package com.baidu.tieba.write.write;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.permissionhelper.app.ActivityCompat;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.afx.TbAlphaVideo;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddLinkActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.BaseWriteConfig;
import com.baidu.tbadk.core.atomData.BubbleChooseActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.LocalChannelTopicListActivityConfig;
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
import com.baidu.tbadk.core.util.dimen.TbDimenUtil;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
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
import com.baidu.tbadk.widget.richText.TbRichTextEvaluateItemInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.a69;
import com.baidu.tieba.au4;
import com.baidu.tieba.b39;
import com.baidu.tieba.ba5;
import com.baidu.tieba.bx4;
import com.baidu.tieba.c69;
import com.baidu.tieba.d39;
import com.baidu.tieba.dc6;
import com.baidu.tieba.dh;
import com.baidu.tieba.dj;
import com.baidu.tieba.ej;
import com.baidu.tieba.f55;
import com.baidu.tieba.f75;
import com.baidu.tieba.frs.FrsPublishFineGoodsDialogView;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.tieba.g39;
import com.baidu.tieba.g55;
import com.baidu.tieba.gh;
import com.baidu.tieba.gm8;
import com.baidu.tieba.h55;
import com.baidu.tieba.h75;
import com.baidu.tieba.ih;
import com.baidu.tieba.ir4;
import com.baidu.tieba.j19;
import com.baidu.tieba.ju4;
import com.baidu.tieba.k29;
import com.baidu.tieba.k36;
import com.baidu.tieba.kz4;
import com.baidu.tieba.ln4;
import com.baidu.tieba.lv6;
import com.baidu.tieba.n55;
import com.baidu.tieba.no8;
import com.baidu.tieba.on;
import com.baidu.tieba.po8;
import com.baidu.tieba.q55;
import com.baidu.tieba.qh5;
import com.baidu.tieba.qo4;
import com.baidu.tieba.r05;
import com.baidu.tieba.ro8;
import com.baidu.tieba.s38;
import com.baidu.tieba.s55;
import com.baidu.tieba.st8;
import com.baidu.tieba.t55;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tl8;
import com.baidu.tieba.u45;
import com.baidu.tieba.ug5;
import com.baidu.tieba.uh5;
import com.baidu.tieba.uu4;
import com.baidu.tieba.vg5;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.EBusinessProtocolView;
import com.baidu.tieba.vy4;
import com.baidu.tieba.w29;
import com.baidu.tieba.write.WritePrefixItemLayout;
import com.baidu.tieba.write.data.QuestionTagListData;
import com.baidu.tieba.write.view.AssociatedItemContainer;
import com.baidu.tieba.write.view.ForumSelectedView;
import com.baidu.tieba.write.view.ForumTabSelectedView;
import com.baidu.tieba.write.view.LocalChannelTopicSelectView;
import com.baidu.tieba.write.view.WriteEvaluationHeaderView;
import com.baidu.tieba.write.view.xrichtext.RichImageItem;
import com.baidu.tieba.write.view.xrichtext.RichTextEditor;
import com.baidu.tieba.x45;
import com.baidu.tieba.x59;
import com.baidu.tieba.xh5;
import com.baidu.tieba.y19;
import com.baidu.tieba.y29;
import com.baidu.tieba.yg;
import com.baidu.tieba.yl8;
import com.baidu.tieba.zg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class WriteActivity extends AbsBaseWriteActivity<WriteActivity> implements VoiceManager.j, yl8.g, ActivityCompat.OnRequestPermissionsResultCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PlayVoiceBntNew A0;
    public y29 A1;
    public ImageView B0;
    public LinearLayout B1;
    public View C0;
    public ImageView C1;
    public ImageView D0;
    public TextView D1;
    public ImageView E0;
    public List<lv6> E1;
    public boolean F0;
    public EBusinessProtocolView F1;
    public boolean G0;
    public boolean G1;
    public String H0;
    public boolean H1;
    public po8 I0;
    public View I1;
    public VoiceManager J0;
    public final HttpMessageListener J1;
    public d39 K0;
    public final d39.b K1;
    public boolean L0;
    public CustomMessageListener L1;
    public boolean M0;
    public final CustomMessageListener M1;
    public String N0;
    public WriteTipBubbleController.b N1;
    public boolean O0;
    public ListView O1;
    public String P0;
    public WriteImageGridView P1;
    public ForumTagInfo Q0;
    public t55 Q1;
    public boolean R0;
    public CustomMessageListener R1;
    public String S0;
    public CustomMessageListener S1;
    public int T0;
    public CustomMessageListener T1;
    public boolean U0;
    public ba5 U1;
    public boolean V0;
    public boolean V1;
    public boolean W0;
    public int W1;
    public String X0;
    public final gm8.f X1;
    public boolean Y0;
    public final Runnable Y1;
    public k36 Z0;
    public WriteTipBubbleController a1;
    public w29 b1;
    public String c1;
    public String d1;
    public String e1;
    public LocalChannelTopicSelectView f1;
    public a69 g0;
    public ForumSelectedView g1;
    public VoiceData.VoiceModel h0;
    public SelectForumData h1;
    public View i0;
    public WriteEvaluationHeaderView i1;
    public View j0;
    public TextView j1;
    public View k1;
    public ju4 l1;
    public SaveDraftDialogView m1;
    public c69 n1;
    public RelativeLayout o1;
    public SerializableItemInfo p1;
    public TbAlphaVideo q0;
    public boolean q1;
    public RichTextEditor r0;
    public boolean r1;
    public View s0;
    public int s1;
    public String t0;
    public boolean t1;
    public String u0;
    public boolean u1;
    public TextView v0;
    public String v1;
    public TextView w0;
    public Serializable w1;
    public NormalItemCell x0;
    public boolean x1;
    public NormalItemCell y0;
    public AssociatedItemContainer y1;
    public LinearLayout z0;
    public final y29.d z1;

    /* loaded from: classes6.dex */
    public class a extends ba5<GoodsEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity c;

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
            this.c = writeActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.u95
        /* renamed from: a */
        public boolean onEvent(GoodsEvent goodsEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, goodsEvent)) == null) {
                if (goodsEvent == null) {
                    return false;
                }
                this.c.U5(goodsEvent.getGoodsList());
                goodsEvent.setDispost(true);
                this.c.M1();
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class a0 implements vy4.a {
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

        @Override // com.baidu.tieba.vy4.a
        public void b(int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                this.a.e6();
                this.a.M1();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public b(WriteActivity writeActivity) {
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (editorTools = (writeActivity = this.a).S) == null || editorTools.a == null) {
                return;
            }
            if (writeActivity.b1 == null) {
                WriteActivity writeActivity2 = this.a;
                writeActivity2.b1 = new w29(writeActivity2.getPageContext());
            }
            this.a.b1.b(this.a.S.a.s(2));
        }
    }

    /* loaded from: classes6.dex */
    public class b0 implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public b0(WriteActivity writeActivity) {
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
                    this.a.S.A(new u45(5, -1, null));
                    this.a.E.requestFocus();
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteVoteData a;
        public final /* synthetic */ WriteActivity b;

        public c(WriteActivity writeActivity, WriteVoteData writeVoteData) {
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
                this.b.I5(this.a);
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_WRITE_VOTE_VIEW_SHOW).param("obj_source", 3));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c0 extends yg<on> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ WriteActivity b;

        public c0(WriteActivity writeActivity, boolean z) {
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
        @Override // com.baidu.tieba.yg
        public void onLoaded(on onVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, onVar, str, i) == null) {
                super.onLoaded((c0) onVar, str, i);
                if (onVar == null || onVar.p() == null || onVar.o() == null) {
                    return;
                }
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), onVar.p(), onVar.p().getNinePatchChunk(), onVar.o(), null);
                if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
                    ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                }
                this.b.j0.setBackgroundDrawable(ninePatchDrawable);
                if (this.a) {
                    gm8.c(this.b.getPageContext(), this.b.V1(), true, this.b.X1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001353, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ WriteActivity b;

        public d(WriteActivity writeActivity, boolean z) {
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
            if (id == R.id.obfuscated_res_0x7f091dad) {
                this.b.w4();
                if (this.a) {
                    this.b.D5();
                }
                this.b.setResult(100);
                this.b.finish();
            } else if (id == R.id.obfuscated_res_0x7f091dae) {
                this.b.Y5();
                if (this.a) {
                    this.b.D5();
                }
                this.b.setResult(100);
                this.b.finish();
            }
            this.b.l1.dismiss();
        }
    }

    /* loaded from: classes6.dex */
    public class d0 implements gm8.f {
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

        @Override // com.baidu.tieba.gm8.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.t0 = null;
                this.a.u0 = null;
                this.a.a6(false);
                this.a.S.A(new u45(2, 12, null));
            }
        }
    }

    /* loaded from: classes6.dex */
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
                if (this.a.M0) {
                    this.a.p4();
                    this.a.I2();
                    this.a.M1();
                } else if (this.a.O0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.a.getPageContext().getPageActivity(), "", ej.P(TbConfig.QUESTION_THREAD_RULE, "refer=3"), true, true, true)));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e0 implements c69.b {
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

        @Override // com.baidu.tieba.c69.b
        public void a(WriteVoteData writeVoteData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, writeVoteData) == null) {
                this.a.M1();
                this.a.A6(writeVoteData);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.C4();
                this.a.h6();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f0 implements AdapterView.OnItemClickListener {
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

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) && this.a.A1 != null && (this.a.A1.getItem(i) instanceof ir4)) {
                ir4 ir4Var = (ir4) this.a.A1.getItem(i);
                int i2 = ir4Var.b;
                if (i2 == 1) {
                    if (ir4Var.o == 1) {
                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{ir4Var.g});
                        return;
                    }
                    UrlManager urlManager = UrlManager.getInstance();
                    TbPageContext<WriteActivity> pageContext = this.a.getPageContext();
                    urlManager.dealOneLink(pageContext, new String[]{qo4.a + dj.getUrlEncode(ir4Var.g)});
                } else if (i2 == 2) {
                    if (!TextUtils.isEmpty(ir4Var.j)) {
                        if (ir4Var.j.startsWith("tiebaclient://")) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, ir4Var.j));
                            return;
                        }
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(ir4Var.j));
                        intent.addFlags(268468224);
                        if (UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                            this.a.startActivity(intent);
                        } else if (TextUtils.isEmpty(ir4Var.k)) {
                        } else {
                            UrlManager urlManager2 = UrlManager.getInstance();
                            TbPageContext<WriteActivity> pageContext2 = this.a.getPageContext();
                            urlManager2.dealOneLink(pageContext2, new String[]{qo4.a + dj.getUrlEncode(ir4Var.k)});
                        }
                    } else if (TextUtils.isEmpty(ir4Var.k)) {
                    } else {
                        UrlManager urlManager3 = UrlManager.getInstance();
                        TbPageContext<WriteActivity> pageContext3 = this.a.getPageContext();
                        urlManager3.dealOneLink(pageContext3, new String[]{qo4.a + dj.getUrlEncode(ir4Var.k)});
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
                int height = this.a.v0.getHeight();
                EditText editText = this.a.A;
                editText.setPadding(editText.getPaddingLeft(), this.a.A.getPaddingTop(), this.a.A.getPaddingRight(), this.a.A.getPaddingBottom() + height);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g0 implements d39.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public g0(WriteActivity writeActivity) {
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

        @Override // com.baidu.tieba.d39.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c6();
                this.a.h6();
            }
        }

        @Override // com.baidu.tieba.d39.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.v2();
                this.a.n4(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int height = this.a.w0.getHeight();
                SpanGroupEditText spanGroupEditText = this.a.E;
                spanGroupEditText.setPadding(spanGroupEditText.getPaddingLeft(), this.a.E.getPaddingTop(), this.a.E.getPaddingRight(), this.a.E.getPaddingBottom() + height);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h0 implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.u1) {
                this.a.a0.callback(false, ro8.d, ro8.e, ro8.f, ro8.g);
            }
        }
    }

    /* loaded from: classes6.dex */
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
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectForumConfig(this.a)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i0 implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ej.x(this.a.getActivity(), this.a.getCurrentFocus());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!this.a.u4()) {
                    if (this.a.Q0 == null) {
                        if (!TextUtils.isEmpty(this.a.P0)) {
                            this.a.C5();
                            return;
                        } else {
                            this.a.x4();
                            return;
                        }
                    }
                    return;
                }
                BdTopToast bdTopToast = new BdTopToast(this.a, 3000);
                bdTopToast.h(false);
                bdTopToast.g(this.a.getString(R.string.obfuscated_res_0x7f0f03c7));
                bdTopToast.i((ViewGroup) this.a.v);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j0 extends BdAsyncTask<Void, Integer, Void> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                FileHelper.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + this.a.H0));
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class k implements y29.d {
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

        @Override // com.baidu.tieba.y29.d
        public void a(List<ir4> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                this.a.n6(list);
            }
        }

        @Override // com.baidu.tieba.y29.d
        public void b(int i) {
            SpanGroupEditText spanGroupEditText;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || (spanGroupEditText = this.a.E) == null) {
                return;
            }
            spanGroupEditText.g(i);
        }
    }

    /* loaded from: classes6.dex */
    public class k0 extends InsertGalleryAsyncTask.a {
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
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && new File(str).exists() && (writeImagesInfo = this.a.q) != null) {
                writeImagesInfo.clear();
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(str);
                imageFileInfo.isFromMoreForum = true;
                this.a.q.addChooseFile(imageFileInfo);
                this.a.q.setMaxImagesAllowed(1);
                this.a.Y3(imageFileInfo);
                this.a.f6(true);
                this.a.h6();
                this.a.c6();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements x59 {
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

        @Override // com.baidu.tieba.x59
        public void a(@NonNull QuestionTagListData.QuestionTag questionTag) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, questionTag) == null) {
                WriteData writeData = this.a.p;
                if (writeData != null) {
                    writeData.setQuestionTagId(questionTag.id);
                    this.a.p.setQuestionTagManualCreated(true);
                }
                if (this.a.y0 != null) {
                    this.a.y0.setSubTitle(questionTag.tagName);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        /* loaded from: classes6.dex */
        public class a extends qh5<String> {
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
            @Override // com.baidu.tieba.qh5
            public String doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? UtilHelper.getClipBoardContent() : (String) invokeV.objValue;
            }
        }

        /* loaded from: classes6.dex */
        public class b implements vg5<String> {
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
            @Override // com.baidu.tieba.vg5
            /* renamed from: a */
            public void onReturnDataInUI(String str) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && !dj.isEmpty(str) && UrlManager.getInstance().isUrlValid(str)) {
                    if (this.a.a.a1 == null) {
                        WriteActivity writeActivity = this.a.a;
                        writeActivity.a1 = new WriteTipBubbleController(writeActivity.getPageContext(), this.a.a.N1);
                    }
                    View s = this.a.a.S.a.s(31);
                    WriteTipBubbleController writeTipBubbleController = this.a.a.a1;
                    writeTipBubbleController.d(s, this.a.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0641) + "\n" + str, str, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL);
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (editorTools = this.a.S) == null || editorTools.a == null) {
                return;
            }
            if (AsyncGetClipboardSwitch.isOn() && TbadkCoreApplication.getInst().isMIUIRom()) {
                uh5.b(new a(this), new b(this));
                return;
            }
            String clipBoardContent = UtilHelper.getClipBoardContent();
            if (dj.isEmpty(clipBoardContent) || !UrlManager.getInstance().isUrlValid(clipBoardContent)) {
                return;
            }
            if (this.a.a1 == null) {
                WriteActivity writeActivity = this.a;
                writeActivity.a1 = new WriteTipBubbleController(writeActivity.getPageContext(), this.a.N1);
            }
            View s = this.a.S.a.s(31);
            WriteTipBubbleController writeTipBubbleController = this.a.a1;
            writeTipBubbleController.d(s, this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0641) + "\n" + clipBoardContent, clipBoardContent, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL);
        }
    }

    /* loaded from: classes6.dex */
    public class m implements AssociatedItemContainer.b {
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

        @Override // com.baidu.tieba.write.view.AssociatedItemContainer.b
        public void a(ItemData itemData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, itemData) == null) {
                this.a.p.removeItemData(itemData);
                if (ListUtils.isEmpty(this.a.p.getItemDatas())) {
                    this.a.M1();
                    this.a.y1.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ au4 a;
        public final /* synthetic */ WriteActivity b;

        public m0(WriteActivity writeActivity, au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity, au4Var};
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
            this.a = au4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            au4 au4Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (au4Var = this.a) == null) {
                return;
            }
            au4Var.dismiss();
            bx4.k().u("commodity_goods_show_first_dialog", true);
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_WRITE_GOODS_NEW_DIALOG_CLICK).param("obj_locate", 2);
            WriteData writeData = this.b.p;
            StatisticItem param2 = param.param("fid", writeData != null ? writeData.getForumId() : "");
            WriteData writeData2 = this.b.p;
            TiebaStatic.log(param2.param("fname", writeData2 != null ? writeData2.getForumName() : ""));
            String uk = TbadkCoreApplication.getCurrentAccountInfo().getUk();
            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + uk + "&max=" + this.b.R4()));
        }
    }

    /* loaded from: classes6.dex */
    public class n implements AssociatedItemContainer.a {
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

        @Override // com.baidu.tieba.write.view.AssociatedItemContainer.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                if (this.a.P1.getVisibility() == 0) {
                    this.a.n4(true);
                } else {
                    this.a.n4(false);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
                bdTopToast.g(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f14fd));
                bdTopToast.i((ViewGroup) this.a.v);
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class o implements WriteEvaluationHeaderView.b {
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

        @Override // com.baidu.tieba.write.view.WriteEvaluationHeaderView.b
        public void a(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048576, this, f) == null) {
                if (!TextUtils.isEmpty(this.a.E.getText()) && this.a.E.getText().length() >= 20 && this.a.E.getText().length() <= 500 && f > 0.0f) {
                    this.a.y.setEnabled(true);
                } else {
                    this.a.y.setEnabled(false);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
                this.a.s0.setVisibility(8);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p implements WriteEvaluationHeaderView.c {
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

        @Override // com.baidu.tieba.write.view.WriteEvaluationHeaderView.c
        public void onClose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.y.setEnabled(false);
            }
        }
    }

    /* loaded from: classes6.dex */
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
                this.a.T4("5");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

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

        @Override // android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ih.i(this.a.F1, this.a);
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

    /* loaded from: classes6.dex */
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
                this.a.s0.setVisibility(8);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        /* loaded from: classes6.dex */
        public class a implements au4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(r rVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {rVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.au4.e
            public void onClick(au4 au4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, au4Var) == null) {
                    bx4 k = bx4.k();
                    k.u(TbadkCoreApplication.getCurrentAccount() + "is_agree_protocol", true);
                    au4Var.dismiss();
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements au4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(r rVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {rVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.au4.e
            public void onClick(au4 au4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, au4Var) == null) {
                    bx4 k = bx4.k();
                    k.u(TbadkCoreApplication.getCurrentAccount() + "is_agree_protocol", false);
                    au4Var.dismiss();
                }
            }
        }

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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.G1) {
                    this.a.G1 = false;
                    this.a.C1.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080a2f, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
                } else {
                    this.a.G1 = true;
                    this.a.C1.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08083e, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
                }
                bx4 k = bx4.k();
                if (k.h(TbadkCoreApplication.getCurrentAccount() + "is_agree_protocol", false) || !this.a.G1) {
                    return;
                }
                au4 au4Var = new au4(this.a);
                au4Var.setNegativeTextColor(R.color.CAM_X0105);
                au4Var.setTitle("");
                au4Var.setMessage(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0f50));
                au4Var.setContentViewSize(1);
                au4Var.setPositiveButton("同意", new a(this));
                au4Var.setNegativeButton(SapiWebView.HTTPS_SSL_DATE_INVALID_DIALOG_CANCEL, new b(this));
                au4Var.create(this.a.getPageContext()).show();
            }
        }
    }

    /* loaded from: classes6.dex */
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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                WriteActivity writeActivity = this.a;
                if (writeActivity.p == null || !writeActivity.U0) {
                    return;
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_COMMODITY_ENTRANCE_SHOW).param("obj_locate", 1).param("fid", this.a.p.getForumId()).param("fname", this.a.p.getForumName()));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s implements EBusinessProtocolView.f {
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

        @Override // com.baidu.tieba.view.EBusinessProtocolView.f
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    if (this.a.G1) {
                        return;
                    }
                    this.a.G1 = true;
                    this.a.C1.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08083e, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
                } else if (this.a.G1) {
                    this.a.G1 = false;
                    this.a.C1.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080a2f, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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
                this.a.s6();
            }
        }
    }

    /* loaded from: classes6.dex */
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
                if (this.a.W0) {
                    this.a.W0 = false;
                    bx4 k = bx4.k();
                    k.u("key_write_virtual_image_enable" + TbadkCoreApplication.getCurrentAccount(), this.a.W0);
                    WriteActivity writeActivity = this.a;
                    writeActivity.p.setShowCustomFigure(writeActivity.W0);
                    this.a.w6();
                }
                this.a.I1.setVisibility(8);
            }
        }
    }

    /* loaded from: classes6.dex */
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
                TiebaStatic.log(new StatisticItem("c13013").param("fid", this.a.p.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                this.a.J.setVisibility(0);
                this.a.M.setSelected(true);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.a.L, R.drawable.obfuscated_res_0x7f08094f, R.color.CAM_X0105, null);
                WriteActivity writeActivity = this.a;
                ih.l(writeActivity.K, view2, 0, ej.d(writeActivity.getPageContext().getPageActivity(), 1.0f));
                this.a.S.q();
                WriteActivity writeActivity2 = this.a;
                writeActivity2.HidenSoftKeyPad(writeActivity2.T, writeActivity2.A);
                WriteActivity writeActivity3 = this.a;
                writeActivity3.HidenSoftKeyPad(writeActivity3.T, writeActivity3.E);
            }
        }
    }

    /* loaded from: classes6.dex */
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
                this.a.T4("6");
                this.a.I1.setVisibility(8);
            }
        }
    }

    /* loaded from: classes6.dex */
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
            Map map;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage.getError() == 0 && (map = (Map) MessageManager.getInstance().runTask(2001284, Map.class, httpResponsedMessage).getData()) != null) {
                String str = (String) map.get("b_url");
                String str2 = (String) map.get("dynamic_url");
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.a.t0)) {
                    this.a.t0 = str;
                    this.a.u0 = str2;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes(str2);
                    this.a.a6(true);
                } else if (TextUtils.isEmpty(str) || str.equals(this.a.t0)) {
                } else {
                    this.a.t0 = str;
                    this.a.u0 = str2;
                    TbadkCoreApplication.getInst().setDefaultBubble(this.a.t0);
                    TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes(this.a.u0);
                    this.a.a6(true);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class v0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v0(WriteActivity writeActivity, int i) {
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
            this.a.p5(selectForumData);
        }
    }

    /* loaded from: classes6.dex */
    public class w implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log(new StatisticItem("c13013").param("fid", this.a.p.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                this.a.J.setSelected(true);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.a.L, R.drawable.obfuscated_res_0x7f08094f, R.color.CAM_X0105, null);
                WriteActivity writeActivity = this.a;
                ih.l(writeActivity.K, view2, 0, ej.d(writeActivity.getPageContext().getPageActivity(), 1.0f));
                this.a.S.q();
                WriteActivity writeActivity2 = this.a;
                writeActivity2.HidenSoftKeyPad(writeActivity2.T, writeActivity2.W1());
                WriteActivity writeActivity3 = this.a;
                writeActivity3.HidenSoftKeyPad(writeActivity3.T, writeActivity3.V1());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class w0 implements WriteTipBubbleController.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public w0(WriteActivity writeActivity) {
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
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, view2, str) == null) || this.a.a1 == null) {
                return;
            }
            TiebaStatic.log("c13802");
            this.a.a1.c();
            UtilHelper.clearClipBoard();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddLinkActivityConfig(this.a.getActivity(), 25049, str, false, null)));
        }
    }

    /* loaded from: classes6.dex */
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
                g39.b(1);
                if (this.a.t4()) {
                    return;
                }
                SpanGroupEditText spanGroupEditText = this.a.E;
                if (spanGroupEditText != null && spanGroupEditText.getText() != null && this.a.E.getText().toString() != null) {
                    if (this.a.E.getText().toString().length() > 1000) {
                        WriteActivity writeActivity = this.a;
                        writeActivity.showToast(writeActivity.getResources().getString(R.string.obfuscated_res_0x7f0f0ef1));
                        return;
                    } else if (this.a.E.getText().toString().contains("ܷ") || this.a.E.getText().toString().contains("ܶ")) {
                        WriteActivity writeActivity2 = this.a;
                        writeActivity2.showToast(writeActivity2.getResources().getString(R.string.obfuscated_res_0x7f0f0ef0));
                        return;
                    }
                }
                if (this.a.q1 || (!TextUtils.isEmpty(this.a.A.getText().toString()) && this.a.A.getText().toString().trim().length() >= 5)) {
                    if (!this.a.u4()) {
                        if (this.a.q4()) {
                            if (!this.a.H1 || this.a.G1) {
                                if (this.a.s4()) {
                                    int v4 = this.a.v4();
                                    if (v4 == 1) {
                                        this.a.showToast(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1452));
                                        return;
                                    } else if (v4 == 2) {
                                        this.a.showToast(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1453));
                                        return;
                                    }
                                }
                                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c59);
                                }
                                if (xh5.a()) {
                                    return;
                                }
                                WriteActivity writeActivity3 = this.a;
                                if (writeActivity3.a.b(writeActivity3.A, writeActivity3.E)) {
                                    WriteActivity writeActivity4 = this.a;
                                    writeActivity4.showToast(writeActivity4.a.e());
                                    return;
                                }
                                WriteActivity writeActivity5 = this.a;
                                writeActivity5.HidenSoftKeyPad(writeActivity5.T, writeActivity5.W1());
                                WriteActivity writeActivity6 = this.a;
                                writeActivity6.HidenSoftKeyPad(writeActivity6.T, writeActivity6.V1());
                                this.a.S.q();
                                this.a.X5();
                                MercatorModel.d().f();
                                return;
                            }
                            WriteActivity writeActivity7 = this.a;
                            writeActivity7.showToast(writeActivity7.getResources().getString(R.string.obfuscated_res_0x7f0f0f57));
                            return;
                        }
                        this.a.showToast(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f144d));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectForumConfig(this.a)));
                    return;
                }
                BdTopToast bdTopToast = new BdTopToast(this.a, 3000);
                bdTopToast.h(false);
                if (this.a.O0) {
                    string = this.a.getString(R.string.obfuscated_res_0x7f0f0f94);
                } else {
                    string = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1441);
                }
                bdTopToast.g(string);
                bdTopToast.i((ViewGroup) this.a.v);
            }
        }
    }

    /* loaded from: classes6.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage instanceof BackgroundSwitchMessage) || ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                return;
            }
            this.a.r4();
        }
    }

    /* loaded from: classes6.dex */
    public class y implements k29.c {
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

        @Override // com.baidu.tieba.k29.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ej.N(TbadkCoreApplication.getInst(), String.format(this.a.getString(R.string.obfuscated_res_0x7f0f15f8), 31));
            }
        }
    }

    /* loaded from: classes6.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.a.w4();
                this.a.setResult(100);
                this.a.finish();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class z implements RichImageItem.f {
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

        @Override // com.baidu.tieba.write.view.xrichtext.RichImageItem.f
        public void a(ImageFileInfo imageFileInfo, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, imageFileInfo, view2) == null) {
                if (ListUtils.isEmpty(this.a.q.getChosedFiles())) {
                    this.a.v2();
                }
                this.a.c6();
                this.a.h6();
            }
        }

        @Override // com.baidu.tieba.write.view.xrichtext.RichImageItem.f
        public void b(ImageFileInfo imageFileInfo, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageFileInfo, view2) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class z0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z0(WriteActivity writeActivity, int i) {
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
                this.a.o6((EvaluateRelevanceItemSelectedMessage) customResponsedMessage);
            }
        }
    }

    public WriteActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.t0 = null;
        this.u0 = null;
        this.E0 = null;
        this.F0 = false;
        this.G0 = true;
        this.T0 = 0;
        this.U0 = false;
        this.X0 = "";
        this.Y0 = false;
        this.t1 = true;
        this.u1 = false;
        this.v1 = null;
        this.x1 = false;
        this.z1 = new k(this);
        this.G1 = false;
        this.H1 = false;
        this.J1 = new v(this, CmdConfigHttp.REQUEST_BUBBLELIST_CMD);
        this.K1 = new g0(this);
        this.L1 = new r0(this, 2921494);
        this.M1 = new v0(this, 2921505);
        this.N1 = new w0(this);
        this.R1 = new x0(this, 2001011);
        this.S1 = new y0(this, 2921622);
        this.T1 = new z0(this, 2921516);
        this.U1 = new a(this);
        this.V1 = false;
        this.W1 = 0;
        this.X1 = new d0(this);
        this.Y1 = new h0(this);
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void A2(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, postWriteCallBackData) == null) {
            if (WriteActivityConfig.FROM_ADD_PHOTO_LIVE_IN_MISSON.equals(this.f)) {
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUCCES_IN_MISSON);
            }
            super.A2(postWriteCallBackData);
        }
    }

    public final void A4(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, editable) == null) {
            if (editable.length() > 500) {
                this.j1.setText((500 - editable.length()) + "/500");
                this.j1.setVisibility(0);
                return;
            }
            this.j1.setVisibility(4);
        }
    }

    public final boolean A5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? !this.M0 && this.L0 : invokeV.booleanValue;
    }

    public void A6(WriteVoteData writeVoteData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, writeVoteData) == null) {
            this.p.setWriteVoteData(writeVoteData);
        }
    }

    public final void B4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            new j0(this).execute(new Void[0]);
        }
    }

    public final boolean B5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.R0 || !"2".equals(this.k) || !this.L0 || this.q1 || this.O0) ? false : true : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void C2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            String string = getPageContext().getString(R.string.obfuscated_res_0x7f0f112c);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.f)) {
                string = getPageContext().getString(R.string.obfuscated_res_0x7f0f1146);
            }
            TextView addTextButton = this.w.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, string);
            this.y = addTextButton;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) addTextButton.getLayoutParams();
            layoutParams.rightMargin = ej.f(getPageContext().getPageActivity(), R.dimen.tbds2);
            this.y.setLayoutParams(layoutParams);
            this.y.setOnFocusChangeListener(this.d0);
        }
    }

    public final void C4() {
        g55 g55Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            VoiceData.VoiceModel voiceModel = this.h0;
            if (voiceModel != null) {
                kz4.a(kz4.b(voiceModel.voiceId));
            }
            this.h0 = null;
            this.p.setVoiceModel(null);
            this.z0.setVisibility(8);
            this.A0.p();
            this.A0.setVoiceModel(null);
            f55 n2 = this.S.n(6);
            if (n2 != null && (g55Var = n2.m) != null) {
                g55Var.B(new u45(52, 0, null));
            }
            v2();
        }
    }

    public final void C5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            QuestionTagChooseActivityConfig questionTagChooseActivityConfig = new QuestionTagChooseActivityConfig(this);
            questionTagChooseActivityConfig.setCategory(this.P0);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, questionTagChooseActivityConfig));
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public boolean D2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (this.q1 || this.O0) ? false : true : invokeV.booleanValue;
    }

    public final void D4(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, writeData) == null) {
            this.p.setContent(writeData.getContent());
            SpannableString t2 = TbFaceManager.i().t(getPageContext().getPageActivity(), this.p.getContent(), this.Y);
            InputFilter[] filters = this.E.getFilters();
            this.E.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50000)});
            V1().setText(t2);
            EditText V1 = V1();
            SpanGroupEditText spanGroupEditText = this.E;
            if (V1 == spanGroupEditText && spanGroupEditText.getSpanGroupManager() != null) {
                this.E.i();
                this.E.getSpanGroupManager().t();
                this.E.c();
                e6();
            }
            this.E.setFilters(filters);
            if (V1().getText() != null) {
                V1().setSelection(V1().getText().length());
            }
        }
    }

    public final void D5() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || WriteActivityConfig.isAsyncWriting() || this.p == null) {
            return;
        }
        WriteActivityConfig.newInstance(getActivity()).setType(9).setForumId(TextUtils.isEmpty(this.p.getForumId()) ? "0" : this.p.getForumId()).setForumName(this.p.getForumName()).setEnableAudio(this.G0).setAudioMsg(this.e).setCanGoods(this.U0).setPrefixData(this.d).setPrivateThread(this.j).setForumDir(this.p.getFirstDir(), this.p.getSecondDir()).setProfessionZone(this.p.getProZone()).setFrsTabInfo(this.r).setCallFrom(this.k).setStatisticFrom(this.p.getStatisticFrom()).setIsEvaluate(true).setScoreItemInfo(this.p1).setStarCount(this.s1).setFrom(this.f).send();
        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED);
        statisticItem.param("obj_locate", "main_tab".equals(this.f) ? 8 : 2);
        statisticItem.param("obj_type", 6);
        TiebaStatic.log(statisticItem);
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void E1(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, editable) == null) {
            super.E1(editable);
            if (this.q1) {
                b4(editable);
            } else if (this.O0) {
                O5(editable);
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public boolean E2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? !this.O0 : invokeV.booleanValue;
    }

    public final void E4(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, writeData) == null) {
            if ((this.M0 && this.L0) || A5()) {
                this.p.setRichContentData(writeData.getRichContentData());
                this.r0.s(writeData.getRichContentData());
            }
        }
    }

    public final void E5(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i2) == null) || this.q == null || this.p == null) {
            return;
        }
        AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(getPageContext().getPageActivity(), this.q.toJsonString(), true, true);
        albumFloatActivityConfig.getIntent().putExtra("forum_id", this.p.getForumId());
        albumFloatActivityConfig.getIntent().putExtra("forum_name", this.p.getForumName());
        albumFloatActivityConfig.getIntent().putExtra("from", this.f);
        albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
        albumFloatActivityConfig.setAlbumThread(i2);
        albumFloatActivityConfig.setCanSelectVideo(false);
        albumFloatActivityConfig.setCanSelectOnlyVideo(false);
        albumFloatActivityConfig.setCanEditImage(false);
        albumFloatActivityConfig.setFromWrite(3);
        albumFloatActivityConfig.setCallFrom(this.k);
        albumFloatActivityConfig.setStatisticFrom(this.p.getStatisticFrom());
        albumFloatActivityConfig.setProfessionZone(this.p.getProZone());
        albumFloatActivityConfig.setFrsTabInfo(this.r);
        AntiData antiData = new AntiData();
        antiData.voice_message = this.e;
        antiData.setIfVoice(this.G0);
        albumFloatActivityConfig.setExtraData(antiData, this.d, this.p.getFirstDir(), this.p.getSecondDir());
        sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void F1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.F1();
            j6();
            this.E.requestFocus();
            k4();
            this.U1.setPriority(1);
            registerResponsedEventListener(GoodsEvent.class, this.U1);
            h5();
            if (this.u1) {
                D4(this.p);
                v2();
                d5();
            }
            J5();
            K5();
        }
    }

    public final void F4(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, writeData) == null) {
            if (dj.isEmpty(this.p.getTitle())) {
                this.p.setTitle(writeData.getTitle());
            }
            SpannableString i2 = ug5.i(this.p.getTitle());
            if (i2 != null) {
                W1().setText(i2);
                int length = this.p.getTitle().length() > i2.length() ? i2.length() : this.p.getTitle().length();
                if (length > W1().getText().length()) {
                    length = W1().getText().length();
                }
                W1().setSelection(length);
            }
        }
    }

    public final void F5() {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (writeImagesInfo = this.q) == null || this.p == null) {
            return;
        }
        JSONObject json = writeImagesInfo.toJson();
        String str = null;
        if (json != null) {
            try {
                json.put("maxImagesAllowed", 9 - this.q.size());
                json.put("chosedFiles", (Object) null);
                str = json.toString();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(getPageContext().getPageActivity(), str, true, true);
        albumFloatActivityConfig.getIntent().putExtra("forum_id", this.p.getForumId());
        albumFloatActivityConfig.getIntent().putExtra("forum_name", this.p.getForumName());
        albumFloatActivityConfig.getIntent().putExtra("from", this.f);
        albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
        albumFloatActivityConfig.setAlbumThread(0);
        albumFloatActivityConfig.setCanSelectVideo(false);
        albumFloatActivityConfig.setCanSelectOnlyVideo(false);
        albumFloatActivityConfig.setCanEditImage(false);
        albumFloatActivityConfig.setFromWrite(3);
        albumFloatActivityConfig.setCallFrom(this.k);
        albumFloatActivityConfig.setStatisticFrom(this.p.getStatisticFrom());
        albumFloatActivityConfig.setProfessionZone(this.p.getProZone());
        albumFloatActivityConfig.setFrsTabInfo(this.r);
        AntiData antiData = new AntiData();
        antiData.voice_message = this.e;
        antiData.setIfVoice(this.G0);
        albumFloatActivityConfig.setExtraData(antiData, this.d, this.p.getFirstDir(), this.p.getSecondDir());
        sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void G1(Editable editable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, editable) == null) && this.O0) {
            P5(editable);
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public boolean G2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void G4(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, writeData) == null) {
            if (writeData.getWriteImagesInfo() != null) {
                this.q = writeData.getWriteImagesInfo();
            }
            this.p.setWriteImagesInfo(this.q);
            this.r0.setWriteImagesInfo(this.q);
            if (this.q.getChosedFiles() != null && this.q.getChosedFiles().size() > 0) {
                z2();
            }
            f6(false);
            r6(true, true);
        }
    }

    public final void G5(int i2) {
        WriteImagesInfo writeImagesInfo;
        int size;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048598, this, i2) == null) || (writeImagesInfo = this.q) == null || writeImagesInfo.getChosedFiles() == null || (size = this.q.getChosedFiles().size()) < 1 || i2 < 0 || i2 >= size) {
            return;
        }
        sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.q, i2)));
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void H1(CharSequence charSequence, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048599, this, charSequence, i2, i3, i4) == null) {
            this.E.f(i2, i3, i4);
        }
    }

    public final void H4(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, intent) == null) {
            P4(intent, true);
        }
    }

    public final void H5(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048601, this, i2) == null) || this.q == null || this.p == null) {
            return;
        }
        AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(getPageContext().getPageActivity(), this.q.toJsonString(), true, true);
        albumFloatActivityConfig.getIntent().putExtra("forum_id", this.p.getForumId());
        albumFloatActivityConfig.getIntent().putExtra("forum_name", this.p.getForumName());
        albumFloatActivityConfig.getIntent().putExtra("from", this.f);
        albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
        albumFloatActivityConfig.setAlbumThread(i2);
        albumFloatActivityConfig.setCanSelectVideo(true);
        albumFloatActivityConfig.setCanSelectOnlyVideo(true);
        albumFloatActivityConfig.setCanEditImage(false);
        albumFloatActivityConfig.setFromWrite(3);
        albumFloatActivityConfig.setCallFrom(this.k);
        albumFloatActivityConfig.setStatisticFrom(this.p.getStatisticFrom());
        albumFloatActivityConfig.setProfessionZone(this.p.getProZone());
        albumFloatActivityConfig.setFrsTabInfo(this.r);
        if (this.A.getText().toString() != null) {
            albumFloatActivityConfig.setVideoTitle(this.A.getText().toString());
        } else {
            albumFloatActivityConfig.setVideoTitle(this.s);
        }
        albumFloatActivityConfig.setBarName(this.p.getForumName());
        albumFloatActivityConfig.setBarID(this.p.getForumId());
        if (this.h1 == null && this.p.getForumName() != null) {
            albumFloatActivityConfig.setCanChangeBarName(false);
        } else {
            albumFloatActivityConfig.setCanChangeBarName(true);
        }
        albumFloatActivityConfig.setVideoAbstract(this.E.getText().toString());
        AntiData antiData = new AntiData();
        antiData.voice_message = this.e;
        antiData.setIfVoice(this.G0);
        albumFloatActivityConfig.setExtraData(antiData, this.d, this.p.getFirstDir(), this.p.getSecondDir());
        sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void I1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.I1();
            if (this.x1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921583));
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void I2() {
        WriteData writeData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (writeData = this.p) == null) {
            return;
        }
        if (writeData.getType() != 9) {
            this.z.setText(R.string.obfuscated_res_0x7f0f112e);
            this.E.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
            this.A.setVisibility(8);
            return;
        }
        this.E.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
        if (this.R0) {
            this.z.setText(R.string.obfuscated_res_0x7f0f0efe);
        } else if (this.M0) {
            if (this.L0) {
                this.z.setText(R.string.obfuscated_res_0x7f0f102e);
            } else {
                this.z.setText(R.string.obfuscated_res_0x7f0f0c6b);
            }
        } else {
            String str = this.k;
            if (str != null && str.equals("1")) {
                this.z.setText(R.string.obfuscated_res_0x7f0f0f02);
            } else {
                String str2 = this.k;
                if (str2 != null && str2.equals("2")) {
                    if (this.q1) {
                        this.z.setText(R.string.obfuscated_res_0x7f0f0f54);
                    } else if (A5()) {
                        this.z.setText(R.string.obfuscated_res_0x7f0f0eee);
                    } else if (this.O0) {
                        this.z.setText(R.string.obfuscated_res_0x7f0f0f03);
                        this.E.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
                    } else {
                        this.z.setText(R.string.obfuscated_res_0x7f0f0f04);
                    }
                } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.f)) {
                    this.z.setText(getResources().getString(R.string.share_to) + this.p.getForumName() + getResources().getString(R.string.obfuscated_res_0x7f0f02de));
                    this.A.setVisibility(8);
                    String str3 = this.c1 + " " + this.d1;
                    if (!StringUtils.isNull(str3)) {
                        this.E.setText(str3);
                    }
                } else {
                    this.z.setText("");
                }
            }
        }
        this.A.setVisibility(0);
    }

    public final void I4(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, intent) == null) || intent == null) {
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
                    this.q.addChooseFile(imageFileInfo);
                    w5(imageFileInfo);
                }
            }
            c6();
            h6();
            if (this.q.getChosedFiles() != null) {
                z2();
            }
        }
        f6(true);
    }

    public final void I5(WriteVoteData writeVoteData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, writeVoteData) == null) {
            WriteVoteActivityConfig writeVoteActivityConfig = new WriteVoteActivityConfig(getPageContext().getPageActivity(), 25048);
            if (writeVoteData != null) {
                writeVoteActivityConfig.setExtraData(writeVoteData);
            }
            sendMessage(new CustomMessage(2002001, writeVoteActivityConfig));
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void J1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            super.J1();
            z6();
            this.V1 = true;
        }
    }

    public final void J4(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, intent) == null) {
            this.H0 = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
            String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.H0;
            if (!TextUtils.isEmpty(str)) {
                try {
                    int readPictureDegree = BitmapHelper.readPictureDegree(str);
                    if (readPictureDegree != 0) {
                        Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, ej.d(getPageContext().getPageActivity(), ej.k(getPageContext().getPageActivity())), ej.d(getPageContext().getPageActivity(), ej.i(getPageContext().getPageActivity())));
                        Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                        if (loadResizedBitmap != rotateBitmapBydegree) {
                            loadResizedBitmap.recycle();
                        }
                        FileHelper.saveBitmapByRelativelyPath(TbConfig.LOCAL_CAMERA_DIR, this.H0, rotateBitmapBydegree, 100);
                        rotateBitmapBydegree.recycle();
                    }
                } catch (Exception unused) {
                }
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(str);
                imageFileInfo.setTempFile(true);
                this.q.addChooseFile(imageFileInfo);
                this.q.updateQuality();
                Y3(imageFileInfo);
                c6();
                h6();
                z2();
            }
            f6(true);
        }
    }

    public final void J5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            if (this.p.getType() == 9) {
                if (this.t1) {
                    if (this.p.isLocalChannelDynamic()) {
                        yl8.l(this);
                    } else if (this.p.isQuestionThread()) {
                        yl8.p(this.p.getForumId(), this);
                    } else if (this.p.isEvaluate()) {
                        yl8.j(this.p.getItem_id(), this);
                    } else if (TextUtils.isEmpty(this.p.getTopicId())) {
                        yl8.k(this.p.getForumId(), this);
                    } else {
                        yl8.r(this.p.getTopicId(), this);
                    }
                }
            } else if (this.p.getType() == 1) {
                yl8.o(this.p.getThreadId(), this);
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void K1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, bundle) == null) {
            super.K1(bundle);
            if (bundle != null) {
                this.R0 = bundle.getBoolean(WriteActivityConfig.KEY_POST_LOCAL_CHANNEL_DYNAMIC);
                this.S0 = bundle.getString(WriteActivityConfig.KEY_LOCAL_CHANNEL_TOPIC);
            } else if (getIntent() != null) {
                Intent intent = getIntent();
                this.R0 = intent.getBooleanExtra(WriteActivityConfig.KEY_POST_LOCAL_CHANNEL_DYNAMIC, false);
                this.S0 = intent.getStringExtra(WriteActivityConfig.KEY_LOCAL_CHANNEL_TOPIC);
            }
        }
    }

    public final void K4(@Nullable Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, intent) == null) || intent == null) {
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
                    this.q.addChooseFile(imageFileInfo);
                    w5(imageFileInfo);
                }
            }
            c6();
            h6();
            if (this.q.getChosedFiles() != null) {
                z2();
            }
        }
        f6(true);
    }

    public final void K5() {
        WriteData writeData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || (writeData = this.p) == null) {
            return;
        }
        int i2 = -1;
        if (writeData.getType() == 9) {
            if (y5()) {
                i2 = 4;
            } else if (z5()) {
                i2 = 1;
            } else if (B5()) {
                i2 = 2;
            } else if (this.O0) {
                i2 = 5;
            }
        }
        g39.a(i2);
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public boolean L1(WriteData writeData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, writeData)) == null) ? m4(writeData) || WriteActivityConfig.FROM_FORUM_SHARE.equals(this.f) : invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void L2(View view2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048613, this, view2, z2) == null) {
            super.L2(view2, z2);
            if (view2 != this.E && (view2 instanceof SpanGroupEditText)) {
                Object tag = view2.getTag(R.id.obfuscated_res_0x7f09103c);
                if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue() && z2) {
                    this.l = false;
                    M1();
                    ej.L(getActivity(), view2);
                    EditorTools editorTools = this.S;
                    if (editorTools != null) {
                        editorTools.q();
                    }
                }
            }
            if (this.O0) {
                if (z2 && (view2 == this.A || view2 == this.E)) {
                    getWindow().setSoftInputMode(16);
                } else {
                    getWindow().setSoftInputMode(48);
                }
            }
        }
    }

    public final String L4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            ArrayList arrayList = new ArrayList();
            WriteEvaluationHeaderView writeEvaluationHeaderView = this.i1;
            arrayList.add(new HeadItem("", String.valueOf(writeEvaluationHeaderView != null ? writeEvaluationHeaderView.getStarCount() : 0), 2));
            return new Gson().toJson(arrayList);
        }
        return (String) invokeV.objValue;
    }

    public void L5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            if (!s4()) {
                BdToast b2 = BdToast.b(this, getString(R.string.obfuscated_res_0x7f0f0efa));
                b2.f(BdToast.ToastIcon.FAILURE);
                b2.i();
            } else if (!this.U0) {
                BdToast b3 = BdToast.b(this, getString(R.string.obfuscated_res_0x7f0f0efb));
                b3.f(BdToast.ToastIcon.FAILURE);
                b3.i();
            } else {
                if (this.p != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_COMMODITY_ENTRANCE_CLICK).param("obj_locate", 2).param("fid", this.p.getForumId()).param("fname", this.p.getForumName()));
                }
                if (!bx4.k().h("commodity_goods_show_first_dialog", false)) {
                    au4 au4Var = new au4(getPageContext().getPageActivity());
                    au4Var.setContentViewSize(2);
                    au4Var.setCanceledOnTouchOutside(false);
                    FrsPublishFineGoodsDialogView frsPublishFineGoodsDialogView = new FrsPublishFineGoodsDialogView(getPageContext().getPageActivity());
                    frsPublishFineGoodsDialogView.setConfirmButtonListener(new m0(this, au4Var));
                    au4Var.setContentView(frsPublishFineGoodsDialogView);
                    StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_WRITE_GOODS_NEW_DIALOG_SHOW).param("obj_locate", 2);
                    WriteData writeData = this.p;
                    StatisticItem param2 = param.param("fid", writeData != null ? writeData.getForumId() : "");
                    WriteData writeData2 = this.p;
                    TiebaStatic.log(param2.param("fname", writeData2 != null ? writeData2.getForumName() : ""));
                    au4Var.create(getPageContext()).show();
                    return;
                }
                String uk = TbadkCoreApplication.getCurrentAccountInfo().getUk();
                MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + uk + "&max=" + R4()));
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void M1() {
        t55 t55Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            super.M1();
            EditorTools editorTools = this.S;
            if (editorTools != null) {
                boolean z2 = true;
                editorTools.setDeskLauncherEnabled(!this.l);
                this.S.setToolEnabled(!this.A.hasFocus(), 2);
                this.S.setToolEnabled(!this.A.hasFocus(), 30);
                this.S.setToolEnabled(false, 34);
                if (this.R0 || this.A.hasFocus()) {
                    this.S.setToolEnabled(false, 31);
                }
                f55 n2 = this.S.n(5);
                if (n2 != null) {
                    n2.d(true);
                }
                y19 y19Var = this.U;
                if (y19Var != null && !this.R0 && !this.O0) {
                    y19Var.n(true);
                }
                c6();
                h6();
                d6();
                b6();
                i6();
                if (this.q1 && (t55Var = this.Q1) != null && !t55Var.c()) {
                    this.S.setToolEnabled(false, 31);
                } else {
                    this.S.setToolEnabled((this.L0 || this.A.hasFocus()) ? false : true, 31);
                }
                this.S.setToolEnabled((this.L0 || this.A.hasFocus()) ? false : false, 6);
            }
        }
    }

    public final String M4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? (V1() == null || V1().getText() == null) ? "" : V1().getText().toString() : (String) invokeV.objValue;
    }

    public final void M5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            if (!this.p.canAddItem()) {
                ej.M(getActivity(), R.string.obfuscated_res_0x7f0f1619);
                return;
            }
            RelevanceItemSearchActivityConfig relevanceItemSearchActivityConfig = new RelevanceItemSearchActivityConfig(getActivity(), 0);
            relevanceItemSearchActivityConfig.setSelectedIds(this.p.getItemDataIds());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, relevanceItemSearchActivityConfig));
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public boolean N1(PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, postWriteCallBackData)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void N4(@Nullable Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048620, this, intent) == null) || intent == null) {
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
                this.q.getChosedFiles().remove(originalImgIndex);
                this.q.getChosedFiles().add(originalImgIndex, imageFileInfo);
                this.r0.p(imageFileInfo, writeImagesInfo.getOriginalImgViewIndex());
                c6();
                h6();
                if (this.q.getChosedFiles() != null) {
                    z2();
                }
            }
        }
        f6(true);
    }

    public final void N5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            this.E.setVisibility(0);
            this.r0.setVisibility(8);
            d39 d39Var = this.K0;
            if (d39Var != null) {
                d39Var.s(false);
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void O1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            super.O1();
            this.S.setMoreVipIcon(A5());
            this.S.setShouldShowMorePopTip(!this.R0);
            c5();
        }
    }

    public final void O4(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, intent) == null) {
            P4(intent, false);
        }
    }

    public final void O5(Editable editable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048624, this, editable) == null) || this.w0 == null) {
            return;
        }
        if (!TextUtils.isEmpty(editable)) {
            SpannableString spannableString = new SpannableString(getString(R.string.obfuscated_res_0x7f0f090d, new Object[]{Integer.valueOf(editable.length()), 500}));
            if (editable.length() > 500) {
                spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301)), 0, String.valueOf(editable.length()).length(), 17);
            }
            this.w0.setText(spannableString);
            return;
        }
        this.w0.setText(getString(R.string.obfuscated_res_0x7f0f090d, new Object[]{0, 500}));
    }

    public final void P4(Intent intent, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048625, this, intent, z2) == null) || intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            this.q.parseJson(stringExtra);
            this.q.updateQuality();
            c6();
            h6();
            if (this.q.getChosedFiles() != null) {
                z2();
            }
        }
        f6(true);
    }

    public final void P5(Editable editable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048626, this, editable) == null) || this.v0 == null) {
            return;
        }
        if (!TextUtils.isEmpty(editable)) {
            SpannableString spannableString = new SpannableString(getString(R.string.obfuscated_res_0x7f0f090d, new Object[]{Integer.valueOf(editable.length()), 31}));
            if (editable.length() > 31) {
                spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301)), 0, String.valueOf(editable.length()).length(), 17);
            }
            this.v0.setText(spannableString);
            return;
        }
        this.v0.setText(getString(R.string.obfuscated_res_0x7f0f090d, new Object[]{0, 31}));
    }

    public final int Q4(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048627, this, new Object[]{Double.valueOf(d2)})) == null) ? (int) ((d2 + 1.0d) / 2.0d) : invokeCommon.intValue;
    }

    public final void Q5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            this.E.setVisibility(8);
            this.r0.setVisibility(0);
            d39 d39Var = this.K0;
            if (d39Var != null) {
                d39Var.s(true);
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public boolean R1(@NonNull PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, postWriteCallBackData)) == null) ? !st8.d(postWriteCallBackData.getErrorCode()) : invokeL.booleanValue;
    }

    public final int R4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            SpanGroupEditText spanGroupEditText = this.E;
            if (spanGroupEditText == null || spanGroupEditText.getSpanGroupManager() == null) {
                return 10;
            }
            return 10 - this.E.getSpanGroupManager().z();
        }
        return invokeV.intValue;
    }

    public final void R5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            ForumTagInfo forumTagInfo = this.Q0;
            if (forumTagInfo != null) {
                WriteData writeData = this.p;
                if (writeData != null) {
                    writeData.setQuestionTagId(forumTagInfo.id);
                    this.p.setQuestionTagManualCreated(false);
                }
                this.y0.setSubTitle(this.Q0.name);
                this.y0.a();
                return;
            }
            WriteData writeData2 = this.p;
            if (writeData2 != null) {
                writeData2.setQuestionTagId(null);
                this.p.setQuestionTagManualCreated(false);
            }
            this.y0.setSubTitle(null);
            this.y0.e();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void S1(AtListActivityConfig atListActivityConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, atListActivityConfig) == null) {
            if (this.M0 && this.L0) {
                atListActivityConfig.setSelectedAtList(this.r0.getAtDataInText());
            } else if (V1() instanceof SpanGroupEditText) {
                atListActivityConfig.setSelectedAtList(((SpanGroupEditText) V1()).getAtDataInText());
            }
        }
    }

    public final String S4() {
        InterceptResult invokeV;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            if (this.p == null || W1() == null || W1().getVisibility() != 0 || W1().getText() == null) {
                return "";
            }
            String obj = W1().getText().toString();
            PostPrefixData postPrefixData = this.d;
            if (postPrefixData != null && ListUtils.getCount(postPrefixData.getPrefixs()) > 0 && this.i != ListUtils.getCount(this.d.getPrefixs()) - 1 && (textView = this.J) != null && textView.getText() != null) {
                this.p.setPostPrefix(this.J.getText().toString());
            }
            PostPrefixData postPrefixData2 = this.d;
            if (postPrefixData2 == null || StringUtils.isNull(postPrefixData2.getImplicitTitle())) {
                return obj;
            }
            return this.d.getImplicitTitle() + this.p.getTitle();
        }
        return (String) invokeV.objValue;
    }

    public void S5(u45 u45Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, u45Var) == null) {
            if (this.S.u()) {
                this.S.q();
            }
            if (this.L0) {
                F5();
            } else {
                E5(0);
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity, com.baidu.tieba.h19.a
    public void T0(int i2) {
        PostPrefixData postPrefixData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048635, this, i2) == null) || (postPrefixData = this.d) == null) {
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
    public int T1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? R.color.CAM_X0201 : invokeV.intValue;
    }

    public final void T4(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, str) == null) {
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
                urlManager.dealOneLink(pageContext, new String[]{"https://tieba.baidu.com/mo/q/hybrid-main-service/virtualAvatar?customfullscreen=1&nonavigationbar=1" + str2 + ("&from=" + str)});
            } catch (Exception e2) {
                BdLog.e("openPageByUrl fail:" + e2.toString());
            }
        }
    }

    public void T5(u45 u45Var) {
        String str;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, u45Var) == null) {
            if (this.S.u()) {
                this.S.q();
            }
            int a2 = j19.a();
            if (j19.c(a2)) {
                j19.e(getPageContext().getPageActivity(), a2, WorkPublishOpenHelper.OPEN_WORK_PUBLISH_FROM_FRS_WRITE);
            } else if (j19.b()) {
                if (this.q == null || this.p == null) {
                    return;
                }
                if (this.A.getText().toString() != null) {
                    str = this.A.getText().toString();
                    i2 = 5;
                } else {
                    str = this.s;
                    i2 = 1;
                }
                if (this.h1 == null && this.p.getForumName() != null) {
                    j19.f(getPageContext(), str, this.E.getText().toString(), this.p.getForumId(), this.p.getForumName(), 3, Boolean.FALSE, "", "", "");
                } else {
                    j19.f(getPageContext(), str, this.E.getText().toString(), this.p.getForumId(), this.p.getForumName(), i2, Boolean.TRUE, "", "", "");
                }
            } else {
                H5(0);
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public int U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? A5() ? 3 : 5 : invokeV.intValue;
    }

    public final boolean U4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            c69 c69Var = this.n1;
            return (c69Var == null || this.o1 == null || c69Var.c() == null || this.o1.getVisibility() != 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void U5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, str) == null) {
            this.E1 = new ArrayList();
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
                    this.E1.add(lv6.g(jSONObject));
                }
                if (this.E1.size() > 0) {
                    this.H1 = true;
                    this.E.h(this.E1, arrayList);
                    k5();
                    e6();
                    this.B1.setVisibility(0);
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public EditText V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? this.L0 ? this.r0.getLastFocusEdit() : this.E : (EditText) invokeV.objValue;
    }

    public final void V3(ItemData itemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, itemData) == null) {
            this.p.addItemData(itemData);
            this.y1.setVisibility(0);
            this.y1.a(itemData);
        }
    }

    public final void V4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048644, this) == null) {
            View view2 = this.j0;
            view2.setPadding(0, 0, 0, 0);
            view2.setBackgroundDrawable(null);
            SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
        }
    }

    public final void V5(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048645, this, z2) == null) {
            TextView textView = this.y;
            if (textView != null && ((textView.isEnabled() || this.q1 || !ListUtils.isEmpty(this.p.getItemDatas())) && ((!this.q1 || !TextUtils.isEmpty(this.E.getText()) || (this.q.getChosedFiles() != null && this.q.size() != 0)) && this.t1))) {
                if (this.m1 == null) {
                    this.m1 = new SaveDraftDialogView(this);
                    this.m1.setOnClickListener(new d(this, z2));
                }
                if (this.l1 == null) {
                    ju4 ju4Var = new ju4(getPageContext());
                    this.l1 = ju4Var;
                    ju4Var.setContentView(this.m1);
                }
                this.m1.setText(getString(R.string.obfuscated_res_0x7f0f15fc), getString(R.string.obfuscated_res_0x7f0f10a2));
                this.l1.k();
                return;
            }
            w4();
            setResult(100);
            finish();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public EditText W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) ? this.A : (EditText) invokeV.objValue;
    }

    public final void W3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            this.S.d(new h55(getActivity(), 7));
        }
    }

    public final void W4() {
        w29 w29Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048648, this) == null) || (w29Var = this.b1) == null) {
            return;
        }
        w29Var.a();
    }

    public final void W5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048649, this) == null) {
            x6();
            this.p.setContent(M4());
            Z5(S4());
            this.p.setWriteImagesInfo(this.q);
            this.r0.setWriteImagesInfo(this.q);
            c69 c69Var = this.n1;
            if (c69Var != null) {
                this.p.setWriteVoteData(c69Var.c());
            }
            WriteImagesInfo writeImagesInfo = this.q;
            if (writeImagesInfo != null && writeImagesInfo.size() > 0) {
                Iterator<ImageFileInfo> it = this.q.getChosedFiles().iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    ImageFileInfo next = it.next();
                    if (next != null && next.isFromCamera()) {
                        i2++;
                    }
                }
                this.p.setTakePhotoNum(i2);
            }
            WriteImagesInfo writeImagesInfo2 = this.q;
            if (writeImagesInfo2 != null) {
                this.I0.A(writeImagesInfo2.size() > 0);
            }
            WriteEvaluationHeaderView writeEvaluationHeaderView = this.i1;
            if (writeEvaluationHeaderView != null && writeEvaluationHeaderView.getEvaluateItemInfo() != null) {
                this.p.setItem_id(this.i1.getEvaluateItemInfo().getItemID());
                this.p.setComment_head(L4());
            }
            D1();
            this.I0.H(this.p);
            WriteData writeData = this.p;
            writeData.setContent(writeData.getContent().replaceAll("\u0000\n", ""));
            WriteData writeData2 = this.p;
            writeData2.setContent(writeData2.getContent().replaceAll("\u0000", ""));
            this.p.setVcode(null);
            this.p.setVoiceModel(this.h0);
            VoiceData.VoiceModel voiceModel = this.h0;
            if (voiceModel != null) {
                if (voiceModel.getId() != null) {
                    this.I0.o().setVoice(this.h0.getId());
                    this.I0.o().setVoiceDuringTime(this.h0.duration);
                } else {
                    this.I0.o().setVoice(null);
                    this.I0.o().setVoiceDuringTime(-1);
                }
            } else {
                this.I0.o().setVoice(null);
                this.I0.o().setVoiceDuringTime(-1);
            }
            this.p.setRichTextEditorMode(this.L0);
            if (this.L0) {
                this.p.setServerRichContent(this.r0.getPostServerContentData());
            }
            if (!this.I0.e()) {
                showToast(R.string.obfuscated_res_0x7f0f15f3);
            } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.obfuscated_res_0x7f0f0c59);
            } else if (s38.a().b() == 0 && this.W0) {
                u6();
            } else {
                w6();
            }
        }
    }

    public final void X3() {
        CustomResponsedMessage runTask;
        f55 f55Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048650, this) == null) || (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, getActivity()), f55.class)) == null || (f55Var = (f55) runTask.getData()) == null) {
            return;
        }
        f55Var.o = true;
        f55Var.l = 9;
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.f)) {
            return;
        }
        this.S.d(f55Var);
    }

    public final void X4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048651, this) == null) {
            this.H.clearFocus();
        }
    }

    public final void X5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048652, this) == null) {
            if ("1".equals(this.k)) {
                this.p.setCanNoForum(true);
                this.p.setTransmitForumData("[]");
            } else if ("2".equals(this.k)) {
                this.p.setCanNoForum(false);
            }
            w2();
            this.p.setPrivacy(this.m);
            k6();
            this.p.setToDynamic(this.V0);
            l6();
            this.p.setShowCustomFigure(this.W0);
            this.p.setCallFrom(this.k);
            if (this.p.getVideoInfo() != null) {
                TiebaStatic.log("c10063");
            }
            WriteData writeData = this.p;
            bx4 k2 = bx4.k();
            writeData.setShowCustomFigure(k2.h("key_write_virtual_image_enable" + TbadkCoreApplication.getCurrentAccount(), true));
            W5();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void Y1(CharSequence charSequence, int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048653, this, new Object[]{charSequence, Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) || this.R0) {
            return;
        }
        super.Y1(charSequence, i2, i3, str);
    }

    public final void Y3(ImageFileInfo imageFileInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048654, this, imageFileInfo) == null) && this.L0 && imageFileInfo != null) {
            w5(imageFileInfo);
        }
    }

    public final void Y4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048655, this) == null) {
            ImageView imageView = this.E0;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            TextView textView = this.z;
            if (textView != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
                layoutParams.rightMargin = this.W1;
                this.z.setLayoutParams(layoutParams);
            }
        }
    }

    public final void Y5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048656, this) == null) {
            WriteData writeData = this.p;
            if (writeData != null && writeData.getType() == 2 && this.F0) {
                finish();
            } else if (this.p == null) {
                finish();
            } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.f)) {
                finish();
            } else {
                this.p.setTitle(W1().getText().toString());
                this.p.setContent(V1().getText().toString());
                WriteEvaluationHeaderView writeEvaluationHeaderView = this.i1;
                if (writeEvaluationHeaderView != null) {
                    this.p.setEvaluationStar(writeEvaluationHeaderView.getStarCount());
                }
                this.p.setRichTextEditorMode(this.L0);
                if (this.L0) {
                    this.p.setRichContentData(this.r0.getPlainTextContentData());
                }
                this.p.setQuestionThread(this.O0);
                int type = this.p.getType();
                if (type == 9) {
                    if (this.t1) {
                        if (this.R0) {
                            yl8.v(this.p);
                        } else if (this.O0) {
                            yl8.z(this.p.getForumId(), this.p, false);
                        } else if (this.p.isEvaluate()) {
                            yl8.s(this.p.getItem_id(), this.p);
                        } else if (TextUtils.isEmpty(this.p.getTopicId())) {
                            yl8.t(this.p.getForumId(), this.p);
                        } else {
                            yl8.B(this.p.getTopicId(), this.p);
                        }
                    }
                } else if (type == 1) {
                    yl8.y(this.p.getThreadId(), this.p);
                }
                this.V1 = true;
            }
        }
    }

    public final void Z3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048657, this) == null) || WriteActivityConfig.FROM_FORUM_SHARE.equals(this.f) || this.q1) {
            return;
        }
        if (!"main_tab".equals(this.f)) {
            this.S.d(new x45(getActivity(), 10));
        }
        this.S.d(new s55(getActivity(), 11));
    }

    public final void Z4() {
        WriteImagesInfo writeImagesInfo;
        LinkedList<ImageFileInfo> chosedFiles;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048658, this) == null) || (writeImagesInfo = this.q) == null || writeImagesInfo.size() <= 0 || (chosedFiles = this.q.getChosedFiles()) == null) {
            return;
        }
        for (ImageFileInfo imageFileInfo : chosedFiles) {
            if (imageFileInfo != null) {
                w5(imageFileInfo);
            }
        }
    }

    public final void Z5(String str) {
        ConstraintLayout constraintLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048659, this, str) == null) || this.p == null || (constraintLayout = this.C) == null) {
            return;
        }
        if (constraintLayout.getVisibility() == 0) {
            if (StringUtils.isNull(str)) {
                this.p.setIsNoTitle(true);
                this.p.setTitle("");
                return;
            }
            this.p.setIsNoTitle(false);
            this.p.setTitle(str);
            return;
        }
        this.p.setIsNoTitle(true);
        this.p.setTitle("");
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void a2(Bundle bundle) {
        WriteData writeData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, bundle) == null) {
            po8 k2 = po8.k();
            this.I0 = k2;
            k2.p(this);
            super.a2(bundle);
            if (bundle != null) {
                this.p.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
                this.p.setFloorNum(bundle.getInt("floor_num", 0));
                String string = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
                this.X0 = string;
                this.p.setTopicId(string);
                this.p.setStatisticFrom(bundle.getInt(WriteActivityConfig.KEY_STATISTIS_FROM, 0));
                this.F0 = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
                this.H0 = bundle.getString(WriteActivityConfig.PHOTO_NAME);
                this.T0 = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
                this.U0 = bundle.getBoolean(WriteActivityConfig.CAN_GOODS);
                this.x1 = bundle.getBoolean(WriteActivityConfig.NEED_CLOSE_PRE_PAGE);
                this.M0 = bundle.getBoolean(WriteActivityConfig.RICH_MODE_ENABLE, false);
                this.L0 = bundle.getBoolean(WriteActivityConfig.RICH_TEXT_MODE, false);
                this.O0 = bundle.getBoolean(WriteActivityConfig.IS_QUESTION_THREAD, false);
                this.Q0 = (ForumTagInfo) bundle.getSerializable(WriteActivityConfig.FORUM_TAG_INFO);
                this.P0 = bundle.getString(WriteActivityConfig.FORUM_FIRST_CATEGORY);
            } else {
                Intent intent = getIntent();
                this.p.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
                this.p.setFloorNum(intent.getIntExtra("floor_num", 0));
                this.p.setProZone(intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
                String stringExtra = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
                this.X0 = stringExtra;
                this.p.setTopicId(stringExtra);
                this.p.setStatisticFrom(intent.getIntExtra(WriteActivityConfig.KEY_STATISTIS_FROM, 0));
                this.F0 = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
                this.e1 = intent.getStringExtra("more_forum_img");
                this.c1 = intent.getStringExtra("more_forum_title");
                this.d1 = intent.getStringExtra("more_forum_url");
                this.T0 = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
                this.p.setFrsTabInfoData(this.r);
                this.U0 = intent.getBooleanExtra(WriteActivityConfig.CAN_GOODS, false);
                this.x1 = intent.getBooleanExtra(WriteActivityConfig.NEED_CLOSE_PRE_PAGE, false);
                boolean booleanExtra = getIntent().getBooleanExtra(IntentConfig.IS_EVALUATE, false);
                this.q1 = booleanExtra;
                this.p.setIsEvaluate(booleanExtra);
                this.r1 = getIntent().getBooleanExtra(IntentConfig.IS_ITEM_DETAIL, false);
                this.s1 = getIntent().getIntExtra(WriteActivityConfig.STAR_COUNT, 0);
                Serializable serializableExtra = getIntent().getSerializableExtra(WriteActivityConfig.ITEM_INFO);
                if (serializableExtra instanceof SerializableItemInfo) {
                    SerializableItemInfo serializableItemInfo = (SerializableItemInfo) serializableExtra;
                    this.p1 = serializableItemInfo;
                    this.p.setItem_id(String.valueOf(serializableItemInfo.id));
                }
                this.t1 = getIntent().getBooleanExtra(BaseWriteConfig.IS_SAVE_DRAFTE, true);
                this.u1 = getIntent().getBooleanExtra(WriteActivityConfig.IS_FROM_ERROR_DIALOG, false);
                this.v1 = getIntent().getStringExtra(WriteActivityConfig.GOODS_LIST);
                this.w1 = intent.getSerializableExtra(IntentConfig.WRITE_VOTE_DATA);
                this.G0 = intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true);
                this.e = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
                this.M0 = intent.getBooleanExtra(WriteActivityConfig.RICH_MODE_ENABLE, false);
                this.L0 = intent.getBooleanExtra(WriteActivityConfig.RICH_TEXT_MODE, false);
                this.N0 = intent.getStringExtra(WriteActivityConfig.IS_ARTICLE);
                this.O0 = intent.getBooleanExtra(WriteActivityConfig.IS_QUESTION_THREAD, false);
                this.Q0 = (ForumTagInfo) intent.getSerializableExtra(WriteActivityConfig.FORUM_TAG_INFO);
                this.P0 = intent.getStringExtra(WriteActivityConfig.FORUM_FIRST_CATEGORY);
                if (this.u1 && (writeData = ro8.f) != null) {
                    this.p = writeData;
                    writeData.setType(9);
                    WriteData writeData2 = this.p;
                    writeData2.setContent(writeData2.getContentString());
                    this.q = this.p.getWriteImagesInfo();
                    this.r = this.p.getFrsTabInfoData();
                    if (this.p.getItemInfo() != null) {
                        this.p1 = null;
                    }
                    this.h0 = this.p.getVoiceModel();
                }
                if (UbsABTestHelper.isMainTabShowA()) {
                    this.p.setIsArticle(this.N0);
                }
            }
            PostPrefixData postPrefixData = this.d;
            if (postPrefixData != null && postPrefixData.getPrefixs().size() > 0) {
                this.d.getPrefixs().add(getPageContext().getString(R.string.obfuscated_res_0x7f0f15f7));
            }
            this.p.setLocalChannelDynamic(this.R0);
            this.p.setLocalChannelTopic(this.S0);
            this.p.setQuestionThread(this.O0);
            if (this.p.getType() == 9) {
                this.p.setEntranceType(1);
            } else if (this.p.getType() == 10) {
                this.p.setEntranceType(2);
                this.p.setType(9);
            }
            this.t0 = TbadkCoreApplication.getInst().getDefaultBubble();
            this.u0 = TbadkCoreApplication.getInst().getDefaultBubbleDynamicRes();
            this.I0.B(this.R0);
        }
    }

    public final void a4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048661, this) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            this.S.h(arrayList);
            f55 n2 = this.S.n(5);
            if (n2 != null) {
                n2.l = 5;
            }
        }
    }

    public final void a5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048662, this) == null) {
            e4();
            a4();
            W3();
            X3();
            f4();
            j4();
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void a6(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048663, this, z2) == null) || this.O0 || !TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) || V1() == null) {
            return;
        }
        this.j0.setPadding(0, 0, 0, 0);
        this.j0.setBackgroundDrawable(null);
        SkinManager.setBackgroundColor(this.j0, R.color.CAM_X0201);
        if (TextUtils.isEmpty(this.t0)) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.j0.getLayoutParams();
        if (!TextUtils.isEmpty(this.u0)) {
            layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.tbds48) * (-1);
            this.q0.setVisibility(0);
            this.q0.k(ln4.a(this.u0));
        } else {
            this.q0.setVisibility(8);
            layoutParams.topMargin = 0;
        }
        this.j0.setLayoutParams(layoutParams);
        zg.h().m(this.t0, 19, new c0(this, z2), getUniqueId());
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    @SuppressLint({"ResourceAsColor"})
    public void b2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048664, this) == null) {
            super.b2();
            int l2 = bx4.k().l("write_associate_item_hint_tip_key", 0);
            if (bx4.k().l("commodity_tip_show_controller", 0) != 0 || !this.U0) {
                q6();
                r4();
            } else if (l2 > 0) {
                p6();
            } else {
                bx4.k().w("commodity_tip_show_controller", bx4.k().l("commodity_tip_show_controller", 0) + 1);
            }
        }
    }

    public final void b4(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048665, this, editable) == null) {
            A4(editable);
            g6(editable);
        }
    }

    public final void b5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048666, this) == null) {
            AssociatedItemContainer associatedItemContainer = (AssociatedItemContainer) findViewById(R.id.obfuscated_res_0x7f0902c9);
            this.y1 = associatedItemContainer;
            associatedItemContainer.setOnDeletedListener(new m(this));
            this.y1.setOnAddedListener(new n(this));
        }
    }

    public void b6() {
        WriteData writeData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048667, this) == null) || (writeData = this.p) == null) {
            return;
        }
        this.S.setToolEnabled((!ListUtils.isEmpty(writeData.getItemDatas()) || this.L0 || this.A.hasFocus()) ? false : true, 33);
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void c2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048668, this) == null) {
            super.c2();
            this.S.setActionListener(60, this.e0);
            this.S.setActionListener(56, this.e0);
            this.S.setActionListener(58, this.e0);
            this.S.setActionListener(66, this.e0);
            this.S.setActionListener(22, this.e0);
            this.S.setActionListener(21, this.e0);
            this.S.setActionListener(59, this.e0);
            this.S.setActionListener(61, this.e0);
            this.S.setActionListener(69, this.e0);
        }
    }

    public final void c4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048669, this) == null) || WriteActivityConfig.FROM_FORUM_SHARE.equals(this.f) || this.q1) {
            return;
        }
        this.S.d(new n55(getActivity(), 12));
    }

    public final void c5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048670, this) == null) {
            if (this.O0) {
                this.S.setBarLauncherType(8);
                this.S.setMoreButtonAtEnd(false);
                j4();
            } else if (A5()) {
                a5();
            } else {
                e4();
                g4();
                i4();
                d4();
                a4();
                W3();
                X3();
                f4();
                Z3();
                c4();
                j4();
            }
        }
    }

    public void c6() {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048671, this) == null) || this.S.n(10) == null) {
            return;
        }
        boolean z2 = false;
        if (!this.A.hasFocus() && ((writeImagesInfo = this.q) == null || ListUtils.getCount(writeImagesInfo.getChosedFiles()) < this.q.getMaxImagesAllowed())) {
            z2 = true;
        }
        this.S.setToolEnabled(z2, 10);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048672, this) == null) {
            if (this.R0) {
                ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 1);
            } else {
                ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void d2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048673, this) == null) {
            super.d2();
            this.k1 = findViewById(R.id.obfuscated_res_0x7f090c05);
            if (this.Q.getVisibility() == 0) {
                this.k1.setVisibility(0);
            }
        }
    }

    public final void d4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048674, this) == null) && StringHelper.equals(this.k, "2")) {
            t55 t55Var = new t55(getActivity(), 4);
            this.Q1 = t55Var;
            if (this.q1) {
                t55Var.g(false);
                this.Q1.h(false);
            }
            this.S.d(this.Q1);
            if (this.q1) {
                return;
            }
            this.S.d(new h75(getActivity(), 8));
        }
    }

    public final void d5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048675, this) == null) {
            this.w.postDelayed(this.Y1, 500L);
        }
    }

    public void d6() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048676, this) == null) || this.p == null) {
            return;
        }
        this.S.setToolEnabled((U4() || 10 - R4() != 0 || this.L0 || this.A.hasFocus()) ? false : true, 35);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i e1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048677, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    public final void e4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048678, this) == null) {
            q55 q55Var = new q55(getActivity(), 1);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.f)) {
                return;
            }
            this.S.d(q55Var);
        }
    }

    public final void e5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048679, this) == null) {
            this.O1 = (ListView) this.v.findViewById(R.id.obfuscated_res_0x7f090691);
            y29 y29Var = new y29(getPageContext());
            this.A1 = y29Var;
            y29Var.j(this.z1);
            this.O1.setAdapter((ListAdapter) this.A1);
            this.O1.setOnItemClickListener(new f0(this));
        }
    }

    public void e6() {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048680, this) == null) {
            y29 y29Var = this.A1;
            if (y29Var != null && y29Var.f() == null && (spanGroupEditText = this.E) != null && spanGroupEditText.getSpanGroupManager() != null) {
                this.A1.i(this.E.getSpanGroupManager().F());
                this.A1.h();
            } else {
                y29 y29Var2 = this.A1;
                if (y29Var2 != null && y29Var2.f() != null) {
                    this.A1.h();
                }
            }
            y29 y29Var3 = this.A1;
            if (y29Var3 != null) {
                if (y29Var3.getCount() == 0) {
                    this.O1.setVisibility(8);
                } else {
                    this.O1.setVisibility(0);
                }
            }
            y29 y29Var4 = this.A1;
            if (y29Var4 != null) {
                n6(y29Var4.d());
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048681, this) == null) {
            if (this.R0) {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 1);
            } else {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void f2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048682, this) == null) {
            super.f2();
            registerListener(this.J1);
            registerListener(this.L1);
            registerListener(this.M1);
            registerListener(this.R1);
            registerListener(this.S1);
            registerListener(this.T1);
        }
    }

    public final void f4() {
        CustomResponsedMessage runTask;
        f55 f55Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048683, this) == null) || (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, getActivity()), f55.class)) == null || (f55Var = (f55) runTask.getData()) == null) {
            return;
        }
        f55Var.o = true;
        f55Var.l = 10;
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.f)) {
            return;
        }
        this.S.d(f55Var);
    }

    public final void f5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048684, this) == null) && this.R0) {
            LocalChannelTopicSelectView localChannelTopicSelectView = (LocalChannelTopicSelectView) findViewById(R.id.obfuscated_res_0x7f0926b7);
            this.f1 = localChannelTopicSelectView;
            localChannelTopicSelectView.setVisibility(0);
            this.f1.setLocalChannelTopic(this.S0);
        }
    }

    public final void f6(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048685, this, z2) == null) {
            WriteData writeData = this.p;
            String forumId = writeData == null ? "" : writeData.getForumId();
            d39 d39Var = this.K0;
            if (d39Var != null) {
                d39Var.v(this.q, this.f, forumId);
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void g2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048686, this) == null) {
            super.g2();
            if (this.Z0 == null) {
                k36 k36Var = new k36(getPageContext(), this.M);
                this.Z0 = k36Var;
                k36Var.q0(R.drawable.obfuscated_res_0x7f0802f5);
                this.Z0.T(16);
                this.Z0.c0(true);
                this.Z0.r0(true);
                this.Z0.u0(ej.f(getActivity(), R.dimen.obfuscated_res_0x7f070207));
            }
            g5();
        }
    }

    public final void g4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048687, this) == null) {
            f75 f75Var = new f75(getActivity(), 2);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.f)) {
                return;
            }
            this.S.d(f75Var);
        }
    }

    public final void g5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048688, this) == null) {
            PostPrefixData postPrefixData = this.d;
            if (postPrefixData != null && postPrefixData.getPrefixs().size() > 1) {
                this.M.setVisibility(0);
                this.F.setVisibility(0);
                this.Z0.y0(getString(R.string.obfuscated_res_0x7f0f160d), "write_title_prefix_tip_key", true);
                ArrayList<String> prefixs = this.d.getPrefixs();
                int size = prefixs.size();
                this.i = 0;
                this.M.setOnClickListener(new u(this));
                this.J.setOnClickListener(new w(this));
                int color = SkinManager.getColor(R.color.CAM_X0105);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.L, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, null);
                uu4 d2 = uu4.d(this.J);
                d2.v(R.color.CAM_X0105);
                d2.A(R.string.F_X02);
                d2.f(R.color.CAM_X0201);
                this.G.clear();
                for (int i2 = 0; i2 < size; i2++) {
                    WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                    this.G.add(writePrefixItemLayout);
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
                    this.K.a(writePrefixItemLayout);
                }
                this.K.c(0);
                this.J.setText(prefixs.get(0));
                x2(0);
                return;
            }
            this.M.setVisibility(8);
            this.F.setVisibility(8);
        }
    }

    public final void g6(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048689, this, editable) == null) {
            if (!TextUtils.isEmpty(editable) && editable.length() >= 20 && editable.length() <= 500 && this.i1.e()) {
                this.y.setEnabled(true);
            } else {
                this.y.setEnabled(false);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tieba.hc5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048690, this)) == null) ? "a094" : (String) invokeV.objValue;
    }

    public final void h4(VoiceData.VoiceModel voiceModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048691, this, voiceModel) == null) || voiceModel == null || TextUtils.isEmpty(voiceModel.voiceId) || voiceModel.duration <= 0) {
            return;
        }
        this.h0 = voiceModel;
        this.p.setVoiceModel(voiceModel);
        this.z0.setVisibility(0);
        this.A0.setVoiceModel(voiceModel);
        this.A0.o();
        v2();
    }

    public final void h5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048692, this) == null) {
            U5(this.v1);
        }
    }

    public void h6() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048693, this) == null) || this.S.n(34) == null) {
            return;
        }
        boolean z2 = true;
        boolean z3 = false;
        z2 = (ListUtils.getCount(this.q.getChosedFiles()) > 0 || this.h0 != null || this.L0) ? false : false;
        if (!this.R0 && !this.A.hasFocus()) {
            z3 = z2;
        }
        this.S.setToolEnabled(z3, 34);
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void i2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048694, this) == null) {
            if (this.q1) {
                this.C.setVisibility(8);
                WriteImageGridView writeImageGridView = this.P1;
                if (writeImageGridView != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) writeImageGridView.getLayoutParams();
                    layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X012);
                    this.P1.setLayoutParams(layoutParams);
                }
                this.i0.setVisibility(8);
            } else {
                this.A.setHint(R.string.obfuscated_res_0x7f0f143f);
                this.C.setVisibility(0);
                WriteImageGridView writeImageGridView2 = this.P1;
                if (writeImageGridView2 != null) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) writeImageGridView2.getLayoutParams();
                    layoutParams2.topMargin = 0;
                    this.P1.setLayoutParams(layoutParams2);
                }
                this.i0.setVisibility(0);
                this.C.requestFocus();
            }
            if (this.R0) {
                this.A.setHint(R.string.obfuscated_res_0x7f0f1440);
            }
            if (this.O0) {
                this.A.setHint(getString(R.string.obfuscated_res_0x7f0f0f93));
                this.A.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
                this.A.setSingleLine(false);
            }
        }
    }

    public final void i4() {
        CustomResponsedMessage runTask;
        f55 f55Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048695, this) == null) && x5().booleanValue() && no8.a() && tl8.a(this.p.getForumName(), Boolean.TRUE) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, getActivity()), f55.class)) != null && (f55Var = (f55) runTask.getData()) != null) {
            f55Var.l = 3;
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.f)) {
                return;
            }
            this.S.d(f55Var);
        }
    }

    public final void i5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048696, this) == null) {
            this.B1 = (LinearLayout) this.v.findViewById(R.id.obfuscated_res_0x7f091ad1);
            this.C1 = (ImageView) this.v.findViewById(R.id.obfuscated_res_0x7f091ad6);
            TextView textView = (TextView) this.v.findViewById(R.id.obfuscated_res_0x7f091ad3);
            this.D1 = textView;
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0107);
            EBusinessProtocolView eBusinessProtocolView = new EBusinessProtocolView(this, EBusinessProtocolView.WindowType.PROTOCOL);
            this.F1 = eBusinessProtocolView;
            eBusinessProtocolView.o(getResources().getString(R.string.obfuscated_res_0x7f0f0f51));
            this.F1.i("file:///android_asset/protocol.html");
            SpannableString spannableString = new SpannableString(getResources().getString(R.string.obfuscated_res_0x7f0f0fa0));
            spannableString.setSpan(new q(this), 6, 17, 34);
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0302)), 6, 17, 34);
            this.D1.setText(spannableString);
            this.D1.setMovementMethod(LinkMovementMethod.getInstance());
            this.C1.setOnClickListener(new r(this));
            bx4 k2 = bx4.k();
            if (k2.h(TbadkCoreApplication.getCurrentAccount() + "is_agree_protocol", false)) {
                this.G1 = true;
                this.C1.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08083e, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
            } else {
                this.G1 = false;
                this.C1.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080a2f, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
            }
            this.F1.m(new s(this));
        }
    }

    public void i6() {
        WriteData writeData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048697, this) == null) || (writeData = this.p) == null) {
            return;
        }
        this.S.setToolEnabled((!ListUtils.isEmpty(writeData.getItemDatas()) || this.L0 || this.A.hasFocus()) ? false : true, 32);
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048698, this) == null) {
            super.j2();
            this.D0 = (ImageView) this.w.getCenterImgBox();
            View centerImgBoxLayout = this.w.getCenterImgBoxLayout();
            this.C0 = centerImgBoxLayout;
            centerImgBoxLayout.setOnClickListener(new e(this));
            if (this.M0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.z.getLayoutParams();
                layoutParams.rightMargin = 0;
                layoutParams.leftMargin = 0;
                this.z.setLayoutParams(layoutParams);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.D0.getLayoutParams();
                layoutParams2.width = ej.f(this, R.dimen.tbds31);
                layoutParams2.height = ej.f(this, R.dimen.tbds31);
                this.D0.setLayoutParams(layoutParams2);
                this.D0.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809ab, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_DISABLE));
                this.D0.setVisibility(0);
            } else if (this.O0) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.z.getLayoutParams();
                layoutParams3.rightMargin = ej.f(this, R.dimen.M_W_X002);
                layoutParams3.leftMargin = 0;
                this.z.setLayoutParams(layoutParams3);
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.D0.getLayoutParams();
                layoutParams4.width = ej.f(this, R.dimen.tbds42);
                layoutParams4.height = ej.f(this, R.dimen.tbds42);
                layoutParams4.topMargin = ej.f(this, R.dimen.tbds3);
                this.D0.setLayoutParams(layoutParams4);
                this.D0.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809ca, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_DISABLE));
                this.D0.setVisibility(0);
            }
            this.P1 = (WriteImageGridView) findViewById(R.id.obfuscated_res_0x7f0926b2);
            this.i0 = findViewById(R.id.obfuscated_res_0x7f092249);
            d39 d39Var = new d39(getPageContext(), this.v);
            this.K0 = d39Var;
            d39Var.r(this.K1);
            this.K0.q(this.e, this.p.getFirstDir(), this.p.getSecondDir(), this.d, this.p.getStatisticFrom(), this.G0);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.f)) {
                this.K0.t(false);
            } else {
                this.K0.u(this.p.getType() == 9);
            }
            this.K0.p(this.O0);
            this.K0.s(this.L0);
            r6(true, false);
            this.z0 = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0912b0);
            this.A0 = (PlayVoiceBntNew) findViewById(R.id.obfuscated_res_0x7f090455);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f091003);
            this.B0 = imageView;
            imageView.setOnClickListener(new f(this));
            h4(this.h0);
            v5();
            j5();
            q5();
            f5();
            u5();
            t5();
            s5();
            i5();
            e5();
            o5();
            b5();
            t6();
        }
    }

    public final void j4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048699, this) == null) {
            if (this.U == null) {
                y19 y19Var = new y19(getActivity(), this.k);
                this.U = y19Var;
                y19Var.k(0);
                this.U.l(SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1);
                if (this.R0 || this.O0) {
                    this.U.n(false);
                }
            }
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.f)) {
                this.U.h();
                this.U.m(WriteActivityConfig.FROM_FORUM_SHARE);
            }
            this.S.d(this.U);
        }
    }

    public final void j5() {
        WriteData writeData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048700, this) == null) || this.z == null || (writeData = this.p) == null || writeData.getProZone() != 1) {
            return;
        }
        this.z.setText(R.string.obfuscated_res_0x7f0f161c);
    }

    public final void j6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048701, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921500, new n0(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    @Override // com.baidu.tieba.yl8.g
    public void k(WriteData writeData) {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048702, this, writeData) == null) || WriteActivityConfig.FROM_FORUM_SHARE.equals(this.f) || this.H1 || this.u1) {
            return;
        }
        if ((!this.M0 || (writeImagesInfo = this.q) == null || writeImagesInfo.size() <= 0) && writeData != null && this.p != null && writeData.isEvaluate() == this.p.isEvaluate()) {
            boolean z2 = (this.p.getWriteImagesInfo() == null || ListUtils.isEmpty(this.p.getWriteImagesInfo().getChosedFiles())) ? false : true;
            boolean z3 = !dj.isEmpty(W1().getText().toString());
            boolean z4 = !dj.isEmpty(V1().getText().toString());
            boolean z5 = !dj.isEmpty(writeData.getTitle());
            boolean z6 = !dj.isEmpty(writeData.getContent());
            boolean z7 = !ListUtils.isEmpty(writeData.getRichContentData());
            this.p.setHaveDraft(true);
            if (!this.M0 && !A5()) {
                this.L0 = false;
                N5();
            } else {
                boolean isRichTextEditorMode = writeData.isRichTextEditorMode();
                this.L0 = isRichTextEditorMode;
                this.p.setRichTextEditorMode(isRichTextEditorMode);
                if (this.L0) {
                    Q5();
                } else {
                    N5();
                }
            }
            if (!z2) {
                G4(writeData);
            }
            if (!z3 && z5) {
                F4(writeData);
            }
            if (z6 && !z4) {
                D4(writeData);
            }
            if (z7) {
                E4(writeData);
            }
            if (writeData.getItemInfo() != null) {
                this.p.setItemInfo(writeData.getItemInfo());
                this.p.setEvaluationStar(writeData.getEvaluationStar());
                this.p1 = null;
                t5();
            }
            if (writeData.getWriteVoteData() != null) {
                this.p.setWriteVoteData(writeData.getWriteVoteData());
                v6();
            }
            if (writeData.getVoiceModel() != null) {
                h4(writeData.getVoiceModel());
                h6();
            }
            if (!ListUtils.isEmpty(writeData.getItemDatas()) && !U4() && 10 - R4() == 0) {
                Iterator<ItemData> it = writeData.getItemDatas().iterator();
                while (it.hasNext()) {
                    V3(it.next());
                }
            }
            M1();
            v2();
            I2();
            this.S.q();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void k2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048703, this) == null) {
            this.j0 = findViewById(R.id.obfuscated_res_0x7f091a3c);
            this.q0 = (TbAlphaVideo) findViewById(R.id.obfuscated_res_0x7f09014e);
            RichTextEditor richTextEditor = (RichTextEditor) findViewById(R.id.obfuscated_res_0x7f091c1d);
            this.r0 = richTextEditor;
            richTextEditor.setWriteImagesInfo(this.q);
            this.r0.setOutImageOperateListener(new z(this));
            SpanGroupEditText spanGroupEditText = (SpanGroupEditText) findViewById(R.id.obfuscated_res_0x7f091a3b);
            this.E = spanGroupEditText;
            spanGroupEditText.setDrawingCacheEnabled(false);
            this.E.setOnClickListener(this.c0);
            a0 a0Var = new a0(this);
            this.E.setOnSpanGroupChangedListener(a0Var);
            this.E.setType(SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_COMMODITY);
            this.E.setForumId(dh.g(this.p.getForumId(), 0L));
            po8 po8Var = this.I0;
            if (po8Var != null) {
                po8Var.G(this.E.getSpanGroupManager());
            }
            WriteData writeData = this.p;
            if (writeData != null) {
                writeData.setSpanGroupManager(this.E.getSpanGroupManager());
            }
            if (this.p.getContent() != null && this.p.getContent().length() > 0) {
                this.E.setText(TbFaceManager.i().r(getPageContext().getPageActivity(), this.p.getContent()));
                if (this.E.getText() != null) {
                    SpanGroupEditText spanGroupEditText2 = this.E;
                    spanGroupEditText2.setSelection(spanGroupEditText2.getText().length());
                }
            }
            this.E.setOnFocusChangeListener(this.d0);
            this.E.setOnTouchListener(new b0(this));
            this.E.addTextChangedListener(this.W);
            a6(true);
            this.Y0 = false;
            if (this.q1) {
                SpannableString spannableString = new SpannableString(" " + ((Object) getResources().getText(R.string.obfuscated_res_0x7f0f15f0)));
                Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809cb, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL);
                pureDrawable.setBounds(0, 0, pureDrawable.getIntrinsicWidth(), pureDrawable.getIntrinsicHeight());
                spannableString.setSpan(new dc6(pureDrawable, 1, ej.f(this, R.dimen.tbds4)), 0, 1, 17);
                this.E.setHint(spannableString);
            } else if (this.O0) {
                this.E.setHint(getString(R.string.obfuscated_res_0x7f0f0f8f));
            } else {
                this.E.setHint(R.string.obfuscated_res_0x7f0f0a97);
            }
            this.r0.setOnSpanGroupChangedListener(a0Var);
            this.r0.setForumId(dh.g(this.p.getForumId(), 0L));
            this.r0.setEditOnClickListener(this.c0);
            this.r0.setEditOnFocusChangeListener(this.d0);
            this.r0.setBigEmotionSpanHandler(this.Y);
            this.r0.k(this.W);
            this.r0.n();
            r5();
        }
    }

    public final void k4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048704, this) == null) && WriteActivityConfig.FROM_FORUM_SHARE.equals(this.f) && !StringUtils.isNull(this.e1)) {
            if (this.mCurrentPermissionJudgePolicy == null) {
                this.mCurrentPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
            this.mCurrentPermissionJudgePolicy.appendRequestPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mCurrentPermissionJudgePolicy.startRequestPermission(this)) {
                return;
            }
            InsertGalleryAsyncTask insertGalleryAsyncTask = new InsertGalleryAsyncTask(this, this.e1, new k0(this));
            insertGalleryAsyncTask.setFrom(1);
            insertGalleryAsyncTask.execute(new String[0]);
        }
    }

    public final void k5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048705, this) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.z.getLayoutParams();
            this.W1 = layoutParams.rightMargin;
            layoutParams.rightMargin = 0;
            this.z.setLayoutParams(layoutParams);
            ImageView imageView = (ImageView) this.w.getCenterImgBox();
            this.E0 = imageView;
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080940, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL));
            int f2 = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            int f3 = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds47);
            this.E0.setPadding(f2, f2, f2, f2);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.E0.getLayoutParams();
            int i2 = f3 + f2 + f2;
            layoutParams2.width = i2;
            layoutParams2.height = i2;
            this.E0.setLayoutParams(layoutParams2);
            this.E0.setOnClickListener(new t(this));
            this.E0.setVisibility(0);
        }
    }

    public final void k6() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048706, this) == null) || (editorTools = this.S) == null) {
            return;
        }
        editorTools.A(new u45(57, 15, null));
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void l2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048707, this) == null) {
            EditText editText = (EditText) findViewById(R.id.obfuscated_res_0x7f091a59);
            this.A = editText;
            editText.setOnClickListener(this.c0);
            this.A.setOnFocusChangeListener(this.d0);
            if (this.p.getType() == 9 && this.p.getTitle() != null) {
                this.A.setText(this.p.getTitle());
                this.A.setSelection(this.p.getTitle().length());
            }
            this.A.addTextChangedListener(this.X);
            this.A.setFilters(new InputFilter[]{new k29.b(this.A, 31, new y(this))});
            uu4.d(this.A).A(R.string.F_X02);
        }
    }

    public final boolean l4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048708, this)) == null) ? ListUtils.isEmpty(this.p.getItemDatas()) && this.p.getVoiceModel() == null && this.p.getVideoInfo() == null && this.p.getWriteVoteData() == null && TextUtils.isEmpty(this.E.getText()) && (!this.L0 || this.r0.u()) && (this.q.getChosedFiles() == null || this.q.size() == 0) : invokeV.booleanValue;
    }

    public final void l5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048709, this) == null) {
            this.v0 = (TextView) findViewById(R.id.obfuscated_res_0x7f091b36);
            this.w0 = (TextView) findViewById(R.id.obfuscated_res_0x7f091b30);
            this.v0.setVisibility(0);
            this.w0.setVisibility(0);
            this.v0.setText(getString(R.string.obfuscated_res_0x7f0f090d, new Object[]{0, 31}));
            this.w0.setText(getString(R.string.obfuscated_res_0x7f0f090d, new Object[]{0, 500}));
            this.v0.post(new g(this));
            this.w0.post(new h(this));
        }
    }

    public void l6() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048710, this) == null) || (editorTools = this.S) == null) {
            return;
        }
        editorTools.A(new u45(65, 15, null));
    }

    public final boolean m4(WriteData writeData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048711, this, writeData)) == null) ? writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom())) : invokeL.booleanValue;
    }

    public final void m5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048712, this) == null) {
            NormalItemCell normalItemCell = (NormalItemCell) findViewById(R.id.obfuscated_res_0x7f091b31);
            this.x0 = normalItemCell;
            normalItemCell.setVisibility(0);
            NormalItemCell.a aVar = new NormalItemCell.a();
            aVar.a = R.color.CAM_X0206;
            aVar.c = R.drawable.icon_pure_ba16;
            aVar.b = 1;
            aVar.f = getString(R.string.obfuscated_res_0x7f0f03c8);
            aVar.e = getString(R.string.obfuscated_res_0x7f0f03c6);
            this.x0.setConfig(aVar);
            this.x0.setOnClickListener(new i(this));
            if (!"2".equals(this.k) || TextUtils.isEmpty(this.p.getForumName())) {
                return;
            }
            this.x0.setSubTitle(this.p.getForumName());
            this.x0.setOnClickListener(null);
            this.x0.a();
        }
    }

    public void m6(boolean z2) {
        SpanGroupEditText spanGroupEditText;
        WriteEvaluationHeaderView writeEvaluationHeaderView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048713, this, z2) == null) {
            if (z2 && this.q1 && ((spanGroupEditText = this.E) == null || TextUtils.isEmpty(spanGroupEditText.getText()) || this.E.getText().length() < 20 || this.E.getText().length() > 500 || (writeEvaluationHeaderView = this.i1) == null || !writeEvaluationHeaderView.e())) {
                return;
            }
            this.y.setEnabled(z2);
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void n2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048714, this) == null) {
            this.y.setOnClickListener(new x(this));
        }
    }

    public void n4(boolean z2) {
        AssociatedItemContainer associatedItemContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048715, this, z2) == null) || (associatedItemContainer = this.y1) == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) associatedItemContainer.getLayoutParams();
        if (z2) {
            layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.M_H_X004);
        } else {
            layoutParams.topMargin = 0;
        }
        this.y1.setLayoutParams(layoutParams);
    }

    public final void n5() {
        ForumTagInfo forumTagInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048716, this) == null) {
            NormalItemCell normalItemCell = (NormalItemCell) findViewById(R.id.obfuscated_res_0x7f091b35);
            this.y0 = normalItemCell;
            normalItemCell.setVisibility(0);
            NormalItemCell.a aVar = new NormalItemCell.a();
            aVar.b = 1;
            aVar.f = getString(R.string.obfuscated_res_0x7f0f03d4);
            aVar.e = getString(R.string.obfuscated_res_0x7f0f03d3);
            this.y0.setConfig(aVar);
            this.y0.setOnClickListener(new j(this));
            if ("2".equals(this.k) && (forumTagInfo = this.Q0) != null && forumTagInfo.isValid()) {
                this.p.setQuestionTagId(this.Q0.id);
                this.p.setQuestionTagManualCreated(false);
                this.y0.setSubTitle(this.Q0.name);
                this.y0.setOnClickListener(null);
                this.y0.a();
            }
        }
    }

    public final void n6(List<ir4> list) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048717, this, list) == null) || list == null) {
            return;
        }
        boolean z2 = false;
        Iterator<ir4> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().b == 2) {
                z2 = true;
                break;
            }
        }
        if (z2 || (linearLayout = this.B1) == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    public final void o4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048718, this, i2) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CHANGE_RICH_TEXT_MODE);
            statisticItem.param("obj_type", i2);
            TiebaStatic.log(statisticItem);
            if (i2 == 0) {
                TiebaStatic.log(CommonStatisticKey.KEY_LIMIT_MODE_CHANGE_TOAST);
            }
        }
    }

    public final void o5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048719, this) == null) && this.O0) {
            l5();
            m5();
            n5();
        }
    }

    public final void o6(EvaluateRelevanceItemSelectedMessage evaluateRelevanceItemSelectedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048720, this, evaluateRelevanceItemSelectedMessage) == null) {
            WriteEvaluationHeaderView writeEvaluationHeaderView = this.i1;
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
                this.p.setItemInfo(tbRichTextEvaluateItemInfo);
                this.i1.setItemInfo(tbRichTextEvaluateItemInfo);
                return;
            }
            ItemData itemData = new ItemData();
            itemData.itemId = dh.g(evaluateRelevanceItemSelectedMessage.item_id, 0L);
            itemData.mTags = evaluateRelevanceItemSelectedMessage.tags;
            itemData.mScore = evaluateRelevanceItemSelectedMessage.score;
            itemData.mStar = evaluateRelevanceItemSelectedMessage.star;
            itemData.mIconUrl = evaluateRelevanceItemSelectedMessage.icon_url;
            itemData.mIconSize = evaluateRelevanceItemSelectedMessage.icon_size;
            itemData.mTitle = evaluateRelevanceItemSelectedMessage.item_name;
            V3(itemData);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    @SuppressLint({"ResourceAsColor"})
    public void onActivityResult(int i2, int i3, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        String str;
        int i4;
        LocalChannelTopicSelectView localChannelTopicSelectView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048721, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1) {
                if (i2 == 25072) {
                    if (!this.O0 || intent == null || this.y0 == null) {
                        return;
                    }
                    if (intent.getBooleanExtra(QuestionTagChooseActivityConfig.KEY_RESPONSE_CREATE_TAG, false)) {
                        x4();
                        return;
                    }
                    QuestionTagListData.QuestionTag questionTag = (QuestionTagListData.QuestionTag) intent.getParcelableExtra(QuestionTagChooseActivityConfig.KEY_RESPONSE_TAG);
                    if (questionTag == null) {
                        return;
                    }
                    this.p.setQuestionTagId(questionTag.id);
                    this.p.setQuestionTagManualCreated(false);
                    this.y0.setSubTitle(questionTag.tagName);
                } else if (i2 != 25068) {
                    PostWriteCallBackData postWriteCallBackData2 = null;
                    postWriteCallBackData2 = null;
                    postWriteCallBackData2 = null;
                    if (i2 == 12004) {
                        if (this.A == getCurrentFocus()) {
                            V1().clearFocus();
                            this.A.requestFocus();
                            EditorTools editorTools = this.S;
                            if (editorTools != null) {
                                editorTools.q();
                            }
                            ShowSoftKeyPadDelay(this.A);
                        } else {
                            V1().requestFocus();
                            EditorTools editorTools2 = this.S;
                            if (editorTools2 != null) {
                                editorTools2.q();
                            }
                            ShowSoftKeyPadDelay(this.E);
                        }
                        ArrayList parcelableArrayListExtra = intent != null ? intent.getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA) : null;
                        int selectionStart = V1().getSelectionStart();
                        if (selectionStart > 0) {
                            int i5 = selectionStart - 1;
                            if (V1().getText().toString().charAt(i5) == '@') {
                                V1().getEditableText().delete(i5, selectionStart);
                            }
                        }
                        if (this.M0 && this.L0) {
                            this.r0.l(parcelableArrayListExtra);
                        } else if (V1() instanceof SpanGroupEditText) {
                            ((SpanGroupEditText) V1()).e(parcelableArrayListExtra);
                        }
                        if (parcelableArrayListExtra != null && parcelableArrayListExtra.size() > 0) {
                            V1().getText().delete(V1().getSelectionStart(), V1().getSelectionEnd());
                            if (this.M0 && this.L0) {
                                this.r0.h(parcelableArrayListExtra);
                            } else if (V1() instanceof SpanGroupEditText) {
                                ((SpanGroupEditText) V1()).b(parcelableArrayListExtra);
                            }
                        }
                    } else if (i2 == 12006) {
                        if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) {
                            postWriteCallBackData2 = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                        }
                        w4();
                        A2(postWriteCallBackData2);
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
                            y4(intent);
                        } else {
                            z4(intent);
                            gh.a().post(new i0(this));
                        }
                        r6(ListUtils.getCount(this.q.getChosedFiles()) > 0, false);
                        if (this.Y0) {
                            a6(true);
                            this.Y0 = false;
                        }
                    } else if (i2 == 12012) {
                        if (this.L0) {
                            N4(intent);
                        } else {
                            O4(intent);
                            v2();
                        }
                    } else if (i2 == 13010) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.p.setVideoInfo(videoInfo);
                            this.S.A(new u45(2, 19, " "));
                            this.S.A(new u45(28, 20, videoInfo));
                        } else {
                            this.S.A(new u45(5, -1, null));
                        }
                        v2();
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
                        if (this.n) {
                            sb.append("#");
                            this.n = false;
                        }
                        sb.append(stringExtra);
                        C1(sb.toString());
                    } else if (i2 == 25048) {
                        if (intent == null) {
                            return;
                        }
                        Serializable serializableExtra = intent.getSerializableExtra(IntentConfig.WRITE_VOTE_DATA);
                        if (serializableExtra instanceof WriteVoteData) {
                            this.w1 = serializableExtra;
                            v6();
                        }
                    } else if (i2 == 25049 && intent != null) {
                        String str2 = intent.getStringExtra(AddLinkActivityConfig.NEW_LINK_CONTENT) + " ";
                        int selectionStart2 = this.E.getSelectionStart();
                        int selectionEnd = this.E.getSelectionEnd();
                        if (selectionStart2 >= 0) {
                            Editable text = this.E.getText();
                            if (selectionEnd > selectionStart2) {
                                text.replace(selectionStart2, selectionEnd, str2);
                            } else {
                                text.insert(selectionStart2, str2);
                            }
                        }
                    } else if (i2 == 25064) {
                        if (j19.b()) {
                            if (this.q == null || this.p == null) {
                                return;
                            }
                            if (this.A.getText().toString() != null) {
                                str = this.A.getText().toString();
                                i4 = 5;
                            } else {
                                str = this.s;
                                i4 = 1;
                            }
                            if (this.h1 == null && this.p.getForumName() != null) {
                                j19.f(getPageContext(), str, this.E.getText().toString(), this.p.getForumId(), this.p.getForumName(), 3, Boolean.FALSE, "", "", "");
                            } else {
                                j19.f(getPageContext(), str, this.E.getText().toString(), this.p.getForumId(), this.p.getForumName(), i4, Boolean.TRUE, "", "", "");
                            }
                        } else {
                            H5(0);
                        }
                    }
                } else if (!this.R0 || intent == null || (localChannelTopicSelectView = this.f1) == null || localChannelTopicSelectView.getVisibility() != 0) {
                    return;
                } else {
                    String stringExtra2 = intent.getStringExtra(LocalChannelTopicListActivityConfig.KEY_RESPONSE_TOPIC);
                    this.S0 = stringExtra2;
                    this.f1.setLocalChannelTopic(stringExtra2);
                }
            } else if (i3 == 0) {
                EditorTools editorTools3 = this.S;
                if (editorTools3 != null && !editorTools3.u()) {
                    this.S.q();
                }
                if (i2 == 12001) {
                    B4();
                } else if (i2 == 12002) {
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.q.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    if (this.Y0) {
                        a6(true);
                        this.Y0 = false;
                    }
                } else if (i2 != 12004) {
                    if (i2 != 12006) {
                        if (i2 == 12010) {
                            this.H0 = String.valueOf(System.currentTimeMillis());
                            SelectImageHelper.takePhoto(getPageContext(), this.H0);
                        } else if (i2 == 25004) {
                            if ("from_title".equals(this.g)) {
                                W1().requestFocus();
                            } else if ("from_content".equals(this.g)) {
                                V1().requestFocus();
                            }
                        }
                    } else if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.a.n(postWriteCallBackData.getErrorString());
                        this.a.m(postWriteCallBackData.getSensitiveWords());
                        this.a.h(this.A, this.E);
                    }
                } else if (this.A == getCurrentFocus()) {
                    V1().clearFocus();
                    this.A.requestFocus();
                    EditorTools editorTools4 = this.S;
                    if (editorTools4 != null) {
                        editorTools4.q();
                    }
                    ShowSoftKeyPadDelay(this.A);
                } else {
                    V1().requestFocus();
                    EditorTools editorTools5 = this.S;
                    if (editorTools5 != null) {
                        editorTools5.q();
                    }
                    ShowSoftKeyPadDelay(this.E);
                }
            }
            M1();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity, com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048722, this, i2) == null) {
            super.onChangeSkinType(i2);
            SkinManager.setBackgroundColor(this.H, R.color.CAM_X0205);
            RichTextEditor richTextEditor = this.r0;
            if (richTextEditor != null) {
                richTextEditor.w();
            }
            if (this.w.getBackImageView() != null) {
                this.w.getBackImageView().setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080a0e, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            }
            SkinManager.setBackgroundColor(W1(), R.color.CAM_X0205);
            this.B0.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08095e, SkinManager.getColor(R.color.CAM_X0107), null));
            this.A0.e();
            if (TextUtils.isEmpty(this.t0)) {
                SkinManager.setBackgroundColor(this.j0, R.color.CAM_X0205);
            }
            y29 y29Var = this.A1;
            if (y29Var != null) {
                y29Var.notifyDataSetChanged();
            }
            this.K0.d.notifyDataSetChanged();
            a6(false);
            LocalChannelTopicSelectView localChannelTopicSelectView = this.f1;
            if (localChannelTopicSelectView != null) {
                localChannelTopicSelectView.b();
            }
            ForumSelectedView forumSelectedView = this.g1;
            if (forumSelectedView != null) {
                forumSelectedView.c();
            }
            WriteEvaluationHeaderView writeEvaluationHeaderView = this.i1;
            if (writeEvaluationHeaderView != null) {
                writeEvaluationHeaderView.f();
            }
            c69 c69Var = this.n1;
            if (c69Var != null) {
                c69Var.d(i2);
            }
            EBusinessProtocolView eBusinessProtocolView = this.F1;
            if (eBusinessProtocolView != null) {
                eBusinessProtocolView.j(i2);
            }
            TextView textView = this.j1;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0301);
            }
            AssociatedItemContainer associatedItemContainer = this.y1;
            if (associatedItemContainer != null) {
                associatedItemContainer.c();
            }
            View view2 = this.I1;
            if (view2 != null && view2.getVisibility() == 0) {
                u6();
            }
            if (this.O0) {
                TextView textView2 = this.v0;
                if (textView2 != null) {
                    SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0110);
                    P5(this.v0.getEditableText());
                }
                TextView textView3 = this.w0;
                if (textView3 != null) {
                    SkinManager.setViewTextColor(textView3, (int) R.color.CAM_X0110);
                    O5(this.w0.getEditableText());
                }
                NormalItemCell normalItemCell = this.x0;
                if (normalItemCell != null) {
                    normalItemCell.c();
                }
                NormalItemCell normalItemCell2 = this.y0;
                if (normalItemCell2 != null) {
                    normalItemCell2.c();
                }
                a69 a69Var = this.g0;
                if (a69Var != null) {
                    a69Var.r();
                }
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048723, this) == null) {
            this.w.removeCallbacks(this.Y1);
            po8 po8Var = this.I0;
            if (po8Var != null) {
                po8Var.t();
            }
            W4();
            y6(true);
            if (!this.V1) {
                Y5();
            }
            ih.a(this.l1, this);
            gm8.d();
            super.onDestroy();
            t0().onDestory(getPageContext());
            d39 d39Var = this.K0;
            if (d39Var != null) {
                d39Var.n();
            }
            k36 k36Var = this.Z0;
            if (k36Var != null) {
                k36Var.N();
            }
            a69 a69Var = this.g0;
            if (a69Var != null) {
                a69Var.s();
            }
            MessageManager.getInstance().unRegisterTask(2921500);
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity, android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048724, this) == null) {
            super.onDismiss();
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.L, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, null);
            ShowSoftKeyPadDelay(this.E);
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity, com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048725, this, z2) == null) {
            super.onKeyboardVisibilityChanged(z2);
            if (this.b1 != null && !z2) {
                W4();
            }
            if (z2) {
                return;
            }
            X4();
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048726, this, intent) == null) {
            super.onNewIntent(intent);
            if (intent == null) {
                return;
            }
            if (this.L0) {
                K4(intent);
                return;
            }
            String stringExtra = intent.getStringExtra(BaseWriteConfig.KEY_WRITE_IMAGES_INFO_STRING);
            if (stringExtra == null || (writeImagesInfo = this.q) == null) {
                return;
            }
            writeImagesInfo.parseJson(stringExtra);
            this.q.updateQuality();
            if (this.q.getChosedFiles() != null) {
                z2();
            }
            f6(true);
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048727, this) == null) {
            super.onPause();
            t0().onPause(getPageContext());
            if (this.S.u()) {
                this.S.q();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    @SuppressLint({"NewApi"})
    @TargetApi(23)
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048728, this, i2, strArr, iArr) == null) {
            if (i2 == 1) {
                ArrayMap<String, Boolean> transformPermissionResult = PermissionUtil.transformPermissionResult(strArr, iArr);
                if (PermissionUtil.checkCamera(getApplicationContext())) {
                    SelectImageHelper.takePhoto(getPageContext(), this.H0);
                } else {
                    showToast(R.string.obfuscated_res_0x7f0f1361);
                }
                if (!transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") || transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                    return;
                }
                showToast(R.string.obfuscated_res_0x7f0f10bd);
                return;
            }
            super.onRequestPermissionsResult(i2, strArr, iArr);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048729, this) == null) {
            super.onResume();
            t0().onResume(getPageContext());
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048730, this, bundle) == null) {
            bundle.putString(WriteActivityConfig.FLOOR_ID, this.p.getFloor());
            bundle.putInt("floor_num", this.p.getFloorNum());
            bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.F0);
            bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.T0);
            bundle.putBoolean(WriteActivityConfig.CAN_GOODS, this.U0);
            bundle.putBoolean(WriteActivityConfig.NEED_CLOSE_PRE_PAGE, this.x1);
            bundle.putInt(WriteActivityConfig.KEY_STATISTIS_FROM, this.p.getStatisticFrom());
            super.onSaveInstanceState(bundle);
            t0().onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048731, this) == null) {
            super.onStart();
            t0().onStart(getPageContext());
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048732, this) == null) {
            super.onStop();
            t0().onStop(getPageContext());
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void p2(@NonNull u45 u45Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048733, this, u45Var) == null) {
            super.p2(u45Var);
            int i2 = u45Var.a;
            if (i2 == 16) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 9));
            } else if (i2 == 14 || i2 == 48) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 1));
                S5(u45Var);
            } else if (i2 == 60) {
                T5(u45Var);
            } else if (i2 == 24) {
                Object obj = u45Var.c;
                if (obj instanceof r05) {
                    r05 r05Var = (r05) obj;
                    if (EmotionGroupType.isSendAsPic(r05Var.getType())) {
                        if (this.mCurrentPermissionJudgePolicy == null) {
                            this.mCurrentPermissionJudgePolicy = new PermissionJudgePolicy();
                        }
                        this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
                        this.mCurrentPermissionJudgePolicy.appendRequestPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.mCurrentPermissionJudgePolicy.startRequestPermission(this)) {
                            return;
                        }
                        if (this.q.size() >= this.q.getMaxImagesAllowed()) {
                            showToast(String.format(getString(R.string.obfuscated_res_0x7f0f0abe), Integer.valueOf(this.q.getMaxImagesAllowed())));
                            return;
                        }
                        ImageFileInfo imageFileInfo = new ImageFileInfo();
                        imageFileInfo.setImageType(1);
                        imageFileInfo.setFilePath(r05Var.d());
                        imageFileInfo.width = r05Var.h();
                        imageFileInfo.height = r05Var.b();
                        this.q.addChooseFile(imageFileInfo);
                        this.q.updateQuality();
                        Y3(imageFileInfo);
                        f6(true);
                        h6();
                        c6();
                        v2();
                    } else if (o2()) {
                        showToast(R.string.obfuscated_res_0x7f0f0d37);
                    } else {
                        m2(r05Var);
                    }
                }
            } else if (i2 == 10) {
                Object obj2 = u45Var.c;
                if (obj2 instanceof VoiceData.VoiceModel) {
                    h4((VoiceData.VoiceModel) obj2);
                    h6();
                }
            } else if (i2 == 11) {
                C4();
                h6();
            } else if (i2 == 12 || i2 == 13 || i2 == 46 || i2 == 49) {
                c6();
                h6();
                v2();
            } else if (i2 == 15 || i2 == 47) {
                Object obj3 = u45Var.c;
                if (obj3 instanceof Integer) {
                    G5(((Integer) obj3).intValue());
                }
            } else {
                String str = null;
                r7 = null;
                WriteVoteData writeVoteData = null;
                str = null;
                if (i2 == 25) {
                    Object obj4 = u45Var.c;
                    if (obj4 instanceof Map) {
                        Map map = (Map) obj4;
                        this.t0 = (String) map.get("b_url");
                        this.u0 = (String) map.get("dynamic_url");
                    } else {
                        this.t0 = null;
                        this.u0 = null;
                    }
                    a6(false);
                } else if (i2 == 43) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 4));
                    bx4.k().u("hot_topic_has_click", true);
                    this.S.A(new u45(2, 26, null));
                    this.n = true;
                    t2(true);
                    if (W1().isFocused() && this.C.getVisibility() == 0) {
                        this.g = "from_title";
                    } else {
                        this.g = "from_content";
                    }
                } else if (i2 == 58) {
                    Object obj5 = u45Var.c;
                    if (obj5 instanceof Boolean) {
                        this.V0 = ((Boolean) obj5).booleanValue();
                    }
                } else if (i2 == 22) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 10));
                    c69 c69Var = this.n1;
                    if (c69Var != null && c69Var.c() != null) {
                        writeVoteData = this.n1.c();
                    }
                    I5(writeVoteData);
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_WRITE_VOTE_VIEW_SHOW).param("obj_source", 2));
                    Y4();
                } else if (i2 == 21) {
                    WriteTipBubbleController writeTipBubbleController = this.a1;
                    if (writeTipBubbleController != null) {
                        writeTipBubbleController.c();
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 5));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddLinkActivityConfig(getActivity(), 25049, "", true, null)));
                } else if (i2 == 59) {
                    L5();
                } else if (i2 == 61) {
                    M5();
                } else if (i2 == 66) {
                    Object obj6 = u45Var.c;
                    if (obj6 instanceof Boolean) {
                        this.W0 = ((Boolean) obj6).booleanValue();
                    }
                } else if (i2 == 69) {
                    x6();
                    EditText editText = this.A;
                    if (editText != null && editText.getText() != null) {
                        str = this.A.getText().toString();
                    }
                    if (TextUtils.isEmpty(str) && l4()) {
                        x6();
                        D5();
                        setResult(100);
                        finish();
                        return;
                    }
                    x6();
                    V5(true);
                }
            }
        }
    }

    public final void p4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048734, this) == null) {
            if (l4()) {
                if (this.L0) {
                    N5();
                    o4(1);
                } else {
                    Q5();
                    o4(2);
                }
                this.L0 = !this.L0;
                f6(true);
                K5();
                return;
            }
            BdTopToast bdTopToast = new BdTopToast(this);
            bdTopToast.h(false);
            bdTopToast.g(getResources().getString(R.string.obfuscated_res_0x7f0f0536));
            bdTopToast.i((ViewGroup) this.v);
            o4(0);
        }
    }

    public final void p5(SelectForumData selectForumData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048735, this, selectForumData) == null) || selectForumData == null) {
            return;
        }
        this.h1 = selectForumData;
        WriteData writeData = this.p;
        if (writeData != null) {
            writeData.setForumId(selectForumData.forumId);
            this.p.setForumName(this.h1.forumName);
            SpanGroupEditText spanGroupEditText = this.E;
            if (spanGroupEditText != null) {
                spanGroupEditText.setForumId(dh.g(this.h1.forumId, 0L));
            }
        }
        NormalItemCell normalItemCell = this.x0;
        if (normalItemCell != null) {
            this.Q0 = selectForumData.forumTagInfo;
            this.P0 = selectForumData.firstCategory;
            normalItemCell.setSubTitle(this.h1.forumName);
            R5();
            return;
        }
        ForumSelectedView forumSelectedView = this.g1;
        if (forumSelectedView != null) {
            forumSelectedView.setSelectedForum(this.h1.forumName);
        }
        this.r = null;
        if (!ListUtils.isEmpty(this.h1.tabInfoList)) {
            FrsTabInfoData frsTabInfoData = new FrsTabInfoData();
            this.r = frsTabInfoData;
            frsTabInfoData.selectedTabId = -1;
            SelectForumData selectForumData2 = this.h1;
            List<FrsTabItemData> list = selectForumData2.tabInfoList;
            frsTabInfoData.tabList = list;
            if (selectForumData2.isForumBusinessAccount && list != null) {
                FrsTabItemData frsTabItemData = new FrsTabItemData();
                frsTabItemData.tabId = 505;
                frsTabItemData.name = "官方";
                this.r.tabList.add(0, frsTabItemData);
            }
            this.r.isForumBusinessAccount = this.h1.isForumBusinessAccount;
        }
        this.Q.setData(this.r);
        WriteData writeData2 = this.p;
        if (writeData2 != null) {
            writeData2.setFrsTabInfoData(this.r);
        }
        if (this.Q.getVisibility() == 0) {
            this.k1.setVisibility(0);
        }
        this.d = null;
        PostPrefixData postPrefixData = this.h1.postPrefix;
        if (postPrefixData != null && !ListUtils.isEmpty(postPrefixData.getPrefixs())) {
            PostPrefixData postPrefixData2 = this.h1.postPrefix;
            this.d = postPrefixData2;
            postPrefixData2.getPrefixs().add(getPageContext().getString(R.string.obfuscated_res_0x7f0f15f7));
        }
        g5();
    }

    public final void p6() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048736, this) == null) || (editorTools = this.S) == null) {
            return;
        }
        editorTools.post(new b(this));
    }

    public final boolean q4() {
        InterceptResult invokeV;
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048737, this)) == null) ? this.U0 || (spanGroupEditText = this.E) == null || spanGroupEditText.getSpanGroupManager() == null || this.E.getSpanGroupManager().z() <= 0 : invokeV.booleanValue;
    }

    public final void q5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048738, this) == null) {
            if ("main_tab".equals(this.f) && !this.u1 && !this.O0) {
                ForumSelectedView forumSelectedView = (ForumSelectedView) findViewById(R.id.obfuscated_res_0x7f0926bf);
                this.g1 = forumSelectedView;
                forumSelectedView.setVisibility(0);
            } else if (this.O0) {
            } else {
                if (this.M0 || z5() || B5()) {
                    ForumSelectedView forumSelectedView2 = (ForumSelectedView) findViewById(R.id.obfuscated_res_0x7f0926bf);
                    this.g1 = forumSelectedView2;
                    forumSelectedView2.setVisibility(0);
                    this.g1.setSelectedForum(this.p.getForumName());
                    this.g1.a();
                    this.g1.setOnClickListener(null);
                }
            }
        }
    }

    public final void q6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048739, this) == null) {
            if (this.V == null) {
                this.V = new b39(getPageContext());
            }
            this.V.c(this.S);
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void r2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048740, this) == null) {
            super.r2();
            x6();
            V5(false);
        }
    }

    public final void r4() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048741, this) == null) || (editorTools = this.S) == null) {
            return;
        }
        editorTools.post(new l0(this));
    }

    public final void r5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048742, this) == null) {
            if (this.M0 && this.L0) {
                Z4();
            }
            if (this.L0) {
                Q5();
            } else {
                N5();
            }
        }
    }

    public void r6(boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048743, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (z2) {
                if (!this.L0) {
                    this.K0.o().setVisibility(0);
                    n4(true);
                }
                a6(false);
            } else {
                this.q.clear();
                this.K0.o().setVisibility(8);
                n4(false);
                V4();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001353, Boolean.FALSE));
            }
            v2();
            M1();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void s2(PostWriteCallBackData postWriteCallBackData, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048744, this, postWriteCallBackData, writeData) == null) {
            super.s2(postWriteCallBackData, writeData);
            k29.e(this.p);
            w4();
            if (!dj.isEmpty(postWriteCallBackData.getVideoid()) && this.p.getVideoInfo() != null) {
                if (!dj.isEmpty(this.p.getForumName())) {
                    postWriteCallBackData.mFrom = 2;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001374, postWriteCallBackData));
            } else {
                B2(postWriteCallBackData);
            }
            finish();
        }
    }

    public final boolean s4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048745, this)) == null) {
            FrsTabInfoData frsTabInfoData = this.r;
            if (frsTabInfoData != null && !ListUtils.isEmpty(frsTabInfoData.tabList)) {
                for (FrsTabItemData frsTabItemData : this.r.tabList) {
                    if (frsTabItemData != null && frsTabItemData.tabType == 3) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void s5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048746, this) == null) {
            this.o1 = (RelativeLayout) this.v.findViewById(R.id.obfuscated_res_0x7f09262f);
            c69 c69Var = new c69(getPageContext(), this.o1);
            this.n1 = c69Var;
            c69Var.e(new e0(this));
            v6();
        }
    }

    public final void s6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048747, this) == null) {
            EBusinessProtocolView eBusinessProtocolView = new EBusinessProtocolView(this, EBusinessProtocolView.WindowType.TIP);
            eBusinessProtocolView.o(getResources().getString(R.string.obfuscated_res_0x7f0f1434));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f1421)).append((CharSequence) "\n");
            spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f1422)).append((CharSequence) "\n");
            spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f1423)).append((CharSequence) "\n");
            spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f1424)).append((CharSequence) "\n");
            spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f1425));
            eBusinessProtocolView.k(spannableStringBuilder);
            ih.i(eBusinessProtocolView, this);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public synchronized VoiceManager t0() {
        InterceptResult invokeV;
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048748, this)) == null) {
            synchronized (this) {
                if (this.J0 == null) {
                    this.J0 = VoiceManager.instance();
                }
                voiceManager = this.J0;
            }
            return voiceManager;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public final boolean t4() {
        InterceptResult invokeV;
        EditText editText;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048749, this)) == null) {
            if (!this.O0 || (editText = this.A) == null || this.E == null || editText.getText() == null || this.E.getText() == null) {
                return false;
            }
            if (this.A.getText().toString().length() > 31 || this.E.getText().toString().length() > 500) {
                BdTopToast bdTopToast = new BdTopToast(this, 3000);
                bdTopToast.h(false);
                bdTopToast.g(getString(R.string.obfuscated_res_0x7f0f0f90));
                bdTopToast.i((ViewGroup) this.v);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void t5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048750, this) == null) && this.q1) {
            this.i1.setVisibility(0);
            if (this.r1) {
                this.i1.setShowItemInfo(false);
            }
            if (this.p1 != null) {
                TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo = new TbRichTextEvaluateItemInfo();
                tbRichTextEvaluateItemInfo.setItemID(String.valueOf(this.p1.id));
                tbRichTextEvaluateItemInfo.setTags(this.p1.tags);
                tbRichTextEvaluateItemInfo.setScore(this.p1.averageScore);
                tbRichTextEvaluateItemInfo.setStar(Q4(this.p1.averageScore));
                tbRichTextEvaluateItemInfo.setIconUrl(this.p1.icon_url);
                tbRichTextEvaluateItemInfo.setIconSize(this.p1.icon_size);
                tbRichTextEvaluateItemInfo.setTitle(this.p1.name);
                this.i1.setItemInfo(tbRichTextEvaluateItemInfo);
                this.i1.setStarCount(this.s1);
                this.p.setItemInfo(tbRichTextEvaluateItemInfo);
                this.p.setEvaluationStar(this.s1);
            } else if (this.p.getItemInfo() != null) {
                this.i1.setItemInfo(this.p.getItemInfo());
                this.i1.setStarCount(this.p.getEvaluationStar());
            }
        }
    }

    public final void t6() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048751, this) == null) || bx4.k().h("key_virtual_image_setting_guide_has_show", false)) {
            return;
        }
        bx4.k().u("key_virtual_image_setting_guide_has_show", true);
        ((ViewStub) findViewById(R.id.obfuscated_res_0x7f092604)).inflate();
        View findViewById = findViewById(R.id.obfuscated_res_0x7f092603);
        this.s0 = findViewById;
        findViewById.setVisibility(0);
        this.s0.setOnClickListener(new o0(this));
        uu4 d2 = uu4.d(this.s0);
        d2.e(R.string.A_X05);
        d2.f(R.color.CAM_X0611);
        uu4 d3 = uu4.d(this.s0.findViewById(R.id.obfuscated_res_0x7f092600));
        d3.n(R.string.J_X06);
        d3.f(R.color.CAM_X0201);
        ((GifView) this.s0.findViewById(R.id.obfuscated_res_0x7f0925ff)).setGifRaw(R.raw.obfuscated_res_0x7f110071);
        View findViewById2 = this.s0.findViewById(R.id.obfuscated_res_0x7f0925fd);
        if (this.O0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById2.getLayoutParams();
            layoutParams.setMarginStart(TbDimenUtil.dp2px(getApplicationContext(), 100.0f));
            layoutParams.setMargins(0, TbDimenUtil.dp2px(getApplicationContext(), 20.0f), 0, TbDimenUtil.dp2px(getApplicationContext(), 8.0f));
            findViewById2.setLayoutParams(layoutParams);
        }
        uu4 d4 = uu4.d(findViewById2);
        d4.n(R.string.J_X07);
        d4.f(R.color.CAM_X0205);
        s38 a2 = s38.a();
        uu4.d((TextView) this.s0.findViewById(R.id.obfuscated_res_0x7f092601)).v(R.color.CAM_X0105);
        uu4.d((TextView) this.s0.findViewById(R.id.obfuscated_res_0x7f0925fe)).v(R.color.CAM_X0105);
        TextView textView = (TextView) this.s0.findViewById(R.id.obfuscated_res_0x7f0925fb);
        if (a2 != null && a2.b() == 1) {
            textView.setVisibility(8);
        } else {
            uu4 d5 = uu4.d(textView);
            d5.A(R.string.F_X01);
            d5.z(R.dimen.T_X07);
            d5.v(R.color.CAM_X0304);
            d5.n(R.string.J_X07);
            d5.l(R.dimen.L_X02);
            d5.k(R.color.CAM_X0304);
            d5.j(R.string.A_X07);
            textView.setOnClickListener(new p0(this));
        }
        this.s0.postDelayed(new q0(this), 4000L);
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public boolean u2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048752, this)) == null) {
            View view2 = this.s0;
            if (view2 != null && view2.getVisibility() == 0) {
                this.s0.setVisibility(8);
                return true;
            }
            x6();
            V5(false);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean u4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048753, this)) == null) ? "2".equals(this.k) && this.h1 == null && TextUtils.isEmpty(this.p.getForumName()) : invokeV.booleanValue;
    }

    public final void u5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048754, this) == null) && this.q1) {
            this.j1 = (TextView) findViewById(R.id.obfuscated_res_0x7f091a3e);
            WriteEvaluationHeaderView writeEvaluationHeaderView = (WriteEvaluationHeaderView) findViewById(R.id.obfuscated_res_0x7f0926b1);
            this.i1 = writeEvaluationHeaderView;
            writeEvaluationHeaderView.setStarChangeListener(new o(this));
            this.i1.setItemCloseListener(new p(this));
        }
    }

    public final void u6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048755, this) == null) {
            if (this.I1 == null) {
                ((ViewStub) findViewById(R.id.obfuscated_res_0x7f0925f8)).inflate();
                this.I1 = findViewById(R.id.obfuscated_res_0x7f0925f7);
            }
            this.I1.setOnClickListener(new s0(this));
            this.I1.setVisibility(0);
            uu4 d2 = uu4.d(this.I1);
            d2.e(R.string.A_X05);
            d2.f(R.color.CAM_X0611);
            uu4 d3 = uu4.d(this.I1.findViewById(R.id.obfuscated_res_0x7f0925f6));
            d3.n(R.string.J_X06);
            d3.f(R.color.CAM_X0201);
            TextView textView = (TextView) this.I1.findViewById(R.id.obfuscated_res_0x7f0925f4);
            uu4 d4 = uu4.d(textView);
            d4.A(R.string.F_X01);
            d4.z(R.dimen.T_X07);
            d4.v(R.color.CAM_X0105);
            d4.n(R.string.J_X07);
            d4.l(R.dimen.L_X02);
            d4.k(R.color.CAM_X0105);
            d4.j(R.string.A_X07);
            textView.setOnClickListener(new t0(this));
            TextView textView2 = (TextView) this.I1.findViewById(R.id.obfuscated_res_0x7f0925f3);
            uu4 d5 = uu4.d(textView2);
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
    public void v2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048756, this) == null) || this.p == null) {
            return;
        }
        String obj = W1() != null ? W1().getText().toString() : "";
        String trim = V1() != null ? V1().getText().toString().trim() : "";
        String trim2 = obj.trim();
        if (this.p.getType() == 9) {
            PostPrefixData postPrefixData = this.d;
            if (postPrefixData != null && postPrefixData.getPrefixs().size() > 0) {
                if (this.i == ListUtils.getCount(this.d.getPrefixs()) - 1) {
                    if (TextUtils.isEmpty(trim2)) {
                        this.p.setIsNoTitle(true);
                    } else if (this.C.getVisibility() == 0) {
                        this.p.setIsNoTitle(false);
                        m6(true);
                        return;
                    }
                } else if (this.C.getVisibility() == 0 && !TextUtils.isEmpty(trim2)) {
                    this.p.setIsNoTitle(false);
                    m6(true);
                    return;
                }
            } else if (TextUtils.isEmpty(trim2)) {
                this.p.setIsNoTitle(true);
            } else if (this.C.getVisibility() == 0) {
                this.p.setIsNoTitle(false);
                m6(true);
                return;
            }
        }
        if (this.q.getChosedFiles() != null && this.q.size() > 0) {
            m6(true);
        } else if (TextUtils.isEmpty(trim) && this.h0 == null) {
            if (U4()) {
                m6(true);
            } else {
                m6(false);
            }
        } else {
            m6(true);
        }
    }

    public final int v4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048757, this)) == null) {
            y29 y29Var = this.A1;
            boolean z2 = y29Var == null || y29Var.e();
            ForumTabSelectedView forumTabSelectedView = this.Q;
            boolean z3 = (forumTabSelectedView == null || forumTabSelectedView.getSelectedTabItemData() == null || this.Q.getSelectedTabItemData().tabType != 3) ? false : true;
            if (z2 && z3) {
                return 1;
            }
            return (z2 || z3) ? 0 : 2;
        }
        return invokeV.intValue;
    }

    public final void v5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048758, this) == null) {
            t0().onCreate(getPageContext());
        }
    }

    public final void v6() {
        WriteVoteData writeVoteData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048759, this) == null) {
            Serializable serializable = this.w1;
            if (serializable instanceof WriteVoteData) {
                writeVoteData = (WriteVoteData) serializable;
                this.p.setWriteVoteData(writeVoteData);
            } else if (this.p.getWriteVoteData() == null) {
                return;
            } else {
                writeVoteData = this.p.getWriteVoteData();
            }
            c cVar = new c(this, writeVoteData);
            this.n1.g(cVar);
            this.n1.f(cVar);
            this.n1.h(writeVoteData);
            this.n1.i(true);
            v2();
        }
    }

    public final void w4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048760, this) == null) {
            if (this.p.getType() == 9) {
                if (this.t1) {
                    if (this.R0) {
                        yl8.v(null);
                    } else if (this.O0) {
                        yl8.z(this.p.getForumId(), this.p, true);
                    } else if (this.p.isEvaluate()) {
                        yl8.s(this.p.getItem_id(), null);
                    } else if (TextUtils.isEmpty(this.p.getTopicId())) {
                        yl8.u(this.p.getForumId(), this.p, true);
                    } else {
                        yl8.B(this.p.getTopicId(), null);
                    }
                }
            } else if (this.p.getType() == 1) {
                yl8.y(this.p.getThreadId(), null);
            }
            this.V1 = true;
        }
    }

    public final void w5(@NonNull ImageFileInfo imageFileInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048761, this, imageFileInfo) == null) {
            this.r0.t(imageFileInfo);
        }
    }

    public final void w6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048762, this) == null) {
            this.I0.I();
            k29.e(this.p);
            z6();
            Y5();
            if ("topic_detail".equals(this.f)) {
                setResult(-1);
            } else {
                setResult(100);
            }
            finish();
        }
    }

    public final void x4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048763, this) == null) {
            if (this.g0 == null) {
                this.g0 = new a69();
            }
            this.g0.u(this, this.Q0 == null ? this.y0.getSubTitleContent() : null, this.p.getForumId(), new l(this));
        }
    }

    public final Boolean x5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048764, this)) == null) ? Boolean.valueOf(this.G0) : (Boolean) invokeV.objValue;
    }

    public void x6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048765, this) == null) {
            y6(false);
        }
    }

    public final void y4(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048766, this, intent) == null) || this.q == null) {
            return;
        }
        J4(intent);
        int size = this.q.size() - 1;
        if (size <= -1 || this.q.getChosedFiles() == null || this.q.size() < 1) {
            return;
        }
        sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.q, size)));
    }

    public final boolean y5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048767, this)) == null) ? (this.R0 || this.M0 || !this.q1) ? false : true : invokeV.booleanValue;
    }

    public void y6(boolean z2) {
        po8 po8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048768, this, z2) == null) {
            if (!z2 && (po8Var = this.I0) != null) {
                po8Var.d();
            }
            FeedBackModel feedBackModel = this.u;
            if (feedBackModel != null) {
                feedBackModel.cancelLoadData();
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public boolean z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048769, this)) == null) {
            if (super.z2()) {
                WriteData writeData = this.p;
                String forumId = writeData == null ? "" : writeData.getForumId();
                d39 d39Var = this.K0;
                if (d39Var != null) {
                    d39Var.v(this.q, this.f, forumId);
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void z4(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048770, this, intent) == null) {
            if (this.L0) {
                I4(intent);
            } else {
                H4(intent);
            }
            v2();
        }
    }

    public final boolean z5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048771, this)) == null) ? (this.R0 || !"2".equals(this.k) || this.L0 || this.q1 || this.O0) ? false : true : invokeV.booleanValue;
    }

    public final synchronized void z6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048772, this) == null) {
            synchronized (this) {
                VoiceManager t02 = t0();
                this.J0 = t02;
                t02.stopPlay();
            }
        }
    }
}
