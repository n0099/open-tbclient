package com.baidu.tieba.write.write;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.permissionhelper.app.ActivityCompat;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddLinkActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.BaseWriteConfig;
import com.baidu.tbadk.core.atomData.BubbleChooseActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.LocalChannelTopicListActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.QuestionTagChooseActivityConfig;
import com.baidu.tbadk.core.atomData.RelevanceItemSearchActivityConfig;
import com.baidu.tbadk.core.atomData.SelectForumConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.WorkPublishOpenHelper;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVoteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumTagInfo;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.WriteTipBubbleController;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.message.EvaluateRelevanceItemSelectedMessage;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.SelectImageHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NormalItemCell;
import com.baidu.tbadk.core.view.SaveDraftDialogView;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.HeadItem;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.WriteVoteData;
import com.baidu.tbadk.data.SelectForumData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.mutiprocess.event.GoodsEvent;
import com.baidu.tbadk.switchs.AsyncGetClipboardSwitch;
import com.baidu.tbadk.switchs.RepostToDynamicDefaultSwitch;
import com.baidu.tbadk.util.InsertGalleryAsyncTask;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextEvaluateItemInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsPublishFineGoodsDialogView;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.EBusinessProtocolView;
import com.baidu.tieba.write.WritePrefixItemLayout;
import com.baidu.tieba.write.data.QuestionTagListData;
import com.baidu.tieba.write.view.AssociatedItemContainer;
import com.baidu.tieba.write.view.ForumSelectedView;
import com.baidu.tieba.write.view.ForumTabSelectedView;
import com.baidu.tieba.write.view.LocalChannelTopicSelectView;
import com.baidu.tieba.write.view.WriteEvaluationHeaderView;
import com.baidu.tieba.write.view.xrichtext.RichTextEditor;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import com.repackage.a35;
import com.repackage.ak8;
import com.repackage.b19;
import com.repackage.c9;
import com.repackage.cf5;
import com.repackage.cp4;
import com.repackage.d19;
import com.repackage.d35;
import com.repackage.ds4;
import com.repackage.f35;
import com.repackage.fk8;
import com.repackage.g19;
import com.repackage.g35;
import com.repackage.gf5;
import com.repackage.gy4;
import com.repackage.h25;
import com.repackage.ha6;
import com.repackage.ie5;
import com.repackage.je5;
import com.repackage.jf5;
import com.repackage.jg;
import com.repackage.jz8;
import com.repackage.k25;
import com.repackage.kg;
import com.repackage.kw4;
import com.repackage.l09;
import com.repackage.l28;
import com.repackage.ms4;
import com.repackage.n19;
import com.repackage.nk8;
import com.repackage.o16;
import com.repackage.og;
import com.repackage.oi;
import com.repackage.p75;
import com.repackage.pi;
import com.repackage.q19;
import com.repackage.qi;
import com.repackage.rg;
import com.repackage.ru4;
import com.repackage.s19;
import com.repackage.s25;
import com.repackage.t25;
import com.repackage.t45;
import com.repackage.tg;
import com.repackage.u25;
import com.repackage.um8;
import com.repackage.ur4;
import com.repackage.ur8;
import com.repackage.v45;
import com.repackage.vt6;
import com.repackage.w09;
import com.repackage.wm8;
import com.repackage.y09;
import com.repackage.ym8;
import com.repackage.zm;
import com.repackage.zw4;
import com.repackage.zz8;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class WriteActivity extends AbsBaseWriteActivity<WriteActivity> implements VoiceManager.j, fk8.g, ActivityCompat.OnRequestPermissionsResultCallback {
    public static /* synthetic */ Interceptable $ic;
    public static int z2;
    public transient /* synthetic */ FieldHolder $fh;
    public q19 A0;
    public o16 A1;
    public VoiceData.VoiceModel B0;
    public WriteTipBubbleController B1;
    public boolean C0;
    public w09 C1;
    public boolean D0;
    public String D1;
    public boolean E0;
    public String E1;
    public HeadImageView F0;
    public String F1;
    public View G0;
    public LocalChannelTopicSelectView G1;
    public FeedBackTopListView H0;
    public ForumSelectedView H1;
    public View I0;
    public SelectForumData I1;
    public View J0;
    public WriteEvaluationHeaderView J1;
    public RichTextEditor K0;
    public TextView K1;
    public View L0;
    public View L1;
    public String M0;
    public ds4 M1;
    public TextView N0;
    public SaveDraftDialogView N1;
    public TextView O0;
    public s19 O1;
    public NormalItemCell P0;
    public RelativeLayout P1;
    public NormalItemCell Q0;
    public SerializableItemInfo Q1;
    public LinearLayout R0;
    public boolean R1;
    public PlayVoiceBntNew S0;
    public boolean S1;
    public ImageView T0;
    public int T1;
    public View U0;
    public boolean U1;
    public ImageView V0;
    public boolean V1;
    public ImageView W0;
    public String W1;
    public boolean X0;
    public Serializable X1;
    public String Y0;
    public boolean Y1;
    public boolean Z0;
    public AssociatedItemContainer Z1;
    public String a1;
    public final y09.d a2;
    public wm8 b1;
    public y09 b2;
    public VoiceManager c1;
    public LinearLayout c2;
    public d19 d1;
    public ImageView d2;
    public boolean e1;
    public TextView e2;
    public boolean f1;
    public List<vt6> f2;
    public String g1;
    public EBusinessProtocolView g2;
    public boolean h1;
    public boolean h2;
    public String i1;
    public boolean i2;
    public ForumTagInfo j1;
    public View j2;
    public File k1;
    public final HttpMessageListener k2;
    public TbImageView l1;
    public CustomMessageListener l2;
    public View m1;
    public final CustomMessageListener m2;
    public Dialog n1;
    public WriteTipBubbleController.b n2;
    public LinearLayout o1;
    public ListView o2;
    public boolean p1;
    public WriteImageGridView p2;
    public long q1;
    public g35 q2;
    public boolean r1;
    public CustomMessageListener r2;
    public boolean s1;
    public CustomMessageListener s2;
    public String t1;
    public CustomMessageListener t2;
    public int u1;
    public p75 u2;
    public boolean v1;
    public boolean v2;
    public boolean w1;
    public int w2;
    public boolean x1;
    public final nk8.f x2;
    public String y1;
    public final Runnable y2;
    public boolean z1;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public a(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            WriteActivity writeActivity;
            EditorTools editorTools;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (editorTools = (writeActivity = this.a).e0) == null || editorTools.a == null) {
                return;
            }
            if (writeActivity.C1 == null) {
                WriteActivity writeActivity2 = this.a;
                writeActivity2.C1 = new w09(writeActivity2.getPageContext());
            }
            this.a.C1.b(this.a.e0.a.s(2));
        }
    }

    /* loaded from: classes4.dex */
    public class a0 implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public a0(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() == 1) {
                    view2.requestFocus();
                    this.a.e0.A(new h25(5, -1, null));
                    this.a.L.requestFocus();
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteVoteData a;
        public final /* synthetic */ WriteActivity b;

        public b(WriteActivity writeActivity, WriteVoteData writeVoteData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity, writeVoteData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = writeActivity;
            this.a = writeVoteData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.i6(this.a);
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_WRITE_VOTE_VIEW_SHOW).param("obj_source", 3));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b0 extends jg<zm> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ WriteActivity b;

        public b0(WriteActivity writeActivity, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = writeActivity;
            this.a = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jg
        public void onLoaded(zm zmVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, zmVar, str, i) == null) {
                super.onLoaded((b0) zmVar, str, i);
                if (zmVar == null || zmVar.p() == null || zmVar.o() == null) {
                    return;
                }
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), zmVar.p(), zmVar.p().getNinePatchChunk(), zmVar.o(), null);
                if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
                    ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                }
                this.b.J0.setBackgroundDrawable(ninePatchDrawable);
                if (this.a) {
                    nk8.c(this.b.getPageContext(), this.b.W1(), true, this.b.x2);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001353, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ WriteActivity b;

        public c(WriteActivity writeActivity, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = writeActivity;
            this.a = z;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null) {
                return;
            }
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f091d5d) {
                this.b.Q4();
                if (this.a) {
                    this.b.d6();
                }
                this.b.setResult(100);
                this.b.finish();
            } else if (id == R.id.obfuscated_res_0x7f091d5e) {
                this.b.y6();
                if (this.a) {
                    this.b.d6();
                }
                this.b.setResult(100);
                this.b.finish();
            }
            this.b.M1.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class c0 implements nk8.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public c0(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // com.repackage.nk8.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.M0 = null;
                this.a.A6(false);
                this.a.e0.A(new h25(2, 12, null));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public d(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.f1) {
                    this.a.I4();
                    this.a.U2();
                    this.a.N1();
                } else if (this.a.h1) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.a.getPageContext().getPageActivity(), "", qi.Q(TbConfig.QUESTION_THREAD_RULE, "refer=3"), true, true, true)));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d0 implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public d0(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) && this.a.b2 != null && (this.a.b2.getItem(i) instanceof cp4)) {
                cp4 cp4Var = (cp4) this.a.b2.getItem(i);
                int i2 = cp4Var.b;
                if (i2 == 1) {
                    if (cp4Var.o == 1) {
                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{cp4Var.g});
                        return;
                    }
                    UrlManager urlManager = UrlManager.getInstance();
                    TbPageContext<WriteActivity> pageContext = this.a.getPageContext();
                    urlManager.dealOneLink(pageContext, new String[]{"https://tieba.baidu.com/mo/q/checkurl?url=" + pi.getUrlEncode(cp4Var.g)});
                } else if (i2 == 2) {
                    if (!TextUtils.isEmpty(cp4Var.j)) {
                        if (cp4Var.j.startsWith("tiebaclient://")) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, cp4Var.j));
                            return;
                        }
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(cp4Var.j));
                        intent.addFlags(268468224);
                        if (UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                            this.a.startActivity(intent);
                        } else if (TextUtils.isEmpty(cp4Var.k)) {
                        } else {
                            UrlManager urlManager2 = UrlManager.getInstance();
                            TbPageContext<WriteActivity> pageContext2 = this.a.getPageContext();
                            urlManager2.dealOneLink(pageContext2, new String[]{"https://tieba.baidu.com/mo/q/checkurl?url=" + pi.getUrlEncode(cp4Var.k)});
                        }
                    } else if (TextUtils.isEmpty(cp4Var.k)) {
                    } else {
                        UrlManager urlManager3 = UrlManager.getInstance();
                        TbPageContext<WriteActivity> pageContext3 = this.a.getPageContext();
                        urlManager3.dealOneLink(pageContext3, new String[]{"https://tieba.baidu.com/mo/q/checkurl?url=" + pi.getUrlEncode(cp4Var.k)});
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public e(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.W4();
                this.a.H6();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public e0(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.V1) {
                this.a.s0.callback(false, ym8.c, ym8.d, ym8.e, ym8.f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public f(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int height = this.a.N0.getHeight();
                EditText editText = this.a.H;
                editText.setPadding(editText.getPaddingLeft(), this.a.H.getPaddingTop(), this.a.H.getPaddingRight(), this.a.H.getPaddingBottom() + height);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public f0(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                qi.x(this.a.getActivity(), this.a.getCurrentFocus());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public g(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int height = this.a.O0.getHeight();
                SpanGroupEditText spanGroupEditText = this.a.L;
                spanGroupEditText.setPadding(spanGroupEditText.getPaddingLeft(), this.a.L.getPaddingTop(), this.a.L.getPaddingRight(), this.a.L.getPaddingBottom() + height);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g0(WriteActivity writeActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                WriteActivity writeActivity = this.a;
                if (writeActivity.r == null || !writeActivity.v1) {
                    return;
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_COMMODITY_ENTRANCE_SHOW).param("obj_locate", 1).param("fid", this.a.r.getForumId()).param("fname", this.a.r.getForumName()));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public h(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectForumConfig(this.a)));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h0 extends BdAsyncTask<Void, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public h0(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                FileHelper.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + this.a.a1));
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public i(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!this.a.N4()) {
                    if (this.a.j1 == null) {
                        if (!TextUtils.isEmpty(this.a.i1)) {
                            this.a.c6();
                            return;
                        } else {
                            this.a.R4();
                            return;
                        }
                    }
                    return;
                }
                BdTopToast bdTopToast = new BdTopToast(this.a, 3000);
                bdTopToast.h(false);
                bdTopToast.g(this.a.getString(R.string.obfuscated_res_0x7f0f03c2));
                bdTopToast.i((ViewGroup) this.a.C);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i0 extends InsertGalleryAsyncTask.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public i0(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // com.baidu.tbadk.util.InsertGalleryAsyncTask.a
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
            }
        }

        @Override // com.baidu.tbadk.util.InsertGalleryAsyncTask.a
        public void b(String str) {
            WriteImagesInfo writeImagesInfo;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && new File(str).exists() && (writeImagesInfo = this.a.u) != null) {
                writeImagesInfo.clear();
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(str);
                imageFileInfo.isFromMoreForum = true;
                this.a.u.addChooseFile(imageFileInfo);
                this.a.u.setMaxImagesAllowed(1);
                this.a.q4(imageFileInfo);
                this.a.F6(true);
                this.a.H6();
                this.a.C6();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements n19 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public j(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // com.repackage.n19
        public void a(@NonNull QuestionTagListData.QuestionTag questionTag) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, questionTag) == null) {
                WriteData writeData = this.a.r;
                if (writeData != null) {
                    writeData.setQuestionTagId(questionTag.id);
                    this.a.r.setQuestionTagManualCreated(true);
                }
                if (this.a.Q0 != null) {
                    this.a.Q0.setSubTitle(questionTag.tagName);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public j0(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.k1 == null) {
                return;
            }
            WriteActivity writeActivity = this.a;
            writeActivity.P4(writeActivity.k1.getAbsolutePath());
        }
    }

    /* loaded from: classes4.dex */
    public class k implements y09.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public k(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // com.repackage.y09.d
        public void a(List<cp4> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                this.a.O6(list);
            }
        }

        @Override // com.repackage.y09.d
        public void b(int i) {
            SpanGroupEditText spanGroupEditText;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || (spanGroupEditText = this.a.L) == null) {
                return;
            }
            spanGroupEditText.g(i);
        }
    }

    /* loaded from: classes4.dex */
    public class k0 implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public k0(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) && this.a.p1) {
                qi.x(this.a.getPageContext().getPageActivity(), this.a.getCurrentFocus());
                this.a.q1 = System.currentTimeMillis();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements AssociatedItemContainer.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public l(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // com.baidu.tieba.write.view.AssociatedItemContainer.b
        public void a(ItemData itemData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, itemData) == null) {
                this.a.r.removeItemData(itemData);
                if (ListUtils.isEmpty(this.a.r.getItemDatas())) {
                    this.a.N1();
                    this.a.Z1.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        /* loaded from: classes4.dex */
        public class a extends cf5<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(l0 l0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {l0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.cf5
            public String doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? UtilHelper.getClipBoardContent() : (String) invokeV.objValue;
            }
        }

        /* loaded from: classes4.dex */
        public class b implements je5<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l0 a;

            public b(l0 l0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {l0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = l0Var;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.je5
            /* renamed from: a */
            public void onReturnDataInUI(String str) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && !pi.isEmpty(str) && UrlManager.getInstance().isUrlValid(str)) {
                    if (this.a.a.B1 == null) {
                        WriteActivity writeActivity = this.a.a;
                        writeActivity.B1 = new WriteTipBubbleController(writeActivity.getPageContext(), this.a.a.n2);
                    }
                    View s = this.a.a.e0.a.s(31);
                    WriteTipBubbleController writeTipBubbleController = this.a.a.B1;
                    writeTipBubbleController.d(s, this.a.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f062d) + "\n" + str, str, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL);
                }
            }
        }

        public l0(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            EditorTools editorTools;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (editorTools = this.a.e0) == null || editorTools.a == null) {
                return;
            }
            if (AsyncGetClipboardSwitch.isOn() && TbadkCoreApplication.getInst().isMIUIRom()) {
                gf5.b(new a(this), new b(this));
                return;
            }
            String clipBoardContent = UtilHelper.getClipBoardContent();
            if (pi.isEmpty(clipBoardContent) || !UrlManager.getInstance().isUrlValid(clipBoardContent)) {
                return;
            }
            if (this.a.B1 == null) {
                WriteActivity writeActivity = this.a;
                writeActivity.B1 = new WriteTipBubbleController(writeActivity.getPageContext(), this.a.n2);
            }
            View s = this.a.e0.a.s(31);
            WriteTipBubbleController writeTipBubbleController = this.a.B1;
            writeTipBubbleController.d(s, this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f062d) + "\n" + clipBoardContent, clipBoardContent, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL);
        }
    }

    /* loaded from: classes4.dex */
    public class m implements AssociatedItemContainer.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public m(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // com.baidu.tieba.write.view.AssociatedItemContainer.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                if (this.a.p2.getVisibility() == 0) {
                    this.a.F4(true);
                } else {
                    this.a.F4(false);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ur4 a;
        public final /* synthetic */ WriteActivity b;

        public m0(WriteActivity writeActivity, ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity, ur4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = writeActivity;
            this.a = ur4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            ur4 ur4Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (ur4Var = this.a) == null) {
                return;
            }
            ur4Var.dismiss();
            ru4.k().u("commodity_goods_show_first_dialog", true);
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_WRITE_GOODS_NEW_DIALOG_CLICK).param("obj_locate", 2);
            WriteData writeData = this.b.r;
            StatisticItem param2 = param.param("fid", writeData != null ? writeData.getForumId() : "");
            WriteData writeData2 = this.b.r;
            TiebaStatic.log(param2.param("fname", writeData2 != null ? writeData2.getForumName() : ""));
            String uk = TbadkCoreApplication.getCurrentAccountInfo().getUk();
            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + uk + "&max=" + this.b.p5()));
        }
    }

    /* loaded from: classes4.dex */
    public class n implements WriteEvaluationHeaderView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public n(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // com.baidu.tieba.write.view.WriteEvaluationHeaderView.b
        public void a(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048576, this, f) == null) {
                if (!TextUtils.isEmpty(this.a.L.getText()) && this.a.L.getText().length() >= 20 && this.a.L.getText().length() <= 500 && f > 0.0f) {
                    this.a.F.setEnabled(true);
                } else {
                    this.a.F.setEnabled(false);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n0 implements CustomMessageTask.CustomRunnable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public n0(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage == null || customMessage.getData() == null || !customMessage.getData().booleanValue()) {
                    return null;
                }
                BdTopToast bdTopToast = new BdTopToast(this.a);
                bdTopToast.h(false);
                bdTopToast.g(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f14d8));
                bdTopToast.i((ViewGroup) this.a.C);
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class o implements WriteEvaluationHeaderView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public o(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // com.baidu.tieba.write.view.WriteEvaluationHeaderView.c
        public void onClose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.F.setEnabled(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public o0(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.L0.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public p(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                tg.i(this.a.g2, this.a);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                textPaint.setUnderlineText(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public p0(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.s5("5");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        /* loaded from: classes4.dex */
        public class a implements ur4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(q qVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {qVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.repackage.ur4.e
            public void onClick(ur4 ur4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                    ru4 k = ru4.k();
                    k.u(TbadkCoreApplication.getCurrentAccount() + "is_agree_protocol", true);
                    ur4Var.dismiss();
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements ur4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(q qVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {qVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.repackage.ur4.e
            public void onClick(ur4 ur4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                    ru4 k = ru4.k();
                    k.u(TbadkCoreApplication.getCurrentAccount() + "is_agree_protocol", false);
                    ur4Var.dismiss();
                }
            }
        }

        public q(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.h2) {
                    this.a.h2 = false;
                    this.a.d2.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080a11, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
                } else {
                    this.a.h2 = true;
                    this.a.d2.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080821, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
                }
                ru4 k = ru4.k();
                if (k.h(TbadkCoreApplication.getCurrentAccount() + "is_agree_protocol", false) || !this.a.h2) {
                    return;
                }
                ur4 ur4Var = new ur4(this.a);
                ur4Var.setNegativeTextColor(R.color.CAM_X0105);
                ur4Var.setTitle("");
                ur4Var.setMessage(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0f2f));
                ur4Var.setContentViewSize(1);
                ur4Var.setPositiveButton("同意", new a(this));
                ur4Var.setNegativeButton(SapiWebView.HTTPS_SSL_DATE_INVALID_DIALOG_CANCEL, new b(this));
                ur4Var.create(this.a.getPageContext()).show();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public q0(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.L0.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r implements EBusinessProtocolView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public r(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // com.baidu.tieba.view.EBusinessProtocolView.f
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    if (this.a.h2) {
                        return;
                    }
                    this.a.h2 = true;
                    this.a.d2.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080821, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
                } else if (this.a.h2) {
                    this.a.h2 = false;
                    this.a.d2.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080a11, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r0(WriteActivity writeActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            SelectForumData selectForumData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof SelectForumData) || (selectForumData = (SelectForumData) customResponsedMessage.getData()) == null || StringUtils.isNull(selectForumData.forumId) || StringUtils.isNull(selectForumData.forumName)) {
                return;
            }
            this.a.P5(selectForumData);
        }
    }

    /* loaded from: classes4.dex */
    public class s implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public s(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.T6();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class s0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public s0(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class t implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public t(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log(new StatisticItem("c13013").param("fid", this.a.r.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                this.a.U.setVisibility(0);
                this.a.X.setSelected(true);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.a.W, R.drawable.obfuscated_res_0x7f080931, R.color.CAM_X0105, null);
                WriteActivity writeActivity = this.a;
                tg.l(writeActivity.V, view2, 0, qi.d(writeActivity.getPageContext().getPageActivity(), 1.0f));
                this.a.e0.q();
                WriteActivity writeActivity2 = this.a;
                writeActivity2.HidenSoftKeyPad(writeActivity2.f0, writeActivity2.H);
                WriteActivity writeActivity3 = this.a;
                writeActivity3.HidenSoftKeyPad(writeActivity3.f0, writeActivity3.L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class t0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public t0(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.x1) {
                    this.a.x1 = false;
                    ru4 k = ru4.k();
                    k.u("key_write_virtual_image_enable" + TbadkCoreApplication.getCurrentAccount(), this.a.x1);
                    WriteActivity writeActivity = this.a;
                    writeActivity.r.setShowCustomFigure(writeActivity.x1);
                    this.a.X6();
                }
                this.a.j2.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class u implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public u(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log(new StatisticItem("c13013").param("fid", this.a.r.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                this.a.U.setSelected(true);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.a.W, R.drawable.obfuscated_res_0x7f080931, R.color.CAM_X0105, null);
                WriteActivity writeActivity = this.a;
                tg.l(writeActivity.V, view2, 0, qi.d(writeActivity.getPageContext().getPageActivity(), 1.0f));
                this.a.e0.q();
                WriteActivity writeActivity2 = this.a;
                writeActivity2.HidenSoftKeyPad(writeActivity2.f0, writeActivity2.X1());
                WriteActivity writeActivity3 = this.a;
                writeActivity3.HidenSoftKeyPad(writeActivity3.f0, writeActivity3.W1());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class u0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public u0(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.s5("6");
                this.a.j2.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class v extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(WriteActivity writeActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(2001284, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.a.M0)) {
                    this.a.M0 = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    this.a.A6(true);
                } else if (TextUtils.isEmpty(str) || str.equals(this.a.M0)) {
                } else {
                    this.a.M0 = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(this.a.M0);
                    this.a.A6(true);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class v0 implements WriteTipBubbleController.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public v0(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // com.baidu.tbadk.core.dialog.WriteTipBubbleController.b
        public void a(View view2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, view2, str) == null) || this.a.B1 == null) {
                return;
            }
            TiebaStatic.log("c13802");
            this.a.B1.c();
            UtilHelper.clearClipBoard();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddLinkActivityConfig(this.a.getActivity(), 25049, str, false, null)));
        }
    }

    /* loaded from: classes4.dex */
    public class w extends c9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public w(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // com.repackage.c9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.a.hideProgressBar();
                if (obj == null || !(obj instanceof FeedBackModel)) {
                    this.a.H0.setVisibility(8);
                    this.a.I0.setVisibility(8);
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c3c);
                    return;
                }
                FeedBackModel feedBackModel = (FeedBackModel) obj;
                if (feedBackModel.D() != 0) {
                    this.a.H0.setVisibility(8);
                    this.a.I0.setVisibility(8);
                    return;
                }
                this.a.H0.c(feedBackModel.E(), this.a.getPageContext());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class w0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w0(WriteActivity writeActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage instanceof BackgroundSwitchMessage) || ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                return;
            }
            this.a.K4();
        }
    }

    /* loaded from: classes4.dex */
    public class x implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public x(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String string;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                g19.b(1);
                if (this.a.M4()) {
                    return;
                }
                SpanGroupEditText spanGroupEditText = this.a.L;
                if (spanGroupEditText != null && spanGroupEditText.getText() != null && this.a.L.getText().toString() != null) {
                    if (this.a.L.getText().toString().length() > 1000) {
                        WriteActivity writeActivity = this.a;
                        writeActivity.showToast(writeActivity.getResources().getString(R.string.obfuscated_res_0x7f0f0ed0));
                        return;
                    } else if (this.a.L.getText().toString().contains("ܷ") || this.a.L.getText().toString().contains("ܶ")) {
                        WriteActivity writeActivity2 = this.a;
                        writeActivity2.showToast(writeActivity2.getResources().getString(R.string.obfuscated_res_0x7f0f0ecf));
                        return;
                    }
                }
                if (this.a.R1 || (!TextUtils.isEmpty(this.a.H.getText().toString()) && this.a.H.getText().toString().trim().length() >= 5)) {
                    if (!this.a.N4()) {
                        if (this.a.J4()) {
                            if (!this.a.i2 || this.a.h2) {
                                if (this.a.L4()) {
                                    int O4 = this.a.O4();
                                    if (O4 == 1) {
                                        this.a.showToast(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f142d));
                                        return;
                                    } else if (O4 == 2) {
                                        this.a.showToast(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f142e));
                                        return;
                                    }
                                }
                                if (!oi.z()) {
                                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c3c);
                                }
                                if (jf5.a()) {
                                    return;
                                }
                                WriteActivity writeActivity3 = this.a;
                                if (writeActivity3.a.b(writeActivity3.H, writeActivity3.L)) {
                                    WriteActivity writeActivity4 = this.a;
                                    writeActivity4.showToast(writeActivity4.a.e());
                                    return;
                                }
                                WriteActivity writeActivity5 = this.a;
                                writeActivity5.HidenSoftKeyPad(writeActivity5.f0, writeActivity5.X1());
                                WriteActivity writeActivity6 = this.a;
                                writeActivity6.HidenSoftKeyPad(writeActivity6.f0, writeActivity6.W1());
                                this.a.e0.q();
                                if (this.a.C0) {
                                    this.a.w6();
                                    BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                                } else {
                                    this.a.x6();
                                }
                                MercatorModel.d().f();
                                return;
                            }
                            WriteActivity writeActivity7 = this.a;
                            writeActivity7.showToast(writeActivity7.getResources().getString(R.string.obfuscated_res_0x7f0f0f36));
                            return;
                        }
                        this.a.showToast(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1428));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectForumConfig(this.a)));
                    return;
                }
                BdTopToast bdTopToast = new BdTopToast(this.a, 3000);
                bdTopToast.h(false);
                if (this.a.h1) {
                    string = this.a.getString(R.string.obfuscated_res_0x7f0f0f72);
                } else {
                    string = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f141c);
                }
                bdTopToast.g(string);
                bdTopToast.i((ViewGroup) this.a.C);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class x0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x0(WriteActivity writeActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.a.Q4();
                this.a.setResult(100);
                this.a.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class y implements l09.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public y(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // com.repackage.l09.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                qi.O(TbadkCoreApplication.getInst(), String.format(this.a.getString(R.string.obfuscated_res_0x7f0f15d2), 31));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class y0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y0(WriteActivity writeActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage instanceof EvaluateRelevanceItemSelectedMessage)) {
                this.a.P6((EvaluateRelevanceItemSelectedMessage) customResponsedMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class z implements kw4.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public z(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // com.repackage.kw4.a
        public void a(int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                this.a.E6();
                this.a.N1();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class z0 extends p75<GoodsEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity c;

        public z0(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = writeActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.i75
        /* renamed from: a */
        public boolean onEvent(GoodsEvent goodsEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, goodsEvent)) == null) {
                if (goodsEvent == null) {
                    return false;
                }
                this.c.u6(goodsEvent.getGoodsList());
                goodsEvent.setDispost(true);
                this.c.N1();
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(554768059, "Lcom/baidu/tieba/write/write/WriteActivity;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(554768059, "Lcom/baidu/tieba/write/write/WriteActivity;");
        }
    }

    public WriteActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.C0 = false;
        this.D0 = false;
        this.E0 = false;
        this.F0 = null;
        this.H0 = null;
        this.M0 = null;
        this.W0 = null;
        this.X0 = false;
        this.Y0 = null;
        this.Z0 = true;
        this.k1 = null;
        this.l1 = null;
        this.m1 = null;
        this.n1 = null;
        this.o1 = null;
        this.p1 = false;
        this.q1 = -1000L;
        this.r1 = false;
        this.u1 = 0;
        this.v1 = false;
        this.y1 = "";
        this.z1 = false;
        this.U1 = true;
        this.V1 = false;
        this.W1 = null;
        this.Y1 = false;
        this.a2 = new k(this);
        this.h2 = false;
        this.i2 = false;
        this.k2 = new v(this, CmdConfigHttp.REQUEST_BUBBLELIST_CMD);
        this.l2 = new g0(this, 2921494);
        this.m2 = new r0(this, 2921505);
        this.n2 = new v0(this);
        this.r2 = new w0(this, 2001011);
        this.s2 = new x0(this, 2921622);
        this.t2 = new y0(this, 2921516);
        this.u2 = new z0(this);
        this.v2 = false;
        this.w2 = 0;
        this.x2 = new c0(this);
        this.y2 = new e0(this);
    }

    public static Bitmap l5(String str, float f2) {
        InterceptResult invokeLF;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65590, null, str, f2)) == null) {
            int i2 = (int) f2;
            Bitmap bitmap2 = null;
            if (!pi.isEmpty(str) && i2 > 0) {
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(str, options);
                    int i3 = options.outWidth;
                    int i4 = options.outHeight;
                    bitmap = BitmapHelper.resizeBitmapAbsolute(str, (Math.max(i3, i4) * i2) / Math.min(i3, i4));
                    try {
                        Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(bitmap, i2);
                        if (bitmap != null && bitmap != resizedBitmap && !bitmap.isRecycled()) {
                            bitmap.recycle();
                        }
                        System.gc();
                        return resizedBitmap;
                    } catch (Exception unused) {
                        if (bitmap != null && bitmap != null && !bitmap.isRecycled()) {
                            bitmap.recycle();
                        }
                        System.gc();
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        bitmap2 = bitmap;
                        if (bitmap2 != null && bitmap2 != null && !bitmap2.isRecycled()) {
                            bitmap2.recycle();
                        }
                        System.gc();
                        throw th;
                    }
                } catch (Exception unused2) {
                    bitmap = null;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            return null;
        }
        return (Bitmap) invokeLF.objValue;
    }

    public final void A4() {
        CustomResponsedMessage runTask;
        s25 s25Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            boolean booleanValue = X5().booleanValue();
            if (this.C0 || !booleanValue || !um8.a() || !ak8.a(this.r.getForumName(), Boolean.TRUE) || (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, getActivity()), s25.class)) == null || (s25Var = (s25) runTask.getData()) == null) {
                return;
            }
            s25Var.l = 3;
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.f)) {
                return;
            }
            this.e0.d(s25Var);
        }
    }

    public final void A5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            AssociatedItemContainer associatedItemContainer = (AssociatedItemContainer) findViewById(R.id.obfuscated_res_0x7f0902c1);
            this.Z1 = associatedItemContainer;
            associatedItemContainer.setOnDeletedListener(new l(this));
            this.Z1.setOnAddedListener(new m(this));
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void A6(boolean z3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z3) == null) || this.h1 || !TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) || W1() == null) {
            return;
        }
        this.J0.setPadding(0, 0, 0, 0);
        this.J0.setBackgroundDrawable(null);
        SkinManager.setBackgroundColor(this.J0, R.color.CAM_X0201);
        if (TextUtils.isEmpty(this.M0) || this.s != null) {
            return;
        }
        kg.h().m(this.M0, 19, new b0(this, z3), getUniqueId());
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public boolean B2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View view2 = this.L0;
            if (view2 != null && view2.getVisibility() == 0) {
                this.L0.setVisibility(8);
                return true;
            }
            Z6();
            v6(false);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void B4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.s == null) {
            if (this.g0 == null) {
                zz8 zz8Var = new zz8(getActivity(), this.l);
                this.g0 = zz8Var;
                zz8Var.m(0);
                this.g0.n(SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1);
                if (this.s1 || this.h1) {
                    this.g0.p(false);
                }
            }
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.f)) {
                this.g0.j();
                this.g0.o(WriteActivityConfig.FROM_FORUM_SHARE);
                Y6();
            }
            if (!ListUtils.isEmpty(this.v)) {
                this.g0.j();
            }
            this.g0.i();
            this.e0.d(this.g0);
        }
    }

    public final void B5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.h1) {
                this.e0.setBarLauncherType(8);
                this.e0.setMoreButtonAtEnd(false);
                B4();
            } else if (a6()) {
                z5();
            } else {
                w4();
                y4();
                A4();
                v4();
                s4();
                o4();
                p4();
                x4();
                r4();
                u4();
                B4();
            }
        }
    }

    public void B6() {
        WriteData writeData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (writeData = this.r) == null) {
            return;
        }
        this.e0.setToolEnabled((!ListUtils.isEmpty(writeData.getItemDatas()) || this.e1 || this.H.hasFocus()) ? false : true, 33);
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void C2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.r == null) {
            return;
        }
        String obj = X1() != null ? X1().getText().toString() : "";
        String trim = W1() != null ? W1().getText().toString().trim() : "";
        String trim2 = obj.trim();
        if (this.r.getType() == 0 || this.r.getType() == 9) {
            PostPrefixData postPrefixData = this.d;
            if (postPrefixData != null && postPrefixData.getPrefixs().size() > 0) {
                if (this.i == ListUtils.getCount(this.d.getPrefixs()) - 1) {
                    if (TextUtils.isEmpty(trim2)) {
                        this.r.setIsNoTitle(true);
                    } else if (this.J.getVisibility() == 0) {
                        this.r.setIsNoTitle(false);
                        N6(true);
                        return;
                    }
                } else if (this.J.getVisibility() == 0 && !TextUtils.isEmpty(trim2)) {
                    this.r.setIsNoTitle(false);
                    N6(true);
                    return;
                }
            } else if (TextUtils.isEmpty(trim2)) {
                this.r.setIsNoTitle(true);
            } else if (this.J.getVisibility() == 0) {
                this.r.setIsNoTitle(false);
                N6(true);
                return;
            }
        }
        if (this.u.getChosedFiles() != null && this.u.size() > 0) {
            N6(true);
        } else if (TextUtils.isEmpty(trim) && this.B0 == null) {
            if (t5()) {
                N6(true);
            } else {
                N6(false);
            }
        } else {
            N6(true);
        }
    }

    public final void C4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && WriteActivityConfig.FROM_FORUM_SHARE.equals(this.f) && !StringUtils.isNull(this.F1)) {
            if (this.mCurrentPermissionJudgePolicy == null) {
                this.mCurrentPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
            this.mCurrentPermissionJudgePolicy.appendRequestPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mCurrentPermissionJudgePolicy.startRequestPermission(this)) {
                return;
            }
            InsertGalleryAsyncTask insertGalleryAsyncTask = new InsertGalleryAsyncTask(this, this.F1, new i0(this));
            insertGalleryAsyncTask.setFrom(1);
            insertGalleryAsyncTask.execute(new String[0]);
        }
    }

    public final void C5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.D.postDelayed(this.y2, 500L);
        }
    }

    public void C6() {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.e0.n(10) == null) {
            return;
        }
        boolean z3 = false;
        if (!this.H.hasFocus() && ((writeImagesInfo = this.u) == null || ListUtils.getCount(writeImagesInfo.getChosedFiles()) < this.u.getMaxImagesAllowed())) {
            z3 = true;
        }
        this.e0.setToolEnabled(z3, 10);
    }

    public final boolean D4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? ListUtils.isEmpty(this.r.getItemDatas()) && this.r.getVoiceModel() == null && this.r.getVideoInfo() == null && this.r.getWriteVoteData() == null && TextUtils.isEmpty(this.L.getText()) && (!this.e1 || this.K0.t()) && (this.u.getChosedFiles() == null || this.u.size() == 0) : invokeV.booleanValue;
    }

    public final void D5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.o2 = (ListView) this.C.findViewById(R.id.obfuscated_res_0x7f09067e);
            y09 y09Var = new y09(getPageContext());
            this.b2 = y09Var;
            y09Var.j(this.a2);
            this.o2.setAdapter((ListAdapter) this.b2);
            this.o2.setOnItemClickListener(new d0(this));
        }
    }

    public void D6() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.r == null) {
            return;
        }
        this.e0.setToolEnabled((t5() || 10 - p5() != 0 || this.e1 || this.H.hasFocus()) ? false : true, 35);
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void E1(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, editable) == null) {
            super.E1(editable);
            if (this.R1) {
                t4(editable);
            } else if (this.h1) {
                o6(editable);
            }
        }
    }

    public final boolean E4(WriteData writeData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, writeData)) == null) ? writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom())) : invokeL.booleanValue;
    }

    public final void E5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.s1) {
            LocalChannelTopicSelectView localChannelTopicSelectView = (LocalChannelTopicSelectView) findViewById(R.id.obfuscated_res_0x7f09264f);
            this.G1 = localChannelTopicSelectView;
            localChannelTopicSelectView.setVisibility(0);
            this.G1.setLocalChannelTopic(this.t1);
        }
    }

    public void E6() {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            y09 y09Var = this.b2;
            if (y09Var != null && y09Var.f() == null && (spanGroupEditText = this.L) != null && spanGroupEditText.getSpanGroupManager() != null) {
                this.b2.i(this.L.getSpanGroupManager().F());
                this.b2.h();
            } else {
                y09 y09Var2 = this.b2;
                if (y09Var2 != null && y09Var2.f() != null) {
                    this.b2.h();
                }
            }
            y09 y09Var3 = this.b2;
            if (y09Var3 != null) {
                if (y09Var3.getCount() == 0) {
                    this.o2.setVisibility(8);
                } else {
                    this.o2.setVisibility(0);
                }
            }
            y09 y09Var4 = this.b2;
            if (y09Var4 != null) {
                O6(y09Var4.d());
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void F1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.F1();
            r5();
            J6();
            O5();
            this.L.requestFocus();
            C4();
            this.u2.setPriority(1);
            registerResponsedEventListener(GoodsEvent.class, this.u2);
            G5();
            if (this.V1) {
                X4(this.r);
                C2();
                C5();
            }
            j6();
            k6();
        }
    }

    public void F4(boolean z3) {
        AssociatedItemContainer associatedItemContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048595, this, z3) == null) || (associatedItemContainer = this.Z1) == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) associatedItemContainer.getLayoutParams();
        if (z3) {
            layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.M_H_X004);
        } else {
            layoutParams.topMargin = 0;
        }
        this.Z1.setLayoutParams(layoutParams);
    }

    public final void F5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            PostPrefixData postPrefixData = this.d;
            if (postPrefixData != null && postPrefixData.getPrefixs().size() > 1) {
                this.X.setVisibility(0);
                this.M.setVisibility(0);
                this.A1.y0(getString(R.string.obfuscated_res_0x7f0f15e5), "write_title_prefix_tip_key", true);
                ArrayList<String> prefixs = this.d.getPrefixs();
                int size = prefixs.size();
                this.i = 0;
                this.X.setOnClickListener(new t(this));
                this.U.setOnClickListener(new u(this));
                int color = SkinManager.getColor(R.color.CAM_X0105);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.W, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, null);
                ms4 d2 = ms4.d(this.U);
                d2.v(R.color.CAM_X0105);
                d2.A(R.string.F_X02);
                d2.f(R.color.CAM_X0201);
                this.N.clear();
                for (int i2 = 0; i2 < size; i2++) {
                    WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                    this.N.add(writePrefixItemLayout);
                    writePrefixItemLayout.setPrefixText(prefixs.get(i2));
                    int i3 = size - 1;
                    if (i2 == i3) {
                        writePrefixItemLayout.setPrefixTextColor(color);
                        writePrefixItemLayout.c(true);
                    } else {
                        writePrefixItemLayout.setPrefixTextColor(color);
                        writePrefixItemLayout.c(false);
                    }
                    if (i2 != i3) {
                        writePrefixItemLayout.setDividerStyle(false);
                    }
                    this.V.a(writePrefixItemLayout);
                }
                this.V.c(0);
                this.U.setText(prefixs.get(0));
                F2(0);
                return;
            }
            this.X.setVisibility(8);
            this.M.setVisibility(8);
        }
    }

    public final void F6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z3) == null) {
            WriteData writeData = this.r;
            String forumId = writeData == null ? "" : writeData.getForumId();
            d19 d19Var = this.d1;
            if (d19Var != null) {
                d19Var.m(this.u, this.f, forumId);
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void G1(Editable editable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, editable) == null) && this.h1) {
            p6(editable);
        }
    }

    public final void G4(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, hotTopicBussinessData) == null) || hotTopicBussinessData == null || (hotTopicBussinessData2 = (HotTopicBussinessData) ListUtils.getItem(this.v, 0)) == null || TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            return;
        }
        SpannableString i2 = ie5.i(ie5.a(hotTopicBussinessData.mTopicName));
        if (i2 != null) {
            this.H.setText(i2);
        }
        this.b0.setText(hotTopicBussinessData.mForumName);
    }

    public final void G5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            u6(this.W1);
        }
    }

    public final void G6(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, editable) == null) {
            if (!TextUtils.isEmpty(editable) && editable.length() >= 20 && editable.length() <= 500 && this.J1.e()) {
                this.F.setEnabled(true);
            } else {
                this.F.setEnabled(false);
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void H1(CharSequence charSequence, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048602, this, charSequence, i2, i3, i4) == null) {
            this.L.f(i2, i3, i4);
        }
    }

    public final void H4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CHANGE_RICH_TEXT_MODE);
            statisticItem.param("obj_type", i2);
            TiebaStatic.log(statisticItem);
            if (i2 == 0) {
                TiebaStatic.log(CommonStatisticKey.KEY_LIMIT_MODE_CHANGE_TOAST);
            }
        }
    }

    public final void H5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.c2 = (LinearLayout) this.C.findViewById(R.id.obfuscated_res_0x7f091a8f);
            this.d2 = (ImageView) this.C.findViewById(R.id.obfuscated_res_0x7f091a94);
            TextView textView = (TextView) this.C.findViewById(R.id.obfuscated_res_0x7f091a91);
            this.e2 = textView;
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0107);
            EBusinessProtocolView eBusinessProtocolView = new EBusinessProtocolView(this, EBusinessProtocolView.WindowType.PROTOCOL);
            this.g2 = eBusinessProtocolView;
            eBusinessProtocolView.o(getResources().getString(R.string.obfuscated_res_0x7f0f0f30));
            this.g2.i("file:///android_asset/protocol.html");
            SpannableString spannableString = new SpannableString(getResources().getString(R.string.obfuscated_res_0x7f0f0f7e));
            spannableString.setSpan(new p(this), 6, 17, 34);
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0302)), 6, 17, 34);
            this.e2.setText(spannableString);
            this.e2.setMovementMethod(LinkMovementMethod.getInstance());
            this.d2.setOnClickListener(new q(this));
            ru4 k2 = ru4.k();
            if (k2.h(TbadkCoreApplication.getCurrentAccount() + "is_agree_protocol", false)) {
                this.h2 = true;
                this.d2.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080821, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
            } else {
                this.h2 = false;
                this.d2.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080a11, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
            }
            this.g2.m(new r(this));
        }
    }

    public void H6() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || this.e0.n(34) == null) {
            return;
        }
        boolean z3 = true;
        boolean z4 = false;
        z3 = (ListUtils.getCount(this.u.getChosedFiles()) > 0 || this.B0 != null || this.e1) ? false : false;
        if (!this.s1 && !this.H.hasFocus()) {
            z4 = z3;
        }
        this.e0.setToolEnabled(z4, 34);
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void I1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            super.I1();
            if (this.Y1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921583));
            }
            if (this.r.getType() == 0) {
                e6(this.u1);
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public boolean I2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (super.I2()) {
                WriteData writeData = this.r;
                String forumId = writeData == null ? "" : writeData.getForumId();
                d19 d19Var = this.d1;
                if (d19Var != null) {
                    d19Var.m(this.u, this.f, forumId);
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void I4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            if (D4()) {
                if (this.e1) {
                    n6();
                    H4(1);
                } else {
                    q6();
                    H4(2);
                }
                this.e1 = !this.e1;
                F6(true);
                k6();
                return;
            }
            BdTopToast bdTopToast = new BdTopToast(this);
            bdTopToast.h(false);
            bdTopToast.g(getResources().getString(R.string.obfuscated_res_0x7f0f0529));
            bdTopToast.i((ViewGroup) this.C);
            H4(0);
        }
    }

    public final void I5() {
        WriteData writeData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || this.G == null || (writeData = this.r) == null || writeData.getProZone() != 1) {
            return;
        }
        this.G.setText(R.string.obfuscated_res_0x7f0f15f4);
    }

    public void I6() {
        WriteData writeData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || (writeData = this.r) == null) {
            return;
        }
        this.e0.setToolEnabled((!ListUtils.isEmpty(writeData.getItemDatas()) || this.e1 || this.H.hasFocus()) ? false : true, 32);
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void J1(@NonNull NewVcodeActivityConfig newVcodeActivityConfig) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048611, this, newVcodeActivityConfig) == null) && this.E0) {
            newVcodeActivityConfig.setHideFeedBackButton();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void J2(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, postWriteCallBackData) == null) {
            if (WriteActivityConfig.FROM_ADD_PHOTO_LIVE_IN_MISSON.equals(this.f)) {
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUCCES_IN_MISSON);
            }
            super.J2(postWriteCallBackData);
        }
    }

    public final boolean J4() {
        InterceptResult invokeV;
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.v1 || (spanGroupEditText = this.L) == null || spanGroupEditText.getSpanGroupManager() == null || this.L.getSpanGroupManager().z() <= 0 : invokeV.booleanValue;
    }

    public final void J5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.G.getLayoutParams();
            this.w2 = layoutParams.rightMargin;
            layoutParams.rightMargin = 0;
            this.G.setLayoutParams(layoutParams);
            ImageView imageView = (ImageView) this.D.getCenterImgBox();
            this.W0 = imageView;
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080922, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL));
            int f2 = qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            int f3 = qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds47);
            this.W0.setPadding(f2, f2, f2, f2);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.W0.getLayoutParams();
            int i2 = f3 + f2 + f2;
            layoutParams2.width = i2;
            layoutParams2.height = i2;
            this.W0.setLayoutParams(layoutParams2);
            this.W0.setOnClickListener(new s(this));
            this.W0.setVisibility(0);
        }
    }

    public final void J6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921500, new n0(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void K1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            super.K1();
            b7();
            this.v2 = true;
        }
    }

    public final void K4() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048617, this) == null) || (editorTools = this.e0) == null) {
            return;
        }
        editorTools.post(new l0(this));
    }

    public final void K5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            this.N0 = (TextView) findViewById(R.id.obfuscated_res_0x7f091af2);
            this.O0 = (TextView) findViewById(R.id.obfuscated_res_0x7f091aec);
            this.N0.setVisibility(0);
            this.O0.setVisibility(0);
            this.N0.setText(getString(R.string.obfuscated_res_0x7f0f08f6, new Object[]{0, 31}));
            this.O0.setText(getString(R.string.obfuscated_res_0x7f0f08f6, new Object[]{0, 500}));
            this.N0.post(new f(this));
            this.O0.post(new g(this));
        }
    }

    public final void K6() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048619, this) == null) || (editorTools = this.e0) == null) {
            return;
        }
        editorTools.A(new h25(57, 15, null));
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void L1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, bundle) == null) {
            super.L1(bundle);
            if (bundle != null) {
                this.s1 = bundle.getBoolean(WriteActivityConfig.KEY_POST_LOCAL_CHANNEL_DYNAMIC);
                this.t1 = bundle.getString(WriteActivityConfig.KEY_LOCAL_CHANNEL_TOPIC);
            } else if (getIntent() != null) {
                Intent intent = getIntent();
                this.s1 = intent.getBooleanExtra(WriteActivityConfig.KEY_POST_LOCAL_CHANNEL_DYNAMIC, false);
                this.t1 = intent.getStringExtra(WriteActivityConfig.KEY_LOCAL_CHANNEL_TOPIC);
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void L2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            String string = getPageContext().getString(R.string.obfuscated_res_0x7f0f110b);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.f)) {
                string = getPageContext().getString(R.string.obfuscated_res_0x7f0f1125);
            }
            TextView addTextButton = this.D.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, string);
            this.F = addTextButton;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) addTextButton.getLayoutParams();
            layoutParams.rightMargin = qi.f(getPageContext().getPageActivity(), R.dimen.tbds2);
            this.F.setLayoutParams(layoutParams);
            this.F.setOnFocusChangeListener(this.x0);
        }
    }

    public final boolean L4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            FrsTabInfoData frsTabInfoData = this.x;
            if (frsTabInfoData != null && !ListUtils.isEmpty(frsTabInfoData.tabList)) {
                for (FrsTabItemData frsTabItemData : this.x.tabList) {
                    if (frsTabItemData != null && frsTabItemData.tabType == 3) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void L5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            NormalItemCell normalItemCell = (NormalItemCell) findViewById(R.id.obfuscated_res_0x7f091aed);
            this.P0 = normalItemCell;
            normalItemCell.setVisibility(0);
            NormalItemCell.a aVar = new NormalItemCell.a();
            aVar.a = R.color.CAM_X0206;
            aVar.c = R.drawable.icon_pure_ba16;
            aVar.b = 1;
            aVar.f = getString(R.string.obfuscated_res_0x7f0f03c3);
            aVar.e = getString(R.string.obfuscated_res_0x7f0f03c1);
            this.P0.setConfig(aVar);
            this.P0.setOnClickListener(new h(this));
            if (!"2".equals(this.l) || TextUtils.isEmpty(this.r.getForumName())) {
                return;
            }
            this.P0.setSubTitle(this.r.getForumName());
            this.P0.setOnClickListener(null);
            this.P0.a();
        }
    }

    public void L6() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048624, this) == null) || (editorTools = this.e0) == null) {
            return;
        }
        editorTools.A(new h25(65, 15, null));
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public boolean M1(WriteData writeData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, writeData)) == null) ? E4(writeData) || WriteActivityConfig.FROM_FORUM_SHARE.equals(this.f) : invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public boolean M2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? (this.R1 || this.h1) ? false : true : invokeV.booleanValue;
    }

    public final boolean M4() {
        InterceptResult invokeV;
        EditText editText;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            if (!this.h1 || (editText = this.H) == null || this.L == null || editText.getText() == null || this.L.getText() == null) {
                return false;
            }
            if (this.H.getText().toString().length() > 31 || this.L.getText().toString().length() > 500) {
                BdTopToast bdTopToast = new BdTopToast(this, 3000);
                bdTopToast.h(false);
                bdTopToast.g(getString(R.string.obfuscated_res_0x7f0f0f6e));
                bdTopToast.i((ViewGroup) this.C);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void M5() {
        ForumTagInfo forumTagInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            NormalItemCell normalItemCell = (NormalItemCell) findViewById(R.id.obfuscated_res_0x7f091af1);
            this.Q0 = normalItemCell;
            normalItemCell.setVisibility(0);
            NormalItemCell.a aVar = new NormalItemCell.a();
            aVar.b = 1;
            aVar.f = getString(R.string.obfuscated_res_0x7f0f03cf);
            aVar.e = getString(R.string.obfuscated_res_0x7f0f03ce);
            this.Q0.setConfig(aVar);
            this.Q0.setOnClickListener(new i(this));
            if ("2".equals(this.l) && (forumTagInfo = this.j1) != null && forumTagInfo.isValid()) {
                this.r.setQuestionTagId(this.j1.id);
                this.r.setQuestionTagManualCreated(false);
                this.Q0.setSubTitle(this.j1.name);
                this.Q0.setOnClickListener(null);
                this.Q0.a();
            }
        }
    }

    public final void M6(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, bool) == null) {
            WriteData writeData = this.r;
            if (getPageContext().getString(R.string.obfuscated_res_0x7f0f060a).equals(writeData != null ? writeData.getForumName() : null)) {
                this.C0 = true;
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void N1() {
        g35 g35Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            super.N1();
            EditorTools editorTools = this.e0;
            if (editorTools != null) {
                boolean z3 = true;
                editorTools.setDeskLauncherEnabled(!this.m);
                this.e0.setToolEnabled(!this.H.hasFocus(), 2);
                this.e0.setToolEnabled(!this.H.hasFocus(), 30);
                this.e0.setToolEnabled(false, 34);
                if (this.s1 || this.H.hasFocus()) {
                    this.e0.setToolEnabled(false, 31);
                }
                s25 n2 = this.e0.n(5);
                if (n2 != null) {
                    n2.d(true);
                }
                zz8 zz8Var = this.g0;
                if (zz8Var != null && !this.s1 && !this.h1) {
                    zz8Var.p(true);
                }
                C6();
                H6();
                D6();
                B6();
                I6();
                if (this.R1 && (g35Var = this.q2) != null && !g35Var.c()) {
                    this.e0.setToolEnabled(false, 31);
                } else {
                    this.e0.setToolEnabled((this.e1 || this.H.hasFocus()) ? false : true, 31);
                }
                this.e0.setToolEnabled((this.e1 || this.H.hasFocus()) ? false : false, 6);
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public boolean N2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? super.N2() && !this.C0 : invokeV.booleanValue;
    }

    public final boolean N4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? "2".equals(this.l) && this.I1 == null && TextUtils.isEmpty(this.r.getForumName()) : invokeV.booleanValue;
    }

    public final void N5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048633, this) == null) && this.h1) {
            K5();
            L5();
            M5();
        }
    }

    public void N6(boolean z3) {
        SpanGroupEditText spanGroupEditText;
        WriteEvaluationHeaderView writeEvaluationHeaderView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048634, this, z3) == null) {
            if (z3 && this.R1 && ((spanGroupEditText = this.L) == null || TextUtils.isEmpty(spanGroupEditText.getText()) || this.L.getText().length() < 20 || this.L.getText().length() > 500 || (writeEvaluationHeaderView = this.J1) == null || !writeEvaluationHeaderView.e())) {
                return;
            }
            this.F.setEnabled(z3);
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public boolean O1(PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, postWriteCallBackData)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public boolean O2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? !this.h1 : invokeV.booleanValue;
    }

    public final int O4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            y09 y09Var = this.b2;
            boolean z3 = y09Var == null || y09Var.e();
            ForumTabSelectedView forumTabSelectedView = this.c0;
            boolean z4 = (forumTabSelectedView == null || forumTabSelectedView.getSelectedTabItemData() == null || this.c0.getSelectedTabItemData().tabType != 3) ? false : true;
            if (z3 && z4) {
                return 1;
            }
            return (z3 || z4) ? 0 : 2;
        }
        return invokeV.intValue;
    }

    public final void O5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048638, this) == null) && this.k1 != null && this.r.getType() == 0 && this.r.getType() == 9 && this.r.getType() == 11) {
            h5(getActivity());
            View inflate = getPageContext().getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d074b, (ViewGroup) null);
            this.m1 = inflate;
            inflate.setOnClickListener(new j0(this));
            this.l1 = (TbImageView) this.m1.findViewById(R.id.obfuscated_res_0x7f091b21);
            this.o1 = (LinearLayout) this.m1.findViewById(R.id.obfuscated_res_0x7f091b20);
            if (ru4.k().q("write_rec_pic_path", "").equalsIgnoreCase(this.k1.getAbsolutePath())) {
                return;
            }
            ru4.k().y("write_rec_pic_path", this.k1.getAbsolutePath());
            Bitmap l5 = l5(this.k1.getAbsolutePath(), getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070252));
            if (l5 != null) {
                this.l1.setImageBitmap(l5);
                this.l1.setDrawBorder(true);
                this.l1.setBorderWidth(2);
                this.l1.setBorderColor(SkinManager.getColor(R.color.common_color_10264));
                Dialog dialog = new Dialog(getActivity(), R.style.obfuscated_res_0x7f1003a3);
                this.n1 = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.n1.setOnDismissListener(new k0(this));
                this.n1.setContentView(this.m1);
                this.n1.show();
                Window window = this.n1.getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                window.setGravity(83);
                attributes.x = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701f9);
                attributes.y = (z2 / 18) + getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07023b);
                attributes.width = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070257);
                attributes.height = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070291);
                window.setAttributes(attributes);
            }
        }
    }

    public final void O6(List<cp4> list) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048639, this, list) == null) || list == null) {
            return;
        }
        boolean z3 = false;
        Iterator<cp4> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().b == 2) {
                z3 = true;
                break;
            }
        }
        if (z3 || (linearLayout = this.c2) == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void P1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
            super.P1();
            this.e0.setMoreVipIcon(a6());
            this.e0.setShouldShowMorePopTip(!this.s1);
            B5();
        }
    }

    public final void P4(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048641, this, str) == null) || pi.isEmpty(str) || this.n1 == null) {
            return;
        }
        m5(str);
        this.n1.dismiss();
    }

    public final void P5(SelectForumData selectForumData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048642, this, selectForumData) == null) || selectForumData == null) {
            return;
        }
        this.I1 = selectForumData;
        WriteData writeData = this.r;
        if (writeData != null) {
            writeData.setForumId(selectForumData.forumId);
            this.r.setForumName(this.I1.forumName);
            SpanGroupEditText spanGroupEditText = this.L;
            if (spanGroupEditText != null) {
                spanGroupEditText.setForumId(og.g(this.I1.forumId, 0L));
            }
        }
        NormalItemCell normalItemCell = this.P0;
        if (normalItemCell != null) {
            this.j1 = selectForumData.forumTagInfo;
            this.i1 = selectForumData.firstCategory;
            normalItemCell.setSubTitle(this.I1.forumName);
            r6();
            return;
        }
        ForumSelectedView forumSelectedView = this.H1;
        if (forumSelectedView != null) {
            forumSelectedView.setSelectedForum(this.I1.forumName);
        }
        this.x = null;
        if (!ListUtils.isEmpty(this.I1.tabInfoList)) {
            FrsTabInfoData frsTabInfoData = new FrsTabInfoData();
            this.x = frsTabInfoData;
            frsTabInfoData.selectedTabId = -1;
            SelectForumData selectForumData2 = this.I1;
            List<FrsTabItemData> list = selectForumData2.tabInfoList;
            frsTabInfoData.tabList = list;
            if (selectForumData2.isForumBusinessAccount && list != null) {
                FrsTabItemData frsTabItemData = new FrsTabItemData();
                frsTabItemData.tabId = 505;
                frsTabItemData.name = "官方";
                this.x.tabList.add(0, frsTabItemData);
            }
            this.x.isForumBusinessAccount = this.I1.isForumBusinessAccount;
        }
        this.c0.setData(this.x);
        WriteData writeData2 = this.r;
        if (writeData2 != null) {
            writeData2.setFrsTabInfoData(this.x);
        }
        if (this.c0.getVisibility() == 0) {
            this.L1.setVisibility(0);
        }
        this.d = null;
        PostPrefixData postPrefixData = this.I1.postPrefix;
        if (postPrefixData != null && !ListUtils.isEmpty(postPrefixData.getPrefixs())) {
            PostPrefixData postPrefixData2 = this.I1.postPrefix;
            this.d = postPrefixData2;
            postPrefixData2.getPrefixs().add(getPageContext().getString(R.string.obfuscated_res_0x7f0f15d1));
        }
        F5();
    }

    public final void P6(EvaluateRelevanceItemSelectedMessage evaluateRelevanceItemSelectedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, evaluateRelevanceItemSelectedMessage) == null) {
            WriteEvaluationHeaderView writeEvaluationHeaderView = this.J1;
            if (writeEvaluationHeaderView != null) {
                writeEvaluationHeaderView.setVisibility(0);
                TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo = new TbRichTextEvaluateItemInfo();
                tbRichTextEvaluateItemInfo.setItemID(evaluateRelevanceItemSelectedMessage.item_id);
                tbRichTextEvaluateItemInfo.setTags(evaluateRelevanceItemSelectedMessage.tags);
                tbRichTextEvaluateItemInfo.setScore(evaluateRelevanceItemSelectedMessage.score);
                tbRichTextEvaluateItemInfo.setStar(evaluateRelevanceItemSelectedMessage.star);
                tbRichTextEvaluateItemInfo.setIconUrl(evaluateRelevanceItemSelectedMessage.icon_url);
                tbRichTextEvaluateItemInfo.setIconSize(evaluateRelevanceItemSelectedMessage.icon_size);
                tbRichTextEvaluateItemInfo.setTitle(evaluateRelevanceItemSelectedMessage.item_name);
                this.r.setItemInfo(tbRichTextEvaluateItemInfo);
                this.J1.setItemInfo(tbRichTextEvaluateItemInfo);
                return;
            }
            ItemData itemData = new ItemData();
            itemData.itemId = og.g(evaluateRelevanceItemSelectedMessage.item_id, 0L);
            itemData.mTags = evaluateRelevanceItemSelectedMessage.tags;
            itemData.mScore = evaluateRelevanceItemSelectedMessage.score;
            itemData.mStar = evaluateRelevanceItemSelectedMessage.star;
            itemData.mIconUrl = evaluateRelevanceItemSelectedMessage.icon_url;
            itemData.mIconSize = evaluateRelevanceItemSelectedMessage.icon_size;
            itemData.mTitle = evaluateRelevanceItemSelectedMessage.item_name;
            n4(itemData);
        }
    }

    public final void Q4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048644, this) == null) {
            if (this.r.getType() != 0 && this.r.getType() != 9 && this.r.getType() != 11) {
                if (this.r.getType() == 1) {
                    fk8.y(this.r.getThreadId(), null);
                }
            } else if (this.U1) {
                if (this.s1) {
                    fk8.v(null);
                } else if (this.h1) {
                    fk8.z(this.r.getForumId(), this.r, true);
                } else if (this.r.isEvaluate()) {
                    fk8.s(this.r.getItem_id(), null);
                } else if (TextUtils.isEmpty(this.r.getTopicId())) {
                    fk8.u(this.r.getForumId(), this.r, true);
                } else {
                    fk8.B(this.r.getTopicId(), null);
                }
            }
            this.v2 = true;
        }
    }

    public final void Q5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048645, this) == null) {
            if ("main_tab".equals(this.f) && !this.V1 && !this.h1) {
                ForumSelectedView forumSelectedView = (ForumSelectedView) findViewById(R.id.obfuscated_res_0x7f092657);
                this.H1 = forumSelectedView;
                forumSelectedView.setVisibility(0);
            } else if (this.h1) {
            } else {
                if (this.f1 || Z5() || b6()) {
                    ForumSelectedView forumSelectedView2 = (ForumSelectedView) findViewById(R.id.obfuscated_res_0x7f092657);
                    this.H1 = forumSelectedView2;
                    forumSelectedView2.setVisibility(0);
                    this.H1.setSelectedForum(this.r.getForumName());
                    this.H1.a();
                    this.H1.setOnClickListener(null);
                }
            }
        }
    }

    public final void Q6() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048646, this) == null) || (editorTools = this.e0) == null) {
            return;
        }
        editorTools.post(new a(this));
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public boolean R2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void R4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048648, this) == null) {
            if (this.A0 == null) {
                this.A0 = new q19();
            }
            this.A0.u(this, this.j1 == null ? this.Q0.getSubTitleContent() : null, this.r.getForumId(), new j(this));
        }
    }

    public final void R5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048649, this) == null) {
            if (this.f1 && this.e1) {
                y5();
            }
            if (this.e1) {
                q6();
            } else {
                n6();
            }
        }
    }

    public final void R6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048650, this) == null) {
            if (this.h0 == null) {
                this.h0 = new b19(getPageContext());
            }
            this.h0.c(this.e0);
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public boolean S1(@NonNull PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048651, this, postWriteCallBackData)) == null) ? !ur8.d(postWriteCallBackData.getErrorCode()) : invokeL.booleanValue;
    }

    public final void S4(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048652, this, intent) == null) || this.u == null) {
            return;
        }
        d5(intent);
        int size = this.u.size() - 1;
        if (size <= -1 || this.u.getChosedFiles() == null || this.u.size() < 1) {
            return;
        }
        sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.u, size)));
    }

    public final void S5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048653, this) == null) {
            this.P1 = (RelativeLayout) this.C.findViewById(R.id.obfuscated_res_0x7f0925c9);
            this.O1 = new s19(getPageContext(), this.P1);
            W6();
        }
    }

    public void S6(boolean z3, boolean z4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048654, this, new Object[]{Boolean.valueOf(z3), Boolean.valueOf(z4)}) == null) {
            if (z3) {
                if (!this.e1) {
                    this.d1.h().setVisibility(0);
                    F4(true);
                }
                A6(false);
            } else {
                this.u.clear();
                this.d1.h().setVisibility(8);
                F4(false);
                u5();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001353, Boolean.FALSE));
            }
            C2();
            N1();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity, com.repackage.hz8.a
    public void T0(int i2) {
        PostPrefixData postPrefixData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048655, this, i2) == null) || (postPrefixData = this.d) == null) {
            return;
        }
        if (i2 == ListUtils.getCount(postPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new StatisticItem("c13014").param("obj_type", 1));
        } else {
            TiebaStatic.log(new StatisticItem("c13014").param("obj_type", 2));
        }
        super.T0(i2);
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void T1(AtListActivityConfig atListActivityConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048656, this, atListActivityConfig) == null) {
            if (this.f1 && this.e1) {
                atListActivityConfig.setSelectedAtList(this.K0.getAtDataInText());
            } else if (W1() instanceof SpanGroupEditText) {
                atListActivityConfig.setSelectedAtList(((SpanGroupEditText) W1()).getAtDataInText());
            }
        }
    }

    public final void T4(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, intent) == null) {
            if (this.e1) {
                c5(intent);
            } else {
                b5(intent);
            }
            C2();
        }
    }

    public final void T5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048658, this) == null) && this.R1) {
            this.J1.setVisibility(0);
            if (this.S1) {
                this.J1.setShowItemInfo(false);
            }
            if (this.Q1 != null) {
                TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo = new TbRichTextEvaluateItemInfo();
                tbRichTextEvaluateItemInfo.setItemID(String.valueOf(this.Q1.id));
                tbRichTextEvaluateItemInfo.setTags(this.Q1.tags);
                tbRichTextEvaluateItemInfo.setScore(this.Q1.averageScore);
                tbRichTextEvaluateItemInfo.setStar(o5(this.Q1.averageScore));
                tbRichTextEvaluateItemInfo.setIconUrl(this.Q1.icon_url);
                tbRichTextEvaluateItemInfo.setIconSize(this.Q1.icon_size);
                tbRichTextEvaluateItemInfo.setTitle(this.Q1.name);
                this.J1.setItemInfo(tbRichTextEvaluateItemInfo);
                this.J1.setStarCount(this.T1);
                this.r.setItemInfo(tbRichTextEvaluateItemInfo);
                this.r.setEvaluationStar(this.T1);
            } else if (this.r.getItemInfo() != null) {
                this.J1.setItemInfo(this.r.getItemInfo());
                this.J1.setStarCount(this.r.getEvaluationStar());
            }
        }
    }

    public final void T6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048659, this) == null) {
            EBusinessProtocolView eBusinessProtocolView = new EBusinessProtocolView(this, EBusinessProtocolView.WindowType.TIP);
            eBusinessProtocolView.o(getResources().getString(R.string.obfuscated_res_0x7f0f140f));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f13fc)).append((CharSequence) "\n");
            spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f13fd)).append((CharSequence) "\n");
            spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f13fe)).append((CharSequence) "\n");
            spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f13ff)).append((CharSequence) "\n");
            spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f1400));
            eBusinessProtocolView.k(spannableStringBuilder);
            tg.i(eBusinessProtocolView, this);
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public int U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) ? R.color.CAM_X0201 : invokeV.intValue;
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void U2() {
        WriteData writeData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048661, this) == null) || (writeData = this.r) == null) {
            return;
        }
        int type = writeData.getType();
        if (type != 0 && type != 9) {
            if (type != 11) {
                this.G.setText(R.string.obfuscated_res_0x7f0f110d);
                this.L.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                this.H.setVisibility(8);
                return;
            }
            this.G.setText(R.string.obfuscated_res_0x7f0f0f33);
            this.H.setVisibility(0);
            this.L.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
            return;
        }
        this.L.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
        if (!this.C0 && !this.p) {
            if (this.s1) {
                this.G.setText(R.string.obfuscated_res_0x7f0f0edd);
            } else if (this.f1) {
                if (this.e1) {
                    this.G.setText(R.string.obfuscated_res_0x7f0f100e);
                } else {
                    this.G.setText(R.string.obfuscated_res_0x7f0f0c4e);
                }
            } else {
                String str = this.l;
                if (str != null && str.equals("1")) {
                    this.G.setText(R.string.obfuscated_res_0x7f0f0ee1);
                } else {
                    String str2 = this.l;
                    if (str2 != null && str2.equals("2")) {
                        if (this.R1) {
                            this.G.setText(R.string.obfuscated_res_0x7f0f0f33);
                        } else if (a6()) {
                            this.G.setText(R.string.obfuscated_res_0x7f0f0ecd);
                        } else if (this.h1) {
                            this.G.setText(R.string.obfuscated_res_0x7f0f0ee2);
                            this.L.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
                        } else {
                            this.G.setText(R.string.obfuscated_res_0x7f0f0ee3);
                        }
                    } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.f)) {
                        this.G.setText(getResources().getString(R.string.obfuscated_res_0x7f0f115d) + this.r.getForumName() + getResources().getString(R.string.obfuscated_res_0x7f0f02d9));
                        this.H.setVisibility(8);
                        String str3 = this.D1 + " " + this.E1;
                        if (!StringUtils.isNull(str3)) {
                            this.L.setText(str3);
                        }
                    } else {
                        this.G.setText("");
                    }
                }
            }
        } else if (this.E0) {
            this.G.setText(R.string.obfuscated_res_0x7f0f060d);
        } else {
            this.G.setText(R.string.obfuscated_res_0x7f0f0609);
        }
        this.H.setVisibility(0);
    }

    public final void U4(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048662, this, editable) == null) {
            if (editable.length() > 500) {
                this.K1.setText((500 - editable.length()) + "/500");
                this.K1.setVisibility(0);
                return;
            }
            this.K1.setVisibility(4);
        }
    }

    public final void U5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048663, this) == null) && this.R1) {
            this.K1 = (TextView) findViewById(R.id.obfuscated_res_0x7f0919fe);
            WriteEvaluationHeaderView writeEvaluationHeaderView = (WriteEvaluationHeaderView) findViewById(R.id.obfuscated_res_0x7f092649);
            this.J1 = writeEvaluationHeaderView;
            writeEvaluationHeaderView.setStarChangeListener(new n(this));
            this.J1.setItemCloseListener(new o(this));
        }
    }

    public final void U6() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048664, this) == null) || ru4.k().h("key_virtual_image_setting_guide_has_show", false)) {
            return;
        }
        ru4.k().u("key_virtual_image_setting_guide_has_show", true);
        ((ViewStub) findViewById(R.id.obfuscated_res_0x7f09259e)).inflate();
        View findViewById = findViewById(R.id.obfuscated_res_0x7f09259d);
        this.L0 = findViewById;
        findViewById.setVisibility(0);
        this.L0.setOnClickListener(new o0(this));
        ms4 d2 = ms4.d(this.L0);
        d2.e(R.string.A_X05);
        d2.f(R.color.CAM_X0611);
        ms4 d3 = ms4.d(this.L0.findViewById(R.id.obfuscated_res_0x7f09259a));
        d3.n(R.string.J_X06);
        d3.f(R.color.CAM_X0201);
        ((GifView) this.L0.findViewById(R.id.obfuscated_res_0x7f092599)).setGifRaw(R.raw.obfuscated_res_0x7f110071);
        ms4 d4 = ms4.d(this.L0.findViewById(R.id.obfuscated_res_0x7f092597));
        d4.n(R.string.J_X07);
        d4.f(R.color.CAM_X0205);
        l28 a2 = l28.a();
        ms4.d((TextView) this.L0.findViewById(R.id.obfuscated_res_0x7f09259b)).v(R.color.CAM_X0105);
        ms4.d((TextView) this.L0.findViewById(R.id.obfuscated_res_0x7f092598)).v(R.color.CAM_X0105);
        TextView textView = (TextView) this.L0.findViewById(R.id.obfuscated_res_0x7f092595);
        if (a2 != null && a2.b() == 1) {
            textView.setVisibility(8);
        } else {
            ms4 d5 = ms4.d(textView);
            d5.A(R.string.F_X01);
            d5.z(R.dimen.T_X07);
            d5.v(R.color.CAM_X0304);
            d5.n(R.string.J_X07);
            d5.l(R.dimen.L_X02);
            d5.k(R.color.CAM_X0304);
            d5.j(R.string.A_X07);
            textView.setOnClickListener(new p0(this));
        }
        this.L0.postDelayed(new q0(this), 4000L);
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public int V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) ? a6() ? 3 : 5 : invokeV.intValue;
    }

    public final void V4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048666, this) == null) {
            new h0(this).execute(new Void[0]);
        }
    }

    public final void V5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048667, this) == null) {
            t0().onCreate(getPageContext());
        }
    }

    public final void V6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048668, this) == null) {
            if (this.j2 == null) {
                ((ViewStub) findViewById(R.id.obfuscated_res_0x7f092592)).inflate();
                this.j2 = findViewById(R.id.obfuscated_res_0x7f092591);
            }
            this.j2.setOnClickListener(new s0(this));
            this.j2.setVisibility(0);
            ms4 d2 = ms4.d(this.j2);
            d2.e(R.string.A_X05);
            d2.f(R.color.CAM_X0611);
            ms4 d3 = ms4.d(this.j2.findViewById(R.id.obfuscated_res_0x7f092590));
            d3.n(R.string.J_X06);
            d3.f(R.color.CAM_X0201);
            TextView textView = (TextView) this.j2.findViewById(R.id.obfuscated_res_0x7f09258e);
            ms4 d4 = ms4.d(textView);
            d4.A(R.string.F_X01);
            d4.z(R.dimen.T_X07);
            d4.v(R.color.CAM_X0105);
            d4.n(R.string.J_X07);
            d4.l(R.dimen.L_X02);
            d4.k(R.color.CAM_X0105);
            d4.j(R.string.A_X07);
            textView.setOnClickListener(new t0(this));
            TextView textView2 = (TextView) this.j2.findViewById(R.id.obfuscated_res_0x7f09258d);
            ms4 d5 = ms4.d(textView2);
            d5.A(R.string.F_X01);
            d5.z(R.dimen.T_X07);
            d5.v(R.color.CAM_X0304);
            d5.n(R.string.J_X07);
            d5.l(R.dimen.L_X02);
            d5.k(R.color.CAM_X0304);
            d5.j(R.string.A_X07);
            textView2.setOnClickListener(new u0(this));
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public EditText W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) ? this.e1 ? this.K0.getLastFocusEdit() : this.L : (EditText) invokeV.objValue;
    }

    public final void W4() {
        t25 t25Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048670, this) == null) {
            VoiceData.VoiceModel voiceModel = this.B0;
            if (voiceModel != null) {
                zw4.a(zw4.b(voiceModel.voiceId));
            }
            this.B0 = null;
            this.r.setVoiceModel(null);
            this.R0.setVisibility(8);
            this.S0.p();
            this.S0.setVoiceModel(null);
            s25 n2 = this.e0.n(6);
            if (n2 != null && (t25Var = n2.m) != null) {
                t25Var.A(new h25(52, 0, null));
            }
            C2();
        }
    }

    public final void W5(@NonNull ImageFileInfo imageFileInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048671, this, imageFileInfo) == null) {
            this.K0.s(imageFileInfo);
        }
    }

    public final void W6() {
        WriteVoteData writeVoteData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048672, this) == null) {
            Serializable serializable = this.X1;
            if (serializable instanceof WriteVoteData) {
                writeVoteData = (WriteVoteData) serializable;
                this.r.setWriteVoteData(writeVoteData);
            } else if (this.r.getWriteVoteData() == null) {
                return;
            } else {
                writeVoteData = this.r.getWriteVoteData();
            }
            b bVar = new b(this, writeVoteData);
            this.O1.f(bVar);
            this.O1.e(bVar);
            this.O1.g(writeVoteData);
            this.O1.h(true);
            C2();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public EditText X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) ? this.H : (EditText) invokeV.objValue;
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void X2(View view2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048674, this, view2, z3) == null) {
            super.X2(view2, z3);
            if (view2 != this.L && (view2 instanceof SpanGroupEditText)) {
                Object tag = view2.getTag(R.id.obfuscated_res_0x7f09101d);
                if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue() && z3) {
                    this.m = false;
                    N1();
                    qi.M(getActivity(), view2);
                    EditorTools editorTools = this.e0;
                    if (editorTools != null) {
                        editorTools.q();
                    }
                }
            }
            if (this.h1) {
                if (z3 && (view2 == this.H || view2 == this.L)) {
                    getWindow().setSoftInputMode(16);
                } else {
                    getWindow().setSoftInputMode(48);
                }
            }
        }
    }

    public final void X4(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048675, this, writeData) == null) {
            this.r.setContent(writeData.getContent());
            SpannableString t2 = TbFaceManager.i().t(getPageContext().getPageActivity(), this.r.getContent(), this.q0);
            InputFilter[] filters = this.L.getFilters();
            this.L.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50000)});
            W1().setText(t2);
            EditText W1 = W1();
            SpanGroupEditText spanGroupEditText = this.L;
            if (W1 == spanGroupEditText && spanGroupEditText.getSpanGroupManager() != null) {
                this.L.i();
                this.L.getSpanGroupManager().t();
                this.L.c();
                E6();
            }
            this.L.setFilters(filters);
            if (W1().getText() != null) {
                W1().setSelection(W1().getText().length());
            }
        }
    }

    public final Boolean X5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) ? Boolean.valueOf(this.Z0) : (Boolean) invokeV.objValue;
    }

    public final void X6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048677, this) == null) {
            this.b1.I();
            l09.e(this.r);
            b7();
            y6();
            if (PersonPolymericActivityConfig.VIDEO_PERSON_FROM_TOPIC_DETAIL.equals(this.f)) {
                setResult(-1);
            } else {
                setResult(100);
            }
            finish();
        }
    }

    public final void Y4(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048678, this, writeData) == null) {
            if ((this.f1 && this.e1) || a6()) {
                this.r.setRichContentData(writeData.getRichContentData());
                this.K0.r(writeData.getRichContentData());
            }
        }
    }

    public final boolean Y5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) ? (this.C0 || this.p || this.s1 || this.f1 || !this.R1) ? false : true : invokeV.booleanValue;
    }

    public void Y6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048680, this) == null) {
            if (!this.A.H(getPageContext().getPageActivity())) {
                showToast(R.string.obfuscated_res_0x7f0f0a55);
                H2(0, true, null);
                zz8 zz8Var = this.g0;
                if (zz8Var != null) {
                    zz8Var.g();
                }
            } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
                S2();
            } else {
                LocationModel locationModel = this.A;
                if (locationModel == null) {
                    return;
                }
                locationModel.P(false);
                H2(1, true, null);
                this.A.L();
            }
        }
    }

    public final void Z4(WriteData writeData) {
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048681, this, writeData) == null) {
            if (pi.isEmpty(this.r.getTitle())) {
                this.r.setTitle(writeData.getTitle());
            }
            if (!ListUtils.isEmpty(this.v)) {
                HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) ListUtils.getItem(this.v, 0);
                String str = hotTopicBussinessData != null ? hotTopicBussinessData.mTopicName : null;
                if (StringUtils.isNull(str)) {
                    a2 = this.r.getTitle();
                } else {
                    a2 = ie5.a(str);
                }
                SpannableString i2 = ie5.i(a2);
                if (i2 != null) {
                    X1().setText(i2);
                    int length = i2.length() > a2.length() ? a2.length() : i2.length();
                    if (length > X1().getText().length()) {
                        length = X1().getText().length();
                    }
                    X1().setSelection(length);
                    return;
                }
                return;
            }
            SpannableString i3 = ie5.i(this.r.getTitle());
            if (i3 != null) {
                X1().setText(i3);
                int length2 = this.r.getTitle().length() > i3.length() ? i3.length() : this.r.getTitle().length();
                if (length2 > X1().getText().length()) {
                    length2 = X1().getText().length();
                }
                X1().setSelection(length2);
            }
        }
    }

    public final boolean Z5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) ? (this.C0 || this.p || this.s1 || !"2".equals(this.l) || this.e1 || this.R1 || this.h1) ? false : true : invokeV.booleanValue;
    }

    public void Z6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048683, this) == null) {
            a7(false);
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void a2(CharSequence charSequence, int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048684, this, new Object[]{charSequence, Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) || this.s1) {
            return;
        }
        super.a2(charSequence, i2, i3, str);
    }

    public final void a5(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048685, this, writeData) == null) {
            if (writeData.getWriteImagesInfo() != null) {
                this.u = writeData.getWriteImagesInfo();
            }
            this.r.setWriteImagesInfo(this.u);
            this.K0.setWriteImagesInfo(this.u);
            if (this.u.getChosedFiles() != null && this.u.getChosedFiles().size() > 0) {
                I2();
            }
            F6(false);
            S6(true, true);
        }
    }

    public final boolean a6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) ? !this.f1 && this.e1 : invokeV.booleanValue;
    }

    public void a7(boolean z3) {
        wm8 wm8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048687, this, z3) == null) {
            if (!z3 && (wm8Var = this.b1) != null) {
                wm8Var.d();
            }
            FeedBackModel feedBackModel = this.B;
            if (feedBackModel != null) {
                feedBackModel.cancelLoadData();
            }
            LocationModel locationModel = this.A;
            if (locationModel != null) {
                locationModel.cancelLoadData();
            }
        }
    }

    public final void b5(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048688, this, intent) == null) {
            n5(intent, true);
        }
    }

    public final boolean b6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) ? (this.C0 || this.p || this.s1 || !"2".equals(this.l) || !this.e1 || this.R1 || this.h1) ? false : true : invokeV.booleanValue;
    }

    public final synchronized void b7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048690, this) == null) {
            synchronized (this) {
                VoiceManager t02 = t0();
                this.c1 = t02;
                t02.stopPlay();
            }
        }
    }

    public final void c5(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048691, this, intent) == null) || intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            writeImagesInfo.updateQuality();
            LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo.getChosedFiles();
            if (chosedFiles != null) {
                for (ImageFileInfo imageFileInfo : chosedFiles) {
                    this.u.addChooseFile(imageFileInfo);
                    W5(imageFileInfo);
                }
            }
            C6();
            H6();
            if (this.u.getChosedFiles() != null) {
                I2();
            }
        }
        F6(true);
    }

    public final void c6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048692, this) == null) {
            QuestionTagChooseActivityConfig questionTagChooseActivityConfig = new QuestionTagChooseActivityConfig(this);
            questionTagChooseActivityConfig.setCategory(this.i1);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, questionTagChooseActivityConfig));
        }
    }

    public void c7(WriteVoteData writeVoteData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048693, this, writeVoteData) == null) {
            this.r.setWriteVoteData(writeVoteData);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048694, this) == null) {
            if (this.s1) {
                ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 1);
            } else {
                ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void d2(Bundle bundle) {
        WriteData writeData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048695, this, bundle) == null) {
            wm8 k2 = wm8.k();
            this.b1 = k2;
            k2.p(this);
            super.d2(bundle);
            if (bundle != null) {
                this.r.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
                this.r.setFloorNum(bundle.getInt("floor_num", 0));
                String string = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
                this.y1 = string;
                this.r.setTopicId(string);
                this.r.setStatisticFrom(bundle.getInt(WriteActivityConfig.KEY_STATISTIS_FROM, 0));
                this.C0 = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
                this.D0 = bundle.getBoolean(WriteActivityConfig.KEY_SHOW_HOMEPAGE_TEST_BTN, false);
                this.E0 = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
                this.X0 = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
                this.Y0 = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
                this.a1 = bundle.getString(WriteActivityConfig.PHOTO_NAME);
                this.u1 = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
                this.v1 = bundle.getBoolean(WriteActivityConfig.CAN_GOODS);
                this.Y1 = bundle.getBoolean(WriteActivityConfig.NEED_CLOSE_PRE_PAGE);
                this.f1 = bundle.getBoolean(WriteActivityConfig.RICH_MODE_ENABLE, false);
                this.e1 = bundle.getBoolean(WriteActivityConfig.RICH_TEXT_MODE, false);
                this.h1 = bundle.getBoolean(WriteActivityConfig.IS_QUESTION_THREAD, false);
                this.j1 = (ForumTagInfo) bundle.getSerializable(WriteActivityConfig.FORUM_TAG_INFO);
                this.i1 = bundle.getString(WriteActivityConfig.FORUM_FIRST_CATEGORY);
            } else {
                Intent intent = getIntent();
                this.r.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
                this.r.setFloorNum(intent.getIntExtra("floor_num", 0));
                this.r.setProZone(intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
                String stringExtra = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
                this.y1 = stringExtra;
                this.r.setTopicId(stringExtra);
                this.r.setStatisticFrom(intent.getIntExtra(WriteActivityConfig.KEY_STATISTIS_FROM, 0));
                this.C0 = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
                this.D0 = intent.getBooleanExtra(WriteActivityConfig.KEY_SHOW_HOMEPAGE_TEST_BTN, false);
                this.E0 = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
                this.X0 = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
                this.Y0 = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
                this.F1 = intent.getStringExtra("more_forum_img");
                this.D1 = intent.getStringExtra("more_forum_title");
                this.E1 = intent.getStringExtra("more_forum_url");
                this.u1 = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
                this.r.setFrsTabInfoData(this.x);
                this.v1 = intent.getBooleanExtra(WriteActivityConfig.CAN_GOODS, false);
                this.Y1 = intent.getBooleanExtra(WriteActivityConfig.NEED_CLOSE_PRE_PAGE, false);
                boolean booleanExtra = getIntent().getBooleanExtra(IntentConfig.IS_EVALUATE, false);
                this.R1 = booleanExtra;
                this.r.setIsEvaluate(booleanExtra);
                this.S1 = getIntent().getBooleanExtra(IntentConfig.IS_ITEM_DETAIL, false);
                this.T1 = getIntent().getIntExtra(WriteActivityConfig.STAR_COUNT, 0);
                Serializable serializableExtra = getIntent().getSerializableExtra(WriteActivityConfig.ITEM_INFO);
                if (serializableExtra instanceof SerializableItemInfo) {
                    SerializableItemInfo serializableItemInfo = (SerializableItemInfo) serializableExtra;
                    this.Q1 = serializableItemInfo;
                    this.r.setItem_id(String.valueOf(serializableItemInfo.id));
                }
                this.U1 = getIntent().getBooleanExtra(BaseWriteConfig.IS_SAVE_DRAFTE, true);
                this.V1 = getIntent().getBooleanExtra(WriteActivityConfig.IS_FROM_ERROR_DIALOG, false);
                this.W1 = getIntent().getStringExtra(WriteActivityConfig.GOODS_LIST);
                this.X1 = intent.getSerializableExtra(IntentConfig.WRITE_VOTE_DATA);
                this.Z0 = intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true);
                this.e = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
                this.f1 = intent.getBooleanExtra(WriteActivityConfig.RICH_MODE_ENABLE, false);
                this.e1 = intent.getBooleanExtra(WriteActivityConfig.RICH_TEXT_MODE, false);
                this.g1 = intent.getStringExtra(WriteActivityConfig.IS_ARTICLE);
                this.h1 = intent.getBooleanExtra(WriteActivityConfig.IS_QUESTION_THREAD, false);
                this.j1 = (ForumTagInfo) intent.getSerializableExtra(WriteActivityConfig.FORUM_TAG_INFO);
                this.i1 = intent.getStringExtra(WriteActivityConfig.FORUM_FIRST_CATEGORY);
                if (this.V1 && (writeData = ym8.e) != null) {
                    this.r = writeData;
                    writeData.setType(9);
                    WriteData writeData2 = this.r;
                    writeData2.setContent(writeData2.getContentString());
                    this.u = this.r.getWriteImagesInfo();
                    this.x = this.r.getFrsTabInfoData();
                    if (this.r.getItemInfo() != null) {
                        this.Q1 = null;
                    }
                    this.B0 = this.r.getVoiceModel();
                }
                if (UbsABTestHelper.isMainTabShowA()) {
                    this.r.setIsArticle(this.g1);
                }
            }
            PostPrefixData postPrefixData = this.d;
            if (postPrefixData != null && postPrefixData.getPrefixs().size() > 0) {
                this.d.getPrefixs().add(getPageContext().getString(R.string.obfuscated_res_0x7f0f15d1));
            }
            this.r.setLocalChannelDynamic(this.s1);
            this.r.setLocalChannelTopic(this.t1);
            this.r.setQuestionThread(this.h1);
            if (this.r.getType() == 9) {
                this.r.setEntranceType(1);
            } else if (this.r.getType() == 10) {
                this.r.setEntranceType(2);
                this.r.setType(9);
            } else if (this.r.getType() == 0) {
                this.r.setEntranceType(3);
            }
            this.r.setIsUserFeedback(this.C0);
            this.M0 = TbadkCoreApplication.getInst().getDefaultBubble();
            try {
                this.k1 = j5();
            } catch (Throwable unused) {
                this.k1 = null;
            }
            this.b1.B(this.s1);
        }
    }

    public final void d5(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048696, this, intent) == null) {
            this.a1 = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
            String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.a1;
            if (!TextUtils.isEmpty(str)) {
                try {
                    int readPictureDegree = BitmapHelper.readPictureDegree(str);
                    if (readPictureDegree != 0) {
                        Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, qi.d(getPageContext().getPageActivity(), qi.k(getPageContext().getPageActivity())), qi.d(getPageContext().getPageActivity(), qi.i(getPageContext().getPageActivity())));
                        Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                        if (loadResizedBitmap != rotateBitmapBydegree) {
                            loadResizedBitmap.recycle();
                        }
                        FileHelper.saveBitmapByRelativelyPath(TbConfig.LOCAL_CAMERA_DIR, this.a1, rotateBitmapBydegree, 100);
                        rotateBitmapBydegree.recycle();
                    }
                } catch (Exception unused) {
                }
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(str);
                imageFileInfo.setTempFile(true);
                this.u.addChooseFile(imageFileInfo);
                this.u.updateQuality();
                q4(imageFileInfo);
                C6();
                H6();
                I2();
            }
            F6(true);
        }
    }

    public final void d6() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048697, this) == null) || WriteActivityConfig.isAsyncWriting() || this.r == null) {
            return;
        }
        WriteActivityConfig.newInstance(getActivity()).setType(9).setForumId(TextUtils.isEmpty(this.r.getForumId()) ? "0" : this.r.getForumId()).setForumName(this.r.getForumName()).setEnableAudio(this.Z0).setAudioMsg(this.e).setCanGoods(this.v1).setPrefixData(this.d).setPrivateThread(this.j).setForumDir(this.r.getFirstDir(), this.r.getSecondDir()).setProfessionZone(this.r.getProZone()).setFrsTabInfo(this.x).setCallFrom(this.l).setStatisticFrom(this.r.getStatisticFrom()).setIsEvaluate(true).setScoreItemInfo(this.Q1).setStarCount(this.T1).setFrom(this.f).send();
        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED);
        statisticItem.param("obj_locate", "main_tab".equals(this.f) ? 8 : 2);
        statisticItem.param("obj_type", 6);
        TiebaStatic.log(statisticItem);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i e1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048698, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    @SuppressLint({"ResourceAsColor"})
    public void e2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048699, this) == null) {
            super.e2();
            int l2 = ru4.k().l("write_associate_item_hint_tip_key", 0);
            if (ru4.k().l("commodity_tip_show_controller", 0) != 0 || !this.v1) {
                R6();
                K4();
            } else if (l2 > 0) {
                Q6();
            } else {
                ru4.k().w("commodity_tip_show_controller", ru4.k().l("commodity_tip_show_controller", 0) + 1);
            }
        }
    }

    public final void e5(@Nullable Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048700, this, intent) == null) || intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(BaseWriteConfig.KEY_WRITE_IMAGES_INFO_STRING);
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            writeImagesInfo.updateQuality();
            LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo.getChosedFiles();
            if (chosedFiles != null) {
                for (ImageFileInfo imageFileInfo : chosedFiles) {
                    this.u.addChooseFile(imageFileInfo);
                    W5(imageFileInfo);
                }
            }
            C6();
            H6();
            if (this.u.getChosedFiles() != null) {
                I2();
            }
        }
        F6(true);
    }

    public final void e6(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048701, this, i2) == null) || this.u == null || this.r == null) {
            return;
        }
        AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(getPageContext().getPageActivity(), this.u.toJsonString(), true, true);
        albumFloatActivityConfig.getIntent().putExtra("forum_id", this.r.getForumId());
        albumFloatActivityConfig.getIntent().putExtra("forum_name", this.r.getForumName());
        albumFloatActivityConfig.getIntent().putExtra("from", this.f);
        albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
        albumFloatActivityConfig.setAlbumThread(i2);
        albumFloatActivityConfig.setCanSelectVideo(false);
        albumFloatActivityConfig.setCanSelectOnlyVideo(false);
        albumFloatActivityConfig.setCanEditImage(false);
        albumFloatActivityConfig.setFromWrite(3);
        albumFloatActivityConfig.setCallFrom(this.l);
        albumFloatActivityConfig.setStatisticFrom(this.r.getStatisticFrom());
        albumFloatActivityConfig.setProfessionZone(this.r.getProZone());
        albumFloatActivityConfig.setFrsTabInfo(this.x);
        AntiData antiData = new AntiData();
        antiData.voice_message = this.e;
        antiData.setIfVoice(this.Z0);
        albumFloatActivityConfig.setExtraData(antiData, this.d, this.r.getFirstDir(), this.r.getSecondDir());
        sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048702, this) == null) {
            if (this.s1) {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 1);
            } else {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void f2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048703, this) == null) {
            super.f2();
            this.e0.setActionListener(60, this.y0);
            this.e0.setActionListener(56, this.y0);
            this.e0.setActionListener(58, this.y0);
            this.e0.setActionListener(66, this.y0);
            this.e0.setActionListener(22, this.y0);
            this.e0.setActionListener(21, this.y0);
            this.e0.setActionListener(59, this.y0);
            this.e0.setActionListener(61, this.y0);
            this.e0.setActionListener(69, this.y0);
        }
    }

    public final String f5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048704, this)) == null) {
            ArrayList arrayList = new ArrayList();
            WriteEvaluationHeaderView writeEvaluationHeaderView = this.J1;
            arrayList.add(new HeadItem("", String.valueOf(writeEvaluationHeaderView != null ? writeEvaluationHeaderView.getStarCount() : 0), 2));
            return new Gson().toJson(arrayList);
        }
        return (String) invokeV.objValue;
    }

    public final void f6() {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048705, this) == null) || (writeImagesInfo = this.u) == null || this.r == null) {
            return;
        }
        JSONObject json = writeImagesInfo.toJson();
        String str = null;
        if (json != null) {
            try {
                json.put("maxImagesAllowed", 9 - this.u.size());
                json.put("chosedFiles", (Object) null);
                str = json.toString();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(getPageContext().getPageActivity(), str, true, true);
        albumFloatActivityConfig.getIntent().putExtra("forum_id", this.r.getForumId());
        albumFloatActivityConfig.getIntent().putExtra("forum_name", this.r.getForumName());
        albumFloatActivityConfig.getIntent().putExtra("from", this.f);
        albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
        albumFloatActivityConfig.setAlbumThread(0);
        albumFloatActivityConfig.setCanSelectVideo(false);
        albumFloatActivityConfig.setCanSelectOnlyVideo(false);
        albumFloatActivityConfig.setCanEditImage(false);
        albumFloatActivityConfig.setFromWrite(3);
        albumFloatActivityConfig.setCallFrom(this.l);
        albumFloatActivityConfig.setStatisticFrom(this.r.getStatisticFrom());
        albumFloatActivityConfig.setProfessionZone(this.r.getProZone());
        albumFloatActivityConfig.setFrsTabInfo(this.x);
        AntiData antiData = new AntiData();
        antiData.voice_message = this.e;
        antiData.setIfVoice(this.Z0);
        albumFloatActivityConfig.setExtraData(antiData, this.d, this.r.getFirstDir(), this.r.getSecondDir());
        sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void g2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048706, this) == null) {
            super.g2();
            this.L1 = findViewById(R.id.obfuscated_res_0x7f090bea);
            if (this.c0.getVisibility() == 0) {
                this.L1.setVisibility(0);
            }
        }
    }

    public final String g5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048707, this)) == null) ? (W1() == null || W1().getText() == null) ? "" : W1().getText().toString() : (String) invokeV.objValue;
    }

    public final void g6(int i2) {
        WriteImagesInfo writeImagesInfo;
        int size;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048708, this, i2) == null) || (writeImagesInfo = this.u) == null || writeImagesInfo.getChosedFiles() == null || (size = this.u.getChosedFiles().size()) < 1 || i2 < 0 || i2 >= size) {
            return;
        }
        sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.u, i2)));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.repackage.u95
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048709, this)) == null) ? "a094" : (String) invokeV.objValue;
    }

    @Override // com.repackage.fk8.g
    public void h0(WriteData writeData) {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048710, this, writeData) == null) || WriteActivityConfig.FROM_FORUM_SHARE.equals(this.f) || this.i2 || this.V1) {
            return;
        }
        if (!this.f1 || (writeImagesInfo = this.u) == null || writeImagesInfo.size() <= 0) {
            if (writeData != null) {
                if (this.r != null && writeData.isEvaluate() == this.r.isEvaluate()) {
                    boolean z3 = (this.r.getWriteImagesInfo() == null || ListUtils.isEmpty(this.r.getWriteImagesInfo().getChosedFiles())) ? false : true;
                    boolean z4 = !pi.isEmpty(X1().getText().toString());
                    boolean z5 = !pi.isEmpty(W1().getText().toString());
                    boolean z6 = !pi.isEmpty(writeData.getTitle());
                    boolean z7 = !pi.isEmpty(writeData.getContent());
                    boolean z8 = !ListUtils.isEmpty(writeData.getRichContentData());
                    this.r.setHaveDraft(true);
                    if (!this.f1 && !a6()) {
                        this.e1 = false;
                        n6();
                    } else {
                        boolean isRichTextEditorMode = writeData.isRichTextEditorMode();
                        this.e1 = isRichTextEditorMode;
                        this.r.setRichTextEditorMode(isRichTextEditorMode);
                        if (this.e1) {
                            q6();
                        } else {
                            n6();
                        }
                    }
                    if (!z3) {
                        a5(writeData);
                    }
                    if (!z4 || this.r1 || ((this.C0 || this.p) && z6)) {
                        Z4(writeData);
                    }
                    if (z7 && (!z5 || this.C0 || this.p)) {
                        X4(writeData);
                    }
                    if (z8) {
                        Y4(writeData);
                    }
                    WriteData writeData2 = this.r;
                    if (writeData2 != null && !writeData2.getHaveDraft()) {
                        j2();
                    }
                    if (writeData.getItemInfo() != null) {
                        this.r.setItemInfo(writeData.getItemInfo());
                        this.r.setEvaluationStar(writeData.getEvaluationStar());
                        this.Q1 = null;
                        T5();
                    }
                    if (writeData.getWriteVoteData() != null) {
                        this.r.setWriteVoteData(writeData.getWriteVoteData());
                        W6();
                    }
                    if (writeData.getVoiceModel() != null) {
                        z4(writeData.getVoiceModel());
                        H6();
                    }
                    if (!ListUtils.isEmpty(writeData.getItemDatas()) && !t5() && 10 - p5() == 0) {
                        Iterator<ItemData> it = writeData.getItemDatas().iterator();
                        while (it.hasNext()) {
                            n4(it.next());
                        }
                    }
                    N1();
                    C2();
                    U2();
                    this.e0.q();
                    return;
                }
                return;
            }
            j2();
        }
    }

    public final void h5(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048711, this, context) == null) {
            z2 = qi.i(context);
        }
    }

    public final void h6(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048712, this, i2) == null) || this.u == null || this.r == null) {
            return;
        }
        AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(getPageContext().getPageActivity(), this.u.toJsonString(), true, true);
        albumFloatActivityConfig.getIntent().putExtra("forum_id", this.r.getForumId());
        albumFloatActivityConfig.getIntent().putExtra("forum_name", this.r.getForumName());
        albumFloatActivityConfig.getIntent().putExtra("from", this.f);
        albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
        albumFloatActivityConfig.setAlbumThread(i2);
        albumFloatActivityConfig.setCanSelectVideo(true);
        albumFloatActivityConfig.setCanSelectOnlyVideo(true);
        albumFloatActivityConfig.setCanEditImage(false);
        albumFloatActivityConfig.setFromWrite(3);
        albumFloatActivityConfig.setCallFrom(this.l);
        albumFloatActivityConfig.setStatisticFrom(this.r.getStatisticFrom());
        albumFloatActivityConfig.setProfessionZone(this.r.getProZone());
        albumFloatActivityConfig.setFrsTabInfo(this.x);
        if (this.H.getText().toString() != null) {
            albumFloatActivityConfig.setVideoTitle(this.H.getText().toString());
        } else {
            albumFloatActivityConfig.setVideoTitle(this.y);
        }
        albumFloatActivityConfig.setBarName(this.r.getForumName());
        albumFloatActivityConfig.setBarID(this.r.getForumId());
        if (this.I1 == null && this.r.getForumName() != null) {
            albumFloatActivityConfig.setCanChangeBarName(false);
        } else {
            albumFloatActivityConfig.setCanChangeBarName(true);
        }
        albumFloatActivityConfig.setVideoAbstract(this.L.getText().toString());
        AntiData antiData = new AntiData();
        antiData.voice_message = this.e;
        antiData.setIfVoice(this.Z0);
        albumFloatActivityConfig.setExtraData(antiData, this.d, this.r.getFirstDir(), this.r.getSecondDir());
        sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void i2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048713, this) == null) {
            super.i2();
            registerListener(this.k2);
            registerListener(this.l2);
            registerListener(this.m2);
            registerListener(this.r2);
            registerListener(this.s2);
            registerListener(this.t2);
        }
    }

    public final void i5(@Nullable Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048714, this, intent) == null) || intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            writeImagesInfo.updateQuality();
            if (writeImagesInfo.getChosedFiles() != null && writeImagesInfo.getChosedFiles().size() > 0) {
                ImageFileInfo imageFileInfo = writeImagesInfo.getChosedFiles().get(0);
                int originalImgIndex = writeImagesInfo.getOriginalImgIndex();
                this.u.getChosedFiles().remove(originalImgIndex);
                this.u.getChosedFiles().add(originalImgIndex, imageFileInfo);
                this.K0.o(imageFileInfo, writeImagesInfo.getOriginalImgViewIndex());
                C6();
                H6();
                if (this.u.getChosedFiles() != null) {
                    I2();
                }
            }
        }
        F6(true);
    }

    public final void i6(WriteVoteData writeVoteData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048715, this, writeVoteData) == null) {
            WriteVoteActivityConfig writeVoteActivityConfig = new WriteVoteActivityConfig(getPageContext().getPageActivity(), 25048);
            if (writeVoteData != null) {
                writeVoteActivityConfig.setExtraData(writeVoteData);
            }
            sendMessage(new CustomMessage(2002001, writeVoteActivityConfig));
        }
    }

    public final File j5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048716, this)) == null) {
            Cursor query = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "_data", "bucket_display_name", "datetaken", "mime_type"}, null, null, "datetaken DESC");
            if (query == null) {
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            String name = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getName();
            String name2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getName();
            try {
                query.moveToFirst();
                while (!query.isAfterLast()) {
                    String string = query.getString(query.getColumnIndex("_data"));
                    File file = new File(string);
                    if ((currentTimeMillis - file.lastModified()) / 60000 > 1) {
                        break;
                    }
                    String upperCase = string.toUpperCase();
                    if (!upperCase.contains("DCIM/CAMERA") && !upperCase.contains("DCIM/100ANDRO") && !upperCase.contains("DCIM/100MEDIA") && !upperCase.contains("SCREENSHOTS") && !upperCase.contains(name.toUpperCase()) && !upperCase.contains(name2.toUpperCase())) {
                        query.moveToNext();
                    }
                    return file;
                }
                return null;
            } finally {
                query.close();
            }
        }
        return (File) invokeV.objValue;
    }

    public final void j6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048717, this) == null) {
            if (this.r.getType() != 0 && this.r.getType() != 9 && this.r.getType() != 11) {
                if (this.r.getType() == 1) {
                    fk8.o(this.r.getThreadId(), this);
                }
            } else if (this.U1) {
                if (this.r.isLocalChannelDynamic()) {
                    fk8.l(this);
                } else if (this.r.isQuestionThread()) {
                    fk8.p(this.r.getForumId(), this);
                } else if (this.r.isEvaluate()) {
                    fk8.j(this.r.getItem_id(), this);
                } else if (TextUtils.isEmpty(this.r.getTopicId())) {
                    fk8.k(this.r.getForumId(), this);
                } else {
                    fk8.r(this.r.getTopicId(), this);
                }
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void k2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048718, this) == null) {
            super.k2();
            if (this.A1 == null) {
                o16 o16Var = new o16(getPageContext(), this.X);
                this.A1 = o16Var;
                o16Var.q0(R.drawable.obfuscated_res_0x7f0802f1);
                this.A1.T(16);
                this.A1.c0(true);
                this.A1.r0(true);
                this.A1.u0(qi.f(getActivity(), R.dimen.obfuscated_res_0x7f070207));
            }
            F5();
        }
    }

    public final void k5(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048719, this, intent) == null) {
            n5(intent, false);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0017, code lost:
        if (r0 != 11) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void k6() {
        WriteData writeData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048720, this) == null) || (writeData = this.r) == null) {
            return;
        }
        int i2 = -1;
        int type = writeData.getType();
        if (type == 0 || type == 9) {
            if (!Y5()) {
                if (Z5()) {
                    i2 = 1;
                } else if (b6()) {
                    i2 = 2;
                } else if (this.h1) {
                    i2 = 5;
                }
                g19.a(i2);
            }
            i2 = 4;
            g19.a(i2);
        }
    }

    public void l6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048721, this) == null) {
            if (!L4()) {
                BdToast b2 = BdToast.b(this, getString(R.string.obfuscated_res_0x7f0f0ed9));
                b2.f(BdToast.ToastIcon.FAILURE);
                b2.h();
            } else if (!this.v1) {
                BdToast b3 = BdToast.b(this, getString(R.string.obfuscated_res_0x7f0f0eda));
                b3.f(BdToast.ToastIcon.FAILURE);
                b3.h();
            } else {
                if (this.r != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_COMMODITY_ENTRANCE_CLICK).param("obj_locate", 2).param("fid", this.r.getForumId()).param("fname", this.r.getForumName()));
                }
                if (!ru4.k().h("commodity_goods_show_first_dialog", false)) {
                    ur4 ur4Var = new ur4(getPageContext().getPageActivity());
                    ur4Var.setContentViewSize(2);
                    ur4Var.setCanceledOnTouchOutside(false);
                    FrsPublishFineGoodsDialogView frsPublishFineGoodsDialogView = new FrsPublishFineGoodsDialogView(getPageContext().getPageActivity());
                    frsPublishFineGoodsDialogView.setConfirmButtonListener(new m0(this, ur4Var));
                    ur4Var.setContentView(frsPublishFineGoodsDialogView);
                    StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_WRITE_GOODS_NEW_DIALOG_SHOW).param("obj_locate", 2);
                    WriteData writeData = this.r;
                    StatisticItem param2 = param.param("fid", writeData != null ? writeData.getForumId() : "");
                    WriteData writeData2 = this.r;
                    TiebaStatic.log(param2.param("fname", writeData2 != null ? writeData2.getForumName() : ""));
                    ur4Var.create(getPageContext()).show();
                    return;
                }
                String uk = TbadkCoreApplication.getCurrentAccountInfo().getUk();
                MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + uk + "&max=" + p5()));
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void m2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048722, this) == null) {
            if (this.R1) {
                this.J.setVisibility(8);
                WriteImageGridView writeImageGridView = this.p2;
                if (writeImageGridView != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) writeImageGridView.getLayoutParams();
                    layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X012);
                    this.p2.setLayoutParams(layoutParams);
                }
                this.G0.setVisibility(8);
            } else {
                this.H.setHint(R.string.obfuscated_res_0x7f0f141a);
                this.J.setVisibility(0);
                WriteImageGridView writeImageGridView2 = this.p2;
                if (writeImageGridView2 != null) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) writeImageGridView2.getLayoutParams();
                    layoutParams2.topMargin = 0;
                    this.p2.setLayoutParams(layoutParams2);
                }
                this.G0.setVisibility(0);
                this.J.requestFocus();
            }
            if (this.s1) {
                this.H.setHint(R.string.obfuscated_res_0x7f0f141b);
            }
            if (this.h1) {
                this.H.setHint(getString(R.string.obfuscated_res_0x7f0f0f71));
                this.H.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
                this.H.setSingleLine(false);
            }
        }
    }

    public final void m5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048723, this, str) == null) {
            if (this.u.getChosedFiles() != null && this.u.getChosedFiles().size() >= this.u.getMaxImagesAllowed()) {
                showToast(String.format(getPageContext().getContext().getString(R.string.obfuscated_res_0x7f0f0aa4), Integer.valueOf(this.u.getMaxImagesAllowed())));
                return;
            }
            this.u.addChooseFileFromCamera(str);
            this.u.updateQuality();
            q4(this.u.getChosedFiles().getLast());
            this.p1 = true;
            C6();
            H6();
            if (this.u.getChosedFiles() != null) {
                I2();
            }
            F6(true);
        }
    }

    public final void m6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048724, this) == null) {
            if (!this.r.canAddItem()) {
                qi.N(getActivity(), R.string.obfuscated_res_0x7f0f15f1);
                return;
            }
            RelevanceItemSearchActivityConfig relevanceItemSearchActivityConfig = new RelevanceItemSearchActivityConfig(getActivity(), 0);
            relevanceItemSearchActivityConfig.setSelectedIds(this.r.getItemDataIds());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, relevanceItemSearchActivityConfig));
        }
    }

    public final void n4(ItemData itemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048725, this, itemData) == null) {
            this.r.addItemData(itemData);
            this.Z1.setVisibility(0);
            this.Z1.a(itemData);
        }
    }

    public final void n5(Intent intent, boolean z3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048726, this, intent, z3) == null) || intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            this.u.parseJson(stringExtra);
            this.u.updateQuality();
            C6();
            H6();
            if (this.u.getChosedFiles() != null) {
                I2();
            }
        }
        F6(true);
    }

    public final void n6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048727, this) == null) {
            this.L.setVisibility(0);
            this.K0.setVisibility(8);
            d19 d19Var = this.d1;
            if (d19Var != null) {
                d19Var.j(false);
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void o2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048728, this) == null) {
            super.o2();
            this.V0 = (ImageView) this.D.getCenterImgBox();
            View centerImgBoxLayout = this.D.getCenterImgBoxLayout();
            this.U0 = centerImgBoxLayout;
            centerImgBoxLayout.setOnClickListener(new d(this));
            if (this.f1) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.G.getLayoutParams();
                layoutParams.rightMargin = 0;
                layoutParams.leftMargin = 0;
                this.G.setLayoutParams(layoutParams);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.V0.getLayoutParams();
                layoutParams2.width = qi.f(this, R.dimen.tbds31);
                layoutParams2.height = qi.f(this, R.dimen.tbds31);
                this.V0.setLayoutParams(layoutParams2);
                this.V0.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08098e, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_DISABLE));
                this.V0.setVisibility(0);
            } else if (this.h1) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.G.getLayoutParams();
                layoutParams3.rightMargin = qi.f(this, R.dimen.M_W_X002);
                layoutParams3.leftMargin = 0;
                this.G.setLayoutParams(layoutParams3);
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.V0.getLayoutParams();
                layoutParams4.width = qi.f(this, R.dimen.tbds42);
                layoutParams4.height = qi.f(this, R.dimen.tbds42);
                layoutParams4.topMargin = qi.f(this, R.dimen.tbds3);
                this.V0.setLayoutParams(layoutParams4);
                this.V0.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809ad, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_DISABLE));
                this.V0.setVisibility(0);
            }
            this.H0 = (FeedBackTopListView) findViewById(R.id.obfuscated_res_0x7f0909a0);
            this.I0 = findViewById(R.id.obfuscated_res_0x7f09099e);
            this.p2 = (WriteImageGridView) findViewById(R.id.obfuscated_res_0x7f09264a);
            this.G0 = findViewById(R.id.obfuscated_res_0x7f0921ed);
            this.d1 = new d19(getPageContext(), this.C);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.f)) {
                this.d1.k(false);
            } else {
                this.d1.l(this.r.getType() == 0 || this.r.getType() == 9 || this.r.getType() == 11);
            }
            this.d1.i(this.h1);
            this.d1.j(this.e1);
            S6(true, false);
            if (this.C0 || this.p) {
                getWindow().setSoftInputMode(18);
            }
            this.R0 = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091290);
            this.S0 = (PlayVoiceBntNew) findViewById(R.id.obfuscated_res_0x7f090447);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f090fe5);
            this.T0 = imageView;
            imageView.setOnClickListener(new e(this));
            z4(this.B0);
            M6(X5());
            V5();
            I5();
            Q5();
            E5();
            U5();
            T5();
            S5();
            H5();
            D5();
            N5();
            A5();
            U6();
        }
    }

    public final void o4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048729, this) == null) {
            this.e0.d(new u25(getActivity(), 7));
        }
    }

    public final int o5(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048730, this, new Object[]{Double.valueOf(d2)})) == null) ? (int) ((d2 + 1.0d) / 2.0d) : invokeCommon.intValue;
    }

    public final void o6(Editable editable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048731, this, editable) == null) || this.O0 == null) {
            return;
        }
        if (!TextUtils.isEmpty(editable)) {
            SpannableString spannableString = new SpannableString(getString(R.string.obfuscated_res_0x7f0f08f6, new Object[]{Integer.valueOf(editable.length()), 500}));
            if (editable.length() > 500) {
                spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301)), 0, String.valueOf(editable.length()).length(), 17);
            }
            this.O0.setText(spannableString);
            return;
        }
        this.O0.setText(getString(R.string.obfuscated_res_0x7f0f08f6, new Object[]{0, 500}));
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    @SuppressLint({"ResourceAsColor"})
    public void onActivityResult(int i2, int i3, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        String str;
        int i4;
        LocalChannelTopicSelectView localChannelTopicSelectView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048732, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1) {
                if (i2 == 25072) {
                    if (!this.h1 || intent == null || this.Q0 == null) {
                        return;
                    }
                    if (intent.getBooleanExtra(QuestionTagChooseActivityConfig.KEY_RESPONSE_CREATE_TAG, false)) {
                        R4();
                        return;
                    }
                    QuestionTagListData.QuestionTag questionTag = (QuestionTagListData.QuestionTag) intent.getParcelableExtra(QuestionTagChooseActivityConfig.KEY_RESPONSE_TAG);
                    if (questionTag == null) {
                        return;
                    }
                    this.r.setQuestionTagId(questionTag.id);
                    this.r.setQuestionTagManualCreated(false);
                    this.Q0.setSubTitle(questionTag.tagName);
                } else if (i2 != 25068) {
                    PostWriteCallBackData postWriteCallBackData2 = null;
                    postWriteCallBackData2 = null;
                    postWriteCallBackData2 = null;
                    if (i2 == 12004) {
                        if (this.H == getCurrentFocus()) {
                            W1().clearFocus();
                            this.H.requestFocus();
                            EditorTools editorTools = this.e0;
                            if (editorTools != null) {
                                editorTools.q();
                            }
                            ShowSoftKeyPadDelay(this.H);
                        } else {
                            W1().requestFocus();
                            EditorTools editorTools2 = this.e0;
                            if (editorTools2 != null) {
                                editorTools2.q();
                            }
                            ShowSoftKeyPadDelay(this.L);
                        }
                        ArrayList parcelableArrayListExtra = intent != null ? intent.getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA) : null;
                        int selectionStart = W1().getSelectionStart();
                        if (selectionStart > 0) {
                            int i5 = selectionStart - 1;
                            if (W1().getText().toString().charAt(i5) == '@') {
                                W1().getEditableText().delete(i5, selectionStart);
                            }
                        }
                        if (this.f1 && this.e1) {
                            this.K0.k(parcelableArrayListExtra);
                        } else if (W1() instanceof SpanGroupEditText) {
                            ((SpanGroupEditText) W1()).e(parcelableArrayListExtra);
                        }
                        if (parcelableArrayListExtra != null && parcelableArrayListExtra.size() > 0) {
                            W1().getText().delete(W1().getSelectionStart(), W1().getSelectionEnd());
                            if (this.f1 && this.e1) {
                                this.K0.g(parcelableArrayListExtra);
                            } else if (W1() instanceof SpanGroupEditText) {
                                ((SpanGroupEditText) W1()).b(parcelableArrayListExtra);
                            }
                        }
                    } else if (i2 == 12006) {
                        if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) {
                            postWriteCallBackData2 = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                        }
                        Q4();
                        J2(postWriteCallBackData2);
                        setResult(-1, intent);
                        finish();
                    } else if (i2 == 12002) {
                        if (intent == null) {
                            return;
                        }
                        if (intent.getBooleanExtra(AlbumActivityConfig.FINISH_SELF, false)) {
                            setResult(-1, intent);
                            finish();
                            return;
                        }
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            S4(intent);
                        } else {
                            T4(intent);
                            rg.a().post(new f0(this));
                        }
                        S6(ListUtils.getCount(this.u.getChosedFiles()) > 0, false);
                        if (this.z1) {
                            A6(true);
                            this.z1 = false;
                        }
                    } else if (i2 == 12012) {
                        if (this.e1) {
                            i5(intent);
                        } else {
                            k5(intent);
                            C2();
                        }
                    } else if (i2 == 13010) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.r.setVideoInfo(videoInfo);
                            this.e0.A(new h25(2, 19, " "));
                            this.e0.A(new h25(28, 20, videoInfo));
                        } else {
                            this.e0.A(new h25(5, -1, null));
                        }
                        C2();
                    } else if (i2 == 23004) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
                    } else if (i2 == 25004) {
                        if (intent == null) {
                            return;
                        }
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (StringUtils.isNull(stringExtra)) {
                            return;
                        }
                        StringBuilder sb = new StringBuilder();
                        if (this.o) {
                            sb.append("#");
                            this.o = false;
                        }
                        sb.append(stringExtra);
                        C1(sb.toString());
                    } else if (i2 != 25005 || intent == null || ListUtils.isEmpty(this.v)) {
                        if (i2 == 25048) {
                            if (intent == null) {
                                return;
                            }
                            Serializable serializableExtra = intent.getSerializableExtra(IntentConfig.WRITE_VOTE_DATA);
                            if (serializableExtra instanceof WriteVoteData) {
                                this.X1 = serializableExtra;
                                W6();
                            }
                        } else if (i2 == 25049 && intent != null) {
                            String str2 = intent.getStringExtra(AddLinkActivityConfig.NEW_LINK_CONTENT) + " ";
                            int selectionStart2 = this.L.getSelectionStart();
                            int selectionEnd = this.L.getSelectionEnd();
                            if (selectionStart2 >= 0) {
                                Editable text = this.L.getText();
                                if (selectionEnd > selectionStart2) {
                                    text.replace(selectionStart2, selectionEnd, str2);
                                } else {
                                    text.insert(selectionStart2, str2);
                                }
                            }
                        } else if (i2 == 25064) {
                            if (jz8.b()) {
                                if (this.u == null || this.r == null) {
                                    return;
                                }
                                if (this.H.getText().toString() != null) {
                                    str = this.H.getText().toString();
                                    i4 = 5;
                                } else {
                                    str = this.y;
                                    i4 = 1;
                                }
                                if (this.I1 == null && this.r.getForumName() != null) {
                                    jz8.f(getPageContext(), str, this.L.getText().toString(), this.r.getForumId(), this.r.getForumName(), 3, Boolean.FALSE, "", "", "");
                                } else {
                                    jz8.f(getPageContext(), str, this.L.getText().toString(), this.r.getForumId(), this.r.getForumName(), i4, Boolean.TRUE, "", "", "");
                                }
                            } else {
                                h6(0);
                            }
                        }
                    } else if (ListUtils.isEmpty(this.v) || intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) >= this.v.size()) {
                        return;
                    } else {
                        HotTopicBussinessData hotTopicBussinessData = this.v.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                        this.w = hotTopicBussinessData;
                        G4(hotTopicBussinessData);
                    }
                } else if (!this.s1 || intent == null || (localChannelTopicSelectView = this.G1) == null || localChannelTopicSelectView.getVisibility() != 0) {
                    return;
                } else {
                    String stringExtra2 = intent.getStringExtra(LocalChannelTopicListActivityConfig.KEY_RESPONSE_TOPIC);
                    this.t1 = stringExtra2;
                    this.G1.setLocalChannelTopic(stringExtra2);
                }
            } else if (i3 == 0) {
                EditorTools editorTools3 = this.e0;
                if (editorTools3 != null && !editorTools3.u()) {
                    this.e0.q();
                }
                if (i2 == 12001) {
                    V4();
                } else if (i2 == 12002) {
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.u.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    if (this.z1) {
                        A6(true);
                        this.z1 = false;
                    }
                } else if (i2 != 12004) {
                    if (i2 != 12006) {
                        if (i2 == 12010) {
                            this.a1 = String.valueOf(System.currentTimeMillis());
                            SelectImageHelper.takePhoto(getPageContext(), this.a1);
                        } else if (i2 == 25004) {
                            if ("from_title".equals(this.g)) {
                                X1().requestFocus();
                            } else if ("from_content".equals(this.g)) {
                                W1().requestFocus();
                            }
                        }
                    } else if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.a.n(postWriteCallBackData.getErrorString());
                        this.a.m(postWriteCallBackData.getSensitiveWords());
                        this.a.h(this.H, this.L);
                    }
                } else if (this.H == getCurrentFocus()) {
                    W1().clearFocus();
                    this.H.requestFocus();
                    EditorTools editorTools4 = this.e0;
                    if (editorTools4 != null) {
                        editorTools4.q();
                    }
                    ShowSoftKeyPadDelay(this.H);
                } else {
                    W1().requestFocus();
                    EditorTools editorTools5 = this.e0;
                    if (editorTools5 != null) {
                        editorTools5.q();
                    }
                    ShowSoftKeyPadDelay(this.L);
                }
            }
            N1();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity, com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048733, this, i2) == null) {
            super.onChangeSkinType(i2);
            getLayoutMode().k(this.o1);
            SkinManager.setBackgroundColor(this.O, R.color.CAM_X0205);
            if (this.l1 != null && (i2 == 1 || i2 == 4)) {
                this.l1.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
            }
            RichTextEditor richTextEditor = this.K0;
            if (richTextEditor != null) {
                richTextEditor.v();
            }
            if (this.D.getBackImageView() != null) {
                this.D.getBackImageView().setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809f1, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            }
            SkinManager.setBackgroundColor(X1(), R.color.CAM_X0205);
            this.T0.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080940, SkinManager.getColor(R.color.CAM_X0107), null));
            this.S0.e();
            if (TextUtils.isEmpty(this.M0)) {
                SkinManager.setBackgroundColor(this.J0, R.color.CAM_X0205);
            }
            y09 y09Var = this.b2;
            if (y09Var != null) {
                y09Var.notifyDataSetChanged();
            }
            this.d1.d.notifyDataSetChanged();
            A6(false);
            LocalChannelTopicSelectView localChannelTopicSelectView = this.G1;
            if (localChannelTopicSelectView != null) {
                localChannelTopicSelectView.b();
            }
            ForumSelectedView forumSelectedView = this.H1;
            if (forumSelectedView != null) {
                forumSelectedView.c();
            }
            WriteEvaluationHeaderView writeEvaluationHeaderView = this.J1;
            if (writeEvaluationHeaderView != null) {
                writeEvaluationHeaderView.f();
            }
            s19 s19Var = this.O1;
            if (s19Var != null) {
                s19Var.d(i2);
            }
            EBusinessProtocolView eBusinessProtocolView = this.g2;
            if (eBusinessProtocolView != null) {
                eBusinessProtocolView.j(i2);
            }
            TextView textView = this.K1;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0301);
            }
            AssociatedItemContainer associatedItemContainer = this.Z1;
            if (associatedItemContainer != null) {
                associatedItemContainer.c();
            }
            View view2 = this.j2;
            if (view2 != null && view2.getVisibility() == 0) {
                V6();
            }
            if (this.h1) {
                TextView textView2 = this.N0;
                if (textView2 != null) {
                    SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0110);
                    p6(this.N0.getEditableText());
                }
                TextView textView3 = this.O0;
                if (textView3 != null) {
                    SkinManager.setViewTextColor(textView3, (int) R.color.CAM_X0110);
                    o6(this.O0.getEditableText());
                }
                NormalItemCell normalItemCell = this.P0;
                if (normalItemCell != null) {
                    normalItemCell.c();
                }
                NormalItemCell normalItemCell2 = this.Q0;
                if (normalItemCell2 != null) {
                    normalItemCell2.c();
                }
                q19 q19Var = this.A0;
                if (q19Var != null) {
                    q19Var.r();
                }
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048734, this) == null) {
            this.D.removeCallbacks(this.y2);
            wm8 wm8Var = this.b1;
            if (wm8Var != null) {
                wm8Var.t();
            }
            v5();
            a7(true);
            if (!this.v2) {
                y6();
            }
            tg.a(this.M1, this);
            nk8.d();
            super.onDestroy();
            t0().onDestory(getPageContext());
            d19 d19Var = this.d1;
            if (d19Var != null) {
                d19Var.g();
            }
            o16 o16Var = this.A1;
            if (o16Var != null) {
                o16Var.N();
            }
            q19 q19Var = this.A0;
            if (q19Var != null) {
                q19Var.s();
            }
            MessageManager.getInstance().unRegisterTask(2921500);
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity, android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048735, this) == null) {
            super.onDismiss();
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.W, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, null);
            ShowSoftKeyPadDelay(this.L);
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity, com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048736, this, z3) == null) {
            super.onKeyboardVisibilityChanged(z3);
            if (this.p1 && System.currentTimeMillis() - this.q1 < 800) {
                qi.x(getPageContext().getPageActivity(), getCurrentFocus());
                this.p1 = false;
            }
            if (this.C1 != null && !z3) {
                v5();
            }
            if (z3) {
                return;
            }
            w5();
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048737, this, intent) == null) {
            super.onNewIntent(intent);
            if (intent == null) {
                return;
            }
            if (this.e1) {
                e5(intent);
                return;
            }
            String stringExtra = intent.getStringExtra(BaseWriteConfig.KEY_WRITE_IMAGES_INFO_STRING);
            if (stringExtra == null || (writeImagesInfo = this.u) == null) {
                return;
            }
            writeImagesInfo.parseJson(stringExtra);
            this.u.updateQuality();
            if (this.u.getChosedFiles() != null) {
                I2();
            }
            F6(true);
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048738, this) == null) {
            super.onPause();
            t0().onPause(getPageContext());
            if (this.e0.u()) {
                this.e0.q();
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity, com.baidu.tbadk.BaseActivity, android.app.Activity
    @SuppressLint({"NewApi"})
    @TargetApi(23)
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048739, this, i2, strArr, iArr) == null) {
            if (i2 == 1) {
                ArrayMap<String, Boolean> transformPermissionResult = PermissionUtil.transformPermissionResult(strArr, iArr);
                if (PermissionUtil.checkCamera(getApplicationContext())) {
                    SelectImageHelper.takePhoto(getPageContext(), this.a1);
                } else {
                    showToast(R.string.obfuscated_res_0x7f0f133e);
                }
                if (!transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") || transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                    return;
                }
                showToast(R.string.obfuscated_res_0x7f0f109c);
                return;
            }
            super.onRequestPermissionsResult(i2, strArr, iArr);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048740, this) == null) {
            super.onResume();
            t0().onResume(getPageContext());
            if (this.C0) {
                this.m = true;
                N1();
                EditorTools editorTools = this.e0;
                if (editorTools != null) {
                    editorTools.q();
                }
                this.H.requestFocus();
                ShowSoftKeyPadDelay(this.H);
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048741, this, bundle) == null) {
            bundle.putString(WriteActivityConfig.FLOOR_ID, this.r.getFloor());
            bundle.putInt("floor_num", this.r.getFloorNum());
            bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.X0);
            if (this.C0) {
                bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
            }
            bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.u1);
            bundle.putBoolean(WriteActivityConfig.CAN_GOODS, this.v1);
            bundle.putBoolean(WriteActivityConfig.NEED_CLOSE_PRE_PAGE, this.Y1);
            bundle.putInt(WriteActivityConfig.KEY_STATISTIS_FROM, this.r.getStatisticFrom());
            super.onSaveInstanceState(bundle);
            t0().onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048742, this) == null) {
            super.onStart();
            t0().onStart(getPageContext());
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048743, this) == null) {
            super.onStop();
            t0().onStop(getPageContext());
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void p2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048744, this) == null) {
            this.J0 = findViewById(R.id.obfuscated_res_0x7f0919fc);
            RichTextEditor richTextEditor = (RichTextEditor) findViewById(R.id.obfuscated_res_0x7f091bd4);
            this.K0 = richTextEditor;
            richTextEditor.setWriteImagesInfo(this.u);
            SpanGroupEditText spanGroupEditText = (SpanGroupEditText) findViewById(R.id.obfuscated_res_0x7f0919fb);
            this.L = spanGroupEditText;
            spanGroupEditText.setDrawingCacheEnabled(false);
            this.L.setOnClickListener(this.w0);
            z zVar = new z(this);
            this.L.setOnSpanGroupChangedListener(zVar);
            this.L.setType(SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_COMMODITY);
            this.L.setForumId(og.g(this.r.getForumId(), 0L));
            wm8 wm8Var = this.b1;
            if (wm8Var != null) {
                wm8Var.G(this.L.getSpanGroupManager());
            }
            WriteData writeData = this.r;
            if (writeData != null) {
                writeData.setSpanGroupManager(this.L.getSpanGroupManager());
            }
            if (this.r.getContent() != null && this.r.getContent().length() > 0) {
                this.L.setText(TbFaceManager.i().r(getPageContext().getPageActivity(), this.r.getContent()));
                if (this.L.getText() != null) {
                    SpanGroupEditText spanGroupEditText2 = this.L;
                    spanGroupEditText2.setSelection(spanGroupEditText2.getText().length());
                }
            } else if (this.r.getType() == 2) {
                if (this.X0) {
                    String str = this.Y0;
                    if (str != null && str.length() > 0) {
                        this.L.setText(getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f0feb, new Object[]{this.Y0}));
                        SpanGroupEditText spanGroupEditText3 = this.L;
                        spanGroupEditText3.setSelection(spanGroupEditText3.getText().length());
                    }
                } else if (this.r.getFloorNum() > 0) {
                    this.L.setText(String.format(getPageContext().getString(R.string.obfuscated_res_0x7f0f0fed), Integer.valueOf(this.r.getFloorNum())));
                    SpanGroupEditText spanGroupEditText4 = this.L;
                    spanGroupEditText4.setSelection(spanGroupEditText4.getText().length());
                }
            }
            this.L.setOnFocusChangeListener(this.x0);
            this.L.setOnTouchListener(new a0(this));
            this.L.addTextChangedListener(this.i0);
            if (this.r.getType() == 0) {
                this.z1 = true;
            } else {
                A6(true);
                this.z1 = false;
            }
            if (this.R1) {
                SpannableString spannableString = new SpannableString(" " + ((Object) getResources().getText(R.string.obfuscated_res_0x7f0f15ca)));
                Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809ae, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL);
                pureDrawable.setBounds(0, 0, pureDrawable.getIntrinsicWidth(), pureDrawable.getIntrinsicHeight());
                spannableString.setSpan(new ha6(pureDrawable, 1, qi.f(this, R.dimen.tbds4)), 0, 1, 17);
                this.L.setHint(spannableString);
            } else if (this.r.isUserFeedback()) {
                this.L.setHint(R.string.obfuscated_res_0x7f0f15ce);
            } else if (this.h1) {
                this.L.setHint(getString(R.string.obfuscated_res_0x7f0f0f6d));
            } else {
                this.L.setHint(R.string.obfuscated_res_0x7f0f0a7d);
            }
            this.K0.setOnSpanGroupChangedListener(zVar);
            this.K0.setForumId(og.g(this.r.getForumId(), 0L));
            this.K0.setEditOnClickListener(this.w0);
            this.K0.setEditOnFocusChangeListener(this.x0);
            this.K0.setBigEmotionSpanHandler(this.q0);
            this.K0.j(this.i0);
            this.K0.m();
            R5();
        }
    }

    public final void p4() {
        CustomResponsedMessage runTask;
        s25 s25Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048745, this) == null) || (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, getActivity()), s25.class)) == null || (s25Var = (s25) runTask.getData()) == null) {
            return;
        }
        s25Var.o = true;
        s25Var.l = 9;
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.f)) {
            return;
        }
        this.e0.d(s25Var);
    }

    public final int p5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048746, this)) == null) {
            SpanGroupEditText spanGroupEditText = this.L;
            if (spanGroupEditText == null || spanGroupEditText.getSpanGroupManager() == null) {
                return 10;
            }
            return 10 - this.L.getSpanGroupManager().z();
        }
        return invokeV.intValue;
    }

    public final void p6(Editable editable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048747, this, editable) == null) || this.N0 == null) {
            return;
        }
        if (!TextUtils.isEmpty(editable)) {
            SpannableString spannableString = new SpannableString(getString(R.string.obfuscated_res_0x7f0f08f6, new Object[]{Integer.valueOf(editable.length()), 31}));
            if (editable.length() > 31) {
                spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301)), 0, String.valueOf(editable.length()).length(), 17);
            }
            this.N0.setText(spannableString);
            return;
        }
        this.N0.setText(getString(R.string.obfuscated_res_0x7f0f08f6, new Object[]{0, 31}));
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048748, this) == null) {
            HeadImageView headImageView = (HeadImageView) findViewById(R.id.obfuscated_res_0x7f09243e);
            this.F0 = headImageView;
            headImageView.setIsRound(true);
            this.F0.setDrawBorder(false);
            this.F0.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
            if (!StringUtils.isNull(currentPortrait)) {
                this.F0.setUrl(currentPortrait);
                this.F0.K(currentPortrait, 12, false);
            }
            if (this.r.isUserFeedback()) {
                this.F0.setVisibility(0);
            }
            EditText editText = (EditText) findViewById(R.id.obfuscated_res_0x7f091a18);
            this.H = editText;
            editText.setOnClickListener(this.w0);
            this.H.setOnFocusChangeListener(this.x0);
            if (this.r.getType() == 0 || this.r.getType() == 9 || this.r.getType() == 11) {
                if (this.r.getTitle() != null) {
                    this.H.setText(this.r.getTitle());
                    this.H.setSelection(this.r.getTitle().length());
                } else if (this.E0) {
                    this.H.setText(getResources().getString(R.string.obfuscated_res_0x7f0f14f8));
                }
            }
            this.H.addTextChangedListener(this.j0);
            this.H.setFilters(new InputFilter[]{new l09.b(this.H, 31, new y(this))});
            ms4.d(this.H).A(R.string.F_X02);
            if (this.r.getHaveDraft()) {
                return;
            }
            j2();
            this.r1 = true;
        }
    }

    public final void q4(ImageFileInfo imageFileInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048749, this, imageFileInfo) == null) && this.e1 && imageFileInfo != null) {
            W5(imageFileInfo);
        }
    }

    public final String q5() {
        InterceptResult invokeV;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048750, this)) == null) {
            if (this.r == null || X1() == null || X1().getVisibility() != 0 || X1().getText() == null) {
                return "";
            }
            String obj = X1().getText().toString();
            PostPrefixData postPrefixData = this.d;
            if (postPrefixData != null && ListUtils.getCount(postPrefixData.getPrefixs()) > 0 && this.i != ListUtils.getCount(this.d.getPrefixs()) - 1 && (textView = this.U) != null && textView.getText() != null) {
                this.r.setPostPrefix(this.U.getText().toString());
            }
            PostPrefixData postPrefixData2 = this.d;
            if (postPrefixData2 == null || StringUtils.isNull(postPrefixData2.getImplicitTitle())) {
                return obj;
            }
            return this.d.getImplicitTitle() + this.r.getTitle();
        }
        return (String) invokeV.objValue;
    }

    public final void q6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048751, this) == null) {
            this.L.setVisibility(8);
            this.K0.setVisibility(0);
            d19 d19Var = this.d1;
            if (d19Var != null) {
                d19Var.j(true);
            }
        }
    }

    public final void r4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048752, this) == null) || this.R1) {
            return;
        }
        if (!"main_tab".equals(this.f)) {
            this.e0.d(new k25(getActivity(), 10));
        }
        this.e0.d(new f35(getActivity(), 11));
    }

    public final void r5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048753, this) == null) && this.C0 && this.r != null) {
            this.H0.setVisibility(0);
            this.I0.setVisibility(0);
            FeedBackModel feedBackModel = new FeedBackModel(getPageContext());
            this.B = feedBackModel;
            feedBackModel.C(this.r.getForumName());
            this.B.setLoadDataCallBack(new w(this));
        }
    }

    public final void r6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048754, this) == null) {
            ForumTagInfo forumTagInfo = this.j1;
            if (forumTagInfo != null) {
                WriteData writeData = this.r;
                if (writeData != null) {
                    writeData.setQuestionTagId(forumTagInfo.id);
                    this.r.setQuestionTagManualCreated(false);
                }
                this.Q0.setSubTitle(this.j1.name);
                this.Q0.a();
                return;
            }
            WriteData writeData2 = this.r;
            if (writeData2 != null) {
                writeData2.setQuestionTagId(null);
                this.r.setQuestionTagManualCreated(false);
            }
            this.Q0.setSubTitle(null);
            this.Q0.e();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void s2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048755, this) == null) {
            this.F.setOnClickListener(new x(this));
        }
    }

    public final void s4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048756, this) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            this.e0.h(arrayList);
            s25 n2 = this.e0.n(5);
            if (n2 != null) {
                n2.l = 5;
            }
        }
    }

    public final void s5(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048757, this, str) == null) {
            try {
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (skinType == 4) {
                    str2 = "&skin=dart";
                } else if (skinType == 1) {
                    str2 = "&skin=night";
                } else {
                    str2 = "";
                }
                UrlManager urlManager = UrlManager.getInstance();
                TbPageContext<WriteActivity> pageContext = getPageContext();
                urlManager.dealOneLink(pageContext, new String[]{TbConfig.VIRTUAL_IMAGE_MAIN_URL + str2 + ("&from=" + str)});
            } catch (Exception e2) {
                BdLog.e("openPageByUrl fail:" + e2.toString());
            }
        }
    }

    public void s6(h25 h25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048758, this, h25Var) == null) {
            if (this.e0.u()) {
                this.e0.q();
            }
            if (this.e1) {
                f6();
            } else {
                e6(0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public synchronized VoiceManager t0() {
        InterceptResult invokeV;
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048759, this)) == null) {
            synchronized (this) {
                if (this.c1 == null) {
                    this.c1 = VoiceManager.instance();
                }
                voiceManager = this.c1;
            }
            return voiceManager;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public final void t4(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048760, this, editable) == null) {
            U4(editable);
            G6(editable);
        }
    }

    public final boolean t5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048761, this)) == null) {
            s19 s19Var = this.O1;
            return (s19Var == null || this.P1 == null || s19Var.c() == null || this.P1.getVisibility() != 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void t6(h25 h25Var) {
        String str;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048762, this, h25Var) == null) {
            if (this.e0.u()) {
                this.e0.q();
            }
            int a2 = jz8.a();
            if (jz8.c(a2)) {
                jz8.e(getPageContext().getPageActivity(), a2, WorkPublishOpenHelper.OPEN_WORK_PUBLISH_FROM_FRS_WRITE);
            } else if (jz8.b()) {
                if (this.u == null || this.r == null) {
                    return;
                }
                if (this.H.getText().toString() != null) {
                    str = this.H.getText().toString();
                    i2 = 5;
                } else {
                    str = this.y;
                    i2 = 1;
                }
                if (this.I1 == null && this.r.getForumName() != null) {
                    jz8.f(getPageContext(), str, this.L.getText().toString(), this.r.getForumId(), this.r.getForumName(), 3, Boolean.FALSE, "", "", "");
                } else {
                    jz8.f(getPageContext(), str, this.L.getText().toString(), this.r.getForumId(), this.r.getForumName(), i2, Boolean.TRUE, "", "", "");
                }
            } else {
                h6(0);
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void u2(@NonNull h25 h25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048763, this, h25Var) == null) {
            super.u2(h25Var);
            int i2 = h25Var.a;
            if (i2 == 16) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 9));
            } else if (i2 == 14 || i2 == 48) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 1));
                s6(h25Var);
            } else if (i2 == 60) {
                t6(h25Var);
            } else if (i2 == 24) {
                Object obj = h25Var.c;
                if (obj instanceof gy4) {
                    gy4 gy4Var = (gy4) obj;
                    if (EmotionGroupType.isSendAsPic(gy4Var.getType())) {
                        if (this.mCurrentPermissionJudgePolicy == null) {
                            this.mCurrentPermissionJudgePolicy = new PermissionJudgePolicy();
                        }
                        this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
                        this.mCurrentPermissionJudgePolicy.appendRequestPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.mCurrentPermissionJudgePolicy.startRequestPermission(this)) {
                            return;
                        }
                        if (this.u.size() >= this.u.getMaxImagesAllowed()) {
                            showToast(String.format(getString(R.string.obfuscated_res_0x7f0f0aa4), Integer.valueOf(this.u.getMaxImagesAllowed())));
                            return;
                        }
                        ImageFileInfo imageFileInfo = new ImageFileInfo();
                        imageFileInfo.setImageType(1);
                        imageFileInfo.setFilePath(gy4Var.d());
                        imageFileInfo.width = gy4Var.h();
                        imageFileInfo.height = gy4Var.b();
                        this.u.addChooseFile(imageFileInfo);
                        this.u.updateQuality();
                        q4(imageFileInfo);
                        F6(true);
                        H6();
                        C6();
                        C2();
                    } else if (t2()) {
                        showToast(R.string.obfuscated_res_0x7f0f0d19);
                    } else {
                        r2(gy4Var);
                    }
                }
            } else if (i2 == 10) {
                Object obj2 = h25Var.c;
                if (obj2 instanceof VoiceData.VoiceModel) {
                    z4((VoiceData.VoiceModel) obj2);
                    H6();
                }
            } else if (i2 == 11) {
                W4();
                H6();
            } else if (i2 == 12 || i2 == 13 || i2 == 46 || i2 == 49) {
                C6();
                H6();
                C2();
            } else if (i2 == 15 || i2 == 47) {
                Object obj3 = h25Var.c;
                if (obj3 instanceof Integer) {
                    g6(((Integer) obj3).intValue());
                }
            } else {
                String str = null;
                r7 = null;
                WriteVoteData writeVoteData = null;
                str = null;
                if (i2 == 25) {
                    Object obj4 = h25Var.c;
                    if (obj4 instanceof String) {
                        this.M0 = (String) obj4;
                    } else {
                        this.M0 = null;
                    }
                    A6(false);
                } else if (i2 == 43) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 4));
                    ru4.k().u("hot_topic_has_click", true);
                    this.e0.A(new h25(2, 26, null));
                    this.o = true;
                    A2(true);
                    if (X1().isFocused() && this.J.getVisibility() == 0) {
                        this.g = "from_title";
                    } else {
                        this.g = "from_content";
                    }
                } else if (i2 == 58) {
                    Object obj5 = h25Var.c;
                    if (obj5 instanceof Boolean) {
                        this.w1 = ((Boolean) obj5).booleanValue();
                    }
                } else if (i2 == 22) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 10));
                    s19 s19Var = this.O1;
                    if (s19Var != null && s19Var.c() != null) {
                        writeVoteData = this.O1.c();
                    }
                    i6(writeVoteData);
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_WRITE_VOTE_VIEW_SHOW).param("obj_source", 2));
                    x5();
                } else if (i2 == 21) {
                    WriteTipBubbleController writeTipBubbleController = this.B1;
                    if (writeTipBubbleController != null) {
                        writeTipBubbleController.c();
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 5));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddLinkActivityConfig(getActivity(), 25049, "", true, null)));
                } else if (i2 == 59) {
                    l6();
                } else if (i2 == 61) {
                    m6();
                } else if (i2 == 66) {
                    Object obj6 = h25Var.c;
                    if (obj6 instanceof Boolean) {
                        this.x1 = ((Boolean) obj6).booleanValue();
                    }
                } else if (i2 == 69) {
                    Z6();
                    EditText editText = this.H;
                    if (editText != null && editText.getText() != null) {
                        str = this.H.getText().toString();
                    }
                    if (TextUtils.isEmpty(str) && D4()) {
                        Z6();
                        d6();
                        setResult(100);
                        finish();
                        return;
                    }
                    Z6();
                    v6(true);
                }
            }
        }
    }

    public final void u4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048764, this) == null) || this.R1) {
            return;
        }
        this.e0.d(new a35(getActivity(), 12));
    }

    public final void u5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048765, this) == null) {
            View view2 = this.J0;
            view2.setPadding(0, 0, 0, 0);
            view2.setBackgroundDrawable(null);
            SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
        }
    }

    public final void u6(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048766, this, str) == null) {
            this.f2 = new ArrayList();
            ArrayList arrayList = new ArrayList();
            if (StringUtils.isNull(str)) {
                return;
            }
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    String string = jSONArray.getString(i2);
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    arrayList.add(string);
                    this.f2.add(vt6.g(jSONObject));
                }
                if (this.f2.size() > 0) {
                    this.i2 = true;
                    this.L.h(this.f2, arrayList);
                    J5();
                    E6();
                    this.c2.setVisibility(0);
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public final void v4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048767, this) == null) && StringHelper.equals(this.l, "2")) {
            g35 g35Var = new g35(getActivity(), 4);
            this.q2 = g35Var;
            if (this.R1) {
                g35Var.g(false);
                this.q2.h(false);
            }
            this.e0.d(this.q2);
            if (this.R1) {
                return;
            }
            this.e0.d(new v45(getActivity(), 8));
        }
    }

    public final void v5() {
        w09 w09Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048768, this) == null) || (w09Var = this.C1) == null) {
            return;
        }
        w09Var.a();
    }

    public final void v6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048769, this, z3) == null) {
            TextView textView = this.F;
            if (textView != null && ((textView.isEnabled() || this.R1 || !ListUtils.isEmpty(this.r.getItemDatas())) && ((!this.R1 || !TextUtils.isEmpty(this.L.getText()) || (this.u.getChosedFiles() != null && this.u.size() != 0)) && this.U1))) {
                if (this.N1 == null) {
                    this.N1 = new SaveDraftDialogView(this);
                    this.N1.setOnClickListener(new c(this, z3));
                }
                if (this.M1 == null) {
                    ds4 ds4Var = new ds4(getPageContext());
                    this.M1 = ds4Var;
                    ds4Var.setContentView(this.N1);
                }
                this.N1.setText(getString(R.string.obfuscated_res_0x7f0f15d6), getString(R.string.obfuscated_res_0x7f0f1081));
                this.M1.k();
                return;
            }
            Q4();
            setResult(100);
            finish();
        }
    }

    public final void w4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048770, this) == null) {
            d35 d35Var = new d35(getActivity(), 1);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.f)) {
                return;
            }
            this.e0.d(d35Var);
        }
    }

    public final void w5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048771, this) == null) {
            this.O.clearFocus();
        }
    }

    public final void w6() {
        HotTopicBussinessData hotTopicBussinessData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048772, this) == null) {
            Z6();
            this.r.setContent(g5());
            z6(q5());
            if (this.C0 || this.p) {
                String string = getResources().getString(R.string.obfuscated_res_0x7f0f0282);
                if (TextUtils.isEmpty(this.r.getTitle()) || !this.r.getTitle().startsWith(string)) {
                    z6(string + this.r.getTitle());
                }
                String str = getResources().getString(R.string.obfuscated_res_0x7f0f029e) + getResources().getString(R.string.obfuscated_res_0x7f0f13e0);
                if (TextUtils.isEmpty(this.r.getContent()) || !this.r.getContent().startsWith(str)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(TbConfig.getVersion());
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    sb.append(Build.VERSION.RELEASE);
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    sb.append(Build.MODEL);
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    if (oi.z()) {
                        sb.append(oi.K());
                    } else {
                        sb.append(RomUtils.UNKNOWN);
                    }
                    sb.append(":");
                    sb.append(this.r.getContent());
                    this.r.setContent(sb.toString());
                }
            }
            if (this.D0) {
                this.r.setZhongcePrefix(String.format(getResources().getString(R.string.obfuscated_res_0x7f0f0867), Build.MODEL, TbadkCoreApplication.getInst().getVersionName(), oi.K(), Build.VERSION.RELEASE));
            }
            this.r.setWriteImagesInfo(this.u);
            this.K0.setWriteImagesInfo(this.u);
            s19 s19Var = this.O1;
            if (s19Var != null) {
                this.r.setWriteVoteData(s19Var.c());
            }
            WriteImagesInfo writeImagesInfo = this.u;
            if (writeImagesInfo != null && writeImagesInfo.size() > 0) {
                Iterator<ImageFileInfo> it = this.u.getChosedFiles().iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    ImageFileInfo next = it.next();
                    if (next != null && next.isFromCamera()) {
                        i2++;
                    }
                }
                this.r.setTakePhotoNum(i2);
            }
            WriteData writeData = this.r;
            LocationModel locationModel = this.A;
            writeData.setHasLocationData(locationModel != null && locationModel.C());
            WriteImagesInfo writeImagesInfo2 = this.u;
            if (writeImagesInfo2 != null) {
                this.b1.A(writeImagesInfo2.size() > 0);
            }
            if (!ListUtils.isEmpty(this.v) && (hotTopicBussinessData = this.w) != null && hotTopicBussinessData.mIsGlobalBlock == 0) {
                this.r.setForumId(String.valueOf(hotTopicBussinessData.mForumId));
                this.r.setForumName(this.w.mForumName);
            }
            WriteEvaluationHeaderView writeEvaluationHeaderView = this.J1;
            if (writeEvaluationHeaderView != null && writeEvaluationHeaderView.getEvaluateItemInfo() != null) {
                this.r.setItem_id(this.J1.getEvaluateItemInfo().getItemID());
                this.r.setComment_head(f5());
            }
            D1();
            this.b1.H(this.r);
            WriteData writeData2 = this.r;
            writeData2.setContent(writeData2.getContent().replaceAll("\u0000\n", ""));
            WriteData writeData3 = this.r;
            writeData3.setContent(writeData3.getContent().replaceAll("\u0000", ""));
            this.r.setVcode(null);
            this.r.setVoiceModel(this.B0);
            VoiceData.VoiceModel voiceModel = this.B0;
            if (voiceModel != null) {
                if (voiceModel.getId() != null) {
                    this.b1.o().setVoice(this.B0.getId());
                    this.b1.o().setVoiceDuringTime(this.B0.duration);
                } else {
                    this.b1.o().setVoice(null);
                    this.b1.o().setVoiceDuringTime(-1);
                }
            } else {
                this.b1.o().setVoice(null);
                this.b1.o().setVoiceDuringTime(-1);
            }
            this.r.setRichTextEditorMode(this.e1);
            if (this.e1) {
                this.r.setServerRichContent(this.K0.getPostServerContentData());
            }
            if (!this.b1.e()) {
                showToast(R.string.obfuscated_res_0x7f0f15cd);
            } else if (!oi.z()) {
                showToast(R.string.obfuscated_res_0x7f0f0c3c);
            } else if (l28.a().b() == 0 && this.x1) {
                V6();
            } else {
                X6();
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void x2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048773, this) == null) {
            super.x2();
            Z6();
            v6(false);
        }
    }

    public final void x4() {
        CustomResponsedMessage runTask;
        s25 s25Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048774, this) == null) || (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, getActivity()), s25.class)) == null || (s25Var = (s25) runTask.getData()) == null) {
            return;
        }
        s25Var.o = true;
        s25Var.l = 10;
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.f)) {
            return;
        }
        this.e0.d(s25Var);
    }

    public final void x5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048775, this) == null) {
            ImageView imageView = this.W0;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            TextView textView = this.G;
            if (textView != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
                layoutParams.rightMargin = this.w2;
                this.G.setLayoutParams(layoutParams);
            }
        }
    }

    public final void x6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048776, this) == null) {
            if ("1".equals(this.l)) {
                this.r.setCanNoForum(true);
                this.r.setTransmitForumData("[]");
            } else if ("2".equals(this.l)) {
                this.r.setCanNoForum(false);
            }
            E2();
            this.r.setPrivacy(this.n);
            K6();
            this.r.setToDynamic(this.w1);
            L6();
            this.r.setShowCustomFigure(this.x1);
            this.r.setCallFrom(this.l);
            if (this.r.getVideoInfo() != null) {
                TiebaStatic.log("c10063");
            }
            WriteData writeData = this.r;
            ru4 k2 = ru4.k();
            writeData.setShowCustomFigure(k2.h("key_write_virtual_image_enable" + TbadkCoreApplication.getCurrentAccount(), true));
            w6();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void y2(PostWriteCallBackData postWriteCallBackData, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048777, this, postWriteCallBackData, writeData) == null) {
            super.y2(postWriteCallBackData, writeData);
            l09.e(this.r);
            Q4();
            if ((this.r.getType() == 0 || this.r.getType() == 9 || this.r.getType() == 11) && !ListUtils.isEmpty(this.v) && !StringUtils.isNull(this.y1)) {
                TiebaStatic.log(new StatisticItem("c11731").param("obj_id", this.y1));
            }
            if (!pi.isEmpty(postWriteCallBackData.getVideoid()) && this.r.getVideoInfo() != null) {
                if (!pi.isEmpty(this.r.getForumName())) {
                    postWriteCallBackData.mFrom = 2;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001374, postWriteCallBackData));
            } else {
                K2(postWriteCallBackData);
            }
            finish();
        }
    }

    public final void y4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048778, this) == null) {
            t45 t45Var = new t45(getActivity(), 2);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.f)) {
                return;
            }
            this.e0.d(t45Var);
        }
    }

    public final void y5() {
        WriteImagesInfo writeImagesInfo;
        LinkedList<ImageFileInfo> chosedFiles;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048779, this) == null) || (writeImagesInfo = this.u) == null || writeImagesInfo.size() <= 0 || (chosedFiles = this.u.getChosedFiles()) == null) {
            return;
        }
        for (ImageFileInfo imageFileInfo : chosedFiles) {
            if (imageFileInfo != null) {
                W5(imageFileInfo);
            }
        }
    }

    public final void y6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048780, this) == null) {
            WriteData writeData = this.r;
            if (writeData != null && writeData.getType() == 2 && this.X0) {
                finish();
            } else if (this.r == null) {
                finish();
            } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.f)) {
                finish();
            } else {
                this.r.setTitle(X1().getText().toString());
                this.r.setContent(W1().getText().toString());
                WriteEvaluationHeaderView writeEvaluationHeaderView = this.J1;
                if (writeEvaluationHeaderView != null) {
                    this.r.setEvaluationStar(writeEvaluationHeaderView.getStarCount());
                }
                this.r.setRichTextEditorMode(this.e1);
                if (this.e1) {
                    this.r.setRichContentData(this.K0.getPlainTextContentData());
                }
                this.r.setQuestionThread(this.h1);
                int type = this.r.getType();
                if (type == 0 || type == 9 || type == 11) {
                    if (this.U1) {
                        if (this.s1) {
                            fk8.v(this.r);
                        } else if (this.h1) {
                            fk8.z(this.r.getForumId(), this.r, false);
                        } else if (this.r.isEvaluate()) {
                            fk8.s(this.r.getItem_id(), this.r);
                        } else if (TextUtils.isEmpty(this.r.getTopicId())) {
                            fk8.t(this.r.getForumId(), this.r);
                        } else {
                            fk8.B(this.r.getTopicId(), this.r);
                        }
                    }
                } else if (type == 1) {
                    fk8.y(this.r.getThreadId(), this.r);
                }
                this.v2 = true;
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void z2(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048781, this, z3) == null) {
            if (z3 || this.s1) {
                D2();
            }
        }
    }

    public final void z4(VoiceData.VoiceModel voiceModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048782, this, voiceModel) == null) || voiceModel == null || TextUtils.isEmpty(voiceModel.voiceId) || voiceModel.duration <= 0) {
            return;
        }
        this.B0 = voiceModel;
        this.r.setVoiceModel(voiceModel);
        this.R0.setVisibility(0);
        this.S0.setVoiceModel(voiceModel);
        this.S0.o();
        C2();
    }

    public final void z5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048783, this) == null) {
            w4();
            s4();
            o4();
            p4();
            x4();
            B4();
        }
    }

    public final void z6(String str) {
        ConstraintLayout constraintLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048784, this, str) == null) || this.r == null || (constraintLayout = this.J) == null) {
            return;
        }
        if (constraintLayout.getVisibility() == 0) {
            if (StringUtils.isNull(str)) {
                this.r.setIsNoTitle(true);
                this.r.setTitle("");
                return;
            }
            this.r.setIsNoTitle(false);
            this.r.setTitle(str);
            return;
        }
        this.r.setIsNoTitle(true);
        this.r.setTitle("");
    }
}
