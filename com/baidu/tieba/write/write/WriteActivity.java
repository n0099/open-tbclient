package com.baidu.tieba.write.write;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
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
import android.text.style.ImageSpan;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
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
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.permissionhelper.app.ActivityCompat;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.AddLinkActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.BubbleChooseActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.LocalChannelTopicListActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.RelevanceItemSearchActivityConfig;
import com.baidu.tbadk.core.atomData.SelectForumConfig;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WorkPublishOpenHelper;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVoteActivityConfig;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.data.PostTopicData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.WriteTipBubbleController;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.message.EvaluateRelevanceItemSelectedMessage;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.EmotionUtil;
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
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.mutiprocess.event.GoodsEvent;
import com.baidu.tbadk.switchs.AsyncGetClipboardSwitch;
import com.baidu.tbadk.switchs.RepostToDynamicDefaultSwitch;
import com.baidu.tbadk.util.InsertGalleryAsyncTask;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.richText.TbRichTextEvaluateItemInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsPublishFineGoodsDialogView;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.EBusinessProtocolView;
import com.baidu.tieba.write.WritePrefixItemLayout;
import com.baidu.tieba.write.view.AssociatedItemContainer;
import com.baidu.tieba.write.view.ForumSelectedView;
import com.baidu.tieba.write.view.ForumTabSelectedView;
import com.baidu.tieba.write.view.LocalChannelTopicSelectView;
import com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout;
import com.baidu.tieba.write.view.PostCategoryView;
import com.baidu.tieba.write.view.RichGuideHollowView;
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
import com.repackage.ad5;
import com.repackage.ae6;
import com.repackage.c15;
import com.repackage.c9;
import com.repackage.d15;
import com.repackage.ed5;
import com.repackage.eh8;
import com.repackage.ex8;
import com.repackage.f15;
import com.repackage.fc5;
import com.repackage.fr4;
import com.repackage.fx8;
import com.repackage.gc5;
import com.repackage.gv4;
import com.repackage.gx8;
import com.repackage.h05;
import com.repackage.h15;
import com.repackage.hd5;
import com.repackage.ho8;
import com.repackage.ht4;
import com.repackage.hw8;
import com.repackage.hx4;
import com.repackage.i05;
import com.repackage.i15;
import com.repackage.ig;
import com.repackage.jg;
import com.repackage.jt4;
import com.repackage.jx8;
import com.repackage.k05;
import com.repackage.lx8;
import com.repackage.mj8;
import com.repackage.ng;
import com.repackage.ni;
import com.repackage.nq4;
import com.repackage.nt4;
import com.repackage.nw4;
import com.repackage.o05;
import com.repackage.o76;
import com.repackage.oi;
import com.repackage.oj8;
import com.repackage.or6;
import com.repackage.p76;
import com.repackage.pi;
import com.repackage.q55;
import com.repackage.qg;
import com.repackage.qj8;
import com.repackage.qv8;
import com.repackage.rg8;
import com.repackage.ri8;
import com.repackage.ru4;
import com.repackage.rv8;
import com.repackage.s05;
import com.repackage.s76;
import com.repackage.sd5;
import com.repackage.sg;
import com.repackage.t05;
import com.repackage.tw8;
import com.repackage.u05;
import com.repackage.u25;
import com.repackage.uj8;
import com.repackage.ux8;
import com.repackage.v05;
import com.repackage.vn4;
import com.repackage.w25;
import com.repackage.wg8;
import com.repackage.wq4;
import com.repackage.xc6;
import com.repackage.xs8;
import com.repackage.y15;
import com.repackage.yc6;
import com.repackage.ym;
import com.repackage.ys8;
import com.repackage.zc6;
import com.repackage.zw8;
import com.repackage.zy5;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class WriteActivity extends BaseActivity<WriteActivity> implements VoiceManager.j, wg8.f, qv8.a, PopupWindow.OnDismissListener, ActivityCompat.OnRequestPermissionsResultCallback {
    public static /* synthetic */ Interceptable $ic;
    public static int O2;
    public transient /* synthetic */ FieldHolder $fh;
    public final KeyEvent A;
    public lx8 A0;
    public WriteEvaluationHeaderView A1;
    public CustomMessageListener A2;
    public LinearLayout B;
    public GridView B0;
    public TextView B1;
    public CustomMessageListener B2;
    public PlayVoiceBntNew C;
    public zw8 C0;
    public ForumTabSelectedView C1;
    public CustomMessageListener C2;
    public ImageView D;
    public ScrollView D0;
    public View D1;
    public final View.OnClickListener D2;
    public NavigationBar E;
    public EditText E0;
    public FrsTabInfoData E1;
    public boolean E2;
    public View F;
    public View F0;
    public wq4 F1;
    public final View.OnFocusChangeListener F2;
    public TextView G;
    public View G0;
    public SaveDraftDialogView G1;
    public q55 G2;
    public TextView H;
    public View H0;
    public ux8 H1;
    public boolean H2;
    public View I;
    public EditText I0;
    public RelativeLayout I1;
    public TextWatcher I2;
    public ImageView J;
    public TextView J0;
    public View J1;
    public TextWatcher J2;
    public ImageView K;
    public TextView K0;
    public RichGuideHollowView K1;
    public int K2;
    public final Handler L;
    public TextWatcher L0;
    public TBLottieAnimationView L1;
    public xs8 L2;
    public boolean M;
    public TextWatcher M0;
    public RelativeLayout M1;
    public final eh8.f M2;
    public String N;
    public boolean N0;
    public TextView N1;
    public final Runnable N2;
    public RelativeLayout O;
    public boolean O0;
    public TextView O1;
    public Toast P;
    public jt4 P0;
    public TextView P1;
    public boolean Q;
    public boolean Q0;
    public TextView Q1;
    public String R;
    public boolean R0;
    public SerializableItemInfo R1;
    public EditorTools S;
    public String S0;
    public boolean S1;
    public WriteImagesInfo T;
    public File T0;
    public boolean T1;
    public String U;
    public TbImageView U0;
    public int U1;
    public oj8 V;
    public View V0;
    public boolean V1;
    public LocationModel W;
    public Dialog W0;
    public boolean W1;
    public VoiceManager X;
    public LinearLayout X0;
    public String X1;
    public int Y;
    public boolean Y0;
    public Serializable Y1;
    public AdditionData Z;
    public long Z0;
    public String Z1;
    public String a;
    public boolean a1;
    public boolean a2;
    public boolean b;
    public boolean b1;
    public String b2;
    public WriteData c;
    public String c1;
    public String c2;
    public VoiceData.VoiceModel d;
    public String d1;
    public AssociatedItemContainer d2;
    public boolean e;
    public int e1;
    public final gx8.d e2;
    public boolean f;
    public boolean f1;
    public gx8 f2;
    public boolean g;
    public RelativeLayout g0;
    public boolean g1;
    public LinearLayout g2;
    public boolean h;
    public TextView h0;
    public boolean h1;
    public ImageView h2;
    public int i;
    public TextView i0;
    public List<HotTopicBussinessData> i1;
    public TextView i2;
    public InputMethodManager j;
    public TextView j0;
    public HotTopicBussinessData j1;
    public List<or6> j2;
    public EditText k;
    public PostPrefixData k0;
    public TextView k1;
    public EBusinessProtocolView k2;
    public HeadImageView l;
    public PostTopicData l0;
    public String l1;
    public boolean l2;
    public View m;
    public TextView m0;
    public hw8 m1;
    public boolean m2;
    public LinearLayout n;
    public qv8 n0;
    public boolean n1;
    public final HttpMessageListener n2;
    public LinearLayout o;
    public ImageView o0;
    public boolean o1;
    public CustomMessageListener o2;
    public View p;
    public View p0;
    public final fx8 p1;
    public final CustomMessageListener p2;
    public LinearLayout q;
    public int q0;
    public jx8 q1;
    public TbFaceManager.a q2;
    public SpanGroupEditText r;
    public GestureDetector r0;
    public zy5 r1;
    public final AntiHelper.k r2;
    public FeedBackModel s;
    public List<xc6> s0;
    public WriteTipBubbleController s1;
    public WriteTipBubbleController.b s2;
    public FeedBackTopListView t;
    public xc6 t0;
    public ex8 t1;
    public ListView t2;
    public View u;
    public int u0;
    public String u1;
    public WriteImageGridView u2;
    public View v;
    public String v0;
    public String v1;
    public i15 v2;
    public ArrayList<WritePrefixItemLayout> w;
    public int w0;
    public String w1;
    public final NewWriteModel.e w2;
    public View x;
    public PostCategoryView x0;
    public LocalChannelTopicSelectView x1;
    public final LocationModel.e x2;
    public RichTextEditor y;
    public WriteImagesInfo y0;
    public ForumSelectedView y1;
    public final CustomMessageListener y2;
    public String z;
    public View z0;
    public SelectForumData z1;
    public CustomMessageListener z2;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(WriteActivity writeActivity, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ResponsedSelectLocation)) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    this.a.W.Q(false);
                    this.a.W.P(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    this.a.Y6(2, true, responsedSelectLocation.getName());
                    return;
                }
                this.a.W.Q(true);
                this.a.Y6(0, true, null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a0 implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.s7();
                this.a.B6();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a1 implements eh8.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public a1(WriteActivity writeActivity) {
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

        @Override // com.repackage.eh8.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.z = null;
                this.a.H6(false);
                this.a.S.A(new h05(2, 12, null));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(WriteActivity writeActivity, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.a.showToast((String) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b0 implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.J1.setVisibility(8);
                this.a.L1.cancelAnimation();
                if (this.a.d5().isFocused()) {
                    WriteActivity writeActivity = this.a;
                    writeActivity.ShowSoftKeyPad(writeActivity.j, this.a.d5());
                } else if (this.a.c5().isFocused()) {
                    WriteActivity writeActivity2 = this.a;
                    writeActivity2.ShowSoftKeyPad(writeActivity2.j, this.a.c5());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b1 implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public b1(WriteActivity writeActivity) {
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
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) && this.a.f2 != null && (this.a.f2.getItem(i) instanceof vn4)) {
                vn4 vn4Var = (vn4) this.a.f2.getItem(i);
                int i2 = vn4Var.b;
                if (i2 == 1) {
                    if (vn4Var.o == 1) {
                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{vn4Var.g});
                        return;
                    }
                    UrlManager urlManager = UrlManager.getInstance();
                    TbPageContext<WriteActivity> pageContext = this.a.getPageContext();
                    urlManager.dealOneLink(pageContext, new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + oi.getUrlEncode(vn4Var.g)});
                } else if (i2 == 2) {
                    if (!TextUtils.isEmpty(vn4Var.j)) {
                        if (vn4Var.j.startsWith("tiebaclient://")) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, vn4Var.j));
                            return;
                        }
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(vn4Var.j));
                        intent.addFlags(268468224);
                        if (UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                            this.a.startActivity(intent);
                        } else if (TextUtils.isEmpty(vn4Var.k)) {
                        } else {
                            UrlManager urlManager2 = UrlManager.getInstance();
                            TbPageContext<WriteActivity> pageContext2 = this.a.getPageContext();
                            urlManager2.dealOneLink(pageContext2, new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + oi.getUrlEncode(vn4Var.k)});
                        }
                    } else if (TextUtils.isEmpty(vn4Var.k)) {
                    } else {
                        UrlManager urlManager3 = UrlManager.getInstance();
                        TbPageContext<WriteActivity> pageContext3 = this.a.getPageContext();
                        urlManager3.dealOneLink(pageContext3, new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + oi.getUrlEncode(vn4Var.k)});
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(WriteActivity writeActivity, int i) {
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
            this.a.w4();
        }
    }

    /* loaded from: classes4.dex */
    public class c0 implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ht4.k().u("key_rich_mode_guide_has_show", true);
                WriteActivity writeActivity = this.a;
                writeActivity.HidenSoftKeyPad(writeActivity.j, this.a.d5());
                WriteActivity writeActivity2 = this.a;
                writeActivity2.HidenSoftKeyPad(writeActivity2.j, this.a.c5());
                this.a.L1.playAnimation();
                this.a.J1.setVisibility(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c1 implements TbFaceManager.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public c1(WriteActivity writeActivity) {
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

        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), ym.class);
                ym ymVar = runTask != null ? (ym) runTask.getData() : null;
                if (ymVar == null) {
                    return null;
                }
                BitmapDrawable bitmapDrawable = new BitmapDrawable(ymVar.p());
                int r = ymVar.r();
                if (str.startsWith(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX)) {
                    bitmapDrawable.setBounds(0, 0, r, ymVar.m());
                } else {
                    bitmapDrawable.setBounds(0, 0, r, r);
                }
                bitmapDrawable.setGravity(119);
                return new nt4(bitmapDrawable, 0);
            }
            return (ImageSpan) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(WriteActivity writeActivity, int i) {
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
                this.a.A4();
                this.a.setResult(100);
                this.a.finish();
            }
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
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.J1.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public d1(WriteActivity writeActivity) {
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.W1) {
                this.a.w2.callback(false, qj8.c, qj8.d, qj8.e, qj8.f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(WriteActivity writeActivity, int i) {
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
                this.a.g7((EvaluateRelevanceItemSelectedMessage) customResponsedMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e0 implements AssociatedItemContainer.b {
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

        @Override // com.baidu.tieba.write.view.AssociatedItemContainer.b
        public void a(ItemData itemData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, itemData) == null) {
                this.a.c.removeItemData(itemData);
                if (ListUtils.isEmpty(this.a.c.getItemDatas())) {
                    this.a.u4();
                    this.a.d2.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public e1(WriteActivity writeActivity) {
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
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.S.A(new h05(5, -1, null));
                int J4 = this.a.J4();
                if (J4 < 0 || J4 >= this.a.r.getText().length()) {
                    return;
                }
                this.a.r.setSelection(J4);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f0 implements AssociatedItemContainer.a {
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

        @Override // com.baidu.tieba.write.view.AssociatedItemContainer.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                if (this.a.u2.getVisibility() == 0) {
                    this.a.q4(true);
                } else {
                    this.a.q4(false);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public f1(WriteActivity writeActivity) {
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
                this.a.C0.notifyDataSetChanged();
                this.a.B0.invalidateViews();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements nq4.e {
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

        @Override // com.repackage.nq4.e
        public void onClick(nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                this.a.Y6(0, true, null);
                nq4Var.dismiss();
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
                if (writeActivity.c == null || !writeActivity.g1) {
                    return;
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_COMMODITY_ENTRANCE_SHOW).param("obj_locate", 1).param("fid", this.a.c.getForumId()).param("fname", this.a.c.getForumName()));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g1 extends BdAsyncTask<Void, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public g1(WriteActivity writeActivity) {
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
                FileHelper.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + this.a.U));
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class h implements nq4.e {
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

        @Override // com.repackage.nq4.e
        public void onClick(nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                if (ni.z()) {
                    this.a.Y6(1, true, null);
                    this.a.W.O();
                } else {
                    this.a.x2.a();
                }
                nq4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h0 implements WriteEvaluationHeaderView.b {
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

        @Override // com.baidu.tieba.write.view.WriteEvaluationHeaderView.b
        public void a(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048576, this, f) == null) {
                if (TextUtils.isEmpty(this.a.r.getText()) || this.a.r.getText().length() < 20 || this.a.r.getText().length() > 500 || f <= 0.0f) {
                    this.a.G.setEnabled(false);
                } else {
                    this.a.G.setEnabled(true);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h1 extends InsertGalleryAsyncTask.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public h1(WriteActivity writeActivity) {
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
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && new File(str).exists() && this.a.T != null) {
                this.a.T.clear();
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(str);
                imageFileInfo.isFromMoreForum = true;
                this.a.T.addChooseFile(imageFileInfo);
                this.a.T.setMaxImagesAllowed(1);
                this.a.i4(imageFileInfo);
                this.a.M6(true);
                this.a.P6();
                this.a.J6();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnFocusChangeListener {
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

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                if (view2 == this.a.k || view2 == this.a.F || view2 == this.a.G) {
                    if (z) {
                        this.a.E2 = true;
                        this.a.u4();
                        pi.M(this.a.getActivity(), this.a.k);
                        if (this.a.S != null) {
                            this.a.S.q();
                        }
                    } else if (view2 == this.a.k) {
                        this.a.m0.setVisibility(0);
                    }
                }
                if (view2 == this.a.r) {
                    if (z) {
                        this.a.E2 = false;
                        this.a.u4();
                        pi.M(this.a.getActivity(), this.a.r);
                        if (this.a.S != null) {
                            this.a.S.q();
                        }
                    }
                } else if (view2 instanceof SpanGroupEditText) {
                    Object tag = view2.getTag(R.id.obfuscated_res_0x7f090fbf);
                    if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                        this.a.E2 = false;
                        this.a.u4();
                        pi.M(this.a.getActivity(), view2);
                        if (this.a.S != null) {
                            this.a.S.q();
                        }
                    }
                }
                this.a.B7();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i0 implements WriteEvaluationHeaderView.c {
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

        @Override // com.baidu.tieba.write.view.WriteEvaluationHeaderView.c
        public void onClose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.G.setEnabled(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public i1(WriteActivity writeActivity) {
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.T0 == null) {
                return;
            }
            WriteActivity writeActivity = this.a;
            writeActivity.z4(writeActivity.T0.getAbsolutePath());
        }
    }

    /* loaded from: classes4.dex */
    public class j extends q55<GoodsEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity c;

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
            this.c = writeActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.j55
        /* renamed from: a */
        public boolean onEvent(GoodsEvent goodsEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, goodsEvent)) == null) {
                if (goodsEvent == null) {
                    return false;
                }
                this.c.z6(goodsEvent.getGoodsList());
                goodsEvent.setDispost(true);
                this.c.u4();
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class j0 extends ClickableSpan {
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

        @Override // android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                sg.i(this.a.k2, this.a);
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
    public class j1 implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public j1(WriteActivity writeActivity) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) && this.a.Y0) {
                pi.x(this.a.getPageContext().getPageActivity(), this.a.getCurrentFocus());
                this.a.Z0 = System.currentTimeMillis();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements gx8.d {
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

        @Override // com.repackage.gx8.d
        public void a(List<vn4> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                this.a.f7(list);
            }
        }

        @Override // com.repackage.gx8.d
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || this.a.r == null) {
                return;
            }
            this.a.r.f(i);
        }
    }

    /* loaded from: classes4.dex */
    public class k0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        /* loaded from: classes4.dex */
        public class a implements nq4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(k0 k0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {k0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.repackage.nq4.e
            public void onClick(nq4 nq4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                    ht4 k = ht4.k();
                    k.u(TbadkCoreApplication.getCurrentAccount() + "is_agree_protocol", true);
                    nq4Var.dismiss();
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements nq4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(k0 k0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {k0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.repackage.nq4.e
            public void onClick(nq4 nq4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                    ht4 k = ht4.k();
                    k.u(TbadkCoreApplication.getCurrentAccount() + "is_agree_protocol", false);
                    nq4Var.dismiss();
                }
            }
        }

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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.l2) {
                    this.a.l2 = false;
                    this.a.h2.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809e6, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
                } else {
                    this.a.l2 = true;
                    this.a.h2.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080803, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
                }
                ht4 k = ht4.k();
                if (k.h(TbadkCoreApplication.getCurrentAccount() + "is_agree_protocol", false) || !this.a.l2) {
                    return;
                }
                nq4 nq4Var = new nq4(this.a);
                nq4Var.setNegativeTextColor(R.color.CAM_X0105);
                nq4Var.setTitle("");
                nq4Var.setMessage(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0f1d));
                nq4Var.setContentViewSize(1);
                nq4Var.setPositiveButton("同意", new a(this));
                nq4Var.setNegativeButton(SapiWebView.HTTPS_SSL_DATE_INVALID_DIALOG_CANCEL, new b(this));
                nq4Var.create(this.a.getPageContext()).show();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        /* loaded from: classes4.dex */
        public class a extends ad5<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(k1 k1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {k1Var};
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
            @Override // com.repackage.ad5
            public String doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? UtilHelper.getClipBoardContent() : (String) invokeV.objValue;
            }
        }

        /* loaded from: classes4.dex */
        public class b implements gc5<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ k1 a;

            public b(k1 k1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {k1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = k1Var;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.gc5
            /* renamed from: a */
            public void onReturnDataInUI(String str) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && !oi.isEmpty(str) && UrlManager.getInstance().isUrlValid(str)) {
                    if (this.a.a.s1 == null) {
                        WriteActivity writeActivity = this.a.a;
                        writeActivity.s1 = new WriteTipBubbleController(writeActivity.getPageContext(), this.a.a.s2);
                    }
                    View s = this.a.a.S.a.s(31);
                    WriteTipBubbleController writeTipBubbleController = this.a.a.s1;
                    writeTipBubbleController.d(s, this.a.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0619) + "\n" + str, str, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL);
                }
            }
        }

        public k1(WriteActivity writeActivity) {
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.S == null || this.a.S.a == null) {
                return;
            }
            if (AsyncGetClipboardSwitch.isOn() && TbadkCoreApplication.getInst().isMIUIRom()) {
                ed5.b(new a(this), new b(this));
                return;
            }
            String clipBoardContent = UtilHelper.getClipBoardContent();
            if (oi.isEmpty(clipBoardContent) || !UrlManager.getInstance().isUrlValid(clipBoardContent)) {
                return;
            }
            if (this.a.s1 == null) {
                WriteActivity writeActivity = this.a;
                writeActivity.s1 = new WriteTipBubbleController(writeActivity.getPageContext(), this.a.s2);
            }
            View s = this.a.S.a.s(31);
            WriteTipBubbleController writeTipBubbleController = this.a.s1;
            writeTipBubbleController.d(s, this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0619) + "\n" + clipBoardContent, clipBoardContent, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL);
        }
    }

    /* loaded from: classes4.dex */
    public class l implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                WriteActivity writeActivity = this.a;
                writeActivity.showToast(writeActivity.R);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l0 implements EBusinessProtocolView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

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

        @Override // com.baidu.tieba.view.EBusinessProtocolView.f
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    if (this.a.l2) {
                        return;
                    }
                    this.a.l2 = true;
                    this.a.h2.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080803, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
                } else if (this.a.l2) {
                    this.a.l2 = false;
                    this.a.h2.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809e6, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nq4 a;
        public final /* synthetic */ WriteActivity b;

        public l1(WriteActivity writeActivity, nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity, nq4Var};
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
            this.a = nq4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            nq4 nq4Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (nq4Var = this.a) == null) {
                return;
            }
            nq4Var.dismiss();
            ht4.k().u("commodity_goods_show_first_dialog", true);
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_WRITE_GOODS_NEW_DIALOG_CLICK).param("obj_locate", 2);
            WriteData writeData = this.b.c;
            StatisticItem param2 = param.param("fid", writeData != null ? writeData.getForumId() : "");
            WriteData writeData2 = this.b.c;
            TiebaStatic.log(param2.param("fname", writeData2 != null ? writeData2.getForumName() : ""));
            String uk = TbadkCoreApplication.getCurrentAccountInfo().getUk();
            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + uk + "&max=" + this.b.h5()));
        }
    }

    /* loaded from: classes4.dex */
    public class m implements View.OnFocusChangeListener {
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

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) && z) {
                this.a.O0 = true;
                this.a.E2 = true;
                this.a.u4();
                if (this.a.S != null) {
                    this.a.S.q();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public m0(WriteActivity writeActivity) {
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
                this.a.o7();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m1 implements CustomMessageTask.CustomRunnable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public m1(WriteActivity writeActivity) {
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
                bdTopToast.h(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f14f2));
                bdTopToast.j((ViewGroup) this.a.z0);
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class n implements View.OnFocusChangeListener {
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

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) && z) {
                this.a.O0 = false;
                this.a.E2 = false;
                this.a.u4();
                if (this.a.S != null) {
                    this.a.S.q();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n0 implements TabMenuPopView.c {
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

        @Override // com.baidu.tieba.frs.TabMenuPopView.c
        public void a(View view2, ae6 ae6Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, view2, ae6Var) == null) || ae6Var == null) {
                return;
            }
            this.a.x0.setText(ae6Var.a);
            this.a.c.setCategoryTo(ae6Var.b);
            this.a.w0 = ae6Var.b;
            this.a.x0.c();
        }
    }

    /* loaded from: classes4.dex */
    public class n1 implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public n1(WriteActivity writeActivity) {
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

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_WRITE));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nq4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_WRITE));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o implements PhotoLiveLinearLayout.a {
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

        @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.z7();
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
                this.a.x0.e();
                WriteActivity writeActivity = this.a;
                writeActivity.HidenSoftKeyPad(writeActivity.j, this.a.d5());
                WriteActivity writeActivity2 = this.a;
                writeActivity2.HidenSoftKeyPad(writeActivity2.j, this.a.c5());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o1 implements WriteTipBubbleController.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public o1(WriteActivity writeActivity) {
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
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, view2, str) == null) || this.a.s1 == null) {
                return;
            }
            TiebaStatic.log("c13802");
            this.a.s1.c();
            UtilHelper.clearClipBoard();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddLinkActivityConfig(this.a.getActivity(), 25049, str, false, null)));
        }
    }

    /* loaded from: classes4.dex */
    public class p implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.S == null || this.a.S.a == null) {
                return;
            }
            if (this.a.t1 == null) {
                WriteActivity writeActivity = this.a;
                writeActivity.t1 = new ex8(writeActivity.getPageContext());
            }
            this.a.t1.b(this.a.S.a.s(2));
        }
    }

    /* loaded from: classes4.dex */
    public class p0 implements TimePickerDialog.OnTimeSetListener {
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

        @Override // android.app.TimePickerDialog.OnTimeSetListener
        public void onTimeSet(TimePicker timePicker, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, timePicker, i, i2) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p1 implements NewWriteModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        /* loaded from: classes4.dex */
        public class a implements nq4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(p1 p1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {p1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.repackage.nq4.e
            public void onClick(nq4 nq4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                    nq4Var.dismiss();
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements nq4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ p1 a;

            public b(p1 p1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {p1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = p1Var;
            }

            @Override // com.repackage.nq4.e
            public void onClick(nq4 nq4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                    nq4Var.dismiss();
                    this.a.a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.a.a.getActivity(), 0, 26, 1)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 1));
                }
            }
        }

        public p1(WriteActivity writeActivity) {
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

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.e
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, hx4 hx4Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, hx4Var, writeData, antiData}) == null) {
                this.a.u7();
                this.a.closeLoadingDialog();
                this.a.H2 = true;
                if (postWriteCallBackData != null) {
                    WriteActivity writeActivity = this.a;
                    if (writeActivity.c == null) {
                        return;
                    }
                    writeActivity.p1.m(null);
                    if (z) {
                        this.a.X6(z);
                        if (this.a.p4(writeData) || WriteActivityConfig.FROM_FORUM_SHARE.equals(this.a.S0)) {
                            this.a.n7(true, postWriteCallBackData);
                        }
                        tw8.e(this.a.c);
                        this.a.A4();
                        if ((this.a.c.getType() == 0 || this.a.c.getType() == 9 || this.a.c.getType() == 11) && !ListUtils.isEmpty(this.a.i1) && !StringUtils.isNull(this.a.l1)) {
                            TiebaStatic.log(new StatisticItem("c11731").param("obj_id", this.a.l1));
                        }
                        this.a.a7(postWriteCallBackData);
                        if (!oi.isEmpty(postWriteCallBackData.getVideoid()) && this.a.c.getVideoInfo() != null) {
                            if (!oi.isEmpty(this.a.c.getForumName())) {
                                postWriteCallBackData.mFrom = 2;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001374, postWriteCallBackData));
                        } else {
                            Intent intent = new Intent();
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                            intent.putExtras(bundle);
                            this.a.setResult(-1, intent);
                        }
                        this.a.finish();
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                        this.a.showToast(postWriteCallBackData.getErrorString());
                        this.a.p1.m(postWriteCallBackData.getSensitiveWords());
                        this.a.p1.n(postWriteCallBackData.getErrorString());
                        this.a.p1.h(this.a.k, this.a.r);
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                        if (oi.isEmpty(postWriteCallBackData.getErrorString())) {
                            DefaultNavigationBarCoverTip.s(this.a.getActivity(), this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0466), null).u();
                        } else {
                            DefaultNavigationBarCoverTip.s(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                        nq4 nq4Var = new nq4(this.a.getActivity());
                        if (oi.isEmpty(postWriteCallBackData.getErrorString())) {
                            nq4Var.setMessage(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0ced));
                        } else {
                            nq4Var.setMessage(postWriteCallBackData.getErrorString());
                        }
                        nq4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0366, new a(this));
                        nq4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0cef, new b(this));
                        nq4Var.create(this.a.getPageContext()).show();
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 1));
                    } else if ((hx4Var == null || writeData == null || hx4Var.c() == null || AntiHelper.h(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001 && !ho8.d(postWriteCallBackData.getErrorCode())) {
                        this.a.n7(false, postWriteCallBackData);
                    } else if (hx4Var != null && writeData != null && hx4Var.c() != null) {
                        if (writeData.isCanNoForum()) {
                            writeData.setForumName("");
                            writeData.setForumId("0");
                        }
                        writeData.setVcodeMD5(hx4Var.b());
                        writeData.setVcodeUrl(hx4Var.c());
                        writeData.setVcodeExtra(hx4Var.a());
                        if (sd5.b(hx4Var.d())) {
                            NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(this.a.getPageContext().getPageActivity(), 12006, writeData, false, hx4Var.d());
                            if (this.a.h) {
                                newVcodeActivityConfig.setHideFeedBackButton();
                            }
                            this.a.sendMessage(new CustomMessage(2002001, newVcodeActivityConfig));
                            return;
                        }
                        this.a.sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.a.getPageContext().getPageActivity(), writeData, 12006)));
                    } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    } else {
                        this.a.sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.a.getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q implements i05 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        /* loaded from: classes4.dex */
        public class a implements PermissionJudgePolicy.OnPermissionsGrantedListener {
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

            @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
            public void onPermissionsGranted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ht4.k().u("key_post_thread_has_request_location", true);
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

        @Override // com.repackage.i05
        public void C(h05 h05Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, h05Var) == null) || h05Var == null) {
                return;
            }
            int i = h05Var.a;
            if (i == 16) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 9));
                if (this.a.i6()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0d13);
                    return;
                }
                AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this.a.getPageContext().getPageActivity(), 12004, true);
                if (this.a.R0 && this.a.Q0) {
                    atListActivityConfig.setSelectedAtList(this.a.y.getAtDataInText());
                } else if (this.a.c5() instanceof SpanGroupEditText) {
                    atListActivityConfig.setSelectedAtList(((SpanGroupEditText) this.a.c5()).getAtDataInText());
                }
                this.a.sendMessage(new CustomMessage(2002001, atListActivityConfig));
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
                statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
            } else if (i == 14 || i == 48) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 1));
                this.a.x6(h05Var);
            } else if (i == 60) {
                this.a.y6(h05Var);
            } else if (i == 24) {
                Object obj = h05Var.c;
                if (obj == null || !(obj instanceof nw4)) {
                    return;
                }
                nw4 nw4Var = (nw4) obj;
                if (EmotionGroupType.isSendAsPic(nw4Var.getType())) {
                    if (this.a.mCurrentPermissionJudgePolicy == null) {
                        this.a.mCurrentPermissionJudgePolicy = new PermissionJudgePolicy();
                    }
                    this.a.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
                    this.a.mCurrentPermissionJudgePolicy.appendRequestPermission(this.a, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.mCurrentPermissionJudgePolicy.startRequestPermission(this.a)) {
                        return;
                    }
                    if (this.a.T.size() >= this.a.T.getMaxImagesAllowed()) {
                        this.a.showToast(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0aa6), Integer.valueOf(this.a.T.getMaxImagesAllowed())));
                        return;
                    }
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    imageFileInfo.setImageType(1);
                    imageFileInfo.setFilePath(nw4Var.d());
                    imageFileInfo.width = nw4Var.h();
                    imageFileInfo.height = nw4Var.b();
                    this.a.T.addChooseFile(imageFileInfo);
                    this.a.T.updateQuality();
                    this.a.i4(imageFileInfo);
                    this.a.M6(true);
                    this.a.P6();
                    this.a.J6();
                    this.a.N6();
                } else if (this.a.i6()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0d13);
                } else {
                    this.a.e6(nw4Var);
                }
            } else if (i == 3) {
                this.a.G4();
            } else if (i == 10) {
                Object obj2 = h05Var.c;
                if (obj2 instanceof VoiceData.VoiceModel) {
                    this.a.m4((VoiceData.VoiceModel) obj2);
                    this.a.P6();
                }
            } else if (i == 11) {
                this.a.I4();
                this.a.P6();
            } else if (i == 12 || i == 13 || i == 46 || i == 49) {
                this.a.J6();
                this.a.P6();
                this.a.N6();
            } else if (i == 15 || i == 47) {
                Object obj3 = h05Var.c;
                if (obj3 == null || !(obj3 instanceof Integer)) {
                    return;
                }
                this.a.n6(((Integer) obj3).intValue());
            } else if (i == 18) {
                boolean h = ht4.k().h("key_post_thread_has_request_location", false);
                if (h05Var.c == null || this.a.Z != null) {
                    int i2 = this.a.Y;
                    if (i2 != 0) {
                        if (i2 != 2) {
                            return;
                        }
                        this.a.l5();
                        return;
                    }
                    Activity pageActivity = this.a.getPageContext().getPageActivity();
                    if (PermissionUtil.checkLocationForTieba(pageActivity) && h) {
                        this.a.u6();
                    } else {
                        PermissionUtil.requestLocation(pageActivity, 0, new a(this));
                    }
                } else if (h || this.a.b1) {
                    this.a.T6();
                }
            } else if (i == 20) {
                if (this.a.W != null) {
                    this.a.W.Q(true);
                }
            } else {
                WriteVoteData writeVoteData = null;
                if (i == 25) {
                    Object obj4 = h05Var.c;
                    if (obj4 == null || !(obj4 instanceof String)) {
                        this.a.z = null;
                    } else {
                        this.a.z = (String) obj4;
                    }
                    this.a.H6(false);
                } else if (i == 29) {
                    this.a.S.A(new h05(2, 19, null));
                    this.a.S.A(new h05(1, 2, null));
                    this.a.N6();
                    if (this.a.r != null) {
                        this.a.r.requestFocus();
                    }
                    this.a.S.q();
                    this.a.S.A(new h05(5, -1, null));
                    WriteActivity writeActivity = this.a;
                    writeActivity.ShowSoftKeyPad(writeActivity.j, this.a.r);
                } else if (i == 43) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 4));
                    ht4.k().u("hot_topic_has_click", true);
                    this.a.S.A(new h05(2, 26, null));
                    this.a.b = true;
                    this.a.A6(true);
                    if (!this.a.d5().isFocused() || this.a.o.getVisibility() != 0) {
                        this.a.a = "from_content";
                    } else {
                        this.a.a = "from_title";
                    }
                } else if (i == 56) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 8));
                    if (this.a.o.getVisibility() == 0) {
                        if (this.a.o.hasFocus()) {
                            this.a.r.requestFocus();
                            this.a.r.setSelection(this.a.r.getText().toString().length());
                        }
                        this.a.o.setVisibility(8);
                        if (this.a.u2 != null) {
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.a.u2.getLayoutParams();
                            layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X012);
                            this.a.u2.setLayoutParams(layoutParams);
                        }
                        this.a.p.setVisibility(8);
                        this.a.S.m(30).setName(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f051b));
                    } else {
                        this.a.o.setVisibility(0);
                        if (this.a.u2 != null) {
                            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.a.u2.getLayoutParams();
                            layoutParams2.topMargin = 0;
                            this.a.u2.setLayoutParams(layoutParams2);
                        }
                        this.a.p.setVisibility(0);
                        this.a.o.requestFocus();
                        if (this.a.S.m(30) != null) {
                            this.a.S.m(30).setName(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0521));
                        }
                    }
                    this.a.N6();
                } else if (i == 55) {
                    Object obj5 = h05Var.c;
                    if (obj5 == null || !(obj5 instanceof Boolean)) {
                        return;
                    }
                    this.a.f1 = ((Boolean) obj5).booleanValue();
                } else if (i == 58) {
                    Object obj6 = h05Var.c;
                    if (obj6 == null || !(obj6 instanceof Boolean)) {
                        return;
                    }
                    this.a.h1 = ((Boolean) obj6).booleanValue();
                } else if (i == 22) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 10));
                    if (this.a.H1 != null && this.a.H1.c() != null) {
                        writeVoteData = this.a.H1.c();
                    }
                    this.a.p6(writeVoteData);
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_WRITE_VOTE_VIEW_SHOW).param("obj_source", 2));
                    this.a.s5();
                } else if (i == 21) {
                    if (this.a.s1 != null) {
                        this.a.s1.c();
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 5));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddLinkActivityConfig(this.a.getActivity(), 25049, "", true, null)));
                } else if (i == 59) {
                    this.a.s6();
                } else if (i == 61) {
                    this.a.t6();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q0 implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log(new StatisticItem("c13013").param("fid", this.a.c.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                this.a.m0.setVisibility(0);
                this.a.p0.setSelected(true);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.a.o0, R.drawable.obfuscated_res_0x7f08090b, R.color.CAM_X0105, null);
                sg.l(this.a.n0, view2, 0, pi.d(this.a.getPageContext().getPageActivity(), 1.0f));
                this.a.S.q();
                WriteActivity writeActivity = this.a;
                writeActivity.HidenSoftKeyPad(writeActivity.j, this.a.k);
                WriteActivity writeActivity2 = this.a;
                writeActivity2.HidenSoftKeyPad(writeActivity2.j, this.a.r);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q1 implements LocationModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public q1(WriteActivity writeActivity) {
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

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0c70);
                this.a.Y6(0, true, null);
            }
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void b(LocationData locationData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, locationData) == null) {
                if (locationData != null && !StringUtils.isNull(locationData.getFormatted_address())) {
                    this.a.Y6(2, true, locationData.getFormatted_address());
                } else {
                    onFail(null);
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                WriteActivity writeActivity = this.a;
                if (StringUtils.isNull(str)) {
                    str = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0a53);
                }
                writeActivity.showToast(str);
                this.a.Y6(0, true, null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteVoteData a;
        public final /* synthetic */ WriteActivity b;

        public r(WriteActivity writeActivity, WriteVoteData writeVoteData) {
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
                this.b.p6(this.a);
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_WRITE_VOTE_VIEW_SHOW).param("obj_source", 3));
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.y1 == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof SelectForumData) || (selectForumData = (SelectForumData) customResponsedMessage.getData()) == null || StringUtils.isNull(selectForumData.forumId) || StringUtils.isNull(selectForumData.forumName)) {
                return;
            }
            this.a.S5(selectForumData);
        }
    }

    /* loaded from: classes4.dex */
    public class r1 extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public r1(WriteActivity writeActivity) {
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

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                pi.x(this.a.getActivity(), this.a.getCurrentFocus());
                return super.onFling(motionEvent, motionEvent2, f, f2);
            }
            return invokeCommon.booleanValue;
        }

        public /* synthetic */ r1(WriteActivity writeActivity, k kVar) {
            this(writeActivity);
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null) {
                return;
            }
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f091bd0) {
                this.a.A4();
                this.a.setResult(100);
                this.a.finish();
            } else if (id == R.id.obfuscated_res_0x7f091bd1) {
                this.a.E6();
                this.a.setResult(100);
                this.a.finish();
            }
            this.a.F1.dismiss();
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
                TiebaStatic.log(new StatisticItem("c13013").param("fid", this.a.c.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                this.a.m0.setSelected(true);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.a.o0, R.drawable.obfuscated_res_0x7f08090b, R.color.CAM_X0105, null);
                sg.l(this.a.n0, view2, 0, pi.d(this.a.getPageContext().getPageActivity(), 1.0f));
                this.a.S.q();
                WriteActivity writeActivity = this.a;
                writeActivity.HidenSoftKeyPad(writeActivity.j, this.a.d5());
                WriteActivity writeActivity2 = this.a;
                writeActivity2.HidenSoftKeyPad(writeActivity2.j, this.a.c5());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class t implements TextWatcher {
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

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.a.N6();
                this.a.C7();
                EditText d5 = this.a.d5();
                if (editable == null || d5 == null || d5.getText() == null) {
                    return;
                }
                if (this.a.b2 == null || !this.a.b2.equals(editable.toString())) {
                    if (this.a.p1 != null) {
                        this.a.b2 = d5.getText().toString();
                        this.a.p1.i(d5, true);
                        return;
                    }
                    return;
                }
                d5.setSelection(d5.getSelectionEnd());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
                this.a.c2 = charSequence != null ? charSequence.toString() : "";
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
                if ((charSequence != null ? charSequence.toString().length() : 0) > (this.a.c2 != null ? this.a.c2.length() : 0)) {
                    this.a.n5(charSequence, i, i3, "from_title");
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class t0 extends c9 {
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

        @Override // com.repackage.c9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.a.hideProgressBar();
                if (obj == null || !(obj instanceof FeedBackModel)) {
                    this.a.t.setVisibility(8);
                    this.a.u.setVisibility(8);
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c37);
                    return;
                }
                FeedBackModel feedBackModel = (FeedBackModel) obj;
                if (feedBackModel.D() != 0) {
                    this.a.t.setVisibility(8);
                    this.a.u.setVisibility(8);
                    return;
                }
                this.a.t.c(feedBackModel.E(), this.a.getPageContext());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class u implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public final /* synthetic */ WriteActivity c;

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
            this.c = writeActivity;
            this.a = "";
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.c.N6();
                EditText c5 = this.c.c5();
                if (editable == null || c5 == null || c5.getText() == null) {
                    return;
                }
                String str = this.a;
                if (str == null || !str.equals(editable.toString())) {
                    if (this.c.p1 != null) {
                        this.a = c5.getText().toString();
                        this.c.p1.i(c5, false);
                    }
                    if (this.c.S1) {
                        this.c.j4(editable);
                        return;
                    }
                    return;
                }
                c5.setSelection(c5.getSelectionEnd());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
                this.b = charSequence != null ? charSequence.toString() : "";
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
                String str = this.b;
                if ((charSequence != null ? charSequence.toString().length() : 0) > (str != null ? str.length() : 0)) {
                    this.c.n5(charSequence, i, i3, "from_content");
                    this.c.m5(charSequence, i, i3);
                }
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
                if (this.a.r != null && this.a.r.getText() != null && this.a.r.getText().toString() != null) {
                    if (this.a.r.getText().toString().length() <= 1000) {
                        if (this.a.r.getText().toString().contains("ܷ") || this.a.r.getText().toString().contains("ܶ")) {
                            WriteActivity writeActivity = this.a;
                            writeActivity.showToast(writeActivity.getResources().getString(R.string.obfuscated_res_0x7f0f0ebf));
                            return;
                        }
                    } else {
                        WriteActivity writeActivity2 = this.a;
                        writeActivity2.showToast(writeActivity2.getResources().getString(R.string.obfuscated_res_0x7f0f0ec0));
                        return;
                    }
                }
                if (this.a.S1 || (!TextUtils.isEmpty(this.a.k.getText().toString()) && this.a.k.getText().toString().trim().length() >= 5)) {
                    if ((this.a.R0 || this.a.y1 == null || this.a.z1 != null) && (!this.a.R0 || this.a.z1 != null || !TextUtils.isEmpty(this.a.c.getForumName()))) {
                        if (this.a.v4()) {
                            if (!this.a.m2 || this.a.l2) {
                                if (this.a.x4()) {
                                    int y4 = this.a.y4();
                                    if (y4 == 1) {
                                        this.a.showToast(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1446));
                                        return;
                                    } else if (y4 == 2) {
                                        this.a.showToast(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1447));
                                        return;
                                    }
                                }
                                if (!ni.z()) {
                                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c37);
                                }
                                if (hd5.b()) {
                                    return;
                                }
                                if (this.a.p1.b(this.a.k, this.a.r)) {
                                    WriteActivity writeActivity3 = this.a;
                                    writeActivity3.showToast(writeActivity3.p1.e());
                                    return;
                                }
                                WriteActivity writeActivity4 = this.a;
                                writeActivity4.HidenSoftKeyPad(writeActivity4.j, this.a.d5());
                                WriteActivity writeActivity5 = this.a;
                                writeActivity5.HidenSoftKeyPad(writeActivity5.j, this.a.c5());
                                this.a.S.q();
                                if (this.a.c.getType() != 7) {
                                    if (this.a.e) {
                                        this.a.C6();
                                        BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                                    } else {
                                        StatisticItem statisticItem = new StatisticItem("c12102");
                                        statisticItem.param("obj_type", StringUtils.isNull(this.a.c.getForumName()) ? 1 : 2);
                                        TiebaStatic.log(statisticItem);
                                        this.a.D6();
                                    }
                                } else {
                                    TiebaStatic.log("c12015");
                                    this.a.C6();
                                }
                                MercatorModel.d().f();
                                TiebaStatic.log(new StatisticItem("c12262").param("obj_locate", this.a.d1));
                                return;
                            }
                            WriteActivity writeActivity6 = this.a;
                            writeActivity6.showToast(writeActivity6.getResources().getString(R.string.obfuscated_res_0x7f0f0f24));
                            return;
                        }
                        this.a.showToast(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1441));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectForumConfig(this.a)));
                    return;
                }
                BdTopToast bdTopToast = new BdTopToast(this.a);
                bdTopToast.i(false);
                bdTopToast.h(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1436));
                bdTopToast.j((ViewGroup) this.a.z0);
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
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.a.z)) {
                    this.a.z = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    this.a.H6(true);
                } else if (TextUtils.isEmpty(str) || str.equals(this.a.z)) {
                } else {
                    this.a.z = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(this.a.z);
                    this.a.H6(true);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class v0 implements tw8.c {
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

        @Override // com.repackage.tw8.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                pi.O(TbadkCoreApplication.getInst(), String.format(this.a.getString(R.string.obfuscated_res_0x7f0f15d8), 31));
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.R0) {
                this.a.t4();
                this.a.w7();
                this.a.u4();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class w0 implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public EditText b;
        public TextView c;
        public final /* synthetic */ WriteActivity d;

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
            this.d = writeActivity;
            this.b = null;
            this.c = null;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.d.N6();
                if (this.d.N0) {
                    int selectionStart = this.b.getSelectionStart();
                    this.a = selectionStart;
                    this.b.setSelection(selectionStart);
                    this.d.c7(this.c, this.b);
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
                if (!this.d.N0 || !this.d.O0) {
                    if (this.d.N0) {
                        if (this.b == this.d.E0 && this.c == this.d.K0) {
                            return;
                        }
                        this.b = this.d.E0;
                        this.c = this.d.K0;
                    }
                } else if (this.b == this.d.I0 && this.c == this.d.J0) {
                } else {
                    this.b = this.d.I0;
                    this.c = this.d.J0;
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
    public class x implements View.OnTouchListener {
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

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() == 2) {
                    if (this.a.r != null) {
                        pi.x(this.a.getPageContext().getContext(), this.a.r);
                    }
                    if (this.a.S != null) {
                        this.a.S.q();
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class x0 implements ru4.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public x0(WriteActivity writeActivity) {
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

        @Override // com.repackage.ru4.a
        public void a(int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                this.a.L6();
                this.a.u4();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class y implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                view2.requestFocus();
                this.a.S.A(new h05(5, -1, null));
                this.a.r.requestFocus();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class y0 implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public y0(WriteActivity writeActivity) {
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
                    this.a.S.A(new h05(5, -1, null));
                    this.a.r.requestFocus();
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class z implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.I4();
                this.a.P6();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class z0 extends ig<ym> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ WriteActivity b;

        public z0(WriteActivity writeActivity, boolean z) {
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
                super.onLoaded((z0) ymVar, str, i);
                if (ymVar == null || ymVar.p() == null || ymVar.o() == null) {
                    return;
                }
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), ymVar.p(), ymVar.p().getNinePatchChunk(), ymVar.o(), null);
                if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
                    ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                }
                if (this.b.N0) {
                    this.b.E0.setBackgroundDrawable(ninePatchDrawable);
                } else {
                    this.b.x.setBackgroundDrawable(ninePatchDrawable);
                }
                if (this.a) {
                    eh8.c(this.b.getPageContext(), this.b.c5(), true, this.b.M2);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001353, Boolean.TRUE));
            }
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
        this.a = "";
        this.b = false;
        this.c = null;
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = false;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.w = new ArrayList<>();
        this.z = null;
        this.A = new KeyEvent(0, 67);
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = null;
        this.K = null;
        this.L = new Handler();
        this.M = false;
        this.N = null;
        this.O = null;
        this.Q = true;
        this.R = null;
        this.T = new WriteImagesInfo();
        this.Y = 0;
        this.u0 = -1;
        this.w0 = -1;
        this.y0 = new WriteImagesInfo();
        this.z0 = null;
        this.B0 = null;
        this.C0 = null;
        this.D0 = null;
        this.E0 = null;
        this.F0 = null;
        this.G0 = null;
        this.H0 = null;
        this.I0 = null;
        this.J0 = null;
        this.K0 = null;
        this.L0 = null;
        this.M0 = null;
        this.N0 = false;
        this.O0 = false;
        this.P0 = null;
        this.S0 = AlbumActivityConfig.FROM_WRITE;
        this.T0 = null;
        this.U0 = null;
        this.V0 = null;
        this.W0 = null;
        this.X0 = null;
        this.Y0 = false;
        this.Z0 = -1000L;
        this.a1 = false;
        this.d1 = "2";
        this.e1 = 0;
        this.g1 = false;
        this.l1 = "";
        new SpannableStringBuilder();
        this.n1 = false;
        this.o1 = false;
        this.p1 = new fx8();
        this.V1 = true;
        this.W1 = false;
        this.X1 = null;
        this.a2 = false;
        this.b2 = "";
        this.e2 = new k(this);
        this.l2 = false;
        this.m2 = false;
        this.n2 = new v(this, CmdConfigHttp.REQUEST_BUBBLELIST_CMD);
        this.o2 = new g0(this, 2921494);
        this.p2 = new r0(this, 2921505);
        this.q2 = new c1(this);
        this.r2 = new n1(this);
        this.s2 = new o1(this);
        this.w2 = new p1(this);
        this.x2 = new q1(this);
        this.y2 = new a(this, 2001226);
        this.z2 = new b(this, 2016554);
        this.A2 = new c(this, 2001011);
        this.B2 = new d(this, 2921622);
        this.C2 = new e(this, 2921516);
        this.D2 = new f(this);
        this.E2 = true;
        this.F2 = new i(this);
        this.G2 = new j(this);
        this.H2 = false;
        this.I2 = new t(this);
        this.J2 = new u(this);
        this.K2 = 0;
        this.M2 = new a1(this);
        this.N2 = new d1(this);
    }

    public static Bitmap b5(String str, float f2) {
        InterceptResult invokeLF;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65622, null, str, f2)) == null) {
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

    public final void A4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.c.getType() != 0 && this.c.getType() != 9 && this.c.getType() != 11) {
                if (this.c.getType() == 1) {
                    wg8.w(this.c.getThreadId(), null);
                }
            } else if (this.V1) {
                if (this.b1) {
                    wg8.t(null);
                } else if (this.c.isEvaluate()) {
                    wg8.q(this.c.getItem_id(), null);
                } else if (TextUtils.isEmpty(this.c.getTopicId())) {
                    wg8.s(this.c.getForumId(), this.c, true);
                } else {
                    wg8.y(this.c.getTopicId(), null);
                }
            }
            this.H2 = true;
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void A5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int l2 = ht4.k().l("write_associate_item_hint_tip_key", 0);
            EditorTools editorTools = new EditorTools(getActivity());
            this.S = editorTools;
            editorTools.setBarMaxLauCount(5);
            this.S.setMoreButtonAtEnd(true);
            this.S.setBarBackgroundColorId(R.color.CAM_X0201);
            this.S.setBarLauncherType(1);
            this.S.C(true);
            this.S.D(false);
            this.S.setShouldShowMorePopTip(!this.b1);
            int type = this.c.getType();
            if (type != 4 && type != 5) {
                y5();
            } else {
                I5();
            }
            this.S.f();
            LinearLayout linearLayout = this.n;
            if (linearLayout != null) {
                linearLayout.addView(this.S);
            }
            B5();
            this.S.j();
            o05 m2 = this.S.m(6);
            if (m2 != null && !TextUtils.isEmpty(this.R)) {
                ((View) m2).setOnClickListener(new l(this));
            }
            if (!this.N0) {
                this.S.A(new h05(34, 5, 1));
            }
            this.S.q();
            if (!ht4.k().h("hot_topic_has_click", false)) {
                this.S.A(new h05(2, 26, " "));
            }
            if (ht4.k().l("commodity_tip_show_controller", 0) != 0 || !this.g1) {
                j7();
                w4();
            } else if (l2 > 0) {
                i7();
            } else {
                ht4.k().w("commodity_tip_show_controller", ht4.k().l("commodity_tip_show_controller", 0) + 1);
            }
        }
    }

    public final void A6(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z2) == null) || fc5.b(getPageContext())) {
            return;
        }
        HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD);
        WriteData writeData = this.c;
        if (writeData != null) {
            hotSelectActivityConfig.setForumExtra(ng.g(writeData.getForumId(), 0L), this.c.getFirstDir(), this.c.getSecondDir());
        }
        sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
    }

    public final void A7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public final void B4(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, intent) == null) || this.T == null) {
            return;
        }
        R4(intent);
        int size = this.T.size() - 1;
        if (size <= -1 || this.T.getChosedFiles() == null || this.T.size() < 1) {
            return;
        }
        sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.T, size)));
    }

    public final void B5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            q qVar = new q(this);
            this.S.setActionListener(16, qVar);
            this.S.setActionListener(14, qVar);
            this.S.setActionListener(60, qVar);
            this.S.setActionListener(24, qVar);
            this.S.setActionListener(3, qVar);
            this.S.setActionListener(10, qVar);
            this.S.setActionListener(11, qVar);
            this.S.setActionListener(12, qVar);
            this.S.setActionListener(13, qVar);
            this.S.setActionListener(15, qVar);
            this.S.setActionListener(18, qVar);
            this.S.setActionListener(20, qVar);
            this.S.setActionListener(25, qVar);
            this.S.setActionListener(27, qVar);
            this.S.setActionListener(29, qVar);
            this.S.setActionListener(43, qVar);
            this.S.setActionListener(56, qVar);
            this.S.setActionListener(48, qVar);
            this.S.setActionListener(46, qVar);
            this.S.setActionListener(49, qVar);
            this.S.setActionListener(47, qVar);
            this.S.setActionListener(55, qVar);
            this.S.setActionListener(58, qVar);
            this.S.setActionListener(22, qVar);
            this.S.setActionListener(21, qVar);
            this.S.setActionListener(59, qVar);
            this.S.setActionListener(61, qVar);
        }
    }

    public final void B6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            TextView textView = this.G;
            if (textView != null && ((textView.isEnabled() || this.S1 || !ListUtils.isEmpty(this.c.getItemDatas())) && ((!this.S1 || !TextUtils.isEmpty(this.r.getText()) || (this.T.getChosedFiles() != null && this.T.size() != 0)) && this.V1))) {
                if (this.G1 == null) {
                    this.G1 = new SaveDraftDialogView(this);
                    this.G1.setOnClickListener(new s(this));
                }
                if (this.F1 == null) {
                    wq4 wq4Var = new wq4(getPageContext());
                    this.F1 = wq4Var;
                    wq4Var.setContentView(this.G1);
                }
                this.G1.setText(getString(R.string.obfuscated_res_0x7f0f15dc), null, getString(R.string.obfuscated_res_0x7f0f1097));
                this.F1.m();
                return;
            }
            A4();
            setResult(100);
            finish();
        }
    }

    public final void B7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.k.hasFocus()) {
                this.k.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            } else {
                this.k.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            }
            if (this.r.hasFocus()) {
                this.r.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            } else {
                this.r.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            }
        }
    }

    public final void C4(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, intent) == null) {
            if (this.N0) {
                P4(intent);
                y7();
            } else if (this.Q0) {
                Q4(intent);
            } else {
                O4(intent);
            }
            N6();
        }
    }

    public final void C5() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.S1) {
            return;
        }
        ForumTabSelectedView forumTabSelectedView = (ForumTabSelectedView) findViewById(R.id.obfuscated_res_0x7f090bb1);
        this.C1 = forumTabSelectedView;
        forumTabSelectedView.setBgColor(R.color.CAM_X0205);
        this.D1 = findViewById(R.id.obfuscated_res_0x7f090bad);
        this.C1.setData(this.E1);
        if (this.C1.getVisibility() == 0) {
            this.D1.setVisibility(0);
        }
        this.C1.setActivity(this);
    }

    public final void C6() {
        HotTopicBussinessData hotTopicBussinessData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            s7();
            this.c.setContent(U4());
            F6(j5());
            if (this.e || this.g) {
                String string = getResources().getString(R.string.obfuscated_res_0x7f0f027b);
                if (TextUtils.isEmpty(this.c.getTitle()) || !this.c.getTitle().startsWith(string)) {
                    F6(string + this.c.getTitle());
                }
                String str = getResources().getString(R.string.obfuscated_res_0x7f0f029e) + getResources().getString(R.string.obfuscated_res_0x7f0f13fb);
                if (TextUtils.isEmpty(this.c.getContent()) || !this.c.getContent().startsWith(str)) {
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
                    sb.append(this.c.getContent());
                    this.c.setContent(sb.toString());
                }
            }
            if (this.f) {
                this.c.setZhongcePrefix(String.format(getResources().getString(R.string.obfuscated_res_0x7f0f085f), Build.MODEL, TbadkCoreApplication.getInst().getVersionName(), ni.K(), Build.VERSION.RELEASE));
            }
            int i2 = this.u0;
            if (i2 >= 0) {
                this.c.setCategoryFrom(i2);
            }
            int i3 = this.w0;
            if (i3 >= 0) {
                this.c.setCategoryTo(i3);
            }
            this.c.setWriteImagesInfo(this.T);
            this.y.setWriteImagesInfo(this.T);
            ux8 ux8Var = this.H1;
            if (ux8Var != null) {
                this.c.setWriteVoteData(ux8Var.c());
            }
            WriteImagesInfo writeImagesInfo = this.T;
            if (writeImagesInfo != null && writeImagesInfo.size() > 0) {
                Iterator<ImageFileInfo> it = this.T.getChosedFiles().iterator();
                int i4 = 0;
                while (it.hasNext()) {
                    ImageFileInfo next = it.next();
                    if (next != null && next.isFromCamera()) {
                        i4++;
                    }
                }
                this.c.setTakePhotoNum(i4);
            }
            WriteData writeData = this.c;
            LocationModel locationModel = this.W;
            writeData.setHasLocationData(locationModel != null && locationModel.C());
            WriteImagesInfo writeImagesInfo2 = this.T;
            if (writeImagesInfo2 != null) {
                this.V.A(writeImagesInfo2.size() > 0);
            }
            if (!ListUtils.isEmpty(this.i1) && (hotTopicBussinessData = this.j1) != null && hotTopicBussinessData.mIsGlobalBlock == 0) {
                this.c.setForumId(String.valueOf(hotTopicBussinessData.mForumId));
                this.c.setForumName(this.j1.mForumName);
            }
            WriteEvaluationHeaderView writeEvaluationHeaderView = this.A1;
            if (writeEvaluationHeaderView != null && writeEvaluationHeaderView.getEvaluateItemInfo() != null) {
                this.c.setItem_id(this.A1.getEvaluateItemInfo().getItemID());
                this.c.setComment_head(T4());
            }
            l4();
            this.V.H(this.c);
            WriteData writeData2 = this.c;
            writeData2.setContent(writeData2.getContent().replaceAll("\u0000\n", ""));
            WriteData writeData3 = this.c;
            writeData3.setContent(writeData3.getContent().replaceAll("\u0000", ""));
            this.c.setVcode(null);
            this.c.setVoiceModel(this.d);
            VoiceData.VoiceModel voiceModel = this.d;
            if (voiceModel != null) {
                if (voiceModel.getId() != null) {
                    this.V.o().setVoice(this.d.getId());
                    this.V.o().setVoiceDuringTime(this.d.duration);
                } else {
                    this.V.o().setVoice(null);
                    this.V.o().setVoiceDuringTime(-1);
                }
            } else {
                this.V.o().setVoice(null);
                this.V.o().setVoiceDuringTime(-1);
            }
            this.c.setRichTextEditorMode(this.Q0);
            if (this.Q0) {
                this.c.setServerRichContent(this.y.getPostServerContentData());
            }
            if (!this.V.e()) {
                showToast(R.string.obfuscated_res_0x7f0f15d3);
            } else if (!ni.z()) {
                showToast(R.string.obfuscated_res_0x7f0f0c37);
            } else {
                q7();
            }
        }
    }

    public final void C7() {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (editText = this.k) == null || editText.getText() == null || this.k.getText().toString() == null || this.k.getPaint() == null) {
            return;
        }
        if (this.k.getText().toString().length() == 0) {
            this.k.getPaint().setFakeBoldText(true);
        } else if (this.k.getText().toString().length() > 0) {
            this.k.getPaint().setFakeBoldText(true);
        }
    }

    public final void D4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || TbadkCoreApplication.getCurrentAccountObj() == null) {
            return;
        }
        sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) com.kuaishou.weapon.un.w0.I5, 12010, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
    }

    public final void D5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            View findViewById = this.z0.findViewById(R.id.obfuscated_res_0x7f09182c);
            this.F0 = findViewById;
            this.H0 = findViewById.findViewById(R.id.obfuscated_res_0x7f09127a);
            this.E0 = (EditText) this.F0.findViewById(R.id.obfuscated_res_0x7f091277);
            this.B0 = (GridView) this.F0.findViewById(R.id.obfuscated_res_0x7f091826);
            this.I0 = (EditText) this.F0.findViewById(R.id.obfuscated_res_0x7f091279);
            this.J0 = (TextView) this.F0.findViewById(R.id.obfuscated_res_0x7f09201b);
            this.K0 = (TextView) this.F0.findViewById(R.id.obfuscated_res_0x7f0906ac);
            this.G0 = this.F0.findViewById(R.id.obfuscated_res_0x7f091272);
            this.J0.setText(String.valueOf(20));
            this.K0.setText(String.valueOf(233));
            this.F0.setVisibility(0);
            this.J0.setVisibility(0);
            this.K0.setVisibility(0);
            this.I0.setHint(R.string.obfuscated_res_0x7f0f1430);
            this.I0.setOnFocusChangeListener(new m(this));
            if (this.c.getType() == 4) {
                this.E0.setHint(R.string.obfuscated_res_0x7f0f0a26);
            } else if (this.c.getType() == 5) {
                this.E0.setHint(R.string.obfuscated_res_0x7f0f0a27);
            }
            this.E0.setOnFocusChangeListener(new n(this));
            this.E0.requestFocus();
            this.E0.addTextChangedListener(i5());
            this.I0.requestFocus();
            this.I0.addTextChangedListener(i5());
            this.I0.setOnClickListener(this.D2);
            this.E0.setOnClickListener(this.D2);
            zw8 zw8Var = new zw8(this, this.T, this.B0);
            this.C0 = zw8Var;
            zw8Var.n(6);
            this.B0.setAdapter((ListAdapter) this.C0);
            View findViewById2 = this.F0.findViewById(R.id.obfuscated_res_0x7f091278);
            findViewById2.bringToFront();
            ((PhotoLiveLinearLayout) findViewById2).setOnChangeLayoutListener(new o(this));
            G6();
        }
    }

    public final void D6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if ("1".equals(this.d1)) {
                this.c.setCanNoForum(true);
                this.c.setTransmitForumData("[]");
            } else if ("2".equals(this.d1)) {
                this.c.setCanNoForum(false);
            }
            U6();
            this.c.setPrivacy(this.f1);
            V6();
            this.c.setToDynamic(this.h1);
            this.c.setCallFrom(this.d1);
            if (this.c.getVideoInfo() != null) {
                TiebaStatic.log("c10063");
            }
            C6();
        }
    }

    public final void E4(Intent intent) {
        String stringExtra;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, intent) == null) || intent == null || (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) == null) {
            return;
        }
        this.y0.parseJson(stringExtra);
        this.y0.updateQuality();
        if (this.y0.getChosedFiles() != null && this.y0.getChosedFiles().size() > 0) {
            sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) TaskResponseData.ERROR_NO_TASK_OFFLINE_03, 12009, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.y0.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
        }
        this.y0.clear();
    }

    public final void E5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.E.postDelayed(this.N2, 500L);
        }
    }

    public final void E6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            WriteData writeData = this.c;
            if (writeData != null && writeData.getType() == 2 && this.M) {
                finish();
            } else if (this.c == null) {
                finish();
            } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.S0)) {
                finish();
            } else {
                this.c.setTitle(d5().getText().toString());
                this.c.setContent(c5().getText().toString());
                WriteEvaluationHeaderView writeEvaluationHeaderView = this.A1;
                if (writeEvaluationHeaderView != null) {
                    this.c.setEvaluationStar(writeEvaluationHeaderView.getStarCount());
                }
                this.c.setRichTextEditorMode(this.Q0);
                if (this.Q0) {
                    this.c.setRichContentData(this.y.getPlainTextContentData());
                }
                int type = this.c.getType();
                if (type == 0 || type == 9 || type == 11) {
                    if (this.V1) {
                        if (this.b1) {
                            wg8.t(this.c);
                        } else if (this.c.isEvaluate()) {
                            wg8.q(this.c.getItem_id(), this.c);
                        } else if (TextUtils.isEmpty(this.c.getTopicId())) {
                            wg8.r(this.c.getForumId(), this.c);
                        } else {
                            wg8.y(this.c.getTopicId(), this.c);
                        }
                    }
                } else if (type == 7) {
                    if (this.V1) {
                        wg8.r("24591571", this.c);
                    }
                } else if (type == 1) {
                    wg8.w(this.c.getThreadId(), this.c);
                } else if (type == 4) {
                    wg8.r(this.c.getForumId() + "photolive", this.c);
                } else if (type == 5) {
                    wg8.w(this.c.getThreadId() + "updatephotolive", this.c);
                }
                this.H2 = true;
            }
        }
    }

    public final void F4(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, editable) == null) {
            if (editable.length() > 500) {
                this.B1.setText((500 - editable.length()) + "/500");
                this.B1.setVisibility(0);
                return;
            }
            this.B1.setVisibility(4);
        }
    }

    public final void F5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.t2 = (ListView) this.z0.findViewById(R.id.obfuscated_res_0x7f09065d);
            gx8 gx8Var = new gx8(getPageContext());
            this.f2 = gx8Var;
            gx8Var.j(this.e2);
            this.t2.setAdapter((ListAdapter) this.f2);
            this.t2.setOnItemClickListener(new b1(this));
        }
    }

    public final void F6(String str) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, str) == null) || this.c == null || (linearLayout = this.o) == null) {
            return;
        }
        if (linearLayout.getVisibility() == 0) {
            if (StringUtils.isNull(str)) {
                this.c.setIsNoTitle(true);
                this.c.setTitle("");
                return;
            }
            this.c.setIsNoTitle(false);
            this.c.setTitle(str);
            return;
        }
        this.c.setIsNoTitle(true);
        this.c.setTitle("");
    }

    public void G4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || c5().getSelectionStart() <= 0) {
            return;
        }
        String substring = c5().getText().toString().substring(0, c5().getSelectionStart());
        Matcher matcher = o76.b.matcher(substring);
        if (matcher.find()) {
            c5().getText().delete(c5().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), c5().getSelectionStart());
            return;
        }
        c5().onKeyDown(67, this.A);
    }

    public final void G5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            registerListener(this.n2);
            registerListener(this.o2);
            registerListener(this.p2);
            registerListener(this.y2);
            registerListener(this.z2);
            registerListener(this.A2);
            registerListener(this.B2);
            registerListener(this.C2);
        }
    }

    public final void G6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && this.c.getType() == 0 && this.c.getTitle() != null) {
            this.I0.setText(this.c.getTitle());
            this.I0.setSelection(this.c.getTitle().length());
        }
    }

    public final void H4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            new g1(this).execute(new Void[0]);
        }
    }

    public final void H5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && this.b1) {
            LocalChannelTopicSelectView localChannelTopicSelectView = (LocalChannelTopicSelectView) findViewById(R.id.obfuscated_res_0x7f092462);
            this.x1 = localChannelTopicSelectView;
            localChannelTopicSelectView.setVisibility(0);
            this.x1.setLocalChannelTopic(this.c1);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void H6(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048602, this, z2) == null) || !TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) || this.N0 || c5() == null) {
            return;
        }
        this.x.setPadding(0, 0, 0, 0);
        this.x.setBackgroundDrawable(null);
        SkinManager.setBackgroundColor(this.x, R.color.CAM_X0201);
        if (TextUtils.isEmpty(this.z) || this.Z != null) {
            return;
        }
        jg.h().m(this.z, 19, new z0(this, z2), getUniqueId());
    }

    public final void I4() {
        u05 u05Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            VoiceData.VoiceModel voiceModel = this.d;
            if (voiceModel != null) {
                gv4.a(gv4.b(voiceModel.voiceId));
            }
            this.d = null;
            this.c.setVoiceModel(null);
            this.B.setVisibility(8);
            this.C.p();
            this.C.setVoiceModel(null);
            t05 n2 = this.S.n(6);
            if (n2 != null && (u05Var = n2.m) != null) {
                u05Var.C(new h05(52, 0, null));
            }
            N6();
        }
    }

    public final void I5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(10);
            arrayList.add(5);
            this.S.h(arrayList);
            t05 n2 = this.S.n(5);
            if (n2 != null) {
                n2.l = 2;
            }
            this.S.d(new v05(getActivity(), 3));
            this.S.d(new d15(getActivity(), 6));
        }
    }

    public void I6() {
        WriteData writeData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (writeData = this.c) == null) {
            return;
        }
        this.S.setToolEnabled(ListUtils.isEmpty(writeData.getItemDatas()) && !this.Q0, 33);
    }

    public final int J4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            int selectionEnd = c5().getSelectionEnd();
            ImageSpan[] imageSpanArr = (ImageSpan[]) c5().getText().getSpans(0, c5().getText().length(), ImageSpan.class);
            for (int i2 = 0; i2 < imageSpanArr.length; i2++) {
                int spanStart = c5().getText().getSpanStart(imageSpanArr[i2]);
                int spanEnd = c5().getText().getSpanEnd(imageSpanArr[i2]);
                if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                    return spanEnd;
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final void J5() {
        WriteData writeData;
        PostTopicData postTopicData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || (writeData = this.c) == null || writeData.getType() != 0 || this.c.getType() != 9 || this.e || this.g || (postTopicData = this.l0) == null || StringUtils.isNull(postTopicData.getTitleTopic())) {
            return;
        }
        String cutStringWithSuffix = StringHelper.cutStringWithSuffix(this.l0.getTitleTopic(), 31, null);
        if (StringUtils.isNull(cutStringWithSuffix) || d5() == null) {
            return;
        }
        d5().setText(cutStringWithSuffix);
        d5().setSelection(cutStringWithSuffix.length());
    }

    public void J6() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || this.S.n(10) == null) {
            return;
        }
        WriteImagesInfo writeImagesInfo = this.T;
        this.S.setToolEnabled(writeImagesInfo == null || ListUtils.getCount(writeImagesInfo.getChosedFiles()) < this.T.getMaxImagesAllowed(), 10);
    }

    public final void K4(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, writeData) == null) {
            this.c.setContent(writeData.getContent());
            SpannableString t2 = TbFaceManager.i().t(getPageContext().getPageActivity(), this.c.getContent(), this.q2);
            InputFilter[] filters = this.r.getFilters();
            this.r.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50000)});
            c5().setText(t2);
            EditText c5 = c5();
            SpanGroupEditText spanGroupEditText = this.r;
            if (c5 == spanGroupEditText && spanGroupEditText.getSpanGroupManager() != null) {
                this.r.h();
                this.r.getSpanGroupManager().r();
                this.r.c();
                L6();
            }
            this.r.setFilters(filters);
            if (c5().getText() != null) {
                c5().setSelection(c5().getText().length());
            }
            if (this.N0) {
                c7(this.K0, this.E0);
            }
        }
    }

    public final void K5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.p0 = findViewById(R.id.obfuscated_res_0x7f0918b1);
            if (this.r1 == null) {
                zy5 zy5Var = new zy5(getPageContext(), this.p0);
                this.r1 = zy5Var;
                zy5Var.g0(R.drawable.obfuscated_res_0x7f0802ef);
                this.r1.O(16);
                this.r1.U(true);
                this.r1.h0(true);
                this.r1.j0(pi.f(getActivity(), R.dimen.obfuscated_res_0x7f070207));
            }
            this.m0 = (TextView) findViewById(R.id.obfuscated_res_0x7f0918b0);
            this.v = findViewById(R.id.obfuscated_res_0x7f0918cf);
            this.o0 = (ImageView) findViewById(R.id.obfuscated_res_0x7f0918d0);
            L5();
        }
    }

    public void K6() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || this.c == null) {
            return;
        }
        this.S.setToolEnabled((o5() || 10 - h5() != 0 || this.Q0) ? false : true, 35);
    }

    public final void L4(WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048612, this, writeData) == null) && this.R0 && this.Q0) {
            this.c.setRichContentData(writeData.getRichContentData());
            this.y.r(writeData.getRichContentData());
        }
    }

    public final void L5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            PostPrefixData postPrefixData = this.k0;
            if (postPrefixData != null && postPrefixData.getPrefixs().size() > 1) {
                this.p0.setVisibility(0);
                this.v.setVisibility(0);
                this.r1.n0(getString(R.string.obfuscated_res_0x7f0f15e8), "write_title_prefix_tip_key", true);
                ArrayList<String> prefixs = this.k0.getPrefixs();
                int size = prefixs.size();
                this.q0 = 0;
                this.p0.setOnClickListener(new q0(this));
                this.m0.setOnClickListener(new s0(this));
                qv8 qv8Var = new qv8(getPageContext().getPageActivity());
                this.n0 = qv8Var;
                qv8Var.e(this);
                this.n0.d(pi.f(getActivity(), R.dimen.obfuscated_res_0x7f0702d9));
                this.n0.setOutsideTouchable(true);
                this.n0.setFocusable(true);
                this.n0.setOnDismissListener(this);
                this.n0.setBackgroundDrawable(SkinManager.getDrawable(R.color.CAM_X0201));
                int color = SkinManager.getColor(R.color.CAM_X0105);
                SkinManager.getColor(R.color.CAM_X0108);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.o0, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, null);
                fr4 d2 = fr4.d(this.m0);
                d2.v(R.color.CAM_X0105);
                d2.A(R.string.F_X02);
                d2.f(R.color.CAM_X0201);
                this.w.clear();
                for (int i2 = 0; i2 < size; i2++) {
                    WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                    this.w.add(writePrefixItemLayout);
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
                    this.n0.a(writePrefixItemLayout);
                }
                this.n0.c(0);
                this.m0.setText(prefixs.get(0));
                W6(0);
                return;
            }
            this.p0.setVisibility(8);
            this.v.setVisibility(8);
        }
    }

    public void L6() {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            gx8 gx8Var = this.f2;
            if (gx8Var != null && gx8Var.f() == null && (spanGroupEditText = this.r) != null && spanGroupEditText.getSpanGroupManager() != null) {
                this.f2.i(this.r.getSpanGroupManager().D());
                this.f2.h();
            } else {
                gx8 gx8Var2 = this.f2;
                if (gx8Var2 != null && gx8Var2.f() != null) {
                    this.f2.h();
                }
            }
            gx8 gx8Var3 = this.f2;
            if (gx8Var3 != null) {
                if (gx8Var3.getCount() == 0) {
                    this.t2.setVisibility(8);
                } else {
                    this.t2.setVisibility(0);
                }
            }
            gx8 gx8Var4 = this.f2;
            if (gx8Var4 != null) {
                f7(gx8Var4.d());
            }
        }
    }

    public final void M4(WriteData writeData) {
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, writeData) == null) {
            if (oi.isEmpty(this.c.getTitle())) {
                this.c.setTitle(writeData.getTitle());
            }
            if (!ListUtils.isEmpty(this.i1)) {
                HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) ListUtils.getItem(this.i1, 0);
                String str = hotTopicBussinessData != null ? hotTopicBussinessData.mTopicName : null;
                if (StringUtils.isNull(str)) {
                    a2 = this.c.getTitle();
                } else {
                    a2 = fc5.a(str);
                }
                SpannableString i2 = fc5.i(a2);
                if (i2 != null) {
                    d5().setText(i2);
                    int length = i2.length() > a2.length() ? a2.length() : i2.length();
                    if (length > d5().getText().length()) {
                        length = d5().getText().length();
                    }
                    d5().setSelection(length);
                    return;
                }
                return;
            }
            SpannableString i3 = fc5.i(this.c.getTitle());
            if (i3 != null) {
                d5().setText(i3);
                int length2 = this.c.getTitle().length() > i3.length() ? i3.length() : this.c.getTitle().length();
                if (length2 > d5().getText().length()) {
                    length2 = d5().getText().length();
                }
                d5().setSelection(length2);
            }
        }
    }

    public final void M5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            z6(this.X1);
        }
    }

    public final void M6(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z2) == null) {
            WriteData writeData = this.c;
            String forumId = writeData == null ? "" : writeData.getForumId();
            lx8 lx8Var = this.A0;
            if (lx8Var != null) {
                lx8Var.k(this.T, this.S0, forumId);
            }
        }
    }

    public final void N4(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, writeData) == null) {
            if (writeData.getWriteImagesInfo() != null) {
                this.T = writeData.getWriteImagesInfo();
            }
            this.c.setWriteImagesInfo(this.T);
            this.y.setWriteImagesInfo(this.T);
            if (this.T.getChosedFiles() != null && this.T.getChosedFiles().size() > 0) {
                Z6();
            }
            M6(false);
            l7(true, true);
        }
    }

    public final void N5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            this.g2 = (LinearLayout) this.z0.findViewById(R.id.obfuscated_res_0x7f091936);
            this.h2 = (ImageView) this.z0.findViewById(R.id.obfuscated_res_0x7f09193b);
            TextView textView = (TextView) this.z0.findViewById(R.id.obfuscated_res_0x7f091938);
            this.i2 = textView;
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0107);
            EBusinessProtocolView eBusinessProtocolView = new EBusinessProtocolView(this, EBusinessProtocolView.WindowType.PROTOCOL);
            this.k2 = eBusinessProtocolView;
            eBusinessProtocolView.o(getResources().getString(R.string.obfuscated_res_0x7f0f0f1e));
            this.k2.i("file:///android_asset/protocol.html");
            SpannableString spannableString = new SpannableString(getResources().getString(R.string.obfuscated_res_0x7f0f0f66));
            spannableString.setSpan(new j0(this), 6, 17, 34);
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0302)), 6, 17, 34);
            this.i2.setText(spannableString);
            this.i2.setMovementMethod(LinkMovementMethod.getInstance());
            this.h2.setOnClickListener(new k0(this));
            ht4 k2 = ht4.k();
            if (k2.h(TbadkCoreApplication.getCurrentAccount() + "is_agree_protocol", false)) {
                this.l2 = true;
                this.h2.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080803, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
            } else {
                this.l2 = false;
                this.h2.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809e6, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
            }
            this.k2.m(new l0(this));
        }
    }

    public void N6() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048620, this) == null) || this.c == null) {
            return;
        }
        String obj = d5() != null ? d5().getText().toString() : "";
        String trim = c5() != null ? c5().getText().toString().trim() : "";
        String trim2 = obj.trim();
        boolean z2 = false;
        if (this.c.getType() == 0 || this.c.getType() == 9 || this.c.getType() == 7) {
            PostPrefixData postPrefixData = this.k0;
            if (postPrefixData != null && postPrefixData.getPrefixs().size() > 0) {
                if (this.q0 == ListUtils.getCount(this.k0.getPrefixs()) - 1) {
                    if (TextUtils.isEmpty(trim2)) {
                        this.c.setIsNoTitle(true);
                    } else if (this.o.getVisibility() == 0) {
                        this.c.setIsNoTitle(false);
                        d7(true);
                        return;
                    }
                } else if (this.o.getVisibility() == 0 && !TextUtils.isEmpty(trim2)) {
                    this.c.setIsNoTitle(false);
                    d7(true);
                    return;
                }
            } else if (TextUtils.isEmpty(trim2)) {
                this.c.setIsNoTitle(true);
            } else if (this.o.getVisibility() == 0) {
                this.c.setIsNoTitle(false);
                d7(true);
                return;
            }
        }
        if (this.T.getChosedFiles() != null && this.T.size() > 0) {
            if (!this.N0) {
                d7(true);
                return;
            } else if (this.T.size() >= 1) {
                d7(true);
            }
        }
        if (this.c.getType() == 4) {
            if (j6(this.E0) && k6(this.I0)) {
                z2 = true;
            }
            d7(z2);
        } else if (this.c.getType() == 5) {
            d7(j6(this.E0));
        } else if (TextUtils.isEmpty(trim) && this.d == null) {
            if (o5()) {
                d7(true);
            } else {
                d7(false);
            }
        } else {
            d7(true);
        }
    }

    public final void O4(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, intent) == null) {
            f5(intent, true);
        }
    }

    public final void O5() {
        WriteData writeData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048622, this) == null) || this.H == null || (writeData = this.c) == null || writeData.getProZone() != 1) {
            return;
        }
        this.H.setText(R.string.obfuscated_res_0x7f0f15f7);
    }

    public final void O6(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, editable) == null) {
            if (!TextUtils.isEmpty(editable) && editable.length() >= 20 && editable.length() <= 500 && this.A1.e()) {
                this.G.setEnabled(true);
            } else {
                this.G.setEnabled(false);
            }
        }
    }

    public final void P4(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048624, this, intent) == null) || intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            this.T.parseJson(stringExtra);
            this.T.updateQuality();
        }
        y7();
        M6(true);
    }

    public final void P5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.H.getLayoutParams();
            this.K2 = layoutParams.rightMargin;
            layoutParams.rightMargin = 0;
            this.H.setLayoutParams(layoutParams);
            ImageView imageView = (ImageView) this.E.getCenterImgBox();
            this.K = imageView;
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0808fd, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL));
            int f2 = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            int f3 = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds47);
            this.K.setPadding(f2, f2, f2, f2);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.K.getLayoutParams();
            int i2 = f3 + f2 + f2;
            layoutParams2.width = i2;
            layoutParams2.height = i2;
            this.K.setLayoutParams(layoutParams2);
            this.K.setOnClickListener(new m0(this));
            this.K.setVisibility(0);
        }
    }

    public void P6() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048626, this) == null) || this.S.n(34) == null) {
            return;
        }
        boolean z2 = true;
        this.S.setToolEnabled(this.b1 ? false : (ListUtils.getCount(this.T.getChosedFiles()) > 0 || this.d != null || this.Q0) ? false : false, 34);
    }

    public final void Q4(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048627, this, intent) == null) || intent == null) {
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
                    this.T.addChooseFile(imageFileInfo);
                    f6(imageFileInfo);
                }
            }
            J6();
            P6();
            if (this.T.getChosedFiles() != null) {
                Z6();
            }
        }
        M6(true);
    }

    public final void Q5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048628, this) == null) && this.T0 != null && this.c.getType() == 0 && this.c.getType() == 9 && this.c.getType() == 11) {
            V4(getActivity());
            View inflate = getPageContext().getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d06fd, (ViewGroup) null);
            this.V0 = inflate;
            inflate.setOnClickListener(new i1(this));
            this.U0 = (TbImageView) this.V0.findViewById(R.id.obfuscated_res_0x7f0919c0);
            this.X0 = (LinearLayout) this.V0.findViewById(R.id.obfuscated_res_0x7f0919bf);
            if (ht4.k().q("write_rec_pic_path", "").equalsIgnoreCase(this.T0.getAbsolutePath())) {
                return;
            }
            ht4.k().y("write_rec_pic_path", this.T0.getAbsolutePath());
            Bitmap b5 = b5(this.T0.getAbsolutePath(), getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070256));
            if (b5 != null) {
                this.U0.setImageBitmap(b5);
                this.U0.setDrawBorder(true);
                this.U0.setBorderWidth(2);
                this.U0.setBorderColor(SkinManager.getColor(R.color.common_color_10264));
                Dialog dialog = new Dialog(getActivity(), R.style.obfuscated_res_0x7f10039b);
                this.W0 = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.W0.setOnDismissListener(new j1(this));
                this.W0.setContentView(this.V0);
                this.W0.show();
                Window window = this.W0.getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                window.setGravity(83);
                attributes.x = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701f9);
                attributes.y = (O2 / 18) + getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07023e);
                attributes.width = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07025b);
                attributes.height = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070294);
                window.setAttributes(attributes);
            }
        }
    }

    public void Q6() {
        WriteData writeData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048629, this) == null) || (writeData = this.c) == null) {
            return;
        }
        this.S.setToolEnabled(ListUtils.isEmpty(writeData.getItemDatas()) && !this.Q0, 32);
    }

    public final void R4(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, intent) == null) {
            this.U = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
            String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.U;
            if (!TextUtils.isEmpty(str)) {
                try {
                    int readPictureDegree = BitmapHelper.readPictureDegree(str);
                    if (readPictureDegree != 0) {
                        Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, pi.d(getPageContext().getPageActivity(), pi.k(getPageContext().getPageActivity())), pi.d(getPageContext().getPageActivity(), pi.i(getPageContext().getPageActivity())));
                        Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                        if (loadResizedBitmap != rotateBitmapBydegree) {
                            loadResizedBitmap.recycle();
                        }
                        FileHelper.saveBitmapByRelativelyPath(TbConfig.LOCAL_CAMERA_DIR, this.U, rotateBitmapBydegree, 100);
                        rotateBitmapBydegree.recycle();
                    }
                } catch (Exception unused) {
                }
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(str);
                imageFileInfo.setTempFile(true);
                this.T.addChooseFile(imageFileInfo);
                this.T.updateQuality();
                i4(imageFileInfo);
                J6();
                P6();
                Z6();
            }
            M6(true);
        }
    }

    public final void R5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            this.J1 = findViewById(R.id.obfuscated_res_0x7f091a73);
            this.K1 = (RichGuideHollowView) findViewById(R.id.obfuscated_res_0x7f091a72);
            this.L1 = (TBLottieAnimationView) findViewById(R.id.obfuscated_res_0x7f091a75);
            this.M1 = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091a71);
            this.N1 = (TextView) findViewById(R.id.obfuscated_res_0x7f091a76);
            this.O1 = (TextView) findViewById(R.id.obfuscated_res_0x7f091a77);
            this.P1 = (TextView) findViewById(R.id.obfuscated_res_0x7f091a78);
            this.Q1 = (TextView) findViewById(R.id.obfuscated_res_0x7f091a79);
            this.K1.setTargetView(this.I);
            SkinManager.setLottieAnimation(this.L1, R.raw.obfuscated_res_0x7f11004b);
            this.L1.setRepeatCount(3);
            SkinManager.setBackgroundResource(this.M1, R.drawable.obfuscated_res_0x7f080fd0);
            fr4 d2 = fr4.d(this.N1);
            d2.A(R.string.F_X01);
            d2.z(R.dimen.T_X09);
            d2.v(R.color.CAM_X0303);
            fr4 d3 = fr4.d(this.O1);
            d3.A(R.string.F_X02);
            d3.z(R.dimen.T_X05);
            d3.v(R.color.CAM_X0105);
            fr4 d4 = fr4.d(this.P1);
            d4.A(R.string.F_X01);
            d4.z(R.dimen.T_X10);
            d4.v(R.color.CAM_X0109);
            fr4.d(findViewById(R.id.obfuscated_res_0x7f091a74)).o(new int[]{R.color.CAM_X0901, R.color.CAM_X0612});
            fr4 d5 = fr4.d(this.Q1);
            d5.A(R.string.F_X01);
            d5.z(R.dimen.T_X07);
            d5.v(R.color.CAM_X0101);
            d5.n(R.string.J_X07);
            d5.l(R.dimen.L_X01);
            d5.k(R.color.CAM_X0101);
            d5.j(R.string.A_X07);
            d5.h(17170445);
            this.J1.setOnClickListener(new b0(this));
        }
    }

    public final void R6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921500, new m1(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public final void S4(@Nullable Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048633, this, intent) == null) || intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            writeImagesInfo.updateQuality();
            LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo.getChosedFiles();
            if (chosedFiles != null) {
                for (ImageFileInfo imageFileInfo : chosedFiles) {
                    this.T.addChooseFile(imageFileInfo);
                    f6(imageFileInfo);
                }
            }
            J6();
            P6();
            if (this.T.getChosedFiles() != null) {
                Z6();
            }
        }
        M6(true);
    }

    public final void S5(SelectForumData selectForumData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048634, this, selectForumData) == null) || selectForumData == null) {
            return;
        }
        this.z1 = selectForumData;
        WriteData writeData = this.c;
        if (writeData != null) {
            writeData.setForumId(selectForumData.forumId);
            this.c.setForumName(this.z1.forumName);
            SpanGroupEditText spanGroupEditText = this.r;
            if (spanGroupEditText != null) {
                spanGroupEditText.setForumId(ng.g(this.z1.forumId, 0L));
            }
        }
        this.y1.setSelectedForum(this.z1.forumName);
        this.E1 = null;
        if (!ListUtils.isEmpty(this.z1.tabInfoList)) {
            FrsTabInfoData frsTabInfoData = new FrsTabInfoData();
            this.E1 = frsTabInfoData;
            frsTabInfoData.selectedTabId = -1;
            SelectForumData selectForumData2 = this.z1;
            List<FrsTabItemData> list = selectForumData2.tabInfoList;
            frsTabInfoData.tabList = list;
            if (selectForumData2.isForumBusinessAccount && list != null) {
                FrsTabItemData frsTabItemData = new FrsTabItemData();
                frsTabItemData.tabId = 505;
                frsTabItemData.name = "官方";
                this.E1.tabList.add(0, frsTabItemData);
            }
            this.E1.isForumBusinessAccount = this.z1.isForumBusinessAccount;
        }
        this.C1.setData(this.E1);
        WriteData writeData2 = this.c;
        if (writeData2 != null) {
            writeData2.setFrsTabInfoData(this.E1);
        }
        if (this.C1.getVisibility() == 0) {
            this.D1.setVisibility(0);
        }
        this.k0 = null;
        PostPrefixData postPrefixData = this.z1.postPrefix;
        if (postPrefixData != null && !ListUtils.isEmpty(postPrefixData.getPrefixs())) {
            PostPrefixData postPrefixData2 = this.z1.postPrefix;
            this.k0 = postPrefixData2;
            postPrefixData2.getPrefixs().add(getPageContext().getString(R.string.obfuscated_res_0x7f0f15d7));
        }
        L5();
    }

    public final void S6() {
        WriteImagesInfo writeImagesInfo;
        ImageFileInfo imageFileInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048635, this) == null) || (writeImagesInfo = this.T) == null || writeImagesInfo.getChosedFiles() == null || this.T.size() <= 0 || (imageFileInfo = this.T.getChosedFiles().get(this.T.size() - 1)) == null || TextUtils.isEmpty(imageFileInfo.getFilePath()) || !imageFileInfo.getFilePath().startsWith("android.resource://")) {
            return;
        }
        this.T.getChosedFiles().remove(this.T.size() - 1);
    }

    public final String T4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            ArrayList arrayList = new ArrayList();
            WriteEvaluationHeaderView writeEvaluationHeaderView = this.A1;
            arrayList.add(new HeadItem("", String.valueOf(writeEvaluationHeaderView != null ? writeEvaluationHeaderView.getStarCount() : 0), 2));
            return new Gson().toJson(arrayList);
        }
        return (String) invokeV.objValue;
    }

    public final void T5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            if ("main_tab".equals(this.S0) && !this.W1) {
                ForumSelectedView forumSelectedView = (ForumSelectedView) findViewById(R.id.obfuscated_res_0x7f092467);
                this.y1 = forumSelectedView;
                forumSelectedView.setVisibility(0);
            } else if (this.R0) {
                ForumSelectedView forumSelectedView2 = (ForumSelectedView) findViewById(R.id.obfuscated_res_0x7f092467);
                this.y1 = forumSelectedView2;
                forumSelectedView2.setVisibility(0);
                this.y1.setSelectedForum(this.c.getForumName());
                this.y1.a();
                this.y1.setOnClickListener(null);
            }
        }
    }

    public final void T6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            if (this.W.C()) {
                if (this.W.G()) {
                    Y6(2, true, ri8.a().b().getFormatted_address());
                    return;
                }
                Y6(1, true, null);
                this.W.L();
                return;
            }
            Y6(0, true, null);
        }
    }

    @Override // com.repackage.qv8.a
    public void U0(int i2) {
        PostPrefixData postPrefixData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048639, this, i2) == null) || (postPrefixData = this.k0) == null) {
            return;
        }
        if (i2 == ListUtils.getCount(postPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new StatisticItem("c13014").param("obj_type", 1));
        } else {
            TiebaStatic.log(new StatisticItem("c13014").param("obj_type", 2));
        }
        this.q0 = i2;
        this.n0.c(i2);
        W6(i2);
        this.m0.setText(this.k0.getPrefixs().get(i2));
        N6();
        sg.d(this.n0, getPageContext().getPageActivity());
    }

    public final String U4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? (c5() == null || c5().getText() == null) ? "" : c5().getText().toString() : (String) invokeV.objValue;
    }

    public final void U5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            if (this.R0 && this.Q0) {
                u5();
            }
            if (this.Q0) {
                w6();
            } else {
                v6();
            }
        }
    }

    public final void U6() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048642, this) == null) || (editorTools = this.S) == null) {
            return;
        }
        editorTools.A(new h05(54, 15, null));
    }

    public final void V4(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, context) == null) {
            O2 = pi.i(context);
        }
    }

    public void V5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048644, this) == null) {
            if (this.S1) {
                this.o.setVisibility(8);
                WriteImageGridView writeImageGridView = this.u2;
                if (writeImageGridView != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) writeImageGridView.getLayoutParams();
                    layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X012);
                    this.u2.setLayoutParams(layoutParams);
                }
                this.p.setVisibility(8);
            } else {
                this.k.setHint(R.string.obfuscated_res_0x7f0f1434);
                this.o.setVisibility(0);
                WriteImageGridView writeImageGridView2 = this.u2;
                if (writeImageGridView2 != null) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) writeImageGridView2.getLayoutParams();
                    layoutParams2.topMargin = 0;
                    this.u2.setLayoutParams(layoutParams2);
                }
                this.p.setVisibility(0);
                this.o.requestFocus();
            }
            if (this.b1) {
                this.k.setHint(R.string.obfuscated_res_0x7f0f1435);
            }
        }
    }

    public final void V6() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048645, this) == null) || (editorTools = this.S) == null) {
            return;
        }
        editorTools.A(new h05(57, 15, null));
    }

    public final void W4(@Nullable Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048646, this, intent) == null) || intent == null) {
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
                this.T.getChosedFiles().remove(originalImgIndex);
                this.T.getChosedFiles().add(originalImgIndex, imageFileInfo);
                this.y.o(imageFileInfo, writeImagesInfo.getOriginalImgViewIndex());
                J6();
                P6();
                if (this.T.getChosedFiles() != null) {
                    Z6();
                }
            }
        }
        M6(true);
    }

    public final void W5() {
        HotTopicBussinessData hotTopicBussinessData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048647, this) == null) || (hotTopicBussinessData = (HotTopicBussinessData) ListUtils.getItem(this.i1, 0)) == null || TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            return;
        }
        this.k.setText(fc5.i(fc5.a(hotTopicBussinessData.mTopicName)));
        this.k.setMovementMethod(ys8.a());
    }

    public final void W6(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048648, this, i2) == null) || i2 >= this.w.size()) {
            return;
        }
        for (int i3 = 0; i3 < this.w.size(); i3++) {
            this.w.get(i3).b(false);
        }
        this.w.get(i2).b(true);
    }

    public final long X4(EditText editText) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048649, this, editText)) == null) ? hd5.a(editText.getText().toString().trim()) : invokeL.longValue;
    }

    public final void X5() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048650, this) == null) {
            this.P0 = new jt4(getPageContext());
            this.N0 = this.c.getType() == 4 || 5 == this.c.getType();
            View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.obfuscated_res_0x7f0d08c0, (ViewGroup) null);
            this.z0 = inflate;
            setContentView(inflate);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f09238f);
            this.E = navigationBar;
            navigationBar.showBottomLine();
            this.F = this.E.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.H = this.E.setCenterTextTitle("");
            this.J = (ImageView) this.E.getCenterImgBox();
            View centerImgBoxLayout = this.E.getCenterImgBoxLayout();
            this.I = centerImgBoxLayout;
            centerImgBoxLayout.setOnClickListener(new w(this));
            if (this.R0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.H.getLayoutParams();
                layoutParams.rightMargin = 0;
                layoutParams.leftMargin = 0;
                this.H.setLayoutParams(layoutParams);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.J.getLayoutParams();
                layoutParams2.width = pi.f(this, R.dimen.tbds31);
                layoutParams2.height = pi.f(this, R.dimen.tbds31);
                this.J.setLayoutParams(layoutParams2);
                this.J.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080965, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_DISABLE));
                this.J.setVisibility(0);
            }
            SkinManager.setViewTextColor(this.H, (int) R.color.CAM_X0105);
            e7();
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.G.getLayoutParams();
            layoutParams3.rightMargin = pi.f(getPageContext().getPageActivity(), R.dimen.tbds2);
            this.G.setLayoutParams(layoutParams3);
            this.G.setOnFocusChangeListener(this.F2);
            ScrollView scrollView = (ScrollView) findViewById(R.id.obfuscated_res_0x7f092466);
            this.D0 = scrollView;
            scrollView.setOnTouchListener(new x(this));
            addGlobalLayoutListener();
            adjustResizeForSoftInput();
            this.t = (FeedBackTopListView) findViewById(R.id.obfuscated_res_0x7f090968);
            this.u = findViewById(R.id.obfuscated_res_0x7f090966);
            this.O = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091611);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f092082);
            this.n = linearLayout;
            linearLayout.setContentDescription(IStringUtil.TOP_PATH);
            this.o = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f092049);
            this.u2 = (WriteImageGridView) findViewById(R.id.obfuscated_res_0x7f092460);
            this.p = findViewById(R.id.obfuscated_res_0x7f09204a);
            this.m = findViewById(R.id.obfuscated_res_0x7f090ef7);
            this.k1 = (TextView) findViewById(R.id.obfuscated_res_0x7f090d9c);
            c6();
            b6();
            if (this.N0) {
                this.D0.setVisibility(8);
                this.T.setMaxImagesAllowed(6);
                D5();
            } else {
                this.A0 = new lx8(getPageContext(), this.z0);
                if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.S0)) {
                    this.A0.i(false);
                } else {
                    this.A0.j(this.c.getType() == 0 || this.c.getType() == 9 || this.c.getType() == 11);
                }
                this.A0.h(this.Q0);
            }
            l7(true, false);
            if (this.e || this.g) {
                getWindow().setSoftInputMode(18);
            }
            LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0918a6);
            this.q = linearLayout2;
            linearLayout2.setDrawingCacheEnabled(false);
            this.q.setOnClickListener(new y(this));
            this.B = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0911b9);
            this.C = (PlayVoiceBntNew) findViewById(R.id.obfuscated_res_0x7f09042b);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f090f87);
            this.D = imageView;
            imageView.setOnClickListener(new z(this));
            m4(this.d);
            this.F.setOnFocusChangeListener(this.F2);
            this.F.setOnClickListener(new a0(this));
            x5();
            b7(h6());
            g6();
            w7();
            d6();
            u4();
            t5();
            K5();
            W5();
            if (this.c.getType() == 4 && (view2 = this.p0) != null && this.v != null) {
                view2.setVisibility(8);
                this.v.setVisibility(8);
            }
            N6();
            A7();
            O5();
            T5();
            H5();
            C5();
            a6();
            Z5();
            Y5();
            N5();
            F5();
            v5();
            R5();
        }
    }

    public final void X6(boolean z2) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048651, this, z2) == null) || (editorTools = this.S) == null) {
            return;
        }
        editorTools.A(new h05(9, -1, Boolean.valueOf(z2)));
    }

    public final File Y4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
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

    public final void Y5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048653, this) == null) {
            this.I1 = (RelativeLayout) this.z0.findViewById(R.id.obfuscated_res_0x7f0923e3);
            this.H1 = new ux8(getPageContext(), this.I1);
            p7();
        }
    }

    public final void Y6(int i2, boolean z2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048654, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2), str}) == null) {
            this.Y = i2;
            EditorTools editorTools = this.S;
            if (editorTools != null) {
                editorTools.A(new h05(19, 15, new y15(i2, z2, str)));
            }
        }
    }

    public final long Z4(EditText editText) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048655, this, editText)) == null) {
            if (editText == this.E0) {
                return 233L;
            }
            return editText == this.I0 ? 20L : 0L;
        }
        return invokeL.longValue;
    }

    public final void Z5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048656, this) == null) && this.S1) {
            this.A1.setVisibility(0);
            if (this.T1) {
                this.A1.setShowItemInfo(false);
            }
            if (this.R1 != null) {
                TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo = new TbRichTextEvaluateItemInfo();
                tbRichTextEvaluateItemInfo.setItemID(String.valueOf(this.R1.id));
                tbRichTextEvaluateItemInfo.setTags(this.R1.tags);
                tbRichTextEvaluateItemInfo.setScore(this.R1.averageScore);
                tbRichTextEvaluateItemInfo.setStar(g5(this.R1.averageScore));
                tbRichTextEvaluateItemInfo.setIconUrl(this.R1.icon_url);
                tbRichTextEvaluateItemInfo.setIconSize(this.R1.icon_size);
                tbRichTextEvaluateItemInfo.setTitle(this.R1.name);
                this.A1.setItemInfo(tbRichTextEvaluateItemInfo);
                this.A1.setStarCount(this.U1);
                this.c.setItemInfo(tbRichTextEvaluateItemInfo);
                this.c.setEvaluationStar(this.U1);
            } else if (this.c.getItemInfo() != null) {
                this.A1.setItemInfo(this.c.getItemInfo());
                this.A1.setStarCount(this.c.getEvaluationStar());
            }
        }
    }

    public final void Z6() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048657, this) == null) || this.N0) {
            return;
        }
        EditorTools editorTools = this.S;
        if (editorTools != null) {
            editorTools.A(new h05(12, -1, new c15(this.T, true)));
            this.S.A(new h05(12, 11, new c15(this.T, true)));
        }
        WriteData writeData = this.c;
        String forumId = writeData == null ? "" : writeData.getForumId();
        lx8 lx8Var = this.A0;
        if (lx8Var != null) {
            lx8Var.k(this.T, this.S0, forumId);
        }
    }

    public final void a5(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, intent) == null) {
            f5(intent, false);
        }
    }

    public final void a6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048659, this) == null) && this.S1) {
            this.B1 = (TextView) findViewById(R.id.obfuscated_res_0x7f0918a7);
            WriteEvaluationHeaderView writeEvaluationHeaderView = (WriteEvaluationHeaderView) findViewById(R.id.obfuscated_res_0x7f09245f);
            this.A1 = writeEvaluationHeaderView;
            writeEvaluationHeaderView.setStarChangeListener(new h0(this));
            this.A1.setItemCloseListener(new i0(this));
        }
    }

    public final void a7(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, postWriteCallBackData) == null) {
            if (WriteActivityConfig.FROM_ADD_PHOTO_LIVE_IN_MISSON.equals(this.S0)) {
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUCCES_IN_MISSON);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004510, postWriteCallBackData));
        }
    }

    public void b6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048661, this) == null) {
            this.x = findViewById(R.id.obfuscated_res_0x7f0918a5);
            RichTextEditor richTextEditor = (RichTextEditor) findViewById(R.id.obfuscated_res_0x7f091a7b);
            this.y = richTextEditor;
            richTextEditor.setWriteImagesInfo(this.T);
            SpanGroupEditText spanGroupEditText = (SpanGroupEditText) findViewById(R.id.obfuscated_res_0x7f0918a4);
            this.r = spanGroupEditText;
            spanGroupEditText.setDrawingCacheEnabled(false);
            this.r.setOnClickListener(this.D2);
            x0 x0Var = new x0(this);
            this.r.setOnSpanGroupChangedListener(x0Var);
            this.r.setType(SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_COMMODITY);
            this.r.setForumId(ng.g(this.c.getForumId(), 0L));
            oj8 oj8Var = this.V;
            if (oj8Var != null) {
                oj8Var.G(this.r.getSpanGroupManager());
            }
            WriteData writeData = this.c;
            if (writeData != null) {
                writeData.setSpanGroupManager(this.r.getSpanGroupManager());
            }
            if (this.c.getContent() != null && this.c.getContent().length() > 0) {
                this.r.setText(TbFaceManager.i().r(getPageContext().getPageActivity(), this.c.getContent()));
                if (this.r.getText() != null) {
                    SpanGroupEditText spanGroupEditText2 = this.r;
                    spanGroupEditText2.setSelection(spanGroupEditText2.getText().length());
                }
            } else if (this.c.getType() == 2) {
                if (this.M) {
                    String str = this.N;
                    if (str != null && str.length() > 0) {
                        this.r.setText(getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f0fd0, new Object[]{this.N}));
                        SpanGroupEditText spanGroupEditText3 = this.r;
                        spanGroupEditText3.setSelection(spanGroupEditText3.getText().length());
                    }
                } else if (this.c.getFloorNum() > 0) {
                    this.r.setText(String.format(getPageContext().getString(R.string.obfuscated_res_0x7f0f0fd2), Integer.valueOf(this.c.getFloorNum())));
                    SpanGroupEditText spanGroupEditText4 = this.r;
                    spanGroupEditText4.setSelection(spanGroupEditText4.getText().length());
                }
            }
            this.r.setOnFocusChangeListener(this.F2);
            this.r.setOnTouchListener(new y0(this));
            this.r.addTextChangedListener(this.J2);
            if (this.c.getType() == 0) {
                this.n1 = true;
            } else {
                H6(true);
                this.n1 = false;
            }
            if (this.S1) {
                SpannableString spannableString = new SpannableString(" " + ((Object) getResources().getText(R.string.obfuscated_res_0x7f0f15d0)));
                Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080983, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL);
                pureDrawable.setBounds(0, 0, pureDrawable.getIntrinsicWidth(), pureDrawable.getIntrinsicHeight());
                spannableString.setSpan(new s76(pureDrawable, 1, pi.f(this, R.dimen.tbds4)), 0, 1, 17);
                this.r.setHint(spannableString);
            } else if (this.c.isUserFeedback()) {
                this.r.setHint(R.string.obfuscated_res_0x7f0f15d4);
            } else {
                this.r.setHint(R.string.obfuscated_res_0x7f0f0a7f);
            }
            this.y.setOnSpanGroupChangedListener(x0Var);
            this.y.setForumId(ng.g(this.c.getForumId(), 0L));
            this.y.setEditOnClickListener(this.D2);
            this.y.setEditOnFocusChangeListener(this.F2);
            this.y.setBigEmotionSpanHandler(this.q2);
            this.y.j(this.J2);
            this.y.m();
            U5();
        }
    }

    public final void b7(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048662, this, bool) == null) {
            WriteData writeData = this.c;
            if (getPageContext().getString(R.string.obfuscated_res_0x7f0f05f6).equals(writeData != null ? writeData.getForumName() : null)) {
                this.e = true;
            }
        }
    }

    public EditText c5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) ? this.N0 ? this.E0 : this.Q0 ? this.y.getLastFocusEdit() : this.r : (EditText) invokeV.objValue;
    }

    public void c6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048664, this) == null) {
            HeadImageView headImageView = (HeadImageView) findViewById(R.id.obfuscated_res_0x7f092273);
            this.l = headImageView;
            headImageView.setIsRound(true);
            this.l.setDrawBorder(false);
            this.l.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
            if (!StringUtils.isNull(currentPortrait)) {
                String headPortraitFilter = HeadIconRefreshHelper.headPortraitFilter(currentPortrait);
                this.l.setUrl(headPortraitFilter);
                this.l.J(headPortraitFilter, 12, false);
            }
            if (this.c.isUserFeedback()) {
                this.l.setVisibility(0);
            }
            EditText editText = (EditText) findViewById(R.id.obfuscated_res_0x7f0918c1);
            this.k = editText;
            editText.setOnClickListener(this.D2);
            this.k.setOnFocusChangeListener(this.F2);
            if (this.c.getType() != 0 && this.c.getType() != 9 && this.c.getType() != 11 && this.c.getType() != 7) {
                if (this.c.getType() != 1) {
                    this.c.getType();
                }
            } else if (this.c.getTitle() != null) {
                this.k.setText(this.c.getTitle());
                this.k.setSelection(this.c.getTitle().length());
            } else if (this.h) {
                this.k.setText(getResources().getString(R.string.obfuscated_res_0x7f0f1509));
            }
            this.k.addTextChangedListener(this.I2);
            this.k.setFilters(new InputFilter[]{new tw8.b(this.k, 31, new v0(this))});
            fr4.d(this.k).A(R.string.F_X02);
            if (this.c.getHaveDraft()) {
                return;
            }
            J5();
            this.a1 = true;
        }
    }

    public final void c7(TextView textView, EditText editText) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048665, this, textView, editText) == null) || textView == null || editText == null) {
            return;
        }
        long Z4 = Z4(editText);
        long X4 = Z4 - X4(editText);
        String valueOf = String.valueOf(X4);
        if (Z4 == 20) {
            if (X4 < 0) {
                if (X4 < -9) {
                    valueOf = "-∞";
                }
                textView.setTextColor(SkinManager.getColor(R.color.common_color_10159));
            } else {
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            }
        } else if (X4 < 0) {
            if (X4 < -99) {
                valueOf = "-∞";
            }
            textView.setTextColor(SkinManager.getColor(R.color.common_color_10159));
        } else {
            textView.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
        }
        textView.setText(valueOf);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048666, this) == null) {
            if (this.b1) {
                ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 1);
            } else {
                ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        jt4 jt4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048667, this) == null) || (jt4Var = this.P0) == null) {
            return;
        }
        jt4Var.h(false);
    }

    public final EditText d5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) ? this.N0 ? this.I0 : this.k : (EditText) invokeV.objValue;
    }

    public final void d6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048669, this) == null) {
            u0().onCreate(getPageContext());
        }
    }

    public void d7(boolean z2) {
        SpanGroupEditText spanGroupEditText;
        WriteEvaluationHeaderView writeEvaluationHeaderView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048670, this, z2) == null) {
            if (z2 && this.S1 && ((spanGroupEditText = this.r) == null || TextUtils.isEmpty(spanGroupEditText.getText()) || this.r.getText().length() < 20 || this.r.getText().length() > 500 || (writeEvaluationHeaderView = this.A1) == null || !writeEvaluationHeaderView.e())) {
                return;
            }
            this.G.setEnabled(z2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048671, this, motionEvent)) == null) {
            if (this.r0.onTouchEvent(motionEvent)) {
                motionEvent.setAction(3);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public final void e5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048672, this, str) == null) {
            if (this.T.getChosedFiles() != null && this.T.getChosedFiles().size() >= this.T.getMaxImagesAllowed()) {
                showToast(String.format(getPageContext().getContext().getString(R.string.obfuscated_res_0x7f0f0aa6), Integer.valueOf(this.T.getMaxImagesAllowed())));
                return;
            }
            this.T.addChooseFileFromCamera(str);
            this.T.updateQuality();
            i4(this.T.getChosedFiles().getLast());
            this.Y0 = true;
            J6();
            P6();
            if (this.T.getChosedFiles() != null) {
                Z6();
            }
            M6(true);
        }
    }

    public void e6(nw4 nw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048673, this, nw4Var) == null) {
            if (((ImageSpan[]) c5().getText().getSpans(0, c5().getText().length(), ImageSpan.class)).length >= 10) {
                if (this.P == null) {
                    this.P = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.obfuscated_res_0x7f0f144a, 0);
                }
                this.P.show();
                return;
            }
            p76.b(this, nw4Var, c5());
        }
    }

    public final void e7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048674, this) == null) {
            if (this.c.getType() == 7) {
                this.G = this.E.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.obfuscated_res_0x7f0f13ee));
                return;
            }
            String string = getPageContext().getString(R.string.obfuscated_res_0x7f0f111e);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.S0)) {
                string = getPageContext().getString(R.string.obfuscated_res_0x7f0f1145);
            }
            this.G = this.E.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, string);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048675, this) == null) {
            if (this.b1) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048676, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    public final void f5(Intent intent, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048677, this, intent, z2) == null) || intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            this.T.parseJson(stringExtra);
            this.T.updateQuality();
            J6();
            P6();
            if (this.T.getChosedFiles() != null) {
                Z6();
            }
        }
        M6(true);
    }

    public final void f6(@NonNull ImageFileInfo imageFileInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048678, this, imageFileInfo) == null) {
            this.y.s(imageFileInfo);
        }
    }

    public final void f7(List<vn4> list) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048679, this, list) == null) || list == null) {
            return;
        }
        boolean z2 = false;
        Iterator<vn4> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().b == 2) {
                z2 = true;
                break;
            }
        }
        if (z2 || (linearLayout = this.g2) == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    public final int g5(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048680, this, new Object[]{Double.valueOf(d2)})) == null) ? (int) ((d2 + 1.0d) / 2.0d) : invokeCommon.intValue;
    }

    public void g6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048681, this) == null) {
            this.G.setOnClickListener(new u0(this));
        }
    }

    public final void g7(EvaluateRelevanceItemSelectedMessage evaluateRelevanceItemSelectedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048682, this, evaluateRelevanceItemSelectedMessage) == null) {
            WriteEvaluationHeaderView writeEvaluationHeaderView = this.A1;
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
                this.c.setItemInfo(tbRichTextEvaluateItemInfo);
                this.A1.setItemInfo(tbRichTextEvaluateItemInfo);
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
            h4(itemData);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.repackage.t75
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) {
            WriteData writeData = this.c;
            return writeData != null ? writeData.getType() == 4 ? "a015" : this.c.getType() == 5 ? "a016" : "a094" : "a094";
        }
        return (String) invokeV.objValue;
    }

    public final void h4(ItemData itemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048684, this, itemData) == null) {
            this.c.addItemData(itemData);
            this.d2.setVisibility(0);
            this.d2.a(itemData);
        }
    }

    public final int h5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) {
            SpanGroupEditText spanGroupEditText = this.r;
            if (spanGroupEditText == null || spanGroupEditText.getSpanGroupManager() == null) {
                return 10;
            }
            return 10 - this.r.getSpanGroupManager().x();
        }
        return invokeV.intValue;
    }

    public final Boolean h6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) ? Boolean.valueOf(this.Q) : (Boolean) invokeV.objValue;
    }

    public final void h7(boolean z2, String str) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048687, this, z2, str) == null) {
            StringBuilder sb = new StringBuilder();
            if (str != null) {
                sb.append(str);
            }
            if (z2) {
                AdditionData additionData = this.Z;
                if (additionData != null) {
                    i2 = additionData.getTotalCount();
                    i3 = this.Z.getAlreadyCount() + 1;
                } else {
                    i2 = 0;
                    i3 = 0;
                }
                if (i2 > i3) {
                    String format = String.format(getPageContext().getString(R.string.obfuscated_res_0x7f0f15ce), Integer.valueOf(i2 - i3));
                    sb.append("\n");
                    sb.append(format);
                }
            }
            pi.O(getPageContext().getPageActivity(), sb.toString());
        }
    }

    @Override // com.repackage.wg8.f
    public void i0(WriteData writeData) {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048688, this, writeData) == null) || WriteActivityConfig.FROM_FORUM_SHARE.equals(this.S0) || this.m2 || this.W1) {
            return;
        }
        if (this.R0 && (writeImagesInfo = this.T) != null && writeImagesInfo.size() > 0) {
            m7();
        } else if (writeData != null) {
            if (this.c != null && writeData.isEvaluate() == this.c.isEvaluate()) {
                int i2 = 0;
                boolean z2 = (this.c.getWriteImagesInfo() == null || ListUtils.isEmpty(this.c.getWriteImagesInfo().getChosedFiles())) ? false : true;
                boolean z3 = !oi.isEmpty(d5().getText().toString());
                boolean z4 = !oi.isEmpty(c5().getText().toString());
                boolean z5 = !oi.isEmpty(writeData.getTitle());
                boolean z6 = !oi.isEmpty(writeData.getContent());
                boolean z7 = !ListUtils.isEmpty(writeData.getRichContentData());
                this.c.setHaveDraft(true);
                if (this.R0) {
                    boolean isRichTextEditorMode = writeData.isRichTextEditorMode();
                    this.Q0 = isRichTextEditorMode;
                    this.c.setRichTextEditorMode(isRichTextEditorMode);
                    if (this.Q0) {
                        w6();
                        m7();
                    } else {
                        v6();
                    }
                } else {
                    this.Q0 = false;
                    v6();
                }
                if (!z2) {
                    N4(writeData);
                }
                if (!z3 || this.a1 || ((this.e || this.g) && z5)) {
                    M4(writeData);
                }
                if (z6 && (!z4 || this.e || this.g)) {
                    K4(writeData);
                }
                if (z7) {
                    L4(writeData);
                }
                WriteData writeData2 = this.c;
                if (writeData2 != null && !writeData2.getHaveDraft()) {
                    J5();
                }
                if (writeData.getItemInfo() != null) {
                    this.c.setItemInfo(writeData.getItemInfo());
                    this.c.setEvaluationStar(writeData.getEvaluationStar());
                    this.R1 = null;
                    Z5();
                }
                if (writeData.getWriteVoteData() != null) {
                    this.c.setWriteVoteData(writeData.getWriteVoteData());
                    p7();
                }
                if (writeData.getVoiceModel() != null) {
                    m4(writeData.getVoiceModel());
                    P6();
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    r6();
                }
                if (!ListUtils.isEmpty(writeData.getItemDatas()) && !o5() && 10 - h5() == 0) {
                    Iterator<ItemData> it = writeData.getItemDatas().iterator();
                    while (it.hasNext()) {
                        h4(it.next());
                    }
                }
                u4();
                N6();
                w7();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.s0 != null) {
                    xc6 xc6Var = this.t0;
                    this.w0 = xc6Var.b;
                    this.v0 = xc6Var.a;
                    while (true) {
                        if (i2 == this.s0.size()) {
                            break;
                        }
                        xc6 xc6Var2 = this.s0.get(i2);
                        if (categoryTo == xc6Var2.b) {
                            this.w0 = categoryTo;
                            this.v0 = xc6Var2.a;
                            this.c.setCategoryTo(categoryTo);
                            break;
                        }
                        i2++;
                    }
                    PostCategoryView postCategoryView = this.x0;
                    if (postCategoryView != null) {
                        postCategoryView.setText(this.v0);
                        this.x0.setCategoryContainerData(this.s0, this.t0, this.w0);
                    }
                }
                this.S.q();
            }
        } else {
            r6();
            J5();
            m7();
        }
    }

    public final void i4(ImageFileInfo imageFileInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048689, this, imageFileInfo) == null) && this.Q0 && imageFileInfo != null) {
            f6(imageFileInfo);
        }
    }

    public final TextWatcher i5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048690, this)) == null) {
            w0 w0Var = new w0(this);
            if (this.N0 && this.O0) {
                TextWatcher textWatcher = this.L0;
                if (textWatcher != null) {
                    this.I0.removeTextChangedListener(textWatcher);
                }
                this.L0 = w0Var;
            } else if (this.N0) {
                TextWatcher textWatcher2 = this.M0;
                if (textWatcher2 != null) {
                    this.E0.removeTextChangedListener(textWatcher2);
                }
                this.M0 = w0Var;
            }
            return w0Var;
        }
        return (TextWatcher) invokeV.objValue;
    }

    public final boolean i6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048691, this)) == null) {
            return c5().getText() != null && c5().getText().length() >= (this.Z != null ? 1000 : 5000);
        }
        return invokeV.booleanValue;
    }

    public final void i7() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048692, this) == null) || (editorTools = this.S) == null) {
            return;
        }
        editorTools.post(new p(this));
    }

    public final void j4(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048693, this, editable) == null) {
            F4(editable);
            O6(editable);
        }
    }

    public final String j5() {
        InterceptResult invokeV;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048694, this)) == null) {
            if (this.c == null || d5() == null || d5().getVisibility() != 0 || d5().getText() == null) {
                return "";
            }
            String obj = d5().getText().toString();
            PostPrefixData postPrefixData = this.k0;
            if (postPrefixData != null && ListUtils.getCount(postPrefixData.getPrefixs()) > 0 && this.q0 != ListUtils.getCount(this.k0.getPrefixs()) - 1 && this.c.getType() != 4 && (textView = this.m0) != null && textView.getText() != null) {
                this.c.setPostPrefix(this.m0.getText().toString());
            }
            PostPrefixData postPrefixData2 = this.k0;
            if (postPrefixData2 == null || StringUtils.isNull(postPrefixData2.getImplicitTitle())) {
                return obj;
            }
            return this.k0.getImplicitTitle() + this.c.getTitle();
        }
        return (String) invokeV.objValue;
    }

    public final boolean j6(EditText editText) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048695, this, editText)) == null) {
            long X4 = X4(editText);
            if (X4 > 233) {
                return false;
            }
            return X4 > 0 || this.T.size() >= 1;
        }
        return invokeL.booleanValue;
    }

    public final void j7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048696, this) == null) {
            if (this.q1 == null) {
                this.q1 = new jx8(getPageContext());
            }
            this.q1.c(this.S);
        }
    }

    public final void k4(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048697, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        int i2 = -1;
        Editable editable = null;
        if ("from_content".equals(this.a)) {
            this.a = "";
            c5().requestFocus();
            if (c5().getText() != null && c5().getText().length() + str.length() > 5000) {
                showToast(R.string.obfuscated_res_0x7f0f0d13);
                return;
            } else {
                i2 = c5().getSelectionStart();
                editable = c5().getText();
            }
        } else if ("from_title".equals(this.a)) {
            this.a = "";
            d5().requestFocus();
            if (d5().getText() != null && d5().getText().length() + str.length() > 31) {
                showToast(R.string.obfuscated_res_0x7f0f0d13);
                return;
            } else {
                i2 = d5().getSelectionStart();
                editable = d5().getText();
            }
        }
        if (editable == null || i2 < 0 || i2 > editable.length()) {
            return;
        }
        editable.insert(i2, str);
    }

    public final void k5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048698, this) == null) && this.e && this.c != null) {
            this.t.setVisibility(0);
            this.u.setVisibility(0);
            FeedBackModel feedBackModel = new FeedBackModel(getPageContext());
            this.s = feedBackModel;
            feedBackModel.C(this.c.getForumName());
            this.s.setLoadDataCallBack(new t0(this));
        }
    }

    public final boolean k6(EditText editText) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048699, this, editText)) == null) {
            long X4 = X4(editText);
            return X4 <= 20 && X4 > 0;
        }
        return invokeL.booleanValue;
    }

    public final void k7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048700, this) == null) {
            nq4 nq4Var = new nq4(getPageContext().getPageActivity());
            nq4Var.setMessageId(R.string.obfuscated_res_0x7f0f0a51).setPositiveButton(R.string.obfuscated_res_0x7f0f0973, new h(this)).setNegativeButton(R.string.obfuscated_res_0x7f0f0366, new g(this)).create(getPageContext());
            nq4Var.show();
        }
    }

    public final void l4() {
        WriteData writeData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048701, this) == null) || (writeData = this.c) == null || this.C1 == null) {
            return;
        }
        FrsTabInfoData frsTabInfoData = this.E1;
        writeData.setIsForumBusinessAccount(frsTabInfoData == null ? false : frsTabInfoData.isForumBusinessAccount);
        FrsTabItemData selectedTabItemData = this.C1.getSelectedTabItemData();
        if (selectedTabItemData == null) {
            return;
        }
        this.c.setTabId(selectedTabItemData.tabId);
        this.c.setTabName(selectedTabItemData.name);
        this.c.setIsGeneralTab(selectedTabItemData.isGeneralTab);
    }

    public final void l5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048702, this) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
        }
    }

    public final void l6(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048703, this, i2) == null) || this.T == null || this.c == null) {
            return;
        }
        AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(getPageContext().getPageActivity(), this.T.toJsonString(), true, true);
        albumFloatActivityConfig.getIntent().putExtra("forum_id", this.c.getForumId());
        albumFloatActivityConfig.getIntent().putExtra("forum_name", this.c.getForumName());
        albumFloatActivityConfig.getIntent().putExtra("from", this.S0);
        albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
        albumFloatActivityConfig.setAlbumThread(i2);
        albumFloatActivityConfig.setCanSelectVideo(false);
        albumFloatActivityConfig.setCanSelectOnlyVideo(false);
        albumFloatActivityConfig.setCanEditImage(false);
        albumFloatActivityConfig.setFromWrite(3);
        albumFloatActivityConfig.setCallFrom(this.d1);
        albumFloatActivityConfig.setStatisticFrom(this.c.getStatisticFrom());
        albumFloatActivityConfig.setProfessionZone(this.c.getProZone());
        albumFloatActivityConfig.setFrsTabInfo(this.E1);
        AntiData antiData = new AntiData();
        antiData.voice_message = this.R;
        antiData.setIfVoice(this.Q);
        albumFloatActivityConfig.setExtraData(antiData, this.k0, this.c.getFirstDir(), this.c.getSecondDir());
        sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
    }

    public void l7(boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048704, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (z2) {
                if (!this.Q0) {
                    this.A0.g().setVisibility(0);
                    q4(true);
                }
                H6(false);
            } else {
                this.T.clear();
                this.A0.g().setVisibility(8);
                q4(false);
                p5();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001353, Boolean.FALSE));
            }
            N6();
            u4();
        }
    }

    public final void m4(VoiceData.VoiceModel voiceModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048705, this, voiceModel) == null) || voiceModel == null || TextUtils.isEmpty(voiceModel.voiceId) || voiceModel.duration <= 0) {
            return;
        }
        this.d = voiceModel;
        this.c.setVoiceModel(voiceModel);
        this.B.setVisibility(0);
        this.C.setVoiceModel(voiceModel);
        this.C.o();
        N6();
    }

    public final void m5(CharSequence charSequence, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048706, this, charSequence, i2, i3) == null) && this.o1 && charSequence != null && i3 == 1 && i2 < charSequence.length() && i2 >= 0 && charSequence.charAt(i2) == '@') {
            AtListActivityConfig atListActivityConfig = new AtListActivityConfig(getPageContext().getPageActivity(), 12004, true);
            if (this.R0 && this.Q0) {
                atListActivityConfig.setSelectedAtList(this.y.getAtDataInText());
            } else if (c5() instanceof SpanGroupEditText) {
                atListActivityConfig.setSelectedAtList(((SpanGroupEditText) c5()).getAtDataInText());
            }
            sendMessage(new CustomMessage(2002001, atListActivityConfig));
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public final void m6() {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048707, this) == null) || (writeImagesInfo = this.T) == null || this.c == null) {
            return;
        }
        JSONObject json = writeImagesInfo.toJson();
        String str = null;
        if (json != null) {
            try {
                json.put("maxImagesAllowed", 9 - this.T.size());
                json.put("chosedFiles", (Object) null);
                str = json.toString();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(getPageContext().getPageActivity(), str, true, true);
        albumFloatActivityConfig.getIntent().putExtra("forum_id", this.c.getForumId());
        albumFloatActivityConfig.getIntent().putExtra("forum_name", this.c.getForumName());
        albumFloatActivityConfig.getIntent().putExtra("from", this.S0);
        albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
        albumFloatActivityConfig.setAlbumThread(0);
        albumFloatActivityConfig.setCanSelectVideo(false);
        albumFloatActivityConfig.setCanSelectOnlyVideo(false);
        albumFloatActivityConfig.setCanEditImage(false);
        albumFloatActivityConfig.setFromWrite(3);
        albumFloatActivityConfig.setCallFrom(this.d1);
        albumFloatActivityConfig.setStatisticFrom(this.c.getStatisticFrom());
        albumFloatActivityConfig.setProfessionZone(this.c.getProZone());
        albumFloatActivityConfig.setFrsTabInfo(this.E1);
        AntiData antiData = new AntiData();
        antiData.voice_message = this.R;
        antiData.setIfVoice(this.Q);
        albumFloatActivityConfig.setExtraData(antiData, this.k0, this.c.getFirstDir(), this.c.getSecondDir());
        sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
    }

    public final void m7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048708, this) == null) && this.R0 && !ht4.k().h("key_rich_mode_guide_has_show", false)) {
            this.J1.postDelayed(new c0(this), 500L);
            this.J1.postDelayed(new d0(this), 5000L);
        }
    }

    public final void n4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048709, this) == null) && WriteActivityConfig.FROM_FORUM_SHARE.equals(this.S0) && !StringUtils.isNull(this.w1)) {
            if (this.mCurrentPermissionJudgePolicy == null) {
                this.mCurrentPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
            this.mCurrentPermissionJudgePolicy.appendRequestPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mCurrentPermissionJudgePolicy.startRequestPermission(this)) {
                return;
            }
            InsertGalleryAsyncTask insertGalleryAsyncTask = new InsertGalleryAsyncTask(this, this.w1, new h1(this));
            insertGalleryAsyncTask.setFrom(1);
            insertGalleryAsyncTask.execute(new String[0]);
        }
    }

    public final void n5(CharSequence charSequence, int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048710, this, new Object[]{charSequence, Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) || this.b1 || !this.o1 || charSequence == null || i3 != 1 || i2 >= charSequence.length() || i2 < 0) {
            return;
        }
        this.b = false;
        this.a = "";
        if ("from_content".equals(str)) {
            this.a = "from_content";
        } else if ("from_title".equals(str)) {
            this.a = "from_title";
        }
        if (fc5.f(String.valueOf(charSequence.charAt(i2)))) {
            A6(false);
        }
    }

    public final void n6(int i2) {
        WriteImagesInfo writeImagesInfo;
        int size;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048711, this, i2) == null) || (writeImagesInfo = this.T) == null || writeImagesInfo.getChosedFiles() == null || (size = this.T.getChosedFiles().size()) < 1 || i2 < 0 || i2 >= size) {
            return;
        }
        sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.T, i2)));
    }

    public final void n7(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048712, this, z2, postWriteCallBackData) == null) || postWriteCallBackData == null) {
            return;
        }
        String errorString = postWriteCallBackData.getErrorString();
        if (AntiHelper.m(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
            if (AntiHelper.w(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.r2) != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_WRITE));
            }
        } else if (postWriteCallBackData.getErrorCode() != 0) {
            if (postWriteCallBackData.getErrorCode() == 230278) {
                return;
            }
            String errorString2 = postWriteCallBackData.getErrorString();
            if (TextUtils.isEmpty(errorString2)) {
                errorString2 = getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f102c);
            }
            showToast(errorString2);
        } else if (this.c.getType() != 7) {
            if (this.Z == null) {
                uj8.b(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                return;
            }
            h7(z2, errorString);
        }
    }

    public final boolean o4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048713, this)) == null) ? ListUtils.isEmpty(this.c.getItemDatas()) && this.c.getVoiceModel() == null && this.c.getVideoInfo() == null && this.c.getWriteVoteData() == null && TextUtils.isEmpty(this.r.getText()) && (!this.Q0 || this.y.t()) && (this.T.getChosedFiles() == null || this.T.size() == 0) : invokeV.booleanValue;
    }

    public final boolean o5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048714, this)) == null) {
            ux8 ux8Var = this.H1;
            return (ux8Var == null || this.I1 == null || ux8Var.c() == null || this.I1.getVisibility() != 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void o6(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048715, this, i2) == null) || this.T == null || this.c == null) {
            return;
        }
        AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(getPageContext().getPageActivity(), this.T.toJsonString(), true, true);
        albumFloatActivityConfig.getIntent().putExtra("forum_id", this.c.getForumId());
        albumFloatActivityConfig.getIntent().putExtra("forum_name", this.c.getForumName());
        albumFloatActivityConfig.getIntent().putExtra("from", this.S0);
        albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
        albumFloatActivityConfig.setAlbumThread(i2);
        albumFloatActivityConfig.setCanSelectVideo(true);
        albumFloatActivityConfig.setCanSelectOnlyVideo(true);
        albumFloatActivityConfig.setCanEditImage(false);
        albumFloatActivityConfig.setFromWrite(3);
        albumFloatActivityConfig.setCallFrom(this.d1);
        albumFloatActivityConfig.setStatisticFrom(this.c.getStatisticFrom());
        albumFloatActivityConfig.setProfessionZone(this.c.getProZone());
        albumFloatActivityConfig.setFrsTabInfo(this.E1);
        if (this.k.getText().toString() != null) {
            albumFloatActivityConfig.setVideoTitle(this.k.getText().toString());
        } else {
            albumFloatActivityConfig.setVideoTitle(this.b2);
        }
        albumFloatActivityConfig.setBarName(this.c.getForumName());
        albumFloatActivityConfig.setBarID(this.c.getForumId());
        if (this.z1 == null && this.c.getForumName() != null) {
            albumFloatActivityConfig.setCanChangeBarName(false);
        } else {
            albumFloatActivityConfig.setCanChangeBarName(true);
        }
        albumFloatActivityConfig.setVideoAbstract(this.r.getText().toString());
        AntiData antiData = new AntiData();
        antiData.voice_message = this.R;
        antiData.setIfVoice(this.Q);
        albumFloatActivityConfig.setExtraData(antiData, this.k0, this.c.getFirstDir(), this.c.getSecondDir());
        sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
    }

    public final void o7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048716, this) == null) {
            EBusinessProtocolView eBusinessProtocolView = new EBusinessProtocolView(this, EBusinessProtocolView.WindowType.TIP);
            eBusinessProtocolView.o(getResources().getString(R.string.obfuscated_res_0x7f0f1429));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f1416)).append((CharSequence) "\n");
            spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f1417)).append((CharSequence) "\n");
            spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f1418)).append((CharSequence) "\n");
            spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f1419)).append((CharSequence) "\n");
            spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f141a));
            eBusinessProtocolView.k(spannableStringBuilder);
            sg.i(eBusinessProtocolView, this);
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
        if (interceptable == null || interceptable.invokeIIL(1048717, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1) {
                if (i2 != 25068) {
                    PostWriteCallBackData postWriteCallBackData2 = null;
                    postWriteCallBackData2 = null;
                    postWriteCallBackData2 = null;
                    if (i2 == 12004) {
                        if (this.k == getCurrentFocus()) {
                            c5().clearFocus();
                            this.k.requestFocus();
                            EditorTools editorTools = this.S;
                            if (editorTools != null) {
                                editorTools.q();
                            }
                            ShowSoftKeyPadDelay(this.k);
                        } else {
                            c5().requestFocus();
                            EditorTools editorTools2 = this.S;
                            if (editorTools2 != null) {
                                editorTools2.q();
                            }
                            ShowSoftKeyPadDelay(this.r);
                        }
                        ArrayList parcelableArrayListExtra = intent != null ? intent.getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA) : null;
                        int selectionStart = c5().getSelectionStart();
                        if (selectionStart > 0) {
                            int i5 = selectionStart - 1;
                            if (c5().getText().toString().charAt(i5) == '@') {
                                c5().getEditableText().delete(i5, selectionStart);
                            }
                        }
                        if (this.R0 && this.Q0) {
                            this.y.k(parcelableArrayListExtra);
                        } else if (c5() instanceof SpanGroupEditText) {
                            ((SpanGroupEditText) c5()).e(parcelableArrayListExtra);
                        }
                        if (parcelableArrayListExtra != null && parcelableArrayListExtra.size() > 0) {
                            c5().getText().delete(c5().getSelectionStart(), c5().getSelectionEnd());
                            if (this.R0 && this.Q0) {
                                this.y.g(parcelableArrayListExtra);
                            } else if (c5() instanceof SpanGroupEditText) {
                                ((SpanGroupEditText) c5()).b(parcelableArrayListExtra);
                            }
                        }
                    } else if (i2 == 12006) {
                        if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) {
                            postWriteCallBackData2 = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                        }
                        A4();
                        a7(postWriteCallBackData2);
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
                                    D4();
                                } else {
                                    B4(intent);
                                }
                            } else if (intExtra == 1) {
                                E4(intent);
                            } else {
                                C4(intent);
                                qg.a().post(new e1(this));
                            }
                            l7(ListUtils.getCount(this.T.getChosedFiles()) > 0, false);
                            if (this.n1) {
                                H6(true);
                                this.n1 = false;
                            }
                        } else if (i2 == 12012) {
                            if (this.Q0) {
                                W4(intent);
                            } else if (!this.N0) {
                                a5(intent);
                                N6();
                            } else {
                                P4(intent);
                            }
                        } else if (i2 == 13010) {
                            VideoInfo videoInfo = new VideoInfo();
                            videoInfo.parseFromIntent(intent);
                            if (videoInfo.isAvaliable()) {
                                this.c.setVideoInfo(videoInfo);
                                this.S.A(new h05(2, 19, " "));
                                this.S.A(new h05(28, 20, videoInfo));
                            } else {
                                this.S.A(new h05(5, -1, null));
                            }
                            N6();
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
                            if (this.b) {
                                sb.append("#");
                                this.b = false;
                            }
                            sb.append(stringExtra);
                            k4(sb.toString());
                        } else if (i2 != 25005 || intent == null || ListUtils.isEmpty(this.i1)) {
                            if (i2 == 25048) {
                                if (intent == null) {
                                    return;
                                }
                                Serializable serializableExtra = intent.getSerializableExtra(IntentConfig.WRITE_VOTE_DATA);
                                if (serializableExtra instanceof WriteVoteData) {
                                    this.Y1 = serializableExtra;
                                    p7();
                                }
                            } else if (i2 == 25049 && intent != null) {
                                String str2 = intent.getStringExtra(AddLinkActivityConfig.NEW_LINK_CONTENT) + " ";
                                int selectionStart2 = this.r.getSelectionStart();
                                int selectionEnd = this.r.getSelectionEnd();
                                if (selectionStart2 >= 0) {
                                    Editable text = this.r.getText();
                                    if (selectionEnd > selectionStart2) {
                                        text.replace(selectionStart2, selectionEnd, str2);
                                    } else {
                                        text.insert(selectionStart2, str2);
                                    }
                                }
                            } else if (i2 == 25064) {
                                if (rv8.b()) {
                                    if (this.T == null || this.c == null) {
                                        return;
                                    }
                                    if (this.k.getText().toString() != null) {
                                        str = this.k.getText().toString();
                                        i4 = 5;
                                    } else {
                                        str = this.b2;
                                        i4 = 1;
                                    }
                                    if (this.z1 == null && this.c.getForumName() != null) {
                                        rv8.f(getPageContext(), str, this.r.getText().toString(), this.c.getForumId(), this.c.getForumName(), 3, Boolean.FALSE, "", "", "");
                                    } else {
                                        rv8.f(getPageContext(), str, this.r.getText().toString(), this.c.getForumId(), this.c.getForumName(), i4, Boolean.TRUE, "", "", "");
                                    }
                                } else {
                                    o6(0);
                                }
                            }
                        } else if (ListUtils.isEmpty(this.i1) || intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) >= this.i1.size()) {
                            return;
                        } else {
                            HotTopicBussinessData hotTopicBussinessData = this.i1.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                            this.j1 = hotTopicBussinessData;
                            r4(hotTopicBussinessData);
                        }
                    }
                } else if (!this.b1 || intent == null || (localChannelTopicSelectView = this.x1) == null || localChannelTopicSelectView.getVisibility() != 0) {
                    return;
                } else {
                    String stringExtra2 = intent.getStringExtra(LocalChannelTopicListActivityConfig.KEY_RESPONSE_TOPIC);
                    this.c1 = stringExtra2;
                    this.x1.setLocalChannelTopic(stringExtra2);
                }
            } else if (i3 == 0) {
                EditorTools editorTools3 = this.S;
                if (editorTools3 != null && !editorTools3.u()) {
                    this.r.requestFocus();
                    this.j.toggleSoftInput(0, 2);
                    this.S.q();
                }
                if (i2 == 12001) {
                    H4();
                } else if (i2 == 12002) {
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.T.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    y7();
                    if (this.n1) {
                        H6(true);
                        this.n1 = false;
                    }
                } else if (i2 != 12004) {
                    if (i2 != 12006) {
                        if (i2 == 12010) {
                            this.U = String.valueOf(System.currentTimeMillis());
                            SelectImageHelper.takePhoto(getPageContext(), this.U);
                        } else if (i2 == 12012) {
                            y7();
                        } else if (i2 == 25004) {
                            if ("from_title".equals(this.a)) {
                                d5().requestFocus();
                            } else if ("from_content".equals(this.a)) {
                                c5().requestFocus();
                            }
                        }
                    } else if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.p1.n(postWriteCallBackData.getErrorString());
                        this.p1.m(postWriteCallBackData.getSensitiveWords());
                        this.p1.h(this.k, this.r);
                    }
                } else if (this.k == getCurrentFocus()) {
                    c5().clearFocus();
                    this.k.requestFocus();
                    EditorTools editorTools4 = this.S;
                    if (editorTools4 != null) {
                        editorTools4.q();
                    }
                    ShowSoftKeyPadDelay(this.k);
                } else {
                    c5().requestFocus();
                    EditorTools editorTools5 = this.S;
                    if (editorTools5 != null) {
                        editorTools5.q();
                    }
                    ShowSoftKeyPadDelay(this.r);
                }
            }
            u4();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048718, this, i2) == null) {
            super.onChangeSkinType(i2);
            getLayoutMode().k(i2 == 1);
            getLayoutMode().j(this.O);
            getLayoutMode().j(this.X0);
            SkinManager.setBackgroundColor(this.O, R.color.CAM_X0205);
            if (this.U0 != null && (i2 == 1 || i2 == 4)) {
                this.U0.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
            }
            RichTextEditor richTextEditor = this.y;
            if (richTextEditor != null) {
                richTextEditor.v();
            }
            this.E.onChangeSkinType(getPageContext(), i2);
            if (this.E.getBackImageView() != null) {
                this.E.getBackImageView().setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809c6, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            }
            this.G.setTextColor(SkinManager.getColorStateListWithClickAndDisableState(R.color.CAM_X0302, i2));
            u4();
            SkinManager.setViewTextColor(this.N1, (int) R.color.CAM_X0303);
            SkinManager.setViewTextColor(this.O1, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.P1, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.Q1, (int) R.color.CAM_X0101);
            SkinManager.setBackgroundResource(this.M1, R.drawable.obfuscated_res_0x7f080fd0);
            SkinManager.setBackgroundColor(this.m, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.G0, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(d5(), R.color.CAM_X0205);
            this.D.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08091a, SkinManager.getColor(R.color.CAM_X0107), null));
            this.C.e();
            if (TextUtils.isEmpty(this.z)) {
                if (this.N0) {
                    SkinManager.setBackgroundColor(this.E0, R.color.CAM_X0205);
                } else {
                    SkinManager.setBackgroundColor(this.x, R.color.CAM_X0205);
                }
            }
            N6();
            this.S.w(i2);
            PostCategoryView postCategoryView = this.x0;
            if (postCategoryView != null) {
                postCategoryView.b();
            }
            gx8 gx8Var = this.f2;
            if (gx8Var != null) {
                gx8Var.notifyDataSetChanged();
            }
            SkinManager.setViewTextColor(this.H, (int) R.color.CAM_X0105);
            this.A0.d.notifyDataSetChanged();
            B7();
            C7();
            H6(false);
            fx8 fx8Var = this.p1;
            if (fx8Var != null) {
                fx8Var.l(d5(), c5());
            }
            LocalChannelTopicSelectView localChannelTopicSelectView = this.x1;
            if (localChannelTopicSelectView != null) {
                localChannelTopicSelectView.b();
            }
            ForumSelectedView forumSelectedView = this.y1;
            if (forumSelectedView != null) {
                forumSelectedView.c();
            }
            WriteEvaluationHeaderView writeEvaluationHeaderView = this.A1;
            if (writeEvaluationHeaderView != null) {
                writeEvaluationHeaderView.f();
            }
            ForumTabSelectedView forumTabSelectedView = this.C1;
            if (forumTabSelectedView != null) {
                forumTabSelectedView.m(i2);
            }
            ux8 ux8Var = this.H1;
            if (ux8Var != null) {
                ux8Var.d(i2);
            }
            EBusinessProtocolView eBusinessProtocolView = this.k2;
            if (eBusinessProtocolView != null) {
                eBusinessProtocolView.j(i2);
            }
            TextView textView = this.B1;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0301);
            }
            AssociatedItemContainer associatedItemContainer = this.d2;
            if (associatedItemContainer != null) {
                associatedItemContainer.c();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048719, this, bundle) == null) {
            if (bundle != null) {
                this.b1 = bundle.getBoolean(WriteActivityConfig.KEY_POST_LOCAL_CHANNEL_DYNAMIC);
                this.c1 = bundle.getString(WriteActivityConfig.KEY_LOCAL_CHANNEL_TOPIC);
            } else if (getIntent() != null) {
                Intent intent = getIntent();
                this.b1 = intent.getBooleanExtra(WriteActivityConfig.KEY_POST_LOCAL_CHANNEL_DYNAMIC, false);
                this.c1 = intent.getStringExtra(WriteActivityConfig.KEY_LOCAL_CHANNEL_TOPIC);
            }
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            this.r0 = new GestureDetector(getPageContext().getPageActivity(), new r1(this, null));
            this.j = (InputMethodManager) getSystemService("input_method");
            G5();
            z5(bundle);
            if (this.a2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921583));
            }
            if (this.c.getType() == 0) {
                l6(this.e1);
            }
            X5();
            k5();
            LocationModel locationModel = new LocationModel(getPageContext());
            this.W = locationModel;
            locationModel.R(this.x2);
            R6();
            A5();
            Q5();
            if (this.N0) {
                this.C0.m(this.S);
            } else {
                this.r.requestFocus();
            }
            V5();
            Z6();
            n4();
            this.G2.setPriority(1);
            registerResponsedEventListener(GoodsEvent.class, this.G2);
            M5();
            if (this.W1) {
                K4(this.c);
                N6();
                E5();
            }
            q6();
        }
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048720, this, i2)) == null) {
            xs8 xs8Var = new xs8(getPageContext().getPageActivity(), new p0(this), new Date().getHours(), new Date().getMinutes(), false);
            this.L2 = xs8Var;
            xs8Var.setTitle(R.string.obfuscated_res_0x7f0f0c55);
            this.L2.setButton(-1, getPageContext().getString(R.string.obfuscated_res_0x7f0f0260), this.L2);
            this.L2.setButton(-2, getPageContext().getString(R.string.obfuscated_res_0x7f0f0366), this.L2);
            return this.L2;
        }
        return (Dialog) invokeI.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048721, this) == null) {
            this.E.removeCallbacks(this.N2);
            oj8 oj8Var = this.V;
            if (oj8Var != null) {
                oj8Var.t();
            }
            r5();
            q5();
            TiebaPrepareImageService.StopService();
            t7(true);
            if (!this.H2) {
                E6();
            }
            sg.a(this.F1, this);
            super.onDestroy();
            u0().onDestory(getPageContext());
            this.L.removeCallbacksAndMessages(null);
            lx8 lx8Var = this.A0;
            if (lx8Var != null) {
                lx8Var.f();
            }
            zy5 zy5Var = this.r1;
            if (zy5Var != null) {
                zy5Var.I();
            }
            MessageManager.getInstance().unRegisterTask(2921500);
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048722, this) == null) {
            this.p0.setSelected(false);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.o0, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, null);
            ShowSoftKeyPadDelay(this.r);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Editable text;
        int selectionStart;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048723, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                qv8 qv8Var = this.n0;
                if (qv8Var != null && qv8Var.isShowing()) {
                    sg.d(this.n0, getPageContext().getPageActivity());
                    return true;
                } else if (this.S.u()) {
                    this.S.q();
                    return true;
                } else if (this.J1.getVisibility() == 0) {
                    this.J1.performClick();
                    return true;
                } else {
                    s7();
                    B6();
                    return true;
                }
            }
            if (i2 == 67 && (text = c5().getText()) != null && (selectionStart = c5().getSelectionStart() - 1) > 0 && selectionStart < text.length() && text.charAt(selectionStart) == 0) {
                c5().onKeyDown(67, this.A);
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048724, this, i2) == null) {
            super.onKeyboardHeightChanged(i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048725, this, z2) == null) {
            this.o1 = z2;
            if (this.Y0 && System.currentTimeMillis() - this.Z0 < 800) {
                pi.x(getPageContext().getPageActivity(), getCurrentFocus());
                this.Y0 = false;
            }
            hw8 hw8Var = this.m1;
            if (hw8Var != null && !z2) {
                hw8Var.h();
            }
            if (this.q1 != null && !z2) {
                r5();
            }
            if (this.t1 == null || z2) {
                return;
            }
            q5();
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
            if (this.Q0) {
                S4(intent);
                return;
            }
            String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            if (stringExtra == null || (writeImagesInfo = this.T) == null) {
                return;
            }
            writeImagesInfo.parseJson(stringExtra);
            this.T.updateQuality();
            if (this.T.getChosedFiles() != null) {
                Z6();
            }
            M6(true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048727, this) == null) {
            HidenSoftKeyPad(this.j, d5());
            HidenSoftKeyPad(this.j, c5());
            super.onPause();
            u0().onPause(getPageContext());
            if (this.S.u()) {
                this.S.q();
            }
        }
    }

    @Override // android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048728, this, i2, dialog) == null) {
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    @SuppressLint({"NewApi"})
    @TargetApi(23)
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048729, this, i2, strArr, iArr) == null) {
            if (i2 == 0) {
                super.onRequestPermissionsResult(i2, strArr, iArr);
                u6();
            } else if (i2 == 1) {
                ArrayMap<String, Boolean> transformPermissionResult = PermissionUtil.transformPermissionResult(strArr, iArr);
                if (PermissionUtil.checkCamera(getApplicationContext())) {
                    SelectImageHelper.takePhoto(getPageContext(), this.U);
                } else {
                    showToast(R.string.obfuscated_res_0x7f0f135a);
                }
                if (!transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") || transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                    return;
                }
                showToast(R.string.obfuscated_res_0x7f0f10b0);
            } else {
                super.onRequestPermissionsResult(i2, strArr, iArr);
            }
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048730, this, bundle) == null) {
            super.onRestoreInstanceState(bundle);
            String obj = c5().getEditableText().toString();
            if (obj != null) {
                c5().setText(TbFaceManager.i().t(getPageContext().getPageActivity(), obj, this.q2));
                c5().setSelection(c5().getText().length());
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048731, this) == null) {
            super.onResume();
            u0().onResume(getPageContext());
            if (this.N0) {
                this.k.setVisibility(8);
                if (this.c.getType() == 5) {
                    this.H0.setVisibility(8);
                } else {
                    this.H0.setVisibility(0);
                }
                c7(this.K0, this.E0);
                c7(this.J0, this.I0);
                N6();
            }
            if (this.e) {
                this.E2 = true;
                u4();
                EditorTools editorTools = this.S;
                if (editorTools != null) {
                    editorTools.q();
                }
                this.k.requestFocus();
                ShowSoftKeyPadDelay(this.k);
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048732, this, bundle) == null) {
            bundle.putInt("type", this.c.getType());
            bundle.putString("forum_id", this.c.getForumId());
            bundle.putString("forum_name", this.c.getForumName());
            bundle.putString(IntentConfig.FORUM_FIRST_DIR, this.c.getFirstDir());
            bundle.putString(IntentConfig.FORUM_SECOND_DIR, this.c.getSecondDir());
            bundle.putString("thread_id", this.c.getThreadId());
            bundle.putString(WriteActivityConfig.FLOOR_ID, this.c.getFloor());
            bundle.putInt("floor_num", this.c.getFloorNum());
            bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.M);
            if (this.e) {
                bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
            }
            WriteImagesInfo writeImagesInfo = this.T;
            if (writeImagesInfo != null) {
                bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", writeImagesInfo.toJsonString());
            }
            bundle.putString(WriteActivityConfig.PHOTO_NAME, this.U);
            AdditionData additionData = this.Z;
            if (additionData != null) {
                bundle.putString("addition_data", OrmObject.jsonStrWithObject(additionData));
            }
            PostPrefixData postPrefixData = this.k0;
            if (postPrefixData != null) {
                bundle.putString("prefix_data", OrmObject.jsonStrWithObject(postPrefixData));
            }
            PostTopicData postTopicData = this.l0;
            if (postTopicData != null) {
                bundle.putString("hot_topic", OrmObject.jsonStrWithObject(postTopicData));
            }
            bundle.putString("from", this.S0);
            bundle.putString("KEY_CALL_FROM", this.d1);
            bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.e1);
            bundle.putInt("private_thread", this.i);
            bundle.putSerializable("tab_list", this.E1);
            bundle.putBoolean(WriteActivityConfig.CAN_GOODS, this.g1);
            bundle.putBoolean(WriteActivityConfig.NEED_CLOSE_PRE_PAGE, this.a2);
            bundle.putInt(WriteActivityConfig.KEY_STATISTIS_FROM, this.c.getStatisticFrom());
            super.onSaveInstanceState(bundle);
            u0().onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048733, this) == null) {
            super.onStart();
            u0().onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048734, this) == null) {
            super.onStop();
            u0().onStop(getPageContext());
            getWindow().setSoftInputMode(18);
        }
    }

    public final boolean p4(WriteData writeData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048735, this, writeData)) == null) ? writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom())) : invokeL.booleanValue;
    }

    public final void p5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048736, this) == null) {
            View view2 = this.N0 ? this.E0 : this.x;
            view2.setPadding(0, 0, 0, 0);
            view2.setBackgroundDrawable(null);
            SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
        }
    }

    public final void p6(WriteVoteData writeVoteData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048737, this, writeVoteData) == null) {
            WriteVoteActivityConfig writeVoteActivityConfig = new WriteVoteActivityConfig(getPageContext().getPageActivity(), 25048);
            if (writeVoteData != null) {
                writeVoteActivityConfig.setExtraData(writeVoteData);
            }
            sendMessage(new CustomMessage(2002001, writeVoteActivityConfig));
        }
    }

    public final void p7() {
        WriteVoteData writeVoteData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048738, this) == null) {
            Serializable serializable = this.Y1;
            if (serializable instanceof WriteVoteData) {
                writeVoteData = (WriteVoteData) serializable;
                this.c.setWriteVoteData(writeVoteData);
            } else if (this.c.getWriteVoteData() == null) {
                return;
            } else {
                writeVoteData = this.c.getWriteVoteData();
            }
            r rVar = new r(this, writeVoteData);
            this.H1.f(rVar);
            this.H1.e(rVar);
            this.H1.g(writeVoteData);
            this.H1.h(true);
            N6();
        }
    }

    public void q4(boolean z2) {
        AssociatedItemContainer associatedItemContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048739, this, z2) == null) || (associatedItemContainer = this.d2) == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) associatedItemContainer.getLayoutParams();
        if (z2) {
            layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.M_H_X004);
        } else {
            layoutParams.topMargin = 0;
        }
        this.d2.setLayoutParams(layoutParams);
    }

    public final void q5() {
        ex8 ex8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048740, this) == null) || (ex8Var = this.t1) == null) {
            return;
        }
        ex8Var.a();
    }

    public final void q6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048741, this) == null) {
            if (this.c.getType() != 0 && this.c.getType() != 9 && this.c.getType() != 11) {
                if (this.c.getType() == 7) {
                    if (this.V1) {
                        wg8.j("24591571", this);
                    }
                } else if (this.c.getType() == 1) {
                    wg8.n(this.c.getThreadId(), this);
                } else if (this.c.getType() == 4) {
                    wg8.j(this.c.getForumId() + "photolive", this);
                } else if (this.c.getType() == 5) {
                    wg8.n(this.c.getThreadId() + "updatephotolive", this);
                }
            } else if (this.V1) {
                if (this.c.isLocalChannelDynamic()) {
                    wg8.k(this);
                } else if (this.c.isEvaluate()) {
                    wg8.i(this.c.getItem_id(), this);
                } else if (TextUtils.isEmpty(this.c.getTopicId())) {
                    wg8.j(this.c.getForumId(), this);
                } else {
                    wg8.p(this.c.getTopicId(), this);
                }
            }
        }
    }

    public final void q7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048742, this) == null) {
            this.V.I();
            tw8.e(this.c);
            u7();
            E6();
            if (PersonPolymericActivityConfig.VIDEO_PERSON_FROM_TOPIC_DETAIL.equals(this.S0)) {
                setResult(-1);
            } else {
                setResult(100);
            }
            finish();
        }
    }

    public final void r4(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048743, this, hotTopicBussinessData) == null) || hotTopicBussinessData == null || (hotTopicBussinessData2 = (HotTopicBussinessData) ListUtils.getItem(this.i1, 0)) == null || TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            return;
        }
        SpannableString i2 = fc5.i(fc5.a(hotTopicBussinessData.mTopicName));
        if (i2 != null) {
            this.k.setText(i2);
        }
        this.k1.setText(hotTopicBussinessData.mForumName);
    }

    public final void r5() {
        jx8 jx8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048744, this) == null) || (jx8Var = this.q1) == null) {
            return;
        }
        jx8Var.b();
    }

    public final void r6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048745, this) == null) {
            if ((this.N0 && this.C0 == null) || this.B0 == null) {
                return;
            }
            this.C0.l(this.T);
            z7();
        }
    }

    public void r7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048746, this) == null) {
            if (!this.W.H(getPageContext().getPageActivity())) {
                showToast(R.string.obfuscated_res_0x7f0f0a58);
                Y6(0, true, null);
                hw8 hw8Var = this.m1;
                if (hw8Var != null) {
                    hw8Var.g();
                }
            } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
                k7();
            } else {
                LocationModel locationModel = this.W;
                if (locationModel == null) {
                    return;
                }
                locationModel.Q(false);
                Y6(1, true, null);
                this.W.L();
            }
        }
    }

    public final void s4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048747, this, i2) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CHANGE_RICH_TEXT_MODE);
            statisticItem.param("obj_type", i2);
            TiebaStatic.log(statisticItem);
            if (i2 == 0) {
                TiebaStatic.log(CommonStatisticKey.KEY_LIMIT_MODE_CHANGE_TOAST);
            }
        }
    }

    public final void s5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048748, this) == null) {
            ImageView imageView = this.K;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            TextView textView = this.H;
            if (textView != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
                layoutParams.rightMargin = this.K2;
                this.H.setLayoutParams(layoutParams);
            }
        }
    }

    public void s6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048749, this) == null) {
            if (!x4()) {
                BdToast.i(this, getString(R.string.obfuscated_res_0x7f0f0ec9), R.drawable.obfuscated_res_0x7f0809b5, true).n();
            } else if (!this.g1) {
                BdToast.i(this, getString(R.string.obfuscated_res_0x7f0f0eca), R.drawable.obfuscated_res_0x7f0809b5, true).n();
            } else {
                if (this.c != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_COMMODITY_ENTRANCE_CLICK).param("obj_locate", 2).param("fid", this.c.getForumId()).param("fname", this.c.getForumName()));
                }
                if (!ht4.k().h("commodity_goods_show_first_dialog", false)) {
                    nq4 nq4Var = new nq4(getPageContext().getPageActivity());
                    nq4Var.setContentViewSize(2);
                    nq4Var.setCanceledOnTouchOutside(false);
                    FrsPublishFineGoodsDialogView frsPublishFineGoodsDialogView = new FrsPublishFineGoodsDialogView(getPageContext().getPageActivity());
                    frsPublishFineGoodsDialogView.setConfirmButtonListener(new l1(this, nq4Var));
                    nq4Var.setContentView(frsPublishFineGoodsDialogView);
                    StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_WRITE_GOODS_NEW_DIALOG_SHOW).param("obj_locate", 2);
                    WriteData writeData = this.c;
                    StatisticItem param2 = param.param("fid", writeData != null ? writeData.getForumId() : "");
                    WriteData writeData2 = this.c;
                    TiebaStatic.log(param2.param("fname", writeData2 != null ? writeData2.getForumName() : ""));
                    nq4Var.create(getPageContext()).show();
                    return;
                }
                String uk = TbadkCoreApplication.getCurrentAccountInfo().getUk();
                MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + uk + "&max=" + h5()));
            }
        }
    }

    public void s7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048750, this) == null) {
            t7(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048751, this, str, onCancelListener) == null) {
            this.P0.e(null);
            this.P0.i(R.string.obfuscated_res_0x7f0f1125);
            this.P0.h(true);
        }
    }

    public final void t4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048752, this) == null) {
            if (o4()) {
                if (this.Q0) {
                    v6();
                    s4(1);
                } else {
                    w6();
                    s4(2);
                }
                this.Q0 = !this.Q0;
                m7();
                M6(true);
                return;
            }
            BdTopToast bdTopToast = new BdTopToast(this);
            bdTopToast.i(false);
            bdTopToast.h(getResources().getString(R.string.obfuscated_res_0x7f0f0516));
            bdTopToast.j((ViewGroup) this.z0);
            s4(0);
        }
    }

    public final void t5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048753, this) == null) {
            this.g0 = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090122);
            this.h0 = (TextView) findViewById(R.id.obfuscated_res_0x7f090123);
            this.i0 = (TextView) findViewById(R.id.obfuscated_res_0x7f090127);
            this.j0 = (TextView) findViewById(R.id.obfuscated_res_0x7f090126);
            if (this.Z != null) {
                this.g0.setVisibility(0);
                TextView textView = this.h0;
                textView.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f15cb) + StringHelper.getFormatTime(this.Z.getCreateTime() * 1000));
                if (this.Z.getAlreadyCount() == 0) {
                    this.i0.setVisibility(8);
                } else {
                    TextView textView2 = this.i0;
                    textView2.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f15cd) + StringHelper.getFormatTime(this.Z.getLastAdditionTime() * 1000));
                }
                String lastAdditionContent = this.Z.getLastAdditionContent();
                if (!TextUtils.isEmpty(lastAdditionContent)) {
                    this.j0.setText(lastAdditionContent);
                } else {
                    this.j0.setVisibility(8);
                }
                c5().setHint(String.format(getPageContext().getString(R.string.obfuscated_res_0x7f0f15cc), Integer.valueOf(this.Z.getAlreadyCount()), Integer.valueOf(this.Z.getTotalCount())));
                this.H.setText(R.string.obfuscated_res_0x7f0f15cf);
                return;
            }
            this.g0.setVisibility(8);
        }
    }

    public final void t6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048754, this) == null) {
            if (!this.c.canAddItem()) {
                pi.N(getActivity(), R.string.obfuscated_res_0x7f0f15f4);
                return;
            }
            RelevanceItemSearchActivityConfig relevanceItemSearchActivityConfig = new RelevanceItemSearchActivityConfig(getActivity(), 0);
            relevanceItemSearchActivityConfig.setSelectedIds(this.c.getItemDataIds());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, relevanceItemSearchActivityConfig));
        }
    }

    public void t7(boolean z2) {
        oj8 oj8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048755, this, z2) == null) {
            if (!z2 && (oj8Var = this.V) != null) {
                oj8Var.d();
            }
            FeedBackModel feedBackModel = this.s;
            if (feedBackModel != null) {
                feedBackModel.cancelLoadData();
            }
            LocationModel locationModel = this.W;
            if (locationModel != null) {
                locationModel.cancelLoadData();
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public synchronized VoiceManager u0() {
        InterceptResult invokeV;
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048756, this)) == null) {
            synchronized (this) {
                if (this.X == null) {
                    this.X = VoiceManager.instance();
                }
                voiceManager = this.X;
            }
            return voiceManager;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public void u4() {
        EditorTools editorTools;
        i15 i15Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048757, this) == null) || (editorTools = this.S) == null) {
            return;
        }
        editorTools.setBarLauncherEnabled(!this.E2);
        this.S.setDeskLauncherEnabled(!this.E2);
        this.S.setToolEnabled(true, 26);
        this.S.setToolEnabled(true, 2);
        this.S.setToolEnabled(true, 30);
        this.S.setToolEnabled(false, 34);
        if (this.b1) {
            this.S.setToolEnabled(false, 31);
        }
        t05 n2 = this.S.n(5);
        if (n2 != null) {
            n2.d(true);
        }
        hw8 hw8Var = this.m1;
        if (hw8Var != null && !this.b1) {
            hw8Var.n(true);
        }
        J6();
        P6();
        K6();
        I6();
        Q6();
        if (this.S1 && (i15Var = this.v2) != null && !i15Var.c()) {
            this.S.setToolEnabled(false, 31);
        } else {
            this.S.setToolEnabled(!this.Q0, 31);
        }
        this.S.setToolEnabled(!this.Q0, 6);
    }

    public final void u5() {
        WriteImagesInfo writeImagesInfo;
        LinkedList<ImageFileInfo> chosedFiles;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048758, this) == null) || (writeImagesInfo = this.T) == null || writeImagesInfo.size() <= 0 || (chosedFiles = this.T.getChosedFiles()) == null) {
            return;
        }
        for (ImageFileInfo imageFileInfo : chosedFiles) {
            if (imageFileInfo != null) {
                f6(imageFileInfo);
            }
        }
    }

    public void u6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048759, this) == null) {
            if (!this.W.H(getPageContext().getPageActivity())) {
                showToast(R.string.obfuscated_res_0x7f0f0a58);
                Y6(0, true, null);
            } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
                k7();
            } else if (this.W.G()) {
                l5();
            } else {
                this.W.Q(false);
                Y6(1, true, null);
                this.W.L();
            }
        }
    }

    public final synchronized void u7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048760, this) == null) {
            synchronized (this) {
                VoiceManager u02 = u0();
                this.X = u02;
                u02.stopPlay();
            }
        }
    }

    public final boolean v4() {
        InterceptResult invokeV;
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048761, this)) == null) ? this.g1 || (spanGroupEditText = this.r) == null || spanGroupEditText.getSpanGroupManager() == null || this.r.getSpanGroupManager().x() <= 0 : invokeV.booleanValue;
    }

    public final void v5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048762, this) == null) {
            AssociatedItemContainer associatedItemContainer = (AssociatedItemContainer) findViewById(R.id.obfuscated_res_0x7f0902ac);
            this.d2 = associatedItemContainer;
            associatedItemContainer.setOnDeletedListener(new e0(this));
            this.d2.setOnAddedListener(new f0(this));
        }
    }

    public final void v6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048763, this) == null) {
            this.r.setVisibility(0);
            this.y.setVisibility(8);
            lx8 lx8Var = this.A0;
            if (lx8Var != null) {
                lx8Var.h(false);
            }
        }
    }

    public void v7(WriteVoteData writeVoteData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048764, this, writeVoteData) == null) {
            this.c.setWriteVoteData(writeVoteData);
        }
    }

    public final void w4() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048765, this) == null) || (editorTools = this.S) == null) {
            return;
        }
        editorTools.post(new k1(this));
    }

    public final void w5() {
        zc6 b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048766, this) == null) || (b2 = yc6.a().b(1)) == null) {
            return;
        }
        List<xc6> list = b2.b;
        this.s0 = list;
        if (list == null || list.isEmpty() || this.u0 < 0) {
            return;
        }
        xc6 xc6Var = new xc6();
        this.t0 = xc6Var;
        xc6Var.b = 0;
        xc6Var.a = getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0380);
        xc6 xc6Var2 = this.t0;
        this.w0 = xc6Var2.b;
        this.v0 = xc6Var2.a;
        for (xc6 xc6Var3 : this.s0) {
            int i2 = xc6Var3.b;
            if (i2 == this.u0) {
                this.w0 = i2;
                this.v0 = xc6Var3.a;
                return;
            }
        }
    }

    public final void w6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048767, this) == null) {
            this.r.setVisibility(8);
            this.y.setVisibility(0);
            lx8 lx8Var = this.A0;
            if (lx8Var != null) {
                lx8Var.h(true);
            }
        }
    }

    public final void w7() {
        WriteData writeData;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048768, this) == null) || (writeData = this.c) == null) {
            return;
        }
        int type = writeData.getType();
        if (type != 0) {
            if (type == 7) {
                this.k.setVisibility(0);
                this.r.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                this.H.setText(R.string.obfuscated_res_0x7f0f0ec1);
                return;
            } else if (type != 9) {
                if (type == 11) {
                    this.H.setText(R.string.obfuscated_res_0x7f0f0f21);
                    this.k.setVisibility(0);
                    this.r.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                } else if (type == 4) {
                    this.H.setText(R.string.obfuscated_res_0x7f0f0f25);
                    this.r.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                } else if (type != 5) {
                    this.H.setText(R.string.obfuscated_res_0x7f0f1120);
                    this.r.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.k.setVisibility(8);
                    return;
                } else {
                    this.H.setText(getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f14db, Integer.valueOf(this.c.getFloorNum() + 1)));
                    this.G0.setVisibility(8);
                    return;
                }
            }
        }
        if (!this.e && !this.g) {
            if (this.b1) {
                this.H.setText(R.string.obfuscated_res_0x7f0f0ecd);
            } else if (this.R0) {
                if (this.Q0) {
                    this.H.setText(R.string.obfuscated_res_0x7f0f0ff7);
                } else {
                    this.H.setText(R.string.obfuscated_res_0x7f0f0c49);
                }
            } else {
                String str3 = this.d1;
                if (str3 != null && str3.equals("1")) {
                    this.H.setText(R.string.obfuscated_res_0x7f0f0ed1);
                } else {
                    String str4 = this.d1;
                    if (str4 != null && str4.equals("2")) {
                        if (this.S1) {
                            this.H.setText(R.string.obfuscated_res_0x7f0f0f21);
                        } else if (StringUtils.isNull(this.c.getForumName())) {
                            this.H.setText(R.string.obfuscated_res_0x7f0f0ed2);
                        } else {
                            String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.obfuscated_res_0x7f0f0ed0) + this.c.getForumName(), 9, true, false);
                            if (fixedBarText.length() < 14) {
                                str2 = fixedBarText + getResources().getString(R.string.obfuscated_res_0x7f0f02d1);
                            } else {
                                str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.obfuscated_res_0x7f0f02d1);
                            }
                            this.H.setText(str2);
                        }
                    } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.S0)) {
                        this.H.setText(getResources().getString(R.string.obfuscated_res_0x7f0f117d) + this.c.getForumName() + getResources().getString(R.string.obfuscated_res_0x7f0f02d1));
                        this.k.setVisibility(8);
                        String str5 = this.u1 + " " + this.v1;
                        if (!StringUtils.isNull(str5)) {
                            this.r.setText(str5);
                        }
                    } else {
                        this.H.setText("");
                    }
                }
            }
        } else if (this.h) {
            this.H.setText(R.string.obfuscated_res_0x7f0f05f9);
        } else {
            this.H.setText(R.string.obfuscated_res_0x7f0f05f5);
        }
        this.k.setVisibility(0);
        this.r.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
    }

    public final boolean x4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048769, this)) == null) {
            FrsTabInfoData frsTabInfoData = this.E1;
            if (frsTabInfoData != null && !ListUtils.isEmpty(frsTabInfoData.tabList)) {
                for (FrsTabItemData frsTabItemData : this.E1.tabList) {
                    if (frsTabItemData != null && frsTabItemData.tabType == 3) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void x5() {
        List<xc6> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048770, this) == null) || (list = this.s0) == null || list.isEmpty()) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091850);
        linearLayout.setVisibility(0);
        findViewById(R.id.obfuscated_res_0x7f090ef8).setVisibility(0);
        PostCategoryView postCategoryView = (PostCategoryView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090584);
        this.x0 = postCategoryView;
        postCategoryView.setText(this.v0);
        this.x0.setCategoryContainerData(this.s0, this.t0, this.w0);
        this.x0.setCategoryContainerClickCallback(new n0(this));
        linearLayout.setOnClickListener(new o0(this));
    }

    public void x6(h05 h05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048771, this, h05Var) == null) {
            if (this.N0) {
                S6();
            }
            if (this.S.u()) {
                this.S.q();
            }
            if (this.Q0) {
                m6();
            } else {
                l6(0);
            }
        }
    }

    public void x7(LinkedList<ImageFileInfo> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048772, this, linkedList) == null) {
            LinkedList<ImageFileInfo> chosedFiles = this.T.getChosedFiles();
            if (chosedFiles != null) {
                chosedFiles.clear();
                if (linkedList != null) {
                    chosedFiles.addAll(linkedList);
                }
            }
            N6();
        }
    }

    public final int y4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048773, this)) == null) {
            gx8 gx8Var = this.f2;
            boolean z2 = gx8Var == null || gx8Var.e();
            ForumTabSelectedView forumTabSelectedView = this.C1;
            boolean z3 = (forumTabSelectedView == null || forumTabSelectedView.getSelectedTabItemData() == null || this.C1.getSelectedTabItemData().tabType != 3) ? false : true;
            if (z2 && z3) {
                return 1;
            }
            return (z2 || z3) ? 0 : 2;
        }
        return invokeV.intValue;
    }

    public final void y5() {
        t05 t05Var;
        t05 t05Var2;
        CustomResponsedMessage runTask;
        t05 t05Var3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048774, this) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            f15 f15Var = new f15(getActivity(), 1);
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.S0)) {
                this.S.d(f15Var);
            }
            u25 u25Var = new u25(getActivity(), 2);
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.S0)) {
                this.S.d(u25Var);
            }
            Boolean h6 = h6();
            if (!this.e && h6 != null && h6.booleanValue() && mj8.a() && rg8.a(this.c.getForumName(), Boolean.TRUE) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, getActivity()), t05.class)) != null && (t05Var3 = (t05) runTask.getData()) != null) {
                t05Var3.l = 3;
                if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.S0)) {
                    this.S.d(t05Var3);
                }
            }
            if (!this.S1) {
                this.S.d(new s05(getActivity(), 6));
            }
            this.S.d(new v05(getActivity(), 7));
            if (StringHelper.equals(this.d1, "2")) {
                i15 i15Var = new i15(getActivity(), 4);
                this.v2 = i15Var;
                if (this.S1) {
                    i15Var.g(false);
                    this.v2.h(false);
                }
                this.S.d(this.v2);
                if (!this.S1) {
                    this.S.d(new w25(getActivity(), 8));
                }
            }
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, getActivity()), t05.class);
            if (runTask2 != null && (t05Var2 = (t05) runTask2.getData()) != null) {
                t05Var2.o = true;
                t05Var2.l = 9;
                if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.S0)) {
                    this.S.d(t05Var2);
                }
            }
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, getActivity()), t05.class);
            if (runTask3 != null && (t05Var = (t05) runTask3.getData()) != null) {
                t05Var.o = true;
                t05Var.l = 10;
                if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.S0)) {
                    this.S.d(t05Var);
                }
            }
            if (this.Z == null) {
                if (this.m1 == null) {
                    hw8 hw8Var = new hw8(getActivity(), this.d1);
                    this.m1 = hw8Var;
                    hw8Var.k(0);
                    this.m1.l(SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1);
                    if (this.b1) {
                        this.m1.n(false);
                    }
                }
                if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.S0)) {
                    this.m1.i();
                    this.m1.m(WriteActivityConfig.FROM_FORUM_SHARE);
                    r7();
                }
                if (!ListUtils.isEmpty(this.i1)) {
                    this.m1.i();
                }
                this.S.d(this.m1);
            }
            if (!this.S1) {
                if (!"main_tab".equals(this.S0)) {
                    this.S.d(new k05(getActivity(), 10));
                }
                this.S.d(new h15(getActivity(), 11));
            }
            this.S.h(arrayList);
            t05 n2 = this.S.n(5);
            if (n2 != null) {
                n2.l = 5;
            }
        }
    }

    public void y6(h05 h05Var) {
        String str;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048775, this, h05Var) == null) {
            if (this.N0) {
                S6();
            }
            if (this.S.u()) {
                this.S.q();
            }
            int a2 = rv8.a();
            if (rv8.c(a2)) {
                rv8.e(getPageContext().getPageActivity(), a2, WorkPublishOpenHelper.OPEN_WORK_PUBLISH_FROM_FRS_WRITE);
            } else if (rv8.b()) {
                if (this.T == null || this.c == null) {
                    return;
                }
                if (this.k.getText().toString() != null) {
                    str = this.k.getText().toString();
                    i2 = 5;
                } else {
                    str = this.b2;
                    i2 = 1;
                }
                if (this.z1 == null && this.c.getForumName() != null) {
                    rv8.f(getPageContext(), str, this.r.getText().toString(), this.c.getForumId(), this.c.getForumName(), 3, Boolean.FALSE, "", "", "");
                } else {
                    rv8.f(getPageContext(), str, this.r.getText().toString(), this.c.getForumId(), this.c.getForumName(), i2, Boolean.TRUE, "", "", "");
                }
            } else {
                o6(0);
            }
        }
    }

    public final void y7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048776, this) == null) && this.N0) {
            this.C0.l(this.T);
            z7();
        }
    }

    public final void z4(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048777, this, str) == null) || oi.isEmpty(str) || this.W0 == null) {
            return;
        }
        e5(str);
        this.W0.dismiss();
    }

    public final void z5(Bundle bundle) {
        WriteData writeData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048778, this, bundle) == null) {
            oj8 k2 = oj8.k();
            this.V = k2;
            k2.p(this);
            WriteData writeData2 = new WriteData();
            this.c = writeData2;
            if (bundle != null) {
                writeData2.setType(bundle.getInt("type", 0));
                this.c.setForumId(bundle.getString("forum_id"));
                this.c.setForumName(bundle.getString("forum_name"));
                this.c.setFirstDir(bundle.getString(IntentConfig.FORUM_FIRST_DIR));
                this.c.setSecondDir(bundle.getString(IntentConfig.FORUM_SECOND_DIR));
                this.c.setThreadId(bundle.getString("thread_id"));
                this.c.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
                this.c.setFloorNum(bundle.getInt("floor_num", 0));
                String string = bundle.getString("addition_data");
                if (!StringUtils.isNull(string)) {
                    this.Z = (AdditionData) OrmObject.objectWithJsonStr(string, AdditionData.class);
                }
                this.c.setIsAddition(this.Z != null);
                String string2 = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
                this.l1 = string2;
                this.c.setTopicId(string2);
                this.c.setTitle(bundle.getString("write_title"));
                this.c.setContent(bundle.getString("write_content"));
                this.c.setStatisticFrom(bundle.getInt(WriteActivityConfig.KEY_STATISTIS_FROM, 0));
                this.e = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
                this.f = bundle.getBoolean(WriteActivityConfig.KEY_SHOW_HOMEPAGE_TEST_BTN, false);
                this.h = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
                this.M = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
                this.N = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
                this.Z1 = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
                this.U = bundle.getString(WriteActivityConfig.PHOTO_NAME);
                String string3 = bundle.getString("prefix_data");
                if (!StringUtils.isNull(string3)) {
                    this.k0 = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
                }
                String string4 = bundle.getString("hot_topic");
                if (!StringUtils.isNull(string4)) {
                    this.l0 = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
                }
                this.S0 = bundle.getString("from");
                this.i = bundle.getInt("private_thread", -1);
                this.i1 = (List) bundle.getSerializable("hot_topic_forum_list");
                this.d1 = bundle.getString("KEY_CALL_FROM");
                this.e1 = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
                this.E1 = (FrsTabInfoData) bundle.getSerializable("tab_list");
                this.g1 = bundle.getBoolean(WriteActivityConfig.CAN_GOODS);
                this.a2 = bundle.getBoolean(WriteActivityConfig.NEED_CLOSE_PRE_PAGE);
                this.R0 = bundle.getBoolean(WriteActivityConfig.RICH_MODE_ENABLE, false);
            } else {
                Intent intent = getIntent();
                this.c.setType(intent.getIntExtra("type", 9));
                this.c.setForumId(intent.getStringExtra("forum_id"));
                this.c.setForumName(intent.getStringExtra("forum_name"));
                this.c.setFirstDir(intent.getStringExtra(IntentConfig.FORUM_FIRST_DIR));
                this.c.setSecondDir(intent.getStringExtra(IntentConfig.FORUM_SECOND_DIR));
                this.c.setThreadId(intent.getStringExtra("thread_id"));
                this.c.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
                this.c.setFloorNum(intent.getIntExtra("floor_num", 0));
                AdditionData additionData = (AdditionData) intent.getSerializableExtra("addition_data");
                this.Z = additionData;
                this.c.setIsAddition(additionData != null);
                this.c.setProZone(intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
                this.c.setTitle(intent.getStringExtra("write_title"));
                this.c.setContent(intent.getStringExtra("write_content"));
                String stringExtra = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
                this.l1 = stringExtra;
                this.c.setTopicId(stringExtra);
                this.c.setStatisticFrom(intent.getIntExtra(WriteActivityConfig.KEY_STATISTIS_FROM, 0));
                this.e = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
                this.f = intent.getBooleanExtra(WriteActivityConfig.KEY_SHOW_HOMEPAGE_TEST_BTN, false);
                this.h = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
                this.M = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
                this.N = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
                this.i = intent.getIntExtra("private_thread", 0);
                this.k0 = (PostPrefixData) intent.getSerializableExtra("prefix_data");
                this.l0 = (PostTopicData) intent.getSerializableExtra("hot_topic");
                this.S0 = intent.getStringExtra("from");
                this.w1 = intent.getStringExtra("more_forum_img");
                this.u1 = intent.getStringExtra("more_forum_title");
                this.v1 = intent.getStringExtra("more_forum_url");
                this.i1 = (List) intent.getSerializableExtra("hot_topic_forum_list");
                this.d1 = intent.getStringExtra("KEY_CALL_FROM");
                this.e1 = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
                this.Z1 = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
                FrsTabInfoData frsTabInfoData = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
                this.E1 = frsTabInfoData;
                this.c.setFrsTabInfoData(frsTabInfoData);
                this.g1 = intent.getBooleanExtra(WriteActivityConfig.CAN_GOODS, false);
                this.a2 = intent.getBooleanExtra(WriteActivityConfig.NEED_CLOSE_PRE_PAGE, false);
                boolean booleanExtra = getIntent().getBooleanExtra(IntentConfig.IS_EVALUATE, false);
                this.S1 = booleanExtra;
                this.c.setIsEvaluate(booleanExtra);
                this.T1 = getIntent().getBooleanExtra(IntentConfig.IS_ITEM_DETAIL, false);
                this.U1 = getIntent().getIntExtra(WriteActivityConfig.STAR_COUNT, 0);
                Serializable serializableExtra = getIntent().getSerializableExtra(WriteActivityConfig.ITEM_INFO);
                if (serializableExtra instanceof SerializableItemInfo) {
                    SerializableItemInfo serializableItemInfo = (SerializableItemInfo) serializableExtra;
                    this.R1 = serializableItemInfo;
                    this.c.setItem_id(String.valueOf(serializableItemInfo.id));
                }
                this.V1 = getIntent().getBooleanExtra("need_save_draft", true);
                this.W1 = getIntent().getBooleanExtra(WriteActivityConfig.IS_FROM_ERROR_DIALOG, false);
                this.u0 = getIntent().getIntExtra("category_id", -1);
                this.X1 = getIntent().getStringExtra(WriteActivityConfig.GOODS_LIST);
                this.Y1 = intent.getSerializableExtra(IntentConfig.WRITE_VOTE_DATA);
                this.Q = intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true);
                this.R = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
                this.R0 = intent.getBooleanExtra(WriteActivityConfig.RICH_MODE_ENABLE, false);
                if (this.W1 && (writeData = qj8.e) != null) {
                    this.c = writeData;
                    writeData.setType(9);
                    WriteData writeData3 = this.c;
                    writeData3.setContent(writeData3.getContentString());
                    this.T = this.c.getWriteImagesInfo();
                    this.E1 = this.c.getFrsTabInfoData();
                    if (this.c.getItemInfo() != null) {
                        this.R1 = null;
                    }
                    this.d = this.c.getVoiceModel();
                }
            }
            PostPrefixData postPrefixData = this.k0;
            if (postPrefixData != null && postPrefixData.getPrefixs().size() > 0) {
                this.k0.getPrefixs().add(getPageContext().getString(R.string.obfuscated_res_0x7f0f15d7));
            }
            this.c.setLocalChannelDynamic(this.b1);
            this.c.setLocalChannelTopic(this.c1);
            if (this.c.getType() == 9) {
                this.c.setEntranceType(1);
            } else if (this.c.getType() == 10) {
                this.c.setEntranceType(2);
                this.c.setType(9);
            } else if (this.c.getType() == 0) {
                this.c.setEntranceType(3);
            }
            this.c.setIsUserFeedback(this.e);
            if (this.T == null) {
                this.T = new WriteImagesInfo();
            }
            String str = this.Z1;
            if (str != null) {
                this.T.parseJson(str);
                this.T.updateQuality();
            }
            this.T.setMaxImagesAllowed(this.c.getType() == 4 ? 6 : 9);
            this.c.setWriteImagesInfo(this.T);
            this.z = TbadkCoreApplication.getInst().getDefaultBubble();
            w5();
            WriteData writeData4 = this.c;
            if (writeData4 != null && writeData4.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.c.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
                this.g = true;
            }
            try {
                this.T0 = Y4();
            } catch (Throwable unused) {
                this.T0 = null;
            }
            this.V.B(this.b1);
        }
    }

    public final void z6(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048779, this, str) == null) {
            this.j2 = new ArrayList();
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
                    this.j2.add(or6.g(jSONObject));
                }
                if (this.j2.size() > 0) {
                    this.m2 = true;
                    this.r.g(this.j2, arrayList);
                    P5();
                    L6();
                    this.g2.setVisibility(0);
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public final void z7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048780, this) == null) {
            this.C0.notifyDataSetChanged();
            this.B0.invalidate();
            this.L.postDelayed(new f1(this), 550L);
        }
    }
}
