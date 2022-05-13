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
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ReplyPrivacyCheckController;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
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
import com.baidu.tbadk.util.PageType;
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
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a9;
import com.repackage.au7;
import com.repackage.b35;
import com.repackage.bg;
import com.repackage.bg5;
import com.repackage.bm8;
import com.repackage.bs7;
import com.repackage.bv7;
import com.repackage.by7;
import com.repackage.cg;
import com.repackage.co;
import com.repackage.cs7;
import com.repackage.d35;
import com.repackage.dt7;
import com.repackage.e35;
import com.repackage.eu4;
import com.repackage.ex7;
import com.repackage.ey4;
import com.repackage.fo4;
import com.repackage.fw7;
import com.repackage.g15;
import com.repackage.g85;
import com.repackage.gt7;
import com.repackage.gz4;
import com.repackage.hw7;
import com.repackage.hx7;
import com.repackage.hz4;
import com.repackage.i15;
import com.repackage.iz4;
import com.repackage.j15;
import com.repackage.jw7;
import com.repackage.jx7;
import com.repackage.kg;
import com.repackage.ki;
import com.repackage.kw7;
import com.repackage.l85;
import com.repackage.li;
import com.repackage.ln4;
import com.repackage.m98;
import com.repackage.mi;
import com.repackage.ne5;
import com.repackage.ng;
import com.repackage.nr4;
import com.repackage.ot7;
import com.repackage.pj8;
import com.repackage.rm6;
import com.repackage.rs7;
import com.repackage.ur4;
import com.repackage.vx7;
import com.repackage.vy7;
import com.repackage.w05;
import com.repackage.wr4;
import com.repackage.xl4;
import com.repackage.xq8;
import com.repackage.xv7;
import com.repackage.y25;
import com.repackage.yf5;
import com.repackage.yq8;
import com.repackage.yr4;
import com.repackage.z25;
import com.repackage.z35;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class FoldCommentActivity extends BaseFragmentActivity implements VoiceManager.j, ot7<NewSubPbActivity>, TbRichTextView.s, nr4.e, bg5 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CHECK_MUTE_FROM_DIALOG = 2;

    /* renamed from: CHECK_MUTE_FROM＿FLOOR  reason: contains not printable characters */
    public static final int f3CHECK_MUTE_FROMFLOOR = 1;
    public static final String PB_LITERATURE_LOOK_MORE_ICON_SUFFIX = "#4%2&@#907$12#@96476)w7we9e~@$%&&";
    public static final int PROFESSION_PERMISSION_TYPE_REPLY_FLOOR = 1;
    public static final int PROFESSION_PERMISSION_TYPE_REPLY_POST = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId MESSAGE_ID_PB;
    public View floorReplyView;
    public int imgIndex;
    public boolean index_valid;
    public boolean isDialogFromLongClick;
    public y25 mCheckSubFloorCallBack;
    public View.OnClickListener mCommonOnClickListener;
    public hw7 mContentProcessController;
    public CustomMessageListener mDraftLoadListener;
    public EmotionImageData mEmotionImageData;
    public TbRichTextMemeInfo mEmotionInfo;
    public Object mExtra;
    public final a9 mForumManageCallBack;
    public ForumManageModel mForumManageModel;
    public bg<ImageView> mImageViewPool;
    public boolean mIsFromCDN;
    public boolean mIsFromVideoTab;
    public PbModel.h mLoadPbCallback;
    public wr4 mLongClickDialog;
    public final xl4.a mMarkDoneCallBack;
    public xl4 mMarkModel;
    public eu4 mMessageHelper;
    public PbModel mModel;
    public pj8 mMsgData;
    public NewWriteModel.g mOnFloorPostWriteNewCallback;
    public final TbRichTextView.y mOnImageClickListener;
    public final View.OnLongClickListener mOnLongClickListener;
    public b35 mPbEditor;
    public hx7 mPbEventController;
    public jx7 mPbPostShareController;
    public d35 mPbeb;
    public PermissionJudgePolicy mPermissionJudgement;
    public yr4 mPopupDialogView;
    public z25 mPrePostCallBack;
    public rm6 mProfessionController;
    public ex7 mReplyEmotionModel;
    public int[] mReplyFloorLocation;
    public int mReplyFloorMeasureHeight;
    public ReplyPrivacyCheckController mReplyPrivacyController;
    public co mSaveBdImage;
    public jw7 mSaveImageHelper;
    public String mSaveImageUrl;
    public ShareSuccessReplyToServerModel mShareSuccessReplyToServerModel;
    public rm6 mSubReplyPermissionController;
    public dt7 mTbGestureDetector;
    public by7 mUEGReportController;
    public yq8 mUserBlockController;
    public BdUniqueId mVideoPageUniqueId;
    public au7 mView;
    public VoiceManager mVoiceManager;
    public View moreReplyView;
    public yr4.e onLongClickItemClickListener;
    public PostData postData;
    public boolean showTrisectionAndFeedback;
    public View tempView;

    /* loaded from: classes3.dex */
    public class a extends a9 {
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

        @Override // com.repackage.a9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                boolean z = false;
                if (obj != null) {
                    int loadDataMode = this.a.mForumManageModel.getLoadDataMode();
                    if (loadDataMode == 0) {
                        this.a.mModel.q2();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        this.a.finishDelPost(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
                        return;
                    } else if (loadDataMode != 1) {
                        return;
                    } else {
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        this.a.mView.v(1, dVar.a, dVar.b, true);
                        return;
                    }
                }
                this.a.mView.v(this.a.mForumManageModel.getLoadDataMode(), false, null, false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements nr4.e {
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

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) || nr4Var == null) {
                return;
            }
            nr4Var.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements nr4.e {
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

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                this.b.mView.d0();
                MessageManager.getInstance().sendMessage(this.a);
                nr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements nr4.e {
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

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                nr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements z25 {
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

        @Override // com.repackage.z25
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.showProgressBar();
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if (this.a.mPbEditor != null) {
                this.a.mView.W(this.a.mPbEditor.C());
            }
            this.a.mView.a0(false);
        }
    }

    /* loaded from: classes3.dex */
    public class g implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        /* loaded from: classes3.dex */
        public class a implements nr4.e {
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

            @Override // com.repackage.nr4.e
            public void onClick(nr4 nr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                    nr4Var.dismiss();
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements nr4.e {
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

            @Override // com.repackage.nr4.e
            public void onClick(nr4 nr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                    nr4Var.dismiss();
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

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ey4 ey4Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, ey4Var, writeData, antiData}) == null) {
                if (!li.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.mModel != null && this.a.mModel.P1() != null) {
                        statisticItem.param("fid", this.a.mModel.P1().m());
                    }
                    if (this.a.mModel != null) {
                        statisticItem.param("tid", this.a.mModel.h2());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (z) {
                    hw7 hw7Var = this.a.mContentProcessController;
                    if (hw7Var != null) {
                        hw7Var.d();
                    }
                    if (postWriteCallBackData == null || postWriteCallBackData.getIconStampData() == null) {
                        return;
                    }
                    iz4.c(this.a.getPageContext(), postWriteCallBackData, 2);
                    return;
                }
                if ((postWriteCallBackData != null ? postWriteCallBackData.getErrorCode() : -1) == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.a.mReplyPrivacyController;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                        return;
                    }
                    return;
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (li.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.s(this.a.getActivity(), this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f046e), null).u();
                    } else {
                        DefaultNavigationBarCoverTip.s(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    nr4 nr4Var = new nr4(this.a.getActivity());
                    if (li.isEmpty(postWriteCallBackData.getErrorString())) {
                        nr4Var.setMessage(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0ce4));
                    } else {
                        nr4Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    nr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0374, new a(this));
                    nr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0ce6, new b(this));
                    nr4Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData == null || !postWriteCallBackData.isSensitiveError()) {
                    return;
                }
                FoldCommentActivity foldCommentActivity = this.a;
                if (foldCommentActivity.mContentProcessController == null) {
                    return;
                }
                if (foldCommentActivity.mView != null && this.a.mView.y() != null && this.a.mView.y().b() != null && this.a.mView.y().b().x()) {
                    this.a.mView.y().b().v(postWriteCallBackData);
                }
                this.a.mContentProcessController.l(postWriteCallBackData);
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.mModel == null) {
                return;
            }
            this.a.mModel.loadData();
        }
    }

    /* loaded from: classes3.dex */
    public class i implements ShareSuccessReplyToServerModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        /* loaded from: classes3.dex */
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
                    gt7.a(this.b.a.getPageContext(), this.a).show();
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
                ng.a().postDelayed(new a(this, customDialogData), 1000L);
            }
        }
    }

    /* loaded from: classes3.dex */
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
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null) {
                return;
            }
            if ((view2 instanceof TbListTextView) && (view2.getParent() instanceof TbRichTextView)) {
                StatisticItem statisticItem2 = new StatisticItem("c13398");
                statisticItem2.param("tid", this.a.mModel.h2());
                statisticItem2.param("fid", this.a.mModel.getForumId());
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("obj_locate", 1);
                TiebaStatic.log(statisticItem2);
                TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.obfuscated_res_0x7f091eae);
                    if (obj instanceof PostData) {
                        PostData postData = (PostData) obj;
                        if (this.a.mModel == null || this.a.mModel.P1() == null || postData.s() == null || postData.A() == 1 || !this.a.checkUpIsLogin()) {
                            return;
                        }
                        if (this.a.mView.y() != null) {
                            this.a.mView.y().c();
                        }
                        rs7 rs7Var = new rs7();
                        rs7Var.A(this.a.mModel.P1().l());
                        rs7Var.E(this.a.mModel.P1().O());
                        rs7Var.C(postData);
                        this.a.mView.x().U(rs7Var);
                        this.a.mView.x().setPostId(postData.I());
                        this.a.locateSubPbEditor(view2, postData.s().getUserId(), "", postData);
                        TiebaStatic.log("c11743");
                        vy7.b(this.a.mModel.P1(), postData, postData.h0, 8, 1);
                        if (this.a.mPbEditor != null) {
                            this.a.mView.W(this.a.mPbEditor.C());
                        }
                    }
                }
            } else if (view2.getId() != R.id.obfuscated_res_0x7f0916dd && view2.getId() != R.id.obfuscated_res_0x7f091733) {
                if (view2.getId() != R.id.obfuscated_res_0x7f091e0b && view2.getId() != R.id.obfuscated_res_0x7f091e09 && view2.getId() != R.id.obfuscated_res_0x7f0916db && view2.getId() != R.id.obfuscated_res_0x7f091576) {
                    if ((view2.getId() == R.id.obfuscated_res_0x7f091739 || view2.getId() == R.id.obfuscated_res_0x7f0918fe || view2.getId() == R.id.obfuscated_res_0x7f0916d5) && this.a.mModel != null) {
                        if (view2.getId() == R.id.obfuscated_res_0x7f091739) {
                            StatisticItem statisticItem3 = new StatisticItem("c13398");
                            statisticItem3.param("tid", this.a.mModel.h2());
                            statisticItem3.param("fid", this.a.mModel.getForumId());
                            statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                            statisticItem3.param("obj_locate", 6);
                            TiebaStatic.log(statisticItem3);
                        }
                        if (view2.getId() == R.id.obfuscated_res_0x7f0918fe) {
                            if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                this.a.floorReplyView = view2;
                                return;
                            }
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f091739 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                            this.a.floorReplyView = view2;
                            return;
                        }
                        if (this.a.checkUpIsLogin() && (view2.getTag() instanceof SparseArray)) {
                            SparseArray sparseArray = (SparseArray) view2.getTag();
                            if (sparseArray.get(R.id.obfuscated_res_0x7f091eca) instanceof PostData) {
                                PostData postData2 = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091eca);
                                if (view2.getId() == R.id.obfuscated_res_0x7f091739 && (statisticItem = postData2.i0) != null) {
                                    StatisticItem copy = statisticItem.copy();
                                    copy.delete("obj_locate");
                                    copy.param("obj_locate", 8);
                                    TiebaStatic.log(copy);
                                } else if (view2.getId() == R.id.obfuscated_res_0x7f0918fe || view2.getId() == R.id.obfuscated_res_0x7f0916d5) {
                                    TiebaStatic.log(new StatisticItem("c13700").param("tid", this.a.mModel.i2()).param("fid", this.a.mModel.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData2.I()).param("obj_source", 1).param("obj_type", 3));
                                }
                                if (this.a.mModel == null || this.a.mModel.P1() == null || postData2.s() == null || postData2.A() == 1) {
                                    return;
                                }
                                if (this.a.mView.y() != null) {
                                    this.a.mView.y().c();
                                }
                                if (this.a.showTrisectionAndFeedback && postData2.R() != null && postData2.R().size() != 0) {
                                    this.a.startSubPbActivity(postData2, true);
                                    return;
                                }
                                rs7 rs7Var2 = new rs7();
                                rs7Var2.A(this.a.mModel.P1().l());
                                rs7Var2.E(this.a.mModel.P1().O());
                                rs7Var2.C(postData2);
                                this.a.mView.x().U(rs7Var2);
                                this.a.mView.x().setPostId(postData2.I());
                                this.a.locateSubPbEditor(view2, postData2.s().getUserId(), "", postData2);
                                if (this.a.mPbEditor != null) {
                                    this.a.mView.W(this.a.mPbEditor.C());
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (view2.getId() == R.id.obfuscated_res_0x7f091576) {
                    StatisticItem statisticItem4 = new StatisticItem("c13398");
                    statisticItem4.param("tid", this.a.mModel.h2());
                    statisticItem4.param("fid", this.a.mModel.getForumId());
                    statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem4.param("obj_locate", 4);
                    TiebaStatic.log(statisticItem4);
                }
                if (view2.getId() == R.id.obfuscated_res_0x7f0916db && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                    this.a.moreReplyView = view2;
                } else if (this.a.checkUpIsLogin()) {
                    if (this.a.mModel == null || this.a.mModel.P1() == null) {
                        return;
                    }
                    this.a.mView.u();
                    SparseArray sparseArray2 = (SparseArray) view2.getTag();
                    PostData postData3 = (PostData) sparseArray2.get(R.id.obfuscated_res_0x7f091eca);
                    PostData postData4 = (PostData) sparseArray2.get(R.id.obfuscated_res_0x7f091ecb);
                    View view3 = (View) sparseArray2.get(R.id.obfuscated_res_0x7f091ecc);
                    if (postData3 == null || view3 == null) {
                        return;
                    }
                    if (postData3.E() == 1) {
                        TiebaStatic.log(new StatisticItem("c12630"));
                    }
                    StatisticItem statisticItem5 = postData3.i0;
                    if (statisticItem5 != null) {
                        StatisticItem copy2 = statisticItem5.copy();
                        copy2.delete("obj_locate");
                        if (view2.getId() == R.id.obfuscated_res_0x7f091576) {
                            copy2.param("obj_locate", 6);
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f0916db) {
                            copy2.param("obj_locate", 8);
                        }
                        TiebaStatic.log(copy2);
                    }
                    if (view2.getId() == R.id.obfuscated_res_0x7f0916db && this.a.mModel != null && this.a.mModel.P1() != null && postData3 != null) {
                        TiebaStatic.log(new StatisticItem("c14443").param("tid", this.a.mModel.h2()).param("fname", this.a.mModel.P1().n()).param("fid", this.a.mModel.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData3.I()));
                    }
                    String h2 = this.a.mModel.h2();
                    String I = postData3.I();
                    String I2 = postData4 != null ? postData4.I() : "";
                    int V = this.a.mModel.P1() != null ? this.a.mModel.P1().V() : 0;
                    this.a.stopVoice();
                    if (view2.getId() == R.id.obfuscated_res_0x7f091aae) {
                        AbsPbActivity.e processSubPbImg = this.a.processSubPbImg(I);
                        if (this.a.mModel == null || this.a.mModel.P1() == null || processSubPbImg == null) {
                            return;
                        }
                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(h2, I, "pb", true, this.a.mIsFromVideoTab, null, true, null, V, postData3.U(), this.a.mModel.P1().d(), false, postData3.s().getIconInfo(), 5).addBigImageData(processSubPbImg.a, processSubPbImg.b, processSubPbImg.g, processSubPbImg.j);
                        addBigImageData.setKeyPageStartFrom(this.a.mModel.O1());
                        addBigImageData.setFromFrsForumId(this.a.mModel.getFromForumId());
                        addBigImageData.setWorksInfoData(this.a.mModel.m2());
                        addBigImageData.setKeyFromForumId(this.a.mModel.getForumId());
                        addBigImageData.setBjhData(this.a.mModel.h1());
                        addBigImageData.setTiebaPlusData(this.a.mModel.H(), this.a.mModel.D(), this.a.mModel.E(), this.a.mModel.C(), this.a.mModel.I());
                        addBigImageData.setFromFoldComment(true);
                        addBigImageData.setFromVideoPageUniqueId((BdUniqueId) this.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData));
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f0916db && this.a.mIsFromVideoTab) {
                        AbsPbActivity.e processSubPbImg2 = this.a.processSubPbImg(I);
                        if (this.a.mModel == null || this.a.mModel.P1() == null || processSubPbImg2 == null) {
                            return;
                        }
                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(h2, I, "pb", true, this.a.mIsFromVideoTab, null, true, null, V, postData3.U(), this.a.mModel.P1().d(), false, postData3.s().getIconInfo(), 5).addBigImageData(processSubPbImg2.a, processSubPbImg2.b, processSubPbImg2.g, processSubPbImg2.j);
                        addBigImageData2.setKeyPageStartFrom(this.a.mModel.O1());
                        addBigImageData2.setFromFrsForumId(this.a.mModel.getFromForumId());
                        addBigImageData2.setWorksInfoData(this.a.mModel.m2());
                        addBigImageData2.setKeyFromForumId(this.a.mModel.getForumId());
                        addBigImageData2.setBjhData(this.a.mModel.h1());
                        addBigImageData2.setTiebaPlusData(this.a.mModel.H(), this.a.mModel.D(), this.a.mModel.E(), this.a.mModel.C(), this.a.mModel.I());
                        addBigImageData2.setFromFoldComment(true);
                        addBigImageData2.setFromVideoPageUniqueId((BdUniqueId) this.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData2));
                    } else {
                        TiebaStatic.log("c11742");
                        AbsPbActivity.e processSubPbImg3 = this.a.processSubPbImg(I);
                        if (postData3 == null || this.a.mModel == null || this.a.mModel.P1() == null || processSubPbImg3 == null) {
                            return;
                        }
                        SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(h2, I, "pb", true, this.a.mIsFromVideoTab, null, false, I2, V, postData3.U(), this.a.mModel.P1().d(), false, postData3.s().getIconInfo(), 5).addBigImageData(processSubPbImg3.a, processSubPbImg3.b, processSubPbImg3.g, processSubPbImg3.j);
                        if (!li.isEmpty(I2)) {
                            addBigImageData3.setHighLightPostId(I2);
                            addBigImageData3.setKeyIsUseSpid(true);
                        }
                        addBigImageData3.setKeyFromForumId(this.a.mModel.getForumId());
                        addBigImageData3.setTiebaPlusData(this.a.mModel.H(), this.a.mModel.D(), this.a.mModel.E(), this.a.mModel.C(), this.a.mModel.I());
                        addBigImageData3.setBjhData(this.a.mModel.h1());
                        addBigImageData3.setKeyPageStartFrom(this.a.mModel.O1());
                        addBigImageData3.setFromFrsForumId(this.a.mModel.getFromForumId());
                        addBigImageData3.setWorksInfoData(this.a.mModel.m2());
                        addBigImageData3.setFromFoldComment(true);
                        addBigImageData3.setFromVideoPageUniqueId((BdUniqueId) this.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData3));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 3).param("fid", this.a.mModel.P1().m()));
                }
            } else {
                StatisticItem statisticItem6 = new StatisticItem("c13398");
                statisticItem6.param("tid", this.a.mModel.h2());
                statisticItem6.param("fid", this.a.mModel.getForumId());
                statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem6.param("obj_locate", 7);
                TiebaStatic.log(statisticItem6);
                if (this.a.mModel != null && this.a.mModel.P1() != null && this.a.postData != null) {
                    TiebaStatic.log(new StatisticItem("c14441").param("tid", this.a.mModel.h2()).param("fname", this.a.mModel.P1().n()).param("fid", this.a.mModel.P1().m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.postData.I()));
                }
                FoldCommentActivity foldCommentActivity = this.a;
                foldCommentActivity.isDialogFromLongClick = false;
                foldCommentActivity.dealLongClickListener(view2);
            }
        }
    }

    /* loaded from: classes3.dex */
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
        public void b(bs7 bs7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bs7Var) == null) {
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void c(boolean z, int i, int i2, int i3, bs7 bs7Var, String str, int i4) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), bs7Var, str, Integer.valueOf(i4)}) == null) || this.a.mView == null) {
                return;
            }
            this.a.mView.U();
            if (!z) {
                this.a.onNetOrDataError(i, str);
                return;
            }
            this.a.mView.E();
            if (bs7Var != null) {
                if (bs7Var.s() == 1) {
                    this.a.mIsFromCDN = true;
                } else {
                    this.a.mIsFromCDN = false;
                }
                String str2 = null;
                if (this.a.mModel == null || !this.a.mModel.v2()) {
                    if (this.a.mView != null) {
                        str2 = this.a.mView.z();
                    }
                } else {
                    str2 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0dda);
                }
                if (!StringUtils.isNull(str2)) {
                    this.a.mPbEditor.k0(TbSingleton.getInstance().getAdVertiComment(bs7Var.k0(), bs7Var.l0(), str2));
                }
                this.a.mView.S(bs7Var, this.a.mIsFromCDN);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ FoldCommentActivity c;

        /* loaded from: classes3.dex */
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
                hw7 hw7Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (hw7Var = this.a.c.mContentProcessController) == null || hw7Var.g() == null) {
                    return;
                }
                if (!this.a.c.mContentProcessController.g().e()) {
                    this.a.c.mContentProcessController.b(false);
                }
                this.a.c.mContentProcessController.g().l(false);
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
                int i2 = mi.i(this.c.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i = TbadkCoreApplication.getInst().getKeyboardHeight();
                    f = mi.f(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                } else {
                    i = i2 / 2;
                    f = mi.f(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                }
                int i3 = i2 - (i + f);
                FoldCommentActivity foldCommentActivity = this.c;
                boolean z = true;
                foldCommentActivity.mView.w().smoothScrollBy((foldCommentActivity.mReplyFloorLocation[1] + foldCommentActivity.mReplyFloorMeasureHeight) - i3, 50);
                if (this.c.mView.y() != null) {
                    this.c.mPbEditor.a().setVisibility(8);
                    this.c.mView.y().o(this.a, this.b, this.c.mView.z(), (this.c.mModel == null || this.c.mModel.P1() == null || this.c.mModel.P1().O() == null || !this.c.mModel.P1().O().isBjh()) ? false : false);
                    e35 b = this.c.mView.y().b();
                    if (b != null && this.c.mModel != null && this.c.mModel.P1() != null) {
                        b.G(this.c.mModel.P1().d());
                        b.c0(this.c.mModel.P1().O());
                    }
                    if (this.c.mContentProcessController.f() == null && this.c.mView.y().b().t() != null) {
                        this.c.mView.y().b().t().f(new a(this));
                        FoldCommentActivity foldCommentActivity2 = this.c;
                        foldCommentActivity2.mContentProcessController.n(foldCommentActivity2.mView.y().b().t().h());
                        this.c.mView.y().b().M(this.c.mCheckSubFloorCallBack);
                    }
                }
                this.c.mView.B();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m implements rm6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ FoldCommentActivity c;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ m a;

            /* renamed from: com.baidu.tieba.pb.pb.foldcomment.FoldCommentActivity$m$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class C0221a implements TextWatcher {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public C0221a(a aVar) {
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
                    hw7 hw7Var;
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (hw7Var = this.a.a.c.mContentProcessController) == null || hw7Var.g() == null) {
                        return;
                    }
                    if (!this.a.a.c.mContentProcessController.g().e()) {
                        this.a.a.c.mContentProcessController.b(false);
                    }
                    this.a.a.c.mContentProcessController.g().l(false);
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
                    int i2 = mi.i(this.a.c.getApplicationContext());
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        i = TbadkCoreApplication.getInst().getKeyboardHeight();
                        f = mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                    } else {
                        i = i2 / 2;
                        f = mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                    }
                    int i3 = i2 - (i + f);
                    FoldCommentActivity foldCommentActivity = this.a.c;
                    boolean z = true;
                    foldCommentActivity.mView.w().smoothScrollBy((foldCommentActivity.mReplyFloorLocation[1] + foldCommentActivity.mReplyFloorMeasureHeight) - i3, 50);
                    if (this.a.c.mView.y() != null) {
                        this.a.c.mPbEditor.a().setVisibility(8);
                        z = (this.a.c.mModel == null || this.a.c.mModel.P1() == null || this.a.c.mModel.P1().O() == null || !this.a.c.mModel.P1().O().isBjh()) ? false : false;
                        bv7 y = this.a.c.mView.y();
                        m mVar = this.a;
                        y.o(mVar.a, mVar.b, mVar.c.mView.z(), z);
                        e35 b = this.a.c.mView.y().b();
                        if (b != null && this.a.c.mModel != null && this.a.c.mModel.P1() != null) {
                            b.G(this.a.c.mModel.P1().d());
                            b.c0(this.a.c.mModel.P1().O());
                        }
                        if (this.a.c.mContentProcessController.f() == null && this.a.c.mView.y().b().t() != null) {
                            this.a.c.mView.y().b().t().f(new C0221a(this));
                            FoldCommentActivity foldCommentActivity2 = this.a.c;
                            foldCommentActivity2.mContentProcessController.n(foldCommentActivity2.mView.y().b().t().h());
                            this.a.c.mView.y().b().M(this.a.c.mCheckSubFloorCallBack);
                        }
                    }
                    this.a.c.mView.B();
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

        @Override // com.repackage.rm6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.repackage.rm6.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                ng.a().postDelayed(new a(this), 0L);
            }
        }

        @Override // com.repackage.rm6.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n implements y25 {
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

        @Override // com.repackage.y25
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                hw7 hw7Var = this.a.mContentProcessController;
                if (hw7Var == null || hw7Var.g() == null || !this.a.mContentProcessController.g().d()) {
                    return !this.a.checkPrivacyBeforePost(ReplyPrivacyCheckController.TYPE_FLOOR);
                }
                FoldCommentActivity foldCommentActivity = this.a;
                foldCommentActivity.showToast(foldCommentActivity.mContentProcessController.g().c());
                if (this.a.mView != null && this.a.mView.y() != null && this.a.mView.y().b() != null && this.a.mView.y().b().x()) {
                    this.a.mView.y().b().v(this.a.mContentProcessController.h());
                }
                this.a.mContentProcessController.b(true);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class o implements rm6.d {
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

        @Override // com.repackage.rm6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.repackage.rm6.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                if (this.a.mPbEditor != null && this.a.mPbEditor.a() != null) {
                    this.a.mPbEditor.a().A(new w05(45, 27, null));
                }
                this.a.mView.t();
            }
        }

        @Override // com.repackage.rm6.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class p implements xl4.a {
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

        @Override // com.repackage.xl4.a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                if (z) {
                    if (this.a.mMarkModel != null) {
                        this.a.mMarkModel.h(z2);
                    }
                    this.a.mModel.C3(z2);
                    if (this.a.mModel.A1()) {
                        this.a.makeFakeMark();
                    }
                    if (z2) {
                        if (this.a.mMarkModel != null) {
                            if (this.a.mMarkModel.f() == null || this.a.mModel == null || this.a.mModel.P1() == null || this.a.mModel.P1().O() == null || this.a.mModel.P1().O().getAuthor() == null) {
                                return;
                            }
                            MarkData f = this.a.mMarkModel.f();
                            MetaData author = this.a.mModel.P1().O().getAuthor();
                            if (f != null && author != null) {
                                if (StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), author.getUserId()) || author.hadConcerned()) {
                                    this.a.showToast(R.string.obfuscated_res_0x7f0f00d0);
                                    if (gz4.f(this.a.getActivity(), 0)) {
                                        gz4.h(this.a.getPageContext(), 6, 2000L);
                                    }
                                }
                            } else {
                                FoldCommentActivity foldCommentActivity = this.a;
                                foldCommentActivity.showToast(foldCommentActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f00cf));
                            }
                        }
                        this.a.addCollectionStat();
                        return;
                    }
                    FoldCommentActivity foldCommentActivity2 = this.a;
                    foldCommentActivity2.showToast(foldCommentActivity2.getPageContext().getString(R.string.obfuscated_res_0x7f0f0f9c));
                    return;
                }
                FoldCommentActivity foldCommentActivity3 = this.a;
                foldCommentActivity3.showToast(foldCommentActivity3.getPageContext().getString(R.string.obfuscated_res_0x7f0f14b8));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class q implements cg<ImageView> {
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
        @Override // com.repackage.cg
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.cg
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
                    if (ln4.c().g()) {
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
        @Override // com.repackage.cg
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
        @Override // com.repackage.cg
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.getPageContext().getPageActivity());
                boolean g = ln4.c().g();
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

    /* loaded from: classes3.dex */
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

        /* JADX DEBUG: Multi-variable search result rejected for r14v21, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$b */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.y
        public void a(View view2, String str, int i, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    if (view2.getTag(R.id.obfuscated_res_0x7f091ee4) == null || !(view2.getTag(R.id.obfuscated_res_0x7f091ee4) instanceof TbRichTextMemeInfo) || !(view2 instanceof TbImageView)) {
                        if (this.a.mModel.P1().g0()) {
                            ArrayList<String> arrayList = new ArrayList<>();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                            TbRichTextView tbRichTextView = null;
                            if (view2.getParent() instanceof TbRichTextView) {
                                tbRichTextView = (TbRichTextView) view2.getParent();
                            } else if ((view2.getParent() instanceof GridImageLayout) && (view2.getParent().getParent() instanceof TbRichTextView)) {
                                tbRichTextView = (TbRichTextView) view2.getParent().getParent();
                            }
                            int i2 = -1;
                            if (tbRichTextView != null && tbRichTextView.getRichText() != null && tbRichTextView.getRichText().C() != null) {
                                ArrayList<TbRichTextImageInfo> C = tbRichTextView.getRichText().C();
                                int i3 = -1;
                                for (int i4 = 0; i4 < C.size(); i4++) {
                                    if (C.get(i4) != null) {
                                        arrayList.add(C.get(i4).D());
                                        if (i3 == -1 && str != null && (str.equals(C.get(i4).D()) || str.equals(C.get(i4).A()) || str.equals(C.get(i4).y()) || str.equals(C.get(i4).z()) || str.equals(C.get(i4).C()))) {
                                            i3 = i4;
                                        }
                                        ImageUrlData imageUrlData = new ImageUrlData();
                                        imageUrlData.imageUrl = C.get(i4).D();
                                        imageUrlData.originalUrl = C.get(i4).D();
                                        imageUrlData.isLongPic = C.get(i4).G();
                                        concurrentHashMap.put(C.get(i4).D(), imageUrlData);
                                    }
                                }
                                i2 = i3;
                            }
                            ImageViewerConfig.b bVar = new ImageViewerConfig.b();
                            bVar.x(arrayList);
                            bVar.B(i2);
                            bVar.C(false);
                            bVar.F(this.a.mModel.a2());
                            bVar.w(concurrentHashMap);
                            bVar.H(true);
                            bVar.K(false);
                            bVar.G(this.a.isHostOnlyMode());
                            if (this.a.mModel != null) {
                                bVar.A(this.a.mModel.getFromForumId());
                                if (this.a.mModel.P1() != null) {
                                    bVar.N(this.a.mModel.P1().O());
                                }
                            }
                            ImageViewerConfig v = bVar.v(this.a.getPageContext().getPageActivity());
                            v.getIntent().putExtra("from", "pb");
                            this.a.sendMessage(new CustomMessage(2010000, v));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                            return;
                        }
                        AbsPbActivity.e eVar = new AbsPbActivity.e();
                        this.a.processImgUrls(str, i, eVar);
                        if (eVar.h) {
                            TbRichText validImage = this.a.validImage(str, i);
                            if (validImage != null && this.a.imgIndex >= 0 && this.a.imgIndex < validImage.A().size()) {
                                ArrayList<String> arrayList2 = new ArrayList<>();
                                String a = cs7.a(validImage.A().get(this.a.imgIndex));
                                int i5 = 0;
                                while (true) {
                                    if (i5 >= eVar.a.size()) {
                                        break;
                                    } else if (eVar.a.get(i5).equals(a)) {
                                        eVar.j = i5;
                                        arrayList2.add(a);
                                        break;
                                    } else {
                                        i5++;
                                    }
                                }
                                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                                if (!ListUtils.isEmpty(arrayList2)) {
                                    String str2 = arrayList2.get(0);
                                    concurrentHashMap2.put(str2, eVar.b.get(str2));
                                }
                                ImageViewerConfig.b bVar2 = new ImageViewerConfig.b();
                                bVar2.x(arrayList2);
                                bVar2.z(eVar.c);
                                bVar2.y(eVar.d);
                                bVar2.O(eVar.e);
                                bVar2.C(eVar.g);
                                bVar2.H(true);
                                bVar2.J(eVar.i);
                                bVar2.F(this.a.mModel.a2());
                                bVar2.w(concurrentHashMap2);
                                bVar2.K(false);
                                bVar2.G(this.a.isHostOnlyMode());
                                bVar2.L(eVar.f);
                                if (this.a.mModel != null) {
                                    bVar2.A(this.a.mModel.getFromForumId());
                                    if (this.a.mModel.P1() != null) {
                                        bVar2.N(this.a.mModel.P1().O());
                                    }
                                }
                                ImageViewerConfig v2 = bVar2.v(this.a.getPageContext().getPageActivity());
                                v2.getIntent().putExtra("from", "pb");
                                this.a.sendMessage(new CustomMessage(2010000, v2));
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                                return;
                            }
                            return;
                        }
                        ArrayList arrayList3 = new ArrayList();
                        arrayList3.add(ListUtils.getItem(eVar.a, 0));
                        ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
                        if (!ListUtils.isEmpty(arrayList3)) {
                            String str3 = (String) arrayList3.get(0);
                            concurrentHashMap3.put(str3, eVar.b.get(str3));
                        }
                        ImageViewerConfig.b bVar3 = new ImageViewerConfig.b();
                        bVar3.x(arrayList3);
                        bVar3.z(eVar.c);
                        bVar3.y(eVar.d);
                        bVar3.O(eVar.e);
                        bVar3.C(eVar.g);
                        bVar3.H(true);
                        bVar3.J(eVar.a.get(0));
                        bVar3.F(this.a.mModel.a2());
                        bVar3.w(concurrentHashMap3);
                        bVar3.K(false);
                        bVar3.G(this.a.isHostOnlyMode());
                        bVar3.L(eVar.f);
                        bVar3.D(false);
                        if (this.a.mModel != null) {
                            bVar3.A(this.a.mModel.getFromForumId());
                            if (this.a.mModel.P1() != null) {
                                bVar3.N(this.a.mModel.P1().O());
                            }
                        }
                        ImageViewerConfig v3 = bVar3.v(this.a.getPageContext().getPageActivity());
                        v3.getIntent().putExtra("from", "pb");
                        this.a.sendMessage(new CustomMessage(2010000, v3));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                        return;
                    }
                    TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f091ee4);
                    boolean x = ((TbImageView) view2).x();
                    if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                        this.a.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(this.a.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, x)));
                    }
                    this.a.tempView = view2;
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
                    this.a.mPbEditor.L(null, null);
                } else if (i == ReplyPrivacyCheckController.TYPE_FLOOR && this.a.mView != null && this.a.mView.y() != null && this.a.mView.y().b() != null) {
                    this.a.mView.y().b().F();
                } else if (i == ReplyPrivacyCheckController.TYPE_EMOTION_IMAGE) {
                    FoldCommentActivity foldCommentActivity = this.a;
                    foldCommentActivity.sendEmotion(foldCommentActivity.mEmotionImageData);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class t implements PbFragment.d3 {
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

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.d3
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!ki.z()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c2e);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.mModel.P1().l().getId(), this.a.mModel.P1().l().getName(), this.a.mModel.P1().O().getId(), String.valueOf(this.a.mModel.P1().U().getUserId()), objArr.length > 1 ? String.valueOf(objArr[1]) : "", objArr.length > 3 ? String.valueOf(objArr[3]) : "", objArr.length > 2 ? String.valueOf(objArr[2]) : "", objArr.length > 4 ? String.valueOf(objArr[4]) : "")));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class u implements dt7.a {
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

        @Override // com.repackage.dt7.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.repackage.dt7.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (view2 != null) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f091ac8) {
                        if (this.a.richTextHandleSingleTap(view2)) {
                            return true;
                        }
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f0916da) {
                        if (view2.getTag(R.id.obfuscated_res_0x7f091ec1) instanceof SparseArray) {
                            this.a.startSubPbActivity((SparseArray) view2.getTag(R.id.obfuscated_res_0x7f091ec1));
                        }
                    } else if ((view2 instanceof TbRichTextView) || view2.getId() == R.id.obfuscated_res_0x7f091732) {
                        SparseArray sparseArray = view2.getTag() instanceof SparseArray ? (SparseArray) view2.getTag() : null;
                        if (sparseArray == null) {
                            return false;
                        }
                        this.a.startSubPbActivity(sparseArray);
                    }
                }
                if (this.a.mPbEditor != null) {
                    this.a.mView.W(this.a.mPbEditor.C());
                }
                this.a.mView.R();
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.repackage.dt7.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
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
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) ? this.a.dealLongClickListener(view2) : invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class w implements yr4.e {
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

        @Override // com.repackage.yr4.e
        public void onItemClick(yr4 yr4Var, int i, View view2) {
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, yr4Var, i, view2) == null) {
                if (this.a.mLongClickDialog != null) {
                    this.a.mLongClickDialog.dismiss();
                }
                this.a.trackDialogItem(i);
                int i2 = 4;
                switch (i) {
                    case -4:
                        View view3 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0916c0);
                        this.a.putTrackTagToPerformView(view3);
                        if (view3 != null) {
                            view3.performClick();
                            return;
                        }
                        return;
                    case -3:
                        View view4 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0916bf);
                        this.a.putTrackTagToPerformView(view4);
                        if (view4 != null) {
                            view4.performClick();
                            return;
                        }
                        return;
                    case -2:
                        View view5 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0916c2);
                        if (view5 != null) {
                            AgreeView agreeView = (AgreeView) view5;
                            this.a.putTrackTagToPerformView(view5);
                            if (agreeView.getImgDisagree() != null) {
                                agreeView.getImgDisagree().performClick();
                                return;
                            }
                            return;
                        }
                        return;
                    case -1:
                        View view6 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0916c2);
                        if (view6 != null) {
                            this.a.putTrackTagToPerformView(view6);
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
                        if (this.a.mSaveBdImage == null || TextUtils.isEmpty(this.a.mSaveImageUrl)) {
                            return;
                        }
                        if (this.a.mEmotionInfo == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.a.mSaveImageUrl));
                        } else {
                            z35.a aVar = new z35.a();
                            aVar.a = this.a.mSaveImageUrl;
                            String str = "";
                            if (this.a.mEmotionInfo.memeInfo.pck_id.intValue() >= 0) {
                                str = "" + this.a.mEmotionInfo.memeInfo.pck_id;
                            }
                            aVar.b = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                        }
                        this.a.mSaveBdImage = null;
                        this.a.mSaveImageUrl = null;
                        return;
                    case 2:
                        if (this.a.mSaveBdImage == null || TextUtils.isEmpty(this.a.mSaveImageUrl)) {
                            return;
                        }
                        if (this.a.mPermissionJudgement == null) {
                            this.a.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        this.a.mPermissionJudgement.clearRequestPermissionList();
                        this.a.mPermissionJudgement.appendRequestPermission(this.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.a.mPermissionJudgement.startRequestPermission(this.a.getPageContext().getPageActivity())) {
                            return;
                        }
                        if (this.a.mSaveImageHelper == null) {
                            FoldCommentActivity foldCommentActivity = this.a;
                            foldCommentActivity.mSaveImageHelper = new jw7(foldCommentActivity.getPageContext());
                        }
                        this.a.mSaveImageHelper.b(this.a.mSaveImageUrl, this.a.mSaveBdImage.n());
                        this.a.mSaveBdImage = null;
                        this.a.mSaveImageUrl = null;
                        return;
                    case 3:
                        PostData postData = this.a.postData;
                        if (postData != null) {
                            postData.o0();
                            this.a.postData = null;
                            return;
                        }
                        return;
                    case 4:
                        TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                        if (this.a.checkUpIsLogin()) {
                            this.a.markFloor(view2);
                            if (this.a.mModel.P1().O() == null || this.a.mModel.P1().O().getAuthor() == null || this.a.mModel.P1().O().getAuthor().getUserId() == null || this.a.mMarkModel == null) {
                                return;
                            }
                            FoldCommentActivity foldCommentActivity2 = this.a;
                            int threadType = foldCommentActivity2.getThreadType(foldCommentActivity2.mModel.P1());
                            ThreadData O = this.a.mModel.P1().O();
                            if (O.isBJHArticleThreadType()) {
                                i2 = 2;
                            } else if (O.isBJHVideoThreadType()) {
                                i2 = 3;
                            } else if (!O.isBJHNormalThreadType()) {
                                i2 = O.isBJHVideoDynamicThreadType() ? 5 : 1;
                            }
                            TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.mModel.h2()).param("obj_locate", 2).param("obj_id", this.a.mModel.P1().O().getAuthor().getUserId()).param("obj_type", !this.a.mMarkModel.e()).param("obj_source", threadType).param("obj_param1", i2));
                            return;
                        }
                        return;
                    case 5:
                        if (!ki.z()) {
                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c2e);
                            return;
                        }
                        Object tag = view2.getTag();
                        if (tag instanceof String) {
                            TiebaStatic.log(new StatisticItem("c13079"));
                            this.a.handleReportClicked((String) tag);
                            return;
                        } else if (tag instanceof SparseArray) {
                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                            SparseArray<Object> sparseArray2 = (SparseArray) tag;
                            if ((sparseArray2.get(R.id.obfuscated_res_0x7f091f03) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.obfuscated_res_0x7f091f03)).booleanValue()) {
                                sparseArray2.put(R.id.obfuscated_res_0x7f091ec1, 0);
                                sparseArray2.put(R.id.obfuscated_res_0x7f091eaa, 2);
                                this.a.checkMuteState(sparseArray2);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    case 6:
                        SparseArray sparseArray3 = (SparseArray) view2.getTag();
                        if (sparseArray3 != null && (sparseArray3.get(R.id.obfuscated_res_0x7f091eb2) instanceof Integer) && (sparseArray3.get(R.id.obfuscated_res_0x7f091eb0) instanceof String) && (sparseArray3.get(R.id.obfuscated_res_0x7f091ecd) instanceof Integer) && (sparseArray3.get(R.id.obfuscated_res_0x7f091eb1) instanceof Boolean) && (sparseArray3.get(R.id.obfuscated_res_0x7f091ec2) instanceof Boolean)) {
                            boolean booleanValue = ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f091eb1)).booleanValue();
                            int intValue = ((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f091ecd)).intValue();
                            boolean booleanValue2 = ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f091ec2)).booleanValue();
                            boolean isHost = this.a.isHost(TbadkCoreApplication.getCurrentAccount());
                            if (isHost) {
                                if (!booleanValue2) {
                                    this.a.showDelNoSubPostDialog(sparseArray3, intValue, booleanValue);
                                    return;
                                } else {
                                    this.a.mView.N(((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f091eb2)).intValue(), (String) sparseArray3.get(R.id.obfuscated_res_0x7f091eb0), intValue, booleanValue, null, isHost);
                                    return;
                                }
                            } else if (booleanValue && !booleanValue2) {
                                this.a.showDelNoSubPostDialog(sparseArray3, intValue, booleanValue);
                                return;
                            } else {
                                this.a.mView.L(((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f091eb2)).intValue(), (String) sparseArray3.get(R.id.obfuscated_res_0x7f091eb0), intValue, booleanValue);
                                return;
                            }
                        }
                        return;
                    case 7:
                        if (!ki.z()) {
                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c2e);
                            return;
                        }
                        SparseArray<Object> sparseArray4 = (SparseArray) view2.getTag();
                        if (sparseArray4 == null) {
                            return;
                        }
                        boolean booleanValue3 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091ef0)).booleanValue();
                        boolean booleanValue4 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091eee)).booleanValue();
                        boolean booleanValue5 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091f03)).booleanValue();
                        if (!booleanValue3) {
                            if (booleanValue4) {
                                this.a.mView.L(((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f091eb2)).intValue(), (String) sparseArray4.get(R.id.obfuscated_res_0x7f091eb0), ((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f091ecd)).intValue(), ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091eb1)).booleanValue());
                                return;
                            }
                            return;
                        } else if (booleanValue5) {
                            sparseArray4.put(R.id.obfuscated_res_0x7f091ec1, 1);
                            sparseArray4.put(R.id.obfuscated_res_0x7f091eaa, 2);
                            this.a.checkMuteState(sparseArray4);
                            return;
                        } else {
                            sparseArray4.put(R.id.obfuscated_res_0x7f091eaa, 2);
                            this.a.mView.P(view2);
                            return;
                        }
                    case 8:
                        if (this.a.checkUpIsLogin() && (sparseArray = (SparseArray) view2.getTag()) != null) {
                            PostData postData2 = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091eae);
                            if (postData2.q() == null) {
                                return;
                            }
                            this.a.clickOnDisagree(postData2.q());
                            return;
                        }
                        return;
                    case 9:
                        if (!this.a.checkUpIsLogin() || this.a.mModel == null || this.a.mModel.P1() == null) {
                            return;
                        }
                        this.a.showBlockDialog(xq8.c(view2));
                        return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class x implements nr4.e {
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

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                if (nr4Var != null) {
                    nr4Var.dismiss();
                }
                this.d.deleteThreadDirect(((Integer) this.a.get(R.id.obfuscated_res_0x7f091eb2)).intValue(), (String) this.a.get(R.id.obfuscated_res_0x7f091eb0), this.b, this.c);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class y implements nr4.e {
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

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                nr4Var.dismiss();
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
        this.isDialogFromLongClick = true;
        this.mIsFromVideoTab = false;
        this.mReplyFloorLocation = new int[2];
        this.mMarkModel = null;
        this.mLoadPbCallback = new k(this);
        this.imgIndex = 0;
        this.mOnImageClickListener = new r(this);
        this.index_valid = false;
        this.mTbGestureDetector = new dt7(new u(this));
        this.mOnLongClickListener = new v(this);
        this.postData = null;
        this.onLongClickItemClickListener = new w(this);
        this.mForumManageCallBack = new a(this);
        this.mPrePostCallBack = new e(this);
        this.mDraftLoadListener = new f(this, 2004008);
        this.mOnFloorPostWriteNewCallback = new g(this);
        this.showTrisectionAndFeedback = UbsABTestHelper.showTrisectionAndFeedback();
        this.mCommonOnClickListener = new j(this);
        this.mCheckSubFloorCallBack = new n(this);
        this.mMarkDoneCallBack = new p(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addCollectionStat() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65583, this) == null) || (pbModel = this.mModel) == null || pbModel.P1() == null || this.mModel.P1().O() == null) {
            return;
        }
        ThreadData O = this.mModel.P1().O();
        O.mRecomAbTag = this.mModel.U1();
        O.mRecomWeight = this.mModel.X1();
        O.mRecomSource = this.mModel.W1();
        O.mRecomExtra = this.mModel.V1();
        O.isSubPb = this.mModel.C1();
        if (O.getFid() == 0) {
            O.setFid(kg.g(this.mModel.getForumId(), 0L));
        }
        StatisticItem i2 = l85.i(this, O, "c13562");
        TbPageTag l2 = l85.l(this);
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

    private void addTopAgreeData(bs7 bs7Var, ArrayList<PostData> arrayList) {
        List<PostData> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65584, this, bs7Var, arrayList) == null) || bs7Var == null || bs7Var.T() == null || bs7Var.T().a == null || (list = bs7Var.T().a) == null || arrayList == null) {
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
                    if (postData != null && !TextUtils.isEmpty(next.I()) && !TextUtils.isEmpty(postData.I()) && next.I().equals(postData.I())) {
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

    private boolean checkIsIfPostForbid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65585, this)) == null) {
            PbModel pbModel = this.mModel;
            if (pbModel == null || pbModel.P1() == null) {
                return false;
            }
            return AntiHelper.b(getPageContext(), this.mModel.P1().O()) || AntiHelper.d(getPageContext(), this.mModel.P1().d());
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void clickOnDisagree(AgreeData agreeData) {
        g85 currentVisiblePageExtra;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65586, this, agreeData) == null) || agreeData == null) {
            return;
        }
        if (this.mMessageHelper == null) {
            this.mMessageHelper = new eu4();
        }
        if (this.mMsgData == null) {
            pj8 pj8Var = new pj8();
            this.mMsgData = pj8Var;
            pj8Var.a = getUniqueId();
        }
        fo4 fo4Var = new fo4();
        fo4Var.b = 5;
        fo4Var.h = 8;
        fo4Var.g = 2;
        PbModel pbModel2 = this.mModel;
        if (pbModel2 != null) {
            fo4Var.f = pbModel2.O1();
        }
        fo4Var.a = 2;
        int i2 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                fo4Var.i = 0;
                currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(this);
                if (currentVisiblePageExtra != null) {
                    agreeData.objSource = currentVisiblePageExtra.a();
                }
                this.mMessageHelper.c(agreeData, i2, getUniqueId(), false);
                this.mMessageHelper.d(agreeData, this.mMsgData);
                pbModel = this.mModel;
                if (pbModel != null || pbModel.P1() == null) {
                }
                this.mMessageHelper.b(this, fo4Var, agreeData, this.mModel.P1().O());
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            fo4Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            fo4Var.i = 1;
        }
        i2 = 0;
        currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(this);
        if (currentVisiblePageExtra != null) {
        }
        this.mMessageHelper.c(agreeData, i2, getUniqueId(), false);
        this.mMessageHelper.d(agreeData, this.mMsgData);
        pbModel = this.mModel;
        if (pbModel != null) {
        }
    }

    private void closeActivityAfterDelPost() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65587, this) == null) {
            if (this.mModel.u1() || this.mModel.x1()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", this.mModel.h2());
                setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.mModel.h2()));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dealLongClickListener(View view2) {
        InterceptResult invokeL;
        SparseArray sparseArray;
        xl4 xl4Var;
        boolean z;
        List<ur4> b2;
        ur4 ur4Var;
        ur4 ur4Var2;
        ur4 ur4Var3;
        co coVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65588, this, view2)) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null) {
                return true;
            }
            PostData postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091eae);
            this.postData = postData;
            if (postData == null || (xl4Var = this.mMarkModel) == null) {
                return true;
            }
            if (xl4Var.e() && this.postData.I() != null) {
                this.postData.I().equals(this.mModel.K1());
            }
            if (this.mPopupDialogView == null) {
                yr4 yr4Var = new yr4(this);
                this.mPopupDialogView = yr4Var;
                yr4Var.n(this.onLongClickItemClickListener);
            }
            ArrayList arrayList = new ArrayList();
            if (view2 == null || sparseArray == null) {
                return true;
            }
            boolean isImage = isImage(view2);
            boolean z2 = (!isImage(view2) || (coVar = this.mSaveBdImage) == null || coVar.t()) ? false : true;
            boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f091ec7) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ec7)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091eb1) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eb1)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f091f03) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091f03)).booleanValue() : false;
            boolean booleanValue4 = sparseArray.get(R.id.obfuscated_res_0x7f091ef0) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ef0)).booleanValue() : false;
            boolean booleanValue5 = sparseArray.get(R.id.obfuscated_res_0x7f091f03) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091f03)).booleanValue() : false;
            boolean booleanValue6 = sparseArray.get(R.id.obfuscated_res_0x7f091eee) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eee)).booleanValue() : false;
            String str = sparseArray.get(R.id.obfuscated_res_0x7f091ebe) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091ebe) : null;
            boolean booleanValue7 = sparseArray.get(R.id.obfuscated_res_0x7f091ec6) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ec6)).booleanValue() : false;
            if (isImage) {
                z = booleanValue;
                arrayList.add(new ur4(1, getString(R.string.obfuscated_res_0x7f0f1086), this.mPopupDialogView));
            } else {
                z = booleanValue;
            }
            if (z2) {
                arrayList.add(new ur4(2, getString(R.string.obfuscated_res_0x7f0f1087), this.mPopupDialogView));
            }
            if (!isImage && !z2) {
                ur4 ur4Var4 = new ur4(3, getString(R.string.obfuscated_res_0x7f0f0444), this.mPopupDialogView);
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.obfuscated_res_0x7f091eae, this.postData);
                ur4Var4.d.setTag(sparseArray2);
                arrayList.add(ur4Var4);
            }
            if (this.mIsLogin) {
                if (!vx7.h(this.mModel) && !booleanValue4 && booleanValue3) {
                    ur4 ur4Var5 = new ur4(5, getString(R.string.obfuscated_res_0x7f0f0b29), this.mPopupDialogView);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.obfuscated_res_0x7f091f03, Boolean.TRUE);
                    sparseArray3.put(R.id.obfuscated_res_0x7f091ec5, sparseArray.get(R.id.obfuscated_res_0x7f091ec5));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091eff, sparseArray.get(R.id.obfuscated_res_0x7f091eff));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091f00, sparseArray.get(R.id.obfuscated_res_0x7f091f00));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091efe, sparseArray.get(R.id.obfuscated_res_0x7f091efe));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091f01, sparseArray.get(R.id.obfuscated_res_0x7f091f01));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091f02, sparseArray.get(R.id.obfuscated_res_0x7f091f02));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091eb1, sparseArray.get(R.id.obfuscated_res_0x7f091eb1));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091eb2, sparseArray.get(R.id.obfuscated_res_0x7f091eb2));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091eb0, sparseArray.get(R.id.obfuscated_res_0x7f091eb0));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091ecd, sparseArray.get(R.id.obfuscated_res_0x7f091ecd));
                    ur4Var5.d.setTag(sparseArray3);
                    arrayList.add(ur4Var5);
                } else {
                    if (isShowReportButton(booleanValue2) && TbadkCoreApplication.isLogin()) {
                        ur4 ur4Var6 = new ur4(5, getString(R.string.obfuscated_res_0x7f0f0fc0), this.mPopupDialogView);
                        ur4Var6.d.setTag(str);
                        arrayList.add(ur4Var6);
                    }
                }
                if (booleanValue4) {
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.obfuscated_res_0x7f091ef0, Boolean.TRUE);
                    sparseArray4.put(R.id.obfuscated_res_0x7f091ecd, sparseArray.get(R.id.obfuscated_res_0x7f091ecd));
                    sparseArray4.put(R.id.obfuscated_res_0x7f091ebb, sparseArray.get(R.id.obfuscated_res_0x7f091ebb));
                    sparseArray4.put(R.id.obfuscated_res_0x7f091ebc, sparseArray.get(R.id.obfuscated_res_0x7f091ebc));
                    sparseArray4.put(R.id.obfuscated_res_0x7f091ebd, sparseArray.get(R.id.obfuscated_res_0x7f091ebd));
                    sparseArray4.put(R.id.obfuscated_res_0x7f091ebe, str);
                    if (!vx7.h(this.mModel) && booleanValue5) {
                        sparseArray4.put(R.id.obfuscated_res_0x7f091f03, Boolean.TRUE);
                        sparseArray4.put(R.id.obfuscated_res_0x7f091ec5, sparseArray.get(R.id.obfuscated_res_0x7f091ec5));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091eff, sparseArray.get(R.id.obfuscated_res_0x7f091eff));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091f00, sparseArray.get(R.id.obfuscated_res_0x7f091f00));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091efe, sparseArray.get(R.id.obfuscated_res_0x7f091efe));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091f01, sparseArray.get(R.id.obfuscated_res_0x7f091f01));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091f02, sparseArray.get(R.id.obfuscated_res_0x7f091f02));
                    } else {
                        sparseArray4.put(R.id.obfuscated_res_0x7f091f03, Boolean.FALSE);
                    }
                    if (booleanValue6) {
                        sparseArray4.put(R.id.obfuscated_res_0x7f091eee, Boolean.TRUE);
                        sparseArray4.put(R.id.obfuscated_res_0x7f091eb1, Boolean.valueOf(booleanValue2));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091eb0, sparseArray.get(R.id.obfuscated_res_0x7f091eb0));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091eb2, sparseArray.get(R.id.obfuscated_res_0x7f091eb2));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091ec2, sparseArray.get(R.id.obfuscated_res_0x7f091ec2));
                        if (booleanValue7) {
                            ur4Var = new ur4(6, getString(R.string.obfuscated_res_0x7f0f049d), this.mPopupDialogView);
                            ur4Var.d.setTag(sparseArray4);
                            ur4Var2 = new ur4(7, getString(R.string.obfuscated_res_0x7f0f02d9), this.mPopupDialogView);
                            ur4Var2.d.setTag(sparseArray4);
                        }
                    } else {
                        sparseArray4.put(R.id.obfuscated_res_0x7f091eee, Boolean.FALSE);
                    }
                    ur4Var = null;
                    ur4Var2 = new ur4(7, getString(R.string.obfuscated_res_0x7f0f02d9), this.mPopupDialogView);
                    ur4Var2.d.setTag(sparseArray4);
                } else {
                    if (booleanValue6) {
                        SparseArray sparseArray5 = new SparseArray();
                        sparseArray5.put(R.id.obfuscated_res_0x7f091ef0, Boolean.FALSE);
                        sparseArray5.put(R.id.obfuscated_res_0x7f091f03, Boolean.FALSE);
                        sparseArray5.put(R.id.obfuscated_res_0x7f091eee, Boolean.TRUE);
                        sparseArray5.put(R.id.obfuscated_res_0x7f091ecd, sparseArray.get(R.id.obfuscated_res_0x7f091ecd));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091eb1, Boolean.valueOf(booleanValue2));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091eb0, sparseArray.get(R.id.obfuscated_res_0x7f091eb0));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091eb2, sparseArray.get(R.id.obfuscated_res_0x7f091eb2));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091ec2, sparseArray.get(R.id.obfuscated_res_0x7f091ec2));
                        if (this.mModel.P1().V() == 1002 && !booleanValue2) {
                            ur4Var3 = new ur4(6, getString(R.string.obfuscated_res_0x7f0f0fc0), this.mPopupDialogView);
                        } else {
                            ur4Var3 = new ur4(6, getString(R.string.obfuscated_res_0x7f0f049d), this.mPopupDialogView);
                        }
                        ur4Var3.d.setTag(sparseArray5);
                        ur4Var = ur4Var3;
                    } else {
                        ur4Var = null;
                    }
                    ur4Var2 = null;
                }
                if (ur4Var != null) {
                    arrayList.add(ur4Var);
                }
                if (ur4Var2 != null) {
                    arrayList.add(ur4Var2);
                }
                vx7.a(arrayList, this.mPopupDialogView, this.postData, this.mModel);
            }
            if (UbsABTestHelper.isPBPlanA()) {
                b2 = vx7.c(arrayList, this.postData.q(), sparseArray, this.mPopupDialogView);
            } else {
                b2 = vx7.b(arrayList, this.postData.q(), sparseArray, this.mPopupDialogView);
            }
            vx7.k(b2, this.isDialogFromLongClick);
            vx7.e(b2);
            this.mPopupDialogView.o(vx7.f(this.postData));
            if (UbsABTestHelper.isPBPlanA()) {
                this.mPopupDialogView.k(b2, false);
            } else {
                this.mPopupDialogView.k(b2, true);
            }
            wr4 wr4Var = new wr4(getPageContext(), this.mPopupDialogView);
            this.mLongClickDialog = wr4Var;
            wr4Var.m();
            TiebaStatic.log(new StatisticItem("c13272").param("tid", this.mModel.h2()).param("fid", this.mModel.getForumId()).param("uid", this.mModel.P1().O().getAuthor().getUserId()).param("post_id", this.mModel.A()).param("obj_source", z ? 2 : 1));
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishDelPost(ForumManageModel.b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65589, this, bVar, z) == null) || bVar == null) {
            return;
        }
        String string = !TextUtils.isEmpty(bVar.b) ? bVar.b : getString(R.string.obfuscated_res_0x7f0f04a2);
        int i2 = 0;
        if (bVar.c == 1211066) {
            hideProgressBar();
            nr4 nr4Var = new nr4(getPageContext().getPageActivity());
            nr4Var.setMessage(string);
            nr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04e1, new b(this));
            nr4Var.setCancelable(true);
            nr4Var.create(getPageContext());
            nr4Var.show();
        } else if (bVar.d != 0) {
            this.mView.v(0, bVar.a, bVar.b, z);
        }
        if (bVar.a) {
            int i3 = bVar.d;
            if (i3 == 1) {
                ArrayList<PostData> F = this.mModel.P1().F();
                int size = F.size();
                while (true) {
                    if (i2 >= size) {
                        break;
                    } else if (bVar.g.equals(F.get(i2).I())) {
                        F.remove(i2);
                        break;
                    } else {
                        i2++;
                    }
                }
                this.mModel.P1().O().setReply_num(this.mModel.P1().O().getReply_num() - 1);
            } else if (i3 == 0) {
                closeActivityAfterDelPost();
            } else if (i3 == 2) {
                ArrayList<PostData> F2 = this.mModel.P1().F();
                int size2 = F2.size();
                boolean z2 = false;
                for (int i4 = 0; i4 < size2 && !z2; i4++) {
                    int i5 = 0;
                    while (true) {
                        if (i5 >= F2.get(i4).R().size()) {
                            break;
                        } else if (bVar.g.equals(F2.get(i4).R().get(i5).I())) {
                            F2.get(i4).R().remove(i5);
                            F2.get(i4).k();
                            z2 = true;
                            break;
                        } else {
                            i5++;
                        }
                    }
                    F2.get(i4).m(bVar.g);
                }
            }
        }
    }

    private TbRichText getImage(ArrayList<PostData> arrayList, String str, int i2) {
        InterceptResult invokeLLI;
        ArrayList<TbRichTextData> A;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65590, this, arrayList, str, i2)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    TbRichText P = arrayList.get(i3).P();
                    if (P != null && (A = P.A()) != null) {
                        int size = A.size();
                        int i4 = -1;
                        for (int i5 = 0; i5 < size; i5++) {
                            if (A.get(i5) != null && A.get(i5).getType() == 8) {
                                i4++;
                                if (A.get(i5).E().A().equals(str) || A.get(i5).E().B().equals(str)) {
                                    int h2 = (int) mi.h(TbadkCoreApplication.getInst());
                                    int width = A.get(i5).E().getWidth() * h2;
                                    int height = A.get(i5).E().getHeight() * h2;
                                    if (width < 80 || height < 80 || width * height < 10000) {
                                        return null;
                                    }
                                    this.imgIndex = i5;
                                    return P;
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

    private int getImageIndex(TbRichText tbRichText, TbRichText tbRichText2, int i2, int i3, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        InterceptResult invokeCommon;
        TbRichTextImageInfo E;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65591, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i2), Integer.valueOf(i3), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.index_valid = true;
            }
            if (tbRichText != null) {
                int size = tbRichText.A().size();
                int i4 = i2;
                int i5 = -1;
                for (int i6 = 0; i6 < size; i6++) {
                    TbRichTextData tbRichTextData = tbRichText.A().get(i6);
                    if ((tbRichTextData == null || tbRichTextData.getType() != 20) && tbRichTextData != null && tbRichTextData.getType() == 8) {
                        i5++;
                        int h2 = (int) mi.h(TbadkCoreApplication.getInst());
                        int width = tbRichTextData.E().getWidth() * h2;
                        int height = tbRichTextData.E().getHeight() * h2;
                        if ((width < 80 || height < 80 || width * height < 10000) || !tbRichTextData.E().F()) {
                            if (tbRichText == tbRichText2) {
                                if (i5 <= i3) {
                                    i4--;
                                }
                            }
                        } else if (tbRichTextData.getType() != 20) {
                            String a2 = cs7.a(tbRichTextData);
                            if (!TextUtils.isEmpty(a2)) {
                                arrayList.add(a2);
                                if (tbRichTextData != null && (E = tbRichTextData.E()) != null) {
                                    String A = E.A();
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                        imageUrlData.urlType = 38;
                                        A = E.B();
                                    } else {
                                        imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    }
                                    imageUrlData.imageUrl = A;
                                    imageUrlData.originalUrl = getOriginalPic(tbRichTextData);
                                    imageUrlData.originalSize = getOriginalSize(tbRichTextData);
                                    imageUrlData.mIsShowOrigonButton = getIsShowOriginalButton(tbRichTextData);
                                    imageUrlData.isLongPic = getIsLongImg(tbRichTextData);
                                    imageUrlData.postId = tbRichText.getPostId();
                                    imageUrlData.threadId = kg.g(this.mModel.h2(), -1L);
                                    imageUrlData.mIsReserver = this.mModel.a2();
                                    imageUrlData.mIsSeeHost = this.mModel.s1();
                                    if (concurrentHashMap != null) {
                                        concurrentHashMap.put(a2, imageUrlData);
                                    }
                                }
                            }
                            if (!this.index_valid) {
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

    private boolean getIsLongImg(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65592, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.E() == null) {
                return false;
            }
            return tbRichTextData.E().G();
        }
        return invokeL.booleanValue;
    }

    private boolean getIsShowOriginalButton(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65593, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.E() == null) {
                return false;
            }
            return tbRichTextData.E().H();
        }
        return invokeL.booleanValue;
    }

    private String getOriginalPic(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65594, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.E() == null) {
                return null;
            }
            return tbRichTextData.E().C();
        }
        return (String) invokeL.objValue;
    }

    private long getOriginalSize(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65595, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.E() == null) {
                return 0L;
            }
            return tbRichTextData.E().getOriginalSize();
        }
        return invokeL.longValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getThreadType(bs7 bs7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65596, this, bs7Var)) == null) {
            if (bs7Var == null || bs7Var.O() == null) {
                return 0;
            }
            if (bs7Var.O().getThreadType() == 0) {
                return 1;
            }
            if (bs7Var.O().getThreadType() == 54) {
                return 2;
            }
            return bs7Var.O().getThreadType() == 40 ? 3 : 4;
        }
        return invokeL.intValue;
    }

    private void handleFullScreenEditorResult(int i2, Intent intent) {
        j15 j15Var;
        j15 j15Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65597, this, i2, intent) == null) {
            if (i2 == 0) {
                this.mView.D();
                this.mView.y().c();
                this.mView.a0(false);
            }
            this.mView.R();
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
                    if (editorType != 1 || this.mView.y() == null || this.mView.y().b() == null) {
                        return;
                    }
                    e35 b2 = this.mView.y().b();
                    b2.c0(this.mModel.P1().O());
                    b2.B(writeData);
                    b2.d0(pbEditorData.getVoiceModel());
                    i15 n2 = b2.a().n(6);
                    if (n2 != null && (j15Var2 = n2.m) != null) {
                        j15Var2.onAction(new w05(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i2 == -1) {
                        b2.F();
                        return;
                    }
                    return;
                }
                this.mPbEditor.S();
                this.mPbEditor.t0(pbEditorData.getVoiceModel());
                this.mPbEditor.G(writeData);
                i15 n3 = this.mPbEditor.a().n(6);
                if (n3 != null && (j15Var = n3.m) != null) {
                    j15Var.onAction(new w05(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i2 == -1) {
                    this.mPbEditor.L(null, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleReportClicked(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65598, this, str) == null) {
            PbModel pbModel = this.mModel;
            if (pbModel != null && pbModel.P1() != null && this.mModel.P1().g0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.mModel.h2(), str);
                ThreadData O = this.mModel.P1().O();
                if (O.isBJHArticleThreadType()) {
                    format = format + "&channelid=33833";
                } else if (O.isBjhDynamicThread()) {
                    format = format + "&channelid=33842";
                } else if (O.isBJHVideoThreadType()) {
                    format = format + "&channelid=33840";
                }
                jumpToWeb(format);
                return;
            }
            this.mUEGReportController.a(str);
        }
    }

    private void initData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65599, this, bundle) == null) {
            this.MESSAGE_ID_PB = getUniqueId();
            xl4 c2 = xl4.c(this);
            this.mMarkModel = c2;
            if (c2 != null) {
                c2.j(this.mMarkDoneCallBack);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this);
            this.mForumManageModel = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.mForumManageCallBack);
            if (bundle != null) {
                this.mModel = new PbModel(this, bundle, this.mLoadPbCallback);
            } else {
                this.mModel = new PbModel(this, getIntent(), this.mLoadPbCallback);
            }
            this.mModel.x3(true);
            this.mModel.z3(4);
        }
    }

    private boolean initIsFromVideo(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65600, this, bundle)) == null) {
            if (bundle != null) {
                this.mIsFromVideoTab = bundle.getBoolean("is_jump_from_video_tab", false);
            } else {
                this.mIsFromVideoTab = getIntent().getBooleanExtra("is_jump_from_video_tab", false);
            }
            return this.mIsFromVideoTab;
        }
        return invokeL.booleanValue;
    }

    private void initUI(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65601, this, bundle) == null) {
            this.mPbEventController = new hx7(this);
            this.mPbPostShareController = new jx7(getPageContext());
            au7 au7Var = new au7(this, this.mCommonOnClickListener, this.mOnImageClickListener, this.mTbGestureDetector, this.mOnLongClickListener);
            this.mView = au7Var;
            au7Var.Y(this.mModel);
            setContentView(this.mView.A(), new FlowLayout.LayoutParams(-1, -1));
            adjustResizeForSoftInput();
            addGlobalLayoutListener();
            this.mView.s();
            this.mView.V(new t(this));
            d35 d35Var = new d35();
            this.mPbeb = d35Var;
            setPbNormalEditorBuilder(d35Var);
            b35 b35Var = (b35) this.mPbeb.a(getActivity());
            this.mPbEditor = b35Var;
            b35Var.e0(getPageContext());
            this.mPbEditor.o0(this.mPrePostCallBack);
            this.mPbEditor.g0(1);
            this.mPbEditor.F(getPageContext(), bundle);
            this.mPbEditor.a().b(new g15(getActivity()));
            this.mPbEditor.a().C(true);
            setShowPicBlauncherOutSetVisibilty(true);
            this.mPbEditor.O(this.mModel.r1(), this.mModel.h2(), this.mModel.n1());
            this.mView.T(this.mPbEditor.a());
            this.mContentProcessController = new hw7();
            if (this.mPbEditor.v() != null) {
                this.mContentProcessController.m(this.mPbEditor.v().h());
            }
            registerListener(this.mDraftLoadListener);
            if (!this.mModel.C1()) {
                this.mPbEditor.s(this.mModel.h2());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.mPbEditor.k0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.mModel.v2()) {
                this.mPbEditor.k0(getPageContext().getString(R.string.obfuscated_res_0x7f0f0dda));
            } else {
                au7 au7Var2 = this.mView;
                if (au7Var2 != null) {
                    this.mPbEditor.k0(au7Var2.z());
                }
            }
            this.mShareSuccessReplyToServerModel = new ShareSuccessReplyToServerModel();
        }
    }

    private boolean isFromTopicDetailPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65602, this)) == null) {
            PbModel pbModel = this.mModel;
            return pbModel != null && pbModel.O1() == 17;
        }
        return invokeV.booleanValue;
    }

    private boolean isShowReportButton(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65603, this, z)) == null) {
            PbModel pbModel = this.mModel;
            if (pbModel != null && pbModel.P1() != null) {
                return ((this.mModel.P1().V() != 0) || this.mModel.P1().O() == null || this.mModel.P1().O().getAuthor() == null || TextUtils.equals(this.mModel.P1().O().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    private void jumpToWeb(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65604, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this, "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    private void loadData() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65605, this) == null) || (pbModel = this.mModel) == null) {
            return;
        }
        pbModel.O2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void locateSubPbEditor(View view2, String str, String str2, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65606, this, view2, str, str2, postData) == null) || view2 == null || str == null || str2 == null || !checkPrivacyBeforeInput()) {
            return;
        }
        if (view2.getParent() instanceof View) {
            ((View) view2.getParent()).getLocationOnScreen(this.mReplyFloorLocation);
            this.mReplyFloorMeasureHeight = ((View) view2.getParent()).getMeasuredHeight();
        }
        if (this.mView.y() != null && postData != null) {
            this.mView.y().j(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0fb6), postData.s().getName_show(), postData.P() != null ? postData.P().toString() : ""));
        }
        if (this.mModel.P1() != null && this.mModel.P1().g0()) {
            ng.a().postDelayed(new l(this, str, str2), 0L);
            return;
        }
        if (this.mSubReplyPermissionController == null) {
            rm6 rm6Var = new rm6(getPageContext());
            this.mSubReplyPermissionController = rm6Var;
            rm6Var.j(1);
            this.mSubReplyPermissionController.i(new m(this, str, str2));
        }
        PbModel pbModel = this.mModel;
        if (pbModel == null || pbModel.P1() == null || this.mModel.P1().l() == null) {
            return;
        }
        this.mSubReplyPermissionController.g(this.mModel.P1().l().getId(), kg.g(this.mModel.h2(), 0L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void makeFakeMark() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65607, this) == null) {
            bs7 P1 = this.mModel.P1();
            this.mModel.C3(true);
            xl4 xl4Var = this.mMarkModel;
            if (xl4Var != null) {
                P1.E0(xl4Var.g());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void markFloor(View view2) {
        SparseArray sparseArray;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65608, this, view2) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091eae)) == null) {
                return;
            }
            markFloor(postData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onNetOrDataError(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65609, this, i2, str) == null) {
            if (this.mModel.o2()) {
                showToast(str);
            } else if (!mi.C()) {
                this.mView.f0(R.string.obfuscated_res_0x7f0f0f77);
            } else if (i2 == 4) {
                au7 au7Var = this.mView;
                au7Var.g0(str + "(4" + SmallTailInfo.EMOTION_SUFFIX, true);
            } else if (!TextUtils.isEmpty(str)) {
                au7 au7Var2 = this.mView;
                au7Var2.g0(str + "(" + i2 + SmallTailInfo.EMOTION_SUFFIX, true);
            } else {
                this.mView.f0(R.string.obfuscated_res_0x7f0f0c45);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processImgUrls(String str, int i2, AbsPbActivity.e eVar) {
        TbRichTextData tbRichTextData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65610, this, str, i2, eVar) == null) || eVar == null) {
            return;
        }
        bs7 P1 = this.mModel.P1();
        TbRichText validImage = validImage(str, i2);
        if (validImage == null || (tbRichTextData = validImage.A().get(this.imgIndex)) == null) {
            return;
        }
        eVar.f = String.valueOf(validImage.getPostId());
        eVar.a = new ArrayList<>();
        eVar.b = new ConcurrentHashMap<>();
        if (!tbRichTextData.E().F()) {
            eVar.h = false;
            String a2 = cs7.a(tbRichTextData);
            eVar.a.add(a2);
            ImageUrlData imageUrlData = new ImageUrlData();
            imageUrlData.imageUrl = str;
            if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                imageUrlData.urlType = 38;
            } else {
                imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
            }
            imageUrlData.originalUrl = getOriginalPic(tbRichTextData);
            imageUrlData.originalUrl = getOriginalPic(tbRichTextData);
            imageUrlData.originalSize = getOriginalSize(tbRichTextData);
            imageUrlData.mIsShowOrigonButton = getIsShowOriginalButton(tbRichTextData);
            imageUrlData.isLongPic = getIsLongImg(tbRichTextData);
            imageUrlData.postId = validImage.getPostId();
            imageUrlData.mIsReserver = this.mModel.a2();
            imageUrlData.mIsSeeHost = this.mModel.s1();
            eVar.b.put(a2, imageUrlData);
            if (P1 != null) {
                if (P1.l() != null) {
                    eVar.c = P1.l().getName();
                    eVar.d = P1.l().getId();
                }
                if (P1.O() != null) {
                    eVar.e = P1.O().getId();
                }
                eVar.g = P1.s() == 1;
            }
            imageUrlData.threadId = kg.g(eVar.e, -1L);
            return;
        }
        eVar.h = true;
        int size = P1.F().size();
        this.index_valid = false;
        eVar.j = -1;
        int imageIndex = P1.j() != null ? getImageIndex(P1.j().P(), validImage, i2, i2, eVar.a, eVar.b) : i2;
        for (int i3 = 0; i3 < size; i3++) {
            PostData postData = P1.F().get(i3);
            if (postData.I() == null || P1.j() == null || P1.j().I() == null || !postData.I().equals(P1.j().I())) {
                imageIndex = getImageIndex(postData.P(), validImage, imageIndex, i2, eVar.a, eVar.b);
            }
        }
        if (eVar.a.size() > 0) {
            ArrayList<String> arrayList = eVar.a;
            eVar.i = arrayList.get(arrayList.size() - 1);
        }
        if (P1 != null) {
            if (P1.l() != null) {
                eVar.c = P1.l().getName();
                eVar.d = P1.l().getId();
            }
            if (P1.O() != null) {
                eVar.e = P1.O().getId();
            }
            eVar.g = P1.s() == 1;
        }
        eVar.j = imageIndex;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AbsPbActivity.e processSubPbImg(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65611, this, str)) == null) {
            String str2 = null;
            if (this.mModel.P1() != null && this.mModel.P1().F() != null && this.mModel.P1().F().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i2 = 0;
                while (true) {
                    if (i2 >= this.mModel.P1().F().size()) {
                        i2 = 0;
                        break;
                    } else if (str.equals(this.mModel.P1().F().get(i2).I())) {
                        break;
                    } else {
                        i2++;
                    }
                }
                PostData postData = this.mModel.P1().F().get(i2);
                if (postData.P() != null && postData.P().A() != null) {
                    Iterator<TbRichTextData> it = postData.P().A().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        TbRichTextData next = it.next();
                        if (next != null && next.getType() == 8) {
                            if (next.E() != null) {
                                str2 = next.E().A();
                            }
                        }
                    }
                    processImgUrls(str2, 0, eVar);
                    cs7.b(postData, eVar);
                    return eVar;
                }
            }
            return null;
        }
        return (AbsPbActivity.e) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void putTrackTagToPerformView(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65612, this, view2) == null) || view2 == null) {
            return;
        }
        SparseArray sparseArray = (SparseArray) view2.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(R.id.obfuscated_res_0x7f091757, Integer.valueOf(this.isDialogFromLongClick ? 2 : 3));
        view2.setTag(sparseArray);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean richTextHandleSingleTap(View view2) {
        InterceptResult invokeL;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65613, this, view2)) == null) {
            if (view2 != null && (view2.getTag() instanceof SparseArray)) {
                Object obj = ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f091eae);
                if (obj instanceof PostData) {
                    PostData postData = (PostData) obj;
                    if (checkUpIsLogin() && (pbModel = this.mModel) != null && pbModel.P1() != null) {
                        if (this.mView.y() != null) {
                            this.mView.y().c();
                        }
                        rs7 rs7Var = new rs7();
                        rs7Var.A(this.mModel.P1().l());
                        rs7Var.E(this.mModel.P1().O());
                        rs7Var.C(postData);
                        TiebaStatic.log("c11743");
                        this.mView.x().U(rs7Var);
                        this.mView.x().setPostId(postData.I());
                        locateSubPbEditor(view2, postData.s().getUserId(), "", postData);
                        b35 b35Var = this.mPbEditor;
                        if (b35Var != null) {
                            this.mView.W(b35Var.C());
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

    /* JADX INFO: Access modifiers changed from: private */
    public void sendEmotion(EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65614, this, emotionImageData) == null) || emotionImageData == null) {
            return;
        }
        if (this.mReplyEmotionModel == null) {
            ex7 ex7Var = new ex7(this);
            this.mReplyEmotionModel = ex7Var;
            ex7Var.n(this.mPrePostCallBack);
        }
        ex7 ex7Var2 = this.mReplyEmotionModel;
        PbModel pbModel = this.mModel;
        ex7Var2.k(emotionImageData, pbModel, pbModel.P1());
    }

    private void setPbNormalEditorBuilder(d35 d35Var) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65615, this, d35Var) == null) || d35Var == null || (pbModel = this.mModel) == null) {
            return;
        }
        d35Var.p(pbModel.o1());
        if (this.mModel.P1() != null && this.mModel.P1().l() != null) {
            d35Var.o(this.mModel.P1().l());
        }
        d35Var.q("pb");
        d35Var.r(this.mModel);
    }

    private void setShowPicBlauncherOutSetVisibilty(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65616, this, z) == null) {
            this.mPbEditor.f0(z);
            this.mPbEditor.i0(z);
            this.mPbEditor.p0(z);
        }
    }

    private void showAntiInfo(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65617, this, antiData, postWriteCallBackData) == null) || antiData == null || postWriteCallBackData == null) {
            return;
        }
        if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
            if (this.mView != null) {
                String errorString = postWriteCallBackData.getErrorString();
                String preMsg = postWriteCallBackData.getPreMsg();
                String colorMsg = postWriteCallBackData.getColorMsg();
                if (postWriteCallBackData.getIconStampData() != null) {
                    iz4.c(getPageContext(), postWriteCallBackData, 2);
                    return;
                } else {
                    bm8.b(getPageContext().getPageActivity(), errorString, preMsg, colorMsg);
                    return;
                }
            }
            return;
        }
        if (!this.mModel.C1()) {
            antiData.setBlock_forum_name(this.mModel.P1().l().getName());
            antiData.setBlock_forum_id(this.mModel.P1().l().getId());
            antiData.setUser_name(this.mModel.P1().U().getUserName());
            antiData.setUser_id(this.mModel.P1().U().getUserId());
        }
        AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDelNoSubPostDialog(SparseArray<Object> sparseArray, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65618, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            vx7.d(getActivity(), getPageContext(), new x(this, sparseArray, i2, z), new y(this));
        }
    }

    private void showUserMuteDialog(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65619, this, new Object[]{Boolean.valueOf(z), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z) {
                this.mView.d0();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            nr4 nr4Var = new nr4(this);
            if (li.isEmpty(str)) {
                nr4Var.setMessage(getResources().getString(R.string.obfuscated_res_0x7f0f0315, str3));
            } else {
                nr4Var.setMessage(str);
            }
            nr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0428, new c(this, userMuteAddAndDelCustomMessage));
            nr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0374, new d(this));
            nr4Var.create(getPageContext()).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSubPbActivity(PostData postData, boolean z) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65621, this, postData, z) == null) || postData == null || (pbModel = this.mModel) == null || pbModel.P1() == null || postData.A() == 1) {
            return;
        }
        String h2 = this.mModel.h2();
        String I = postData.I();
        int V = this.mModel.P1() != null ? this.mModel.P1().V() : 0;
        AbsPbActivity.e processSubPbImg = processSubPbImg(I);
        if (processSubPbImg == null) {
            return;
        }
        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this).createSubPbActivityConfig(h2, I, "pb", true, this.mIsFromVideoTab, null, false, null, V, postData.U(), this.mModel.P1().d(), false, postData.s() != null ? postData.s().getIconInfo() : null, 5).addBigImageData(processSubPbImg.a, processSubPbImg.b, processSubPbImg.g, processSubPbImg.j);
        addBigImageData.setKeyPageStartFrom(this.mModel.O1());
        addBigImageData.setFromFrsForumId(this.mModel.getFromForumId());
        addBigImageData.setWorksInfoData(this.mModel.m2());
        addBigImageData.setKeyFromForumId(this.mModel.getForumId());
        addBigImageData.setBjhData(this.mModel.h1());
        addBigImageData.setIsOpenEditor(z);
        addBigImageData.setFromFoldComment(true);
        addBigImageData.setFromVideoPageUniqueId((BdUniqueId) getIntent().getSerializableExtra("key_from_video_page_id"));
        sendMessage(new CustomMessage(2002001, addBigImageData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopVoice() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65622, this) == null) || (voiceManager = this.mVoiceManager) == null) {
            return;
        }
        voiceManager.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackDialogItem(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65623, this, i2) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.mModel.h2()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(vx7.m(i2))));
        }
    }

    private void tryAddexperienced() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65624, this) == null) && TbadkCoreApplication.isLogin() && AddExperiencedModel.D(this.mModel.getForumId()) && this.mModel.P1() != null && this.mModel.P1().l() != null) {
            if (this.mModel.P1().l().isLike() == 1) {
                this.mModel.c1().C(this.mModel.getForumId(), this.mModel.h2());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText validImage(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65625, this, str, i2)) == null) {
            PbModel pbModel = this.mModel;
            TbRichText tbRichText = null;
            if (pbModel == null || pbModel.P1() == null || str == null || i2 < 0) {
                return null;
            }
            bs7 P1 = this.mModel.P1();
            if (P1.j() != null) {
                ArrayList<PostData> arrayList = new ArrayList<>();
                arrayList.add(P1.j());
                tbRichText = getImage(arrayList, str, i2);
            }
            if (tbRichText == null) {
                ArrayList<PostData> F = P1.F();
                addTopAgreeData(P1, F);
                return getImage(F, str, i2);
            }
            return tbRichText;
        }
        return (TbRichText) invokeLI.objValue;
    }

    public void checkMuteState(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = kg.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = kg.g((String) sparseArray.get(R.id.obfuscated_res_0x7f091eff), 0L);
            BdUniqueId bdUniqueId = this.MESSAGE_ID_PB;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            this.mExtra = sparseArray;
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public boolean checkPrivacyBeforeInput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if ((this.mModel.P1() != null && (this.mModel.P1().g0() || ThreadCardUtils.isSelf(this.mModel.P1().O()))) || this.mReplyPrivacyController == null || this.mModel.P1() == null || this.mModel.P1().d() == null) {
                return true;
            }
            return this.mReplyPrivacyController.checkPrivacyBeforeInvokeEditor(this.mModel.P1().d().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public boolean checkPrivacyBeforePost(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (this.mReplyPrivacyController == null || this.mModel.P1() == null || ThreadCardUtils.isSelf(this.mModel.P1().O()) || this.mModel.P1().d() == null) {
                return true;
            }
            return this.mReplyPrivacyController.checkPrivacyBeforeSend(this.mModel.P1().d().replyPrivateFlag, i2);
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.mIsFromVideoTab) {
                ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 1);
            } else {
                ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.s
    public void decorateText(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048580, this, spannableStringBuilder, textView, tbRichTextView) == null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains(PB_LITERATURE_LOOK_MORE_ICON_SUFFIX)) {
            return;
        }
        Object[] objArr = (yf5[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), yf5.class);
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (kw7.c(objArr[i2].d()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(PB_LITERATURE_LOOK_MORE_ICON_SUFFIX);
                spannableStringBuilder2.setSpan(new ne5(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i2], spannableStringBuilder.getSpanStart(objArr[i2]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    public void deleteThread(nr4 nr4Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, nr4Var, jSONArray) == null) {
            nr4Var.dismiss();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (nr4Var.getYesButtonTag() instanceof SparseArray) {
                    deleteThread((SparseArray) nr4Var.getYesButtonTag(), jSONArray);
                    return;
                }
                return;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        }
    }

    public void deleteThreadDirect(int i2, String str, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f091eb0, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091eb2, Integer.valueOf(i2));
            sparseArray.put(R.id.obfuscated_res_0x7f091ecd, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f091eb1, Boolean.valueOf(z));
            sparseArray.put(fw7.f2, Integer.valueOf(fw7.g2));
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                deleteThread(sparseArray, (JSONArray) null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.mIsFromVideoTab) {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 1);
            } else {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            }
        }
    }

    public void finishForumManageProcess(int i2, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            if (z && z2) {
                showToast(getPageContext().getString(R.string.obfuscated_res_0x7f0f1217));
            } else if (z2) {
                if (li.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0c2d);
                }
                showToast(str);
            }
        }
    }

    public AntiData getAntiData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            PbModel pbModel = this.mModel;
            if (pbModel == null || pbModel.P1() == null) {
                return null;
            }
            return this.mModel.P1().d();
        }
        return (AntiData) invokeV.objValue;
    }

    @Override // com.repackage.ot7
    public hx7 getEventController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mPbEventController : (hx7) invokeV.objValue;
    }

    public PostData getFirstPostData() {
        InterceptResult invokeV;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            PbModel pbModel = this.mModel;
            if (pbModel == null || pbModel.P1() == null || this.mModel.P1().O() == null || this.mModel.P1().O().getAuthor() == null) {
                return null;
            }
            PostData postData = new PostData();
            MetaData author = this.mModel.P1().O().getAuthor();
            String userId = author.getUserId();
            HashMap<String, MetaData> userMap = this.mModel.P1().O().getUserMap();
            if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                author = metaData;
            }
            postData.p0(1);
            postData.u0(this.mModel.P1().O().getFirstPostId());
            postData.G0(this.mModel.P1().O().getTitle());
            postData.F0(this.mModel.P1().O().getCreateTime());
            postData.n0(author);
            return postData;
        }
        return (PostData) invokeV.objValue;
    }

    @Override // com.repackage.ot7
    public String getFromForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            PbModel pbModel = this.mModel;
            if (pbModel != null) {
                return pbModel.o1();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.bg5
    public bg<GifView> getGifViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return null;
        }
        return (bg) invokeV.objValue;
    }

    @Override // com.repackage.bg5
    public bg<ImageView> getImageViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.mImageViewPool == null) {
                this.mImageViewPool = new bg<>(new q(this), 8, 0);
            }
            return this.mImageViewPool;
        }
        return (bg) invokeV.objValue;
    }

    @Override // com.repackage.bg5
    public bg<ItemCardView> getItemCardViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return null;
        }
        return (bg) invokeV.objValue;
    }

    @Override // com.repackage.bg5
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return null;
        }
        return (ListView) invokeV.objValue;
    }

    public PbModel getModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mModel : (PbModel) invokeV.objValue;
    }

    public b35 getPbEditor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mPbEditor : (b35) invokeV.objValue;
    }

    public jx7 getPbPostShareController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mPbPostShareController : (jx7) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.repackage.bg5
    public bg<RelativeLayout> getRelativeLayoutPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return null;
        }
        return (bg) invokeV.objValue;
    }

    @Override // com.repackage.bg5
    public int getRichTextViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.bg5
    public bg<TextView> getTextViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return null;
        }
        return (bg) invokeV.objValue;
    }

    @Override // com.repackage.bg5
    public bg<LinearLayout> getTextVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return null;
        }
        return (bg) invokeV.objValue;
    }

    @Override // com.repackage.bg5
    public bg<TiebaPlusRecommendCard> getTiejiaRecommendPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return null;
        }
        return (bg) invokeV.objValue;
    }

    @Override // com.repackage.ot7
    public int getUserIdentify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            PbModel pbModel = this.mModel;
            if (pbModel == null || pbModel.P1() == null) {
                return 0;
            }
            return this.mModel.P1().V();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.mVoiceManager : (VoiceManager) invokeV.objValue;
    }

    @Override // com.repackage.bg5
    public bg<View> getVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return null;
        }
        return (bg) invokeV.objValue;
    }

    public void handleMuteClick(boolean z, String str, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Boolean.valueOf(z), str, sparseArray}) == null) {
            String str2 = sparseArray.get(R.id.obfuscated_res_0x7f091f00) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091f00) : "";
            String str3 = sparseArray.get(R.id.obfuscated_res_0x7f091f02) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091f02) : "";
            String str4 = sparseArray.get(R.id.obfuscated_res_0x7f091f01) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091f01) : "";
            String str5 = sparseArray.get(R.id.obfuscated_res_0x7f091efd) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091efd) : "";
            String str6 = sparseArray.get(R.id.obfuscated_res_0x7f091efe) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091efe) : "";
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.MESSAGE_ID_PB);
            userMuteAddAndDelCustomMessage.setTag(this.MESSAGE_ID_PB);
            showUserMuteDialog(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    @Override // com.repackage.ot7
    public boolean isHost(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
            PbModel pbModel = this.mModel;
            return pbModel != null && pbModel.F2(str);
        }
        return invokeL.booleanValue;
    }

    public boolean isHostOnlyMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            PbModel pbModel = this.mModel;
            if (pbModel != null) {
                return pbModel.s1();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isImage(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, view2)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.ot7
    public boolean isSimpleForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            PbModel pbModel = this.mModel;
            if (pbModel == null) {
                return false;
            }
            return pbModel.E2();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048612, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            this.mPbEditor.H(i2, i3, intent);
            ex7 ex7Var = this.mReplyEmotionModel;
            if (ex7Var != null) {
                ex7Var.i(i2, i3, intent);
            }
            if (this.mView.y() != null) {
                this.mView.y().g(i2, i3, intent);
            }
            if (i2 == 25035) {
                handleFullScreenEditorResult(i3, intent);
            }
            if (i3 == -1) {
                if (i2 == 13008) {
                    xv7.b().m();
                    this.mHandler.postDelayed(new h(this), 1000L);
                } else if (i2 == 13011) {
                    m98.g().m(getPageContext());
                } else if (i2 != 24007) {
                } else {
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        m98.g().m(getPageContext());
                        tryAddexperienced();
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.mShareSuccessReplyToServerModel;
                        if (shareSuccessReplyToServerModel == null || shareItem == null || (str = shareItem.v) == null) {
                            return;
                        }
                        shareSuccessReplyToServerModel.y(str, intExtra, new i(this));
                    }
                }
            }
        }
    }

    @Override // com.repackage.bg5
    public void onAtClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
        }
    }

    @Override // com.repackage.nr4.e
    public void onClick(nr4 nr4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, nr4Var) == null) {
            deleteThread(nr4Var, (JSONArray) null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, bundle) == null) {
            initIsFromVideo(bundle);
            super.onCreate(bundle);
            VoiceManager voiceManager = new VoiceManager();
            this.mVoiceManager = voiceManager;
            voiceManager.onCreate(getPageContext());
            initData(bundle);
            initUI(bundle);
            loadData();
            if (this.mIsFromVideoTab) {
                this.mView.A().setAnimTime(0);
                this.mView.A().setIsFromVideoTab(true);
            }
            if (getIntent() != null && this.mIsFromVideoTab) {
                this.mVideoPageUniqueId = (BdUniqueId) getIntent().getSerializableExtra("key_from_video_page_id");
            }
            this.mView.A().h();
            this.mView.x().setFromForumId(this.mModel.getFromForumId());
            by7 by7Var = new by7(this);
            this.mUEGReportController = by7Var;
            by7Var.b(getUniqueId());
            this.mUserBlockController = new yq8(getPageContext(), getUniqueId());
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.mReplyPrivacyController = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new s(this));
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.mPbEditor.k0(TbSingleton.getInstance().getAdVertiComment());
            } else {
                this.mPbEditor.k0(this.mView.z());
            }
            hz4.b(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            super.onDestroy();
            ReplyPrivacyCheckController replyPrivacyCheckController = this.mReplyPrivacyController;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
        }
    }

    @Override // com.repackage.bg5
    public void onLinkButtonClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048618, this, context, str) == null) {
        }
    }

    @Override // com.repackage.bg5
    public void onLinkClicked(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048619, this, context, str, z) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            super.onPause();
            if (this.mIsFromVideoTab) {
                syncFloatBackGround(false);
            }
        }
    }

    @Override // com.repackage.bg5
    public void onPhoneClicked(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048621, this, context, str, str2) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            super.onResume();
            if (this.mIsFromVideoTab) {
                syncFloatBackGround(true);
            }
        }
    }

    @Override // com.repackage.bg5
    public void onSongClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048623, this, context, str) == null) {
        }
    }

    @Override // com.repackage.bg5
    public void onVideoClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048624, this, context, str) == null) {
        }
    }

    @Override // com.repackage.bg5
    public void onVideoP2PClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048625, this, context, str) == null) {
        }
    }

    public void processProfessionPermission() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048626, this) == null) || !checkUpIsLogin() || (pbModel = this.mModel) == null || pbModel.P1() == null || this.mModel.P1().l() == null || checkIsIfPostForbid()) {
            return;
        }
        if (this.mModel.P1().g0()) {
            this.mView.t();
            return;
        }
        if (this.mProfessionController == null) {
            rm6 rm6Var = new rm6(getPageContext());
            this.mProfessionController = rm6Var;
            rm6Var.j(0);
            this.mProfessionController.i(new o(this));
        }
        this.mProfessionController.g(this.mModel.P1().l().getId(), kg.g(this.mModel.h2(), 0L));
    }

    public void showBlockDialog(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048627, this, str) == null) || str == null || this.mUserBlockController == null) {
            return;
        }
        this.mUserBlockController.n(kg.g(str, 0L));
    }

    public void syncFloatBackGround(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z) == null) {
            CustomMessage customMessage = new CustomMessage(2921596);
            customMessage.setTag(this.mVideoPageUniqueId);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921596, Boolean.valueOf(z));
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public void markFloor(PostData postData) {
        xl4 xl4Var;
        PostData firstPostData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, postData) == null) || postData == null) {
            return;
        }
        boolean z = false;
        if (postData.I() != null && postData.I().equals(this.mModel.K1())) {
            z = true;
        }
        MarkData J1 = this.mModel.J1(postData);
        if (this.mModel.P1() != null && this.mModel.P1().g0() && (firstPostData = getFirstPostData()) != null) {
            J1 = this.mModel.J1(firstPostData);
        }
        if (J1 == null || (xl4Var = this.mMarkModel) == null) {
            return;
        }
        xl4Var.i(J1);
        if (!z) {
            this.mMarkModel.a();
        } else {
            this.mMarkModel.d();
        }
    }

    public void deleteThread(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(fw7.f2)).intValue();
            if (intValue == fw7.g2) {
                if (this.mForumManageModel.R()) {
                    return;
                }
                String str = (String) sparseArray.get(R.id.obfuscated_res_0x7f091eb0);
                int intValue2 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091ecd)).intValue();
                boolean booleanValue = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eb1)).booleanValue();
                int intValue3 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091eb2)).intValue();
                boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091ec4) != null ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ec4)).booleanValue() : false;
                if (jSONArray != null) {
                    this.mForumManageModel.T(StringHelper.JsonArrayToString(jSONArray));
                }
                this.mForumManageModel.U(this.mModel.P1().l().getId(), this.mModel.P1().l().getName(), this.mModel.P1().O().getId(), str, intValue3, intValue2, booleanValue, this.mModel.P1().O().getBaijiahaoData(), booleanValue2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            } else if (intValue == fw7.h2 || intValue == fw7.j2) {
                if (this.mModel.k1() != null) {
                    this.mModel.k1().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == fw7.h2) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSubPbActivity(SparseArray<Object> sparseArray) {
        PostData postData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65620, this, sparseArray) == null) && checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.obfuscated_res_0x7f091eae) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091eae)) != null) {
            startSubPbActivity(postData, false);
        }
    }
}
