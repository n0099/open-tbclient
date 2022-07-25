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
import android.text.TextWatcher;
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
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
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
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.LocalChannelTopicListActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.RelevanceItemSearchActivityConfig;
import com.baidu.tbadk.core.atomData.SelectForumConfig;
import com.baidu.tbadk.core.atomData.WorkPublishOpenHelper;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVoteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
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
import com.baidu.tbadk.core.util.HeadIconRefreshHelper;
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
import com.baidu.tieba.write.view.AssociatedItemContainer;
import com.baidu.tieba.write.view.ForumSelectedView;
import com.baidu.tieba.write.view.ForumTabSelectedView;
import com.baidu.tieba.write.view.LocalChannelTopicSelectView;
import com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout;
import com.baidu.tieba.write.view.PostCategoryView;
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
import com.repackage.by8;
import com.repackage.c9;
import com.repackage.cs6;
import com.repackage.de5;
import com.repackage.dp8;
import com.repackage.dr4;
import com.repackage.f25;
import com.repackage.fw4;
import com.repackage.gy8;
import com.repackage.h25;
import com.repackage.he5;
import com.repackage.i08;
import com.repackage.ig;
import com.repackage.ik8;
import com.repackage.iy8;
import com.repackage.j25;
import com.repackage.jd5;
import com.repackage.jg;
import com.repackage.jx8;
import com.repackage.k15;
import com.repackage.k25;
import com.repackage.kd5;
import com.repackage.ke5;
import com.repackage.kk8;
import com.repackage.lo4;
import com.repackage.ly8;
import com.repackage.mh8;
import com.repackage.mk8;
import com.repackage.mr4;
import com.repackage.mx4;
import com.repackage.n15;
import com.repackage.ng;
import com.repackage.ni;
import com.repackage.ny8;
import com.repackage.oi;
import com.repackage.p86;
import com.repackage.pi;
import com.repackage.qg;
import com.repackage.qv4;
import com.repackage.qy8;
import com.repackage.rh8;
import com.repackage.sg;
import com.repackage.t65;
import com.repackage.tw8;
import com.repackage.ud6;
import com.repackage.v15;
import com.repackage.vr4;
import com.repackage.vx8;
import com.repackage.w15;
import com.repackage.wz5;
import com.repackage.x15;
import com.repackage.x35;
import com.repackage.xy8;
import com.repackage.ym;
import com.repackage.yt4;
import com.repackage.z35;
import com.repackage.zh8;
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
public class WriteActivity extends AbsBaseWriteActivity<WriteActivity> implements VoiceManager.j, rh8.f, ActivityCompat.OnRequestPermissionsResultCallback {
    public static /* synthetic */ Interceptable $ic;
    public static int L2;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout A1;
    public ListView A2;
    public boolean B1;
    public WriteImageGridView B2;
    public long C1;
    public k25 C2;
    public boolean D1;
    public CustomMessageListener D2;
    public boolean E1;
    public CustomMessageListener E2;
    public String F1;
    public CustomMessageListener F2;
    public int G1;
    public t65 G2;
    public VoiceData.VoiceModel H0;
    public boolean H1;
    public boolean H2;
    public boolean I0;
    public boolean I1;
    public int I2;
    public boolean J0;
    public boolean J1;
    public final zh8.f J2;
    public boolean K0;
    public String K1;
    public final Runnable K2;
    public HeadImageView L0;
    public boolean L1;
    public View M0;
    public wz5 M1;
    public FeedBackTopListView N0;
    public WriteTipBubbleController N1;
    public View O0;
    public gy8 O1;
    public View P0;
    public String P1;
    public RichTextEditor Q0;
    public String Q1;
    public View R0;
    public String R1;
    public String S0;
    public LocalChannelTopicSelectView S1;
    public LinearLayout T0;
    public ForumSelectedView T1;
    public PlayVoiceBntNew U0;
    public SelectForumData U1;
    public ImageView V0;
    public WriteEvaluationHeaderView V1;
    public View W0;
    public TextView W1;
    public ImageView X0;
    public View X1;
    public ImageView Y0;
    public mr4 Y1;
    public boolean Z0;
    public SaveDraftDialogView Z1;
    public String a1;
    public xy8 a2;
    public boolean b1;
    public RelativeLayout b2;
    public String c1;
    public SerializableItemInfo c2;
    public kk8 d1;
    public boolean d2;
    public VoiceManager e1;
    public boolean e2;
    public WriteImagesInfo f1;
    public int f2;
    public ny8 g1;
    public boolean g2;
    public GridView h1;
    public boolean h2;
    public by8 i1;
    public String i2;
    public EditText j1;
    public Serializable j2;
    public View k1;
    public boolean k2;
    public View l1;
    public AssociatedItemContainer l2;
    public View m1;
    public final iy8.d m2;
    public EditText n1;
    public iy8 n2;
    public TextView o1;
    public LinearLayout o2;
    public TextView p1;
    public ImageView p2;
    public TextWatcher q1;
    public TextView q2;
    public TextWatcher r1;
    public List<cs6> r2;
    public boolean s1;
    public EBusinessProtocolView s2;
    public boolean t1;
    public boolean t2;
    public boolean u1;
    public boolean u2;
    public String v1;
    public View v2;
    public File w1;
    public final HttpMessageListener w2;
    public TbImageView x1;
    public CustomMessageListener x2;
    public View y1;
    public final CustomMessageListener y2;
    public Dialog z1;
    public WriteTipBubbleController.b z2;

