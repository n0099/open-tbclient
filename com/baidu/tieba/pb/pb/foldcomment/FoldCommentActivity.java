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
import c.a.s0.c0.d;
import c.a.s0.i.a;
import c.a.s0.s.q.d2;
import c.a.s0.s.q.t0;
import c.a.s0.s.s.a;
import c.a.s0.s.s.j;
import c.a.s0.t.c.m0;
import c.a.t0.d1.r2.a.c;
import c.a.t0.s2.s.c;
import c.a.t0.s2.u.f.l0;
import c.a.t0.s2.u.f.v0;
import c.a.t0.s2.u.f.x0;
import c.a.t0.s2.u.f.y0;
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
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.dialog.PopupDialog;
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
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity;
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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
/* loaded from: classes12.dex */
public class FoldCommentActivity extends BaseFragmentActivity implements VoiceManager.j, c.a.t0.s2.u.a<NewSubPbActivity>, TbRichTextView.s, a.e, c.a.s0.g1.n.i {
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
    public c.a.s0.x.y.b mCheckSubFloorCallBack;
    public View.OnClickListener mCommonOnClickListener;
    public v0 mContentProcessController;
    public CustomMessageListener mDraftLoadListener;
    public EmotionImageData mEmotionImageData;
    public TbRichTextMemeInfo mEmotionInfo;
    public Object mExtra;
    public final c.a.d.a.e mForumManageCallBack;
    public ForumManageModel mForumManageModel;
    public c.a.d.f.k.b<ImageView> mImageViewPool;
    public boolean mIsFromCDN;
    public boolean mIsFromVideoTab;
    public PbModel.g mLoadPbCallback;
    public PopupDialog mLongClickDialog;
    public final a.InterfaceC0841a mMarkDoneCallBack;
    public c.a.s0.i.a mMarkModel;
    public c.a.s0.s.e0.a mMessageHelper;
    public PbModel mModel;
    public c.a.t0.w3.j0.e mMsgData;
    public NewWriteModel.g mOnFloorPostWriteNewCallback;
    public final TbRichTextView.y mOnImageClickListener;
    public final View.OnLongClickListener mOnLongClickListener;
    public c.a.s0.x.y.e mPbEditor;
    public c.a.t0.s2.u.f.d1.a mPbEventController;
    public c.a.t0.s2.u.f.d1.c mPbPostShareController;
    public c.a.s0.x.y.g mPbeb;
    public PermissionJudgePolicy mPermissionJudgement;
    public c.a.s0.s.s.j mPopupDialogView;
    public c.a.s0.x.y.c mPrePostCallBack;
    public c.a.t0.d1.r2.a.c mProfessionController;
    public c.a.t0.s2.u.f.c1.f.a mReplyEmotionModel;
    public int[] mReplyFloorLocation;
    public int mReplyFloorMeasureHeight;
    public ReplyPrivacyCheckController mReplyPrivacyController;
    public c.a.d.n.d.a mSaveBdImage;
    public x0 mSaveImageHelper;
    public String mSaveImageUrl;
    public ShareSuccessReplyToServerModel mShareSuccessReplyToServerModel;
    public c.a.t0.d1.r2.a.c mSubReplyPermissionController;
    public c.a.t0.s2.s.c mTbGestureDetector;
    public c.a.t0.s2.u.g.a mUEGReportController;
    public c.a.t0.g4.b mUserBlockController;
    public BdUniqueId mVideoPageUniqueId;
    public c.a.t0.s2.u.d.c mView;
    public VoiceManager mVoiceManager;
    public View moreReplyView;
    public j.e onLongClickItemClickListener;
    public PostData postData;
    public boolean showTrisectionAndFeedback;
    public View tempView;

    /* loaded from: classes12.dex */
    public class a extends c.a.d.a.e {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // c.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                boolean z = false;
                if (obj != null) {
                    int loadDataMode = this.a.mForumManageModel.getLoadDataMode();
                    if (loadDataMode == 0) {
                        this.a.mModel.q1();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        this.a.finishDelPost(bVar, (bVar.f50069e != 1002 || bVar.f50070f) ? true : true);
                        return;
                    } else if (loadDataMode != 1) {
                        return;
                    } else {
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        this.a.mView.v(1, dVar.a, dVar.f50073b, true);
                        return;
                    }
                }
                this.a.mView.v(this.a.mForumManageModel.getLoadDataMode(), false, null, false);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FoldCommentActivity f48195e;

        public b(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48195e = foldCommentActivity;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            aVar.dismiss();
        }
    }

