package com.baidu.tieba.pb.pb.foldcomment;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ReplyPrivacyCheckController;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tbadk.widget.layout.GridImageLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextMemeInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.tiejia.TiebaPlusRecommendCard;
import com.baidu.tieba.R;
import com.baidu.tieba.a75;
import com.baidu.tieba.au4;
import com.baidu.tieba.aw7;
import com.baidu.tieba.b18;
import com.baidu.tieba.bc5;
import com.baidu.tieba.c08;
import com.baidu.tieba.cz7;
import com.baidu.tieba.dh;
import com.baidu.tieba.dj;
import com.baidu.tieba.do4;
import com.baidu.tieba.e08;
import com.baidu.tieba.e55;
import com.baidu.tieba.ej;
import com.baidu.tieba.ez7;
import com.baidu.tieba.f55;
import com.baidu.tieba.fz7;
import com.baidu.tieba.g55;
import com.baidu.tieba.gc5;
import com.baidu.tieba.gh;
import com.baidu.tieba.hu4;
import com.baidu.tieba.iw7;
import com.baidu.tieba.ju4;
import com.baidu.tieba.kq6;
import com.baidu.tieba.l15;
import com.baidu.tieba.lm8;
import com.baidu.tieba.lu4;
import com.baidu.tieba.lv7;
import com.baidu.tieba.ni5;
import com.baidu.tieba.on;
import com.baidu.tieba.oy7;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pc8;
import com.baidu.tieba.q9;
import com.baidu.tieba.rq4;
import com.baidu.tieba.s08;
import com.baidu.tieba.s25;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.st8;
import com.baidu.tieba.sx7;
import com.baidu.tieba.t65;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tt8;
import com.baidu.tieba.u45;
import com.baidu.tieba.u65;
import com.baidu.tieba.ug;
import com.baidu.tieba.up4;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.uw7;
import com.baidu.tieba.v18;
import com.baidu.tieba.v75;
import com.baidu.tieba.vg;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.vk5;
import com.baidu.tieba.vu7;
import com.baidu.tieba.w65;
import com.baidu.tieba.wu7;
import com.baidu.tieba.x25;
import com.baidu.tieba.xv7;
import com.baidu.tieba.xw4;
import com.baidu.tieba.y25;
import com.baidu.tieba.y65;
import com.baidu.tieba.yk5;
import com.baidu.tieba.zy7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public class FoldCommentActivity extends BaseFragmentActivity implements VoiceManager.j, iw7<NewSubPbActivity>, TbRichTextView.s, au4.e, yk5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public do4 A;
    public ug<ImageView> B;
    public BdUniqueId C;
    public PbModel.h D;
    public View E;
    public int F;
    public final TbRichTextView.y G;
    public boolean H;
    public xv7 I;
    public final View.OnLongClickListener J;
    public ez7 K;
    public on L;
    public String M;
    public TbRichTextMemeInfo N;
    public PostData O;
    public lu4.e P;
    public Object Q;
    public final q9 R;
    public u65 S;
    public CustomMessageListener T;
    public NewWriteModel.d U;
    public boolean V;
    public View W;
    public View X;
    public View.OnClickListener Y;
    public t65 Z;
    public PbModel a;
    public final do4.a a0;
    public b18 b;
    public uw7 c;
    public c08 d;
    public e08 e;
    public boolean f;
    public boolean g;
    public ju4 h;
    public lu4 i;
    public PermissionJudgePolicy j;
    public BdUniqueId k;
    public xw4 l;
    public lm8 m;
    public ForumManageModel n;
    public tt8 o;
    public y65 p;
    public w65 q;
    public boolean r;
    public cz7 s;
    public VoiceManager t;
    public ReplyPrivacyCheckController u;
    public ShareSuccessReplyToServerModel v;
    public int[] w;
    public int x;
    public kq6 y;
    public kq6 z;

    /* loaded from: classes5.dex */
    public class a extends q9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        public a(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // com.baidu.tieba.q9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                boolean z = false;
                if (obj != null) {
                    int loadDataMode = this.a.n.getLoadDataMode();
                    if (loadDataMode == 0) {
                        this.a.a.v2();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        this.a.X1(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
                        return;
                    } else if (loadDataMode != 1) {
                        return;
                    } else {
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        this.a.c.v(1, dVar.a, dVar.b, true);
                        return;
                    }
                }
                this.a.c.v(this.a.n.getLoadDataMode(), false, null, false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements au4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        public b(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // com.baidu.tieba.au4.e
        public void onClick(au4 au4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, au4Var) == null) || au4Var == null) {
                return;
            }
            au4Var.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements au4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserMuteAddAndDelCustomMessage a;
        public final /* synthetic */ FoldCommentActivity b;

        public c(FoldCommentActivity foldCommentActivity, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity, userMuteAddAndDelCustomMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = foldCommentActivity;
            this.a = userMuteAddAndDelCustomMessage;
        }

        @Override // com.baidu.tieba.au4.e
        public void onClick(au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, au4Var) == null) {
                this.b.c.d0();
                MessageManager.getInstance().sendMessage(this.a);
                au4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements au4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        public d(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // com.baidu.tieba.au4.e
        public void onClick(au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, au4Var) == null) {
                au4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements u65 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        public e(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // com.baidu.tieba.u65
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.showProgressBar();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(FoldCommentActivity foldCommentActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity, Integer.valueOf(i)};
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
            this.a = foldCommentActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (this.a.q != null) {
                this.a.c.W(this.a.q.y());
            }
            this.a.c.a0(false);
        }
    }

    /* loaded from: classes5.dex */
    public class g implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        /* loaded from: classes5.dex */
        public class a implements au4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
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
                    au4Var.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements au4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            public b(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            @Override // com.baidu.tieba.au4.e
            public void onClick(au4 au4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, au4Var) == null) {
                    au4Var.dismiss();
                    this.a.a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.a.a.getActivity(), 0, 26, 2)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
                }
            }
        }

        public g(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, l15 l15Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, l15Var, writeData, antiData}) == null) {
                if (!dj.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.a != null && this.a.a.S1() != null) {
                        statisticItem.param("fid", this.a.a.S1().m());
                    }
                    if (this.a.a != null) {
                        statisticItem.param("tid", this.a.a.m2());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (z) {
                    cz7 cz7Var = this.a.s;
                    if (cz7Var != null) {
                        cz7Var.d();
                    }
                    if (postWriteCallBackData == null || postWriteCallBackData.getIconStampData() == null) {
                        return;
                    }
                    y25.c(this.a.getPageContext(), postWriteCallBackData, 2);
                    return;
                }
                if ((postWriteCallBackData != null ? postWriteCallBackData.getErrorCode() : -1) == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.a.u;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                        return;
                    }
                    return;
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (dj.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0480), null).v();
                    } else {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).v();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    au4 au4Var = new au4(this.a.getActivity());
                    if (dj.isEmpty(postWriteCallBackData.getErrorString())) {
                        au4Var.setMessage(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0d11));
                    } else {
                        au4Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    au4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new a(this));
                    au4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0d13, new b(this));
                    au4Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData == null || !postWriteCallBackData.isSensitiveError()) {
                    return;
                }
                FoldCommentActivity foldCommentActivity = this.a;
                if (foldCommentActivity.s == null) {
                    return;
                }
                if (foldCommentActivity.c != null && this.a.c.y() != null && this.a.c.y().b() != null && this.a.c.y().b().y()) {
                    this.a.c.y().b().w(postWriteCallBackData);
                }
                this.a.s.l(postWriteCallBackData);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        public h(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a == null) {
                return;
            }
            this.a.a.loadData();
        }
    }

    /* loaded from: classes5.dex */
    public class i implements ShareSuccessReplyToServerModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CustomDialogData a;
            public final /* synthetic */ i b;

            public a(i iVar, CustomDialogData customDialogData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar, customDialogData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = iVar;
                this.a = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    aw7.a(this.b.a.getPageContext(), this.a).show();
                }
            }
        }

        public i(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void b(CustomDialogData customDialogData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customDialogData) == null) {
                gh.a().postDelayed(new a(this, customDialogData), 1000L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        public j(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            StatisticItem statisticItem;
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null) {
                return;
            }
            if ((view2 instanceof TbListTextView) && (view2.getParent() instanceof TbRichTextView)) {
                StatisticItem statisticItem2 = new StatisticItem("c13398");
                statisticItem2.param("tid", this.a.a.m2());
                statisticItem2.param("fid", this.a.a.getForumId());
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("obj_locate", 1);
                TiebaStatic.log(statisticItem2);
                TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.obfuscated_res_0x7f09203a);
                    if (obj instanceof PostData) {
                        PostData postData = (PostData) obj;
                        if (this.a.a == null || this.a.a.S1() == null || postData.s() == null || postData.C() == 1 || !this.a.checkUpIsLogin()) {
                            return;
                        }
                        if (this.a.c.y() != null) {
                            this.a.c.y().c();
                        }
                        lv7 lv7Var = new lv7();
                        lv7Var.A(this.a.a.S1().l());
                        lv7Var.E(this.a.a.S1().O());
                        lv7Var.C(postData);
                        this.a.c.x().V(lv7Var);
                        this.a.c.x().setPostId(postData.L());
                        this.a.v2(view2, postData.s().getUserId(), "", postData);
                        TiebaStatic.log("c11743");
                        v18.b(this.a.a.S1(), postData, postData.b0, 8, 1);
                        if (this.a.q != null) {
                            this.a.c.W(this.a.q.y());
                        }
                    }
                }
            } else if (view2.getId() != R.id.obfuscated_res_0x7f09180d && view2.getId() != R.id.obfuscated_res_0x7f091865) {
                if (view2.getId() != R.id.obfuscated_res_0x7f091f9c && view2.getId() != R.id.obfuscated_res_0x7f091f9a && view2.getId() != R.id.obfuscated_res_0x7f09180b && view2.getId() != R.id.obfuscated_res_0x7f09169e) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f09186b || view2.getId() == R.id.obfuscated_res_0x7f091a41 || view2.getId() == R.id.obfuscated_res_0x7f091805) {
                        if (this.a.a == null) {
                            return;
                        }
                        if (view2.getId() == R.id.obfuscated_res_0x7f09186b) {
                            StatisticItem statisticItem3 = new StatisticItem("c13398");
                            statisticItem3.param("tid", this.a.a.m2());
                            statisticItem3.param("fid", this.a.a.getForumId());
                            statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                            statisticItem3.param("obj_locate", 6);
                            TiebaStatic.log(statisticItem3);
                        }
                        if (view2.getId() == R.id.obfuscated_res_0x7f091a41) {
                            if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                this.a.X = view2;
                                return;
                            }
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f09186b && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                            this.a.X = view2;
                            return;
                        }
                        if (this.a.checkUpIsLogin() && (view2.getTag() instanceof SparseArray)) {
                            SparseArray sparseArray2 = (SparseArray) view2.getTag();
                            if (sparseArray2.get(R.id.obfuscated_res_0x7f092057) instanceof PostData) {
                                PostData postData2 = (PostData) sparseArray2.get(R.id.obfuscated_res_0x7f092057);
                                if (view2.getId() == R.id.obfuscated_res_0x7f09186b && (statisticItem = postData2.c0) != null) {
                                    StatisticItem copy = statisticItem.copy();
                                    copy.delete("obj_locate");
                                    copy.param("obj_locate", 8);
                                    TiebaStatic.log(copy);
                                } else if (view2.getId() == R.id.obfuscated_res_0x7f091a41 || view2.getId() == R.id.obfuscated_res_0x7f091805) {
                                    TiebaStatic.log(new StatisticItem("c13700").param("tid", this.a.a.n2()).param("fid", this.a.a.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData2.L()).param("obj_source", 1).param("obj_type", 3));
                                }
                                if (this.a.a == null || this.a.a.S1() == null || postData2.s() == null || postData2.C() == 1) {
                                    return;
                                }
                                if (this.a.c.y() != null) {
                                    this.a.c.y().c();
                                }
                                if (this.a.V && postData2.Z() != null && postData2.Z().size() != 0) {
                                    this.a.L2(postData2, true);
                                    return;
                                }
                                lv7 lv7Var2 = new lv7();
                                lv7Var2.A(this.a.a.S1().l());
                                lv7Var2.E(this.a.a.S1().O());
                                lv7Var2.C(postData2);
                                this.a.c.x().V(lv7Var2);
                                this.a.c.x().setPostId(postData2.L());
                                this.a.v2(view2, postData2.s().getUserId(), "", postData2);
                                if (this.a.q != null) {
                                    this.a.c.W(this.a.q.y());
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    } else if ((view2.getId() == R.id.obfuscated_res_0x7f090786 || view2.getId() == R.id.obfuscated_res_0x7f090a0c) && (sparseArray = (SparseArray) view2.getTag()) != null && (sparseArray.get(R.id.obfuscated_res_0x7f092057) instanceof PostData)) {
                        PostData postData3 = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f092057);
                        View view3 = (View) sparseArray.get(R.id.obfuscated_res_0x7f092059);
                        if (postData3 == null || view3 == null) {
                            return;
                        }
                        ImageView imageView = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f090787);
                        EMTextView eMTextView = (EMTextView) view3.findViewById(R.id.obfuscated_res_0x7f090788);
                        View findViewById = view3.findViewById(R.id.obfuscated_res_0x7f090a0c);
                        if (postData3.q0()) {
                            postData3.Q0(false);
                        } else {
                            postData3.Q0(true);
                        }
                        SkinManager.setBackgroundColor(findViewById, postData3.q0() ? R.color.CAM_X0201 : R.color.transparent);
                        SkinManager.setViewTextColor(eMTextView, postData3.q0() ? R.color.CAM_X0304 : R.color.CAM_X0107);
                        WebPManager.setPureDrawable(imageView, postData3.q0() ? R.drawable.obfuscated_res_0x7f080981 : R.drawable.obfuscated_res_0x7f080980, postData3.q0() ? R.color.CAM_X0304 : R.color.CAM_X0107, null);
                        return;
                    } else {
                        return;
                    }
                }
                if (view2.getId() == R.id.obfuscated_res_0x7f09169e) {
                    StatisticItem statisticItem4 = new StatisticItem("c13398");
                    statisticItem4.param("tid", this.a.a.m2());
                    statisticItem4.param("fid", this.a.a.getForumId());
                    statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem4.param("obj_locate", 4);
                    TiebaStatic.log(statisticItem4);
                }
                if (view2.getId() == R.id.obfuscated_res_0x7f09180b && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                    this.a.W = view2;
                } else if (this.a.checkUpIsLogin()) {
                    if (this.a.a == null || this.a.a.S1() == null) {
                        return;
                    }
                    this.a.c.u();
                    SparseArray sparseArray3 = (SparseArray) view2.getTag();
                    PostData postData4 = (PostData) sparseArray3.get(R.id.obfuscated_res_0x7f092057);
                    PostData postData5 = (PostData) sparseArray3.get(R.id.obfuscated_res_0x7f092058);
                    View view4 = (View) sparseArray3.get(R.id.obfuscated_res_0x7f092059);
                    if (postData4 == null || view4 == null) {
                        return;
                    }
                    if (postData4.G() == 1) {
                        TiebaStatic.log(new StatisticItem("c12630"));
                    }
                    StatisticItem statisticItem5 = postData4.c0;
                    if (statisticItem5 != null) {
                        StatisticItem copy2 = statisticItem5.copy();
                        copy2.delete("obj_locate");
                        if (view2.getId() == R.id.obfuscated_res_0x7f09169e) {
                            copy2.param("obj_locate", 6);
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f09180b) {
                            copy2.param("obj_locate", 8);
                        }
                        TiebaStatic.log(copy2);
                    }
                    if (view2.getId() == R.id.obfuscated_res_0x7f09180b && this.a.a != null && this.a.a.S1() != null && postData4 != null) {
                        TiebaStatic.log(new StatisticItem("c14443").param("tid", this.a.a.m2()).param("fname", this.a.a.S1().n()).param("fid", this.a.a.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData4.L()));
                    }
                    String m2 = this.a.a.m2();
                    String L = postData4.L();
                    String L2 = postData5 != null ? postData5.L() : "";
                    int W = this.a.a.S1() != null ? this.a.a.S1().W() : 0;
                    this.a.x();
                    if (view2.getId() == R.id.obfuscated_res_0x7f091bfd) {
                        AbsPbActivity.e C2 = this.a.C2(L);
                        if (this.a.a == null || this.a.a.S1() == null || C2 == null) {
                            return;
                        }
                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(m2, L, "pb", true, this.a.r, null, true, null, W, postData4.c0(), this.a.a.S1().d(), false, postData4.s().getIconInfo(), 5).addBigImageData(C2.a, C2.b, C2.g, C2.j);
                        addBigImageData.setKeyPageStartFrom(this.a.a.R1());
                        addBigImageData.setFromFrsForumId(this.a.a.getFromForumId());
                        addBigImageData.setWorksInfoData(this.a.a.r2());
                        addBigImageData.setKeyFromForumId(this.a.a.getForumId());
                        addBigImageData.setBjhData(this.a.a.k1());
                        addBigImageData.setTiebaPlusData(this.a.a.I(), this.a.a.E(), this.a.a.F(), this.a.a.D(), this.a.a.J());
                        addBigImageData.setFromFoldComment(true);
                        addBigImageData.setFromVideoPageUniqueId((BdUniqueId) this.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData));
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f09180b && this.a.r) {
                        AbsPbActivity.e C22 = this.a.C2(L);
                        if (this.a.a == null || this.a.a.S1() == null || C22 == null) {
                            return;
                        }
                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(m2, L, "pb", true, this.a.r, null, true, null, W, postData4.c0(), this.a.a.S1().d(), false, postData4.s().getIconInfo(), 5).addBigImageData(C22.a, C22.b, C22.g, C22.j);
                        addBigImageData2.setKeyPageStartFrom(this.a.a.R1());
                        addBigImageData2.setFromFrsForumId(this.a.a.getFromForumId());
                        addBigImageData2.setWorksInfoData(this.a.a.r2());
                        addBigImageData2.setKeyFromForumId(this.a.a.getForumId());
                        addBigImageData2.setBjhData(this.a.a.k1());
                        addBigImageData2.setTiebaPlusData(this.a.a.I(), this.a.a.E(), this.a.a.F(), this.a.a.D(), this.a.a.J());
                        addBigImageData2.setFromFoldComment(true);
                        addBigImageData2.setFromVideoPageUniqueId((BdUniqueId) this.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData2));
                    } else {
                        TiebaStatic.log("c11742");
                        AbsPbActivity.e C23 = this.a.C2(L);
                        if (postData4 == null || this.a.a == null || this.a.a.S1() == null || C23 == null) {
                            return;
                        }
                        SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(m2, L, "pb", true, this.a.r, null, false, L2, W, postData4.c0(), this.a.a.S1().d(), false, postData4.s().getIconInfo(), 5).addBigImageData(C23.a, C23.b, C23.g, C23.j);
                        if (!dj.isEmpty(L2)) {
                            addBigImageData3.setHighLightPostId(L2);
                            addBigImageData3.setKeyIsUseSpid(true);
                        }
                        addBigImageData3.setKeyFromForumId(this.a.a.getForumId());
                        addBigImageData3.setTiebaPlusData(this.a.a.I(), this.a.a.E(), this.a.a.F(), this.a.a.D(), this.a.a.J());
                        addBigImageData3.setBjhData(this.a.a.k1());
                        addBigImageData3.setKeyPageStartFrom(this.a.a.R1());
                        addBigImageData3.setFromFrsForumId(this.a.a.getFromForumId());
                        addBigImageData3.setWorksInfoData(this.a.a.r2());
                        addBigImageData3.setFromFoldComment(true);
                        addBigImageData3.setFromVideoPageUniqueId((BdUniqueId) this.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData3));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 3).param("fid", this.a.a.S1().m()));
                }
            } else {
                StatisticItem statisticItem6 = new StatisticItem("c13398");
                statisticItem6.param("tid", this.a.a.m2());
                statisticItem6.param("fid", this.a.a.getForumId());
                statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem6.param("obj_locate", 7);
                TiebaStatic.log(statisticItem6);
                if (this.a.a != null && this.a.a.S1() != null && this.a.O != null) {
                    TiebaStatic.log(new StatisticItem("c14441").param("tid", this.a.a.m2()).param("fname", this.a.a.S1().n()).param("fid", this.a.a.S1().m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.O.L()));
                }
                FoldCommentActivity foldCommentActivity = this.a;
                foldCommentActivity.g = false;
                foldCommentActivity.T1(view2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements PbModel.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        public k(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), responsedMessage, Boolean.valueOf(z2), Long.valueOf(j)}) == null) {
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void b(vu7 vu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vu7Var) == null) {
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void c(boolean z, int i, int i2, int i3, vu7 vu7Var, String str, int i4) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), vu7Var, str, Integer.valueOf(i4)}) == null) || this.a.c == null) {
                return;
            }
            this.a.c.U();
            if (!z) {
                this.a.z2(i, str);
                return;
            }
            this.a.c.E();
            if (vu7Var != null) {
                if (vu7Var.s() == 1) {
                    this.a.f = true;
                } else {
                    this.a.f = false;
                }
                String str2 = null;
                if (this.a.a == null || !this.a.a.A2()) {
                    if (this.a.c != null) {
                        str2 = this.a.c.z();
                    }
                } else {
                    str2 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e0a);
                }
                if (!StringUtils.isNull(str2)) {
                    this.a.q.c0(TbSingleton.getInstance().getAdVertiComment(vu7Var.n0(), vu7Var.o0(), str2));
                }
                this.a.c.S(vu7Var, this.a.f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ FoldCommentActivity c;

        /* loaded from: classes5.dex */
        public class a implements TextWatcher {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l a;

            public a(l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = lVar;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                cz7 cz7Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (cz7Var = this.a.c.s) == null || cz7Var.g() == null) {
                    return;
                }
                if (!this.a.c.s.g().e()) {
                    this.a.c.s.b(false);
                }
                this.a.c.s.g().l(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
                }
            }
        }

        public l(FoldCommentActivity foldCommentActivity, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = foldCommentActivity;
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int f;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = ej.i(this.c.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i = TbadkCoreApplication.getInst().getKeyboardHeight();
                    f = ej.f(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                } else {
                    i = i2 / 2;
                    f = ej.f(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                }
                int i3 = i2 - (i + f);
                FoldCommentActivity foldCommentActivity = this.c;
                boolean z = true;
                foldCommentActivity.c.w().smoothScrollBy((foldCommentActivity.w[1] + foldCommentActivity.x) - i3, 50);
                if (this.c.c.y() != null) {
                    this.c.q.a().setVisibility(8);
                    this.c.c.y().o(this.a, this.b, this.c.c.z(), (this.c.a == null || this.c.a.S1() == null || this.c.a.S1().O() == null || !this.c.a.S1().O().isBjh()) ? false : false);
                    a75 b = this.c.c.y().b();
                    if (b != null && this.c.a != null && this.c.a.S1() != null) {
                        b.H(this.c.a.S1().d());
                        b.d0(this.c.a.S1().O());
                    }
                    if (this.c.s.f() == null && this.c.c.y().b().u() != null) {
                        this.c.c.y().b().u().g(new a(this));
                        FoldCommentActivity foldCommentActivity2 = this.c;
                        foldCommentActivity2.s.n(foldCommentActivity2.c.y().b().u().i());
                        this.c.c.y().b().N(this.c.Z);
                    }
                }
                this.c.c.B();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements kq6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ FoldCommentActivity c;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ m a;

            /* renamed from: com.baidu.tieba.pb.pb.foldcomment.FoldCommentActivity$m$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class C0371a implements TextWatcher {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public C0371a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = aVar;
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    cz7 cz7Var;
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (cz7Var = this.a.a.c.s) == null || cz7Var.g() == null) {
                        return;
                    }
                    if (!this.a.a.c.s.g().e()) {
                        this.a.a.c.s.b(false);
                    }
                    this.a.a.c.s.g().l(false);
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
                    }
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
                    }
                }
            }

            public a(m mVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = mVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i;
                int f;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int i2 = ej.i(this.a.c.getApplicationContext());
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        i = TbadkCoreApplication.getInst().getKeyboardHeight();
                        f = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                    } else {
                        i = i2 / 2;
                        f = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                    }
                    int i3 = i2 - (i + f);
                    FoldCommentActivity foldCommentActivity = this.a.c;
                    boolean z = true;
                    foldCommentActivity.c.w().smoothScrollBy((foldCommentActivity.w[1] + foldCommentActivity.x) - i3, 50);
                    if (this.a.c.c.y() != null) {
                        this.a.c.q.a().setVisibility(8);
                        z = (this.a.c.a == null || this.a.c.a.S1() == null || this.a.c.a.S1().O() == null || !this.a.c.a.S1().O().isBjh()) ? false : false;
                        sx7 y = this.a.c.c.y();
                        m mVar = this.a;
                        y.o(mVar.a, mVar.b, mVar.c.c.z(), z);
                        a75 b = this.a.c.c.y().b();
                        if (b != null && this.a.c.a != null && this.a.c.a.S1() != null) {
                            b.H(this.a.c.a.S1().d());
                            b.d0(this.a.c.a.S1().O());
                        }
                        if (this.a.c.s.f() == null && this.a.c.c.y().b().u() != null) {
                            this.a.c.c.y().b().u().g(new C0371a(this));
                            FoldCommentActivity foldCommentActivity2 = this.a.c;
                            foldCommentActivity2.s.n(foldCommentActivity2.c.y().b().u().i());
                            this.a.c.c.y().b().N(this.a.c.Z);
                        }
                    }
                    this.a.c.c.B();
                }
            }
        }

        public m(FoldCommentActivity foldCommentActivity, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = foldCommentActivity;
            this.a = str;
            this.b = str2;
        }

        @Override // com.baidu.tieba.kq6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.baidu.tieba.kq6.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                gh.a().postDelayed(new a(this), 0L);
            }
        }

        @Override // com.baidu.tieba.kq6.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements t65 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        public n(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // com.baidu.tieba.t65
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                cz7 cz7Var = this.a.s;
                if (cz7Var == null || cz7Var.g() == null || !this.a.s.g().d()) {
                    return !this.a.Q1(ReplyPrivacyCheckController.TYPE_FLOOR);
                }
                FoldCommentActivity foldCommentActivity = this.a;
                foldCommentActivity.showToast(foldCommentActivity.s.g().c());
                if (this.a.c != null && this.a.c.y() != null && this.a.c.y().b() != null && this.a.c.y().b().y()) {
                    this.a.c.y().b().w(this.a.s.h());
                }
                this.a.s.b(true);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class o implements kq6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        public o(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // com.baidu.tieba.kq6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.baidu.tieba.kq6.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                if (this.a.q != null && this.a.q.a() != null) {
                    this.a.q.a().A(new u45(45, 27, null));
                }
                this.a.c.t();
            }
        }

        @Override // com.baidu.tieba.kq6.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p implements do4.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        public p(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // com.baidu.tieba.do4.a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                if (z) {
                    if (this.a.A != null) {
                        this.a.A.h(z2);
                    }
                    this.a.a.H3(z2);
                    if (this.a.a.D1()) {
                        this.a.w2();
                    }
                    if (z2) {
                        if (this.a.A != null) {
                            if (this.a.A.f() == null || this.a.a == null || this.a.a.S1() == null || this.a.a.S1().O() == null || this.a.a.S1().O().getAuthor() == null) {
                                return;
                            }
                            MarkData f = this.a.A.f();
                            MetaData author = this.a.a.S1().O().getAuthor();
                            if (f != null && author != null) {
                                if (StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), author.getUserId()) || author.hadConcerned()) {
                                    this.a.showToast(R.string.obfuscated_res_0x7f0f00d3);
                                    if (s25.g(this.a.getActivity(), 0)) {
                                        s25.i(this.a.getPageContext(), 6, 2000L);
                                    }
                                }
                            } else {
                                FoldCommentActivity foldCommentActivity = this.a;
                                foldCommentActivity.showToast(foldCommentActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f00d2));
                            }
                        }
                        this.a.L1();
                        return;
                    }
                    FoldCommentActivity foldCommentActivity2 = this.a;
                    foldCommentActivity2.showToast(foldCommentActivity2.getPageContext().getString(R.string.obfuscated_res_0x7f0f0ff1));
                    return;
                }
                FoldCommentActivity foldCommentActivity3 = this.a;
                foldCommentActivity3.showToast(foldCommentActivity3.getPageContext().getString(R.string.obfuscated_res_0x7f0f14e5));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q implements vg<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        public q(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.vg
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.vg
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        public ImageView e(ImageView imageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, imageView)) == null) {
                if (imageView instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) imageView;
                    tbImageView.setTag(null);
                    if (up4.c().g()) {
                        tbImageView.setAdjustViewBounds(false);
                        tbImageView.setInterceptOnClick(false);
                    } else {
                        tbImageView.setDefaultResource(R.drawable.icon_click);
                        tbImageView.setAdjustViewBounds(true);
                        tbImageView.setInterceptOnClick(true);
                    }
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
        /* renamed from: f */
        public void b(ImageView imageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, imageView) == null) {
                imageView.setBackgroundDrawable(null);
                imageView.setImageDrawable(null);
                imageView.setTag(null);
                imageView.setOnClickListener(null);
                if (imageView instanceof ForeDrawableImageView) {
                    ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                    foreDrawableImageView.O();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.CAM_X0204);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.getPageContext().getPageActivity());
                boolean g = up4.c().g();
                foreDrawableImageView.setDefaultBg(SkinManager.getDrawable(R.color.common_color_10220));
                if (g) {
                    foreDrawableImageView.setAdjustViewBounds(false);
                    foreDrawableImageView.setInterceptOnClick(false);
                } else {
                    foreDrawableImageView.setDefaultResource(R.drawable.icon_click);
                    foreDrawableImageView.setAdjustViewBounds(true);
                    foreDrawableImageView.setInterceptOnClick(true);
                }
                return foreDrawableImageView;
            }
            return (ImageView) invokeV.objValue;
        }

        public ImageView h(ImageView imageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, imageView)) == null) {
                imageView.setBackgroundDrawable(null);
                imageView.setImageDrawable(null);
                imageView.setTag(null);
                imageView.setOnClickListener(null);
                if (imageView instanceof ForeDrawableImageView) {
                    ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                    foreDrawableImageView.O();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.CAM_X0204);
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class r implements TbRichTextView.y {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        public r(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v17, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$Builder */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.y
        public void a(View view2, String str, int i, boolean z, boolean z2) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    if (view2.getTag(R.id.obfuscated_res_0x7f092076) != null && (view2.getTag(R.id.obfuscated_res_0x7f092076) instanceof TbRichTextMemeInfo) && (view2 instanceof TbImageView)) {
                        TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f092076);
                        boolean w = ((TbImageView) view2).w();
                        if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                            this.a.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(this.a.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, w)));
                        }
                        this.a.E = view2;
                        return;
                    }
                    AbsPbActivity.e eVar = new AbsPbActivity.e();
                    this.a.A2(str, i, eVar);
                    if (this.a.a.S1().i0()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        TbRichTextView tbRichTextView = null;
                        if (view2.getParent() instanceof TbRichTextView) {
                            tbRichTextView = (TbRichTextView) view2.getParent();
                        } else if ((view2.getParent() instanceof GridImageLayout) && (view2.getParent().getParent() instanceof TbRichTextView)) {
                            tbRichTextView = (TbRichTextView) view2.getParent().getParent();
                        }
                        int i3 = -1;
                        if (tbRichTextView == null || tbRichTextView.getRichText() == null || tbRichTextView.getRichText().D() == null) {
                            i2 = -1;
                        } else {
                            ArrayList<TbRichTextImageInfo> D = tbRichTextView.getRichText().D();
                            int i4 = 0;
                            int i5 = -1;
                            while (i4 < D.size()) {
                                if (D.get(i4) != null) {
                                    arrayList.add(D.get(i4).F());
                                    if (i5 == i3 && str != null && (str.equals(D.get(i4).F()) || str.equals(D.get(i4).B()) || str.equals(D.get(i4).z()) || str.equals(D.get(i4).A()) || str.equals(D.get(i4).D()))) {
                                        i5 = i4;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = D.get(i4).F();
                                    imageUrlData.originalUrl = D.get(i4).F();
                                    imageUrlData.isLongPic = D.get(i4).I();
                                    concurrentHashMap.put(D.get(i4).F(), imageUrlData);
                                }
                                i4++;
                                i3 = -1;
                            }
                            i2 = i5;
                        }
                        ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
                        builder.A(arrayList);
                        builder.E(i2);
                        builder.F(false);
                        builder.O(eVar.f);
                        builder.I(this.a.a.d2());
                        builder.y(concurrentHashMap);
                        builder.K(true);
                        builder.N(false);
                        builder.J(this.a.q2());
                        if (this.a.a != null) {
                            builder.D(this.a.a.getFromForumId());
                            if (this.a.a.S1() != null) {
                                builder.Q(this.a.a.S1().O());
                            }
                        }
                        ImageViewerConfig x = builder.x(this.a.getPageContext().getPageActivity());
                        x.getIntent().putExtra("from", "pb");
                        this.a.sendMessage(new CustomMessage(2010000, x));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                    } else if (eVar.h) {
                        TbRichText P2 = this.a.P2(str, i);
                        if (P2 != null && this.a.F >= 0 && this.a.F < P2.B().size()) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            String a = wu7.a(P2.B().get(this.a.F));
                            int i6 = 0;
                            while (true) {
                                if (i6 >= eVar.a.size()) {
                                    break;
                                } else if (eVar.a.get(i6).equals(a)) {
                                    eVar.j = i6;
                                    arrayList2.add(a);
                                    break;
                                } else {
                                    i6++;
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                            if (!ListUtils.isEmpty(arrayList2)) {
                                String str2 = arrayList2.get(0);
                                concurrentHashMap2.put(str2, eVar.b.get(str2));
                            }
                            ImageViewerConfig.Builder builder2 = new ImageViewerConfig.Builder();
                            builder2.A(arrayList2);
                            builder2.C(eVar.c);
                            builder2.B(eVar.d);
                            builder2.R(eVar.e);
                            builder2.F(eVar.g);
                            builder2.K(true);
                            builder2.M(eVar.i);
                            builder2.I(this.a.a.d2());
                            builder2.y(concurrentHashMap2);
                            builder2.N(false);
                            builder2.J(this.a.q2());
                            builder2.O(eVar.f);
                            builder2.z(eVar.f);
                            if (this.a.a != null) {
                                builder2.D(this.a.a.getFromForumId());
                                if (this.a.a.S1() != null) {
                                    builder2.Q(this.a.a.S1().O());
                                }
                            }
                            ImageViewerConfig x2 = builder2.x(this.a.getPageContext().getPageActivity());
                            x2.getIntent().putExtra("from", "pb");
                            this.a.sendMessage(new CustomMessage(2010000, x2));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                        }
                    } else {
                        ArrayList arrayList3 = new ArrayList();
                        arrayList3.add(ListUtils.getItem(eVar.a, 0));
                        ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
                        if (!ListUtils.isEmpty(arrayList3)) {
                            String str3 = (String) arrayList3.get(0);
                            concurrentHashMap3.put(str3, eVar.b.get(str3));
                        }
                        ImageViewerConfig.Builder builder3 = new ImageViewerConfig.Builder();
                        builder3.A(arrayList3);
                        builder3.C(eVar.c);
                        builder3.B(eVar.d);
                        builder3.R(eVar.e);
                        builder3.F(eVar.g);
                        builder3.K(true);
                        builder3.M(eVar.a.get(0));
                        builder3.I(this.a.a.d2());
                        builder3.y(concurrentHashMap3);
                        builder3.N(false);
                        builder3.J(this.a.q2());
                        builder3.z(eVar.f);
                        builder3.O(eVar.f);
                        builder3.G(false);
                        if (this.a.a != null) {
                            builder3.D(this.a.a.getFromForumId());
                            if (this.a.a.S1() != null) {
                                builder3.Q(this.a.a.S1().O());
                            }
                        }
                        ImageViewerConfig x3 = builder3.x(this.a.getPageContext().getPageActivity());
                        x3.getIntent().putExtra("from", "pb");
                        this.a.sendMessage(new CustomMessage(2010000, x3));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        public s(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && z) {
                if (i == ReplyPrivacyCheckController.TYPE_THREAD) {
                    this.a.q.G(null, null);
                } else if (i != ReplyPrivacyCheckController.TYPE_FLOOR || this.a.c == null || this.a.c.y() == null || this.a.c.y().b() == null) {
                } else {
                    this.a.c.y().b().G();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t implements PbFragment.h3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        public t(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.h3
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c5a);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.a.S1().l().getId(), this.a.a.S1().l().getName(), this.a.a.S1().O().getId(), String.valueOf(this.a.a.S1().V().getUserId()), objArr.length > 1 ? String.valueOf(objArr[1]) : "", objArr.length > 3 ? String.valueOf(objArr[3]) : "", objArr.length > 2 ? String.valueOf(objArr[2]) : "", objArr.length > 4 ? String.valueOf(objArr[4]) : "")));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u implements xv7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        public u(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // com.baidu.tieba.xv7.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.xv7.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (view2 != null) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f091c1b) {
                        if (this.a.E2(view2)) {
                            return true;
                        }
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f09180a) {
                        if (view2.getTag(R.id.obfuscated_res_0x7f09204d) instanceof SparseArray) {
                            this.a.K2((SparseArray) view2.getTag(R.id.obfuscated_res_0x7f09204d));
                        }
                    } else if ((view2 instanceof TbRichTextView) || view2.getId() == R.id.obfuscated_res_0x7f091864) {
                        SparseArray sparseArray = view2.getTag() instanceof SparseArray ? (SparseArray) view2.getTag() : null;
                        if (sparseArray == null) {
                            return false;
                        }
                        this.a.K2(sparseArray);
                    }
                }
                if (this.a.q != null) {
                    this.a.c.W(this.a.q.y());
                }
                this.a.c.R();
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.xv7.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class v implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        public v(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) ? this.a.T1(view2) : invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class w implements lu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        public w(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // com.baidu.tieba.lu4.e
        public void n0(lu4 lu4Var, int i, View view2) {
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lu4Var, i, view2) == null) {
                if (this.a.h != null) {
                    this.a.h.dismiss();
                }
                this.a.N2(i);
                int i2 = 4;
                switch (i) {
                    case -4:
                        View view3 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0917ee);
                        this.a.D2(view3);
                        if (view3 != null) {
                            view3.performClick();
                            return;
                        }
                        return;
                    case -3:
                        View view4 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0917ed);
                        this.a.D2(view4);
                        if (view4 != null) {
                            view4.performClick();
                            return;
                        }
                        return;
                    case -2:
                        View view5 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0917f0);
                        if (view5 != null) {
                            AgreeView agreeView = (AgreeView) view5;
                            this.a.D2(view5);
                            if (agreeView.getImgDisagree() != null) {
                                agreeView.getImgDisagree().performClick();
                                return;
                            }
                            return;
                        }
                        return;
                    case -1:
                        View view6 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0917f0);
                        if (view6 != null) {
                            this.a.D2(view6);
                            AgreeView agreeView2 = (AgreeView) view6;
                            if (agreeView2.getImgAgree() != null) {
                                agreeView2.getImgAgree().performClick();
                                return;
                            }
                            return;
                        }
                        return;
                    case 0:
                    default:
                        return;
                    case 1:
                        if (this.a.L == null || TextUtils.isEmpty(this.a.M)) {
                            return;
                        }
                        if (this.a.N == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.a.M));
                        } else {
                            v75.a aVar = new v75.a();
                            aVar.a = this.a.M;
                            String str = "";
                            if (this.a.N.memeInfo.pck_id.intValue() >= 0) {
                                str = "" + this.a.N.memeInfo.pck_id;
                            }
                            aVar.b = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                        }
                        this.a.L = null;
                        this.a.M = null;
                        return;
                    case 2:
                        if (this.a.L == null || TextUtils.isEmpty(this.a.M)) {
                            return;
                        }
                        if (this.a.j == null) {
                            this.a.j = new PermissionJudgePolicy();
                        }
                        this.a.j.clearRequestPermissionList();
                        this.a.j.appendRequestPermission(this.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.a.j.startRequestPermission(this.a.getPageContext().getPageActivity())) {
                            return;
                        }
                        if (this.a.K == null) {
                            FoldCommentActivity foldCommentActivity = this.a;
                            foldCommentActivity.K = new ez7(foldCommentActivity.getPageContext());
                        }
                        this.a.K.b(this.a.M, this.a.L.n());
                        this.a.L = null;
                        this.a.M = null;
                        return;
                    case 3:
                        PostData postData = this.a.O;
                        if (postData != null) {
                            postData.C0();
                            this.a.O = null;
                            return;
                        }
                        return;
                    case 4:
                        TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                        if (this.a.checkUpIsLogin()) {
                            this.a.x2(view2);
                            if (this.a.a.S1().O() == null || this.a.a.S1().O().getAuthor() == null || this.a.a.S1().O().getAuthor().getUserId() == null || this.a.A == null) {
                                return;
                            }
                            FoldCommentActivity foldCommentActivity2 = this.a;
                            int j2 = foldCommentActivity2.j2(foldCommentActivity2.a.S1());
                            ThreadData O = this.a.a.S1().O();
                            if (O.isBJHArticleThreadType()) {
                                i2 = 2;
                            } else if (O.isBJHVideoThreadType()) {
                                i2 = 3;
                            } else if (!O.isBJHNormalThreadType()) {
                                i2 = O.isBJHVideoDynamicThreadType() ? 5 : 1;
                            }
                            TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.a.m2()).param("obj_locate", 2).param("obj_id", this.a.a.S1().O().getAuthor().getUserId()).param("obj_type", !this.a.A.e()).param("obj_source", j2).param("obj_param1", i2));
                            return;
                        }
                        return;
                    case 5:
                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c5a);
                            return;
                        }
                        Object tag = view2.getTag();
                        if (tag instanceof String) {
                            TiebaStatic.log(new StatisticItem("c13079"));
                            this.a.m2((String) tag);
                            return;
                        } else if (tag instanceof SparseArray) {
                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                            SparseArray<Object> sparseArray2 = (SparseArray) tag;
                            if ((sparseArray2.get(R.id.obfuscated_res_0x7f092096) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.obfuscated_res_0x7f092096)).booleanValue()) {
                                sparseArray2.put(R.id.obfuscated_res_0x7f09204d, 0);
                                sparseArray2.put(R.id.obfuscated_res_0x7f092036, 2);
                                this.a.O1(sparseArray2);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    case 6:
                        SparseArray sparseArray3 = (SparseArray) view2.getTag();
                        if (sparseArray3 != null && (sparseArray3.get(R.id.obfuscated_res_0x7f09203e) instanceof Integer) && (sparseArray3.get(R.id.obfuscated_res_0x7f09203c) instanceof String) && (sparseArray3.get(R.id.obfuscated_res_0x7f09205a) instanceof Integer) && (sparseArray3.get(R.id.obfuscated_res_0x7f09203d) instanceof Boolean) && (sparseArray3.get(R.id.obfuscated_res_0x7f09204e) instanceof Boolean)) {
                            boolean booleanValue = ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f09203d)).booleanValue();
                            int intValue = ((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f09205a)).intValue();
                            boolean booleanValue2 = ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f09204e)).booleanValue();
                            boolean F = this.a.F(TbadkCoreApplication.getCurrentAccount());
                            if (F) {
                                if (!booleanValue2) {
                                    this.a.I2(sparseArray3, intValue, booleanValue);
                                    return;
                                } else {
                                    this.a.c.N(((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f09203e)).intValue(), (String) sparseArray3.get(R.id.obfuscated_res_0x7f09203c), intValue, booleanValue, null, F);
                                    return;
                                }
                            } else if (booleanValue && !booleanValue2) {
                                this.a.I2(sparseArray3, intValue, booleanValue);
                                return;
                            } else {
                                this.a.c.L(((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f09203e)).intValue(), (String) sparseArray3.get(R.id.obfuscated_res_0x7f09203c), intValue, booleanValue);
                                return;
                            }
                        }
                        return;
                    case 7:
                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c5a);
                            return;
                        }
                        SparseArray<Object> sparseArray4 = (SparseArray) view2.getTag();
                        if (sparseArray4 == null) {
                            return;
                        }
                        boolean booleanValue3 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092082)).booleanValue();
                        boolean booleanValue4 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092080)).booleanValue();
                        boolean booleanValue5 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092096)).booleanValue();
                        if (!booleanValue3) {
                            if (booleanValue4) {
                                this.a.c.L(((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f09203e)).intValue(), (String) sparseArray4.get(R.id.obfuscated_res_0x7f09203c), ((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f09205a)).intValue(), ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f09203d)).booleanValue());
                                return;
                            }
                            return;
                        } else if (booleanValue5) {
                            sparseArray4.put(R.id.obfuscated_res_0x7f09204d, 1);
                            sparseArray4.put(R.id.obfuscated_res_0x7f092036, 2);
                            this.a.O1(sparseArray4);
                            return;
                        } else {
                            sparseArray4.put(R.id.obfuscated_res_0x7f092036, 2);
                            this.a.c.P(view2);
                            return;
                        }
                    case 8:
                        if (this.a.checkUpIsLogin() && (sparseArray = (SparseArray) view2.getTag()) != null) {
                            PostData postData2 = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f09203a);
                            if (postData2.q() == null) {
                                return;
                            }
                            this.a.R1(postData2.q());
                            return;
                        }
                        return;
                    case 9:
                        if (!this.a.checkUpIsLogin() || this.a.a == null || this.a.a.S1() == null) {
                            return;
                        }
                        this.a.H2(st8.c(view2));
                        return;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x implements au4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ FoldCommentActivity d;

        public x(FoldCommentActivity foldCommentActivity, SparseArray sparseArray, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity, sparseArray, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = foldCommentActivity;
            this.a = sparseArray;
            this.b = i;
            this.c = z;
        }

        @Override // com.baidu.tieba.au4.e
        public void onClick(au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, au4Var) == null) {
                if (au4Var != null) {
                    au4Var.dismiss();
                }
                this.d.W1(((Integer) this.a.get(R.id.obfuscated_res_0x7f09203e)).intValue(), (String) this.a.get(R.id.obfuscated_res_0x7f09203c), this.b, this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class y implements au4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        public y(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // com.baidu.tieba.au4.e
        public void onClick(au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, au4Var) == null) {
                au4Var.dismiss();
            }
        }
    }

    public FoldCommentActivity() {
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
        this.g = true;
        this.r = false;
        this.w = new int[2];
        this.A = null;
        this.D = new k(this);
        this.F = 0;
        this.G = new r(this);
        this.H = false;
        this.I = new xv7(new u(this));
        this.J = new v(this);
        this.O = null;
        this.P = new w(this);
        this.R = new a(this);
        this.S = new e(this);
        this.T = new f(this, 2004008);
        this.U = new g(this);
        this.V = UbsABTestHelper.showTrisectionAndFeedback();
        this.Y = new j(this);
        this.Z = new n(this);
        this.a0 = new p(this);
    }

    public final void A2(String str, int i2, AbsPbActivity.e eVar) {
        TbRichTextData tbRichTextData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048576, this, str, i2, eVar) == null) || eVar == null) {
            return;
        }
        vu7 S1 = this.a.S1();
        TbRichText P2 = P2(str, i2);
        if (P2 == null || (tbRichTextData = P2.B().get(this.F)) == null) {
            return;
        }
        eVar.f = String.valueOf(P2.getPostId());
        eVar.a = new ArrayList<>();
        eVar.b = new ConcurrentHashMap<>();
        if (!tbRichTextData.F().H()) {
            eVar.h = false;
            String a2 = wu7.a(tbRichTextData);
            eVar.a.add(a2);
            ImageUrlData imageUrlData = new ImageUrlData();
            imageUrlData.imageUrl = str;
            if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                imageUrlData.urlType = 38;
            } else {
                imageUrlData.urlType = this.f ? 17 : 18;
            }
            imageUrlData.originalUrl = f2(tbRichTextData);
            imageUrlData.originalUrl = f2(tbRichTextData);
            imageUrlData.originalSize = g2(tbRichTextData);
            imageUrlData.mIsShowOrigonButton = d2(tbRichTextData);
            imageUrlData.isLongPic = c2(tbRichTextData);
            imageUrlData.postId = P2.getPostId();
            imageUrlData.mIsReserver = this.a.d2();
            imageUrlData.mIsSeeHost = this.a.v1();
            eVar.b.put(a2, imageUrlData);
            if (S1 != null) {
                if (S1.l() != null) {
                    eVar.c = S1.l().getName();
                    eVar.d = S1.l().getId();
                }
                if (S1.O() != null) {
                    eVar.e = S1.O().getId();
                }
                eVar.g = S1.s() == 1;
            }
            imageUrlData.threadId = dh.g(eVar.e, -1L);
            return;
        }
        eVar.h = true;
        int size = S1.F().size();
        this.H = false;
        eVar.j = -1;
        int b2 = S1.j() != null ? b2(S1.j().W(), P2, i2, i2, eVar.a, eVar.b) : i2;
        for (int i3 = 0; i3 < size; i3++) {
            PostData postData = S1.F().get(i3);
            if (postData.L() == null || S1.j() == null || S1.j().L() == null || !postData.L().equals(S1.j().L())) {
                b2 = b2(postData.W(), P2, b2, i2, eVar.a, eVar.b);
            }
        }
        if (eVar.a.size() > 0) {
            ArrayList<String> arrayList = eVar.a;
            eVar.i = arrayList.get(arrayList.size() - 1);
        }
        if (S1 != null) {
            if (S1.l() != null) {
                eVar.c = S1.l().getName();
                eVar.d = S1.l().getId();
            }
            if (S1.O() != null) {
                eVar.e = S1.O().getId();
            }
            eVar.g = S1.s() == 1;
        }
        eVar.j = b2;
    }

    public void B2() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || !checkUpIsLogin() || (pbModel = this.a) == null || pbModel.S1() == null || this.a.S1().l() == null || N1()) {
            return;
        }
        if (this.a.S1().i0()) {
            this.c.t();
            return;
        }
        if (this.y == null) {
            kq6 kq6Var = new kq6(getPageContext());
            this.y = kq6Var;
            kq6Var.j(0);
            this.y.i(new o(this));
        }
        this.y.g(this.a.S1().l().getId(), dh.g(this.a.m2(), 0L));
    }

    public final AbsPbActivity.e C2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            String str2 = null;
            if (this.a.S1() != null && this.a.S1().F() != null && this.a.S1().F().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i2 = 0;
                while (true) {
                    if (i2 >= this.a.S1().F().size()) {
                        i2 = 0;
                        break;
                    } else if (str.equals(this.a.S1().F().get(i2).L())) {
                        break;
                    } else {
                        i2++;
                    }
                }
                PostData postData = this.a.S1().F().get(i2);
                if (postData.W() != null && postData.W().B() != null) {
                    Iterator<TbRichTextData> it = postData.W().B().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        TbRichTextData next = it.next();
                        if (next != null && next.getType() == 8) {
                            if (next.F() != null) {
                                str2 = next.F().B();
                            }
                        }
                    }
                    A2(str2, 0, eVar);
                    wu7.b(postData, eVar);
                    return eVar;
                }
            }
            return null;
        }
        return (AbsPbActivity.e) invokeL.objValue;
    }

    @Override // com.baidu.tieba.yk5
    public int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public final void D2(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, view2) == null) || view2 == null) {
            return;
        }
        SparseArray sparseArray = (SparseArray) view2.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(R.id.obfuscated_res_0x7f09188a, Integer.valueOf(this.g ? 2 : 3));
        view2.setTag(sparseArray);
    }

    public final boolean E2(View view2) {
        InterceptResult invokeL;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, view2)) == null) {
            if (view2 != null && (view2.getTag() instanceof SparseArray)) {
                Object obj = ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f09203a);
                if (obj instanceof PostData) {
                    PostData postData = (PostData) obj;
                    if (checkUpIsLogin() && (pbModel = this.a) != null && pbModel.S1() != null) {
                        if (this.c.y() != null) {
                            this.c.y().c();
                        }
                        lv7 lv7Var = new lv7();
                        lv7Var.A(this.a.S1().l());
                        lv7Var.E(this.a.S1().O());
                        lv7Var.C(postData);
                        TiebaStatic.log("c11743");
                        this.c.x().V(lv7Var);
                        this.c.x().setPostId(postData.L());
                        v2(view2, postData.s().getUserId(), "", postData);
                        w65 w65Var = this.q;
                        if (w65Var != null) {
                            this.c.W(w65Var.y());
                        }
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.iw7
    public boolean F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            PbModel pbModel = this.a;
            return pbModel != null && pbModel.K2(str);
        }
        return invokeL.booleanValue;
    }

    public final void F2(y65 y65Var) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, y65Var) == null) || y65Var == null || (pbModel = this.a) == null) {
            return;
        }
        y65Var.p(pbModel.r1());
        if (this.a.S1() != null && this.a.S1().l() != null) {
            y65Var.o(this.a.S1().l());
        }
        y65Var.q("pb");
        y65Var.r(this.a);
    }

    @Override // com.baidu.tieba.yk5
    public void G(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, str) == null) {
        }
    }

    public final void G2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.q.X(z);
            this.q.a0(z);
            this.q.i0(z);
        }
    }

    public void H2(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || str == null || this.o == null) {
            return;
        }
        this.o.n(dh.g(str, 0L));
    }

    @Override // com.baidu.tieba.yk5
    public void I(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, context, str) == null) {
        }
    }

    public final void I2(SparseArray<Object> sparseArray, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            s08.e(getActivity(), getPageContext(), new x(this, sparseArray, i2, z), new y(this));
        }
    }

    public final void J2(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z) {
                this.c.d0();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            au4 au4Var = new au4(this);
            if (dj.isEmpty(str)) {
                au4Var.setMessage(getResources().getString(R.string.obfuscated_res_0x7f0f0323, str3));
            } else {
                au4Var.setMessage(str);
            }
            au4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0436, new c(this, userMuteAddAndDelCustomMessage));
            au4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new d(this));
            au4Var.create(getPageContext()).show();
        }
    }

    public final void K2(SparseArray<Object> sparseArray) {
        PostData postData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, sparseArray) == null) && checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.obfuscated_res_0x7f09203a) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f09203a)) != null) {
            L2(postData, false);
        }
    }

    @Override // com.baidu.tieba.yk5
    public ug<RelativeLayout> L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return null;
        }
        return (ug) invokeV.objValue;
    }

    public final void L1() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (pbModel = this.a) == null || pbModel.S1() == null || this.a.S1().O() == null) {
            return;
        }
        ThreadData O = this.a.S1().O();
        O.mRecomAbTag = this.a.X1();
        O.mRecomWeight = this.a.a2();
        O.mRecomSource = this.a.Z1();
        O.mRecomExtra = this.a.Y1();
        O.isSubPb = this.a.F1();
        if (O.getFid() == 0) {
            O.setFid(dh.g(this.a.getForumId(), 0L));
        }
        StatisticItem i2 = gc5.i(this, O, "c13562");
        TbPageTag l2 = gc5.l(this);
        if (l2 != null && "a008".equals(l2.locatePage)) {
            i2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a005");
            i2.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a008");
        }
        if (l2 != null && "a002".equals(l2.locatePage)) {
            i2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a005");
            i2.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
        }
        if (i2 != null) {
            TiebaStatic.log(i2);
        }
    }

    public final void L2(PostData postData, boolean z) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048593, this, postData, z) == null) || postData == null || (pbModel = this.a) == null || pbModel.S1() == null || postData.C() == 1) {
            return;
        }
        String m2 = this.a.m2();
        String L = postData.L();
        int W = this.a.S1() != null ? this.a.S1().W() : 0;
        AbsPbActivity.e C2 = C2(L);
        if (C2 == null) {
            return;
        }
        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this).createSubPbActivityConfig(m2, L, "pb", true, this.r, null, false, null, W, postData.c0(), this.a.S1().d(), false, postData.s() != null ? postData.s().getIconInfo() : null, 5).addBigImageData(C2.a, C2.b, C2.g, C2.j);
        addBigImageData.setKeyPageStartFrom(this.a.R1());
        addBigImageData.setFromFrsForumId(this.a.getFromForumId());
        addBigImageData.setWorksInfoData(this.a.r2());
        addBigImageData.setKeyFromForumId(this.a.getForumId());
        addBigImageData.setBjhData(this.a.k1());
        addBigImageData.setIsOpenEditor(z);
        addBigImageData.setFromFoldComment(true);
        addBigImageData.setFromVideoPageUniqueId((BdUniqueId) getIntent().getSerializableExtra("key_from_video_page_id"));
        sendMessage(new CustomMessage(2002001, addBigImageData));
    }

    public final void M1(vu7 vu7Var, ArrayList<PostData> arrayList) {
        List<PostData> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048594, this, vu7Var, arrayList) == null) || vu7Var == null || vu7Var.T() == null || vu7Var.T().a == null || (list = vu7Var.T().a) == null || arrayList == null) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (list.size() <= 0 || arrayList.size() <= 0) {
            return;
        }
        arrayList3.addAll(list);
        Iterator<PostData> it = arrayList.iterator();
        while (it.hasNext()) {
            PostData next = it.next();
            if (next != null) {
                Iterator it2 = arrayList3.iterator();
                while (it2.hasNext()) {
                    PostData postData = (PostData) it2.next();
                    if (postData != null && !TextUtils.isEmpty(next.L()) && !TextUtils.isEmpty(postData.L()) && next.L().equals(postData.L())) {
                        arrayList2.add(postData);
                    }
                }
            }
        }
        if (arrayList2.size() > 0) {
            arrayList3.removeAll(arrayList2);
        }
        if (arrayList3.size() > 0) {
            arrayList.addAll(arrayList3);
        }
    }

    public void M2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            CustomMessage customMessage = new CustomMessage(2921596);
            customMessage.setTag(this.C);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921596, Boolean.valueOf(z));
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    @Override // com.baidu.tieba.yk5
    public ug<ImageView> N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.B == null) {
                this.B = new ug<>(new q(this), 8, 0);
            }
            return this.B;
        }
        return (ug) invokeV.objValue;
    }

    public final boolean N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel == null || pbModel.S1() == null) {
                return false;
            }
            return AntiHelper.b(getPageContext(), this.a.S1().O()) || AntiHelper.d(getPageContext(), this.a.S1().d());
        }
        return invokeV.booleanValue;
    }

    public final void N2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.a.m2()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(s08.m(i2))));
        }
    }

    @Override // com.baidu.tieba.yk5
    public ug<View> O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return null;
        }
        return (ug) invokeV.objValue;
    }

    public void O1(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = dh.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = dh.g((String) sparseArray.get(R.id.obfuscated_res_0x7f092092), 0L);
            BdUniqueId bdUniqueId = this.k;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            this.Q = sparseArray;
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public final void O2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && TbadkCoreApplication.isLogin() && AddExperiencedModel.E(this.a.getForumId()) && this.a.S1() != null && this.a.S1().l() != null) {
            if (this.a.S1().l().isLike() == 1) {
                this.a.f1().D(this.a.getForumId(), this.a.m2());
            }
        }
    }

    public boolean P1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if ((this.a.S1() != null && (this.a.S1().i0() || ThreadCardUtils.isSelf(this.a.S1().O()))) || this.u == null || this.a.S1() == null || this.a.S1().d() == null) {
                return true;
            }
            return this.u.checkPrivacyBeforeInvokeEditor(this.a.S1().d().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public final TbRichText P2(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048603, this, str, i2)) == null) {
            PbModel pbModel = this.a;
            TbRichText tbRichText = null;
            if (pbModel == null || pbModel.S1() == null || str == null || i2 < 0) {
                return null;
            }
            vu7 S1 = this.a.S1();
            if (S1.j() != null) {
                ArrayList<PostData> arrayList = new ArrayList<>();
                arrayList.add(S1.j());
                tbRichText = a2(arrayList, str, i2);
            }
            if (tbRichText == null) {
                ArrayList<PostData> F = S1.F();
                M1(S1, F);
                return a2(F, str, i2);
            }
            return tbRichText;
        }
        return (TbRichText) invokeLI.objValue;
    }

    @Override // com.baidu.tieba.yk5
    public void Q(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, context, str) == null) {
        }
    }

    public boolean Q1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i2)) == null) {
            if (this.u == null || this.a.S1() == null || ThreadCardUtils.isSelf(this.a.S1().O()) || this.a.S1().d() == null) {
                return true;
            }
            return this.u.checkPrivacyBeforeSend(this.a.S1().d().replyPrivateFlag, i2);
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.tieba.yk5
    public void R(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048606, this, context, str, z) == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void R1(AgreeData agreeData) {
        bc5 currentVisiblePageExtra;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, agreeData) == null) || agreeData == null) {
            return;
        }
        if (this.l == null) {
            this.l = new xw4();
        }
        if (this.m == null) {
            lm8 lm8Var = new lm8();
            this.m = lm8Var;
            lm8Var.a = getUniqueId();
        }
        rq4 rq4Var = new rq4();
        rq4Var.b = 5;
        rq4Var.h = 8;
        rq4Var.g = 2;
        PbModel pbModel2 = this.a;
        if (pbModel2 != null) {
            rq4Var.f = pbModel2.R1();
        }
        rq4Var.a = 2;
        int i2 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                rq4Var.i = 0;
                currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(this);
                if (currentVisiblePageExtra != null) {
                    agreeData.objSource = currentVisiblePageExtra.a();
                }
                this.l.c(agreeData, i2, getUniqueId(), false);
                this.l.d(agreeData, this.m);
                pbModel = this.a;
                if (pbModel != null || pbModel.S1() == null) {
                }
                this.l.b(this, rq4Var, agreeData, this.a.S1().O());
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            rq4Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            rq4Var.i = 1;
        }
        i2 = 0;
        currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(this);
        if (currentVisiblePageExtra != null) {
        }
        this.l.c(agreeData, i2, getUniqueId(), false);
        this.l.d(agreeData, this.m);
        pbModel = this.a;
        if (pbModel != null) {
        }
    }

    public final void S1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            if (this.a.x1() || this.a.A1()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", this.a.m2());
                setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.a.m2()));
            finish();
        }
    }

    @Override // com.baidu.tieba.iw7
    public int T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel == null || pbModel.S1() == null) {
                return 0;
            }
            return this.a.S1().W();
        }
        return invokeV.intValue;
    }

    public final boolean T1(View view2) {
        InterceptResult invokeL;
        SparseArray sparseArray;
        do4 do4Var;
        boolean z;
        boolean z2;
        List<hu4> c2;
        hu4 hu4Var;
        hu4 hu4Var2;
        hu4 hu4Var3;
        on onVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, view2)) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null) {
                return true;
            }
            PostData postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f09203a);
            this.O = postData;
            if (postData == null || (do4Var = this.A) == null) {
                return true;
            }
            if (do4Var.e() && this.O.L() != null) {
                this.O.L().equals(this.a.N1());
            }
            if (this.i == null) {
                lu4 lu4Var = new lu4(this);
                this.i = lu4Var;
                lu4Var.n(this.P);
            }
            ArrayList arrayList = new ArrayList();
            if (view2 == null || sparseArray == null) {
                return true;
            }
            boolean r2 = r2(view2);
            boolean z3 = (!r2(view2) || (onVar = this.L) == null || onVar.t()) ? false : true;
            boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f092053) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092053)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f09203d) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09203d)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f092096) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092096)).booleanValue() : false;
            boolean booleanValue4 = sparseArray.get(R.id.obfuscated_res_0x7f092082) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092082)).booleanValue() : false;
            boolean booleanValue5 = sparseArray.get(R.id.obfuscated_res_0x7f092096) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092096)).booleanValue() : false;
            boolean booleanValue6 = sparseArray.get(R.id.obfuscated_res_0x7f092080) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092080)).booleanValue() : false;
            String str = sparseArray.get(R.id.obfuscated_res_0x7f09204a) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f09204a) : null;
            boolean booleanValue7 = sparseArray.get(R.id.obfuscated_res_0x7f092052) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092052)).booleanValue() : false;
            boolean booleanValue8 = sparseArray.get(R.id.obfuscated_res_0x7f09205b) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09205b)).booleanValue() : false;
            if (r2) {
                z = booleanValue;
                z2 = booleanValue8;
                arrayList.add(new hu4(1, getString(R.string.obfuscated_res_0x7f0f10ae), this.i));
            } else {
                z = booleanValue;
                z2 = booleanValue8;
            }
            if (z3) {
                arrayList.add(new hu4(2, getString(R.string.obfuscated_res_0x7f0f10af), this.i));
            }
            if (!r2 && !z3) {
                hu4 hu4Var4 = new hu4(3, getString(R.string.obfuscated_res_0x7f0f0452), this.i);
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.obfuscated_res_0x7f09203a, this.O);
                hu4Var4.d.setTag(sparseArray2);
                arrayList.add(hu4Var4);
            }
            if (this.mIsLogin) {
                if (!s08.i(this.a) && !booleanValue4 && booleanValue3) {
                    hu4 hu4Var5 = new hu4(5, getString(R.string.obfuscated_res_0x7f0f0b4d), this.i);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.obfuscated_res_0x7f092096, Boolean.TRUE);
                    sparseArray3.put(R.id.obfuscated_res_0x7f092051, sparseArray.get(R.id.obfuscated_res_0x7f092051));
                    sparseArray3.put(R.id.obfuscated_res_0x7f092092, sparseArray.get(R.id.obfuscated_res_0x7f092092));
                    sparseArray3.put(R.id.obfuscated_res_0x7f092093, sparseArray.get(R.id.obfuscated_res_0x7f092093));
                    sparseArray3.put(R.id.obfuscated_res_0x7f092091, sparseArray.get(R.id.obfuscated_res_0x7f092091));
                    sparseArray3.put(R.id.obfuscated_res_0x7f092094, sparseArray.get(R.id.obfuscated_res_0x7f092094));
                    sparseArray3.put(R.id.obfuscated_res_0x7f092095, sparseArray.get(R.id.obfuscated_res_0x7f092095));
                    sparseArray3.put(R.id.obfuscated_res_0x7f09203d, sparseArray.get(R.id.obfuscated_res_0x7f09203d));
                    sparseArray3.put(R.id.obfuscated_res_0x7f09203e, sparseArray.get(R.id.obfuscated_res_0x7f09203e));
                    sparseArray3.put(R.id.obfuscated_res_0x7f09203c, sparseArray.get(R.id.obfuscated_res_0x7f09203c));
                    sparseArray3.put(R.id.obfuscated_res_0x7f09205a, sparseArray.get(R.id.obfuscated_res_0x7f09205a));
                    hu4Var5.d.setTag(sparseArray3);
                    arrayList.add(hu4Var5);
                } else {
                    if (s2(booleanValue2) && TbadkCoreApplication.isLogin()) {
                        hu4 hu4Var6 = new hu4(5, getString(R.string.obfuscated_res_0x7f0f1016), this.i);
                        hu4Var6.d.setTag(str);
                        arrayList.add(hu4Var6);
                    }
                }
                if (booleanValue4) {
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.obfuscated_res_0x7f092082, Boolean.TRUE);
                    sparseArray4.put(R.id.obfuscated_res_0x7f09205a, sparseArray.get(R.id.obfuscated_res_0x7f09205a));
                    sparseArray4.put(R.id.obfuscated_res_0x7f092047, sparseArray.get(R.id.obfuscated_res_0x7f092047));
                    sparseArray4.put(R.id.obfuscated_res_0x7f092048, sparseArray.get(R.id.obfuscated_res_0x7f092048));
                    sparseArray4.put(R.id.obfuscated_res_0x7f092049, sparseArray.get(R.id.obfuscated_res_0x7f092049));
                    sparseArray4.put(R.id.obfuscated_res_0x7f09204a, str);
                    if (!s08.i(this.a) && booleanValue5) {
                        sparseArray4.put(R.id.obfuscated_res_0x7f092096, Boolean.TRUE);
                        sparseArray4.put(R.id.obfuscated_res_0x7f092051, sparseArray.get(R.id.obfuscated_res_0x7f092051));
                        sparseArray4.put(R.id.obfuscated_res_0x7f092092, sparseArray.get(R.id.obfuscated_res_0x7f092092));
                        sparseArray4.put(R.id.obfuscated_res_0x7f092093, sparseArray.get(R.id.obfuscated_res_0x7f092093));
                        sparseArray4.put(R.id.obfuscated_res_0x7f092091, sparseArray.get(R.id.obfuscated_res_0x7f092091));
                        sparseArray4.put(R.id.obfuscated_res_0x7f092094, sparseArray.get(R.id.obfuscated_res_0x7f092094));
                        sparseArray4.put(R.id.obfuscated_res_0x7f092095, sparseArray.get(R.id.obfuscated_res_0x7f092095));
                    } else {
                        sparseArray4.put(R.id.obfuscated_res_0x7f092096, Boolean.FALSE);
                    }
                    if (booleanValue6) {
                        sparseArray4.put(R.id.obfuscated_res_0x7f092080, Boolean.TRUE);
                        sparseArray4.put(R.id.obfuscated_res_0x7f09203d, Boolean.valueOf(booleanValue2));
                        sparseArray4.put(R.id.obfuscated_res_0x7f09203c, sparseArray.get(R.id.obfuscated_res_0x7f09203c));
                        sparseArray4.put(R.id.obfuscated_res_0x7f09203e, sparseArray.get(R.id.obfuscated_res_0x7f09203e));
                        sparseArray4.put(R.id.obfuscated_res_0x7f09204e, sparseArray.get(R.id.obfuscated_res_0x7f09204e));
                        if (booleanValue7) {
                            hu4Var = new hu4(6, getString(R.string.obfuscated_res_0x7f0f04b0), this.i);
                            hu4Var.d.setTag(sparseArray4);
                            hu4Var2 = new hu4(7, getString(R.string.obfuscated_res_0x7f0f02e8), this.i);
                            hu4Var2.d.setTag(sparseArray4);
                        }
                    } else {
                        sparseArray4.put(R.id.obfuscated_res_0x7f092080, Boolean.FALSE);
                    }
                    hu4Var = null;
                    hu4Var2 = new hu4(7, getString(R.string.obfuscated_res_0x7f0f02e8), this.i);
                    hu4Var2.d.setTag(sparseArray4);
                } else {
                    if (booleanValue6) {
                        SparseArray sparseArray5 = new SparseArray();
                        sparseArray5.put(R.id.obfuscated_res_0x7f092082, Boolean.FALSE);
                        sparseArray5.put(R.id.obfuscated_res_0x7f092096, Boolean.FALSE);
                        sparseArray5.put(R.id.obfuscated_res_0x7f092080, Boolean.TRUE);
                        sparseArray5.put(R.id.obfuscated_res_0x7f09205a, sparseArray.get(R.id.obfuscated_res_0x7f09205a));
                        sparseArray5.put(R.id.obfuscated_res_0x7f09203d, Boolean.valueOf(booleanValue2));
                        sparseArray5.put(R.id.obfuscated_res_0x7f09203c, sparseArray.get(R.id.obfuscated_res_0x7f09203c));
                        sparseArray5.put(R.id.obfuscated_res_0x7f09203e, sparseArray.get(R.id.obfuscated_res_0x7f09203e));
                        sparseArray5.put(R.id.obfuscated_res_0x7f09204e, sparseArray.get(R.id.obfuscated_res_0x7f09204e));
                        if (this.a.S1().W() == 1002 && !booleanValue2) {
                            hu4Var3 = new hu4(6, getString(R.string.obfuscated_res_0x7f0f1016), this.i);
                        } else {
                            hu4Var3 = new hu4(6, getString(R.string.obfuscated_res_0x7f0f04b0), this.i);
                        }
                        hu4Var3.d.setTag(sparseArray5);
                        if (z2) {
                            new hu4(13, getString(R.string.obfuscated_res_0x7f0f0b3d), this.i);
                        }
                        hu4Var = hu4Var3;
                    } else {
                        hu4Var = null;
                    }
                    hu4Var2 = null;
                }
                if (hu4Var != null) {
                    arrayList.add(hu4Var);
                }
                if (hu4Var2 != null) {
                    arrayList.add(hu4Var2);
                }
                s08.b(arrayList, this.i, this.O, this.a);
            }
            if (UbsABTestHelper.isPBPlanA()) {
                c2 = s08.d(arrayList, this.O.q(), sparseArray, this.i);
            } else {
                c2 = s08.c(arrayList, this.O.q(), sparseArray, this.i);
            }
            s08.l(c2, this.g);
            s08.f(c2);
            this.i.o(s08.g(this.O));
            if (UbsABTestHelper.isPBPlanA()) {
                this.i.k(c2, false);
            } else {
                this.i.k(c2, true);
            }
            ju4 ju4Var = new ju4(getPageContext(), this.i);
            this.h = ju4Var;
            ju4Var.k();
            TiebaStatic.log(new StatisticItem("c13272").param("tid", this.a.m2()).param("fid", this.a.getForumId()).param("uid", this.a.S1().O().getAuthor().getUserId()).param("post_id", this.a.B()).param("obj_source", z ? 2 : 1));
            return true;
        }
        return invokeL.booleanValue;
    }

    public void U1(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(zy7.k2)).intValue();
            if (intValue == zy7.l2) {
                if (this.n.S()) {
                    return;
                }
                String str = (String) sparseArray.get(R.id.obfuscated_res_0x7f09203c);
                int intValue2 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f09205a)).intValue();
                boolean booleanValue = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09203d)).booleanValue();
                int intValue3 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f09203e)).intValue();
                boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f092050) != null ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092050)).booleanValue() : false;
                if (jSONArray != null) {
                    this.n.U(StringHelper.JsonArrayToString(jSONArray));
                }
                this.n.V(this.a.S1().l().getId(), this.a.S1().l().getName(), this.a.S1().O().getId(), str, intValue3, intValue2, booleanValue, this.a.S1().O().getBaijiahaoData(), booleanValue2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            } else if (intValue == zy7.m2 || intValue == zy7.o2) {
                if (this.a.n1() != null) {
                    this.a.n1().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == zy7.m2) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }

    @Override // com.baidu.tieba.yk5
    public void V(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048612, this, context, str, str2) == null) {
        }
    }

    public void V1(au4 au4Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, au4Var, jSONArray) == null) {
            au4Var.dismiss();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (au4Var.getYesButtonTag() instanceof SparseArray) {
                    U1((SparseArray) au4Var.getYesButtonTag(), jSONArray);
                    return;
                }
                return;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        }
    }

    public void W1(int i2, String str, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f09203c, str);
            sparseArray.put(R.id.obfuscated_res_0x7f09203e, Integer.valueOf(i2));
            sparseArray.put(R.id.obfuscated_res_0x7f09205a, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f09203d, Boolean.valueOf(z));
            sparseArray.put(zy7.k2, Integer.valueOf(zy7.l2));
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                U1(sparseArray, null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    @Override // com.baidu.tieba.iw7
    public String X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null) {
                return pbModel.r1();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public final void X1(ForumManageModel.b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048616, this, bVar, z) == null) || bVar == null) {
            return;
        }
        String string = !TextUtils.isEmpty(bVar.b) ? bVar.b : getString(R.string.obfuscated_res_0x7f0f04b5);
        int i2 = 0;
        if (bVar.c == 1211066) {
            hideProgressBar();
            au4 au4Var = new au4(getPageContext().getPageActivity());
            au4Var.setMessage(string);
            au4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04f3, new b(this));
            au4Var.setCancelable(true);
            au4Var.create(getPageContext());
            au4Var.show();
        } else if (bVar.d != 0) {
            this.c.v(0, bVar.a, bVar.b, z);
        }
        if (bVar.a) {
            int i3 = bVar.d;
            if (i3 == 1) {
                ArrayList<PostData> F = this.a.S1().F();
                int size = F.size();
                while (true) {
                    if (i2 >= size) {
                        break;
                    } else if (bVar.g.equals(F.get(i2).L())) {
                        F.remove(i2);
                        break;
                    } else {
                        i2++;
                    }
                }
                this.a.S1().O().setReply_num(this.a.S1().O().getReply_num() - 1);
            } else if (i3 == 0) {
                S1();
            } else if (i3 == 2) {
                ArrayList<PostData> F2 = this.a.S1().F();
                int size2 = F2.size();
                boolean z2 = false;
                for (int i4 = 0; i4 < size2 && !z2; i4++) {
                    int i5 = 0;
                    while (true) {
                        if (i5 >= F2.get(i4).Z().size()) {
                            break;
                        } else if (bVar.g.equals(F2.get(i4).Z().get(i5).L())) {
                            F2.get(i4).Z().remove(i5);
                            F2.get(i4).k();
                            z2 = true;
                            break;
                        } else {
                            i5++;
                        }
                    }
                    F2.get(i4).l(bVar.g);
                }
            }
        }
    }

    @Override // com.baidu.tieba.yk5
    public void Y(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048617, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.yk5
    public ug<TextView> Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return null;
        }
        return (ug) invokeV.objValue;
    }

    public AntiData Y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel == null || pbModel.S1() == null) {
                return null;
            }
            return this.a.S1().d();
        }
        return (AntiData) invokeV.objValue;
    }

    public PostData Z1() {
        InterceptResult invokeV;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel == null || pbModel.S1() == null || this.a.S1().O() == null || this.a.S1().O().getAuthor() == null) {
                return null;
            }
            PostData postData = new PostData();
            MetaData author = this.a.S1().O().getAuthor();
            String userId = author.getUserId();
            HashMap<String, MetaData> userMap = this.a.S1().O().getUserMap();
            if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                author = metaData;
            }
            postData.D0(1);
            postData.J0(this.a.S1().O().getFirstPostId());
            postData.a1(this.a.S1().O().getTitle());
            postData.Z0(this.a.S1().O().getCreateTime());
            postData.B0(author);
            return postData;
        }
        return (PostData) invokeV.objValue;
    }

    public final TbRichText a2(ArrayList<PostData> arrayList, String str, int i2) {
        InterceptResult invokeLLI;
        ArrayList<TbRichTextData> B;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048621, this, arrayList, str, i2)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    TbRichText W = arrayList.get(i3).W();
                    if (W != null && (B = W.B()) != null) {
                        int size = B.size();
                        int i4 = -1;
                        for (int i5 = 0; i5 < size; i5++) {
                            if (B.get(i5) != null && B.get(i5).getType() == 8) {
                                i4++;
                                if (B.get(i5).F().B().equals(str) || B.get(i5).F().C().equals(str)) {
                                    int h2 = (int) ej.h(TbadkCoreApplication.getInst());
                                    int width = B.get(i5).F().getWidth() * h2;
                                    int height = B.get(i5).F().getHeight() * h2;
                                    if (width < 80 || height < 80 || width * height < 10000) {
                                        return null;
                                    }
                                    this.F = i5;
                                    return W;
                                } else if (i4 > i2) {
                                    break;
                                }
                            }
                        }
                        continue;
                    }
                }
            }
            return null;
        }
        return (TbRichText) invokeLLI.objValue;
    }

    public final int b2(TbRichText tbRichText, TbRichText tbRichText2, int i2, int i3, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        InterceptResult invokeCommon;
        TbRichTextImageInfo F;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048622, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i2), Integer.valueOf(i3), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.H = true;
            }
            if (tbRichText != null) {
                int size = tbRichText.B().size();
                int i4 = i2;
                int i5 = -1;
                for (int i6 = 0; i6 < size; i6++) {
                    TbRichTextData tbRichTextData = tbRichText.B().get(i6);
                    if ((tbRichTextData == null || tbRichTextData.getType() != 20) && tbRichTextData != null && tbRichTextData.getType() == 8) {
                        i5++;
                        int h2 = (int) ej.h(TbadkCoreApplication.getInst());
                        int width = tbRichTextData.F().getWidth() * h2;
                        int height = tbRichTextData.F().getHeight() * h2;
                        if ((width < 80 || height < 80 || width * height < 10000) || !tbRichTextData.F().H()) {
                            if (tbRichText == tbRichText2) {
                                if (i5 <= i3) {
                                    i4--;
                                }
                            }
                        } else if (tbRichTextData.getType() != 20) {
                            String a2 = wu7.a(tbRichTextData);
                            if (!TextUtils.isEmpty(a2)) {
                                arrayList.add(a2);
                                if (tbRichTextData != null && (F = tbRichTextData.F()) != null) {
                                    String B = F.B();
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                        imageUrlData.urlType = 38;
                                        B = F.C();
                                    } else {
                                        imageUrlData.urlType = this.f ? 17 : 18;
                                    }
                                    imageUrlData.imageUrl = B;
                                    imageUrlData.originalUrl = f2(tbRichTextData);
                                    imageUrlData.originalSize = g2(tbRichTextData);
                                    imageUrlData.mIsShowOrigonButton = d2(tbRichTextData);
                                    imageUrlData.isLongPic = c2(tbRichTextData);
                                    imageUrlData.postId = tbRichText.getPostId();
                                    imageUrlData.threadId = dh.g(this.a.m2(), -1L);
                                    imageUrlData.mIsReserver = this.a.d2();
                                    imageUrlData.mIsSeeHost = this.a.v1();
                                    if (concurrentHashMap != null) {
                                        concurrentHashMap.put(a2, imageUrlData);
                                    }
                                }
                            }
                            if (!this.H) {
                                i4++;
                            }
                        }
                    }
                }
                return i4;
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    public final boolean c2(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.F() == null) {
                return false;
            }
            return tbRichTextData.F().I();
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            if (this.r) {
                ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 1);
            } else {
                ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            }
        }
    }

    public final boolean d2(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.F() == null) {
                return false;
            }
            return tbRichTextData.F().J();
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.yk5
    public ug<ItemCardView> e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return null;
        }
        return (ug) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i e1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    public PbModel e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.a : (PbModel) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            if (this.r) {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 1);
            } else {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            }
        }
    }

    public final String f2(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048630, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.F() == null) {
                return null;
            }
            return tbRichTextData.F().D();
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.yk5
    public void g1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048631, this, context, str) == null) {
        }
    }

    public final long g2(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048632, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.F() == null) {
                return 0L;
            }
            return tbRichTextData.F().getOriginalSize();
        }
        return invokeL.longValue;
    }

    @Override // com.baidu.tieba.yk5
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return null;
        }
        return (ListView) invokeV.objValue;
    }

    public w65 h2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.q : (w65) invokeV.objValue;
    }

    public e08 i2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.e : (e08) invokeV.objValue;
    }

    public final int j2(vu7 vu7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048636, this, vu7Var)) == null) {
            if (vu7Var == null || vu7Var.O() == null) {
                return 0;
            }
            if (vu7Var.O().getThreadType() == 0) {
                return 1;
            }
            if (vu7Var.O().getThreadType() == 54) {
                return 2;
            }
            return vu7Var.O().getThreadType() == 40 ? 3 : 4;
        }
        return invokeL.intValue;
    }

    public final void k2(int i2, Intent intent) {
        g55 g55Var;
        g55 g55Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048637, this, i2, intent) == null) {
            if (i2 == 0) {
                this.c.D();
                this.c.y().c();
                this.c.a0(false);
            }
            this.c.R();
            if (intent == null) {
                return;
            }
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                writeData.setWriteImagesInfo(pbEditorData.getWriteImagesInfo());
                int editorType = pbEditorData.getEditorType();
                if (editorType != 0) {
                    if (editorType != 1 || this.c.y() == null || this.c.y().b() == null) {
                        return;
                    }
                    a75 b2 = this.c.y().b();
                    b2.d0(this.a.S1().O());
                    b2.C(writeData);
                    b2.e0(pbEditorData.getVoiceModel());
                    f55 n2 = b2.a().n(6);
                    if (n2 != null && (g55Var2 = n2.m) != null) {
                        g55Var2.B(new u45(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i2 == -1) {
                        b2.G();
                        return;
                    }
                    return;
                }
                this.q.L();
                this.q.m0(pbEditorData.getVoiceModel());
                this.q.B(writeData);
                f55 n3 = this.q.a().n(6);
                if (n3 != null && (g55Var = n3.m) != null) {
                    g55Var.B(new u45(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i2 == -1) {
                    this.q.G(null, null);
                }
            }
        }
    }

    public void l2(boolean z, String str, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048638, this, new Object[]{Boolean.valueOf(z), str, sparseArray}) == null) {
            String str2 = sparseArray.get(R.id.obfuscated_res_0x7f092093) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092093) : "";
            String str3 = sparseArray.get(R.id.obfuscated_res_0x7f092095) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092095) : "";
            String str4 = sparseArray.get(R.id.obfuscated_res_0x7f092094) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092094) : "";
            String str5 = sparseArray.get(R.id.obfuscated_res_0x7f092090) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092090) : "";
            String str6 = sparseArray.get(R.id.obfuscated_res_0x7f092091) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092091) : "";
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.k);
            userMuteAddAndDelCustomMessage.setTag(this.k);
            J2(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public final void m2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, str) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.S1() != null && this.a.S1().i0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.a.m2(), str);
                ThreadData O = this.a.S1().O();
                if (O.isBJHArticleThreadType()) {
                    format = format + "&channelid=33833";
                } else if (O.isBjhDynamicThread()) {
                    format = format + "&channelid=33842";
                } else if (O.isBJHVideoThreadType()) {
                    format = format + "&channelid=33840";
                }
                t2(format);
                return;
            }
            this.b.a(str);
        }
    }

    public final void n2(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, bundle) == null) {
            this.k = getUniqueId();
            do4 c2 = do4.c(this);
            this.A = c2;
            if (c2 != null) {
                c2.j(this.a0);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this);
            this.n = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.R);
            if (bundle != null) {
                this.a = new PbModel(this, bundle, this.D);
            } else {
                this.a = new PbModel(this, getIntent(), this.D);
            }
            this.a.C3(true);
            this.a.E3(4);
        }
    }

    public final boolean o2(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048641, this, bundle)) == null) {
            if (bundle != null) {
                this.r = bundle.getBoolean("is_jump_from_video_tab", false);
            } else {
                this.r = getIntent().getBooleanExtra("is_jump_from_video_tab", false);
            }
            return this.r;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048642, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            this.q.C(i2, i3, intent);
            if (this.c.y() != null) {
                this.c.y().g(i2, i3, intent);
            }
            if (i2 == 25035) {
                k2(i3, intent);
            }
            if (i3 == -1) {
                if (i2 == 13008) {
                    oy7.b().m();
                    this.mHandler.postDelayed(new h(this), 1000L);
                } else if (i2 == 13011) {
                    pc8.g().m(getPageContext());
                } else if (i2 != 24007) {
                } else {
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        pc8.g().m(getPageContext());
                        O2();
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.v;
                        if (shareSuccessReplyToServerModel == null || shareItem == null || (str = shareItem.x) == null) {
                            return;
                        }
                        shareSuccessReplyToServerModel.z(str, intExtra, new i(this));
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048643, this, i2) == null) {
        }
    }

    @Override // com.baidu.tieba.au4.e
    public void onClick(au4 au4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, au4Var) == null) {
            V1(au4Var, null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, bundle) == null) {
            o2(bundle);
            super.onCreate(bundle);
            VoiceManager voiceManager = new VoiceManager();
            this.t = voiceManager;
            voiceManager.onCreate(getPageContext());
            n2(bundle);
            p2(bundle);
            u2();
            if (this.r) {
                this.c.A().setAnimTime(0);
                this.c.A().setIsFromVideoTab(true);
            }
            if (getIntent() != null && this.r) {
                this.C = (BdUniqueId) getIntent().getSerializableExtra("key_from_video_page_id");
            }
            this.c.A().h();
            this.c.x().setFromForumId(this.a.getFromForumId());
            b18 b18Var = new b18(this);
            this.b = b18Var;
            b18Var.b(getUniqueId());
            this.o = new tt8(getPageContext(), getUniqueId());
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.u = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new s(this));
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.q.c0(TbSingleton.getInstance().getAdVertiComment());
            } else {
                this.q.c0(this.c.z());
            }
            x25.b(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048646, this) == null) {
            super.onDestroy();
            ReplyPrivacyCheckController replyPrivacyCheckController = this.u;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            super.onPause();
            if (this.r) {
                M2(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048648, this) == null) {
            super.onResume();
            if (this.r) {
                M2(true);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.s
    public void p0(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048649, this, spannableStringBuilder, textView, tbRichTextView) == null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (vk5[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), vk5.class);
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (fz7.c(objArr[i2].d()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                spannableStringBuilder2.setSpan(new ni5(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i2], spannableStringBuilder.getSpanStart(objArr[i2]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    public final void p2(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, bundle) == null) {
            this.d = new c08(this);
            this.e = new e08(getPageContext());
            uw7 uw7Var = new uw7(this, this.Y, this.G, this.I, this.J);
            this.c = uw7Var;
            uw7Var.Y(this.a);
            setContentView(this.c.A(), new FlowLayout.LayoutParams(-1, -1));
            adjustResizeForSoftInput();
            addGlobalLayoutListener();
            this.c.s();
            this.c.V(new t(this));
            y65 y65Var = new y65();
            this.p = y65Var;
            F2(y65Var);
            w65 w65Var = (w65) this.p.a(getActivity());
            this.q = w65Var;
            w65Var.W(getPageContext());
            this.q.g0(this.S);
            this.q.Y(1);
            this.q.A(getPageContext(), bundle);
            this.q.a().b(new e55(getActivity()));
            this.q.a().C(true);
            G2(true);
            this.q.J(this.a.u1(), this.a.m2(), this.a.q1());
            this.c.T(this.q.a());
            this.s = new cz7();
            if (this.q.s() != null) {
                this.s.m(this.q.s().i());
            }
            registerListener(this.T);
            if (!this.a.F1()) {
                this.q.q(this.a.m2());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.q.c0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.a.A2()) {
                this.q.c0(getPageContext().getString(R.string.obfuscated_res_0x7f0f0e0a));
            } else {
                uw7 uw7Var2 = this.c;
                if (uw7Var2 != null) {
                    this.q.c0(uw7Var2.z());
                }
            }
            this.v = new ShareSuccessReplyToServerModel();
        }
    }

    public boolean q2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null) {
                return pbModel.v1();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean r2(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048652, this, view2)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean s2(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048653, this, z)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.S1() != null) {
                return ((this.a.S1().W() != 0) || this.a.S1().O() == null || this.a.S1().O().getAuthor() == null || TextUtils.equals(this.a.S1().O().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) ? this.t : (VoiceManager) invokeV.objValue;
    }

    public final void t2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this, "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    @Override // com.baidu.tieba.iw7
    public boolean u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel == null) {
                return false;
            }
            return pbModel.J2();
        }
        return invokeV.booleanValue;
    }

    public final void u2() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048657, this) == null) || (pbModel = this.a) == null) {
            return;
        }
        pbModel.T2();
    }

    public final void v2(View view2, String str, String str2, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048658, this, view2, str, str2, postData) == null) || view2 == null || str == null || str2 == null || !P1()) {
            return;
        }
        if (view2.getParent() instanceof View) {
            ((View) view2.getParent()).getLocationOnScreen(this.w);
            this.x = ((View) view2.getParent()).getMeasuredHeight();
        }
        if (this.c.y() != null && postData != null) {
            this.c.y().j(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f100c), postData.s().getName_show(), postData.W() != null ? postData.W().toString() : ""));
        }
        if (this.a.S1() != null && this.a.S1().i0()) {
            gh.a().postDelayed(new l(this, str, str2), 0L);
            return;
        }
        if (this.z == null) {
            kq6 kq6Var = new kq6(getPageContext());
            this.z = kq6Var;
            kq6Var.j(1);
            this.z.i(new m(this, str, str2));
        }
        PbModel pbModel = this.a;
        if (pbModel == null || pbModel.S1() == null || this.a.S1().l() == null) {
            return;
        }
        this.z.g(this.a.S1().l().getId(), dh.g(this.a.m2(), 0L));
    }

    @Override // com.baidu.tieba.yk5
    public ug<GifView> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            return null;
        }
        return (ug) invokeV.objValue;
    }

    public final void w2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048660, this) == null) {
            vu7 S1 = this.a.S1();
            this.a.H3(true);
            do4 do4Var = this.A;
            if (do4Var != null) {
                S1.H0(do4Var.g());
            }
        }
    }

    public final void x() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048661, this) == null) || (voiceManager = this.t) == null) {
            return;
        }
        voiceManager.stopPlay();
    }

    public final void x2(View view2) {
        SparseArray sparseArray;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048662, this, view2) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f09203a)) == null) {
                return;
            }
            y2(postData);
        }
    }

    @Override // com.baidu.tieba.yk5
    public ug<TiebaPlusRecommendCard> y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            return null;
        }
        return (ug) invokeV.objValue;
    }

    public void y2(PostData postData) {
        do4 do4Var;
        PostData Z1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048664, this, postData) == null) || postData == null) {
            return;
        }
        boolean z = false;
        if (postData.L() != null && postData.L().equals(this.a.N1())) {
            z = true;
        }
        MarkData M1 = this.a.M1(postData);
        if (this.a.S1() != null && this.a.S1().i0() && (Z1 = Z1()) != null) {
            M1 = this.a.M1(Z1);
        }
        if (M1 == null || (do4Var = this.A) == null) {
            return;
        }
        do4Var.i(M1);
        if (!z) {
            this.A.a();
        } else {
            this.A.d();
        }
    }

    @Override // com.baidu.tieba.yk5
    public ug<LinearLayout> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            return null;
        }
        return (ug) invokeV.objValue;
    }

    @Override // com.baidu.tieba.iw7
    public c08 z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) ? this.d : (c08) invokeV.objValue;
    }

    public final void z2(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048667, this, i2, str) == null) {
            if (this.a.t2()) {
                showToast(str);
            } else if (!ej.D()) {
                this.c.f0(R.string.obfuscated_res_0x7f0f0fcc);
            } else if (i2 == 4) {
                uw7 uw7Var = this.c;
                uw7Var.g0(str + "(4" + SmallTailInfo.EMOTION_SUFFIX, true);
            } else if (!TextUtils.isEmpty(str)) {
                uw7 uw7Var2 = this.c;
                uw7Var2.g0(str + "(" + i2 + SmallTailInfo.EMOTION_SUFFIX, true);
            } else {
                this.c.f0(R.string.obfuscated_res_0x7f0f0c73);
            }
        }
    }
}