    /* loaded from: classes4.dex */
    public class a implements View.OnFocusChangeListener {
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

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) && z) {
                this.a.s1 = true;
                WriteActivity writeActivity = this.a;
                writeActivity.p = true;
                writeActivity.M1();
                EditorTools editorTools = this.a.r0;
                if (editorTools != null) {
                    editorTools.q();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a0 extends ig<ym> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ WriteActivity b;

        public a0(WriteActivity writeActivity, boolean z) {
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
        @Override // com.repackage.ig
        public void onLoaded(ym ymVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, ymVar, str, i) == null) {
                super.onLoaded((a0) ymVar, str, i);
                if (ymVar == null || ymVar.p() == null || ymVar.o() == null) {
                    return;
                }
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), ymVar.p(), ymVar.p().getNinePatchChunk(), ymVar.o(), null);
                if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
                    ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                }
                WriteActivity writeActivity = this.b;
                if (writeActivity.t) {
                    writeActivity.j1.setBackgroundDrawable(ninePatchDrawable);
                } else {
                    writeActivity.P0.setBackgroundDrawable(ninePatchDrawable);
                }
                if (this.a) {
                    zh8.c(this.b.getPageContext(), this.b.V1(), true, this.b.J2);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001353, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnFocusChangeListener {
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

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) && z) {
                this.a.s1 = false;
                WriteActivity writeActivity = this.a;
                writeActivity.p = false;
                writeActivity.M1();
                EditorTools editorTools = this.a.r0;
                if (editorTools != null) {
                    editorTools.q();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b0 implements zh8.f {
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

        @Override // com.repackage.zh8.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.S0 = null;
                this.a.A6(false);
                this.a.r0.A(new k15(2, 12, null));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements PhotoLiveLinearLayout.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public c(WriteActivity writeActivity) {
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

        @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.h7();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c0 implements AdapterView.OnItemClickListener {
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

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) && this.a.n2 != null && (this.a.n2.getItem(i) instanceof lo4)) {
                lo4 lo4Var = (lo4) this.a.n2.getItem(i);
                int i2 = lo4Var.b;
                if (i2 == 1) {
                    if (lo4Var.o == 1) {
                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{lo4Var.g});
                        return;
                    }
                    UrlManager urlManager = UrlManager.getInstance();
                    TbPageContext<WriteActivity> pageContext = this.a.getPageContext();
                    urlManager.dealOneLink(pageContext, new String[]{"https://tieba.baidu.com/mo/q/checkurl?url=" + oi.getUrlEncode(lo4Var.g)});
                } else if (i2 == 2) {
                    if (!TextUtils.isEmpty(lo4Var.j)) {
                        if (lo4Var.j.startsWith("tiebaclient://")) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, lo4Var.j));
                            return;
                        }
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(lo4Var.j));
                        intent.addFlags(268468224);
                        if (UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                            this.a.startActivity(intent);
                        } else if (TextUtils.isEmpty(lo4Var.k)) {
                        } else {
                            UrlManager urlManager2 = UrlManager.getInstance();
                            TbPageContext<WriteActivity> pageContext2 = this.a.getPageContext();
                            urlManager2.dealOneLink(pageContext2, new String[]{"https://tieba.baidu.com/mo/q/checkurl?url=" + oi.getUrlEncode(lo4Var.k)});
                        }
                    } else if (TextUtils.isEmpty(lo4Var.k)) {
                    } else {
                        UrlManager urlManager3 = UrlManager.getInstance();
                        TbPageContext<WriteActivity> pageContext3 = this.a.getPageContext();
                        urlManager3.dealOneLink(pageContext3, new String[]{"https://tieba.baidu.com/mo/q/checkurl?url=" + oi.getUrlEncode(lo4Var.k)});
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            WriteActivity writeActivity;
            EditorTools editorTools;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (editorTools = (writeActivity = this.a).r0) == null || editorTools.a == null) {
                return;
            }
            if (writeActivity.O1 == null) {
                WriteActivity writeActivity2 = this.a;
                writeActivity2.O1 = new gy8(writeActivity2.getPageContext());
            }
            this.a.O1.b(this.a.r0.a.s(2));
        }
    }

    /* loaded from: classes4.dex */
    public class d0 implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.h2) {
                this.a.z0.callback(false, mk8.c, mk8.d, mk8.e, mk8.f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteVoteData a;
        public final /* synthetic */ WriteActivity b;

        public e(WriteActivity writeActivity, WriteVoteData writeVoteData) {
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
                this.b.j6(this.a);
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_WRITE_VOTE_VIEW_SHOW).param("obj_source", 3));
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
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                pi.x(this.a.getActivity(), this.a.getCurrentFocus());
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null) {
                return;
            }
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f091c75) {
                this.a.P4();
                this.a.setResult(100);
                this.a.finish();
            } else if (id == R.id.obfuscated_res_0x7f091c76) {
                this.a.x6();
                this.a.setResult(100);
                this.a.finish();
            }
            this.a.Y1.dismiss();
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
                this.a.i1.notifyDataSetChanged();
                this.a.h1.invalidateViews();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.u1) {
                this.a.I4();
                this.a.U2();
                this.a.M1();
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
                if (writeActivity.v == null || !writeActivity.H1) {
                    return;
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_COMMODITY_ENTRANCE_SHOW).param("obj_locate", 1).param("fid", this.a.v.getForumId()).param("fname", this.a.v.getForumName()));
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
                this.a.W4();
                this.a.H6();
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
                FileHelper.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + this.a.c1));
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class i implements AssociatedItemContainer.b {
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

        @Override // com.baidu.tieba.write.view.AssociatedItemContainer.b
        public void a(ItemData itemData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, itemData) == null) {
                this.a.v.removeItemData(itemData);
                if (ListUtils.isEmpty(this.a.v.getItemDatas())) {
                    this.a.M1();
                    this.a.l2.setVisibility(8);
                }
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
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && new File(str).exists() && (writeImagesInfo = this.a.y) != null) {
                writeImagesInfo.clear();
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(str);
                imageFileInfo.isFromMoreForum = true;
                this.a.y.addChooseFile(imageFileInfo);
                this.a.y.setMaxImagesAllowed(1);
                this.a.r4(imageFileInfo);
                this.a.F6(true);
                this.a.H6();
                this.a.C6();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements AssociatedItemContainer.a {
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

        @Override // com.baidu.tieba.write.view.AssociatedItemContainer.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                if (this.a.B2.getVisibility() == 0) {
                    this.a.F4(true);
                } else {
                    this.a.F4(false);
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.w1 == null) {
                return;
            }
            WriteActivity writeActivity = this.a;
            writeActivity.O4(writeActivity.w1.getAbsolutePath());
        }
    }

    /* loaded from: classes4.dex */
    public class k implements iy8.d {
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

        @Override // com.repackage.iy8.d
        public void a(List<lo4> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                this.a.Q6(list);
            }
        }

        @Override // com.repackage.iy8.d
        public void b(int i) {
            SpanGroupEditText spanGroupEditText;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || (spanGroupEditText = this.a.S) == null) {
                return;
            }
            spanGroupEditText.f(i);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) && this.a.B1) {
                pi.x(this.a.getPageContext().getPageActivity(), this.a.getCurrentFocus());
                this.a.C1 = System.currentTimeMillis();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements WriteEvaluationHeaderView.b {
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

        @Override // com.baidu.tieba.write.view.WriteEvaluationHeaderView.b
        public void a(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048576, this, f) == null) {
                if (!TextUtils.isEmpty(this.a.S.getText()) && this.a.S.getText().length() >= 20 && this.a.S.getText().length() <= 500 && f > 0.0f) {
                    this.a.L.setEnabled(true);
                } else {
                    this.a.L.setEnabled(false);
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
        public class a extends de5<String> {
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
            @Override // com.repackage.de5
            public String doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? UtilHelper.getClipBoardContent() : (String) invokeV.objValue;
            }
        }

        /* loaded from: classes4.dex */
        public class b implements kd5<String> {
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
            @Override // com.repackage.kd5
            /* renamed from: a */
            public void onReturnDataInUI(String str) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && !oi.isEmpty(str) && UrlManager.getInstance().isUrlValid(str)) {
                    if (this.a.a.N1 == null) {
                        WriteActivity writeActivity = this.a.a;
                        writeActivity.N1 = new WriteTipBubbleController(writeActivity.getPageContext(), this.a.a.z2);
                    }
                    View s = this.a.a.r0.a.s(31);
                    WriteTipBubbleController writeTipBubbleController = this.a.a.N1;
                    writeTipBubbleController.d(s, this.a.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f061f) + "\n" + str, str, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL);
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (editorTools = this.a.r0) == null || editorTools.a == null) {
                return;
            }
            if (AsyncGetClipboardSwitch.isOn() && TbadkCoreApplication.getInst().isMIUIRom()) {
                he5.b(new a(this), new b(this));
                return;
            }
            String clipBoardContent = UtilHelper.getClipBoardContent();
            if (oi.isEmpty(clipBoardContent) || !UrlManager.getInstance().isUrlValid(clipBoardContent)) {
                return;
            }
            if (this.a.N1 == null) {
                WriteActivity writeActivity = this.a;
                writeActivity.N1 = new WriteTipBubbleController(writeActivity.getPageContext(), this.a.z2);
            }
            View s = this.a.r0.a.s(31);
            WriteTipBubbleController writeTipBubbleController = this.a.N1;
            writeTipBubbleController.d(s, this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f061f) + "\n" + clipBoardContent, clipBoardContent, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL);
        }
    }

    /* loaded from: classes4.dex */
    public class m implements WriteEvaluationHeaderView.c {
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

        @Override // com.baidu.tieba.write.view.WriteEvaluationHeaderView.c
        public void onClose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.L.setEnabled(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dr4 a;
        public final /* synthetic */ WriteActivity b;

        public m0(WriteActivity writeActivity, dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity, dr4Var};
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
            this.a = dr4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            dr4 dr4Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (dr4Var = this.a) == null) {
                return;
            }
            dr4Var.dismiss();
            yt4.k().u("commodity_goods_show_first_dialog", true);
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_WRITE_GOODS_NEW_DIALOG_CLICK).param("obj_locate", 2);
            WriteData writeData = this.b.v;
            StatisticItem param2 = param.param("fid", writeData != null ? writeData.getForumId() : "");
            WriteData writeData2 = this.b.v;
            TiebaStatic.log(param2.param("fname", writeData2 != null ? writeData2.getForumName() : ""));
            String uk = TbadkCoreApplication.getCurrentAccountInfo().getUk();
            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + uk + "&max=" + this.b.s5()));
        }
    }

    /* loaded from: classes4.dex */
    public class n extends ClickableSpan {
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

        @Override // android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                sg.i(this.a.s2, this.a);
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
                bdTopToast.i(false);
                bdTopToast.h(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f149a));
                bdTopToast.j((ViewGroup) this.a.I);
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        /* loaded from: classes4.dex */
        public class a implements dr4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(o oVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.repackage.dr4.e
            public void onClick(dr4 dr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                    yt4 k = yt4.k();
                    k.u(TbadkCoreApplication.getCurrentAccount() + "is_agree_protocol", true);
                    dr4Var.dismiss();
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements dr4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(o oVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.repackage.dr4.e
            public void onClick(dr4 dr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                    yt4 k = yt4.k();
                    k.u(TbadkCoreApplication.getCurrentAccount() + "is_agree_protocol", false);
                    dr4Var.dismiss();
                }
            }
        }

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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.t2) {
                    this.a.t2 = false;
                    this.a.p2.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809ef, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
                } else {
                    this.a.t2 = true;
                    this.a.p2.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08080c, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
                }
                yt4 k = yt4.k();
                if (k.h(TbadkCoreApplication.getCurrentAccount() + "is_agree_protocol", false) || !this.a.t2) {
                    return;
                }
                dr4 dr4Var = new dr4(this.a);
                dr4Var.setNegativeTextColor(R.color.CAM_X0105);
                dr4Var.setTitle("");
                dr4Var.setMessage(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0f01));
                dr4Var.setContentViewSize(1);
                dr4Var.setPositiveButton("同意", new a(this));
                dr4Var.setNegativeButton(SapiWebView.HTTPS_SSL_DATE_INVALID_DIALOG_CANCEL, new b(this));
                dr4Var.create(this.a.getPageContext()).show();
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
                this.a.R0.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p implements EBusinessProtocolView.f {
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

        @Override // com.baidu.tieba.view.EBusinessProtocolView.f
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    if (this.a.t2) {
                        return;
                    }
                    this.a.t2 = true;
                    this.a.p2.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08080c, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
                } else if (this.a.t2) {
                    this.a.t2 = false;
                    this.a.p2.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809ef, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
                }
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
                this.a.w5("5");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.V6();
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
                this.a.R0.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log(new StatisticItem("c13013").param("fid", this.a.v.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                this.a.b0.setVisibility(0);
                this.a.e0.setSelected(true);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.a.d0, R.drawable.obfuscated_res_0x7f080914, R.color.CAM_X0105, null);
                WriteActivity writeActivity = this.a;
                sg.l(writeActivity.c0, view2, 0, pi.d(writeActivity.getPageContext().getPageActivity(), 1.0f));
                this.a.r0.q();
                WriteActivity writeActivity2 = this.a;
                writeActivity2.HidenSoftKeyPad(writeActivity2.s0, writeActivity2.N);
                WriteActivity writeActivity3 = this.a;
                writeActivity3.HidenSoftKeyPad(writeActivity3.s0, writeActivity3.S);
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.T1 == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof SelectForumData) || (selectForumData = (SelectForumData) customResponsedMessage.getData()) == null || StringUtils.isNull(selectForumData.forumId) || StringUtils.isNull(selectForumData.forumName)) {
                return;
            }
            this.a.Q5(selectForumData);
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
                TiebaStatic.log(new StatisticItem("c13013").param("fid", this.a.v.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                this.a.b0.setSelected(true);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.a.d0, R.drawable.obfuscated_res_0x7f080914, R.color.CAM_X0105, null);
                WriteActivity writeActivity = this.a;
                sg.l(writeActivity.c0, view2, 0, pi.d(writeActivity.getPageContext().getPageActivity(), 1.0f));
                this.a.r0.q();
                WriteActivity writeActivity2 = this.a;
                writeActivity2.HidenSoftKeyPad(writeActivity2.s0, writeActivity2.W1());
                WriteActivity writeActivity3 = this.a;
                writeActivity3.HidenSoftKeyPad(writeActivity3.s0, writeActivity3.V1());
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
    public class t extends c9 {
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

        @Override // com.repackage.c9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.a.hideProgressBar();
                if (obj == null || !(obj instanceof FeedBackModel)) {
                    this.a.N0.setVisibility(8);
                    this.a.O0.setVisibility(8);
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c17);
                    return;
                }
                FeedBackModel feedBackModel = (FeedBackModel) obj;
                if (feedBackModel.E() != 0) {
                    this.a.N0.setVisibility(8);
                    this.a.O0.setVisibility(8);
                    return;
                }
                this.a.N0.c(feedBackModel.F(), this.a.getPageContext());
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
                if (this.a.J1) {
                    this.a.J1 = false;
                    yt4 k = yt4.k();
                    k.u("key_write_virtual_image_enable" + TbadkCoreApplication.getCurrentAccount(), this.a.J1);
                    WriteActivity writeActivity = this.a;
                    writeActivity.v.setShowCustomFigure(writeActivity.J1);
                    this.a.Z6();
                }
                this.a.v2.setVisibility(8);
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
                SpanGroupEditText spanGroupEditText = this.a.S;
                if (spanGroupEditText != null && spanGroupEditText.getText() != null && this.a.S.getText().toString() != null) {
                    if (this.a.S.getText().toString().length() > 1000) {
                        WriteActivity writeActivity = this.a;
                        writeActivity.showToast(writeActivity.getResources().getString(R.string.obfuscated_res_0x7f0f0ea3));
                        return;
                    } else if (this.a.S.getText().toString().contains("ܷ") || this.a.S.getText().toString().contains("ܶ")) {
                        WriteActivity writeActivity2 = this.a;
                        writeActivity2.showToast(writeActivity2.getResources().getString(R.string.obfuscated_res_0x7f0f0ea2));
                        return;
                    }
                }
                if (this.a.d2 || (!TextUtils.isEmpty(this.a.N.getText().toString()) && this.a.N.getText().toString().trim().length() >= 5)) {
                    if (!this.a.M4()) {
                        if (this.a.J4()) {
                            if (!this.a.u2 || this.a.t2) {
                                if (this.a.L4()) {
                                    int N4 = this.a.N4();
                                    if (N4 == 1) {
                                        this.a.showToast(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f13ef));
                                        return;
                                    } else if (N4 == 2) {
                                        this.a.showToast(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f13f0));
                                        return;
                                    }
                                }
                                if (!ni.z()) {
                                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c17);
                                }
                                if (ke5.b()) {
                                    return;
                                }
                                WriteActivity writeActivity3 = this.a;
                                if (writeActivity3.a.b(writeActivity3.N, writeActivity3.S)) {
                                    WriteActivity writeActivity4 = this.a;
                                    writeActivity4.showToast(writeActivity4.a.e());
                                    return;
                                }
                                WriteActivity writeActivity5 = this.a;
                                writeActivity5.HidenSoftKeyPad(writeActivity5.s0, writeActivity5.W1());
                                WriteActivity writeActivity6 = this.a;
                                writeActivity6.HidenSoftKeyPad(writeActivity6.s0, writeActivity6.V1());
                                this.a.r0.q();
                                if (this.a.v.getType() != 7) {
                                    if (this.a.I0) {
                                        this.a.v6();
                                        BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                                    } else {
                                        StatisticItem statisticItem = new StatisticItem("c12102");
                                        statisticItem.param("obj_type", StringUtils.isNull(this.a.v.getForumName()) ? 1 : 2);
                                        TiebaStatic.log(statisticItem);
                                        this.a.w6();
                                    }
                                } else {
                                    TiebaStatic.log("c12015");
                                    this.a.v6();
                                }
                                MercatorModel.d().f();
                                TiebaStatic.log(new StatisticItem("c12262").param("obj_locate", this.a.o));
                                qy8.b();
                                return;
                            }
                            WriteActivity writeActivity7 = this.a;
                            writeActivity7.showToast(writeActivity7.getResources().getString(R.string.obfuscated_res_0x7f0f0f08));
                            return;
                        }
                        this.a.showToast(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f13ea));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectForumConfig(this.a)));
                    return;
                }
                BdTopToast bdTopToast = new BdTopToast(this.a);
                bdTopToast.i(false);
                bdTopToast.h(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f13de));
                bdTopToast.j((ViewGroup) this.a.I);
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
                this.a.w5("6");
                this.a.v2.setVisibility(8);
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
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.a.S0)) {
                    this.a.S0 = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    this.a.A6(true);
                } else if (TextUtils.isEmpty(str) || str.equals(this.a.S0)) {
                } else {
                    this.a.S0 = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(this.a.S0);
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
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, view2, str) == null) || this.a.N1 == null) {
                return;
            }
            TiebaStatic.log("c13802");
            this.a.N1.c();
            UtilHelper.clearClipBoard();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddLinkActivityConfig(this.a.getActivity(), 25049, str, false, null)));
        }
    }

    /* loaded from: classes4.dex */
    public class w implements vx8.c {
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

        @Override // com.repackage.vx8.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                pi.O(TbadkCoreApplication.getInst(), String.format(this.a.getString(R.string.obfuscated_res_0x7f0f158b), 31));
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
    public class x implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public EditText b;
        public TextView c;
        public final /* synthetic */ WriteActivity d;

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
            this.d = writeActivity;
            this.b = null;
            this.c = null;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.d.D2();
                if (this.d.t) {
                    int selectionStart = this.b.getSelectionStart();
                    this.a = selectionStart;
                    this.b.setSelection(selectionStart);
                    this.d.O6(this.c, this.b);
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
                WriteActivity writeActivity = this.d;
                if (writeActivity.t && writeActivity.s1) {
                    if (this.b == this.d.n1 && this.c == this.d.o1) {
                        return;
                    }
                    this.b = this.d.n1;
                    this.c = this.d.o1;
                    return;
                }
                WriteActivity writeActivity2 = this.d;
                if (writeActivity2.t) {
                    if (this.b == writeActivity2.j1 && this.c == this.d.p1) {
                        return;
                    }
                    this.b = this.d.j1;
                    this.c = this.d.p1;
                }
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
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
                this.a.P4();
                this.a.setResult(100);
                this.a.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class y implements qv4.a {
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

        @Override // com.repackage.qv4.a
        public void a(int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                this.a.E6();
                this.a.M1();
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
                this.a.R6((EvaluateRelevanceItemSelectedMessage) customResponsedMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class z implements View.OnTouchListener {
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

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() == 1) {
                    view2.requestFocus();
                    this.a.r0.A(new k15(5, -1, null));
                    this.a.S.requestFocus();
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class z0 extends t65<GoodsEvent> {
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
        @Override // com.repackage.m65
        /* renamed from: a */
        public boolean onEvent(GoodsEvent goodsEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, goodsEvent)) == null) {
                if (goodsEvent == null) {
                    return false;
                }
                this.c.t6(goodsEvent.getGoodsList());
                goodsEvent.setDispost(true);
                this.c.M1();
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
        this.I0 = false;
        this.J0 = false;
        this.K0 = false;
        this.L0 = null;
        this.N0 = null;
        this.S0 = null;
        this.Y0 = null;
        this.Z0 = false;
        this.a1 = null;
        this.b1 = true;
        this.f1 = new WriteImagesInfo();
        this.h1 = null;
        this.i1 = null;
        this.j1 = null;
        this.k1 = null;
        this.l1 = null;
        this.m1 = null;
        this.n1 = null;
        this.o1 = null;
        this.p1 = null;
        this.q1 = null;
        this.r1 = null;
        this.s1 = false;
        this.w1 = null;
        this.x1 = null;
        this.y1 = null;
        this.z1 = null;
        this.A1 = null;
        this.B1 = false;
        this.C1 = -1000L;
        this.D1 = false;
        this.G1 = 0;
        this.H1 = false;
        this.K1 = "";
        this.L1 = false;
        this.g2 = true;
        this.h2 = false;
        this.i2 = null;
        this.k2 = false;
        this.m2 = new k(this);
        this.t2 = false;
        this.u2 = false;
        this.w2 = new v(this, CmdConfigHttp.REQUEST_BUBBLELIST_CMD);
        this.x2 = new g0(this, 2921494);
        this.y2 = new r0(this, 2921505);
        this.z2 = new v0(this);
        this.D2 = new w0(this, 2001011);
        this.E2 = new x0(this, 2921622);
        this.F2 = new y0(this, 2921516);
        this.G2 = new z0(this);
        this.H2 = false;
        this.I2 = 0;
        this.J2 = new b0(this);
        this.K2 = new d0(this);
    }

    public static Bitmap o5(String str, float f2) {
        InterceptResult invokeLF;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65595, null, str, f2)) == null) {
            int i2 = (int) f2;
            Bitmap bitmap2 = null;
            if (!oi.isEmpty(str) && i2 > 0) {
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

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void A2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z2) == null) {
            if (z2 || this.E1) {
                E2();
            }
        }
    }

    public final void A4() {
        CustomResponsedMessage runTask;
        v15 v15Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            boolean booleanValue = Y5().booleanValue();
            if (this.I0 || !booleanValue || !ik8.a() || !mh8.a(this.v.getForumName(), Boolean.TRUE) || (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, getActivity()), v15.class)) == null || (v15Var = (v15) runTask.getData()) == null) {
                return;
            }
            v15Var.l = 3;
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.f)) {
                return;
            }
            this.r0.d(v15Var);
        }
    }

    public final void A5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ImageView imageView = this.Y0;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            TextView textView = this.M;
            if (textView != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
                layoutParams.rightMargin = this.I2;
                this.M.setLayoutParams(layoutParams);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void A6(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z2) == null) || !TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) || this.t || V1() == null) {
            return;
        }
        this.P0.setPadding(0, 0, 0, 0);
        this.P0.setBackgroundDrawable(null);
        SkinManager.setBackgroundColor(this.P0, R.color.CAM_X0201);
        if (TextUtils.isEmpty(this.S0) || this.w != null) {
            return;
        }
        jg.h().m(this.S0, 19, new a0(this, z2), getUniqueId());
    }

    public final void B4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.w == null) {
            if (this.t0 == null) {
                jx8 jx8Var = new jx8(getActivity(), this.o);
                this.t0 = jx8Var;
                jx8Var.m(0);
                this.t0.n(SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1);
                if (this.E1) {
                    this.t0.p(false);
                }
            }
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.f)) {
                this.t0.j();
                this.t0.o(WriteActivityConfig.FROM_FORUM_SHARE);
                a7();
            }
            if (!ListUtils.isEmpty(this.B)) {
                this.t0.j();
            }
            this.t0.i();
            this.r0.d(this.t0);
        }
    }

    public final void B5() {
        WriteImagesInfo writeImagesInfo;
        LinkedList<ImageFileInfo> chosedFiles;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (writeImagesInfo = this.y) == null || writeImagesInfo.size() <= 0 || (chosedFiles = this.y.getChosedFiles()) == null) {
            return;
        }
        for (ImageFileInfo imageFileInfo : chosedFiles) {
            if (imageFileInfo != null) {
                X5(imageFileInfo);
            }
        }
    }

    public void B6() {
        WriteData writeData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (writeData = this.v) == null) {
            return;
        }
        this.r0.setToolEnabled(ListUtils.isEmpty(writeData.getItemDatas()) && !this.t1, 33);
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public boolean C2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            View view2 = this.R0;
            if (view2 != null && view2.getVisibility() == 0) {
                this.R0.setVisibility(8);
                return true;
            }
            b7();
            u6();
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void C4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && WriteActivityConfig.FROM_FORUM_SHARE.equals(this.f) && !StringUtils.isNull(this.R1)) {
            if (this.mCurrentPermissionJudgePolicy == null) {
                this.mCurrentPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
            this.mCurrentPermissionJudgePolicy.appendRequestPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mCurrentPermissionJudgePolicy.startRequestPermission(this)) {
                return;
            }
            InsertGalleryAsyncTask insertGalleryAsyncTask = new InsertGalleryAsyncTask(this, this.R1, new i0(this));
            insertGalleryAsyncTask.setFrom(1);
            insertGalleryAsyncTask.execute(new String[0]);
        }
    }

    public final void C5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            w4();
            t4();
            p4();
            q4();
            x4();
            B4();
        }
    }

    public void C6() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.r0.n(10) == null) {
            return;
        }
        WriteImagesInfo writeImagesInfo = this.y;
        this.r0.setToolEnabled(writeImagesInfo == null || ListUtils.getCount(writeImagesInfo.getChosedFiles()) < this.y.getMaxImagesAllowed(), 10);
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void D2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.v == null) {
            return;
        }
        String obj = W1() != null ? W1().getText().toString() : "";
        String trim = V1() != null ? V1().getText().toString().trim() : "";
        String trim2 = obj.trim();
        boolean z2 = false;
        if (this.v.getType() == 0 || this.v.getType() == 9 || this.v.getType() == 7) {
            PostPrefixData postPrefixData = this.d;
            if (postPrefixData != null && postPrefixData.getPrefixs().size() > 0) {
                if (this.l == ListUtils.getCount(this.d.getPrefixs()) - 1) {
                    if (TextUtils.isEmpty(trim2)) {
                        this.v.setIsNoTitle(true);
                    } else if (this.Q.getVisibility() == 0) {
                        this.v.setIsNoTitle(false);
                        P6(true);
                        return;
                    }
                } else if (this.Q.getVisibility() == 0 && !TextUtils.isEmpty(trim2)) {
                    this.v.setIsNoTitle(false);
                    P6(true);
                    return;
                }
            } else if (TextUtils.isEmpty(trim2)) {
                this.v.setIsNoTitle(true);
            } else if (this.Q.getVisibility() == 0) {
                this.v.setIsNoTitle(false);
                P6(true);
                return;
            }
        }
        if (this.y.getChosedFiles() != null && this.y.size() > 0) {
            if (!this.t) {
                P6(true);
                return;
            } else if (this.y.size() >= 1) {
                P6(true);
            }
        }
        if (this.v.getType() == 4) {
            if (d6(this.j1) && e6(this.n1)) {
                z2 = true;
            }
            P6(z2);
        } else if (this.v.getType() == 5) {
            P6(d6(this.j1));
        } else if (TextUtils.isEmpty(trim) && this.H0 == null) {
            if (x5()) {
                P6(true);
            } else {
                P6(false);
            }
        } else {
            P6(true);
        }
    }

    public final boolean D4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? ListUtils.isEmpty(this.v.getItemDatas()) && this.v.getVoiceModel() == null && this.v.getVideoInfo() == null && this.v.getWriteVoteData() == null && TextUtils.isEmpty(this.S.getText()) && (!this.t1 || this.Q0.t()) && (this.y.getChosedFiles() == null || this.y.size() == 0) : invokeV.booleanValue;
    }

    public final void D5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            AssociatedItemContainer associatedItemContainer = (AssociatedItemContainer) findViewById(R.id.obfuscated_res_0x7f0902ae);
            this.l2 = associatedItemContainer;
            associatedItemContainer.setOnDeletedListener(new i(this));
            this.l2.setOnAddedListener(new j(this));
        }
    }

    public void D6() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.v == null) {
            return;
        }
        this.r0.setToolEnabled((x5() || 10 - s5() != 0 || this.t1) ? false : true, 35);
    }

    public final boolean E4(WriteData writeData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, writeData)) == null) ? writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom())) : invokeL.booleanValue;
    }

    public final void E5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (b6()) {
                C5();
                return;
            }
            w4();
            y4();
            A4();
            v4();
            t4();
            p4();
            q4();
            x4();
            s4();
            B4();
        }
    }

    public void E6() {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            iy8 iy8Var = this.n2;
            if (iy8Var != null && iy8Var.f() == null && (spanGroupEditText = this.S) != null && spanGroupEditText.getSpanGroupManager() != null) {
                this.n2.i(this.S.getSpanGroupManager().D());
                this.n2.h();
            } else {
                iy8 iy8Var2 = this.n2;
                if (iy8Var2 != null && iy8Var2.f() != null) {
                    this.n2.h();
                }
            }
            iy8 iy8Var3 = this.n2;
            if (iy8Var3 != null) {
                if (iy8Var3.getCount() == 0) {
                    this.A2.setVisibility(8);
                } else {
                    this.A2.setVisibility(0);
                }
            }
            iy8 iy8Var4 = this.n2;
            if (iy8Var4 != null) {
                Q6(iy8Var4.d());
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void F1(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, editable) == null) {
            super.F1(editable);
            if (this.d2) {
                u4(editable);
            }
        }
    }

    public void F4(boolean z2) {
        AssociatedItemContainer associatedItemContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048595, this, z2) == null) || (associatedItemContainer = this.l2) == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) associatedItemContainer.getLayoutParams();
        if (z2) {
            layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.M_H_X004);
        } else {
            layoutParams.topMargin = 0;
        }
        this.l2.setLayoutParams(layoutParams);
    }

    public final void F5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            View findViewById = this.I.findViewById(R.id.obfuscated_res_0x7f0918b0);
            this.k1 = findViewById;
            this.m1 = findViewById.findViewById(R.id.obfuscated_res_0x7f0912f7);
            this.j1 = (EditText) this.k1.findViewById(R.id.obfuscated_res_0x7f0912f4);
            this.h1 = (GridView) this.k1.findViewById(R.id.obfuscated_res_0x7f0918aa);
            this.n1 = (EditText) this.k1.findViewById(R.id.obfuscated_res_0x7f0912f6);
            this.o1 = (TextView) this.k1.findViewById(R.id.obfuscated_res_0x7f0920c2);
            this.p1 = (TextView) this.k1.findViewById(R.id.obfuscated_res_0x7f0906b0);
            this.l1 = this.k1.findViewById(R.id.obfuscated_res_0x7f0912ef);
            this.o1.setText(String.valueOf(20));
            this.p1.setText(String.valueOf(233));
            this.k1.setVisibility(0);
            this.o1.setVisibility(0);
            this.p1.setVisibility(0);
            this.n1.setHint(R.string.obfuscated_res_0x7f0f13d8);
            this.n1.setOnFocusChangeListener(new a(this));
            if (this.v.getType() == 4) {
                this.j1.setHint(R.string.obfuscated_res_0x7f0f09ff);
            } else if (this.v.getType() == 5) {
                this.j1.setHint(R.string.obfuscated_res_0x7f0f0a00);
            }
            this.j1.setOnFocusChangeListener(new b(this));
            this.j1.requestFocus();
            this.j1.addTextChangedListener(t5());
            this.n1.requestFocus();
            this.n1.addTextChangedListener(t5());
            this.n1.setOnClickListener(this.D0);
            this.j1.setOnClickListener(this.D0);
            by8 by8Var = new by8(this, this.y, this.h1);
            this.i1 = by8Var;
            by8Var.n(6);
            this.h1.setAdapter((ListAdapter) this.i1);
            View findViewById2 = this.k1.findViewById(R.id.obfuscated_res_0x7f0912f5);
            findViewById2.bringToFront();
            ((PhotoLiveLinearLayout) findViewById2).setOnChangeLayoutListener(new c(this));
            z6();
        }
    }

    public final void F6(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z2) == null) {
            WriteData writeData = this.v;
            String forumId = writeData == null ? "" : writeData.getForumId();
            ny8 ny8Var = this.g1;
            if (ny8Var != null) {
                ny8Var.k(this.y, this.f, forumId);
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void G1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.G1();
            v5();
            J6();
            P5();
            if (this.t) {
                this.i1.m(this.r0);
            } else {
                this.S.requestFocus();
            }
            C4();
            this.G2.setPriority(1);
            registerResponsedEventListener(GoodsEvent.class, this.G2);
            L5();
            if (this.h2) {
                X4(this.v);
                D2();
                G5();
            }
            k6();
            m6();
        }
    }

    public final void G4(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, hotTopicBussinessData) == null) || hotTopicBussinessData == null || (hotTopicBussinessData2 = (HotTopicBussinessData) ListUtils.getItem(this.B, 0)) == null || TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            return;
        }
        SpannableString i2 = jd5.i(jd5.a(hotTopicBussinessData.mTopicName));
        if (i2 != null) {
            this.N.setText(i2);
        }
        this.i0.setText(hotTopicBussinessData.mForumName);
    }

    public final void G5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.J.postDelayed(this.K2, 500L);
        }
    }

    public final void G6(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, editable) == null) {
            if (!TextUtils.isEmpty(editable) && editable.length() >= 20 && editable.length() <= 500 && this.V1.e()) {
                this.L.setEnabled(true);
            } else {
                this.L.setEnabled(false);
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void H1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.H1();
            if (this.k2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921583));
            }
            if (this.v.getType() == 0) {
                f6(this.G1);
            }
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
            this.A2 = (ListView) this.I.findViewById(R.id.obfuscated_res_0x7f090661);
            iy8 iy8Var = new iy8(getPageContext());
            this.n2 = iy8Var;
            iy8Var.j(this.m2);
            this.A2.setAdapter((ListAdapter) this.n2);
            this.A2.setOnItemClickListener(new c0(this));
        }
    }

    public void H6() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || this.r0.n(34) == null) {
            return;
        }
        boolean z2 = true;
        this.r0.setToolEnabled(this.E1 ? false : (ListUtils.getCount(this.y.getChosedFiles()) > 0 || this.H0 != null || this.t1) ? false : false, 34);
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void I1(@NonNull NewVcodeActivityConfig newVcodeActivityConfig) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048606, this, newVcodeActivityConfig) == null) && this.K0) {
            newVcodeActivityConfig.setHideFeedBackButton();
        }
    }

    public final void I4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            if (D4()) {
                if (this.t1) {
                    p6();
                    H4(1);
                } else {
                    q6();
                    H4(2);
                }
                this.t1 = !this.t1;
                F6(true);
                m6();
                return;
            }
            BdTopToast bdTopToast = new BdTopToast(this);
            bdTopToast.i(false);
            bdTopToast.h(getResources().getString(R.string.obfuscated_res_0x7f0f051c));
            bdTopToast.j((ViewGroup) this.I);
            H4(0);
        }
    }

    public final void I5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && this.E1) {
            LocalChannelTopicSelectView localChannelTopicSelectView = (LocalChannelTopicSelectView) findViewById(R.id.obfuscated_res_0x7f092529);
            this.S1 = localChannelTopicSelectView;
            localChannelTopicSelectView.setVisibility(0);
            this.S1.setLocalChannelTopic(this.F1);
        }
    }

    public void I6() {
        WriteData writeData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || (writeData = this.v) == null) {
            return;
        }
        this.r0.setToolEnabled(ListUtils.isEmpty(writeData.getItemDatas()) && !this.t1, 32);
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void J1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            super.J1();
            d7();
            this.H2 = true;
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public boolean J2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            if (super.J2()) {
                WriteData writeData = this.v;
                String forumId = writeData == null ? "" : writeData.getForumId();
                ny8 ny8Var = this.g1;
                if (ny8Var != null) {
                    ny8Var.k(this.y, this.f, forumId);
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean J4() {
        InterceptResult invokeV;
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.H1 || (spanGroupEditText = this.S) == null || spanGroupEditText.getSpanGroupManager() == null || this.S.getSpanGroupManager().x() <= 0 : invokeV.booleanValue;
    }

    public final void J5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(10);
            arrayList.add(5);
            this.r0.h(arrayList);
            v15 n2 = this.r0.n(5);
            if (n2 != null) {
                n2.l = 2;
            }
            this.r0.d(new x15(getActivity(), 3));
            this.r0.d(new f25(getActivity(), 6));
        }
    }

    public final void J6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921500, new n0(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void K1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, bundle) == null) {
            super.K1(bundle);
            if (bundle != null) {
                this.E1 = bundle.getBoolean(WriteActivityConfig.KEY_POST_LOCAL_CHANNEL_DYNAMIC);
                this.F1 = bundle.getString(WriteActivityConfig.KEY_LOCAL_CHANNEL_TOPIC);
            } else if (getIntent() != null) {
                Intent intent = getIntent();
                this.E1 = intent.getBooleanExtra(WriteActivityConfig.KEY_POST_LOCAL_CHANNEL_DYNAMIC, false);
                this.F1 = intent.getStringExtra(WriteActivityConfig.KEY_LOCAL_CHANNEL_TOPIC);
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void K2(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, postWriteCallBackData) == null) {
            if (WriteActivityConfig.FROM_ADD_PHOTO_LIVE_IN_MISSON.equals(this.f)) {
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUCCES_IN_MISSON);
            }
            super.K2(postWriteCallBackData);
        }
    }

    public final void K4() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048617, this) == null) || (editorTools = this.r0) == null) {
            return;
        }
        editorTools.post(new l0(this));
    }

    public final void K5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            PostPrefixData postPrefixData = this.d;
            if (postPrefixData != null && postPrefixData.getPrefixs().size() > 1) {
                this.e0.setVisibility(0);
                this.T.setVisibility(0);
                this.M1.l0(getString(R.string.obfuscated_res_0x7f0f159b), "write_title_prefix_tip_key", true);
                ArrayList<String> prefixs = this.d.getPrefixs();
                int size = prefixs.size();
                this.l = 0;
                this.e0.setOnClickListener(new r(this));
                this.b0.setOnClickListener(new s(this));
                int color = SkinManager.getColor(R.color.CAM_X0105);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.d0, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, null);
                vr4 d2 = vr4.d(this.b0);
                d2.v(R.color.CAM_X0105);
                d2.A(R.string.F_X02);
                d2.f(R.color.CAM_X0201);
                this.U.clear();
                for (int i2 = 0; i2 < size; i2++) {
                    WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                    this.U.add(writePrefixItemLayout);
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
                    this.c0.a(writePrefixItemLayout);
                }
                this.c0.c(0);
                this.b0.setText(prefixs.get(0));
                G2(0);
                return;
            }
            this.e0.setVisibility(8);
            this.T.setVisibility(8);
        }
    }

    public final void K6() {
        WriteImagesInfo writeImagesInfo;
        ImageFileInfo imageFileInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048619, this) == null) || (writeImagesInfo = this.y) == null || writeImagesInfo.getChosedFiles() == null || this.y.size() <= 0 || (imageFileInfo = this.y.getChosedFiles().get(this.y.size() - 1)) == null || TextUtils.isEmpty(imageFileInfo.getFilePath()) || !imageFileInfo.getFilePath().startsWith("android.resource://")) {
            return;
        }
        this.y.getChosedFiles().remove(this.y.size() - 1);
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public boolean L1(WriteData writeData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, writeData)) == null) ? E4(writeData) || WriteActivityConfig.FROM_FORUM_SHARE.equals(this.f) : invokeL.booleanValue;
    }

    public final boolean L4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            FrsTabInfoData frsTabInfoData = this.D;
            if (frsTabInfoData != null && !ListUtils.isEmpty(frsTabInfoData.tabList)) {
                for (FrsTabItemData frsTabItemData : this.D.tabList) {
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
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            t6(this.i2);
        }
    }

    public final void L6() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048623, this) == null) || (editorTools = this.r0) == null) {
            return;
        }
        editorTools.A(new k15(57, 15, null));
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void M1() {
        k25 k25Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            super.M1();
            EditorTools editorTools = this.r0;
            if (editorTools != null) {
                editorTools.setDeskLauncherEnabled(!this.p);
                this.r0.setToolEnabled(true, 2);
                this.r0.setToolEnabled(true, 30);
                this.r0.setToolEnabled(false, 34);
                if (this.E1) {
                    this.r0.setToolEnabled(false, 31);
                }
                v15 n2 = this.r0.n(5);
                if (n2 != null) {
                    n2.d(true);
                }
                jx8 jx8Var = this.t0;
                if (jx8Var != null && !this.E1) {
                    jx8Var.p(true);
                }
                C6();
                H6();
                D6();
                B6();
                I6();
                if (this.d2 && (k25Var = this.C2) != null && !k25Var.c()) {
                    this.r0.setToolEnabled(false, 31);
                } else {
                    this.r0.setToolEnabled(!this.t1, 31);
                }
                this.r0.setToolEnabled(!this.t1, 6);
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void M2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            if (this.v.getType() == 7) {
                this.L = this.J.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.obfuscated_res_0x7f0f1396));
            } else {
                String string = getPageContext().getString(R.string.obfuscated_res_0x7f0f10d1);
                if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.f)) {
                    string = getPageContext().getString(R.string.obfuscated_res_0x7f0f10eb);
                }
                this.L = this.J.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, string);
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.L.getLayoutParams();
            layoutParams.rightMargin = pi.f(getPageContext().getPageActivity(), R.dimen.tbds2);
            this.L.setLayoutParams(layoutParams);
            this.L.setOnFocusChangeListener(this.E0);
        }
    }

    public final boolean M4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? "2".equals(this.o) && this.U1 == null && TextUtils.isEmpty(this.v.getForumName()) : invokeV.booleanValue;
    }

    public final void M5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            this.o2 = (LinearLayout) this.I.findViewById(R.id.obfuscated_res_0x7f0919b9);
            this.p2 = (ImageView) this.I.findViewById(R.id.obfuscated_res_0x7f0919be);
            TextView textView = (TextView) this.I.findViewById(R.id.obfuscated_res_0x7f0919bb);
            this.q2 = textView;
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0107);
            EBusinessProtocolView eBusinessProtocolView = new EBusinessProtocolView(this, EBusinessProtocolView.WindowType.PROTOCOL);
            this.s2 = eBusinessProtocolView;
            eBusinessProtocolView.o(getResources().getString(R.string.obfuscated_res_0x7f0f0f02));
            this.s2.i("file:///android_asset/protocol.html");
            SpannableString spannableString = new SpannableString(getResources().getString(R.string.obfuscated_res_0x7f0f0f4a));
            spannableString.setSpan(new n(this), 6, 17, 34);
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0302)), 6, 17, 34);
            this.q2.setText(spannableString);
            this.q2.setMovementMethod(LinkMovementMethod.getInstance());
            this.p2.setOnClickListener(new o(this));
            yt4 k2 = yt4.k();
            if (k2.h(TbadkCoreApplication.getCurrentAccount() + "is_agree_protocol", false)) {
                this.t2 = true;
                this.p2.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08080c, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
            } else {
                this.t2 = false;
                this.p2.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809ef, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
            }
            this.s2.m(new p(this));
        }
    }

    public void M6() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048628, this) == null) || (editorTools = this.r0) == null) {
            return;
        }
        editorTools.A(new k15(65, 15, null));
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public boolean N1(PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, postWriteCallBackData)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public boolean N2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? !this.d2 : invokeV.booleanValue;
    }

    public final int N4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            iy8 iy8Var = this.n2;
            boolean z2 = iy8Var == null || iy8Var.e();
            ForumTabSelectedView forumTabSelectedView = this.j0;
            boolean z3 = (forumTabSelectedView == null || forumTabSelectedView.getSelectedTabItemData() == null || this.j0.getSelectedTabItemData().tabType != 3) ? false : true;
            if (z2 && z3) {
                return 1;
            }
            return (z2 || z3) ? 0 : 2;
        }
        return invokeV.intValue;
    }

    public final void N5() {
        WriteData writeData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048632, this) == null) || this.M == null || (writeData = this.v) == null || writeData.getProZone() != 1) {
            return;
        }
        this.M.setText(R.string.obfuscated_res_0x7f0f15aa);
    }

    public final void N6(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, bool) == null) {
            WriteData writeData = this.v;
            if (getPageContext().getString(R.string.obfuscated_res_0x7f0f05fc).equals(writeData != null ? writeData.getForumName() : null)) {
                this.I0 = true;
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void O1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            super.O1();
            this.r0.setMoreVipIcon(b6());
            this.r0.setShouldShowMorePopTip(!this.E1);
            int type = this.v.getType();
            if (type != 4 && type != 5) {
                E5();
            } else {
                J5();
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public boolean O2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? super.O2() && !this.I0 : invokeV.booleanValue;
    }

    public final void O4(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048636, this, str) == null) || oi.isEmpty(str) || this.z1 == null) {
            return;
        }
        p5(str);
        this.z1.dismiss();
    }

    public final void O5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.M.getLayoutParams();
            this.I2 = layoutParams.rightMargin;
            layoutParams.rightMargin = 0;
            this.M.setLayoutParams(layoutParams);
            ImageView imageView = (ImageView) this.J.getCenterImgBox();
            this.Y0 = imageView;
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080906, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL));
            int f2 = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            int f3 = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds47);
            this.Y0.setPadding(f2, f2, f2, f2);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.Y0.getLayoutParams();
            int i2 = f3 + f2 + f2;
            layoutParams2.width = i2;
            layoutParams2.height = i2;
            this.Y0.setLayoutParams(layoutParams2);
            this.Y0.setOnClickListener(new q(this));
            this.Y0.setVisibility(0);
        }
    }

    public final void O6(TextView textView, EditText editText) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048638, this, textView, editText) == null) || textView == null || editText == null) {
            return;
        }
        long m5 = m5(editText);
        long k5 = m5 - k5(editText);
        String valueOf = String.valueOf(k5);
        if (m5 == 20) {
            if (k5 < 0) {
                if (k5 < -9) {
                    valueOf = "-∞";
                }
                textView.setTextColor(SkinManager.getColor(R.color.common_color_10159));
            } else {
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            }
        } else if (k5 < 0) {
            if (k5 < -99) {
                valueOf = "-∞";
            }
            textView.setTextColor(SkinManager.getColor(R.color.common_color_10159));
        } else {
            textView.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
        }
        textView.setText(valueOf);
    }

    public final void P4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            if (this.v.getType() != 0 && this.v.getType() != 9 && this.v.getType() != 11) {
                if (this.v.getType() == 1) {
                    rh8.w(this.v.getThreadId(), null);
                }
            } else if (this.g2) {
                if (this.E1) {
                    rh8.t(null);
                } else if (this.v.isEvaluate()) {
                    rh8.q(this.v.getItem_id(), null);
                } else if (TextUtils.isEmpty(this.v.getTopicId())) {
                    rh8.s(this.v.getForumId(), this.v, true);
                } else {
                    rh8.y(this.v.getTopicId(), null);
                }
            }
            this.H2 = true;
        }
    }

    public final void P5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048640, this) == null) && this.w1 != null && this.v.getType() == 0 && this.v.getType() == 9 && this.v.getType() == 11) {
            i5(getActivity());
            View inflate = getPageContext().getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0724, (ViewGroup) null);
            this.y1 = inflate;
            inflate.setOnClickListener(new j0(this));
            this.x1 = (TbImageView) this.y1.findViewById(R.id.obfuscated_res_0x7f091a42);
            this.A1 = (LinearLayout) this.y1.findViewById(R.id.obfuscated_res_0x7f091a41);
            if (yt4.k().q("write_rec_pic_path", "").equalsIgnoreCase(this.w1.getAbsolutePath())) {
                return;
            }
            yt4.k().y("write_rec_pic_path", this.w1.getAbsolutePath());
            Bitmap o5 = o5(this.w1.getAbsolutePath(), getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070252));
            if (o5 != null) {
                this.x1.setImageBitmap(o5);
                this.x1.setDrawBorder(true);
                this.x1.setBorderWidth(2);
                this.x1.setBorderColor(SkinManager.getColor(R.color.common_color_10264));
                Dialog dialog = new Dialog(getActivity(), R.style.obfuscated_res_0x7f10039f);
                this.z1 = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.z1.setOnDismissListener(new k0(this));
                this.z1.setContentView(this.y1);
                this.z1.show();
                Window window = this.z1.getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                window.setGravity(83);
                attributes.x = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701f9);
                attributes.y = (L2 / 18) + getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07023b);
                attributes.width = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070257);
                attributes.height = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070291);
                window.setAttributes(attributes);
            }
        }
    }

    public void P6(boolean z2) {
        SpanGroupEditText spanGroupEditText;
        WriteEvaluationHeaderView writeEvaluationHeaderView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048641, this, z2) == null) {
            if (z2 && this.d2 && ((spanGroupEditText = this.S) == null || TextUtils.isEmpty(spanGroupEditText.getText()) || this.S.getText().length() < 20 || this.S.getText().length() > 500 || (writeEvaluationHeaderView = this.V1) == null || !writeEvaluationHeaderView.e())) {
                return;
            }
            this.L.setEnabled(z2);
        }
    }

    public final void Q4(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048642, this, intent) == null) || this.y == null) {
            return;
        }
        e5(intent);
        int size = this.y.size() - 1;
        if (size <= -1 || this.y.getChosedFiles() == null || this.y.size() < 1) {
            return;
        }
        sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.y, size)));
    }

    public final void Q5(SelectForumData selectForumData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048643, this, selectForumData) == null) || selectForumData == null) {
            return;
        }
        this.U1 = selectForumData;
        WriteData writeData = this.v;
        if (writeData != null) {
            writeData.setForumId(selectForumData.forumId);
            this.v.setForumName(this.U1.forumName);
            SpanGroupEditText spanGroupEditText = this.S;
            if (spanGroupEditText != null) {
                spanGroupEditText.setForumId(ng.g(this.U1.forumId, 0L));
            }
        }
        this.T1.setSelectedForum(this.U1.forumName);
        this.D = null;
        if (!ListUtils.isEmpty(this.U1.tabInfoList)) {
            FrsTabInfoData frsTabInfoData = new FrsTabInfoData();
            this.D = frsTabInfoData;
            frsTabInfoData.selectedTabId = -1;
            SelectForumData selectForumData2 = this.U1;
            List<FrsTabItemData> list = selectForumData2.tabInfoList;
            frsTabInfoData.tabList = list;
            if (selectForumData2.isForumBusinessAccount && list != null) {
                FrsTabItemData frsTabItemData = new FrsTabItemData();
                frsTabItemData.tabId = 505;
                frsTabItemData.name = "官方";
                this.D.tabList.add(0, frsTabItemData);
            }
            this.D.isForumBusinessAccount = this.U1.isForumBusinessAccount;
        }
        this.j0.setData(this.D);
        WriteData writeData2 = this.v;
        if (writeData2 != null) {
            writeData2.setFrsTabInfoData(this.D);
        }
        if (this.j0.getVisibility() == 0) {
            this.X1.setVisibility(0);
        }
        this.d = null;
        PostPrefixData postPrefixData = this.U1.postPrefix;
        if (postPrefixData != null && !ListUtils.isEmpty(postPrefixData.getPrefixs())) {
            PostPrefixData postPrefixData2 = this.U1.postPrefix;
            this.d = postPrefixData2;
            postPrefixData2.getPrefixs().add(getPageContext().getString(R.string.obfuscated_res_0x7f0f158a));
        }
        K5();
    }

    public final void Q6(List<lo4> list) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048644, this, list) == null) || list == null) {
            return;
        }
        boolean z2 = false;
        Iterator<lo4> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().b == 2) {
                z2 = true;
                break;
            }
        }
        if (z2 || (linearLayout = this.o2) == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public boolean R1(@NonNull PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048645, this, postWriteCallBackData)) == null) ? !dp8.d(postWriteCallBackData.getErrorCode()) : invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public boolean R2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void R4(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, intent) == null) {
            if (this.t) {
                c5(intent);
                g7();
            } else if (this.t1) {
                d5(intent);
            } else {
                b5(intent);
            }
            D2();
        }
    }

    public final void R5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048648, this) == null) {
            if ("main_tab".equals(this.f) && !this.h2) {
                ForumSelectedView forumSelectedView = (ForumSelectedView) findViewById(R.id.obfuscated_res_0x7f092533);
                this.T1 = forumSelectedView;
                forumSelectedView.setVisibility(0);
            } else if (this.u1 || a6() || c6()) {
                ForumSelectedView forumSelectedView2 = (ForumSelectedView) findViewById(R.id.obfuscated_res_0x7f092533);
                this.T1 = forumSelectedView2;
                forumSelectedView2.setVisibility(0);
                this.T1.setSelectedForum(this.v.getForumName());
                this.T1.a();
                this.T1.setOnClickListener(null);
            }
        }
    }

    public final void R6(EvaluateRelevanceItemSelectedMessage evaluateRelevanceItemSelectedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, evaluateRelevanceItemSelectedMessage) == null) {
            WriteEvaluationHeaderView writeEvaluationHeaderView = this.V1;
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
                this.v.setItemInfo(tbRichTextEvaluateItemInfo);
                this.V1.setItemInfo(tbRichTextEvaluateItemInfo);
                return;
            }
            ItemData itemData = new ItemData();
            itemData.itemId = ng.g(evaluateRelevanceItemSelectedMessage.item_id, 0L);
            itemData.mTags = evaluateRelevanceItemSelectedMessage.tags;
            itemData.mScore = evaluateRelevanceItemSelectedMessage.score;
            itemData.mStar = evaluateRelevanceItemSelectedMessage.star;
            itemData.mIconUrl = evaluateRelevanceItemSelectedMessage.icon_url;
            itemData.mIconSize = evaluateRelevanceItemSelectedMessage.icon_size;
            itemData.mTitle = evaluateRelevanceItemSelectedMessage.item_name;
            o4(itemData);
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void S1(AtListActivityConfig atListActivityConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, atListActivityConfig) == null) {
            if (this.u1 && this.t1) {
                atListActivityConfig.setSelectedAtList(this.Q0.getAtDataInText());
            } else if (V1() instanceof SpanGroupEditText) {
                atListActivityConfig.setSelectedAtList(((SpanGroupEditText) V1()).getAtDataInText());
            }
        }
    }

    public final void S4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048651, this) == null) || TbadkCoreApplication.getCurrentAccountObj() == null) {
            return;
        }
        sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
    }

    public final void S5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048652, this) == null) {
            if (this.u1 && this.t1) {
                B5();
            }
            if (this.t1) {
                q6();
            } else {
                p6();
            }
        }
    }

    public final void S6() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048653, this) == null) || (editorTools = this.r0) == null) {
            return;
        }
        editorTools.post(new d(this));
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public int T1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) ? R.color.CAM_X0201 : invokeV.intValue;
    }

    public final void T4(Intent intent) {
        String stringExtra;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048655, this, intent) == null) || intent == null || (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) == null) {
            return;
        }
        this.f1.parseJson(stringExtra);
        this.f1.updateQuality();
        if (this.f1.getChosedFiles() != null && this.f1.getChosedFiles().size() > 0) {
            sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) TaskResponseData.ERROR_NO_TASK_OFFLINE_03, 12009, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.f1.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
        }
        this.f1.clear();
    }

    public final void T5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048656, this) == null) {
            this.b2 = (RelativeLayout) this.I.findViewById(R.id.obfuscated_res_0x7f0924a3);
            this.a2 = new xy8(getPageContext(), this.b2);
            Y6();
        }
    }

    public final void T6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048657, this) == null) {
            if (this.u0 == null) {
                this.u0 = new ly8(getPageContext());
            }
            this.u0.c(this.r0);
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity, com.repackage.rw8.a
    public void U0(int i2) {
        PostPrefixData postPrefixData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048658, this, i2) == null) || (postPrefixData = this.d) == null) {
            return;
        }
        if (i2 == ListUtils.getCount(postPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new StatisticItem("c13014").param("obj_type", 1));
        } else {
            TiebaStatic.log(new StatisticItem("c13014").param("obj_type", 2));
        }
        super.U0(i2);
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public int U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) ? b6() ? 3 : 5 : invokeV.intValue;
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void U2() {
        WriteData writeData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048660, this) == null) || (writeData = this.v) == null) {
            return;
        }
        int type = writeData.getType();
        if (type != 0) {
            if (type == 7) {
                this.N.setVisibility(0);
                this.S.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                this.M.setText(R.string.obfuscated_res_0x7f0f0ea4);
                return;
            } else if (type != 9) {
                if (type == 11) {
                    this.M.setText(R.string.obfuscated_res_0x7f0f0f05);
                    this.N.setVisibility(0);
                    this.S.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                } else if (type == 4) {
                    this.M.setText(R.string.obfuscated_res_0x7f0f0f09);
                    this.S.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                } else if (type != 5) {
                    this.M.setText(R.string.obfuscated_res_0x7f0f10d3);
                    this.S.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.N.setVisibility(8);
                    return;
                } else {
                    this.M.setText(getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f1484, Integer.valueOf(this.v.getFloorNum() + 1)));
                    this.l1.setVisibility(8);
                    return;
                }
            }
        }
        if (!this.I0 && !this.s) {
            if (this.E1) {
                this.M.setText(R.string.obfuscated_res_0x7f0f0eb0);
            } else if (this.u1) {
                if (this.t1) {
                    this.M.setText(R.string.obfuscated_res_0x7f0f0fd7);
                } else {
                    this.M.setText(R.string.obfuscated_res_0x7f0f0c29);
                }
            } else {
                String str = this.o;
                if (str != null && str.equals("1")) {
                    this.M.setText(R.string.obfuscated_res_0x7f0f0eb4);
                } else {
                    String str2 = this.o;
                    if (str2 != null && str2.equals("2")) {
                        if (this.d2) {
                            this.M.setText(R.string.obfuscated_res_0x7f0f0f05);
                        } else if (b6()) {
                            this.M.setText(R.string.obfuscated_res_0x7f0f0ea0);
                        } else {
                            this.M.setText(R.string.obfuscated_res_0x7f0f0eb5);
                        }
                    } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.f)) {
                        this.M.setText(getResources().getString(R.string.obfuscated_res_0x7f0f1123) + this.v.getForumName() + getResources().getString(R.string.obfuscated_res_0x7f0f02d5));
                        this.N.setVisibility(8);
                        String str3 = this.P1 + " " + this.Q1;
                        if (!StringUtils.isNull(str3)) {
                            this.S.setText(str3);
                        }
                    } else {
                        this.M.setText("");
                    }
                }
            }
        } else if (this.K0) {
            this.M.setText(R.string.obfuscated_res_0x7f0f05ff);
        } else {
            this.M.setText(R.string.obfuscated_res_0x7f0f05fb);
        }
        this.N.setVisibility(0);
        this.S.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
    }

    public final void U4(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048661, this, editable) == null) {
            if (editable.length() > 500) {
                this.W1.setText((500 - editable.length()) + "/500");
                this.W1.setVisibility(0);
                return;
            }
            this.W1.setVisibility(4);
        }
    }

    public final void U5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048662, this) == null) && this.d2) {
            this.V1.setVisibility(0);
            if (this.e2) {
                this.V1.setShowItemInfo(false);
            }
            if (this.c2 != null) {
                TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo = new TbRichTextEvaluateItemInfo();
                tbRichTextEvaluateItemInfo.setItemID(String.valueOf(this.c2.id));
                tbRichTextEvaluateItemInfo.setTags(this.c2.tags);
                tbRichTextEvaluateItemInfo.setScore(this.c2.averageScore);
                tbRichTextEvaluateItemInfo.setStar(r5(this.c2.averageScore));
                tbRichTextEvaluateItemInfo.setIconUrl(this.c2.icon_url);
                tbRichTextEvaluateItemInfo.setIconSize(this.c2.icon_size);
                tbRichTextEvaluateItemInfo.setTitle(this.c2.name);
                this.V1.setItemInfo(tbRichTextEvaluateItemInfo);
                this.V1.setStarCount(this.f2);
                this.v.setItemInfo(tbRichTextEvaluateItemInfo);
                this.v.setEvaluationStar(this.f2);
            } else if (this.v.getItemInfo() != null) {
                this.V1.setItemInfo(this.v.getItemInfo());
                this.V1.setStarCount(this.v.getEvaluationStar());
            }
        }
    }

    public void U6(boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048663, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (z2) {
                if (!this.t1) {
                    this.g1.g().setVisibility(0);
                    F4(true);
                }
                A6(false);
            } else {
                this.y.clear();
                this.g1.g().setVisibility(8);
                F4(false);
                y5();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001353, Boolean.FALSE));
            }
            D2();
            M1();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public EditText V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) ? this.t ? this.j1 : this.t1 ? this.Q0.getLastFocusEdit() : this.S : (EditText) invokeV.objValue;
    }

    public final void V4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048665, this) == null) {
            new h0(this).execute(new Void[0]);
        }
    }

    public final void V5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048666, this) == null) && this.d2) {
            this.W1 = (TextView) findViewById(R.id.obfuscated_res_0x7f09192b);
            WriteEvaluationHeaderView writeEvaluationHeaderView = (WriteEvaluationHeaderView) findViewById(R.id.obfuscated_res_0x7f092523);
            this.V1 = writeEvaluationHeaderView;
            writeEvaluationHeaderView.setStarChangeListener(new l(this));
            this.V1.setItemCloseListener(new m(this));
        }
    }

    public final void V6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048667, this) == null) {
            EBusinessProtocolView eBusinessProtocolView = new EBusinessProtocolView(this, EBusinessProtocolView.WindowType.TIP);
            eBusinessProtocolView.o(getResources().getString(R.string.obfuscated_res_0x7f0f13d1));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f13be)).append((CharSequence) "\n");
            spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f13bf)).append((CharSequence) "\n");
            spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f13c0)).append((CharSequence) "\n");
            spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f13c1)).append((CharSequence) "\n");
            spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f13c2));
            eBusinessProtocolView.k(spannableStringBuilder);
            sg.i(eBusinessProtocolView, this);
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public EditText W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) ? this.t ? this.n1 : this.N : (EditText) invokeV.objValue;
    }

    public final void W4() {
        w15 w15Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048669, this) == null) {
            VoiceData.VoiceModel voiceModel = this.H0;
            if (voiceModel != null) {
                fw4.a(fw4.b(voiceModel.voiceId));
            }
            this.H0 = null;
            this.v.setVoiceModel(null);
            this.T0.setVisibility(8);
            this.U0.p();
            this.U0.setVoiceModel(null);
            v15 n2 = this.r0.n(6);
            if (n2 != null && (w15Var = n2.m) != null) {
                w15Var.C(new k15(52, 0, null));
            }
            D2();
        }
    }

    public final void W5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048670, this) == null) {
            u0().onCreate(getPageContext());
        }
    }

    public final void W6() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048671, this) == null) || yt4.k().h("key_virtual_image_setting_guide_has_show", false)) {
            return;
        }
        yt4.k().u("key_virtual_image_setting_guide_has_show", true);
        ((ViewStub) findViewById(R.id.obfuscated_res_0x7f092478)).inflate();
        View findViewById = findViewById(R.id.obfuscated_res_0x7f092477);
        this.R0 = findViewById;
        findViewById.setVisibility(0);
        this.R0.setOnClickListener(new o0(this));
        vr4 d2 = vr4.d(this.R0);
        d2.e(R.string.A_X05);
        d2.f(R.color.CAM_X0611);
        vr4 d3 = vr4.d(this.R0.findViewById(R.id.obfuscated_res_0x7f092474));
        d3.n(R.string.J_X06);
        d3.f(R.color.CAM_X0201);
        ((GifView) this.R0.findViewById(R.id.obfuscated_res_0x7f092473)).setGifRaw(R.raw.obfuscated_res_0x7f11006f);
        vr4 d4 = vr4.d(this.R0.findViewById(R.id.obfuscated_res_0x7f092471));
        d4.n(R.string.J_X07);
        d4.f(R.color.CAM_X0205);
        i08 a2 = i08.a();
        vr4.d((TextView) this.R0.findViewById(R.id.obfuscated_res_0x7f092475)).v(R.color.CAM_X0105);
        vr4.d((TextView) this.R0.findViewById(R.id.obfuscated_res_0x7f092472)).v(R.color.CAM_X0105);
        TextView textView = (TextView) this.R0.findViewById(R.id.obfuscated_res_0x7f09246f);
        if (a2 != null && a2.b() == 1) {
            textView.setVisibility(8);
        } else {
            vr4 d5 = vr4.d(textView);
            d5.A(R.string.F_X01);
            d5.z(R.dimen.T_X07);
            d5.v(R.color.CAM_X0304);
            d5.n(R.string.J_X07);
            d5.l(R.dimen.L_X02);
            d5.k(R.color.CAM_X0304);
            d5.j(R.string.A_X07);
            textView.setOnClickListener(new p0(this));
        }
        this.R0.postDelayed(new q0(this), 4000L);
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void X2(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048672, this, view2) == null) {
            super.X2(view2);
            if (view2 == this.S || !(view2 instanceof SpanGroupEditText)) {
                return;
            }
            Object tag = view2.getTag(R.id.obfuscated_res_0x7f090fc7);
            if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                this.p = false;
                M1();
                pi.M(getActivity(), view2);
                EditorTools editorTools = this.r0;
                if (editorTools != null) {
                    editorTools.q();
                }
            }
        }
    }

    public final void X4(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048673, this, writeData) == null) {
            this.v.setContent(writeData.getContent());
            SpannableString t2 = TbFaceManager.i().t(getPageContext().getPageActivity(), this.v.getContent(), this.x0);
            InputFilter[] filters = this.S.getFilters();
            this.S.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50000)});
            V1().setText(t2);
            EditText V1 = V1();
            SpanGroupEditText spanGroupEditText = this.S;
            if (V1 == spanGroupEditText && spanGroupEditText.getSpanGroupManager() != null) {
                this.S.h();
                this.S.getSpanGroupManager().r();
                this.S.c();
                E6();
            }
            this.S.setFilters(filters);
            if (V1().getText() != null) {
                V1().setSelection(V1().getText().length());
            }
            if (this.t) {
                O6(this.p1, this.j1);
            }
        }
    }

    public final void X5(@NonNull ImageFileInfo imageFileInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048674, this, imageFileInfo) == null) {
            this.Q0.s(imageFileInfo);
        }
    }

    public final void X6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048675, this) == null) {
            if (this.v2 == null) {
                ((ViewStub) findViewById(R.id.obfuscated_res_0x7f09246c)).inflate();
                this.v2 = findViewById(R.id.obfuscated_res_0x7f09246b);
            }
            this.v2.setOnClickListener(new s0(this));
            this.v2.setVisibility(0);
            vr4 d2 = vr4.d(this.v2);
            d2.e(R.string.A_X05);
            d2.f(R.color.CAM_X0611);
            vr4 d3 = vr4.d(this.v2.findViewById(R.id.obfuscated_res_0x7f09246a));
            d3.n(R.string.J_X06);
            d3.f(R.color.CAM_X0201);
            TextView textView = (TextView) this.v2.findViewById(R.id.obfuscated_res_0x7f092468);
            vr4 d4 = vr4.d(textView);
            d4.A(R.string.F_X01);
            d4.z(R.dimen.T_X07);
            d4.v(R.color.CAM_X0105);
            d4.n(R.string.J_X07);
            d4.l(R.dimen.L_X02);
            d4.k(R.color.CAM_X0105);
            d4.j(R.string.A_X07);
            textView.setOnClickListener(new t0(this));
            TextView textView2 = (TextView) this.v2.findViewById(R.id.obfuscated_res_0x7f092467);
            vr4 d5 = vr4.d(textView2);
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

    public final void Y4(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048676, this, writeData) == null) {
            if ((this.u1 && this.t1) || b6()) {
                this.v.setRichContentData(writeData.getRichContentData());
                this.Q0.r(writeData.getRichContentData());
            }
        }
    }

    public final Boolean Y5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) ? Boolean.valueOf(this.b1) : (Boolean) invokeV.objValue;
    }

    public final void Y6() {
        WriteVoteData writeVoteData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048678, this) == null) {
            Serializable serializable = this.j2;
            if (serializable instanceof WriteVoteData) {
                writeVoteData = (WriteVoteData) serializable;
                this.v.setWriteVoteData(writeVoteData);
            } else if (this.v.getWriteVoteData() == null) {
                return;
            } else {
                writeVoteData = this.v.getWriteVoteData();
            }
            e eVar = new e(this, writeVoteData);
            this.a2.f(eVar);
            this.a2.e(eVar);
            this.a2.g(writeVoteData);
            this.a2.h(true);
            D2();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void Z1(CharSequence charSequence, int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048679, this, new Object[]{charSequence, Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) || this.E1) {
            return;
        }
        super.Z1(charSequence, i2, i3, str);
    }

    public final void Z4(WriteData writeData) {
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048680, this, writeData) == null) {
            if (oi.isEmpty(this.v.getTitle())) {
                this.v.setTitle(writeData.getTitle());
            }
            if (!ListUtils.isEmpty(this.B)) {
                HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) ListUtils.getItem(this.B, 0);
                String str = hotTopicBussinessData != null ? hotTopicBussinessData.mTopicName : null;
                if (StringUtils.isNull(str)) {
                    a2 = this.v.getTitle();
                } else {
                    a2 = jd5.a(str);
                }
                SpannableString i2 = jd5.i(a2);
                if (i2 != null) {
                    W1().setText(i2);
                    int length = i2.length() > a2.length() ? a2.length() : i2.length();
                    if (length > W1().getText().length()) {
                        length = W1().getText().length();
                    }
                    W1().setSelection(length);
                    return;
                }
                return;
            }
            SpannableString i3 = jd5.i(this.v.getTitle());
            if (i3 != null) {
                W1().setText(i3);
                int length2 = this.v.getTitle().length() > i3.length() ? i3.length() : this.v.getTitle().length();
                if (length2 > W1().getText().length()) {
                    length2 = W1().getText().length();
                }
                W1().setSelection(length2);
            }
        }
    }

    public final boolean Z5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) ? (this.I0 || this.s || this.E1 || this.u1 || !this.d2) ? false : true : invokeV.booleanValue;
    }

    public final void Z6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048682, this) == null) {
            this.d1.I();
            vx8.e(this.v);
            d7();
            x6();
            if (PersonPolymericActivityConfig.VIDEO_PERSON_FROM_TOPIC_DETAIL.equals(this.f)) {
                setResult(-1);
            } else {
                setResult(100);
            }
            finish();
        }
    }

    public final void a5(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048683, this, writeData) == null) {
            if (writeData.getWriteImagesInfo() != null) {
                this.y = writeData.getWriteImagesInfo();
            }
            this.v.setWriteImagesInfo(this.y);
            this.Q0.setWriteImagesInfo(this.y);
            if (this.y.getChosedFiles() != null && this.y.getChosedFiles().size() > 0) {
                J2();
            }
            F6(false);
            U6(true, true);
        }
    }

    public final boolean a6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) ? (this.I0 || this.s || this.E1 || !"2".equals(this.o) || this.t1 || this.d2) ? false : true : invokeV.booleanValue;
    }

    public void a7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048685, this) == null) {
            if (!this.G.I(getPageContext().getPageActivity())) {
                showToast(R.string.obfuscated_res_0x7f0f0a31);
                I2(0, true, null);
                jx8 jx8Var = this.t0;
                if (jx8Var != null) {
                    jx8Var.g();
                }
            } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
                S2();
            } else {
                LocationModel locationModel = this.G;
                if (locationModel == null) {
                    return;
                }
                locationModel.Q(false);
                I2(1, true, null);
                this.G.M();
            }
        }
    }

    public final void b5(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048686, this, intent) == null) {
            q5(intent, true);
        }
    }

    public final boolean b6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048687, this)) == null) ? !this.u1 && this.t1 : invokeV.booleanValue;
    }

    public void b7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048688, this) == null) {
            c7(false);
        }
    }

    public final void c5(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048689, this, intent) == null) || intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            this.y.parseJson(stringExtra);
            this.y.updateQuality();
        }
        g7();
        F6(true);
    }

    public final boolean c6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048690, this)) == null) ? (this.I0 || this.s || this.E1 || !"2".equals(this.o) || !this.t1 || this.d2) ? false : true : invokeV.booleanValue;
    }

    public void c7(boolean z2) {
        kk8 kk8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048691, this, z2) == null) {
            if (!z2 && (kk8Var = this.d1) != null) {
                kk8Var.d();
            }
            FeedBackModel feedBackModel = this.H;
            if (feedBackModel != null) {
                feedBackModel.cancelLoadData();
            }
            LocationModel locationModel = this.G;
            if (locationModel != null) {
                locationModel.cancelLoadData();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048692, this) == null) {
            if (this.E1) {
                ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 1);
            } else {
                ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
            }
        }
    }

    public final void d5(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048693, this, intent) == null) || intent == null) {
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
                    this.y.addChooseFile(imageFileInfo);
                    X5(imageFileInfo);
                }
            }
            C6();
            H6();
            if (this.y.getChosedFiles() != null) {
                J2();
            }
        }
        F6(true);
    }

    public final boolean d6(EditText editText) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048694, this, editText)) == null) {
            long k5 = k5(editText);
            if (k5 > 233) {
                return false;
            }
            return k5 > 0 || this.y.size() >= 1;
        }
        return invokeL.booleanValue;
    }

    public final synchronized void d7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048695, this) == null) {
            synchronized (this) {
                VoiceManager u02 = u0();
                this.e1 = u02;
                u02.stopPlay();
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void e2(Bundle bundle) {
        WriteData writeData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048696, this, bundle) == null) {
            kk8 k2 = kk8.k();
            this.d1 = k2;
            k2.p(this);
            super.e2(bundle);
            if (bundle != null) {
                this.v.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
                this.v.setFloorNum(bundle.getInt("floor_num", 0));
                String string = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
                this.K1 = string;
                this.v.setTopicId(string);
                this.v.setStatisticFrom(bundle.getInt(WriteActivityConfig.KEY_STATISTIS_FROM, 0));
                this.I0 = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
                this.J0 = bundle.getBoolean(WriteActivityConfig.KEY_SHOW_HOMEPAGE_TEST_BTN, false);
                this.K0 = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
                this.Z0 = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
                this.a1 = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
                this.c1 = bundle.getString(WriteActivityConfig.PHOTO_NAME);
                this.G1 = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
                this.H1 = bundle.getBoolean(WriteActivityConfig.CAN_GOODS);
                this.k2 = bundle.getBoolean(WriteActivityConfig.NEED_CLOSE_PRE_PAGE);
                this.u1 = bundle.getBoolean(WriteActivityConfig.RICH_MODE_ENABLE, false);
                this.t1 = bundle.getBoolean(WriteActivityConfig.RICH_TEXT_MODE, false);
            } else {
                Intent intent = getIntent();
                this.v.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
                this.v.setFloorNum(intent.getIntExtra("floor_num", 0));
                this.v.setProZone(intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
                String stringExtra = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
                this.K1 = stringExtra;
                this.v.setTopicId(stringExtra);
                this.v.setStatisticFrom(intent.getIntExtra(WriteActivityConfig.KEY_STATISTIS_FROM, 0));
                this.I0 = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
                this.J0 = intent.getBooleanExtra(WriteActivityConfig.KEY_SHOW_HOMEPAGE_TEST_BTN, false);
                this.K0 = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
                this.Z0 = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
                this.a1 = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
                this.R1 = intent.getStringExtra("more_forum_img");
                this.P1 = intent.getStringExtra("more_forum_title");
                this.Q1 = intent.getStringExtra("more_forum_url");
                this.G1 = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
                this.v.setFrsTabInfoData(this.D);
                this.H1 = intent.getBooleanExtra(WriteActivityConfig.CAN_GOODS, false);
                this.k2 = intent.getBooleanExtra(WriteActivityConfig.NEED_CLOSE_PRE_PAGE, false);
                boolean booleanExtra = getIntent().getBooleanExtra(IntentConfig.IS_EVALUATE, false);
                this.d2 = booleanExtra;
                this.v.setIsEvaluate(booleanExtra);
                this.e2 = getIntent().getBooleanExtra(IntentConfig.IS_ITEM_DETAIL, false);
                this.f2 = getIntent().getIntExtra(WriteActivityConfig.STAR_COUNT, 0);
                Serializable serializableExtra = getIntent().getSerializableExtra(WriteActivityConfig.ITEM_INFO);
                if (serializableExtra instanceof SerializableItemInfo) {
                    SerializableItemInfo serializableItemInfo = (SerializableItemInfo) serializableExtra;
                    this.c2 = serializableItemInfo;
                    this.v.setItem_id(String.valueOf(serializableItemInfo.id));
                }
                this.g2 = getIntent().getBooleanExtra(BaseWriteConfig.IS_SAVE_DRAFTE, true);
                this.h2 = getIntent().getBooleanExtra(WriteActivityConfig.IS_FROM_ERROR_DIALOG, false);
                this.i2 = getIntent().getStringExtra(WriteActivityConfig.GOODS_LIST);
                this.j2 = intent.getSerializableExtra(IntentConfig.WRITE_VOTE_DATA);
                this.b1 = intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true);
                this.e = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
                this.u1 = intent.getBooleanExtra(WriteActivityConfig.RICH_MODE_ENABLE, false);
                this.t1 = intent.getBooleanExtra(WriteActivityConfig.RICH_TEXT_MODE, false);
                this.v1 = intent.getStringExtra(WriteActivityConfig.IS_ARTICLE);
                if (this.h2 && (writeData = mk8.e) != null) {
                    this.v = writeData;
                    writeData.setType(9);
                    WriteData writeData2 = this.v;
                    writeData2.setContent(writeData2.getContentString());
                    this.y = this.v.getWriteImagesInfo();
                    this.D = this.v.getFrsTabInfoData();
                    if (this.v.getItemInfo() != null) {
                        this.c2 = null;
                    }
                    this.H0 = this.v.getVoiceModel();
                }
                if (UbsABTestHelper.isMainTabShowA()) {
                    this.v.setIsArticle(this.v1);
                }
            }
            PostPrefixData postPrefixData = this.d;
            if (postPrefixData != null && postPrefixData.getPrefixs().size() > 0) {
                this.d.getPrefixs().add(getPageContext().getString(R.string.obfuscated_res_0x7f0f158a));
            }
            this.v.setLocalChannelDynamic(this.E1);
            this.v.setLocalChannelTopic(this.F1);
            if (this.v.getType() == 9) {
                this.v.setEntranceType(1);
            } else if (this.v.getType() == 10) {
                this.v.setEntranceType(2);
                this.v.setType(9);
            } else if (this.v.getType() == 0) {
                this.v.setEntranceType(3);
            }
            this.v.setIsUserFeedback(this.I0);
            this.S0 = TbadkCoreApplication.getInst().getDefaultBubble();
            c2();
            try {
                this.w1 = l5();
            } catch (Throwable unused) {
                this.w1 = null;
            }
            this.d1.B(this.E1);
        }
    }

    public final void e5(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048697, this, intent) == null) {
            this.c1 = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
            String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.c1;
            if (!TextUtils.isEmpty(str)) {
                try {
                    int readPictureDegree = BitmapHelper.readPictureDegree(str);
                    if (readPictureDegree != 0) {
                        Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, pi.d(getPageContext().getPageActivity(), pi.k(getPageContext().getPageActivity())), pi.d(getPageContext().getPageActivity(), pi.i(getPageContext().getPageActivity())));
                        Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                        if (loadResizedBitmap != rotateBitmapBydegree) {
                            loadResizedBitmap.recycle();
                        }
                        FileHelper.saveBitmapByRelativelyPath(TbConfig.LOCAL_CAMERA_DIR, this.c1, rotateBitmapBydegree, 100);
                        rotateBitmapBydegree.recycle();
                    }
                } catch (Exception unused) {
                }
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(str);
                imageFileInfo.setTempFile(true);
                this.y.addChooseFile(imageFileInfo);
                this.y.updateQuality();
                r4(imageFileInfo);
                C6();
                H6();
                J2();
            }
            F6(true);
        }
    }

    public final boolean e6(EditText editText) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048698, this, editText)) == null) {
            long k5 = k5(editText);
            return k5 <= 20 && k5 > 0;
        }
        return invokeL.booleanValue;
    }

    public void e7(WriteVoteData writeVoteData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048699, this, writeVoteData) == null) {
            this.v.setWriteVoteData(writeVoteData);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048700, this) == null) {
            if (this.E1) {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 1);
            } else {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i f1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048701, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    @SuppressLint({"ResourceAsColor"})
    public void f2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048702, this) == null) {
            super.f2();
            int l2 = yt4.k().l("write_associate_item_hint_tip_key", 0);
            if (yt4.k().l("commodity_tip_show_controller", 0) != 0 || !this.H1) {
                T6();
                K4();
            } else if (l2 > 0) {
                S6();
            } else {
                yt4.k().w("commodity_tip_show_controller", yt4.k().l("commodity_tip_show_controller", 0) + 1);
            }
        }
    }

    public final void f5(@Nullable Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048703, this, intent) == null) || intent == null) {
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
                    this.y.addChooseFile(imageFileInfo);
                    X5(imageFileInfo);
                }
            }
            C6();
            H6();
            if (this.y.getChosedFiles() != null) {
                J2();
            }
        }
        F6(true);
    }

    public final void f6(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048704, this, i2) == null) || this.y == null || this.v == null) {
            return;
        }
        AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(getPageContext().getPageActivity(), this.y.toJsonString(), true, true);
        albumFloatActivityConfig.getIntent().putExtra("forum_id", this.v.getForumId());
        albumFloatActivityConfig.getIntent().putExtra("forum_name", this.v.getForumName());
        albumFloatActivityConfig.getIntent().putExtra("from", this.f);
        albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
        albumFloatActivityConfig.setAlbumThread(i2);
        albumFloatActivityConfig.setCanSelectVideo(false);
        albumFloatActivityConfig.setCanSelectOnlyVideo(false);
        albumFloatActivityConfig.setCanEditImage(false);
        albumFloatActivityConfig.setFromWrite(3);
        albumFloatActivityConfig.setCallFrom(this.o);
        albumFloatActivityConfig.setStatisticFrom(this.v.getStatisticFrom());
        albumFloatActivityConfig.setProfessionZone(this.v.getProZone());
        albumFloatActivityConfig.setFrsTabInfo(this.D);
        AntiData antiData = new AntiData();
        antiData.voice_message = this.e;
        antiData.setIfVoice(this.b1);
        albumFloatActivityConfig.setExtraData(antiData, this.d, this.v.getFirstDir(), this.v.getSecondDir());
        sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
    }

    public void f7(LinkedList<ImageFileInfo> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048705, this, linkedList) == null) {
            LinkedList<ImageFileInfo> chosedFiles = this.y.getChosedFiles();
            if (chosedFiles != null) {
                chosedFiles.clear();
                if (linkedList != null) {
                    chosedFiles.addAll(linkedList);
                }
            }
            D2();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void g2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048706, this) == null) {
            super.g2();
            this.r0.setActionListener(60, this.F0);
            this.r0.setActionListener(56, this.F0);
            this.r0.setActionListener(58, this.F0);
            this.r0.setActionListener(66, this.F0);
            this.r0.setActionListener(22, this.F0);
            this.r0.setActionListener(21, this.F0);
            this.r0.setActionListener(59, this.F0);
            this.r0.setActionListener(61, this.F0);
        }
    }

    public final String g5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048707, this)) == null) {
            ArrayList arrayList = new ArrayList();
            WriteEvaluationHeaderView writeEvaluationHeaderView = this.V1;
            arrayList.add(new HeadItem("", String.valueOf(writeEvaluationHeaderView != null ? writeEvaluationHeaderView.getStarCount() : 0), 2));
            return new Gson().toJson(arrayList);
        }
        return (String) invokeV.objValue;
    }

    public final void g6() {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048708, this) == null) || (writeImagesInfo = this.y) == null || this.v == null) {
            return;
        }
        JSONObject json = writeImagesInfo.toJson();
        String str = null;
        if (json != null) {
            try {
                json.put("maxImagesAllowed", 9 - this.y.size());
                json.put("chosedFiles", (Object) null);
                str = json.toString();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(getPageContext().getPageActivity(), str, true, true);
        albumFloatActivityConfig.getIntent().putExtra("forum_id", this.v.getForumId());
        albumFloatActivityConfig.getIntent().putExtra("forum_name", this.v.getForumName());
        albumFloatActivityConfig.getIntent().putExtra("from", this.f);
        albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
        albumFloatActivityConfig.setAlbumThread(0);
        albumFloatActivityConfig.setCanSelectVideo(false);
        albumFloatActivityConfig.setCanSelectOnlyVideo(false);
        albumFloatActivityConfig.setCanEditImage(false);
        albumFloatActivityConfig.setFromWrite(3);
        albumFloatActivityConfig.setCallFrom(this.o);
        albumFloatActivityConfig.setStatisticFrom(this.v.getStatisticFrom());
        albumFloatActivityConfig.setProfessionZone(this.v.getProZone());
        albumFloatActivityConfig.setFrsTabInfo(this.D);
        AntiData antiData = new AntiData();
        antiData.voice_message = this.e;
        antiData.setIfVoice(this.b1);
        albumFloatActivityConfig.setExtraData(antiData, this.d, this.v.getFirstDir(), this.v.getSecondDir());
        sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
    }

    public final void g7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048709, this) == null) && this.t) {
            this.i1.l(this.y);
            h7();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.repackage.w85
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048710, this)) == null) {
            WriteData writeData = this.v;
            return writeData != null ? writeData.getType() == 4 ? "a015" : this.v.getType() == 5 ? "a016" : "a094" : "a094";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void h2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048711, this) == null) {
            super.h2();
            this.X1 = findViewById(R.id.obfuscated_res_0x7f090baf);
            if (this.j0.getVisibility() == 0) {
                this.X1.setVisibility(0);
            }
        }
    }

    public final String h5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048712, this)) == null) ? (V1() == null || V1().getText() == null) ? "" : V1().getText().toString() : (String) invokeV.objValue;
    }

    public final void h6(int i2) {
        WriteImagesInfo writeImagesInfo;
        int size;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048713, this, i2) == null) || (writeImagesInfo = this.y) == null || writeImagesInfo.getChosedFiles() == null || (size = this.y.getChosedFiles().size()) < 1 || i2 < 0 || i2 >= size) {
            return;
        }
        sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.y, i2)));
    }

    public final void h7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048714, this) == null) {
            this.i1.notifyDataSetChanged();
            this.h1.invalidate();
            this.c.postDelayed(new f0(this), 550L);
        }
    }

    @Override // com.repackage.rh8.f
    public void i0(WriteData writeData) {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048715, this, writeData) == null) || WriteActivityConfig.FROM_FORUM_SHARE.equals(this.f) || this.u2 || this.h2) {
            return;
        }
        if (!this.u1 || (writeImagesInfo = this.y) == null || writeImagesInfo.size() <= 0) {
            if (writeData != null) {
                if (this.v != null && writeData.isEvaluate() == this.v.isEvaluate()) {
                    int i2 = 0;
                    boolean z2 = (this.v.getWriteImagesInfo() == null || ListUtils.isEmpty(this.v.getWriteImagesInfo().getChosedFiles())) ? false : true;
                    boolean z3 = !oi.isEmpty(W1().getText().toString());
                    boolean z4 = !oi.isEmpty(V1().getText().toString());
                    boolean z5 = !oi.isEmpty(writeData.getTitle());
                    boolean z6 = !oi.isEmpty(writeData.getContent());
                    boolean z7 = !ListUtils.isEmpty(writeData.getRichContentData());
                    this.v.setHaveDraft(true);
                    if (!this.u1 && !b6()) {
                        this.t1 = false;
                        p6();
                    } else {
                        boolean isRichTextEditorMode = writeData.isRichTextEditorMode();
                        this.t1 = isRichTextEditorMode;
                        this.v.setRichTextEditorMode(isRichTextEditorMode);
                        if (this.t1) {
                            q6();
                        } else {
                            p6();
                        }
                    }
                    if (!z2) {
                        a5(writeData);
                    }
                    if (!z3 || this.D1 || ((this.I0 || this.s) && z5)) {
                        Z4(writeData);
                    }
                    if (z6 && (!z4 || this.I0 || this.s)) {
                        X4(writeData);
                    }
                    if (z7) {
                        Y4(writeData);
                    }
                    WriteData writeData2 = this.v;
                    if (writeData2 != null && !writeData2.getHaveDraft()) {
                        k2();
                    }
                    if (writeData.getItemInfo() != null) {
                        this.v.setItemInfo(writeData.getItemInfo());
                        this.v.setEvaluationStar(writeData.getEvaluationStar());
                        this.c2 = null;
                        U5();
                    }
                    if (writeData.getWriteVoteData() != null) {
                        this.v.setWriteVoteData(writeData.getWriteVoteData());
                        Y6();
                    }
                    if (writeData.getVoiceModel() != null) {
                        z4(writeData.getVoiceModel());
                        H6();
                    }
                    if (writeData.getType() == 4 || writeData.getType() == 5) {
                        l6();
                    }
                    if (!ListUtils.isEmpty(writeData.getItemDatas()) && !x5() && 10 - s5() == 0) {
                        Iterator<ItemData> it = writeData.getItemDatas().iterator();
                        while (it.hasNext()) {
                            o4(it.next());
                        }
                    }
                    M1();
                    D2();
                    U2();
                    int categoryTo = writeData.getCategoryTo();
                    if (categoryTo >= 0 && this.A != null) {
                        ud6 ud6Var = this.z;
                        this.k = ud6Var.b;
                        this.h = ud6Var.a;
                        while (true) {
                            if (i2 == this.A.size()) {
                                break;
                            }
                            ud6 ud6Var2 = this.A.get(i2);
                            if (categoryTo == ud6Var2.b) {
                                this.k = categoryTo;
                                this.h = ud6Var2.a;
                                this.v.setCategoryTo(categoryTo);
                                break;
                            }
                            i2++;
                        }
                        PostCategoryView postCategoryView = this.f0;
                        if (postCategoryView != null) {
                            postCategoryView.setText(this.h);
                            this.f0.setCategoryContainerData(this.A, this.z, this.k);
                        }
                    }
                    this.r0.q();
                    return;
                }
                return;
            }
            l6();
            k2();
        }
    }

    public final void i5(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048716, this, context) == null) {
            L2 = pi.i(context);
        }
    }

    public final void i6(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048717, this, i2) == null) || this.y == null || this.v == null) {
            return;
        }
        AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(getPageContext().getPageActivity(), this.y.toJsonString(), true, true);
        albumFloatActivityConfig.getIntent().putExtra("forum_id", this.v.getForumId());
        albumFloatActivityConfig.getIntent().putExtra("forum_name", this.v.getForumName());
        albumFloatActivityConfig.getIntent().putExtra("from", this.f);
        albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
        albumFloatActivityConfig.setAlbumThread(i2);
        albumFloatActivityConfig.setCanSelectVideo(true);
        albumFloatActivityConfig.setCanSelectOnlyVideo(true);
        albumFloatActivityConfig.setCanEditImage(false);
        albumFloatActivityConfig.setFromWrite(3);
        albumFloatActivityConfig.setCallFrom(this.o);
        albumFloatActivityConfig.setStatisticFrom(this.v.getStatisticFrom());
        albumFloatActivityConfig.setProfessionZone(this.v.getProZone());
        albumFloatActivityConfig.setFrsTabInfo(this.D);
        if (this.N.getText().toString() != null) {
            albumFloatActivityConfig.setVideoTitle(this.N.getText().toString());
        } else {
            albumFloatActivityConfig.setVideoTitle(this.E);
        }
        albumFloatActivityConfig.setBarName(this.v.getForumName());
        albumFloatActivityConfig.setBarID(this.v.getForumId());
        if (this.U1 == null && this.v.getForumName() != null) {
            albumFloatActivityConfig.setCanChangeBarName(false);
        } else {
            albumFloatActivityConfig.setCanChangeBarName(true);
        }
        albumFloatActivityConfig.setVideoAbstract(this.S.getText().toString());
        AntiData antiData = new AntiData();
        antiData.voice_message = this.e;
        antiData.setIfVoice(this.b1);
        albumFloatActivityConfig.setExtraData(antiData, this.d, this.v.getFirstDir(), this.v.getSecondDir());
        sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048718, this) == null) {
            registerListener(this.w2);
            registerListener(this.x2);
            registerListener(this.y2);
            registerListener(this.D2);
            registerListener(this.E2);
            registerListener(this.F2);
        }
    }

    public final void j5(@Nullable Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048719, this, intent) == null) || intent == null) {
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
                this.y.getChosedFiles().remove(originalImgIndex);
                this.y.getChosedFiles().add(originalImgIndex, imageFileInfo);
                this.Q0.o(imageFileInfo, writeImagesInfo.getOriginalImgViewIndex());
                C6();
                H6();
                if (this.y.getChosedFiles() != null) {
                    J2();
                }
            }
        }
        F6(true);
    }

    public final void j6(WriteVoteData writeVoteData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048720, this, writeVoteData) == null) {
            WriteVoteActivityConfig writeVoteActivityConfig = new WriteVoteActivityConfig(getPageContext().getPageActivity(), 25048);
            if (writeVoteData != null) {
                writeVoteActivityConfig.setExtraData(writeVoteData);
            }
            sendMessage(new CustomMessage(2002001, writeVoteActivityConfig));
        }
    }

    public final long k5(EditText editText) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048721, this, editText)) == null) ? ke5.a(editText.getText().toString().trim()) : invokeL.longValue;
    }

    public final void k6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048722, this) == null) {
            if (this.v.getType() != 0 && this.v.getType() != 9 && this.v.getType() != 11) {
                if (this.v.getType() == 7) {
                    if (this.g2) {
                        rh8.j("24591571", this);
                    }
                } else if (this.v.getType() == 1) {
                    rh8.n(this.v.getThreadId(), this);
                } else if (this.v.getType() == 4) {
                    rh8.j(this.v.getForumId() + "photolive", this);
                } else if (this.v.getType() == 5) {
                    rh8.n(this.v.getThreadId() + "updatephotolive", this);
                }
            } else if (this.g2) {
                if (this.v.isLocalChannelDynamic()) {
                    rh8.k(this);
                } else if (this.v.isEvaluate()) {
                    rh8.i(this.v.getItem_id(), this);
                } else if (TextUtils.isEmpty(this.v.getTopicId())) {
                    rh8.j(this.v.getForumId(), this);
                } else {
                    rh8.p(this.v.getTopicId(), this);
                }
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void l2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048723, this) == null) {
            super.l2();
            if (this.M1 == null) {
                wz5 wz5Var = new wz5(getPageContext(), this.e0);
                this.M1 = wz5Var;
                wz5Var.e0(R.drawable.obfuscated_res_0x7f0802ef);
                this.M1.O(16);
                this.M1.U(true);
                this.M1.f0(true);
                this.M1.h0(pi.f(getActivity(), R.dimen.obfuscated_res_0x7f070207));
            }
            K5();
        }
    }

    public final File l5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048724, this)) == null) {
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

    public final void l6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048725, this) == null) {
            if ((this.t && this.i1 == null) || this.h1 == null) {
                return;
            }
            this.i1.l(this.y);
            h7();
        }
    }

    public final long m5(EditText editText) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048726, this, editText)) == null) {
            if (editText == this.j1) {
                return 233L;
            }
            return editText == this.n1 ? 20L : 0L;
        }
        return invokeL.longValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0017, code lost:
        if (r0 != 11) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m6() {
        WriteData writeData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048727, this) == null) || (writeData = this.v) == null) {
            return;
        }
        int i2 = -1;
        int type = writeData.getType();
        if (type == 0 || type == 9) {
            if (!Z5()) {
                if (a6()) {
                    i2 = 1;
                } else if (c6()) {
                    i2 = 2;
                }
                qy8.a(i2);
            }
            i2 = 4;
            qy8.a(i2);
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void n2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048728, this) == null) {
            if (this.d2) {
                this.Q.setVisibility(8);
                WriteImageGridView writeImageGridView = this.B2;
                if (writeImageGridView != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) writeImageGridView.getLayoutParams();
                    layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X012);
                    this.B2.setLayoutParams(layoutParams);
                }
                this.M0.setVisibility(8);
            } else {
                this.N.setHint(R.string.obfuscated_res_0x7f0f13dc);
                this.Q.setVisibility(0);
                WriteImageGridView writeImageGridView2 = this.B2;
                if (writeImageGridView2 != null) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) writeImageGridView2.getLayoutParams();
                    layoutParams2.topMargin = 0;
                    this.B2.setLayoutParams(layoutParams2);
                }
                this.M0.setVisibility(0);
                this.Q.requestFocus();
            }
            if (this.E1) {
                this.N.setHint(R.string.obfuscated_res_0x7f0f13dd);
            }
        }
    }

    public final void n5(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048729, this, intent) == null) {
            q5(intent, false);
        }
    }

    public void n6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048730, this) == null) {
            if (!L4()) {
                BdToast b2 = BdToast.b(this, getString(R.string.obfuscated_res_0x7f0f0eac));
                b2.f(BdToast.ToastIcon.FAILURE);
                b2.h();
            } else if (!this.H1) {
                BdToast b3 = BdToast.b(this, getString(R.string.obfuscated_res_0x7f0f0ead));
                b3.f(BdToast.ToastIcon.FAILURE);
                b3.h();
            } else {
                if (this.v != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_COMMODITY_ENTRANCE_CLICK).param("obj_locate", 2).param("fid", this.v.getForumId()).param("fname", this.v.getForumName()));
                }
                if (!yt4.k().h("commodity_goods_show_first_dialog", false)) {
                    dr4 dr4Var = new dr4(getPageContext().getPageActivity());
                    dr4Var.setContentViewSize(2);
                    dr4Var.setCanceledOnTouchOutside(false);
                    FrsPublishFineGoodsDialogView frsPublishFineGoodsDialogView = new FrsPublishFineGoodsDialogView(getPageContext().getPageActivity());
                    frsPublishFineGoodsDialogView.setConfirmButtonListener(new m0(this, dr4Var));
                    dr4Var.setContentView(frsPublishFineGoodsDialogView);
                    StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_WRITE_GOODS_NEW_DIALOG_SHOW).param("obj_locate", 2);
                    WriteData writeData = this.v;
                    StatisticItem param2 = param.param("fid", writeData != null ? writeData.getForumId() : "");
                    WriteData writeData2 = this.v;
                    TiebaStatic.log(param2.param("fname", writeData2 != null ? writeData2.getForumName() : ""));
                    dr4Var.create(getPageContext()).show();
                    return;
                }
                String uk = TbadkCoreApplication.getCurrentAccountInfo().getUk();
                MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + uk + "&max=" + s5()));
            }
        }
    }

    public final void o4(ItemData itemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048731, this, itemData) == null) {
            this.v.addItemData(itemData);
            this.l2.setVisibility(0);
            this.l2.a(itemData);
        }
    }

    public final void o6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048732, this) == null) {
            if (!this.v.canAddItem()) {
                pi.N(getActivity(), R.string.obfuscated_res_0x7f0f15a7);
                return;
            }
            RelevanceItemSearchActivityConfig relevanceItemSearchActivityConfig = new RelevanceItemSearchActivityConfig(getActivity(), 0);
            relevanceItemSearchActivityConfig.setSelectedIds(this.v.getItemDataIds());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, relevanceItemSearchActivityConfig));
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
        if (interceptable == null || interceptable.invokeIIL(1048733, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1) {
                if (i2 != 25068) {
                    PostWriteCallBackData postWriteCallBackData2 = null;
                    postWriteCallBackData2 = null;
                    postWriteCallBackData2 = null;
                    if (i2 == 12004) {
                        if (this.N == getCurrentFocus()) {
                            V1().clearFocus();
                            this.N.requestFocus();
                            EditorTools editorTools = this.r0;
                            if (editorTools != null) {
                                editorTools.q();
                            }
                            ShowSoftKeyPadDelay(this.N);
                        } else {
                            V1().requestFocus();
                            EditorTools editorTools2 = this.r0;
                            if (editorTools2 != null) {
                                editorTools2.q();
                            }
                            ShowSoftKeyPadDelay(this.S);
                        }
                        ArrayList parcelableArrayListExtra = intent != null ? intent.getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA) : null;
                        int selectionStart = V1().getSelectionStart();
                        if (selectionStart > 0) {
                            int i5 = selectionStart - 1;
                            if (V1().getText().toString().charAt(i5) == '@') {
                                V1().getEditableText().delete(i5, selectionStart);
                            }
                        }
                        if (this.u1 && this.t1) {
                            this.Q0.k(parcelableArrayListExtra);
                        } else if (V1() instanceof SpanGroupEditText) {
                            ((SpanGroupEditText) V1()).e(parcelableArrayListExtra);
                        }
                        if (parcelableArrayListExtra != null && parcelableArrayListExtra.size() > 0) {
                            V1().getText().delete(V1().getSelectionStart(), V1().getSelectionEnd());
                            if (this.u1 && this.t1) {
                                this.Q0.g(parcelableArrayListExtra);
                            } else if (V1() instanceof SpanGroupEditText) {
                                ((SpanGroupEditText) V1()).b(parcelableArrayListExtra);
                            }
                        }
                    } else if (i2 == 12006) {
                        if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) {
                            postWriteCallBackData2 = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                        }
                        P4();
                        K2(postWriteCallBackData2);
                        setResult(-1, intent);
                        finish();
                    } else if (i2 != 12010 && i2 != 12009) {
                        if (i2 == 12002) {
                            if (intent == null) {
                                return;
                            }
                            if (intent.getBooleanExtra(AlbumActivityConfig.FINISH_SELF, false)) {
                                setResult(-1, intent);
                                finish();
                                return;
                            }
                            int intExtra = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                            if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                                if (intExtra == 1) {
                                    S4();
                                } else {
                                    Q4(intent);
                                }
                            } else if (intExtra == 1) {
                                T4(intent);
                            } else {
                                R4(intent);
                                qg.a().post(new e0(this));
                            }
                            U6(ListUtils.getCount(this.y.getChosedFiles()) > 0, false);
                            if (this.L1) {
                                A6(true);
                                this.L1 = false;
                            }
                        } else if (i2 == 12012) {
                            if (this.t1) {
                                j5(intent);
                            } else if (!this.t) {
                                n5(intent);
                                D2();
                            } else {
                                c5(intent);
                            }
                        } else if (i2 == 13010) {
                            VideoInfo videoInfo = new VideoInfo();
                            videoInfo.parseFromIntent(intent);
                            if (videoInfo.isAvaliable()) {
                                this.v.setVideoInfo(videoInfo);
                                this.r0.A(new k15(2, 19, " "));
                                this.r0.A(new k15(28, 20, videoInfo));
                            } else {
                                this.r0.A(new k15(5, -1, null));
                            }
                            D2();
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
                            if (this.r) {
                                sb.append("#");
                                this.r = false;
                            }
                            sb.append(stringExtra);
                            D1(sb.toString());
                        } else if (i2 != 25005 || intent == null || ListUtils.isEmpty(this.B)) {
                            if (i2 == 25048) {
                                if (intent == null) {
                                    return;
                                }
                                Serializable serializableExtra = intent.getSerializableExtra(IntentConfig.WRITE_VOTE_DATA);
                                if (serializableExtra instanceof WriteVoteData) {
                                    this.j2 = serializableExtra;
                                    Y6();
                                }
                            } else if (i2 == 25049 && intent != null) {
                                String str2 = intent.getStringExtra(AddLinkActivityConfig.NEW_LINK_CONTENT) + " ";
                                int selectionStart2 = this.S.getSelectionStart();
                                int selectionEnd = this.S.getSelectionEnd();
                                if (selectionStart2 >= 0) {
                                    Editable text = this.S.getText();
                                    if (selectionEnd > selectionStart2) {
                                        text.replace(selectionStart2, selectionEnd, str2);
                                    } else {
                                        text.insert(selectionStart2, str2);
                                    }
                                }
                            } else if (i2 == 25064) {
                                if (tw8.b()) {
                                    if (this.y == null || this.v == null) {
                                        return;
                                    }
                                    if (this.N.getText().toString() != null) {
                                        str = this.N.getText().toString();
                                        i4 = 5;
                                    } else {
                                        str = this.E;
                                        i4 = 1;
                                    }
                                    if (this.U1 == null && this.v.getForumName() != null) {
                                        tw8.f(getPageContext(), str, this.S.getText().toString(), this.v.getForumId(), this.v.getForumName(), 3, Boolean.FALSE, "", "", "");
                                    } else {
                                        tw8.f(getPageContext(), str, this.S.getText().toString(), this.v.getForumId(), this.v.getForumName(), i4, Boolean.TRUE, "", "", "");
                                    }
                                } else {
                                    i6(0);
                                }
                            }
                        } else if (ListUtils.isEmpty(this.B) || intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) >= this.B.size()) {
                            return;
                        } else {
                            HotTopicBussinessData hotTopicBussinessData = this.B.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                            this.C = hotTopicBussinessData;
                            G4(hotTopicBussinessData);
                        }
                    }
                } else if (!this.E1 || intent == null || (localChannelTopicSelectView = this.S1) == null || localChannelTopicSelectView.getVisibility() != 0) {
                    return;
                } else {
                    String stringExtra2 = intent.getStringExtra(LocalChannelTopicListActivityConfig.KEY_RESPONSE_TOPIC);
                    this.F1 = stringExtra2;
                    this.S1.setLocalChannelTopic(stringExtra2);
                }
            } else if (i3 == 0) {
                EditorTools editorTools3 = this.r0;
                if (editorTools3 != null && !editorTools3.u()) {
                    this.S.requestFocus();
                    this.s0.toggleSoftInput(0, 2);
                    this.r0.q();
                }
                if (i2 == 12001) {
                    V4();
                } else if (i2 == 12002) {
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.y.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    g7();
                    if (this.L1) {
                        A6(true);
                        this.L1 = false;
                    }
                } else if (i2 != 12004) {
                    if (i2 != 12006) {
                        if (i2 == 12010) {
                            this.c1 = String.valueOf(System.currentTimeMillis());
                            SelectImageHelper.takePhoto(getPageContext(), this.c1);
                        } else if (i2 == 12012) {
                            g7();
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
                        this.a.h(this.N, this.S);
                    }
                } else if (this.N == getCurrentFocus()) {
                    V1().clearFocus();
                    this.N.requestFocus();
                    EditorTools editorTools4 = this.r0;
                    if (editorTools4 != null) {
                        editorTools4.q();
                    }
                    ShowSoftKeyPadDelay(this.N);
                } else {
                    V1().requestFocus();
                    EditorTools editorTools5 = this.r0;
                    if (editorTools5 != null) {
                        editorTools5.q();
                    }
                    ShowSoftKeyPadDelay(this.S);
                }
            }
            M1();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity, com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048734, this, i2) == null) {
            super.onChangeSkinType(i2);
            getLayoutMode().j(this.A1);
            SkinManager.setBackgroundColor(this.V, R.color.CAM_X0205);
            if (this.x1 != null && (i2 == 1 || i2 == 4)) {
                this.x1.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
            }
            RichTextEditor richTextEditor = this.Q0;
            if (richTextEditor != null) {
                richTextEditor.v();
            }
            if (this.J.getBackImageView() != null) {
                this.J.getBackImageView().setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809cf, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            }
            SkinManager.setBackgroundColor(this.l1, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(W1(), R.color.CAM_X0205);
            this.V0.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080923, SkinManager.getColor(R.color.CAM_X0107), null));
            this.U0.e();
            if (TextUtils.isEmpty(this.S0)) {
                if (this.t) {
                    SkinManager.setBackgroundColor(this.j1, R.color.CAM_X0205);
                } else {
                    SkinManager.setBackgroundColor(this.P0, R.color.CAM_X0205);
                }
            }
            iy8 iy8Var = this.n2;
            if (iy8Var != null) {
                iy8Var.notifyDataSetChanged();
            }
            this.g1.d.notifyDataSetChanged();
            A6(false);
            LocalChannelTopicSelectView localChannelTopicSelectView = this.S1;
            if (localChannelTopicSelectView != null) {
                localChannelTopicSelectView.b();
            }
            ForumSelectedView forumSelectedView = this.T1;
            if (forumSelectedView != null) {
                forumSelectedView.c();
            }
            WriteEvaluationHeaderView writeEvaluationHeaderView = this.V1;
            if (writeEvaluationHeaderView != null) {
                writeEvaluationHeaderView.f();
            }
            xy8 xy8Var = this.a2;
            if (xy8Var != null) {
                xy8Var.d(i2);
            }
            EBusinessProtocolView eBusinessProtocolView = this.s2;
            if (eBusinessProtocolView != null) {
                eBusinessProtocolView.j(i2);
            }
            TextView textView = this.W1;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0301);
            }
            AssociatedItemContainer associatedItemContainer = this.l2;
            if (associatedItemContainer != null) {
                associatedItemContainer.c();
            }
            View view2 = this.v2;
            if (view2 == null || view2.getVisibility() != 0) {
                return;
            }
            X6();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048735, this) == null) {
            this.J.removeCallbacks(this.K2);
            kk8 kk8Var = this.d1;
            if (kk8Var != null) {
                kk8Var.t();
            }
            z5();
            c7(true);
            if (!this.H2) {
                x6();
            }
            sg.a(this.Y1, this);
            super.onDestroy();
            u0().onDestory(getPageContext());
            ny8 ny8Var = this.g1;
            if (ny8Var != null) {
                ny8Var.f();
            }
            wz5 wz5Var = this.M1;
            if (wz5Var != null) {
                wz5Var.I();
            }
            MessageManager.getInstance().unRegisterTask(2921500);
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity, android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048736, this) == null) {
            super.onDismiss();
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.d0, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, null);
            ShowSoftKeyPadDelay(this.S);
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity, com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048737, this, z2) == null) {
            super.onKeyboardVisibilityChanged(z2);
            if (this.B1 && System.currentTimeMillis() - this.C1 < 800) {
                pi.x(getPageContext().getPageActivity(), getCurrentFocus());
                this.B1 = false;
            }
            if (this.O1 == null || z2) {
                return;
            }
            z5();
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048738, this, intent) == null) {
            super.onNewIntent(intent);
            if (intent == null) {
                return;
            }
            if (this.t1) {
                f5(intent);
                return;
            }
            String stringExtra = intent.getStringExtra(BaseWriteConfig.KEY_WRITE_IMAGES_INFO_STRING);
            if (stringExtra == null || (writeImagesInfo = this.y) == null) {
                return;
            }
            writeImagesInfo.parseJson(stringExtra);
            this.y.updateQuality();
            if (this.y.getChosedFiles() != null) {
                J2();
            }
            F6(true);
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048739, this) == null) {
            super.onPause();
            u0().onPause(getPageContext());
            if (this.r0.u()) {
                this.r0.q();
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity, com.baidu.tbadk.BaseActivity, android.app.Activity
    @SuppressLint({"NewApi"})
    @TargetApi(23)
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048740, this, i2, strArr, iArr) == null) {
            if (i2 == 1) {
                ArrayMap<String, Boolean> transformPermissionResult = PermissionUtil.transformPermissionResult(strArr, iArr);
                if (PermissionUtil.checkCamera(getApplicationContext())) {
                    SelectImageHelper.takePhoto(getPageContext(), this.c1);
                } else {
                    showToast(R.string.obfuscated_res_0x7f0f1302);
                }
                if (!transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") || transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                    return;
                }
                showToast(R.string.obfuscated_res_0x7f0f1063);
                return;
            }
            super.onRequestPermissionsResult(i2, strArr, iArr);
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048741, this) == null) {
            super.onResume();
            u0().onResume(getPageContext());
            if (this.t) {
                if (this.v.getType() == 5) {
                    this.m1.setVisibility(8);
                } else {
                    this.m1.setVisibility(0);
                }
                O6(this.p1, this.j1);
                O6(this.o1, this.n1);
            }
            if (this.I0) {
                this.p = true;
                M1();
                EditorTools editorTools = this.r0;
                if (editorTools != null) {
                    editorTools.q();
                }
                this.N.requestFocus();
                ShowSoftKeyPadDelay(this.N);
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048742, this, bundle) == null) {
            bundle.putString(WriteActivityConfig.FLOOR_ID, this.v.getFloor());
            bundle.putInt("floor_num", this.v.getFloorNum());
            bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.Z0);
            if (this.I0) {
                bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
            }
            bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.G1);
            bundle.putBoolean(WriteActivityConfig.CAN_GOODS, this.H1);
            bundle.putBoolean(WriteActivityConfig.NEED_CLOSE_PRE_PAGE, this.k2);
            bundle.putInt(WriteActivityConfig.KEY_STATISTIS_FROM, this.v.getStatisticFrom());
            super.onSaveInstanceState(bundle);
            u0().onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048743, this) == null) {
            super.onStart();
            u0().onStart(getPageContext());
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048744, this) == null) {
            super.onStop();
            u0().onStop(getPageContext());
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void p2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048745, this) == null) {
            super.p2();
            this.X0 = (ImageView) this.J.getCenterImgBox();
            View centerImgBoxLayout = this.J.getCenterImgBoxLayout();
            this.W0 = centerImgBoxLayout;
            centerImgBoxLayout.setOnClickListener(new g(this));
            if (this.u1) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.M.getLayoutParams();
                layoutParams.rightMargin = 0;
                layoutParams.leftMargin = 0;
                this.M.setLayoutParams(layoutParams);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.X0.getLayoutParams();
                layoutParams2.width = pi.f(this, R.dimen.tbds31);
                layoutParams2.height = pi.f(this, R.dimen.tbds31);
                this.X0.setLayoutParams(layoutParams2);
                this.X0.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08096e, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_DISABLE));
                this.X0.setVisibility(0);
            }
            this.N0 = (FeedBackTopListView) findViewById(R.id.obfuscated_res_0x7f090968);
            this.O0 = findViewById(R.id.obfuscated_res_0x7f090966);
            this.B2 = (WriteImageGridView) findViewById(R.id.obfuscated_res_0x7f092524);
            this.M0 = findViewById(R.id.obfuscated_res_0x7f0920f1);
            if (this.t) {
                this.g0.setVisibility(8);
                this.y.setMaxImagesAllowed(6);
                F5();
            } else {
                this.g1 = new ny8(getPageContext(), this.I);
                if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.f)) {
                    this.g1.i(false);
                } else {
                    this.g1.j(this.v.getType() == 0 || this.v.getType() == 9 || this.v.getType() == 11);
                }
                this.g1.h(this.t1);
            }
            U6(true, false);
            if (this.I0 || this.s) {
                getWindow().setSoftInputMode(18);
            }
            this.T0 = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091236);
            this.U0 = (PlayVoiceBntNew) findViewById(R.id.obfuscated_res_0x7f09042d);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f090f91);
            this.V0 = imageView;
            imageView.setOnClickListener(new h(this));
            z4(this.H0);
            N6(Y5());
            W5();
            N5();
            R5();
            I5();
            V5();
            U5();
            T5();
            M5();
            H5();
            D5();
            W6();
        }
    }

    public final void p4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048746, this) == null) {
            this.r0.d(new x15(getActivity(), 7));
        }
    }

    public final void p5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048747, this, str) == null) {
            if (this.y.getChosedFiles() != null && this.y.getChosedFiles().size() >= this.y.getMaxImagesAllowed()) {
                showToast(String.format(getPageContext().getContext().getString(R.string.obfuscated_res_0x7f0f0a80), Integer.valueOf(this.y.getMaxImagesAllowed())));
                return;
            }
            this.y.addChooseFileFromCamera(str);
            this.y.updateQuality();
            r4(this.y.getChosedFiles().getLast());
            this.B1 = true;
            C6();
            H6();
            if (this.y.getChosedFiles() != null) {
                J2();
            }
            F6(true);
        }
    }

    public final void p6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048748, this) == null) {
            this.S.setVisibility(0);
            this.Q0.setVisibility(8);
            ny8 ny8Var = this.g1;
            if (ny8Var != null) {
                ny8Var.h(false);
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048749, this) == null) {
            this.P0 = findViewById(R.id.obfuscated_res_0x7f091929);
            RichTextEditor richTextEditor = (RichTextEditor) findViewById(R.id.obfuscated_res_0x7f091af3);
            this.Q0 = richTextEditor;
            richTextEditor.setWriteImagesInfo(this.y);
            SpanGroupEditText spanGroupEditText = (SpanGroupEditText) findViewById(R.id.obfuscated_res_0x7f091928);
            this.S = spanGroupEditText;
            spanGroupEditText.setDrawingCacheEnabled(false);
            this.S.setOnClickListener(this.D0);
            y yVar = new y(this);
            this.S.setOnSpanGroupChangedListener(yVar);
            this.S.setType(SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_COMMODITY);
            this.S.setForumId(ng.g(this.v.getForumId(), 0L));
            kk8 kk8Var = this.d1;
            if (kk8Var != null) {
                kk8Var.G(this.S.getSpanGroupManager());
            }
            WriteData writeData = this.v;
            if (writeData != null) {
                writeData.setSpanGroupManager(this.S.getSpanGroupManager());
            }
            if (this.v.getContent() != null && this.v.getContent().length() > 0) {
                this.S.setText(TbFaceManager.i().r(getPageContext().getPageActivity(), this.v.getContent()));
                if (this.S.getText() != null) {
                    SpanGroupEditText spanGroupEditText2 = this.S;
                    spanGroupEditText2.setSelection(spanGroupEditText2.getText().length());
                }
            } else if (this.v.getType() == 2) {
                if (this.Z0) {
                    String str = this.a1;
                    if (str != null && str.length() > 0) {
                        this.S.setText(getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f0fb4, new Object[]{this.a1}));
                        SpanGroupEditText spanGroupEditText3 = this.S;
                        spanGroupEditText3.setSelection(spanGroupEditText3.getText().length());
                    }
                } else if (this.v.getFloorNum() > 0) {
                    this.S.setText(String.format(getPageContext().getString(R.string.obfuscated_res_0x7f0f0fb6), Integer.valueOf(this.v.getFloorNum())));
                    SpanGroupEditText spanGroupEditText4 = this.S;
                    spanGroupEditText4.setSelection(spanGroupEditText4.getText().length());
                }
            }
            this.S.setOnFocusChangeListener(this.E0);
            this.S.setOnTouchListener(new z(this));
            this.S.addTextChangedListener(this.v0);
            if (this.v.getType() == 0) {
                this.L1 = true;
            } else {
                A6(true);
                this.L1 = false;
            }
            if (this.d2) {
                SpannableString spannableString = new SpannableString(" " + ((Object) getResources().getText(R.string.obfuscated_res_0x7f0f1583)));
                Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08098c, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL);
                pureDrawable.setBounds(0, 0, pureDrawable.getIntrinsicWidth(), pureDrawable.getIntrinsicHeight());
                spannableString.setSpan(new p86(pureDrawable, 1, pi.f(this, R.dimen.tbds4)), 0, 1, 17);
                this.S.setHint(spannableString);
            } else if (this.v.isUserFeedback()) {
                this.S.setHint(R.string.obfuscated_res_0x7f0f1587);
            } else {
                this.S.setHint(R.string.obfuscated_res_0x7f0f0a59);
            }
            this.Q0.setOnSpanGroupChangedListener(yVar);
            this.Q0.setForumId(ng.g(this.v.getForumId(), 0L));
            this.Q0.setEditOnClickListener(this.D0);
            this.Q0.setEditOnFocusChangeListener(this.E0);
            this.Q0.setBigEmotionSpanHandler(this.x0);
            this.Q0.j(this.v0);
            this.Q0.m();
            S5();
        }
    }

    public final void q4() {
        CustomResponsedMessage runTask;
        v15 v15Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048750, this) == null) || (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, getActivity()), v15.class)) == null || (v15Var = (v15) runTask.getData()) == null) {
            return;
        }
        v15Var.o = true;
        v15Var.l = 9;
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.f)) {
            return;
        }
        this.r0.d(v15Var);
    }

    public final void q5(Intent intent, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048751, this, intent, z2) == null) || intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            this.y.parseJson(stringExtra);
            this.y.updateQuality();
            C6();
            H6();
            if (this.y.getChosedFiles() != null) {
                J2();
            }
        }
        F6(true);
    }

    public final void q6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048752, this) == null) {
            this.S.setVisibility(8);
            this.Q0.setVisibility(0);
            ny8 ny8Var = this.g1;
            if (ny8Var != null) {
                ny8Var.h(true);
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void r2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048753, this) == null) {
            HeadImageView headImageView = (HeadImageView) findViewById(R.id.obfuscated_res_0x7f09231d);
            this.L0 = headImageView;
            headImageView.setIsRound(true);
            this.L0.setDrawBorder(false);
            this.L0.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
            if (!StringUtils.isNull(currentPortrait)) {
                String headPortraitFilter = HeadIconRefreshHelper.headPortraitFilter(currentPortrait);
                this.L0.setUrl(headPortraitFilter);
                this.L0.J(headPortraitFilter, 12, false);
            }
            if (this.v.isUserFeedback()) {
                this.L0.setVisibility(0);
            }
            EditText editText = (EditText) findViewById(R.id.obfuscated_res_0x7f091945);
            this.N = editText;
            editText.setOnClickListener(this.D0);
            this.N.setOnFocusChangeListener(this.E0);
            if (this.v.getType() != 0 && this.v.getType() != 9 && this.v.getType() != 11 && this.v.getType() != 7) {
                if (this.v.getType() != 1) {
                    this.v.getType();
                }
            } else if (this.v.getTitle() != null) {
                this.N.setText(this.v.getTitle());
                this.N.setSelection(this.v.getTitle().length());
            } else if (this.K0) {
                this.N.setText(getResources().getString(R.string.obfuscated_res_0x7f0f14b1));
            }
            this.N.addTextChangedListener(this.w0);
            this.N.setFilters(new InputFilter[]{new vx8.b(this.N, 31, new w(this))});
            vr4.d(this.N).A(R.string.F_X02);
            if (this.v.getHaveDraft()) {
                return;
            }
            k2();
            this.D1 = true;
        }
    }

    public final void r4(ImageFileInfo imageFileInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048754, this, imageFileInfo) == null) && this.t1 && imageFileInfo != null) {
            X5(imageFileInfo);
        }
    }

    public final int r5(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048755, this, new Object[]{Double.valueOf(d2)})) == null) ? (int) ((d2 + 1.0d) / 2.0d) : invokeCommon.intValue;
    }

    public void r6(k15 k15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048756, this, k15Var) == null) {
            if (this.t) {
                K6();
            }
            if (this.r0.u()) {
                this.r0.q();
            }
            if (this.t1) {
                g6();
            } else {
                f6(0);
            }
        }
    }

    public final void s4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048757, this) == null) || this.d2) {
            return;
        }
        if (!"main_tab".equals(this.f)) {
            this.r0.d(new n15(getActivity(), 10));
        }
        this.r0.d(new j25(getActivity(), 11));
    }

    public final int s5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048758, this)) == null) {
            SpanGroupEditText spanGroupEditText = this.S;
            if (spanGroupEditText == null || spanGroupEditText.getSpanGroupManager() == null) {
                return 10;
            }
            return 10 - this.S.getSpanGroupManager().x();
        }
        return invokeV.intValue;
    }

    public void s6(k15 k15Var) {
        String str;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048759, this, k15Var) == null) {
            if (this.t) {
                K6();
            }
            if (this.r0.u()) {
                this.r0.q();
            }
            int a2 = tw8.a();
            if (tw8.c(a2)) {
                tw8.e(getPageContext().getPageActivity(), a2, WorkPublishOpenHelper.OPEN_WORK_PUBLISH_FROM_FRS_WRITE);
            } else if (tw8.b()) {
                if (this.y == null || this.v == null) {
                    return;
                }
                if (this.N.getText().toString() != null) {
                    str = this.N.getText().toString();
                    i2 = 5;
                } else {
                    str = this.E;
                    i2 = 1;
                }
                if (this.U1 == null && this.v.getForumName() != null) {
                    tw8.f(getPageContext(), str, this.S.getText().toString(), this.v.getForumId(), this.v.getForumName(), 3, Boolean.FALSE, "", "", "");
                } else {
                    tw8.f(getPageContext(), str, this.S.getText().toString(), this.v.getForumId(), this.v.getForumName(), i2, Boolean.TRUE, "", "", "");
                }
            } else {
                i6(0);
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void t2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048760, this) == null) {
            this.L.setOnClickListener(new u(this));
        }
    }

    public final void t4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048761, this) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            this.r0.h(arrayList);
            v15 n2 = this.r0.n(5);
            if (n2 != null) {
                n2.l = 5;
            }
        }
    }

    public final TextWatcher t5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048762, this)) == null) {
            x xVar = new x(this);
            if (this.t && this.s1) {
                TextWatcher textWatcher = this.q1;
                if (textWatcher != null) {
                    this.n1.removeTextChangedListener(textWatcher);
                }
                this.q1 = xVar;
            } else if (this.t) {
                TextWatcher textWatcher2 = this.r1;
                if (textWatcher2 != null) {
                    this.j1.removeTextChangedListener(textWatcher2);
                }
                this.r1 = xVar;
            }
            return xVar;
        }
        return (TextWatcher) invokeV.objValue;
    }

    public final void t6(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048763, this, str) == null) {
            this.r2 = new ArrayList();
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
                    this.r2.add(cs6.g(jSONObject));
                }
                if (this.r2.size() > 0) {
                    this.u2 = true;
                    this.S.g(this.r2, arrayList);
                    O5();
                    E6();
                    this.o2.setVisibility(0);
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public synchronized VoiceManager u0() {
        InterceptResult invokeV;
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048764, this)) == null) {
            synchronized (this) {
                if (this.e1 == null) {
                    this.e1 = VoiceManager.instance();
                }
                voiceManager = this.e1;
            }
            return voiceManager;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public final void u4(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048765, this, editable) == null) {
            U4(editable);
            G6(editable);
        }
    }

    public final String u5() {
        InterceptResult invokeV;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048766, this)) == null) {
            if (this.v == null || W1() == null || W1().getVisibility() != 0 || W1().getText() == null) {
                return "";
            }
            String obj = W1().getText().toString();
            PostPrefixData postPrefixData = this.d;
            if (postPrefixData != null && ListUtils.getCount(postPrefixData.getPrefixs()) > 0 && this.l != ListUtils.getCount(this.d.getPrefixs()) - 1 && this.v.getType() != 4 && (textView = this.b0) != null && textView.getText() != null) {
                this.v.setPostPrefix(this.b0.getText().toString());
            }
            PostPrefixData postPrefixData2 = this.d;
            if (postPrefixData2 == null || StringUtils.isNull(postPrefixData2.getImplicitTitle())) {
                return obj;
            }
            return this.d.getImplicitTitle() + this.v.getTitle();
        }
        return (String) invokeV.objValue;
    }

    public final void u6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048767, this) == null) {
            TextView textView = this.L;
            if (textView != null && ((textView.isEnabled() || this.d2 || !ListUtils.isEmpty(this.v.getItemDatas())) && ((!this.d2 || !TextUtils.isEmpty(this.S.getText()) || (this.y.getChosedFiles() != null && this.y.size() != 0)) && this.g2))) {
                if (this.Z1 == null) {
                    this.Z1 = new SaveDraftDialogView(this);
                    this.Z1.setOnClickListener(new f(this));
                }
                if (this.Y1 == null) {
                    mr4 mr4Var = new mr4(getPageContext());
                    this.Y1 = mr4Var;
                    mr4Var.setContentView(this.Z1);
                }
                this.Z1.setText(getString(R.string.obfuscated_res_0x7f0f158f), null, getString(R.string.obfuscated_res_0x7f0f104a));
                this.Y1.m();
                return;
            }
            P4();
            setResult(100);
            finish();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void v2(@NonNull k15 k15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048768, this, k15Var) == null) {
            super.v2(k15Var);
            int i2 = k15Var.a;
            if (i2 == 16) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 9));
            } else if (i2 == 14 || i2 == 48) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 1));
                r6(k15Var);
            } else if (i2 == 60) {
                s6(k15Var);
            } else if (i2 == 24) {
                Object obj = k15Var.c;
                if (obj instanceof mx4) {
                    mx4 mx4Var = (mx4) obj;
                    if (EmotionGroupType.isSendAsPic(mx4Var.getType())) {
                        if (this.mCurrentPermissionJudgePolicy == null) {
                            this.mCurrentPermissionJudgePolicy = new PermissionJudgePolicy();
                        }
                        this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
                        this.mCurrentPermissionJudgePolicy.appendRequestPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.mCurrentPermissionJudgePolicy.startRequestPermission(this)) {
                            return;
                        }
                        if (this.y.size() >= this.y.getMaxImagesAllowed()) {
                            showToast(String.format(getString(R.string.obfuscated_res_0x7f0f0a80), Integer.valueOf(this.y.getMaxImagesAllowed())));
                            return;
                        }
                        ImageFileInfo imageFileInfo = new ImageFileInfo();
                        imageFileInfo.setImageType(1);
                        imageFileInfo.setFilePath(mx4Var.d());
                        imageFileInfo.width = mx4Var.h();
                        imageFileInfo.height = mx4Var.b();
                        this.y.addChooseFile(imageFileInfo);
                        this.y.updateQuality();
                        r4(imageFileInfo);
                        F6(true);
                        H6();
                        C6();
                        D2();
                    } else if (u2()) {
                        showToast(R.string.obfuscated_res_0x7f0f0cf3);
                    } else {
                        s2(mx4Var);
                    }
                }
            } else if (i2 == 10) {
                Object obj2 = k15Var.c;
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
                D2();
            } else if (i2 == 15 || i2 == 47) {
                Object obj3 = k15Var.c;
                if (obj3 instanceof Integer) {
                    h6(((Integer) obj3).intValue());
                }
            } else {
                WriteVoteData writeVoteData = null;
                if (i2 == 25) {
                    Object obj4 = k15Var.c;
                    if (obj4 instanceof String) {
                        this.S0 = (String) obj4;
                    } else {
                        this.S0 = null;
                    }
                    A6(false);
                } else if (i2 == 43) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 4));
                    yt4.k().u("hot_topic_has_click", true);
                    this.r0.A(new k15(2, 26, null));
                    this.r = true;
                    B2(true);
                    if (W1().isFocused() && this.Q.getVisibility() == 0) {
                        this.g = "from_title";
                    } else {
                        this.g = "from_content";
                    }
                } else if (i2 == 58) {
                    Object obj5 = k15Var.c;
                    if (obj5 instanceof Boolean) {
                        this.I1 = ((Boolean) obj5).booleanValue();
                    }
                } else if (i2 == 22) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 10));
                    xy8 xy8Var = this.a2;
                    if (xy8Var != null && xy8Var.c() != null) {
                        writeVoteData = this.a2.c();
                    }
                    j6(writeVoteData);
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_WRITE_VOTE_VIEW_SHOW).param("obj_source", 2));
                    A5();
                } else if (i2 == 21) {
                    WriteTipBubbleController writeTipBubbleController = this.N1;
                    if (writeTipBubbleController != null) {
                        writeTipBubbleController.c();
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 5));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddLinkActivityConfig(getActivity(), 25049, "", true, null)));
                } else if (i2 == 59) {
                    n6();
                } else if (i2 == 61) {
                    o6();
                } else if (i2 == 66) {
                    Object obj6 = k15Var.c;
                    if (obj6 instanceof Boolean) {
                        this.J1 = ((Boolean) obj6).booleanValue();
                    }
                }
            }
        }
    }

    public final void v4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048769, this) == null) && StringHelper.equals(this.o, "2")) {
            k25 k25Var = new k25(getActivity(), 4);
            this.C2 = k25Var;
            if (this.d2) {
                k25Var.g(false);
                this.C2.h(false);
            }
            this.r0.d(this.C2);
            if (this.d2) {
                return;
            }
            this.r0.d(new z35(getActivity(), 8));
        }
    }

    public final void v5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048770, this) == null) && this.I0 && this.v != null) {
            this.N0.setVisibility(0);
            this.O0.setVisibility(0);
            FeedBackModel feedBackModel = new FeedBackModel(getPageContext());
            this.H = feedBackModel;
            feedBackModel.D(this.v.getForumName());
            this.H.setLoadDataCallBack(new t(this));
        }
    }

    public final void v6() {
        HotTopicBussinessData hotTopicBussinessData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048771, this) == null) {
            b7();
            this.v.setContent(h5());
            y6(u5());
            if (this.I0 || this.s) {
                String string = getResources().getString(R.string.obfuscated_res_0x7f0f027e);
                if (TextUtils.isEmpty(this.v.getTitle()) || !this.v.getTitle().startsWith(string)) {
                    y6(string + this.v.getTitle());
                }
                String str = getResources().getString(R.string.obfuscated_res_0x7f0f029e) + getResources().getString(R.string.obfuscated_res_0x7f0f13a3);
                if (TextUtils.isEmpty(this.v.getContent()) || !this.v.getContent().startsWith(str)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(TbConfig.getVersion());
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    sb.append(Build.VERSION.RELEASE);
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    sb.append(Build.MODEL);
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    if (ni.z()) {
                        sb.append(ni.K());
                    } else {
                        sb.append(RomUtils.UNKNOWN);
                    }
                    sb.append(":");
                    sb.append(this.v.getContent());
                    this.v.setContent(sb.toString());
                }
            }
            if (this.J0) {
                this.v.setZhongcePrefix(String.format(getResources().getString(R.string.obfuscated_res_0x7f0f0855), Build.MODEL, TbadkCoreApplication.getInst().getVersionName(), ni.K(), Build.VERSION.RELEASE));
            }
            int i2 = this.j;
            if (i2 >= 0) {
                this.v.setCategoryFrom(i2);
            }
            int i3 = this.k;
            if (i3 >= 0) {
                this.v.setCategoryTo(i3);
            }
            this.v.setWriteImagesInfo(this.y);
            this.Q0.setWriteImagesInfo(this.y);
            xy8 xy8Var = this.a2;
            if (xy8Var != null) {
                this.v.setWriteVoteData(xy8Var.c());
            }
            WriteImagesInfo writeImagesInfo = this.y;
            if (writeImagesInfo != null && writeImagesInfo.size() > 0) {
                Iterator<ImageFileInfo> it = this.y.getChosedFiles().iterator();
                int i4 = 0;
                while (it.hasNext()) {
                    ImageFileInfo next = it.next();
                    if (next != null && next.isFromCamera()) {
                        i4++;
                    }
                }
                this.v.setTakePhotoNum(i4);
            }
            WriteData writeData = this.v;
            LocationModel locationModel = this.G;
            writeData.setHasLocationData(locationModel != null && locationModel.D());
            WriteImagesInfo writeImagesInfo2 = this.y;
            if (writeImagesInfo2 != null) {
                this.d1.A(writeImagesInfo2.size() > 0);
            }
            if (!ListUtils.isEmpty(this.B) && (hotTopicBussinessData = this.C) != null && hotTopicBussinessData.mIsGlobalBlock == 0) {
                this.v.setForumId(String.valueOf(hotTopicBussinessData.mForumId));
                this.v.setForumName(this.C.mForumName);
            }
            WriteEvaluationHeaderView writeEvaluationHeaderView = this.V1;
            if (writeEvaluationHeaderView != null && writeEvaluationHeaderView.getEvaluateItemInfo() != null) {
                this.v.setItem_id(this.V1.getEvaluateItemInfo().getItemID());
                this.v.setComment_head(g5());
            }
            E1();
            this.d1.H(this.v);
            WriteData writeData2 = this.v;
            writeData2.setContent(writeData2.getContent().replaceAll("\u0000\n", ""));
            WriteData writeData3 = this.v;
            writeData3.setContent(writeData3.getContent().replaceAll("\u0000", ""));
            this.v.setVcode(null);
            this.v.setVoiceModel(this.H0);
            VoiceData.VoiceModel voiceModel = this.H0;
            if (voiceModel != null) {
                if (voiceModel.getId() != null) {
                    this.d1.o().setVoice(this.H0.getId());
                    this.d1.o().setVoiceDuringTime(this.H0.duration);
                } else {
                    this.d1.o().setVoice(null);
                    this.d1.o().setVoiceDuringTime(-1);
                }
            } else {
                this.d1.o().setVoice(null);
                this.d1.o().setVoiceDuringTime(-1);
            }
            this.v.setRichTextEditorMode(this.t1);
            if (this.t1) {
                this.v.setServerRichContent(this.Q0.getPostServerContentData());
            }
            if (!this.d1.e()) {
                showToast(R.string.obfuscated_res_0x7f0f1586);
            } else if (!ni.z()) {
                showToast(R.string.obfuscated_res_0x7f0f0c17);
            } else if (i08.a().b() == 0 && this.J1) {
                X6();
            } else {
                Z6();
            }
        }
    }

    public final void w4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048772, this) == null) {
            h25 h25Var = new h25(getActivity(), 1);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.f)) {
                return;
            }
            this.r0.d(h25Var);
        }
    }

    public final void w5(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048773, this, str) == null) {
            try {
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (skinType == 4) {
                    str2 = "&skin=dart";
                } else if (skinType == 1) {
                    str2 = "&skin=" + SkinManager.SKIN_TYPE_STR_NIGHT;
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

    public final void w6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048774, this) == null) {
            if ("1".equals(this.o)) {
                this.v.setCanNoForum(true);
                this.v.setTransmitForumData("[]");
            } else if ("2".equals(this.o)) {
                this.v.setCanNoForum(false);
            }
            F2();
            this.v.setPrivacy(this.q);
            L6();
            this.v.setToDynamic(this.I1);
            M6();
            this.v.setShowCustomFigure(this.J1);
            this.v.setCallFrom(this.o);
            if (this.v.getVideoInfo() != null) {
                TiebaStatic.log("c10063");
            }
            v6();
        }
    }

    public final void x4() {
        CustomResponsedMessage runTask;
        v15 v15Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048775, this) == null) || (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, getActivity()), v15.class)) == null || (v15Var = (v15) runTask.getData()) == null) {
            return;
        }
        v15Var.o = true;
        v15Var.l = 10;
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.f)) {
            return;
        }
        this.r0.d(v15Var);
    }

    public final boolean x5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048776, this)) == null) {
            xy8 xy8Var = this.a2;
            return (xy8Var == null || this.b2 == null || xy8Var.c() == null || this.b2.getVisibility() != 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void x6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048777, this) == null) {
            WriteData writeData = this.v;
            if (writeData != null && writeData.getType() == 2 && this.Z0) {
                finish();
            } else if (this.v == null) {
                finish();
            } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.f)) {
                finish();
            } else {
                this.v.setTitle(W1().getText().toString());
                this.v.setContent(V1().getText().toString());
                WriteEvaluationHeaderView writeEvaluationHeaderView = this.V1;
                if (writeEvaluationHeaderView != null) {
                    this.v.setEvaluationStar(writeEvaluationHeaderView.getStarCount());
                }
                this.v.setRichTextEditorMode(this.t1);
                if (this.t1) {
                    this.v.setRichContentData(this.Q0.getPlainTextContentData());
                }
                int type = this.v.getType();
                if (type == 0 || type == 9 || type == 11) {
                    if (this.g2) {
                        if (this.E1) {
                            rh8.t(this.v);
                        } else if (this.v.isEvaluate()) {
                            rh8.q(this.v.getItem_id(), this.v);
                        } else if (TextUtils.isEmpty(this.v.getTopicId())) {
                            rh8.r(this.v.getForumId(), this.v);
                        } else {
                            rh8.y(this.v.getTopicId(), this.v);
                        }
                    }
                } else if (type == 7) {
                    if (this.g2) {
                        rh8.r("24591571", this.v);
                    }
                } else if (type == 1) {
                    rh8.w(this.v.getThreadId(), this.v);
                } else if (type == 4) {
                    rh8.r(this.v.getForumId() + "photolive", this.v);
                } else if (type == 5) {
                    rh8.w(this.v.getThreadId() + "updatephotolive", this.v);
                }
                this.H2 = true;
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void y2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048778, this) == null) {
            super.y2();
            b7();
            u6();
        }
    }

    public final void y4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048779, this) == null) {
            x35 x35Var = new x35(getActivity(), 2);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.f)) {
                return;
            }
            this.r0.d(x35Var);
        }
    }

    public final void y5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048780, this) == null) {
            View view2 = this.t ? this.j1 : this.P0;
            view2.setPadding(0, 0, 0, 0);
            view2.setBackgroundDrawable(null);
            SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
        }
    }

    public final void y6(String str) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048781, this, str) == null) || this.v == null || (linearLayout = this.Q) == null) {
            return;
        }
        if (linearLayout.getVisibility() == 0) {
            if (StringUtils.isNull(str)) {
                this.v.setIsNoTitle(true);
                this.v.setTitle("");
                return;
            }
            this.v.setIsNoTitle(false);
            this.v.setTitle(str);
            return;
        }
        this.v.setIsNoTitle(true);
        this.v.setTitle("");
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void z2(PostWriteCallBackData postWriteCallBackData, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048782, this, postWriteCallBackData, writeData) == null) {
            super.z2(postWriteCallBackData, writeData);
            vx8.e(this.v);
            P4();
            if ((this.v.getType() == 0 || this.v.getType() == 9 || this.v.getType() == 11) && !ListUtils.isEmpty(this.B) && !StringUtils.isNull(this.K1)) {
                TiebaStatic.log(new StatisticItem("c11731").param("obj_id", this.K1));
            }
            if (!oi.isEmpty(postWriteCallBackData.getVideoid()) && this.v.getVideoInfo() != null) {
                if (!oi.isEmpty(this.v.getForumName())) {
                    postWriteCallBackData.mFrom = 2;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001374, postWriteCallBackData));
            } else {
                L2(postWriteCallBackData);
            }
            finish();
        }
    }

    public final void z4(VoiceData.VoiceModel voiceModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048783, this, voiceModel) == null) || voiceModel == null || TextUtils.isEmpty(voiceModel.voiceId) || voiceModel.duration <= 0) {
            return;
        }
        this.H0 = voiceModel;
        this.v.setVoiceModel(voiceModel);
        this.T0.setVisibility(0);
        this.U0.setVoiceModel(voiceModel);
        this.U0.o();
        D2();
    }

    public final void z5() {
        gy8 gy8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048784, this) == null) || (gy8Var = this.O1) == null) {
            return;
        }
        gy8Var.a();
    }

    public final void z6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048785, this) == null) && this.v.getType() == 0 && this.v.getTitle() != null) {
            this.n1.setText(this.v.getTitle());
            this.n1.setSelection(this.v.getTitle().length());
        }
    }
}