    /* loaded from: classes12.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserMuteAddAndDelCustomMessage f48196e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FoldCommentActivity f48197f;

        public c(FoldCommentActivity foldCommentActivity, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity, userMuteAddAndDelCustomMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48197f = foldCommentActivity;
            this.f48196e = userMuteAddAndDelCustomMessage;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f48197f.mView.d0();
                MessageManager.getInstance().sendMessage(this.f48196e);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FoldCommentActivity f48198e;

        public d(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48198e = foldCommentActivity;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class e implements c.a.s0.x.y.c {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // c.a.s0.x.y.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.showProgressBar();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(FoldCommentActivity foldCommentActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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

    /* loaded from: classes12.dex */
    public class g implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        /* loaded from: classes12.dex */
        public class a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // c.a.s0.s.s.a.e
            public void onClick(c.a.s0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                }
            }
        }

        /* loaded from: classes12.dex */
        public class b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f48199e;

            public b(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48199e = gVar;
            }

            @Override // c.a.s0.s.s.a.e
            public void onClick(c.a.s0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                    this.f48199e.a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.f48199e.a.getActivity(), 0, 26, 2)));
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, m0 m0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, m0Var, writeData, antiData}) == null) {
                if (!c.a.d.f.p.m.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.mModel != null && this.a.mModel.R0() != null) {
                        statisticItem.param("fid", this.a.mModel.R0().m());
                    }
                    if (this.a.mModel != null) {
                        statisticItem.param("tid", this.a.mModel.h1());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (z) {
                    v0 v0Var = this.a.mContentProcessController;
                    if (v0Var != null) {
                        v0Var.d();
                    }
                    if (postWriteCallBackData == null || postWriteCallBackData.getIconStampData() == null) {
                        return;
                    }
                    c.a.s0.t.h.b.c(this.a.getPageContext(), postWriteCallBackData, 2);
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
                    if (c.a.d.f.p.m.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.makeText(this.a.getActivity(), this.a.getActivity().getString(c.a.t0.s2.l.current_links_too_much_please_modify_and_publish), null).show();
                    } else {
                        DefaultNavigationBarCoverTip.makeText(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(this.a.getActivity());
                    if (c.a.d.f.p.m.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.setMessage(this.a.getActivity().getString(c.a.t0.s2.l.open_member_and_add_more_links));
                    } else {
                        aVar.setMessage(postWriteCallBackData.getErrorString());
                    }
                    aVar.setNegativeButton(c.a.t0.s2.l.cancel, new a(this));
                    aVar.setPositiveButton(c.a.t0.s2.l.open_now, new b(this));
                    aVar.create(this.a.getPageContext()).show();
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

    /* loaded from: classes12.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FoldCommentActivity f48200e;

        public h(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48200e = foldCommentActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f48200e.mModel == null) {
                return;
            }
            this.f48200e.mModel.loadData();
        }
    }

    /* loaded from: classes12.dex */
    public class i implements ShareSuccessReplyToServerModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        /* loaded from: classes12.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomDialogData f48201e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ i f48202f;

            public a(i iVar, CustomDialogData customDialogData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar, customDialogData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48202f = iVar;
                this.f48201e = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.t0.s2.t.c.a(this.f48202f.a.getPageContext(), this.f48201e).show();
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                c.a.d.f.m.e.a().postDelayed(new a(this, customDialogData), 1000L);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FoldCommentActivity f48203e;

        public j(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48203e = foldCommentActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            StatisticItem statisticItem;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
                return;
            }
            if ((view instanceof TbListTextView) && (view.getParent() instanceof TbRichTextView)) {
                StatisticItem statisticItem2 = new StatisticItem("c13398");
                statisticItem2.param("tid", this.f48203e.mModel.h1());
                statisticItem2.param("fid", this.f48203e.mModel.getForumId());
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("obj_locate", 1);
                TiebaStatic.log(statisticItem2);
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(c.a.t0.s2.i.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData = (PostData) obj;
                        if (this.f48203e.mModel == null || this.f48203e.mModel.R0() == null || postData.t() == null || postData.A() == 1 || !this.f48203e.checkUpIsLogin()) {
                            return;
                        }
                        if (this.f48203e.mView.y() != null) {
                            this.f48203e.mView.y().c();
                        }
                        c.a.t0.s2.r.t tVar = new c.a.t0.s2.r.t();
                        tVar.A(this.f48203e.mModel.R0().l());
                        tVar.E(this.f48203e.mModel.R0().O());
                        tVar.C(postData);
                        this.f48203e.mView.x().S(tVar);
                        this.f48203e.mView.x().setPostId(postData.G());
                        this.f48203e.locateSubPbEditor(view, postData.t().getUserId(), "", postData);
                        TiebaStatic.log("c11743");
                        c.a.t0.s2.w.a.b(this.f48203e.mModel.R0(), postData, postData.f0, 8, 1);
                        if (this.f48203e.mPbEditor != null) {
                            this.f48203e.mView.W(this.f48203e.mPbEditor.C());
                        }
                    }
                }
            } else if (view.getId() != c.a.t0.s2.i.pb_floor_right_top_feedback && view.getId() != c.a.t0.s2.i.pb_post_op_more) {
                if (view.getId() != c.a.t0.s2.i.sub_pb_more && view.getId() != c.a.t0.s2.i.sub_pb_item && view.getId() != c.a.t0.s2.i.pb_floor_reply_more && view.getId() != c.a.t0.s2.i.new_sub_pb_list_richText) {
                    if ((view.getId() == c.a.t0.s2.i.pb_post_reply || view.getId() == c.a.t0.s2.i.post_info_commont_img || view.getId() == c.a.t0.s2.i.pb_floor_comment_container) && this.f48203e.mModel != null) {
                        if (view.getId() == c.a.t0.s2.i.pb_post_reply) {
                            StatisticItem statisticItem3 = new StatisticItem("c13398");
                            statisticItem3.param("tid", this.f48203e.mModel.h1());
                            statisticItem3.param("fid", this.f48203e.mModel.getForumId());
                            statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                            statisticItem3.param("obj_locate", 6);
                            TiebaStatic.log(statisticItem3);
                        }
                        if (view.getId() == c.a.t0.s2.i.post_info_commont_img) {
                            if (!DialogLoginHelper.checkUpIsLogin(new t0(this.f48203e.getActivity(), "pb_huifu_louzhonglou"))) {
                                this.f48203e.floorReplyView = view;
                                return;
                            }
                        } else if (view.getId() == c.a.t0.s2.i.pb_post_reply && !DialogLoginHelper.checkUpIsLogin(new t0(this.f48203e.getActivity(), "pb_huifu_louzhonglou"))) {
                            this.f48203e.floorReplyView = view;
                            return;
                        }
                        if (this.f48203e.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                            SparseArray sparseArray = (SparseArray) view.getTag();
                            if (sparseArray.get(c.a.t0.s2.i.tag_load_sub_data) instanceof PostData) {
                                PostData postData2 = (PostData) sparseArray.get(c.a.t0.s2.i.tag_load_sub_data);
                                if (view.getId() == c.a.t0.s2.i.pb_post_reply && (statisticItem = postData2.g0) != null) {
                                    StatisticItem copy = statisticItem.copy();
                                    copy.delete("obj_locate");
                                    copy.param("obj_locate", 8);
                                    TiebaStatic.log(copy);
                                } else if (view.getId() == c.a.t0.s2.i.post_info_commont_img || view.getId() == c.a.t0.s2.i.pb_floor_comment_container) {
                                    TiebaStatic.log(new StatisticItem("c13700").param("tid", this.f48203e.mModel.i1()).param("fid", this.f48203e.mModel.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData2.G()).param("obj_source", 1).param("obj_type", 3));
                                }
                                if (this.f48203e.mModel == null || this.f48203e.mModel.R0() == null || postData2.t() == null || postData2.A() == 1) {
                                    return;
                                }
                                if (this.f48203e.mView.y() != null) {
                                    this.f48203e.mView.y().c();
                                }
                                if (this.f48203e.showTrisectionAndFeedback && postData2.P() != null && postData2.P().size() != 0) {
                                    this.f48203e.startSubPbActivity(postData2, true);
                                    return;
                                }
                                c.a.t0.s2.r.t tVar2 = new c.a.t0.s2.r.t();
                                tVar2.A(this.f48203e.mModel.R0().l());
                                tVar2.E(this.f48203e.mModel.R0().O());
                                tVar2.C(postData2);
                                this.f48203e.mView.x().S(tVar2);
                                this.f48203e.mView.x().setPostId(postData2.G());
                                this.f48203e.locateSubPbEditor(view, postData2.t().getUserId(), "", postData2);
                                if (this.f48203e.mPbEditor != null) {
                                    this.f48203e.mView.W(this.f48203e.mPbEditor.C());
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
                if (view.getId() == c.a.t0.s2.i.new_sub_pb_list_richText) {
                    StatisticItem statisticItem4 = new StatisticItem("c13398");
                    statisticItem4.param("tid", this.f48203e.mModel.h1());
                    statisticItem4.param("fid", this.f48203e.mModel.getForumId());
                    statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem4.param("obj_locate", 4);
                    TiebaStatic.log(statisticItem4);
                }
                if (view.getId() == c.a.t0.s2.i.pb_floor_reply_more && !DialogLoginHelper.checkUpIsLogin(new t0(this.f48203e.getActivity(), "pb_chakanhuifu"))) {
                    this.f48203e.moreReplyView = view;
                } else if (this.f48203e.checkUpIsLogin()) {
                    if (this.f48203e.mModel == null || this.f48203e.mModel.R0() == null) {
                        return;
                    }
                    this.f48203e.mView.u();
                    SparseArray sparseArray2 = (SparseArray) view.getTag();
                    PostData postData3 = (PostData) sparseArray2.get(c.a.t0.s2.i.tag_load_sub_data);
                    PostData postData4 = (PostData) sparseArray2.get(c.a.t0.s2.i.tag_load_sub_reply_data);
                    View view2 = (View) sparseArray2.get(c.a.t0.s2.i.tag_load_sub_view);
                    if (postData3 == null || view2 == null) {
                        return;
                    }
                    if (postData3.E() == 1) {
                        TiebaStatic.log(new StatisticItem("c12630"));
                    }
                    StatisticItem statisticItem5 = postData3.g0;
                    if (statisticItem5 != null) {
                        StatisticItem copy2 = statisticItem5.copy();
                        copy2.delete("obj_locate");
                        if (view.getId() == c.a.t0.s2.i.new_sub_pb_list_richText) {
                            copy2.param("obj_locate", 6);
                        } else if (view.getId() == c.a.t0.s2.i.pb_floor_reply_more) {
                            copy2.param("obj_locate", 8);
                        }
                        TiebaStatic.log(copy2);
                    }
                    if (view.getId() == c.a.t0.s2.i.pb_floor_reply_more && this.f48203e.mModel != null && this.f48203e.mModel.R0() != null && postData3 != null) {
                        TiebaStatic.log(new StatisticItem("c14443").param("tid", this.f48203e.mModel.h1()).param("fname", this.f48203e.mModel.R0().n()).param("fid", this.f48203e.mModel.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData3.G()));
                    }
                    String h1 = this.f48203e.mModel.h1();
                    String G = postData3.G();
                    String G2 = postData4 != null ? postData4.G() : "";
                    int V = this.f48203e.mModel.R0() != null ? this.f48203e.mModel.R0().V() : 0;
                    this.f48203e.stopVoice();
                    if (view.getId() == c.a.t0.s2.i.replybtn) {
                        AbsPbActivity.e processSubPbImg = this.f48203e.processSubPbImg(G);
                        if (this.f48203e.mModel == null || this.f48203e.mModel.R0() == null || processSubPbImg == null) {
                            return;
                        }
                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.f48203e.getPageContext().getPageActivity()).createSubPbActivityConfig(h1, G, "pb", true, this.f48203e.mIsFromVideoTab, null, true, null, V, postData3.S(), this.f48203e.mModel.R0().d(), false, postData3.t().getIconInfo(), 5).addBigImageData(processSubPbImg.a, processSubPbImg.f48229b, processSubPbImg.f48234g, processSubPbImg.f48237j);
                        addBigImageData.setKeyPageStartFrom(this.f48203e.mModel.Q0());
                        addBigImageData.setFromFrsForumId(this.f48203e.mModel.getFromForumId());
                        addBigImageData.setWorksInfoData(this.f48203e.mModel.m1());
                        addBigImageData.setKeyFromForumId(this.f48203e.mModel.getForumId());
                        addBigImageData.setBjhData(this.f48203e.mModel.k0());
                        addBigImageData.setTiebaPlusData(this.f48203e.mModel.F(), this.f48203e.mModel.B(), this.f48203e.mModel.C(), this.f48203e.mModel.A(), this.f48203e.mModel.G());
                        addBigImageData.setFromFoldComment(true);
                        addBigImageData.setFromVideoPageUniqueId((BdUniqueId) this.f48203e.getIntent().getSerializableExtra("key_from_video_page_id"));
                        this.f48203e.sendMessage(new CustomMessage(2002001, addBigImageData));
                    } else if (view.getId() == c.a.t0.s2.i.pb_floor_reply_more && this.f48203e.mIsFromVideoTab) {
                        AbsPbActivity.e processSubPbImg2 = this.f48203e.processSubPbImg(G);
                        if (this.f48203e.mModel == null || this.f48203e.mModel.R0() == null || processSubPbImg2 == null) {
                            return;
                        }
                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(this.f48203e.getPageContext().getPageActivity()).createSubPbActivityConfig(h1, G, "pb", true, this.f48203e.mIsFromVideoTab, null, true, null, V, postData3.S(), this.f48203e.mModel.R0().d(), false, postData3.t().getIconInfo(), 5).addBigImageData(processSubPbImg2.a, processSubPbImg2.f48229b, processSubPbImg2.f48234g, processSubPbImg2.f48237j);
                        addBigImageData2.setKeyPageStartFrom(this.f48203e.mModel.Q0());
                        addBigImageData2.setFromFrsForumId(this.f48203e.mModel.getFromForumId());
                        addBigImageData2.setWorksInfoData(this.f48203e.mModel.m1());
                        addBigImageData2.setKeyFromForumId(this.f48203e.mModel.getForumId());
                        addBigImageData2.setBjhData(this.f48203e.mModel.k0());
                        addBigImageData2.setTiebaPlusData(this.f48203e.mModel.F(), this.f48203e.mModel.B(), this.f48203e.mModel.C(), this.f48203e.mModel.A(), this.f48203e.mModel.G());
                        addBigImageData2.setFromFoldComment(true);
                        addBigImageData2.setFromVideoPageUniqueId((BdUniqueId) this.f48203e.getIntent().getSerializableExtra("key_from_video_page_id"));
                        this.f48203e.sendMessage(new CustomMessage(2002001, addBigImageData2));
                    } else {
                        TiebaStatic.log("c11742");
                        AbsPbActivity.e processSubPbImg3 = this.f48203e.processSubPbImg(G);
                        if (postData3 == null || this.f48203e.mModel == null || this.f48203e.mModel.R0() == null || processSubPbImg3 == null) {
                            return;
                        }
                        SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(this.f48203e.getPageContext().getPageActivity()).createSubPbActivityConfig(h1, G, "pb", true, this.f48203e.mIsFromVideoTab, null, false, G2, V, postData3.S(), this.f48203e.mModel.R0().d(), false, postData3.t().getIconInfo(), 5).addBigImageData(processSubPbImg3.a, processSubPbImg3.f48229b, processSubPbImg3.f48234g, processSubPbImg3.f48237j);
                        if (!c.a.d.f.p.m.isEmpty(G2)) {
                            addBigImageData3.setHighLightPostId(G2);
                            addBigImageData3.setKeyIsUseSpid(true);
                        }
                        addBigImageData3.setKeyFromForumId(this.f48203e.mModel.getForumId());
                        addBigImageData3.setTiebaPlusData(this.f48203e.mModel.F(), this.f48203e.mModel.B(), this.f48203e.mModel.C(), this.f48203e.mModel.A(), this.f48203e.mModel.G());
                        addBigImageData3.setBjhData(this.f48203e.mModel.k0());
                        addBigImageData3.setKeyPageStartFrom(this.f48203e.mModel.Q0());
                        addBigImageData3.setFromFrsForumId(this.f48203e.mModel.getFromForumId());
                        addBigImageData3.setWorksInfoData(this.f48203e.mModel.m1());
                        addBigImageData3.setFromFoldComment(true);
                        addBigImageData3.setFromVideoPageUniqueId((BdUniqueId) this.f48203e.getIntent().getSerializableExtra("key_from_video_page_id"));
                        this.f48203e.sendMessage(new CustomMessage(2002001, addBigImageData3));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 3).param("fid", this.f48203e.mModel.R0().m()));
                }
            } else {
                StatisticItem statisticItem6 = new StatisticItem("c13398");
                statisticItem6.param("tid", this.f48203e.mModel.h1());
                statisticItem6.param("fid", this.f48203e.mModel.getForumId());
                statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem6.param("obj_locate", 7);
                TiebaStatic.log(statisticItem6);
                if (this.f48203e.mModel != null && this.f48203e.mModel.R0() != null && this.f48203e.postData != null) {
                    TiebaStatic.log(new StatisticItem("c14441").param("tid", this.f48203e.mModel.h1()).param("fname", this.f48203e.mModel.R0().n()).param("fid", this.f48203e.mModel.R0().m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.f48203e.postData.G()));
                }
                FoldCommentActivity foldCommentActivity = this.f48203e;
                foldCommentActivity.isDialogFromLongClick = false;
                foldCommentActivity.dealLongClickListener(view);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class k implements PbModel.g {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void a(int i2, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), responsedMessage, Boolean.valueOf(z2), Long.valueOf(j2)}) == null) {
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void b(c.a.t0.s2.r.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void c(boolean z, int i2, int i3, int i4, c.a.t0.s2.r.f fVar, String str, int i5) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fVar, str, Integer.valueOf(i5)}) == null) || this.a.mView == null) {
                return;
            }
            this.a.mView.U();
            if (!z) {
                this.a.onNetOrDataError(i2, str);
                return;
            }
            this.a.mView.E();
            if (fVar != null) {
                if (fVar.s() == 1) {
                    this.a.mIsFromCDN = true;
                } else {
                    this.a.mIsFromCDN = false;
                }
                String str2 = null;
                if (this.a.mModel == null || !this.a.mModel.t1()) {
                    if (this.a.mView != null) {
                        str2 = this.a.mView.z();
                    }
                } else {
                    str2 = this.a.getPageContext().getString(c.a.t0.s2.l.pb_reply_hint_from_smart_frs);
                }
                if (!StringUtils.isNull(str2)) {
                    this.a.mPbEditor.k0(TbSingleton.getInstance().getAdVertiComment(fVar.k0(), fVar.l0(), str2));
                }
                this.a.mView.S(fVar, this.a.mIsFromCDN);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48204e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48205f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ FoldCommentActivity f48206g;

        /* loaded from: classes12.dex */
        public class a implements TextWatcher {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ l f48207e;

            public a(l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48207e = lVar;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                v0 v0Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (v0Var = this.f48207e.f48206g.mContentProcessController) == null || v0Var.g() == null) {
                    return;
                }
                if (!this.f48207e.f48206g.mContentProcessController.g().e()) {
                    this.f48207e.f48206g.mContentProcessController.b(false);
                }
                this.f48207e.f48206g.mContentProcessController.g().l(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48206g = foldCommentActivity;
            this.f48204e = str;
            this.f48205f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2;
            int f2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i3 = c.a.d.f.p.n.i(this.f48206g.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i2 = TbadkCoreApplication.getInst().getKeyboardHeight();
                    f2 = c.a.d.f.p.n.f(this.f48206g.getPageContext().getPageActivity(), c.a.t0.s2.g.tbds256);
                } else {
                    i2 = i3 / 2;
                    f2 = c.a.d.f.p.n.f(this.f48206g.getPageContext().getPageActivity(), c.a.t0.s2.g.tbds256);
                }
                int i4 = i3 - (i2 + f2);
                FoldCommentActivity foldCommentActivity = this.f48206g;
                boolean z = true;
                foldCommentActivity.mView.w().smoothScrollBy((foldCommentActivity.mReplyFloorLocation[1] + foldCommentActivity.mReplyFloorMeasureHeight) - i4, 50);
                if (this.f48206g.mView.y() != null) {
                    this.f48206g.mPbEditor.a().setVisibility(8);
                    this.f48206g.mView.y().o(this.f48204e, this.f48205f, this.f48206g.mView.z(), (this.f48206g.mModel == null || this.f48206g.mModel.R0() == null || this.f48206g.mModel.R0().O() == null || !this.f48206g.mModel.R0().O().T1()) ? false : false);
                    c.a.s0.x.y.h b2 = this.f48206g.mView.y().b();
                    if (b2 != null && this.f48206g.mModel != null && this.f48206g.mModel.R0() != null) {
                        b2.G(this.f48206g.mModel.R0().d());
                        b2.b0(this.f48206g.mModel.R0().O());
                    }
                    if (this.f48206g.mContentProcessController.f() == null && this.f48206g.mView.y().b().t() != null) {
                        this.f48206g.mView.y().b().t().f(new a(this));
                        FoldCommentActivity foldCommentActivity2 = this.f48206g;
                        foldCommentActivity2.mContentProcessController.n(foldCommentActivity2.mView.y().b().t().h());
                        this.f48206g.mView.y().b().M(this.f48206g.mCheckSubFloorCallBack);
                    }
                }
                this.f48206g.mView.B();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class m implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f48208b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FoldCommentActivity f48209c;

        /* loaded from: classes12.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ m f48210e;

            /* renamed from: com.baidu.tieba.pb.pb.foldcomment.FoldCommentActivity$m$a$a  reason: collision with other inner class name */
            /* loaded from: classes12.dex */
            public class C1928a implements TextWatcher {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f48211e;

                public C1928a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f48211e = aVar;
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    v0 v0Var;
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (v0Var = this.f48211e.f48210e.f48209c.mContentProcessController) == null || v0Var.g() == null) {
                        return;
                    }
                    if (!this.f48211e.f48210e.f48209c.mContentProcessController.g().e()) {
                        this.f48211e.f48210e.f48209c.mContentProcessController.b(false);
                    }
                    this.f48211e.f48210e.f48209c.mContentProcessController.g().l(false);
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
                    }
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48210e = mVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i2;
                int f2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int i3 = c.a.d.f.p.n.i(this.f48210e.f48209c.getApplicationContext());
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        i2 = TbadkCoreApplication.getInst().getKeyboardHeight();
                        f2 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), c.a.t0.s2.g.tbds410);
                    } else {
                        i2 = i3 / 2;
                        f2 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), c.a.t0.s2.g.tbds410);
                    }
                    int i4 = i3 - (i2 + f2);
                    FoldCommentActivity foldCommentActivity = this.f48210e.f48209c;
                    boolean z = true;
                    foldCommentActivity.mView.w().smoothScrollBy((foldCommentActivity.mReplyFloorLocation[1] + foldCommentActivity.mReplyFloorMeasureHeight) - i4, 50);
                    if (this.f48210e.f48209c.mView.y() != null) {
                        this.f48210e.f48209c.mPbEditor.a().setVisibility(8);
                        z = (this.f48210e.f48209c.mModel == null || this.f48210e.f48209c.mModel.R0() == null || this.f48210e.f48209c.mModel.R0().O() == null || !this.f48210e.f48209c.mModel.R0().O().T1()) ? false : false;
                        c.a.t0.s2.u.f.t y = this.f48210e.f48209c.mView.y();
                        m mVar = this.f48210e;
                        y.o(mVar.a, mVar.f48208b, mVar.f48209c.mView.z(), z);
                        c.a.s0.x.y.h b2 = this.f48210e.f48209c.mView.y().b();
                        if (b2 != null && this.f48210e.f48209c.mModel != null && this.f48210e.f48209c.mModel.R0() != null) {
                            b2.G(this.f48210e.f48209c.mModel.R0().d());
                            b2.b0(this.f48210e.f48209c.mModel.R0().O());
                        }
                        if (this.f48210e.f48209c.mContentProcessController.f() == null && this.f48210e.f48209c.mView.y().b().t() != null) {
                            this.f48210e.f48209c.mView.y().b().t().f(new C1928a(this));
                            FoldCommentActivity foldCommentActivity2 = this.f48210e.f48209c;
                            foldCommentActivity2.mContentProcessController.n(foldCommentActivity2.mView.y().b().t().h());
                            this.f48210e.f48209c.mView.y().b().M(this.f48210e.f48209c.mCheckSubFloorCallBack);
                        }
                    }
                    this.f48210e.f48209c.mView.B();
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48209c = foldCommentActivity;
            this.a = str;
            this.f48208b = str2;
        }

        @Override // c.a.t0.d1.r2.a.c.d
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // c.a.t0.d1.r2.a.c.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                c.a.d.f.m.e.a().postDelayed(new a(this), 0L);
            }
        }

        @Override // c.a.t0.d1.r2.a.c.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes12.dex */
    public class n implements c.a.s0.x.y.b {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // c.a.s0.x.y.b
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                v0 v0Var = this.a.mContentProcessController;
                if (v0Var == null || v0Var.g() == null || !this.a.mContentProcessController.g().d()) {
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

    /* loaded from: classes12.dex */
    public class o implements c.d {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // c.a.t0.d1.r2.a.c.d
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // c.a.t0.d1.r2.a.c.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                if (this.a.mPbEditor != null && this.a.mPbEditor.a() != null) {
                    this.a.mPbEditor.a().sendAction(new c.a.s0.x.a(45, 27, null));
                }
                this.a.mView.t();
            }
        }

        @Override // c.a.t0.d1.r2.a.c.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes12.dex */
    public class p implements a.InterfaceC0841a {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // c.a.s0.i.a.InterfaceC0841a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                if (z) {
                    if (this.a.mMarkModel != null) {
                        this.a.mMarkModel.h(z2);
                    }
                    this.a.mModel.x2(z2);
                    if (this.a.mModel.D0()) {
                        this.a.makeFakeMark();
                    }
                    if (z2) {
                        if (this.a.mMarkModel != null) {
                            if (this.a.mMarkModel.f() == null || this.a.mModel == null || this.a.mModel.R0() == null || this.a.mModel.R0().O() == null || this.a.mModel.R0().O().J() == null) {
                                return;
                            }
                            MarkData f2 = this.a.mMarkModel.f();
                            MetaData J = this.a.mModel.R0().O().J();
                            if (f2 != null && J != null) {
                                if (StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), J.getUserId()) || J.hadConcerned()) {
                                    this.a.showToast(c.a.t0.s2.l.add_mark_on_pb);
                                    if (c.a.s0.t.h.a.e(this.a.getActivity(), 0)) {
                                        c.a.s0.t.h.a.g(this.a.getPageContext(), 6, 2000L);
                                    }
                                }
                            } else {
                                FoldCommentActivity foldCommentActivity = this.a;
                                foldCommentActivity.showToast(foldCommentActivity.getPageContext().getString(c.a.t0.s2.l.add_mark));
                            }
                        }
                        this.a.addCollectionStat();
                        return;
                    }
                    FoldCommentActivity foldCommentActivity2 = this.a;
                    foldCommentActivity2.showToast(foldCommentActivity2.getPageContext().getString(c.a.t0.s2.l.remove_mark));
                    return;
                }
                FoldCommentActivity foldCommentActivity3 = this.a;
                foldCommentActivity3.showToast(foldCommentActivity3.getPageContext().getString(c.a.t0.s2.l.update_mark_failed));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class q implements c.a.d.f.k.c<ImageView> {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
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
                    if (c.a.s0.s.k.c().g()) {
                        tbImageView.setAdjustViewBounds(false);
                        tbImageView.setInterceptOnClick(false);
                    } else {
                        tbImageView.setDefaultResource(c.a.t0.s2.h.icon_click);
                        tbImageView.setAdjustViewBounds(true);
                        tbImageView.setInterceptOnClick(true);
                    }
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.c
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
                    foreDrawableImageView.stopLoading();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(c.a.t0.s2.f.CAM_X0204);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.c
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.getPageContext().getPageActivity());
                boolean g2 = c.a.s0.s.k.c().g();
                foreDrawableImageView.setDefaultBg(SkinManager.getDrawable(c.a.t0.s2.f.common_color_10220));
                if (g2) {
                    foreDrawableImageView.setAdjustViewBounds(false);
                    foreDrawableImageView.setInterceptOnClick(false);
                } else {
                    foreDrawableImageView.setDefaultResource(c.a.t0.s2.h.icon_click);
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
                    foreDrawableImageView.stopLoading();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(c.a.t0.s2.f.CAM_X0204);
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r14v22, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$b */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.y
        public void a(View view, String str, int i2, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, str, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    if (view.getTag(c.a.t0.s2.i.tag_rich_text_meme_info) == null || !(view.getTag(c.a.t0.s2.i.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                        if (this.a.mModel.R0().g0()) {
                            ArrayList<String> arrayList = new ArrayList<>();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                            TbRichTextView tbRichTextView = null;
                            if (view.getParent() instanceof TbRichTextView) {
                                tbRichTextView = (TbRichTextView) view.getParent();
                            } else if ((view.getParent() instanceof GridImageLayout) && (view.getParent().getParent() instanceof TbRichTextView)) {
                                tbRichTextView = (TbRichTextView) view.getParent().getParent();
                            }
                            int i3 = -1;
                            if (tbRichTextView != null && tbRichTextView.getRichText() != null && tbRichTextView.getRichText().A() != null) {
                                ArrayList<TbRichTextImageInfo> A = tbRichTextView.getRichText().A();
                                int i4 = -1;
                                for (int i5 = 0; i5 < A.size(); i5++) {
                                    if (A.get(i5) != null) {
                                        arrayList.add(A.get(i5).B());
                                        if (i4 == -1 && str != null && (str.equals(A.get(i5).B()) || str.equals(A.get(i5).y()) || str.equals(A.get(i5).w()) || str.equals(A.get(i5).x()) || str.equals(A.get(i5).A()))) {
                                            i4 = i5;
                                        }
                                        ImageUrlData imageUrlData = new ImageUrlData();
                                        imageUrlData.imageUrl = A.get(i5).B();
                                        imageUrlData.originalUrl = A.get(i5).B();
                                        imageUrlData.isLongPic = A.get(i5).E();
                                        concurrentHashMap.put(A.get(i5).B(), imageUrlData);
                                    }
                                }
                                i3 = i4;
                            }
                            ImageViewerConfig.b bVar = new ImageViewerConfig.b();
                            bVar.x(arrayList);
                            bVar.B(i3);
                            bVar.C(false);
                            bVar.F(this.a.mModel.c1());
                            bVar.w(concurrentHashMap);
                            bVar.H(true);
                            bVar.K(false);
                            bVar.G(this.a.isHostOnlyMode());
                            if (this.a.mModel != null) {
                                bVar.A(this.a.mModel.getFromForumId());
                                if (this.a.mModel.R0() != null) {
                                    bVar.N(this.a.mModel.R0().O());
                                }
                            }
                            ImageViewerConfig v = bVar.v(this.a.getPageContext().getPageActivity());
                            v.getIntent().putExtra("from", "pb");
                            this.a.sendMessage(new CustomMessage(2010000, v));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                            return;
                        }
                        AbsPbActivity.e eVar = new AbsPbActivity.e();
                        this.a.processImgUrls(str, i2, eVar);
                        if (eVar.f48235h) {
                            TbRichText validImage = this.a.validImage(str, i2);
                            if (validImage != null && this.a.imgIndex >= 0 && this.a.imgIndex < validImage.y().size()) {
                                ArrayList<String> arrayList2 = new ArrayList<>();
                                String a = c.a.t0.s2.r.g.a(validImage.y().get(this.a.imgIndex));
                                int i6 = 0;
                                while (true) {
                                    if (i6 >= eVar.a.size()) {
                                        break;
                                    } else if (eVar.a.get(i6).equals(a)) {
                                        eVar.f48237j = i6;
                                        arrayList2.add(a);
                                        break;
                                    } else {
                                        i6++;
                                    }
                                }
                                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                                if (!ListUtils.isEmpty(arrayList2)) {
                                    String str2 = arrayList2.get(0);
                                    concurrentHashMap2.put(str2, eVar.f48229b.get(str2));
                                }
                                ImageViewerConfig.b bVar2 = new ImageViewerConfig.b();
                                bVar2.x(arrayList2);
                                bVar2.z(eVar.f48230c);
                                bVar2.y(eVar.f48231d);
                                bVar2.O(eVar.f48232e);
                                bVar2.C(eVar.f48234g);
                                bVar2.H(true);
                                bVar2.J(eVar.f48236i);
                                bVar2.F(this.a.mModel.c1());
                                bVar2.w(concurrentHashMap2);
                                bVar2.K(false);
                                bVar2.G(this.a.isHostOnlyMode());
                                bVar2.L(eVar.f48233f);
                                if (this.a.mModel != null) {
                                    bVar2.A(this.a.mModel.getFromForumId());
                                    if (this.a.mModel.R0() != null) {
                                        bVar2.N(this.a.mModel.R0().O());
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
                            concurrentHashMap3.put(str3, eVar.f48229b.get(str3));
                        }
                        ImageViewerConfig.b bVar3 = new ImageViewerConfig.b();
                        bVar3.x(arrayList3);
                        bVar3.z(eVar.f48230c);
                        bVar3.y(eVar.f48231d);
                        bVar3.O(eVar.f48232e);
                        bVar3.C(eVar.f48234g);
                        bVar3.H(true);
                        bVar3.J(eVar.a.get(0));
                        bVar3.F(this.a.mModel.c1());
                        bVar3.w(concurrentHashMap3);
                        bVar3.K(false);
                        bVar3.G(this.a.isHostOnlyMode());
                        bVar3.L(eVar.f48233f);
                        bVar3.D(false);
                        if (this.a.mModel != null) {
                            bVar3.A(this.a.mModel.getFromForumId());
                            if (this.a.mModel.R0() != null) {
                                bVar3.N(this.a.mModel.R0().O());
                            }
                        }
                        ImageViewerConfig v3 = bVar3.v(this.a.getPageContext().getPageActivity());
                        v3.getIntent().putExtra("from", "pb");
                        this.a.sendMessage(new CustomMessage(2010000, v3));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                        return;
                    }
                    TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(c.a.t0.s2.i.tag_rich_text_meme_info);
                    boolean isGif = ((TbImageView) view).isGif();
                    if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                        this.a.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(this.a.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, isGif)));
                    }
                    this.a.tempView = view;
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
        }
    }

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && z) {
                if (i2 == ReplyPrivacyCheckController.TYPE_THREAD) {
                    this.a.mPbEditor.L(null, null);
                } else if (i2 == ReplyPrivacyCheckController.TYPE_FLOOR && this.a.mView != null && this.a.mView.y() != null && this.a.mView.y().b() != null) {
                    this.a.mView.y().b().F();
                } else if (i2 == ReplyPrivacyCheckController.TYPE_EMOTION_IMAGE) {
                    FoldCommentActivity foldCommentActivity = this.a;
                    foldCommentActivity.sendEmotion(foldCommentActivity.mEmotionImageData);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class t implements PbFragment.c3 {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.c3
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!c.a.d.f.p.l.z()) {
                    this.a.showToast(c.a.t0.s2.l.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.mModel.R0().l().getId(), this.a.mModel.R0().l().getName(), this.a.mModel.R0().O().g0(), String.valueOf(this.a.mModel.R0().U().getUserId()), objArr.length > 1 ? String.valueOf(objArr[1]) : "", objArr.length > 3 ? String.valueOf(objArr[3]) : "", objArr.length > 2 ? String.valueOf(objArr[2]) : "", objArr.length > 4 ? String.valueOf(objArr[4]) : "")));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class u implements c.a {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // c.a.t0.s2.s.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.t0.s2.s.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent)) == null) {
                if (view != null) {
                    if (view.getId() == c.a.t0.s2.i.richText) {
                        if (this.a.richTextHandleSingleTap(view)) {
                            return true;
                        }
                    } else if (view.getId() == c.a.t0.s2.i.pb_floor_item_layout) {
                        if (view.getTag(c.a.t0.s2.i.tag_from) instanceof SparseArray) {
                            this.a.startSubPbActivity((SparseArray) view.getTag(c.a.t0.s2.i.tag_from));
                        }
                    } else if ((view instanceof TbRichTextView) || view.getId() == c.a.t0.s2.i.pb_post_header_layout) {
                        SparseArray sparseArray = view.getTag() instanceof SparseArray ? (SparseArray) view.getTag() : null;
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

        @Override // c.a.t0.s2.s.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public class v implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FoldCommentActivity f48212e;

        public v(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48212e = foldCommentActivity;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) ? this.f48212e.dealLongClickListener(view) : invokeL.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public class w implements j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FoldCommentActivity f48213e;

        public w(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48213e = foldCommentActivity;
        }

        @Override // c.a.s0.s.s.j.e
        public void onItemClick(c.a.s0.s.s.j jVar, int i2, View view) {
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, jVar, i2, view) == null) {
                if (this.f48213e.mLongClickDialog != null) {
                    this.f48213e.mLongClickDialog.dismiss();
                }
                this.f48213e.trackDialogItem(i2);
                int i3 = 4;
                switch (i2) {
                    case -4:
                        View view2 = (View) ((SparseArray) view.getTag()).get(c.a.t0.s2.i.pb_dialog_item_share);
                        this.f48213e.putTrackTagToPerformView(view2);
                        if (view2 != null) {
                            view2.performClick();
                            return;
                        }
                        return;
                    case -3:
                        View view3 = (View) ((SparseArray) view.getTag()).get(c.a.t0.s2.i.pb_dialog_item_reply);
                        this.f48213e.putTrackTagToPerformView(view3);
                        if (view3 != null) {
                            view3.performClick();
                            return;
                        }
                        return;
                    case -2:
                        View view4 = (View) ((SparseArray) view.getTag()).get(c.a.t0.s2.i.pb_dialog_item_zan_2);
                        if (view4 != null) {
                            AgreeView agreeView = (AgreeView) view4;
                            this.f48213e.putTrackTagToPerformView(view4);
                            if (agreeView.getImgDisagree() != null) {
                                agreeView.getImgDisagree().performClick();
                                return;
                            }
                            return;
                        }
                        return;
                    case -1:
                        View view5 = (View) ((SparseArray) view.getTag()).get(c.a.t0.s2.i.pb_dialog_item_zan_2);
                        if (view5 != null) {
                            this.f48213e.putTrackTagToPerformView(view5);
                            AgreeView agreeView2 = (AgreeView) view5;
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
                        if (this.f48213e.mSaveBdImage == null || TextUtils.isEmpty(this.f48213e.mSaveImageUrl)) {
                            return;
                        }
                        if (this.f48213e.mEmotionInfo == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.f48213e.mSaveImageUrl));
                        } else {
                            d.a aVar = new d.a();
                            aVar.a = this.f48213e.mSaveImageUrl;
                            String str = "";
                            if (this.f48213e.mEmotionInfo.memeInfo.pck_id.intValue() >= 0) {
                                str = "" + this.f48213e.mEmotionInfo.memeInfo.pck_id;
                            }
                            aVar.f12569b = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                        }
                        this.f48213e.mSaveBdImage = null;
                        this.f48213e.mSaveImageUrl = null;
                        return;
                    case 2:
                        if (this.f48213e.mSaveBdImage == null || TextUtils.isEmpty(this.f48213e.mSaveImageUrl)) {
                            return;
                        }
                        if (this.f48213e.mPermissionJudgement == null) {
                            this.f48213e.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        this.f48213e.mPermissionJudgement.clearRequestPermissionList();
                        this.f48213e.mPermissionJudgement.appendRequestPermission(this.f48213e.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.f48213e.mPermissionJudgement.startRequestPermission(this.f48213e.getPageContext().getPageActivity())) {
                            return;
                        }
                        if (this.f48213e.mSaveImageHelper == null) {
                            FoldCommentActivity foldCommentActivity = this.f48213e;
                            foldCommentActivity.mSaveImageHelper = new x0(foldCommentActivity.getPageContext());
                        }
                        this.f48213e.mSaveImageHelper.b(this.f48213e.mSaveImageUrl, this.f48213e.mSaveBdImage.n());
                        this.f48213e.mSaveBdImage = null;
                        this.f48213e.mSaveImageUrl = null;
                        return;
                    case 3:
                        PostData postData = this.f48213e.postData;
                        if (postData != null) {
                            postData.m0();
                            this.f48213e.postData = null;
                            return;
                        }
                        return;
                    case 4:
                        TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                        if (this.f48213e.checkUpIsLogin()) {
                            this.f48213e.markFloor(view);
                            if (this.f48213e.mModel.R0().O() == null || this.f48213e.mModel.R0().O().J() == null || this.f48213e.mModel.R0().O().J().getUserId() == null || this.f48213e.mMarkModel == null) {
                                return;
                            }
                            FoldCommentActivity foldCommentActivity2 = this.f48213e;
                            int threadType = foldCommentActivity2.getThreadType(foldCommentActivity2.mModel.R0());
                            d2 O = this.f48213e.mModel.R0().O();
                            if (O.P1()) {
                                i3 = 2;
                            } else if (O.S1()) {
                                i3 = 3;
                            } else if (!O.Q1()) {
                                i3 = O.R1() ? 5 : 1;
                            }
                            TiebaStatic.log(new StatisticItem("c12526").param("tid", this.f48213e.mModel.h1()).param("obj_locate", 2).param("obj_id", this.f48213e.mModel.R0().O().J().getUserId()).param("obj_type", !this.f48213e.mMarkModel.e()).param("obj_source", threadType).param("obj_param1", i3));
                            return;
                        }
                        return;
                    case 5:
                        if (!c.a.d.f.p.l.z()) {
                            this.f48213e.showToast(c.a.t0.s2.l.network_not_available);
                            return;
                        }
                        Object tag = view.getTag();
                        if (tag instanceof String) {
                            TiebaStatic.log(new StatisticItem("c13079"));
                            this.f48213e.handleReportClicked((String) tag);
                            return;
                        } else if (tag instanceof SparseArray) {
                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                            SparseArray<Object> sparseArray2 = (SparseArray) tag;
                            if ((sparseArray2.get(c.a.t0.s2.i.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(c.a.t0.s2.i.tag_user_mute_visible)).booleanValue()) {
                                sparseArray2.put(c.a.t0.s2.i.tag_from, 0);
                                sparseArray2.put(c.a.t0.s2.i.tag_check_mute_from, 2);
                                this.f48213e.checkMuteState(sparseArray2);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    case 6:
                        SparseArray sparseArray3 = (SparseArray) view.getTag();
                        if (sparseArray3 != null && (sparseArray3.get(c.a.t0.s2.i.tag_del_post_type) instanceof Integer) && (sparseArray3.get(c.a.t0.s2.i.tag_del_post_id) instanceof String) && (sparseArray3.get(c.a.t0.s2.i.tag_manage_user_identity) instanceof Integer) && (sparseArray3.get(c.a.t0.s2.i.tag_del_post_is_self) instanceof Boolean) && (sparseArray3.get(c.a.t0.s2.i.tag_has_sub_post) instanceof Boolean)) {
                            boolean booleanValue = ((Boolean) sparseArray3.get(c.a.t0.s2.i.tag_del_post_is_self)).booleanValue();
                            int intValue = ((Integer) sparseArray3.get(c.a.t0.s2.i.tag_manage_user_identity)).intValue();
                            boolean booleanValue2 = ((Boolean) sparseArray3.get(c.a.t0.s2.i.tag_has_sub_post)).booleanValue();
                            boolean isHost = this.f48213e.isHost(TbadkCoreApplication.getCurrentAccount());
                            if (isHost) {
                                if (!booleanValue2) {
                                    this.f48213e.showDelNoSubPostDialog(sparseArray3, intValue, booleanValue);
                                    return;
                                } else {
                                    this.f48213e.mView.N(((Integer) sparseArray3.get(c.a.t0.s2.i.tag_del_post_type)).intValue(), (String) sparseArray3.get(c.a.t0.s2.i.tag_del_post_id), intValue, booleanValue, null, isHost);
                                    return;
                                }
                            } else if (booleanValue && !booleanValue2) {
                                this.f48213e.showDelNoSubPostDialog(sparseArray3, intValue, booleanValue);
                                return;
                            } else {
                                this.f48213e.mView.L(((Integer) sparseArray3.get(c.a.t0.s2.i.tag_del_post_type)).intValue(), (String) sparseArray3.get(c.a.t0.s2.i.tag_del_post_id), intValue, booleanValue);
                                return;
                            }
                        }
                        return;
                    case 7:
                        if (!c.a.d.f.p.l.z()) {
                            this.f48213e.showToast(c.a.t0.s2.l.network_not_available);
                            return;
                        }
                        SparseArray<Object> sparseArray4 = (SparseArray) view.getTag();
                        if (sparseArray4 == null) {
                            return;
                        }
                        boolean booleanValue3 = ((Boolean) sparseArray4.get(c.a.t0.s2.i.tag_should_manage_visible)).booleanValue();
                        boolean booleanValue4 = ((Boolean) sparseArray4.get(c.a.t0.s2.i.tag_should_delete_visible)).booleanValue();
                        boolean booleanValue5 = ((Boolean) sparseArray4.get(c.a.t0.s2.i.tag_user_mute_visible)).booleanValue();
                        if (!booleanValue3) {
                            if (booleanValue4) {
                                this.f48213e.mView.L(((Integer) sparseArray4.get(c.a.t0.s2.i.tag_del_post_type)).intValue(), (String) sparseArray4.get(c.a.t0.s2.i.tag_del_post_id), ((Integer) sparseArray4.get(c.a.t0.s2.i.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(c.a.t0.s2.i.tag_del_post_is_self)).booleanValue());
                                return;
                            }
                            return;
                        } else if (booleanValue5) {
                            sparseArray4.put(c.a.t0.s2.i.tag_from, 1);
                            sparseArray4.put(c.a.t0.s2.i.tag_check_mute_from, 2);
                            this.f48213e.checkMuteState(sparseArray4);
                            return;
                        } else {
                            sparseArray4.put(c.a.t0.s2.i.tag_check_mute_from, 2);
                            this.f48213e.mView.P(view);
                            return;
                        }
                    case 8:
                        if (this.f48213e.checkUpIsLogin() && (sparseArray = (SparseArray) view.getTag()) != null) {
                            PostData postData2 = (PostData) sparseArray.get(c.a.t0.s2.i.tag_clip_board);
                            if (postData2.q() == null) {
                                return;
                            }
                            this.f48213e.clickOnDisagree(postData2.q());
                            return;
                        }
                        return;
                    case 9:
                        if (!this.f48213e.checkUpIsLogin() || this.f48213e.mModel == null || this.f48213e.mModel.R0() == null) {
                            return;
                        }
                        this.f48213e.showBlockDialog(c.a.t0.g4.a.b(view));
                        return;
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class x implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SparseArray f48214e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f48215f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f48216g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ FoldCommentActivity f48217h;

        public x(FoldCommentActivity foldCommentActivity, SparseArray sparseArray, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity, sparseArray, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48217h = foldCommentActivity;
            this.f48214e = sparseArray;
            this.f48215f = i2;
            this.f48216g = z;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (aVar != null) {
                    aVar.dismiss();
                }
                this.f48217h.deleteThreadDirect(((Integer) this.f48214e.get(c.a.t0.s2.i.tag_del_post_type)).intValue(), (String) this.f48214e.get(c.a.t0.s2.i.tag_del_post_id), this.f48215f, this.f48216g);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class y implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FoldCommentActivity f48218e;

        public y(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48218e = foldCommentActivity;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
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
        this.mTbGestureDetector = new c.a.t0.s2.s.c(new u(this));
        this.mOnLongClickListener = new v(this);
        this.postData = null;
        this.onLongClickItemClickListener = new w(this);
        this.mForumManageCallBack = new a(this);
        this.mPrePostCallBack = new e(this);
        this.mDraftLoadListener = new f(this, 2004008);
        this.mOnFloorPostWriteNewCallback = new g(this);
        this.showTrisectionAndFeedback = c.a.s0.b.d.x0();
        this.mCommonOnClickListener = new j(this);
        this.mCheckSubFloorCallBack = new n(this);
        this.mMarkDoneCallBack = new p(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addCollectionStat() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65583, this) == null) || (pbModel = this.mModel) == null || pbModel.R0() == null || this.mModel.R0().O() == null) {
            return;
        }
        d2 O = this.mModel.R0().O();
        O.b1 = this.mModel.W0();
        O.a1 = this.mModel.Z0();
        O.Z0 = this.mModel.Y0();
        O.c1 = this.mModel.X0();
        O.K2 = this.mModel.F0();
        if (O.U() == 0) {
            O.I3(c.a.d.f.m.b.g(this.mModel.getForumId(), 0L));
        }
        StatisticItem i2 = c.a.s0.p0.c.i(this, O, "c13562");
        TbPageTag l2 = c.a.s0.p0.c.l(this);
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

    private void addTopAgreeData(c.a.t0.s2.r.f fVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65584, this, fVar, arrayList) == null) || fVar == null || fVar.T() == null || fVar.T().a == null || (list = fVar.T().a) == null || arrayList == null) {
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
                    if (postData != null && !TextUtils.isEmpty(next.G()) && !TextUtils.isEmpty(postData.G()) && next.G().equals(postData.G())) {
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
            if (pbModel == null || pbModel.R0() == null) {
                return false;
            }
            return AntiHelper.b(getPageContext(), this.mModel.R0().O()) || AntiHelper.d(getPageContext(), this.mModel.R0().d());
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void clickOnDisagree(AgreeData agreeData) {
        c.a.s0.o0.c k2;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65586, this, agreeData) == null) || agreeData == null) {
            return;
        }
        if (this.mMessageHelper == null) {
            this.mMessageHelper = new c.a.s0.s.e0.a();
        }
        if (this.mMsgData == null) {
            c.a.t0.w3.j0.e eVar = new c.a.t0.w3.j0.e();
            this.mMsgData = eVar;
            eVar.a = getUniqueId();
        }
        c.a.s0.s.q.f fVar = new c.a.s0.s.q.f();
        fVar.f13685b = 5;
        fVar.f13691h = 8;
        fVar.f13690g = 2;
        PbModel pbModel2 = this.mModel;
        if (pbModel2 != null) {
            fVar.f13689f = pbModel2.Q0();
        }
        fVar.a = 2;
        int i2 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                fVar.f13692i = 0;
                k2 = TbPageExtraHelper.k(this);
                if (k2 != null) {
                    agreeData.objSource = k2.a();
                }
                this.mMessageHelper.c(agreeData, i2, getUniqueId(), false);
                this.mMessageHelper.d(agreeData, this.mMsgData);
                pbModel = this.mModel;
                if (pbModel != null || pbModel.R0() == null) {
                }
                this.mMessageHelper.b(this, fVar, agreeData, this.mModel.R0().O());
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            fVar.f13692i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            fVar.f13692i = 1;
        }
        i2 = 0;
        k2 = TbPageExtraHelper.k(this);
        if (k2 != null) {
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
            if (this.mModel.x0() || this.mModel.A0()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", this.mModel.h1());
                setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.mModel.h1()));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dealLongClickListener(View view) {
        InterceptResult invokeL;
        SparseArray sparseArray;
        c.a.s0.i.a aVar;
        boolean z;
        List<c.a.s0.s.s.g> b2;
        c.a.s0.s.s.g gVar;
        c.a.s0.s.s.g gVar2;
        c.a.s0.s.s.g gVar3;
        c.a.d.n.d.a aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65588, this, view)) == null) {
            try {
                sparseArray = (SparseArray) view.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null) {
                return true;
            }
            PostData postData = (PostData) sparseArray.get(c.a.t0.s2.i.tag_clip_board);
            this.postData = postData;
            if (postData == null || (aVar = this.mMarkModel) == null) {
                return true;
            }
            if (aVar.e() && this.postData.G() != null) {
                this.postData.G().equals(this.mModel.M0());
            }
            if (this.mPopupDialogView == null) {
                c.a.s0.s.s.j jVar = new c.a.s0.s.s.j(this);
                this.mPopupDialogView = jVar;
                jVar.m(this.onLongClickItemClickListener);
            }
            ArrayList arrayList = new ArrayList();
            if (view == null || sparseArray == null) {
                return true;
            }
            boolean isImage = isImage(view);
            boolean z2 = (!isImage(view) || (aVar2 = this.mSaveBdImage) == null || aVar2.t()) ? false : true;
            boolean booleanValue = sparseArray.get(c.a.t0.s2.i.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray.get(c.a.t0.s2.i.tag_is_subpb)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(c.a.t0.s2.i.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(c.a.t0.s2.i.tag_del_post_is_self)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(c.a.t0.s2.i.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(c.a.t0.s2.i.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue4 = sparseArray.get(c.a.t0.s2.i.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(c.a.t0.s2.i.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue5 = sparseArray.get(c.a.t0.s2.i.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(c.a.t0.s2.i.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue6 = sparseArray.get(c.a.t0.s2.i.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(c.a.t0.s2.i.tag_should_delete_visible)).booleanValue() : false;
            String str = sparseArray.get(c.a.t0.s2.i.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(c.a.t0.s2.i.tag_forbid_user_post_id) : null;
            boolean booleanValue7 = sparseArray.get(c.a.t0.s2.i.tag_is_self_post) instanceof Boolean ? ((Boolean) sparseArray.get(c.a.t0.s2.i.tag_is_self_post)).booleanValue() : false;
            if (isImage) {
                z = booleanValue;
                arrayList.add(new c.a.s0.s.s.g(1, getString(c.a.t0.s2.l.save_to_emotion), this.mPopupDialogView));
            } else {
                z = booleanValue;
            }
            if (z2) {
                arrayList.add(new c.a.s0.s.s.g(2, getString(c.a.t0.s2.l.save_to_local), this.mPopupDialogView));
            }
            if (!isImage && !z2) {
                c.a.s0.s.s.g gVar4 = new c.a.s0.s.s.g(3, getString(c.a.t0.s2.l.copy), this.mPopupDialogView);
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(c.a.t0.s2.i.tag_clip_board, this.postData);
                gVar4.f13917d.setTag(sparseArray2);
                arrayList.add(gVar4);
            }
            if (this.mIsLogin) {
                if (!c.a.t0.s2.u.f.g1.a.h(this.mModel) && !booleanValue4 && booleanValue3) {
                    c.a.s0.s.s.g gVar5 = new c.a.s0.s.s.g(5, getString(c.a.t0.s2.l.mute_option), this.mPopupDialogView);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(c.a.t0.s2.i.tag_user_mute_visible, Boolean.TRUE);
                    int i2 = c.a.t0.s2.i.tag_is_mem;
                    sparseArray3.put(i2, sparseArray.get(i2));
                    int i3 = c.a.t0.s2.i.tag_user_mute_mute_userid;
                    sparseArray3.put(i3, sparseArray.get(i3));
                    int i4 = c.a.t0.s2.i.tag_user_mute_mute_username;
                    sparseArray3.put(i4, sparseArray.get(i4));
                    int i5 = c.a.t0.s2.i.tag_user_mute_mute_nameshow;
                    sparseArray3.put(i5, sparseArray.get(i5));
                    int i6 = c.a.t0.s2.i.tag_user_mute_post_id;
                    sparseArray3.put(i6, sparseArray.get(i6));
                    int i7 = c.a.t0.s2.i.tag_user_mute_thread_id;
                    sparseArray3.put(i7, sparseArray.get(i7));
                    int i8 = c.a.t0.s2.i.tag_del_post_is_self;
                    sparseArray3.put(i8, sparseArray.get(i8));
                    int i9 = c.a.t0.s2.i.tag_del_post_type;
                    sparseArray3.put(i9, sparseArray.get(i9));
                    int i10 = c.a.t0.s2.i.tag_del_post_id;
                    sparseArray3.put(i10, sparseArray.get(i10));
                    int i11 = c.a.t0.s2.i.tag_manage_user_identity;
                    sparseArray3.put(i11, sparseArray.get(i11));
                    gVar5.f13917d.setTag(sparseArray3);
                    arrayList.add(gVar5);
                } else {
                    if (isShowReportButton(booleanValue2) && TbadkCoreApplication.isLogin()) {
                        c.a.s0.s.s.g gVar6 = new c.a.s0.s.s.g(5, getString(c.a.t0.s2.l.report_text), this.mPopupDialogView);
                        gVar6.f13917d.setTag(str);
                        arrayList.add(gVar6);
                    }
                }
                if (booleanValue4) {
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(c.a.t0.s2.i.tag_should_manage_visible, Boolean.TRUE);
                    int i12 = c.a.t0.s2.i.tag_manage_user_identity;
                    sparseArray4.put(i12, sparseArray.get(i12));
                    int i13 = c.a.t0.s2.i.tag_forbid_user_name;
                    sparseArray4.put(i13, sparseArray.get(i13));
                    int i14 = c.a.t0.s2.i.tag_forbid_user_name_show;
                    sparseArray4.put(i14, sparseArray.get(i14));
                    int i15 = c.a.t0.s2.i.tag_forbid_user_portrait;
                    sparseArray4.put(i15, sparseArray.get(i15));
                    sparseArray4.put(c.a.t0.s2.i.tag_forbid_user_post_id, str);
                    if (!c.a.t0.s2.u.f.g1.a.h(this.mModel) && booleanValue5) {
                        sparseArray4.put(c.a.t0.s2.i.tag_user_mute_visible, Boolean.TRUE);
                        int i16 = c.a.t0.s2.i.tag_is_mem;
                        sparseArray4.put(i16, sparseArray.get(i16));
                        int i17 = c.a.t0.s2.i.tag_user_mute_mute_userid;
                        sparseArray4.put(i17, sparseArray.get(i17));
                        int i18 = c.a.t0.s2.i.tag_user_mute_mute_username;
                        sparseArray4.put(i18, sparseArray.get(i18));
                        int i19 = c.a.t0.s2.i.tag_user_mute_mute_nameshow;
                        sparseArray4.put(i19, sparseArray.get(i19));
                        int i20 = c.a.t0.s2.i.tag_user_mute_post_id;
                        sparseArray4.put(i20, sparseArray.get(i20));
                        int i21 = c.a.t0.s2.i.tag_user_mute_thread_id;
                        sparseArray4.put(i21, sparseArray.get(i21));
                    } else {
                        sparseArray4.put(c.a.t0.s2.i.tag_user_mute_visible, Boolean.FALSE);
                    }
                    if (booleanValue6) {
                        sparseArray4.put(c.a.t0.s2.i.tag_should_delete_visible, Boolean.TRUE);
                        sparseArray4.put(c.a.t0.s2.i.tag_del_post_is_self, Boolean.valueOf(booleanValue2));
                        int i22 = c.a.t0.s2.i.tag_del_post_id;
                        sparseArray4.put(i22, sparseArray.get(i22));
                        int i23 = c.a.t0.s2.i.tag_del_post_type;
                        sparseArray4.put(i23, sparseArray.get(i23));
                        int i24 = c.a.t0.s2.i.tag_has_sub_post;
                        sparseArray4.put(i24, sparseArray.get(i24));
                        if (booleanValue7) {
                            c.a.s0.s.s.g gVar7 = new c.a.s0.s.s.g(6, getString(c.a.t0.s2.l.delete), this.mPopupDialogView);
                            gVar7.f13917d.setTag(sparseArray4);
                            gVar3 = gVar7;
                            gVar = new c.a.s0.s.s.g(7, getString(c.a.t0.s2.l.bar_manager), this.mPopupDialogView);
                            gVar.f13917d.setTag(sparseArray4);
                            gVar2 = gVar3;
                        }
                    } else {
                        sparseArray4.put(c.a.t0.s2.i.tag_should_delete_visible, Boolean.FALSE);
                    }
                    gVar3 = null;
                    gVar = new c.a.s0.s.s.g(7, getString(c.a.t0.s2.l.bar_manager), this.mPopupDialogView);
                    gVar.f13917d.setTag(sparseArray4);
                    gVar2 = gVar3;
                } else if (booleanValue6) {
                    SparseArray sparseArray5 = new SparseArray();
                    sparseArray5.put(c.a.t0.s2.i.tag_should_manage_visible, Boolean.FALSE);
                    sparseArray5.put(c.a.t0.s2.i.tag_user_mute_visible, Boolean.FALSE);
                    sparseArray5.put(c.a.t0.s2.i.tag_should_delete_visible, Boolean.TRUE);
                    int i25 = c.a.t0.s2.i.tag_manage_user_identity;
                    sparseArray5.put(i25, sparseArray.get(i25));
                    sparseArray5.put(c.a.t0.s2.i.tag_del_post_is_self, Boolean.valueOf(booleanValue2));
                    int i26 = c.a.t0.s2.i.tag_del_post_id;
                    sparseArray5.put(i26, sparseArray.get(i26));
                    int i27 = c.a.t0.s2.i.tag_del_post_type;
                    sparseArray5.put(i27, sparseArray.get(i27));
                    int i28 = c.a.t0.s2.i.tag_has_sub_post;
                    sparseArray5.put(i28, sparseArray.get(i28));
                    if (this.mModel.R0().V() == 1002 && !booleanValue2) {
                        gVar2 = new c.a.s0.s.s.g(6, getString(c.a.t0.s2.l.report_text), this.mPopupDialogView);
                    } else {
                        gVar2 = new c.a.s0.s.s.g(6, getString(c.a.t0.s2.l.delete), this.mPopupDialogView);
                    }
                    gVar2.f13917d.setTag(sparseArray5);
                    gVar = null;
                } else {
                    gVar = null;
                    gVar2 = null;
                }
                if (gVar2 != null) {
                    arrayList.add(gVar2);
                }
                if (gVar != null) {
                    arrayList.add(gVar);
                }
                c.a.t0.s2.u.f.g1.a.a(arrayList, this.mPopupDialogView, this.postData, this.mModel);
            }
            if (c.a.s0.b.d.N()) {
                b2 = c.a.t0.s2.u.f.g1.a.c(arrayList, this.postData.q(), sparseArray, this.mPopupDialogView);
            } else {
                b2 = c.a.t0.s2.u.f.g1.a.b(arrayList, this.postData.q(), sparseArray, this.mPopupDialogView);
            }
            c.a.t0.s2.u.f.g1.a.k(b2, this.isDialogFromLongClick);
            c.a.t0.s2.u.f.g1.a.e(b2);
            this.mPopupDialogView.n(c.a.t0.s2.u.f.g1.a.f(this.postData));
            if (c.a.s0.b.d.N()) {
                this.mPopupDialogView.k(b2, false);
            } else {
                this.mPopupDialogView.k(b2, true);
            }
            PopupDialog popupDialog = new PopupDialog(getPageContext(), this.mPopupDialogView);
            this.mLongClickDialog = popupDialog;
            popupDialog.showDialog();
            TiebaStatic.log(new StatisticItem("c13272").param("tid", this.mModel.h1()).param("fid", this.mModel.getForumId()).param("uid", this.mModel.R0().O().J().getUserId()).param("post_id", this.mModel.y()).param("obj_source", z ? 2 : 1));
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
        String string = !TextUtils.isEmpty(bVar.f50066b) ? bVar.f50066b : getString(c.a.t0.s2.l.delete_fail);
        int i2 = 0;
        if (bVar.f50067c == 1211066) {
            hideProgressBar();
            c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(getPageContext().getPageActivity());
            aVar.setMessage(string);
            aVar.setPositiveButton(c.a.t0.s2.l.dialog_known, new b(this));
            aVar.setCancelable(true);
            aVar.create(getPageContext());
            aVar.show();
        } else if (bVar.f50068d != 0) {
            this.mView.v(0, bVar.a, bVar.f50066b, z);
        }
        if (bVar.a) {
            int i3 = bVar.f50068d;
            if (i3 == 1) {
                ArrayList<PostData> F = this.mModel.R0().F();
                int size = F.size();
                while (true) {
                    if (i2 >= size) {
                        break;
                    } else if (bVar.f50071g.equals(F.get(i2).G())) {
                        F.remove(i2);
                        break;
                    } else {
                        i2++;
                    }
                }
                this.mModel.R0().O().r4(this.mModel.R0().O().V0() - 1);
            } else if (i3 == 0) {
                closeActivityAfterDelPost();
            } else if (i3 == 2) {
                ArrayList<PostData> F2 = this.mModel.R0().F();
                int size2 = F2.size();
                boolean z2 = false;
                for (int i4 = 0; i4 < size2 && !z2; i4++) {
                    int i5 = 0;
                    while (true) {
                        if (i5 >= F2.get(i4).P().size()) {
                            break;
                        } else if (bVar.f50071g.equals(F2.get(i4).P().get(i5).G())) {
                            F2.get(i4).P().remove(i5);
                            F2.get(i4).l();
                            z2 = true;
                            break;
                        } else {
                            i5++;
                        }
                    }
                    F2.get(i4).n(bVar.f50071g);
                }
            }
        }
    }

    private TbRichText getImage(ArrayList<PostData> arrayList, String str, int i2) {
        InterceptResult invokeLLI;
        ArrayList<TbRichTextData> y2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65590, this, arrayList, str, i2)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    TbRichText N = arrayList.get(i3).N();
                    if (N != null && (y2 = N.y()) != null) {
                        int size = y2.size();
                        int i4 = -1;
                        for (int i5 = 0; i5 < size; i5++) {
                            if (y2.get(i5) != null && y2.get(i5).getType() == 8) {
                                i4++;
                                if (y2.get(i5).C().y().equals(str) || y2.get(i5).C().z().equals(str)) {
                                    int h2 = (int) c.a.d.f.p.n.h(TbadkCoreApplication.getInst());
                                    int width = y2.get(i5).C().getWidth() * h2;
                                    int height = y2.get(i5).C().getHeight() * h2;
                                    if (width < 80 || height < 80 || width * height < 10000) {
                                        return null;
                                    }
                                    this.imgIndex = i5;
                                    return N;
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
        TbRichTextImageInfo C;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65591, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i2), Integer.valueOf(i3), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.index_valid = true;
            }
            if (tbRichText != null) {
                int size = tbRichText.y().size();
                int i4 = i2;
                int i5 = -1;
                for (int i6 = 0; i6 < size; i6++) {
                    TbRichTextData tbRichTextData = tbRichText.y().get(i6);
                    if ((tbRichTextData == null || tbRichTextData.getType() != 20) && tbRichTextData != null && tbRichTextData.getType() == 8) {
                        i5++;
                        int h2 = (int) c.a.d.f.p.n.h(TbadkCoreApplication.getInst());
                        int width = tbRichTextData.C().getWidth() * h2;
                        int height = tbRichTextData.C().getHeight() * h2;
                        if ((width < 80 || height < 80 || width * height < 10000) || !tbRichTextData.C().D()) {
                            if (tbRichText == tbRichText2) {
                                if (i5 <= i3) {
                                    i4--;
                                }
                            }
                        } else if (tbRichTextData.getType() != 20) {
                            String a2 = c.a.t0.s2.r.g.a(tbRichTextData);
                            if (!TextUtils.isEmpty(a2)) {
                                arrayList.add(a2);
                                if (tbRichTextData != null && (C = tbRichTextData.C()) != null) {
                                    String y2 = C.y();
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                        imageUrlData.urlType = 38;
                                        y2 = C.z();
                                    } else {
                                        imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    }
                                    imageUrlData.imageUrl = y2;
                                    imageUrlData.originalUrl = getOriginalPic(tbRichTextData);
                                    imageUrlData.originalSize = getOriginalSize(tbRichTextData);
                                    imageUrlData.mIsShowOrigonButton = getIsShowOriginalButton(tbRichTextData);
                                    imageUrlData.isLongPic = getIsLongImg(tbRichTextData);
                                    imageUrlData.postId = tbRichText.getPostId();
                                    imageUrlData.threadId = c.a.d.f.m.b.g(this.mModel.h1(), -1L);
                                    imageUrlData.mIsReserver = this.mModel.c1();
                                    imageUrlData.mIsSeeHost = this.mModel.v0();
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
            if (tbRichTextData == null || tbRichTextData.C() == null) {
                return false;
            }
            return tbRichTextData.C().E();
        }
        return invokeL.booleanValue;
    }

    private boolean getIsShowOriginalButton(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65593, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.C() == null) {
                return false;
            }
            return tbRichTextData.C().F();
        }
        return invokeL.booleanValue;
    }

    private String getOriginalPic(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65594, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.C() == null) {
                return null;
            }
            return tbRichTextData.C().A();
        }
        return (String) invokeL.objValue;
    }

    private long getOriginalSize(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65595, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.C() == null) {
                return 0L;
            }
            return tbRichTextData.C().getOriginalSize();
        }
        return invokeL.longValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getThreadType(c.a.t0.s2.r.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65596, this, fVar)) == null) {
            if (fVar == null || fVar.O() == null) {
                return 0;
            }
            if (fVar.O().r1() == 0) {
                return 1;
            }
            if (fVar.O().r1() == 54) {
                return 2;
            }
            return fVar.O().r1() == 40 ? 3 : 4;
        }
        return invokeL.intValue;
    }

    private void handleFullScreenEditorResult(int i2, Intent intent) {
        c.a.s0.x.n nVar;
        c.a.s0.x.n nVar2;
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
                    c.a.s0.x.y.h b2 = this.mView.y().b();
                    b2.b0(this.mModel.R0().O());
                    b2.B(writeData);
                    b2.c0(pbEditorData.getVoiceModel());
                    c.a.s0.x.m findToolById = b2.a().findToolById(6);
                    if (findToolById != null && (nVar2 = findToolById.f14538k) != null) {
                        nVar2.onAction(new c.a.s0.x.a(52, 0, pbEditorData.getVoiceModel()));
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
                c.a.s0.x.m findToolById2 = this.mPbEditor.a().findToolById(6);
                if (findToolById2 != null && (nVar = findToolById2.f14538k) != null) {
                    nVar.onAction(new c.a.s0.x.a(52, 0, pbEditorData.getVoiceModel()));
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
            if (pbModel != null && pbModel.R0() != null && this.mModel.R0().g0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.mModel.h1(), str);
                d2 O = this.mModel.R0().O();
                if (O.P1()) {
                    format = format + "&channelid=33833";
                } else if (O.U1()) {
                    format = format + "&channelid=33842";
                } else if (O.S1()) {
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
            c.a.s0.i.a c2 = c.a.s0.i.a.c(this);
            this.mMarkModel = c2;
            if (c2 != null) {
                c2.j(this.mMarkDoneCallBack);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this);
            this.mForumManageModel = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.mForumManageCallBack);
            PbModel pbModel = new PbModel(this);
            this.mModel = pbModel;
            pbModel.t2(true);
            if (bundle != null) {
                this.mModel.initWithBundle(bundle);
            } else {
                this.mModel.initWithIntent(getIntent());
            }
            this.mModel.u2(4);
            this.mModel.o2(this.mLoadPbCallback);
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
            this.mPbEventController = new c.a.t0.s2.u.f.d1.a(this);
            this.mPbPostShareController = new c.a.t0.s2.u.f.d1.c(getPageContext());
            c.a.t0.s2.u.d.c cVar = new c.a.t0.s2.u.d.c(this, this.mCommonOnClickListener, this.mOnImageClickListener, this.mTbGestureDetector, this.mOnLongClickListener);
            this.mView = cVar;
            cVar.Y(this.mModel);
            setContentView(this.mView.A(), new FlowLayout.LayoutParams(-1, -1));
            adjustResizeForSoftInput();
            addGlobalLayoutListener();
            this.mView.s();
            this.mView.V(new t(this));
            c.a.s0.x.y.g gVar = new c.a.s0.x.y.g();
            this.mPbeb = gVar;
            setPbNormalEditorBuilder(gVar);
            c.a.s0.x.y.e eVar = (c.a.s0.x.y.e) this.mPbeb.a(getActivity());
            this.mPbEditor = eVar;
            eVar.e0(getPageContext());
            this.mPbEditor.o0(this.mPrePostCallBack);
            this.mPbEditor.g0(1);
            this.mPbEditor.F(getPageContext(), bundle);
            this.mPbEditor.a().addHideLauncher(new c.a.s0.x.k(getActivity()));
            this.mPbEditor.a().showLinePositionBottom(true);
            setShowPicBlauncherOutSetVisibilty(true);
            this.mPbEditor.O(this.mModel.u0(), this.mModel.h1(), this.mModel.q0());
            this.mView.T(this.mPbEditor.a());
            this.mContentProcessController = new v0();
            if (this.mPbEditor.v() != null) {
                this.mContentProcessController.m(this.mPbEditor.v().h());
            }
            registerListener(this.mDraftLoadListener);
            if (!this.mModel.F0()) {
                this.mPbEditor.s(this.mModel.h1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.mPbEditor.k0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.mModel.t1()) {
                this.mPbEditor.k0(getPageContext().getString(c.a.t0.s2.l.pb_reply_hint_from_smart_frs));
            } else {
                c.a.t0.s2.u.d.c cVar2 = this.mView;
                if (cVar2 != null) {
                    this.mPbEditor.k0(cVar2.z());
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
            return pbModel != null && pbModel.Q0() == 17;
        }
        return invokeV.booleanValue;
    }

    private boolean isShowReportButton(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65603, this, z)) == null) {
            PbModel pbModel = this.mModel;
            if (pbModel != null && pbModel.R0() != null) {
                return ((this.mModel.R0().V() != 0) || this.mModel.R0().O() == null || this.mModel.R0().O().J() == null || TextUtils.equals(this.mModel.R0().O().J().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
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
        pbModel.L1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void locateSubPbEditor(View view, String str, String str2, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65606, this, view, str, str2, postData) == null) || view == null || str == null || str2 == null || !checkPrivacyBeforeInput()) {
            return;
        }
        if (view.getParent() instanceof View) {
            ((View) view.getParent()).getLocationOnScreen(this.mReplyFloorLocation);
            this.mReplyFloorMeasureHeight = ((View) view.getParent()).getMeasuredHeight();
        }
        if (this.mView.y() != null && postData != null) {
            this.mView.y().j(String.format(TbadkCoreApplication.getInst().getResources().getString(c.a.t0.s2.l.reply_title), postData.t().getName_show(), postData.N() != null ? postData.N().toString() : ""));
        }
        if (this.mModel.R0() != null && this.mModel.R0().g0()) {
            c.a.d.f.m.e.a().postDelayed(new l(this, str, str2), 0L);
            return;
        }
        if (this.mSubReplyPermissionController == null) {
            c.a.t0.d1.r2.a.c cVar = new c.a.t0.d1.r2.a.c(getPageContext());
            this.mSubReplyPermissionController = cVar;
            cVar.j(1);
            this.mSubReplyPermissionController.i(new m(this, str, str2));
        }
        PbModel pbModel = this.mModel;
        if (pbModel == null || pbModel.R0() == null || this.mModel.R0().l() == null) {
            return;
        }
        this.mSubReplyPermissionController.g(this.mModel.R0().l().getId(), c.a.d.f.m.b.g(this.mModel.h1(), 0L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void makeFakeMark() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65607, this) == null) {
            c.a.t0.s2.r.f R0 = this.mModel.R0();
            this.mModel.x2(true);
            c.a.s0.i.a aVar = this.mMarkModel;
            if (aVar != null) {
                R0.E0(aVar.g());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void markFloor(View view) {
        SparseArray sparseArray;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65608, this, view) == null) {
            try {
                sparseArray = (SparseArray) view.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (postData = (PostData) sparseArray.get(c.a.t0.s2.i.tag_clip_board)) == null) {
                return;
            }
            markFloor(postData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onNetOrDataError(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65609, this, i2, str) == null) {
            if (this.mModel.o1()) {
                showToast(str);
            } else if (!c.a.d.f.p.n.C()) {
                this.mView.f0(c.a.t0.s2.l.recommend_pb_no_net_text);
            } else if (i2 == 4) {
                c.a.t0.s2.u.d.c cVar = this.mView;
                cVar.g0(str + "(4" + SmallTailInfo.EMOTION_SUFFIX, true);
            } else if (!TextUtils.isEmpty(str)) {
                c.a.t0.s2.u.d.c cVar2 = this.mView;
                cVar2.g0(str + "(" + i2 + SmallTailInfo.EMOTION_SUFFIX, true);
            } else {
                this.mView.f0(c.a.t0.s2.l.no_data_text);
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
        c.a.t0.s2.r.f R0 = this.mModel.R0();
        TbRichText validImage = validImage(str, i2);
        if (validImage == null || (tbRichTextData = validImage.y().get(this.imgIndex)) == null) {
            return;
        }
        eVar.f48233f = String.valueOf(validImage.getPostId());
        eVar.a = new ArrayList<>();
        eVar.f48229b = new ConcurrentHashMap<>();
        if (!tbRichTextData.C().D()) {
            eVar.f48235h = false;
            String a2 = c.a.t0.s2.r.g.a(tbRichTextData);
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
            imageUrlData.mIsReserver = this.mModel.c1();
            imageUrlData.mIsSeeHost = this.mModel.v0();
            eVar.f48229b.put(a2, imageUrlData);
            if (R0 != null) {
                if (R0.l() != null) {
                    eVar.f48230c = R0.l().getName();
                    eVar.f48231d = R0.l().getId();
                }
                if (R0.O() != null) {
                    eVar.f48232e = R0.O().g0();
                }
                eVar.f48234g = R0.s() == 1;
            }
            imageUrlData.threadId = c.a.d.f.m.b.g(eVar.f48232e, -1L);
            return;
        }
        eVar.f48235h = true;
        int size = R0.F().size();
        this.index_valid = false;
        eVar.f48237j = -1;
        int imageIndex = R0.j() != null ? getImageIndex(R0.j().N(), validImage, i2, i2, eVar.a, eVar.f48229b) : i2;
        for (int i3 = 0; i3 < size; i3++) {
            PostData postData = R0.F().get(i3);
            if (postData.G() == null || R0.j() == null || R0.j().G() == null || !postData.G().equals(R0.j().G())) {
                imageIndex = getImageIndex(postData.N(), validImage, imageIndex, i2, eVar.a, eVar.f48229b);
            }
        }
        if (eVar.a.size() > 0) {
            ArrayList<String> arrayList = eVar.a;
            eVar.f48236i = arrayList.get(arrayList.size() - 1);
        }
        if (R0 != null) {
            if (R0.l() != null) {
                eVar.f48230c = R0.l().getName();
                eVar.f48231d = R0.l().getId();
            }
            if (R0.O() != null) {
                eVar.f48232e = R0.O().g0();
            }
            eVar.f48234g = R0.s() == 1;
        }
        eVar.f48237j = imageIndex;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AbsPbActivity.e processSubPbImg(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65611, this, str)) == null) {
            String str2 = null;
            if (this.mModel.R0() != null && this.mModel.R0().F() != null && this.mModel.R0().F().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i2 = 0;
                while (true) {
                    if (i2 >= this.mModel.R0().F().size()) {
                        i2 = 0;
                        break;
                    } else if (str.equals(this.mModel.R0().F().get(i2).G())) {
                        break;
                    } else {
                        i2++;
                    }
                }
                PostData postData = this.mModel.R0().F().get(i2);
                if (postData.N() != null && postData.N().y() != null) {
                    Iterator<TbRichTextData> it = postData.N().y().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        TbRichTextData next = it.next();
                        if (next != null && next.getType() == 8) {
                            if (next.C() != null) {
                                str2 = next.C().y();
                            }
                        }
                    }
                    processImgUrls(str2, 0, eVar);
                    c.a.t0.s2.r.g.b(postData, eVar);
                    return eVar;
                }
            }
            return null;
        }
        return (AbsPbActivity.e) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void putTrackTagToPerformView(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65612, this, view) == null) || view == null) {
            return;
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(c.a.t0.s2.i.pb_track_more_obj_source, Integer.valueOf(this.isDialogFromLongClick ? 2 : 3));
        view.setTag(sparseArray);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean richTextHandleSingleTap(View view) {
        InterceptResult invokeL;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65613, this, view)) == null) {
            if (view != null && (view.getTag() instanceof SparseArray)) {
                Object obj = ((SparseArray) view.getTag()).get(c.a.t0.s2.i.tag_clip_board);
                if (obj instanceof PostData) {
                    PostData postData = (PostData) obj;
                    if (checkUpIsLogin() && (pbModel = this.mModel) != null && pbModel.R0() != null) {
                        if (this.mView.y() != null) {
                            this.mView.y().c();
                        }
                        c.a.t0.s2.r.t tVar = new c.a.t0.s2.r.t();
                        tVar.A(this.mModel.R0().l());
                        tVar.E(this.mModel.R0().O());
                        tVar.C(postData);
                        TiebaStatic.log("c11743");
                        this.mView.x().S(tVar);
                        this.mView.x().setPostId(postData.G());
                        locateSubPbEditor(view, postData.t().getUserId(), "", postData);
                        c.a.s0.x.y.e eVar = this.mPbEditor;
                        if (eVar != null) {
                            this.mView.W(eVar.C());
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
            c.a.t0.s2.u.f.c1.f.a aVar = new c.a.t0.s2.u.f.c1.f.a(this);
            this.mReplyEmotionModel = aVar;
            aVar.n(this.mPrePostCallBack);
        }
        c.a.t0.s2.u.f.c1.f.a aVar2 = this.mReplyEmotionModel;
        PbModel pbModel = this.mModel;
        aVar2.k(emotionImageData, pbModel, pbModel.R0());
    }

    private void setPbNormalEditorBuilder(c.a.s0.x.y.g gVar) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65615, this, gVar) == null) || gVar == null || (pbModel = this.mModel) == null) {
            return;
        }
        gVar.p(pbModel.r0());
        if (this.mModel.R0() != null && this.mModel.R0().l() != null) {
            gVar.o(this.mModel.R0().l());
        }
        gVar.q("pb");
        gVar.r(this.mModel);
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
                    c.a.s0.t.h.b.c(getPageContext(), postWriteCallBackData, 2);
                    return;
                } else {
                    c.a.t0.w3.s0.m.b(getPageContext().getPageActivity(), errorString, preMsg, colorMsg);
                    return;
                }
            }
            return;
        }
        if (!this.mModel.F0()) {
            antiData.setBlock_forum_name(this.mModel.R0().l().getName());
            antiData.setBlock_forum_id(this.mModel.R0().l().getId());
            antiData.setUser_name(this.mModel.R0().U().getUserName());
            antiData.setUser_id(this.mModel.R0().U().getUserId());
        }
        AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDelNoSubPostDialog(SparseArray<Object> sparseArray, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65618, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            c.a.t0.s2.u.f.g1.a.d(getActivity(), getPageContext(), new x(this, sparseArray, i2, z), new y(this));
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
            c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(this);
            if (c.a.d.f.p.m.isEmpty(str)) {
                aVar.setMessage(getResources().getString(c.a.t0.s2.l.block_mute_message_alert, str3));
            } else {
                aVar.setMessage(str);
            }
            aVar.setPositiveButton(c.a.t0.s2.l.confirm, new c(this, userMuteAddAndDelCustomMessage));
            aVar.setNegativeButton(c.a.t0.s2.l.cancel, new d(this));
            aVar.create(getPageContext()).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSubPbActivity(PostData postData, boolean z) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65621, this, postData, z) == null) || postData == null || (pbModel = this.mModel) == null || pbModel.R0() == null || postData.A() == 1) {
            return;
        }
        String h1 = this.mModel.h1();
        String G = postData.G();
        int V = this.mModel.R0() != null ? this.mModel.R0().V() : 0;
        AbsPbActivity.e processSubPbImg = processSubPbImg(G);
        if (processSubPbImg == null) {
            return;
        }
        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this).createSubPbActivityConfig(h1, G, "pb", true, this.mIsFromVideoTab, null, false, null, V, postData.S(), this.mModel.R0().d(), false, postData.t() != null ? postData.t().getIconInfo() : null, 5).addBigImageData(processSubPbImg.a, processSubPbImg.f48229b, processSubPbImg.f48234g, processSubPbImg.f48237j);
        addBigImageData.setKeyPageStartFrom(this.mModel.Q0());
        addBigImageData.setFromFrsForumId(this.mModel.getFromForumId());
        addBigImageData.setWorksInfoData(this.mModel.m1());
        addBigImageData.setKeyFromForumId(this.mModel.getForumId());
        addBigImageData.setBjhData(this.mModel.k0());
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
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.mModel.h1()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(c.a.t0.s2.u.f.g1.a.m(i2))));
        }
    }

    private void tryAddexperienced() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65624, this) == null) && TbadkCoreApplication.isLogin() && AddExperiencedModel.B(this.mModel.getForumId()) && this.mModel.R0() != null && this.mModel.R0().l() != null) {
            if (this.mModel.R0().l().isLike() == 1) {
                this.mModel.f0().A(this.mModel.getForumId(), this.mModel.h1());
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
            if (pbModel == null || pbModel.R0() == null || str == null || i2 < 0) {
                return null;
            }
            c.a.t0.s2.r.f R0 = this.mModel.R0();
            if (R0.j() != null) {
                ArrayList<PostData> arrayList = new ArrayList<>();
                arrayList.add(R0.j());
                tbRichText = getImage(arrayList, str, i2);
            }
            if (tbRichText == null) {
                ArrayList<PostData> F = R0.F();
                addTopAgreeData(R0, F);
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
            userMuteCheckCustomMessage.userIdF = c.a.d.f.m.b.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = c.a.d.f.m.b.g((String) sparseArray.get(c.a.t0.s2.i.tag_user_mute_mute_userid), 0L);
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
            if ((this.mModel.R0() != null && (this.mModel.R0().g0() || ThreadCardUtils.isSelf(this.mModel.R0().O()))) || this.mReplyPrivacyController == null || this.mModel.R0() == null || this.mModel.R0().d() == null) {
                return true;
            }
            return this.mReplyPrivacyController.checkPrivacyBeforeInvokeEditor(this.mModel.R0().d().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public boolean checkPrivacyBeforePost(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (this.mReplyPrivacyController == null || this.mModel.R0() == null || ThreadCardUtils.isSelf(this.mModel.R0().O()) || this.mModel.R0().d() == null) {
                return true;
            }
            return this.mReplyPrivacyController.checkPrivacyBeforeSend(this.mModel.R0().d().replyPrivateFlag, i2);
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
        Object[] objArr = (c.a.s0.g1.n.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), c.a.s0.g1.n.f.class);
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (y0.c(objArr[i2].d()) && (drawable = SkinManager.getDrawable(c.a.t0.s2.h.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(PB_LITERATURE_LOOK_MORE_ICON_SUFFIX);
                spannableStringBuilder2.setSpan(new c.a.s0.g1.d(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i2], spannableStringBuilder.getSpanStart(objArr[i2]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    public void deleteThread(c.a.s0.s.s.a aVar, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, aVar, jSONArray) == null) {
            aVar.dismiss();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (aVar.getYesButtonTag() instanceof SparseArray) {
                    deleteThread((SparseArray) aVar.getYesButtonTag(), jSONArray);
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
            sparseArray.put(c.a.t0.s2.i.tag_del_post_id, str);
            sparseArray.put(c.a.t0.s2.i.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(c.a.t0.s2.i.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(c.a.t0.s2.i.tag_del_post_is_self, Boolean.valueOf(z));
            sparseArray.put(c.a.t0.s2.u.f.t0.X1, Integer.valueOf(c.a.t0.s2.u.f.t0.Y1));
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
                showToast(getPageContext().getString(c.a.t0.s2.l.success));
            } else if (z2) {
                if (c.a.d.f.p.m.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(c.a.t0.s2.l.neterror);
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
            if (pbModel == null || pbModel.R0() == null) {
                return null;
            }
            return this.mModel.R0().d();
        }
        return (AntiData) invokeV.objValue;
    }

    @Override // c.a.t0.s2.u.a
    public c.a.t0.s2.u.f.d1.a getEventController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mPbEventController : (c.a.t0.s2.u.f.d1.a) invokeV.objValue;
    }

    public PostData getFirstPostData() {
        InterceptResult invokeV;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            PbModel pbModel = this.mModel;
            if (pbModel == null || pbModel.R0() == null || this.mModel.R0().O() == null || this.mModel.R0().O().J() == null) {
                return null;
            }
            PostData postData = new PostData();
            MetaData J = this.mModel.R0().O().J();
            String userId = J.getUserId();
            HashMap<String, MetaData> C1 = this.mModel.R0().O().C1();
            if (C1 != null && (metaData = C1.get(userId)) != null && metaData.getUserId() != null) {
                J = metaData;
            }
            postData.n0(1);
            postData.r0(this.mModel.R0().O().X());
            postData.D0(this.mModel.R0().O().getTitle());
            postData.C0(this.mModel.R0().O().P());
            postData.l0(J);
            return postData;
        }
        return (PostData) invokeV.objValue;
    }

    @Override // c.a.t0.s2.u.a
    public String getFromForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            PbModel pbModel = this.mModel;
            if (pbModel != null) {
                return pbModel.r0();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.s0.g1.n.i
    public c.a.d.f.k.b<GifView> getGifViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return null;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    @Override // c.a.s0.g1.n.i
    public c.a.d.f.k.b<ImageView> getImageViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.mImageViewPool == null) {
                this.mImageViewPool = new c.a.d.f.k.b<>(new q(this), 8, 0);
            }
            return this.mImageViewPool;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    @Override // c.a.s0.g1.n.i
    public c.a.d.f.k.b<ItemCardView> getItemCardViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return null;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    @Override // c.a.s0.g1.n.i
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

    public c.a.s0.x.y.e getPbEditor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mPbEditor : (c.a.s0.x.y.e) invokeV.objValue;
    }

    public c.a.t0.s2.u.f.d1.c getPbPostShareController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mPbPostShareController : (c.a.t0.s2.u.f.d1.c) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, voiceData$VoiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // c.a.s0.g1.n.i
    public c.a.d.f.k.b<RelativeLayout> getRelativeLayoutPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return null;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    @Override // c.a.s0.g1.n.i
    public int getRichTextViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.s0.g1.n.i
    public c.a.d.f.k.b<TextView> getTextViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return null;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    @Override // c.a.s0.g1.n.i
    public c.a.d.f.k.b<LinearLayout> getTextVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return null;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    @Override // c.a.s0.g1.n.i
    public c.a.d.f.k.b<TiebaPlusRecommendCard> getTiejiaRecommendPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return null;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    @Override // c.a.t0.s2.u.a
    public int getUserIdentify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            PbModel pbModel = this.mModel;
            if (pbModel == null || pbModel.R0() == null) {
                return 0;
            }
            return this.mModel.R0().V();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.mVoiceManager : (VoiceManager) invokeV.objValue;
    }

    @Override // c.a.s0.g1.n.i
    public c.a.d.f.k.b<View> getVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return null;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    public void handleMuteClick(boolean z, String str, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Boolean.valueOf(z), str, sparseArray}) == null) {
            String str2 = sparseArray.get(c.a.t0.s2.i.tag_user_mute_mute_username) instanceof String ? (String) sparseArray.get(c.a.t0.s2.i.tag_user_mute_mute_username) : "";
            String str3 = sparseArray.get(c.a.t0.s2.i.tag_user_mute_thread_id) instanceof String ? (String) sparseArray.get(c.a.t0.s2.i.tag_user_mute_thread_id) : "";
            String str4 = sparseArray.get(c.a.t0.s2.i.tag_user_mute_post_id) instanceof String ? (String) sparseArray.get(c.a.t0.s2.i.tag_user_mute_post_id) : "";
            String str5 = sparseArray.get(c.a.t0.s2.i.tag_user_mute_msg) instanceof String ? (String) sparseArray.get(c.a.t0.s2.i.tag_user_mute_msg) : "";
            String str6 = sparseArray.get(c.a.t0.s2.i.tag_user_mute_mute_nameshow) instanceof String ? (String) sparseArray.get(c.a.t0.s2.i.tag_user_mute_mute_nameshow) : "";
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.MESSAGE_ID_PB);
            userMuteAddAndDelCustomMessage.setTag(this.MESSAGE_ID_PB);
            showUserMuteDialog(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    @Override // c.a.t0.s2.u.a
    public boolean isHost(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
            PbModel pbModel = this.mModel;
            return pbModel != null && pbModel.D1(str);
        }
        return invokeL.booleanValue;
    }

    public boolean isHostOnlyMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            PbModel pbModel = this.mModel;
            if (pbModel != null) {
                return pbModel.v0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isImage(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, view)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.t0.s2.u.a
    public boolean isSimpleForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            PbModel pbModel = this.mModel;
            if (pbModel == null) {
                return false;
            }
            return pbModel.C1();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        String str;
        Serializable serializableExtra;
        EmotionImageData emotionImageData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048612, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            this.mPbEditor.H(i2, i3, intent);
            c.a.t0.s2.u.f.c1.f.a aVar = this.mReplyEmotionModel;
            if (aVar != null) {
                aVar.i(i2, i3, intent);
            }
            if (this.mView.y() != null) {
                this.mView.y().g(i2, i3, intent);
            }
            if (i2 == 25035) {
                handleFullScreenEditorResult(i3, intent);
            }
            if (i3 == -1) {
                if (i2 == 13008) {
                    l0.b().m();
                    this.mHandler.postDelayed(new h(this), 1000L);
                } else if (i2 == 13011) {
                    c.a.t0.i3.a.g().m(getPageContext());
                } else if (i2 != 24007) {
                    if ((i2 == 25016 || i2 == 25023) && (serializableExtra = intent.getSerializableExtra(PbSearchEmotionActivity.EMOTION_BACK_DATA)) != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.mEmotionImageData = emotionImageData;
                        if (checkPrivacyBeforePost(ReplyPrivacyCheckController.TYPE_EMOTION_IMAGE)) {
                            sendEmotion(emotionImageData);
                        }
                    }
                } else {
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        c.a.t0.i3.a.g().m(getPageContext());
                        tryAddexperienced();
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.mShareSuccessReplyToServerModel;
                        if (shareSuccessReplyToServerModel == null || shareItem == null || (str = shareItem.t) == null) {
                            return;
                        }
                        shareSuccessReplyToServerModel.w(str, intExtra, new i(this));
                    }
                }
            }
        }
    }

    @Override // c.a.s0.g1.n.i
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

    @Override // c.a.s0.s.s.a.e
    public void onClick(c.a.s0.s.s.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, aVar) == null) {
            deleteThread(aVar, (JSONArray) null);
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
            this.mView.A().show();
            this.mView.x().setFromForumId(this.mModel.getFromForumId());
            c.a.t0.s2.u.g.a aVar = new c.a.t0.s2.u.g.a(this);
            this.mUEGReportController = aVar;
            aVar.b(getUniqueId());
            this.mUserBlockController = new c.a.t0.g4.b(getPageContext(), getUniqueId());
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.mReplyPrivacyController = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new s(this));
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.mPbEditor.k0(TbSingleton.getInstance().getAdVertiComment());
            } else {
                this.mPbEditor.k0(this.mView.z());
            }
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

    @Override // c.a.s0.g1.n.i
    public void onLinkButtonClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048618, this, context, str) == null) {
        }
    }

    @Override // c.a.s0.g1.n.i
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

    @Override // c.a.s0.g1.n.i
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

    @Override // c.a.s0.g1.n.i
    public void onSongClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048623, this, context, str) == null) {
        }
    }

    @Override // c.a.s0.g1.n.i
    public void onVideoClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048624, this, context, str) == null) {
        }
    }

    @Override // c.a.s0.g1.n.i
    public void onVideoP2PClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048625, this, context, str) == null) {
        }
    }

    public void processProfessionPermission() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048626, this) == null) || !checkUpIsLogin() || (pbModel = this.mModel) == null || pbModel.R0() == null || this.mModel.R0().l() == null || checkIsIfPostForbid()) {
            return;
        }
        if (this.mModel.R0().g0()) {
            this.mView.t();
            return;
        }
        if (this.mProfessionController == null) {
            c.a.t0.d1.r2.a.c cVar = new c.a.t0.d1.r2.a.c(getPageContext());
            this.mProfessionController = cVar;
            cVar.j(0);
            this.mProfessionController.i(new o(this));
        }
        this.mProfessionController.g(this.mModel.R0().l().getId(), c.a.d.f.m.b.g(this.mModel.h1(), 0L));
    }

    public void showBlockDialog(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048627, this, str) == null) || str == null || this.mUserBlockController == null) {
            return;
        }
        this.mUserBlockController.n(c.a.d.f.m.b.g(str, 0L));
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
        c.a.s0.i.a aVar;
        PostData firstPostData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, postData) == null) || postData == null) {
            return;
        }
        boolean z = false;
        if (postData.G() != null && postData.G().equals(this.mModel.M0())) {
            z = true;
        }
        MarkData L0 = this.mModel.L0(postData);
        if (this.mModel.R0() != null && this.mModel.R0().g0() && (firstPostData = getFirstPostData()) != null) {
            L0 = this.mModel.L0(firstPostData);
        }
        if (L0 == null || (aVar = this.mMarkModel) == null) {
            return;
        }
        aVar.i(L0);
        if (!z) {
            this.mMarkModel.a();
        } else {
            this.mMarkModel.d();
        }
    }

    public void deleteThread(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(c.a.t0.s2.u.f.t0.X1)).intValue();
            if (intValue == c.a.t0.s2.u.f.t0.Y1) {
                if (this.mForumManageModel.P()) {
                    return;
                }
                String str = (String) sparseArray.get(c.a.t0.s2.i.tag_del_post_id);
                int intValue2 = ((Integer) sparseArray.get(c.a.t0.s2.i.tag_manage_user_identity)).intValue();
                boolean booleanValue = ((Boolean) sparseArray.get(c.a.t0.s2.i.tag_del_post_is_self)).booleanValue();
                int intValue3 = ((Integer) sparseArray.get(c.a.t0.s2.i.tag_del_post_type)).intValue();
                boolean booleanValue2 = sparseArray.get(c.a.t0.s2.i.tag_is_block_thread) != null ? ((Boolean) sparseArray.get(c.a.t0.s2.i.tag_is_block_thread)).booleanValue() : false;
                if (jSONArray != null) {
                    this.mForumManageModel.R(StringHelper.JsonArrayToString(jSONArray));
                }
                this.mForumManageModel.S(this.mModel.R0().l().getId(), this.mModel.R0().l().getName(), this.mModel.R0().O().g0(), str, intValue3, intValue2, booleanValue, this.mModel.R0().O().L(), booleanValue2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            } else if (intValue == c.a.t0.s2.u.f.t0.Z1 || intValue == c.a.t0.s2.u.f.t0.b2) {
                if (this.mModel.n0() != null) {
                    this.mModel.n0().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == c.a.t0.s2.u.f.t0.Z1) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSubPbActivity(SparseArray<Object> sparseArray) {
        PostData postData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65620, this, sparseArray) == null) && checkUpIsLogin() && sparseArray != null && (sparseArray.get(c.a.t0.s2.i.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(c.a.t0.s2.i.tag_clip_board)) != null) {
            startSubPbActivity(postData, false);
        }
    }
}
