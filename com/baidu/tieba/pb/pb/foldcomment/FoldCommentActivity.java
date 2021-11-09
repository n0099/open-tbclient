package com.baidu.tieba.pb.pb.foldcomment;

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
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.c0.d;
import b.a.q0.i.a;
import b.a.q0.s.q.d2;
import b.a.q0.s.q.t0;
import b.a.q0.s.s.a;
import b.a.q0.s.s.i;
import b.a.q0.t.c.m0;
import b.a.r0.k2.s.c;
import b.a.r0.k2.u.f.k0;
import b.a.r0.k2.u.f.s0;
import b.a.r0.k2.u.f.u0;
import b.a.r0.k2.u.f.w0;
import b.a.r0.k2.u.f.x0;
import b.a.r0.x0.q2.a.c;
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
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.util.PageType;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tbadk.widget.layout.GridImageLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextMemeInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
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
/* loaded from: classes9.dex */
public class FoldCommentActivity extends BaseFragmentActivity implements VoiceManager.j, b.a.r0.k2.u.a<NewSubPbActivity>, TbRichTextView.t, a.e {
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
    public b.a.q0.x.x.b mCheckSubFloorCallBack;
    public View.OnClickListener mCommonOnClickListener;
    public u0 mContentProcessController;
    public CustomMessageListener mDraftLoadListener;
    public EmotionImageData mEmotionImageData;
    public TbRichTextMemeInfo mEmotionInfo;
    public Object mExtra;
    public final b.a.e.a.e mForumManageCallBack;
    public ForumManageModel mForumManageModel;
    public boolean mIsFromCDN;
    public PbModel.g mLoadPbCallback;
    public PopupDialog mLongClickDialog;
    public final a.InterfaceC0664a mMarkDoneCallBack;
    public b.a.q0.i.a mMarkModel;
    public b.a.q0.s.c0.a mMessageHelper;
    public PbModel mModel;
    public b.a.r0.l3.j0.e mMsgData;
    public NewWriteModel.g mOnFloorPostWriteNewCallback;
    public final TbRichTextView.z mOnImageClickListener;
    public final View.OnLongClickListener mOnLongClickListener;
    public b.a.q0.x.x.e mPbEditor;
    public b.a.r0.k2.u.f.c1.a mPbEventController;
    public b.a.r0.k2.u.f.c1.c mPbPostShareController;
    public b.a.q0.x.x.g mPbeb;
    public PermissionJudgePolicy mPermissionJudgement;
    public b.a.q0.s.s.i mPopupDialogView;
    public b.a.q0.x.x.c mPrePostCallBack;
    public b.a.r0.x0.q2.a.c mProfessionController;
    public b.a.r0.k2.u.f.b1.f.a mReplyEmotionModel;
    public int[] mReplyFloorLocation;
    public int mReplyFloorMeasureHeight;
    public ReplyPrivacyCheckController mReplyPrivacyController;
    public b.a.e.l.d.a mSaveBdImage;
    public w0 mSaveImageHelper;
    public String mSaveImageUrl;
    public ShareSuccessReplyToServerModel mShareSuccessReplyToServerModel;
    public b.a.r0.x0.q2.a.c mSubReplyPermissionController;
    public b.a.r0.k2.s.c mTbGestureDetector;
    public b.a.r0.k2.u.g.a mUEGReportController;
    public b.a.r0.v3.b mUserBlockController;
    public b.a.r0.k2.u.d.c mView;
    public VoiceManager mVoiceManager;
    public View moreReplyView;
    public i.e onLongClickItemClickListener;
    public PostData postData;
    public boolean showTrisectionAndFeedback;
    public View tempView;

    /* loaded from: classes9.dex */
    public class a extends b.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FoldCommentActivity f52131a;

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
            this.f52131a = foldCommentActivity;
        }

        @Override // b.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                boolean z = false;
                if (obj != null) {
                    int loadDataMode = this.f52131a.mForumManageModel.getLoadDataMode();
                    if (loadDataMode == 0) {
                        this.f52131a.mModel.o1();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        this.f52131a.finishDelPost(bVar, (bVar.f54251e != 1002 || bVar.f54252f) ? true : true);
                        return;
                    } else if (loadDataMode != 1) {
                        return;
                    } else {
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        this.f52131a.mView.v(1, dVar.f54255a, dVar.f54256b, true);
                        return;
                    }
                }
                this.f52131a.mView.v(this.f52131a.mForumManageModel.getLoadDataMode(), false, null, false);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FoldCommentActivity f52132e;

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
            this.f52132e = foldCommentActivity;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            aVar.dismiss();
        }
    }

    /* loaded from: classes9.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserMuteAddAndDelCustomMessage f52133e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FoldCommentActivity f52134f;

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
            this.f52134f = foldCommentActivity;
            this.f52133e = userMuteAddAndDelCustomMessage;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f52134f.mView.d0();
                MessageManager.getInstance().sendMessage(this.f52133e);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FoldCommentActivity f52135e;

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
            this.f52135e = foldCommentActivity;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements b.a.q0.x.x.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FoldCommentActivity f52136a;

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
            this.f52136a = foldCommentActivity;
        }

        @Override // b.a.q0.x.x.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f52136a.showProgressBar();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FoldCommentActivity f52137a;

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
            this.f52137a = foldCommentActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (this.f52137a.mPbEditor != null) {
                this.f52137a.mView.W(this.f52137a.mPbEditor.D());
            }
            this.f52137a.mView.a0(false);
        }
    }

    /* loaded from: classes9.dex */
    public class g implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FoldCommentActivity f52138a;

        /* loaded from: classes9.dex */
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

            @Override // b.a.q0.s.s.a.e
            public void onClick(b.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                }
            }
        }

        /* loaded from: classes9.dex */
        public class b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f52139e;

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
                this.f52139e = gVar;
            }

            @Override // b.a.q0.s.s.a.e
            public void onClick(b.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                    this.f52139e.f52138a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.f52139e.f52138a.getActivity(), 0, 26, 2)));
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
            this.f52138a = foldCommentActivity;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, m0 m0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, m0Var, writeData, antiData}) == null) {
                if (!b.a.e.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.f52138a.mModel != null && this.f52138a.mModel.P0() != null) {
                        statisticItem.param("fid", this.f52138a.mModel.P0().m());
                    }
                    if (this.f52138a.mModel != null) {
                        statisticItem.param("tid", this.f52138a.mModel.f1());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (z) {
                    u0 u0Var = this.f52138a.mContentProcessController;
                    if (u0Var != null) {
                        u0Var.d();
                    }
                    if (postWriteCallBackData == null || postWriteCallBackData.getIconStampData() == null) {
                        return;
                    }
                    b.a.q0.t.h.b.a(this.f52138a.getPageContext(), postWriteCallBackData);
                    return;
                }
                if ((postWriteCallBackData != null ? postWriteCallBackData.getErrorCode() : -1) == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.f52138a.mReplyPrivacyController;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                        return;
                    }
                    return;
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (b.a.e.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.makeText(this.f52138a.getActivity(), this.f52138a.getActivity().getString(b.a.r0.k2.l.current_links_too_much_please_modify_and_publish), null).show();
                    } else {
                        DefaultNavigationBarCoverTip.makeText(this.f52138a.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.f52138a.getActivity());
                    if (b.a.e.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.setMessage(this.f52138a.getActivity().getString(b.a.r0.k2.l.open_member_and_add_more_links));
                    } else {
                        aVar.setMessage(postWriteCallBackData.getErrorString());
                    }
                    aVar.setNegativeButton(b.a.r0.k2.l.cancel, new a(this));
                    aVar.setPositiveButton(b.a.r0.k2.l.open_now, new b(this));
                    aVar.create(this.f52138a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData == null || !postWriteCallBackData.isSensitiveError()) {
                    return;
                }
                FoldCommentActivity foldCommentActivity = this.f52138a;
                if (foldCommentActivity.mContentProcessController == null) {
                    return;
                }
                if (foldCommentActivity.mView != null && this.f52138a.mView.y() != null && this.f52138a.mView.y().b() != null && this.f52138a.mView.y().b().x()) {
                    this.f52138a.mView.y().b().v(postWriteCallBackData);
                }
                this.f52138a.mContentProcessController.l(postWriteCallBackData);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FoldCommentActivity f52140e;

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
            this.f52140e = foldCommentActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f52140e.mModel == null) {
                return;
            }
            this.f52140e.mModel.loadData();
        }
    }

    /* loaded from: classes9.dex */
    public class i implements ShareSuccessReplyToServerModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FoldCommentActivity f52141a;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomDialogData f52142e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ i f52143f;

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
                this.f52143f = iVar;
                this.f52142e = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b.a.r0.k2.t.c.a(this.f52143f.f52141a.getPageContext(), this.f52142e).show();
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
            this.f52141a = foldCommentActivity;
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
                b.a.e.e.m.e.a().postDelayed(new a(this, customDialogData), 1000L);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FoldCommentActivity f52144e;

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
            this.f52144e = foldCommentActivity;
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
                statisticItem2.param("tid", this.f52144e.mModel.f1());
                statisticItem2.param("fid", this.f52144e.mModel.getForumId());
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("obj_locate", 1);
                TiebaStatic.log(statisticItem2);
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(b.a.r0.k2.i.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData = (PostData) obj;
                        if (this.f52144e.mModel == null || this.f52144e.mModel.P0() == null || postData.t() == null || postData.A() == 1 || !this.f52144e.checkUpIsLogin()) {
                            return;
                        }
                        if (this.f52144e.mView.y() != null) {
                            this.f52144e.mView.y().c();
                        }
                        b.a.r0.k2.r.s sVar = new b.a.r0.k2.r.s();
                        sVar.A(this.f52144e.mModel.P0().l());
                        sVar.E(this.f52144e.mModel.P0().O());
                        sVar.C(postData);
                        this.f52144e.mView.x().S(sVar);
                        this.f52144e.mView.x().setPostId(postData.G());
                        this.f52144e.locateSubPbEditor(view, postData.t().getUserId(), "", postData);
                        TiebaStatic.log("c11743");
                        b.a.r0.k2.w.a.b(this.f52144e.mModel.P0(), postData, postData.k0, 8, 1);
                        if (this.f52144e.mPbEditor != null) {
                            this.f52144e.mView.W(this.f52144e.mPbEditor.D());
                        }
                    }
                }
            } else if (view.getId() != b.a.r0.k2.i.pb_floor_right_top_feedback && view.getId() != b.a.r0.k2.i.pb_post_op_more) {
                if (view.getId() != b.a.r0.k2.i.sub_pb_more && view.getId() != b.a.r0.k2.i.sub_pb_item && view.getId() != b.a.r0.k2.i.pb_floor_reply_more && view.getId() != b.a.r0.k2.i.new_sub_pb_list_richText) {
                    if ((view.getId() == b.a.r0.k2.i.pb_post_reply || view.getId() == b.a.r0.k2.i.post_info_commont_img || view.getId() == b.a.r0.k2.i.pb_floor_comment_container) && this.f52144e.mModel != null) {
                        if (view.getId() == b.a.r0.k2.i.pb_post_reply) {
                            StatisticItem statisticItem3 = new StatisticItem("c13398");
                            statisticItem3.param("tid", this.f52144e.mModel.f1());
                            statisticItem3.param("fid", this.f52144e.mModel.getForumId());
                            statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                            statisticItem3.param("obj_locate", 6);
                            TiebaStatic.log(statisticItem3);
                        }
                        if (view.getId() == b.a.r0.k2.i.post_info_commont_img) {
                            if (!DialogLoginHelper.checkUpIsLogin(new t0(this.f52144e.getActivity(), "pb_huifu_louzhonglou"))) {
                                this.f52144e.floorReplyView = view;
                                return;
                            }
                        } else if (view.getId() == b.a.r0.k2.i.pb_post_reply && !DialogLoginHelper.checkUpIsLogin(new t0(this.f52144e.getActivity(), "pb_huifu_louzhonglou"))) {
                            this.f52144e.floorReplyView = view;
                            return;
                        }
                        if (this.f52144e.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                            SparseArray sparseArray = (SparseArray) view.getTag();
                            if (sparseArray.get(b.a.r0.k2.i.tag_load_sub_data) instanceof PostData) {
                                PostData postData2 = (PostData) sparseArray.get(b.a.r0.k2.i.tag_load_sub_data);
                                if (view.getId() == b.a.r0.k2.i.pb_post_reply && (statisticItem = postData2.l0) != null) {
                                    StatisticItem copy = statisticItem.copy();
                                    copy.delete("obj_locate");
                                    copy.param("obj_locate", 8);
                                    TiebaStatic.log(copy);
                                } else if (view.getId() == b.a.r0.k2.i.post_info_commont_img || view.getId() == b.a.r0.k2.i.pb_floor_comment_container) {
                                    TiebaStatic.log(new StatisticItem("c13700").param("tid", this.f52144e.mModel.g1()).param("fid", this.f52144e.mModel.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData2.G()).param("obj_source", 1).param("obj_type", 3));
                                }
                                if (this.f52144e.mModel == null || this.f52144e.mModel.P0() == null || postData2.t() == null || postData2.A() == 1) {
                                    return;
                                }
                                if (this.f52144e.mView.y() != null) {
                                    this.f52144e.mView.y().c();
                                }
                                if (this.f52144e.showTrisectionAndFeedback && postData2.O() != null && postData2.O().size() != 0) {
                                    this.f52144e.startSubPbActivity(postData2, true);
                                    return;
                                }
                                b.a.r0.k2.r.s sVar2 = new b.a.r0.k2.r.s();
                                sVar2.A(this.f52144e.mModel.P0().l());
                                sVar2.E(this.f52144e.mModel.P0().O());
                                sVar2.C(postData2);
                                this.f52144e.mView.x().S(sVar2);
                                this.f52144e.mView.x().setPostId(postData2.G());
                                this.f52144e.locateSubPbEditor(view, postData2.t().getUserId(), "", postData2);
                                if (this.f52144e.mPbEditor != null) {
                                    this.f52144e.mView.W(this.f52144e.mPbEditor.D());
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
                if (view.getId() == b.a.r0.k2.i.new_sub_pb_list_richText) {
                    StatisticItem statisticItem4 = new StatisticItem("c13398");
                    statisticItem4.param("tid", this.f52144e.mModel.f1());
                    statisticItem4.param("fid", this.f52144e.mModel.getForumId());
                    statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem4.param("obj_locate", 4);
                    TiebaStatic.log(statisticItem4);
                }
                if (view.getId() == b.a.r0.k2.i.pb_floor_reply_more && !DialogLoginHelper.checkUpIsLogin(new t0(this.f52144e.getActivity(), "pb_chakanhuifu"))) {
                    this.f52144e.moreReplyView = view;
                } else if (this.f52144e.checkUpIsLogin()) {
                    if (this.f52144e.mModel == null || this.f52144e.mModel.P0() == null) {
                        return;
                    }
                    this.f52144e.mView.u();
                    SparseArray sparseArray2 = (SparseArray) view.getTag();
                    PostData postData3 = (PostData) sparseArray2.get(b.a.r0.k2.i.tag_load_sub_data);
                    PostData postData4 = (PostData) sparseArray2.get(b.a.r0.k2.i.tag_load_sub_reply_data);
                    View view2 = (View) sparseArray2.get(b.a.r0.k2.i.tag_load_sub_view);
                    if (postData3 == null || view2 == null) {
                        return;
                    }
                    if (postData3.E() == 1) {
                        TiebaStatic.log(new StatisticItem("c12630"));
                    }
                    StatisticItem statisticItem5 = postData3.l0;
                    if (statisticItem5 != null) {
                        StatisticItem copy2 = statisticItem5.copy();
                        copy2.delete("obj_locate");
                        if (view.getId() == b.a.r0.k2.i.new_sub_pb_list_richText) {
                            copy2.param("obj_locate", 6);
                        } else if (view.getId() == b.a.r0.k2.i.pb_floor_reply_more) {
                            copy2.param("obj_locate", 8);
                        }
                        TiebaStatic.log(copy2);
                    }
                    if (view.getId() == b.a.r0.k2.i.pb_floor_reply_more && this.f52144e.mModel != null && this.f52144e.mModel.P0() != null && postData3 != null) {
                        TiebaStatic.log(new StatisticItem("c14443").param("tid", this.f52144e.mModel.f1()).param("fname", this.f52144e.mModel.P0().n()).param("fid", this.f52144e.mModel.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData3.G()));
                    }
                    String f1 = this.f52144e.mModel.f1();
                    String G = postData3.G();
                    String G2 = postData4 != null ? postData4.G() : "";
                    int V = this.f52144e.mModel.P0() != null ? this.f52144e.mModel.P0().V() : 0;
                    this.f52144e.stopVoice();
                    if (view.getId() == b.a.r0.k2.i.replybtn) {
                        AbsPbActivity.e processSubPbImg = this.f52144e.processSubPbImg(G);
                        if (this.f52144e.mModel == null || this.f52144e.mModel.P0() == null || processSubPbImg == null) {
                            return;
                        }
                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.f52144e.getPageContext().getPageActivity()).createSubPbActivityConfig(f1, G, "pb", true, false, null, true, null, V, postData3.R(), this.f52144e.mModel.P0().d(), false, postData3.t().getIconInfo(), 5).addBigImageData(processSubPbImg.f52183a, processSubPbImg.f52184b, processSubPbImg.f52189g, processSubPbImg.j);
                        addBigImageData.setKeyPageStartFrom(this.f52144e.mModel.O0());
                        addBigImageData.setFromFrsForumId(this.f52144e.mModel.getFromForumId());
                        addBigImageData.setWorksInfoData(this.f52144e.mModel.k1());
                        addBigImageData.setKeyFromForumId(this.f52144e.mModel.getForumId());
                        addBigImageData.setBjhData(this.f52144e.mModel.j0());
                        addBigImageData.setTiebaPlusData(this.f52144e.mModel.F(), this.f52144e.mModel.B(), this.f52144e.mModel.C(), this.f52144e.mModel.A(), this.f52144e.mModel.G());
                        addBigImageData.setFromFoldComment(true);
                        this.f52144e.sendMessage(new CustomMessage(2002001, addBigImageData));
                        return;
                    }
                    TiebaStatic.log("c11742");
                    AbsPbActivity.e processSubPbImg2 = this.f52144e.processSubPbImg(G);
                    if (postData3 == null || this.f52144e.mModel == null || this.f52144e.mModel.P0() == null || processSubPbImg2 == null) {
                        return;
                    }
                    SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(this.f52144e.getPageContext().getPageActivity()).createSubPbActivityConfig(f1, G, "pb", true, false, null, false, G2, V, postData3.R(), this.f52144e.mModel.P0().d(), false, postData3.t().getIconInfo(), 5).addBigImageData(processSubPbImg2.f52183a, processSubPbImg2.f52184b, processSubPbImg2.f52189g, processSubPbImg2.j);
                    if (!b.a.e.e.p.k.isEmpty(G2)) {
                        addBigImageData2.setHighLightPostId(G2);
                        addBigImageData2.setKeyIsUseSpid(true);
                    }
                    addBigImageData2.setKeyFromForumId(this.f52144e.mModel.getForumId());
                    addBigImageData2.setTiebaPlusData(this.f52144e.mModel.F(), this.f52144e.mModel.B(), this.f52144e.mModel.C(), this.f52144e.mModel.A(), this.f52144e.mModel.G());
                    addBigImageData2.setBjhData(this.f52144e.mModel.j0());
                    addBigImageData2.setKeyPageStartFrom(this.f52144e.mModel.O0());
                    addBigImageData2.setFromFrsForumId(this.f52144e.mModel.getFromForumId());
                    addBigImageData2.setWorksInfoData(this.f52144e.mModel.k1());
                    addBigImageData2.setFromFoldComment(true);
                    this.f52144e.sendMessage(new CustomMessage(2002001, addBigImageData2));
                } else {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 3).param("fid", this.f52144e.mModel.P0().m()));
                }
            } else {
                StatisticItem statisticItem6 = new StatisticItem("c13398");
                statisticItem6.param("tid", this.f52144e.mModel.f1());
                statisticItem6.param("fid", this.f52144e.mModel.getForumId());
                statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem6.param("obj_locate", 7);
                TiebaStatic.log(statisticItem6);
                if (this.f52144e.mModel != null && this.f52144e.mModel.P0() != null && this.f52144e.postData != null) {
                    TiebaStatic.log(new StatisticItem("c14441").param("tid", this.f52144e.mModel.f1()).param("fname", this.f52144e.mModel.P0().n()).param("fid", this.f52144e.mModel.P0().m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.f52144e.postData.G()));
                }
                FoldCommentActivity foldCommentActivity = this.f52144e;
                foldCommentActivity.isDialogFromLongClick = false;
                foldCommentActivity.dealLongClickListener(view);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class k implements PbModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FoldCommentActivity f52145a;

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
            this.f52145a = foldCommentActivity;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void a(int i2, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), responsedMessage, Boolean.valueOf(z2), Long.valueOf(j)}) == null) {
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void b(b.a.r0.k2.r.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void c(boolean z, int i2, int i3, int i4, b.a.r0.k2.r.f fVar, String str, int i5) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fVar, str, Integer.valueOf(i5)}) == null) || this.f52145a.mView == null) {
                return;
            }
            this.f52145a.mView.U();
            if (!z) {
                this.f52145a.onNetOrDataError(i2, str);
                return;
            }
            this.f52145a.mView.E();
            if (fVar != null) {
                if (fVar.s() == 1) {
                    this.f52145a.mIsFromCDN = true;
                } else {
                    this.f52145a.mIsFromCDN = false;
                }
                String str2 = null;
                if (this.f52145a.mModel == null || !this.f52145a.mModel.r1()) {
                    if (this.f52145a.mView != null) {
                        str2 = this.f52145a.mView.z();
                    }
                } else {
                    str2 = this.f52145a.getPageContext().getString(b.a.r0.k2.l.pb_reply_hint_from_smart_frs);
                }
                if (!StringUtils.isNull(str2)) {
                    this.f52145a.mPbEditor.l0(TbSingleton.getInstance().getAdVertiComment(fVar.k0(), fVar.l0(), str2));
                }
                this.f52145a.mView.S(fVar, this.f52145a.mIsFromCDN);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f52146e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f52147f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ FoldCommentActivity f52148g;

        /* loaded from: classes9.dex */
        public class a implements TextWatcher {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ l f52149e;

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
                this.f52149e = lVar;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                u0 u0Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (u0Var = this.f52149e.f52148g.mContentProcessController) == null || u0Var.g() == null) {
                    return;
                }
                if (!this.f52149e.f52148g.mContentProcessController.g().e()) {
                    this.f52149e.f52148g.mContentProcessController.b(false);
                }
                this.f52149e.f52148g.mContentProcessController.g().l(false);
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
            this.f52148g = foldCommentActivity;
            this.f52146e = str;
            this.f52147f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2;
            int g2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i3 = b.a.e.e.p.l.i(this.f52148g.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i2 = TbadkCoreApplication.getInst().getKeyboardHeight();
                    g2 = b.a.e.e.p.l.g(this.f52148g.getPageContext().getPageActivity(), b.a.r0.k2.g.tbds256);
                } else {
                    i2 = i3 / 2;
                    g2 = b.a.e.e.p.l.g(this.f52148g.getPageContext().getPageActivity(), b.a.r0.k2.g.tbds256);
                }
                int i4 = i3 - (i2 + g2);
                FoldCommentActivity foldCommentActivity = this.f52148g;
                boolean z = true;
                foldCommentActivity.mView.w().smoothScrollBy((foldCommentActivity.mReplyFloorLocation[1] + foldCommentActivity.mReplyFloorMeasureHeight) - i4, 50);
                if (this.f52148g.mView.y() != null) {
                    this.f52148g.mPbEditor.a().setVisibility(8);
                    this.f52148g.mView.y().n(this.f52146e, this.f52147f, this.f52148g.mView.z(), (this.f52148g.mModel == null || this.f52148g.mModel.P0() == null || this.f52148g.mModel.P0().O() == null || !this.f52148g.mModel.P0().O().Q1()) ? false : false);
                    b.a.q0.x.x.h b2 = this.f52148g.mView.y().b();
                    if (b2 != null && this.f52148g.mModel != null && this.f52148g.mModel.P0() != null) {
                        b2.G(this.f52148g.mModel.P0().d());
                        b2.b0(this.f52148g.mModel.P0().O());
                    }
                    if (this.f52148g.mContentProcessController.f() == null && this.f52148g.mView.y().b().t() != null) {
                        this.f52148g.mView.y().b().t().f(new a(this));
                        FoldCommentActivity foldCommentActivity2 = this.f52148g;
                        foldCommentActivity2.mContentProcessController.n(foldCommentActivity2.mView.y().b().t().h());
                        this.f52148g.mView.y().b().M(this.f52148g.mCheckSubFloorCallBack);
                    }
                }
                this.f52148g.mView.B();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class m implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f52150a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f52151b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FoldCommentActivity f52152c;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ m f52153e;

            /* renamed from: com.baidu.tieba.pb.pb.foldcomment.FoldCommentActivity$m$a$a  reason: collision with other inner class name */
            /* loaded from: classes9.dex */
            public class C1750a implements TextWatcher {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f52154e;

                public C1750a(a aVar) {
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
                    this.f52154e = aVar;
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    u0 u0Var;
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (u0Var = this.f52154e.f52153e.f52152c.mContentProcessController) == null || u0Var.g() == null) {
                        return;
                    }
                    if (!this.f52154e.f52153e.f52152c.mContentProcessController.g().e()) {
                        this.f52154e.f52153e.f52152c.mContentProcessController.b(false);
                    }
                    this.f52154e.f52153e.f52152c.mContentProcessController.g().l(false);
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
                this.f52153e = mVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i2;
                int g2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int i3 = b.a.e.e.p.l.i(this.f52153e.f52152c.getApplicationContext());
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        i2 = TbadkCoreApplication.getInst().getKeyboardHeight();
                        g2 = b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.tbds410);
                    } else {
                        i2 = i3 / 2;
                        g2 = b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.tbds410);
                    }
                    int i4 = i3 - (i2 + g2);
                    FoldCommentActivity foldCommentActivity = this.f52153e.f52152c;
                    boolean z = true;
                    foldCommentActivity.mView.w().smoothScrollBy((foldCommentActivity.mReplyFloorLocation[1] + foldCommentActivity.mReplyFloorMeasureHeight) - i4, 50);
                    if (this.f52153e.f52152c.mView.y() != null) {
                        this.f52153e.f52152c.mPbEditor.a().setVisibility(8);
                        z = (this.f52153e.f52152c.mModel == null || this.f52153e.f52152c.mModel.P0() == null || this.f52153e.f52152c.mModel.P0().O() == null || !this.f52153e.f52152c.mModel.P0().O().Q1()) ? false : false;
                        b.a.r0.k2.u.f.t y = this.f52153e.f52152c.mView.y();
                        m mVar = this.f52153e;
                        y.n(mVar.f52150a, mVar.f52151b, mVar.f52152c.mView.z(), z);
                        b.a.q0.x.x.h b2 = this.f52153e.f52152c.mView.y().b();
                        if (b2 != null && this.f52153e.f52152c.mModel != null && this.f52153e.f52152c.mModel.P0() != null) {
                            b2.G(this.f52153e.f52152c.mModel.P0().d());
                            b2.b0(this.f52153e.f52152c.mModel.P0().O());
                        }
                        if (this.f52153e.f52152c.mContentProcessController.f() == null && this.f52153e.f52152c.mView.y().b().t() != null) {
                            this.f52153e.f52152c.mView.y().b().t().f(new C1750a(this));
                            FoldCommentActivity foldCommentActivity2 = this.f52153e.f52152c;
                            foldCommentActivity2.mContentProcessController.n(foldCommentActivity2.mView.y().b().t().h());
                            this.f52153e.f52152c.mView.y().b().M(this.f52153e.f52152c.mCheckSubFloorCallBack);
                        }
                    }
                    this.f52153e.f52152c.mView.B();
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
            this.f52152c = foldCommentActivity;
            this.f52150a = str;
            this.f52151b = str2;
        }

        @Override // b.a.r0.x0.q2.a.c.d
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // b.a.r0.x0.q2.a.c.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                b.a.e.e.m.e.a().postDelayed(new a(this), 0L);
            }
        }

        @Override // b.a.r0.x0.q2.a.c.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class n implements b.a.q0.x.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FoldCommentActivity f52155a;

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
            this.f52155a = foldCommentActivity;
        }

        @Override // b.a.q0.x.x.b
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                u0 u0Var = this.f52155a.mContentProcessController;
                if (u0Var == null || u0Var.g() == null || !this.f52155a.mContentProcessController.g().d()) {
                    return !this.f52155a.checkPrivacyBeforePost(ReplyPrivacyCheckController.TYPE_FLOOR);
                }
                FoldCommentActivity foldCommentActivity = this.f52155a;
                foldCommentActivity.showToast(foldCommentActivity.mContentProcessController.g().c());
                if (this.f52155a.mView != null && this.f52155a.mView.y() != null && this.f52155a.mView.y().b() != null && this.f52155a.mView.y().b().x()) {
                    this.f52155a.mView.y().b().v(this.f52155a.mContentProcessController.h());
                }
                this.f52155a.mContentProcessController.b(true);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class o implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FoldCommentActivity f52156a;

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
            this.f52156a = foldCommentActivity;
        }

        @Override // b.a.r0.x0.q2.a.c.d
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // b.a.r0.x0.q2.a.c.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                if (this.f52156a.mPbEditor != null && this.f52156a.mPbEditor.a() != null) {
                    this.f52156a.mPbEditor.a().sendAction(new b.a.q0.x.a(45, 27, null));
                }
                this.f52156a.mView.t();
            }
        }

        @Override // b.a.r0.x0.q2.a.c.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class p implements a.InterfaceC0664a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FoldCommentActivity f52157a;

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
            this.f52157a = foldCommentActivity;
        }

        @Override // b.a.q0.i.a.InterfaceC0664a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                if (z) {
                    if (this.f52157a.mMarkModel != null) {
                        this.f52157a.mMarkModel.h(z2);
                    }
                    this.f52157a.mModel.r2(z2);
                    if (this.f52157a.mModel.B0()) {
                        this.f52157a.makeFakeMark();
                    }
                    if (z2) {
                        if (this.f52157a.mMarkModel != null) {
                            if (this.f52157a.mMarkModel.f() == null || this.f52157a.mModel == null || this.f52157a.mModel.P0() == null || this.f52157a.mModel.P0().O() == null || this.f52157a.mModel.P0().O().J() == null) {
                                return;
                            }
                            MarkData f2 = this.f52157a.mMarkModel.f();
                            MetaData J = this.f52157a.mModel.P0().O().J();
                            if (f2 != null && J != null) {
                                if (StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), J.getUserId()) || J.hadConcerned()) {
                                    this.f52157a.showToast(b.a.r0.k2.l.add_mark_on_pb);
                                    if (b.a.q0.t.h.a.e(this.f52157a.getActivity(), 0)) {
                                        b.a.q0.t.h.a.g(this.f52157a.getPageContext(), 6, 2000L);
                                    }
                                }
                            } else {
                                FoldCommentActivity foldCommentActivity = this.f52157a;
                                foldCommentActivity.showToast(foldCommentActivity.getPageContext().getString(b.a.r0.k2.l.add_mark));
                            }
                        }
                        this.f52157a.addCollectionStat();
                        return;
                    }
                    FoldCommentActivity foldCommentActivity2 = this.f52157a;
                    foldCommentActivity2.showToast(foldCommentActivity2.getPageContext().getString(b.a.r0.k2.l.remove_mark));
                    return;
                }
                FoldCommentActivity foldCommentActivity3 = this.f52157a;
                foldCommentActivity3.showToast(foldCommentActivity3.getPageContext().getString(b.a.r0.k2.l.update_mark_failed));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class q implements TbRichTextView.z {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FoldCommentActivity f52158a;

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
            this.f52158a = foldCommentActivity;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r14v22, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$b */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.z
        public void a(View view, String str, int i2, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, str, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    if (view.getTag(b.a.r0.k2.i.tag_rich_text_meme_info) == null || !(view.getTag(b.a.r0.k2.i.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                        if (this.f52158a.mModel.P0().g0()) {
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
                            bVar.F(this.f52158a.mModel.a1());
                            bVar.w(concurrentHashMap);
                            bVar.H(true);
                            bVar.K(false);
                            bVar.G(this.f52158a.isHostOnlyMode());
                            if (this.f52158a.mModel != null) {
                                bVar.A(this.f52158a.mModel.getFromForumId());
                                if (this.f52158a.mModel.P0() != null) {
                                    bVar.N(this.f52158a.mModel.P0().O());
                                }
                            }
                            ImageViewerConfig v = bVar.v(this.f52158a.getPageContext().getPageActivity());
                            v.getIntent().putExtra("from", "pb");
                            this.f52158a.sendMessage(new CustomMessage(2010000, v));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                            return;
                        }
                        AbsPbActivity.e eVar = new AbsPbActivity.e();
                        this.f52158a.processImgUrls(str, i2, eVar);
                        if (eVar.f52190h) {
                            TbRichText validImage = this.f52158a.validImage(str, i2);
                            if (validImage != null && this.f52158a.imgIndex >= 0 && this.f52158a.imgIndex < validImage.y().size()) {
                                ArrayList<String> arrayList2 = new ArrayList<>();
                                String a2 = b.a.r0.k2.r.g.a(validImage.y().get(this.f52158a.imgIndex));
                                int i6 = 0;
                                while (true) {
                                    if (i6 >= eVar.f52183a.size()) {
                                        break;
                                    } else if (eVar.f52183a.get(i6).equals(a2)) {
                                        eVar.j = i6;
                                        arrayList2.add(a2);
                                        break;
                                    } else {
                                        i6++;
                                    }
                                }
                                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                                if (!ListUtils.isEmpty(arrayList2)) {
                                    String str2 = arrayList2.get(0);
                                    concurrentHashMap2.put(str2, eVar.f52184b.get(str2));
                                }
                                ImageViewerConfig.b bVar2 = new ImageViewerConfig.b();
                                bVar2.x(arrayList2);
                                bVar2.z(eVar.f52185c);
                                bVar2.y(eVar.f52186d);
                                bVar2.O(eVar.f52187e);
                                bVar2.C(eVar.f52189g);
                                bVar2.H(true);
                                bVar2.J(eVar.f52191i);
                                bVar2.F(this.f52158a.mModel.a1());
                                bVar2.w(concurrentHashMap2);
                                bVar2.K(false);
                                bVar2.G(this.f52158a.isHostOnlyMode());
                                bVar2.L(eVar.f52188f);
                                if (this.f52158a.mModel != null) {
                                    bVar2.A(this.f52158a.mModel.getFromForumId());
                                    if (this.f52158a.mModel.P0() != null) {
                                        bVar2.N(this.f52158a.mModel.P0().O());
                                    }
                                }
                                ImageViewerConfig v2 = bVar2.v(this.f52158a.getPageContext().getPageActivity());
                                v2.getIntent().putExtra("from", "pb");
                                this.f52158a.sendMessage(new CustomMessage(2010000, v2));
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                                return;
                            }
                            return;
                        }
                        ArrayList arrayList3 = new ArrayList();
                        arrayList3.add(ListUtils.getItem(eVar.f52183a, 0));
                        ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
                        if (!ListUtils.isEmpty(arrayList3)) {
                            String str3 = (String) arrayList3.get(0);
                            concurrentHashMap3.put(str3, eVar.f52184b.get(str3));
                        }
                        ImageViewerConfig.b bVar3 = new ImageViewerConfig.b();
                        bVar3.x(arrayList3);
                        bVar3.z(eVar.f52185c);
                        bVar3.y(eVar.f52186d);
                        bVar3.O(eVar.f52187e);
                        bVar3.C(eVar.f52189g);
                        bVar3.H(true);
                        bVar3.J(eVar.f52183a.get(0));
                        bVar3.F(this.f52158a.mModel.a1());
                        bVar3.w(concurrentHashMap3);
                        bVar3.K(false);
                        bVar3.G(this.f52158a.isHostOnlyMode());
                        bVar3.L(eVar.f52188f);
                        bVar3.D(false);
                        if (this.f52158a.mModel != null) {
                            bVar3.A(this.f52158a.mModel.getFromForumId());
                            if (this.f52158a.mModel.P0() != null) {
                                bVar3.N(this.f52158a.mModel.P0().O());
                            }
                        }
                        ImageViewerConfig v3 = bVar3.v(this.f52158a.getPageContext().getPageActivity());
                        v3.getIntent().putExtra("from", "pb");
                        this.f52158a.sendMessage(new CustomMessage(2010000, v3));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                        return;
                    }
                    TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(b.a.r0.k2.i.tag_rich_text_meme_info);
                    boolean isGif = ((TbImageView) view).isGif();
                    if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                        this.f52158a.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(this.f52158a.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, isGif)));
                    }
                    this.f52158a.tempView = view;
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class r implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FoldCommentActivity f52159a;

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
            this.f52159a = foldCommentActivity;
        }

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && z) {
                if (i2 == ReplyPrivacyCheckController.TYPE_THREAD) {
                    this.f52159a.mPbEditor.M(null, null);
                } else if (i2 == ReplyPrivacyCheckController.TYPE_FLOOR && this.f52159a.mView != null && this.f52159a.mView.y() != null && this.f52159a.mView.y().b() != null) {
                    this.f52159a.mView.y().b().F();
                } else if (i2 == ReplyPrivacyCheckController.TYPE_EMOTION_IMAGE) {
                    FoldCommentActivity foldCommentActivity = this.f52159a;
                    foldCommentActivity.sendEmotion(foldCommentActivity.mEmotionImageData);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class s implements PbFragment.b3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FoldCommentActivity f52160a;

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
            this.f52160a = foldCommentActivity;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.b3
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!b.a.e.e.p.j.z()) {
                    this.f52160a.showToast(b.a.r0.k2.l.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                this.f52160a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.f52160a.getPageContext().getPageActivity(), this.f52160a.mModel.P0().l().getId(), this.f52160a.mModel.P0().l().getName(), this.f52160a.mModel.P0().O().f0(), String.valueOf(this.f52160a.mModel.P0().U().getUserId()), objArr.length > 1 ? String.valueOf(objArr[1]) : "", objArr.length > 3 ? String.valueOf(objArr[3]) : "", objArr.length > 2 ? String.valueOf(objArr[2]) : "", objArr.length > 4 ? String.valueOf(objArr[4]) : "")));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class t implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FoldCommentActivity f52161a;

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
            this.f52161a = foldCommentActivity;
        }

        @Override // b.a.r0.k2.s.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // b.a.r0.k2.s.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent)) == null) {
                if (view != null) {
                    if (view.getId() == b.a.r0.k2.i.richText) {
                        if (this.f52161a.richTextHandleSingleTap(view)) {
                            return true;
                        }
                    } else if (view.getId() == b.a.r0.k2.i.pb_floor_item_layout) {
                        if (view.getTag(b.a.r0.k2.i.tag_from) instanceof SparseArray) {
                            this.f52161a.startSubPbActivity((SparseArray) view.getTag(b.a.r0.k2.i.tag_from));
                        }
                    } else if ((view instanceof TbRichTextView) || view.getId() == b.a.r0.k2.i.pb_post_header_layout) {
                        SparseArray sparseArray = view.getTag() instanceof SparseArray ? (SparseArray) view.getTag() : null;
                        if (sparseArray == null) {
                            return false;
                        }
                        this.f52161a.startSubPbActivity(sparseArray);
                    }
                }
                if (this.f52161a.mPbEditor != null) {
                    this.f52161a.mView.W(this.f52161a.mPbEditor.D());
                }
                this.f52161a.mView.R();
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // b.a.r0.k2.s.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class u implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FoldCommentActivity f52162e;

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
            this.f52162e = foldCommentActivity;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) ? this.f52162e.dealLongClickListener(view) : invokeL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class v implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FoldCommentActivity f52163e;

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
            this.f52163e = foldCommentActivity;
        }

        @Override // b.a.q0.s.s.i.e
        public void onItemClick(b.a.q0.s.s.i iVar, int i2, View view) {
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                if (this.f52163e.mLongClickDialog != null) {
                    this.f52163e.mLongClickDialog.dismiss();
                }
                this.f52163e.trackDialogItem(i2);
                int i3 = 4;
                switch (i2) {
                    case -4:
                        View view2 = (View) ((SparseArray) view.getTag()).get(b.a.r0.k2.i.pb_dialog_item_share);
                        this.f52163e.putTrackTagToPerformView(view2);
                        if (view2 != null) {
                            view2.performClick();
                            return;
                        }
                        return;
                    case -3:
                        View view3 = (View) ((SparseArray) view.getTag()).get(b.a.r0.k2.i.pb_dialog_item_reply);
                        this.f52163e.putTrackTagToPerformView(view3);
                        if (view3 != null) {
                            view3.performClick();
                            return;
                        }
                        return;
                    case -2:
                        View view4 = (View) ((SparseArray) view.getTag()).get(b.a.r0.k2.i.pb_dialog_item_zan_2);
                        if (view4 != null) {
                            AgreeView agreeView = (AgreeView) view4;
                            this.f52163e.putTrackTagToPerformView(view4);
                            if (agreeView.getImgDisagree() != null) {
                                agreeView.getImgDisagree().performClick();
                                return;
                            }
                            return;
                        }
                        return;
                    case -1:
                        View view5 = (View) ((SparseArray) view.getTag()).get(b.a.r0.k2.i.pb_dialog_item_zan_2);
                        if (view5 != null) {
                            this.f52163e.putTrackTagToPerformView(view5);
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
                        if (this.f52163e.mSaveBdImage == null || TextUtils.isEmpty(this.f52163e.mSaveImageUrl)) {
                            return;
                        }
                        if (this.f52163e.mEmotionInfo == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.f52163e.mSaveImageUrl));
                        } else {
                            d.a aVar = new d.a();
                            aVar.f11986a = this.f52163e.mSaveImageUrl;
                            String str = "";
                            if (this.f52163e.mEmotionInfo.memeInfo.pck_id.intValue() >= 0) {
                                str = "" + this.f52163e.mEmotionInfo.memeInfo.pck_id;
                            }
                            aVar.f11987b = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                        }
                        this.f52163e.mSaveBdImage = null;
                        this.f52163e.mSaveImageUrl = null;
                        return;
                    case 2:
                        if (this.f52163e.mSaveBdImage == null || TextUtils.isEmpty(this.f52163e.mSaveImageUrl)) {
                            return;
                        }
                        if (this.f52163e.mPermissionJudgement == null) {
                            this.f52163e.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        this.f52163e.mPermissionJudgement.clearRequestPermissionList();
                        this.f52163e.mPermissionJudgement.appendRequestPermission(this.f52163e.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.f52163e.mPermissionJudgement.startRequestPermission(this.f52163e.getPageContext().getPageActivity())) {
                            return;
                        }
                        if (this.f52163e.mSaveImageHelper == null) {
                            FoldCommentActivity foldCommentActivity = this.f52163e;
                            foldCommentActivity.mSaveImageHelper = new w0(foldCommentActivity.getPageContext());
                        }
                        this.f52163e.mSaveImageHelper.b(this.f52163e.mSaveImageUrl, this.f52163e.mSaveBdImage.n());
                        this.f52163e.mSaveBdImage = null;
                        this.f52163e.mSaveImageUrl = null;
                        return;
                    case 3:
                        FoldCommentActivity foldCommentActivity2 = this.f52163e;
                        PostData postData = foldCommentActivity2.postData;
                        if (postData != null) {
                            postData.l0(foldCommentActivity2.getPageContext().getPageActivity());
                            this.f52163e.postData = null;
                            return;
                        }
                        return;
                    case 4:
                        TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                        if (this.f52163e.checkUpIsLogin()) {
                            this.f52163e.markFloor(view);
                            if (this.f52163e.mModel.P0().O() == null || this.f52163e.mModel.P0().O().J() == null || this.f52163e.mModel.P0().O().J().getUserId() == null || this.f52163e.mMarkModel == null) {
                                return;
                            }
                            FoldCommentActivity foldCommentActivity3 = this.f52163e;
                            int threadType = foldCommentActivity3.getThreadType(foldCommentActivity3.mModel.P0());
                            d2 O = this.f52163e.mModel.P0().O();
                            if (O.M1()) {
                                i3 = 2;
                            } else if (O.P1()) {
                                i3 = 3;
                            } else if (!O.N1()) {
                                i3 = O.O1() ? 5 : 1;
                            }
                            TiebaStatic.log(new StatisticItem("c12526").param("tid", this.f52163e.mModel.f1()).param("obj_locate", 2).param("obj_id", this.f52163e.mModel.P0().O().J().getUserId()).param("obj_type", !this.f52163e.mMarkModel.e()).param("obj_source", threadType).param("obj_param1", i3));
                            return;
                        }
                        return;
                    case 5:
                        if (!b.a.e.e.p.j.z()) {
                            this.f52163e.showToast(b.a.r0.k2.l.network_not_available);
                            return;
                        }
                        Object tag = view.getTag();
                        if (tag instanceof String) {
                            TiebaStatic.log(new StatisticItem("c13079"));
                            this.f52163e.handleReportClicked((String) tag);
                            return;
                        } else if (tag instanceof SparseArray) {
                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                            SparseArray<Object> sparseArray2 = (SparseArray) tag;
                            if ((sparseArray2.get(b.a.r0.k2.i.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(b.a.r0.k2.i.tag_user_mute_visible)).booleanValue()) {
                                sparseArray2.put(b.a.r0.k2.i.tag_from, 0);
                                sparseArray2.put(b.a.r0.k2.i.tag_check_mute_from, 2);
                                this.f52163e.checkMuteState(sparseArray2);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    case 6:
                        SparseArray sparseArray3 = (SparseArray) view.getTag();
                        if (sparseArray3 != null && (sparseArray3.get(b.a.r0.k2.i.tag_del_post_type) instanceof Integer) && (sparseArray3.get(b.a.r0.k2.i.tag_del_post_id) instanceof String) && (sparseArray3.get(b.a.r0.k2.i.tag_manage_user_identity) instanceof Integer) && (sparseArray3.get(b.a.r0.k2.i.tag_del_post_is_self) instanceof Boolean) && (sparseArray3.get(b.a.r0.k2.i.tag_has_sub_post) instanceof Boolean)) {
                            boolean booleanValue = ((Boolean) sparseArray3.get(b.a.r0.k2.i.tag_del_post_is_self)).booleanValue();
                            int intValue = ((Integer) sparseArray3.get(b.a.r0.k2.i.tag_manage_user_identity)).intValue();
                            boolean booleanValue2 = ((Boolean) sparseArray3.get(b.a.r0.k2.i.tag_has_sub_post)).booleanValue();
                            boolean isHost = this.f52163e.isHost(TbadkCoreApplication.getCurrentAccount());
                            if (isHost) {
                                if (!booleanValue2) {
                                    this.f52163e.showDelNoSubPostDialog(sparseArray3, intValue, booleanValue);
                                    return;
                                } else {
                                    this.f52163e.mView.N(((Integer) sparseArray3.get(b.a.r0.k2.i.tag_del_post_type)).intValue(), (String) sparseArray3.get(b.a.r0.k2.i.tag_del_post_id), intValue, booleanValue, null, isHost);
                                    return;
                                }
                            } else if (booleanValue && !booleanValue2) {
                                this.f52163e.showDelNoSubPostDialog(sparseArray3, intValue, booleanValue);
                                return;
                            } else {
                                this.f52163e.mView.L(((Integer) sparseArray3.get(b.a.r0.k2.i.tag_del_post_type)).intValue(), (String) sparseArray3.get(b.a.r0.k2.i.tag_del_post_id), intValue, booleanValue);
                                return;
                            }
                        }
                        return;
                    case 7:
                        if (!b.a.e.e.p.j.z()) {
                            this.f52163e.showToast(b.a.r0.k2.l.network_not_available);
                            return;
                        }
                        SparseArray<Object> sparseArray4 = (SparseArray) view.getTag();
                        if (sparseArray4 == null) {
                            return;
                        }
                        boolean booleanValue3 = ((Boolean) sparseArray4.get(b.a.r0.k2.i.tag_should_manage_visible)).booleanValue();
                        boolean booleanValue4 = ((Boolean) sparseArray4.get(b.a.r0.k2.i.tag_should_delete_visible)).booleanValue();
                        boolean booleanValue5 = ((Boolean) sparseArray4.get(b.a.r0.k2.i.tag_user_mute_visible)).booleanValue();
                        if (!booleanValue3) {
                            if (booleanValue4) {
                                this.f52163e.mView.L(((Integer) sparseArray4.get(b.a.r0.k2.i.tag_del_post_type)).intValue(), (String) sparseArray4.get(b.a.r0.k2.i.tag_del_post_id), ((Integer) sparseArray4.get(b.a.r0.k2.i.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(b.a.r0.k2.i.tag_del_post_is_self)).booleanValue());
                                return;
                            }
                            return;
                        } else if (booleanValue5) {
                            sparseArray4.put(b.a.r0.k2.i.tag_from, 1);
                            sparseArray4.put(b.a.r0.k2.i.tag_check_mute_from, 2);
                            this.f52163e.checkMuteState(sparseArray4);
                            return;
                        } else {
                            sparseArray4.put(b.a.r0.k2.i.tag_check_mute_from, 2);
                            this.f52163e.mView.P(view);
                            return;
                        }
                    case 8:
                        if (this.f52163e.checkUpIsLogin() && (sparseArray = (SparseArray) view.getTag()) != null) {
                            PostData postData2 = (PostData) sparseArray.get(b.a.r0.k2.i.tag_clip_board);
                            if (postData2.q() == null) {
                                return;
                            }
                            this.f52163e.clickOnDisagree(postData2.q());
                            return;
                        }
                        return;
                    case 9:
                        if (!this.f52163e.checkUpIsLogin() || this.f52163e.mModel == null || this.f52163e.mModel.P0() == null) {
                            return;
                        }
                        this.f52163e.showBlockDialog(b.a.r0.v3.a.b(view));
                        return;
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class w implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SparseArray f52164e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f52165f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f52166g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ FoldCommentActivity f52167h;

        public w(FoldCommentActivity foldCommentActivity, SparseArray sparseArray, int i2, boolean z) {
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
            this.f52167h = foldCommentActivity;
            this.f52164e = sparseArray;
            this.f52165f = i2;
            this.f52166g = z;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (aVar != null) {
                    aVar.dismiss();
                }
                this.f52167h.deleteThreadDirect(((Integer) this.f52164e.get(b.a.r0.k2.i.tag_del_post_type)).intValue(), (String) this.f52164e.get(b.a.r0.k2.i.tag_del_post_id), this.f52165f, this.f52166g);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class x implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FoldCommentActivity f52168e;

        public x(FoldCommentActivity foldCommentActivity) {
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
            this.f52168e = foldCommentActivity;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
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
        this.mReplyFloorLocation = new int[2];
        this.mMarkModel = null;
        this.mLoadPbCallback = new k(this);
        this.imgIndex = 0;
        this.mOnImageClickListener = new q(this);
        this.index_valid = false;
        this.mTbGestureDetector = new b.a.r0.k2.s.c(new t(this));
        this.mOnLongClickListener = new u(this);
        this.postData = null;
        this.onLongClickItemClickListener = new v(this);
        this.mForumManageCallBack = new a(this);
        this.mPrePostCallBack = new e(this);
        this.mDraftLoadListener = new f(this, 2004008);
        this.mOnFloorPostWriteNewCallback = new g(this);
        this.showTrisectionAndFeedback = b.a.q0.b.d.m0();
        this.mCommonOnClickListener = new j(this);
        this.mCheckSubFloorCallBack = new n(this);
        this.mMarkDoneCallBack = new p(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addCollectionStat() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65582, this) == null) || (pbModel = this.mModel) == null || pbModel.P0() == null || this.mModel.P0().O() == null) {
            return;
        }
        d2 O = this.mModel.P0().O();
        O.Z0 = this.mModel.U0();
        O.Y0 = this.mModel.X0();
        O.X0 = this.mModel.W0();
        O.a1 = this.mModel.V0();
        O.H2 = this.mModel.D0();
        if (O.T() == 0) {
            O.E3(b.a.e.e.m.b.g(this.mModel.getForumId(), 0L));
        }
        StatisticItem i2 = b.a.q0.n0.c.i(this, O, "c13562");
        TbPageTag l2 = b.a.q0.n0.c.l(this);
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

    private void addTopAgreeData(b.a.r0.k2.r.f fVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65583, this, fVar, arrayList) == null) || fVar == null || fVar.T() == null || fVar.T().f18820a == null || (list = fVar.T().f18820a) == null || arrayList == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65584, this)) == null) {
            PbModel pbModel = this.mModel;
            if (pbModel == null || pbModel.P0() == null) {
                return false;
            }
            return AntiHelper.b(getPageContext(), this.mModel.P0().O()) || AntiHelper.d(getPageContext(), this.mModel.P0().d());
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void clickOnDisagree(AgreeData agreeData) {
        b.a.q0.m0.c k2;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65585, this, agreeData) == null) || agreeData == null) {
            return;
        }
        if (this.mMessageHelper == null) {
            this.mMessageHelper = new b.a.q0.s.c0.a();
        }
        if (this.mMsgData == null) {
            b.a.r0.l3.j0.e eVar = new b.a.r0.l3.j0.e();
            this.mMsgData = eVar;
            eVar.f20601a = getUniqueId();
        }
        b.a.q0.s.q.f fVar = new b.a.q0.s.q.f();
        fVar.f13300b = 5;
        fVar.f13306h = 8;
        fVar.f13305g = 2;
        PbModel pbModel2 = this.mModel;
        if (pbModel2 != null) {
            fVar.f13304f = pbModel2.O0();
        }
        fVar.f13299a = 2;
        int i2 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                fVar.f13307i = 0;
                k2 = TbPageExtraHelper.k(this);
                if (k2 != null) {
                    agreeData.objSource = k2.a();
                }
                this.mMessageHelper.c(agreeData, i2, getUniqueId(), false);
                this.mMessageHelper.d(agreeData, this.mMsgData);
                pbModel = this.mModel;
                if (pbModel != null || pbModel.P0() == null) {
                }
                this.mMessageHelper.b(this, fVar, agreeData, this.mModel.P0().O());
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            fVar.f13307i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            fVar.f13307i = 1;
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
        if (interceptable == null || interceptable.invokeV(65586, this) == null) {
            if (this.mModel.v0() || this.mModel.y0()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", this.mModel.f1());
                setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.mModel.f1()));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dealLongClickListener(View view) {
        InterceptResult invokeL;
        SparseArray sparseArray;
        b.a.q0.i.a aVar;
        boolean z;
        List<b.a.q0.s.s.f> b2;
        b.a.q0.s.s.f fVar;
        b.a.q0.s.s.f fVar2;
        b.a.q0.s.s.f fVar3;
        b.a.e.l.d.a aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65587, this, view)) == null) {
            try {
                sparseArray = (SparseArray) view.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null) {
                return true;
            }
            PostData postData = (PostData) sparseArray.get(b.a.r0.k2.i.tag_clip_board);
            this.postData = postData;
            if (postData == null || (aVar = this.mMarkModel) == null) {
                return true;
            }
            if (aVar.e() && this.postData.G() != null) {
                this.postData.G().equals(this.mModel.K0());
            }
            if (this.mPopupDialogView == null) {
                b.a.q0.s.s.i iVar = new b.a.q0.s.s.i(this);
                this.mPopupDialogView = iVar;
                iVar.m(this.onLongClickItemClickListener);
            }
            ArrayList arrayList = new ArrayList();
            if (view == null || sparseArray == null) {
                return true;
            }
            boolean isImage = isImage(view);
            boolean z2 = (!isImage(view) || (aVar2 = this.mSaveBdImage) == null || aVar2.t()) ? false : true;
            boolean booleanValue = sparseArray.get(b.a.r0.k2.i.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_is_subpb)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(b.a.r0.k2.i.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_del_post_is_self)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(b.a.r0.k2.i.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue4 = sparseArray.get(b.a.r0.k2.i.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue5 = sparseArray.get(b.a.r0.k2.i.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue6 = sparseArray.get(b.a.r0.k2.i.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_should_delete_visible)).booleanValue() : false;
            String str = sparseArray.get(b.a.r0.k2.i.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(b.a.r0.k2.i.tag_forbid_user_post_id) : null;
            boolean booleanValue7 = sparseArray.get(b.a.r0.k2.i.tag_is_self_post) instanceof Boolean ? ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_is_self_post)).booleanValue() : false;
            if (isImage) {
                z = booleanValue;
                arrayList.add(new b.a.q0.s.s.f(1, getString(b.a.r0.k2.l.save_to_emotion), this.mPopupDialogView));
            } else {
                z = booleanValue;
            }
            if (z2) {
                arrayList.add(new b.a.q0.s.s.f(2, getString(b.a.r0.k2.l.save_to_local), this.mPopupDialogView));
            }
            if (!isImage && !z2) {
                b.a.q0.s.s.f fVar4 = new b.a.q0.s.s.f(3, getString(b.a.r0.k2.l.copy), this.mPopupDialogView);
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(b.a.r0.k2.i.tag_clip_board, this.postData);
                fVar4.f13556d.setTag(sparseArray2);
                arrayList.add(fVar4);
            }
            if (this.mIsLogin) {
                if (!b.a.r0.k2.u.f.f1.a.h(this.mModel) && !booleanValue4 && booleanValue3) {
                    b.a.q0.s.s.f fVar5 = new b.a.q0.s.s.f(5, getString(b.a.r0.k2.l.mute_option), this.mPopupDialogView);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(b.a.r0.k2.i.tag_user_mute_visible, Boolean.TRUE);
                    int i2 = b.a.r0.k2.i.tag_is_mem;
                    sparseArray3.put(i2, sparseArray.get(i2));
                    int i3 = b.a.r0.k2.i.tag_user_mute_mute_userid;
                    sparseArray3.put(i3, sparseArray.get(i3));
                    int i4 = b.a.r0.k2.i.tag_user_mute_mute_username;
                    sparseArray3.put(i4, sparseArray.get(i4));
                    int i5 = b.a.r0.k2.i.tag_user_mute_mute_nameshow;
                    sparseArray3.put(i5, sparseArray.get(i5));
                    int i6 = b.a.r0.k2.i.tag_user_mute_post_id;
                    sparseArray3.put(i6, sparseArray.get(i6));
                    int i7 = b.a.r0.k2.i.tag_user_mute_thread_id;
                    sparseArray3.put(i7, sparseArray.get(i7));
                    int i8 = b.a.r0.k2.i.tag_del_post_is_self;
                    sparseArray3.put(i8, sparseArray.get(i8));
                    int i9 = b.a.r0.k2.i.tag_del_post_type;
                    sparseArray3.put(i9, sparseArray.get(i9));
                    int i10 = b.a.r0.k2.i.tag_del_post_id;
                    sparseArray3.put(i10, sparseArray.get(i10));
                    int i11 = b.a.r0.k2.i.tag_manage_user_identity;
                    sparseArray3.put(i11, sparseArray.get(i11));
                    fVar5.f13556d.setTag(sparseArray3);
                    arrayList.add(fVar5);
                } else {
                    if (isShowReportButton(booleanValue2) && TbadkCoreApplication.isLogin()) {
                        b.a.q0.s.s.f fVar6 = new b.a.q0.s.s.f(5, getString(b.a.r0.k2.l.report_text), this.mPopupDialogView);
                        fVar6.f13556d.setTag(str);
                        arrayList.add(fVar6);
                    }
                }
                if (booleanValue4) {
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(b.a.r0.k2.i.tag_should_manage_visible, Boolean.TRUE);
                    int i12 = b.a.r0.k2.i.tag_manage_user_identity;
                    sparseArray4.put(i12, sparseArray.get(i12));
                    int i13 = b.a.r0.k2.i.tag_forbid_user_name;
                    sparseArray4.put(i13, sparseArray.get(i13));
                    int i14 = b.a.r0.k2.i.tag_forbid_user_name_show;
                    sparseArray4.put(i14, sparseArray.get(i14));
                    int i15 = b.a.r0.k2.i.tag_forbid_user_portrait;
                    sparseArray4.put(i15, sparseArray.get(i15));
                    sparseArray4.put(b.a.r0.k2.i.tag_forbid_user_post_id, str);
                    if (!b.a.r0.k2.u.f.f1.a.h(this.mModel) && booleanValue5) {
                        sparseArray4.put(b.a.r0.k2.i.tag_user_mute_visible, Boolean.TRUE);
                        int i16 = b.a.r0.k2.i.tag_is_mem;
                        sparseArray4.put(i16, sparseArray.get(i16));
                        int i17 = b.a.r0.k2.i.tag_user_mute_mute_userid;
                        sparseArray4.put(i17, sparseArray.get(i17));
                        int i18 = b.a.r0.k2.i.tag_user_mute_mute_username;
                        sparseArray4.put(i18, sparseArray.get(i18));
                        int i19 = b.a.r0.k2.i.tag_user_mute_mute_nameshow;
                        sparseArray4.put(i19, sparseArray.get(i19));
                        int i20 = b.a.r0.k2.i.tag_user_mute_post_id;
                        sparseArray4.put(i20, sparseArray.get(i20));
                        int i21 = b.a.r0.k2.i.tag_user_mute_thread_id;
                        sparseArray4.put(i21, sparseArray.get(i21));
                    } else {
                        sparseArray4.put(b.a.r0.k2.i.tag_user_mute_visible, Boolean.FALSE);
                    }
                    if (booleanValue6) {
                        sparseArray4.put(b.a.r0.k2.i.tag_should_delete_visible, Boolean.TRUE);
                        sparseArray4.put(b.a.r0.k2.i.tag_del_post_is_self, Boolean.valueOf(booleanValue2));
                        int i22 = b.a.r0.k2.i.tag_del_post_id;
                        sparseArray4.put(i22, sparseArray.get(i22));
                        int i23 = b.a.r0.k2.i.tag_del_post_type;
                        sparseArray4.put(i23, sparseArray.get(i23));
                        int i24 = b.a.r0.k2.i.tag_has_sub_post;
                        sparseArray4.put(i24, sparseArray.get(i24));
                        if (booleanValue7) {
                            b.a.q0.s.s.f fVar7 = new b.a.q0.s.s.f(6, getString(b.a.r0.k2.l.delete), this.mPopupDialogView);
                            fVar7.f13556d.setTag(sparseArray4);
                            fVar3 = fVar7;
                            fVar = new b.a.q0.s.s.f(7, getString(b.a.r0.k2.l.bar_manager), this.mPopupDialogView);
                            fVar.f13556d.setTag(sparseArray4);
                            fVar2 = fVar3;
                        }
                    } else {
                        sparseArray4.put(b.a.r0.k2.i.tag_should_delete_visible, Boolean.FALSE);
                    }
                    fVar3 = null;
                    fVar = new b.a.q0.s.s.f(7, getString(b.a.r0.k2.l.bar_manager), this.mPopupDialogView);
                    fVar.f13556d.setTag(sparseArray4);
                    fVar2 = fVar3;
                } else if (booleanValue6) {
                    SparseArray sparseArray5 = new SparseArray();
                    sparseArray5.put(b.a.r0.k2.i.tag_should_manage_visible, Boolean.FALSE);
                    sparseArray5.put(b.a.r0.k2.i.tag_user_mute_visible, Boolean.FALSE);
                    sparseArray5.put(b.a.r0.k2.i.tag_should_delete_visible, Boolean.TRUE);
                    int i25 = b.a.r0.k2.i.tag_manage_user_identity;
                    sparseArray5.put(i25, sparseArray.get(i25));
                    sparseArray5.put(b.a.r0.k2.i.tag_del_post_is_self, Boolean.valueOf(booleanValue2));
                    int i26 = b.a.r0.k2.i.tag_del_post_id;
                    sparseArray5.put(i26, sparseArray.get(i26));
                    int i27 = b.a.r0.k2.i.tag_del_post_type;
                    sparseArray5.put(i27, sparseArray.get(i27));
                    int i28 = b.a.r0.k2.i.tag_has_sub_post;
                    sparseArray5.put(i28, sparseArray.get(i28));
                    if (this.mModel.P0().V() == 1002 && !booleanValue2) {
                        fVar2 = new b.a.q0.s.s.f(6, getString(b.a.r0.k2.l.report_text), this.mPopupDialogView);
                    } else {
                        fVar2 = new b.a.q0.s.s.f(6, getString(b.a.r0.k2.l.delete), this.mPopupDialogView);
                    }
                    fVar2.f13556d.setTag(sparseArray5);
                    fVar = null;
                } else {
                    fVar = null;
                    fVar2 = null;
                }
                if (fVar2 != null) {
                    arrayList.add(fVar2);
                }
                if (fVar != null) {
                    arrayList.add(fVar);
                }
                b.a.r0.k2.u.f.f1.a.a(arrayList, this.mPopupDialogView, this.postData, this.mModel);
            }
            if (b.a.q0.b.d.F()) {
                b2 = b.a.r0.k2.u.f.f1.a.c(arrayList, this.postData.q(), sparseArray, this.mPopupDialogView);
            } else {
                b2 = b.a.r0.k2.u.f.f1.a.b(arrayList, this.postData.q(), sparseArray, this.mPopupDialogView);
            }
            b.a.r0.k2.u.f.f1.a.k(b2, this.isDialogFromLongClick);
            b.a.r0.k2.u.f.f1.a.e(b2);
            this.mPopupDialogView.n(b.a.r0.k2.u.f.f1.a.f(this.postData));
            if (b.a.q0.b.d.F()) {
                this.mPopupDialogView.k(b2, false);
            } else {
                this.mPopupDialogView.k(b2, true);
            }
            PopupDialog popupDialog = new PopupDialog(getPageContext(), this.mPopupDialogView);
            this.mLongClickDialog = popupDialog;
            popupDialog.showDialog();
            TiebaStatic.log(new StatisticItem("c13272").param("tid", this.mModel.f1()).param("fid", this.mModel.getForumId()).param("uid", this.mModel.P0().O().J().getUserId()).param("post_id", this.mModel.y()).param("obj_source", z ? 2 : 1));
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishDelPost(ForumManageModel.b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65588, this, bVar, z) == null) || bVar == null) {
            return;
        }
        String string = !TextUtils.isEmpty(bVar.f54248b) ? bVar.f54248b : getString(b.a.r0.k2.l.delete_fail);
        int i2 = 0;
        if (bVar.f54249c == 1211066) {
            hideProgressBar();
            b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(getPageContext().getPageActivity());
            aVar.setMessage(string);
            aVar.setPositiveButton(b.a.r0.k2.l.dialog_known, new b(this));
            aVar.setCancelable(true);
            aVar.create(getPageContext());
            aVar.show();
        } else if (bVar.f54250d != 0) {
            this.mView.v(0, bVar.f54247a, bVar.f54248b, z);
        }
        if (bVar.f54247a) {
            int i3 = bVar.f54250d;
            if (i3 == 1) {
                ArrayList<PostData> F = this.mModel.P0().F();
                int size = F.size();
                while (true) {
                    if (i2 >= size) {
                        break;
                    } else if (bVar.f54253g.equals(F.get(i2).G())) {
                        F.remove(i2);
                        break;
                    } else {
                        i2++;
                    }
                }
                this.mModel.P0().O().n4(this.mModel.P0().O().U0() - 1);
            } else if (i3 == 0) {
                closeActivityAfterDelPost();
            } else if (i3 == 2) {
                ArrayList<PostData> F2 = this.mModel.P0().F();
                int size2 = F2.size();
                boolean z2 = false;
                for (int i4 = 0; i4 < size2 && !z2; i4++) {
                    int i5 = 0;
                    while (true) {
                        if (i5 >= F2.get(i4).O().size()) {
                            break;
                        } else if (bVar.f54253g.equals(F2.get(i4).O().get(i5).G())) {
                            F2.get(i4).O().remove(i5);
                            F2.get(i4).l();
                            z2 = true;
                            break;
                        } else {
                            i5++;
                        }
                    }
                    F2.get(i4).n(bVar.f54253g);
                }
            }
        }
    }

    private TbRichText getImage(ArrayList<PostData> arrayList, String str, int i2) {
        InterceptResult invokeLLI;
        ArrayList<TbRichTextData> y;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65589, this, arrayList, str, i2)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    TbRichText M = arrayList.get(i3).M();
                    if (M != null && (y = M.y()) != null) {
                        int size = y.size();
                        int i4 = -1;
                        for (int i5 = 0; i5 < size; i5++) {
                            if (y.get(i5) != null && y.get(i5).getType() == 8) {
                                i4++;
                                if (y.get(i5).C().y().equals(str) || y.get(i5).C().z().equals(str)) {
                                    int h2 = (int) b.a.e.e.p.l.h(TbadkCoreApplication.getInst());
                                    int width = y.get(i5).C().getWidth() * h2;
                                    int height = y.get(i5).C().getHeight() * h2;
                                    if (width < 80 || height < 80 || width * height < 10000) {
                                        return null;
                                    }
                                    this.imgIndex = i5;
                                    return M;
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
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65590, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i2), Integer.valueOf(i3), arrayList, concurrentHashMap})) == null) {
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
                        int h2 = (int) b.a.e.e.p.l.h(TbadkCoreApplication.getInst());
                        int width = tbRichTextData.C().getWidth() * h2;
                        int height = tbRichTextData.C().getHeight() * h2;
                        if ((width < 80 || height < 80 || width * height < 10000) || !tbRichTextData.C().D()) {
                            if (tbRichText == tbRichText2) {
                                if (i5 <= i3) {
                                    i4--;
                                }
                            }
                        } else if (tbRichTextData.getType() != 20) {
                            String a2 = b.a.r0.k2.r.g.a(tbRichTextData);
                            if (!TextUtils.isEmpty(a2)) {
                                arrayList.add(a2);
                                if (tbRichTextData != null && (C = tbRichTextData.C()) != null) {
                                    String y = C.y();
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                        imageUrlData.urlType = 38;
                                        y = C.z();
                                    } else {
                                        imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    }
                                    imageUrlData.imageUrl = y;
                                    imageUrlData.originalUrl = getOriginalPic(tbRichTextData);
                                    imageUrlData.originalSize = getOriginalSize(tbRichTextData);
                                    imageUrlData.mIsShowOrigonButton = getIsShowOriginalButton(tbRichTextData);
                                    imageUrlData.isLongPic = getIsLongImg(tbRichTextData);
                                    imageUrlData.postId = tbRichText.getPostId();
                                    imageUrlData.threadId = b.a.e.e.m.b.g(this.mModel.f1(), -1L);
                                    imageUrlData.mIsReserver = this.mModel.a1();
                                    imageUrlData.mIsSeeHost = this.mModel.t0();
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65591, this, tbRichTextData)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65592, this, tbRichTextData)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65593, this, tbRichTextData)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65594, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.C() == null) {
                return 0L;
            }
            return tbRichTextData.C().getOriginalSize();
        }
        return invokeL.longValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getThreadType(b.a.r0.k2.r.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65595, this, fVar)) == null) {
            if (fVar == null || fVar.O() == null) {
                return 0;
            }
            if (fVar.O().o1() == 0) {
                return 1;
            }
            if (fVar.O().o1() == 54) {
                return 2;
            }
            return fVar.O().o1() == 40 ? 3 : 4;
        }
        return invokeL.intValue;
    }

    private void handleFullScreenEditorResult(int i2, Intent intent) {
        b.a.q0.x.n nVar;
        b.a.q0.x.n nVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65596, this, i2, intent) == null) {
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
                    b.a.q0.x.x.h b2 = this.mView.y().b();
                    b2.b0(this.mModel.P0().O());
                    b2.B(writeData);
                    b2.c0(pbEditorData.getVoiceModel());
                    b.a.q0.x.m findToolById = b2.a().findToolById(6);
                    if (findToolById != null && (nVar2 = findToolById.k) != null) {
                        nVar2.onAction(new b.a.q0.x.a(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i2 == -1) {
                        b2.F();
                        return;
                    }
                    return;
                }
                this.mPbEditor.T();
                this.mPbEditor.u0(pbEditorData.getVoiceModel());
                this.mPbEditor.H(writeData);
                b.a.q0.x.m findToolById2 = this.mPbEditor.a().findToolById(6);
                if (findToolById2 != null && (nVar = findToolById2.k) != null) {
                    nVar.onAction(new b.a.q0.x.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i2 == -1) {
                    this.mPbEditor.M(null, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleReportClicked(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65597, this, str) == null) {
            PbModel pbModel = this.mModel;
            if (pbModel != null && pbModel.P0() != null && this.mModel.P0().g0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.mModel.f1(), str);
                d2 O = this.mModel.P0().O();
                if (O.M1()) {
                    format = format + "&channelid=33833";
                } else if (O.R1()) {
                    format = format + "&channelid=33842";
                } else if (O.P1()) {
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
        if (interceptable == null || interceptable.invokeL(65598, this, bundle) == null) {
            this.MESSAGE_ID_PB = getUniqueId();
            b.a.q0.i.a c2 = b.a.q0.i.a.c(this);
            this.mMarkModel = c2;
            if (c2 != null) {
                c2.j(this.mMarkDoneCallBack);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this);
            this.mForumManageModel = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.mForumManageCallBack);
            PbModel pbModel = new PbModel(this);
            this.mModel = pbModel;
            pbModel.n2(true);
            if (bundle != null) {
                this.mModel.initWithBundle(bundle);
            } else {
                this.mModel.initWithIntent(getIntent());
            }
            this.mModel.o2(4);
            this.mModel.i2(this.mLoadPbCallback);
        }
    }

    private void initUI(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65599, this, bundle) == null) {
            this.mPbEventController = new b.a.r0.k2.u.f.c1.a(this);
            this.mPbPostShareController = new b.a.r0.k2.u.f.c1.c(getPageContext());
            b.a.r0.k2.u.d.c cVar = new b.a.r0.k2.u.d.c(this, this.mCommonOnClickListener, this.mOnImageClickListener, this.mTbGestureDetector, this.mOnLongClickListener);
            this.mView = cVar;
            cVar.Y(this.mModel);
            setContentView(this.mView.A(), new FlowLayout.LayoutParams(-1, -1));
            this.mView.A().show();
            adjustResizeForSoftInput();
            addGlobalLayoutListener();
            this.mView.s();
            this.mView.V(new s(this));
            b.a.q0.x.x.g gVar = new b.a.q0.x.x.g();
            this.mPbeb = gVar;
            setPbNormalEditorBuilder(gVar);
            b.a.q0.x.x.e eVar = (b.a.q0.x.x.e) this.mPbeb.a(getActivity());
            this.mPbEditor = eVar;
            eVar.f0(getPageContext());
            this.mPbEditor.p0(this.mPrePostCallBack);
            this.mPbEditor.h0(1);
            this.mPbEditor.G(getPageContext(), bundle);
            this.mPbEditor.a().addHideLauncher(new b.a.q0.x.k(getActivity()));
            this.mPbEditor.a().showLinePositionBottom(true);
            setShowPicBlauncherOutSetVisibilty(true);
            this.mPbEditor.P(this.mModel.s0(), this.mModel.f1(), this.mModel.p0());
            this.mView.T(this.mPbEditor.a());
            this.mContentProcessController = new u0();
            if (this.mPbEditor.v() != null) {
                this.mContentProcessController.m(this.mPbEditor.v().h());
            }
            registerListener(this.mDraftLoadListener);
            if (!this.mModel.D0()) {
                this.mPbEditor.s(this.mModel.f1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.mPbEditor.l0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.mModel.r1()) {
                this.mPbEditor.l0(getPageContext().getString(b.a.r0.k2.l.pb_reply_hint_from_smart_frs));
            } else {
                b.a.r0.k2.u.d.c cVar2 = this.mView;
                if (cVar2 != null) {
                    this.mPbEditor.l0(cVar2.z());
                }
            }
            this.mShareSuccessReplyToServerModel = new ShareSuccessReplyToServerModel();
        }
    }

    private boolean isFromTopicDetailPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65600, this)) == null) {
            PbModel pbModel = this.mModel;
            return pbModel != null && pbModel.O0() == 17;
        }
        return invokeV.booleanValue;
    }

    private boolean isShowReportButton(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65601, this, z)) == null) {
            PbModel pbModel = this.mModel;
            if (pbModel != null && pbModel.P0() != null) {
                return ((this.mModel.P0().V() != 0) || this.mModel.P0().O() == null || this.mModel.P0().O().J() == null || TextUtils.equals(this.mModel.P0().O().J().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    private void jumpToWeb(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65602, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this, "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    private void loadData() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65603, this) == null) || (pbModel = this.mModel) == null) {
            return;
        }
        pbModel.H1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void locateSubPbEditor(View view, String str, String str2, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65604, this, view, str, str2, postData) == null) || view == null || str == null || str2 == null || !checkPrivacyBeforeInput()) {
            return;
        }
        if (view.getParent() instanceof View) {
            ((View) view.getParent()).getLocationOnScreen(this.mReplyFloorLocation);
            this.mReplyFloorMeasureHeight = ((View) view.getParent()).getMeasuredHeight();
        }
        if (this.mView.y() != null && postData != null) {
            this.mView.y().j(String.format(TbadkCoreApplication.getInst().getResources().getString(b.a.r0.k2.l.reply_title), postData.t().getName_show(), postData.M() != null ? postData.M().toString() : ""));
        }
        if (this.mModel.P0() != null && this.mModel.P0().g0()) {
            b.a.e.e.m.e.a().postDelayed(new l(this, str, str2), 0L);
            return;
        }
        if (this.mSubReplyPermissionController == null) {
            b.a.r0.x0.q2.a.c cVar = new b.a.r0.x0.q2.a.c(getPageContext());
            this.mSubReplyPermissionController = cVar;
            cVar.j(1);
            this.mSubReplyPermissionController.i(new m(this, str, str2));
        }
        PbModel pbModel = this.mModel;
        if (pbModel == null || pbModel.P0() == null || this.mModel.P0().l() == null) {
            return;
        }
        this.mSubReplyPermissionController.g(this.mModel.P0().l().getId(), b.a.e.e.m.b.g(this.mModel.f1(), 0L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void makeFakeMark() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65605, this) == null) {
            b.a.r0.k2.r.f P0 = this.mModel.P0();
            this.mModel.r2(true);
            b.a.q0.i.a aVar = this.mMarkModel;
            if (aVar != null) {
                P0.E0(aVar.g());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void markFloor(View view) {
        SparseArray sparseArray;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65606, this, view) == null) {
            try {
                sparseArray = (SparseArray) view.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (postData = (PostData) sparseArray.get(b.a.r0.k2.i.tag_clip_board)) == null) {
                return;
            }
            markFloor(postData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onNetOrDataError(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65607, this, i2, str) == null) {
            if (this.mModel.m1()) {
                showToast(str);
            } else if (!b.a.e.e.p.l.D()) {
                this.mView.f0(b.a.r0.k2.l.recommend_pb_no_net_text);
            } else if (i2 == 4) {
                b.a.r0.k2.u.d.c cVar = this.mView;
                cVar.g0(str + "(4" + SmallTailInfo.EMOTION_SUFFIX, true);
            } else if (!TextUtils.isEmpty(str)) {
                b.a.r0.k2.u.d.c cVar2 = this.mView;
                cVar2.g0(str + "(" + i2 + SmallTailInfo.EMOTION_SUFFIX, true);
            } else {
                this.mView.f0(b.a.r0.k2.l.no_data_text);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processImgUrls(String str, int i2, AbsPbActivity.e eVar) {
        TbRichTextData tbRichTextData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65608, this, str, i2, eVar) == null) || eVar == null) {
            return;
        }
        b.a.r0.k2.r.f P0 = this.mModel.P0();
        TbRichText validImage = validImage(str, i2);
        if (validImage == null || (tbRichTextData = validImage.y().get(this.imgIndex)) == null) {
            return;
        }
        eVar.f52188f = String.valueOf(validImage.getPostId());
        eVar.f52183a = new ArrayList<>();
        eVar.f52184b = new ConcurrentHashMap<>();
        if (!tbRichTextData.C().D()) {
            eVar.f52190h = false;
            String a2 = b.a.r0.k2.r.g.a(tbRichTextData);
            eVar.f52183a.add(a2);
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
            imageUrlData.mIsReserver = this.mModel.a1();
            imageUrlData.mIsSeeHost = this.mModel.t0();
            eVar.f52184b.put(a2, imageUrlData);
            if (P0 != null) {
                if (P0.l() != null) {
                    eVar.f52185c = P0.l().getName();
                    eVar.f52186d = P0.l().getId();
                }
                if (P0.O() != null) {
                    eVar.f52187e = P0.O().f0();
                }
                eVar.f52189g = P0.s() == 1;
            }
            imageUrlData.threadId = b.a.e.e.m.b.g(eVar.f52187e, -1L);
            return;
        }
        eVar.f52190h = true;
        int size = P0.F().size();
        this.index_valid = false;
        eVar.j = -1;
        int imageIndex = P0.j() != null ? getImageIndex(P0.j().M(), validImage, i2, i2, eVar.f52183a, eVar.f52184b) : i2;
        for (int i3 = 0; i3 < size; i3++) {
            PostData postData = P0.F().get(i3);
            if (postData.G() == null || P0.j() == null || P0.j().G() == null || !postData.G().equals(P0.j().G())) {
                imageIndex = getImageIndex(postData.M(), validImage, imageIndex, i2, eVar.f52183a, eVar.f52184b);
            }
        }
        if (eVar.f52183a.size() > 0) {
            ArrayList<String> arrayList = eVar.f52183a;
            eVar.f52191i = arrayList.get(arrayList.size() - 1);
        }
        if (P0 != null) {
            if (P0.l() != null) {
                eVar.f52185c = P0.l().getName();
                eVar.f52186d = P0.l().getId();
            }
            if (P0.O() != null) {
                eVar.f52187e = P0.O().f0();
            }
            eVar.f52189g = P0.s() == 1;
        }
        eVar.j = imageIndex;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AbsPbActivity.e processSubPbImg(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65609, this, str)) == null) {
            String str2 = null;
            if (this.mModel.P0() != null && this.mModel.P0().F() != null && this.mModel.P0().F().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i2 = 0;
                while (true) {
                    if (i2 >= this.mModel.P0().F().size()) {
                        i2 = 0;
                        break;
                    } else if (str.equals(this.mModel.P0().F().get(i2).G())) {
                        break;
                    } else {
                        i2++;
                    }
                }
                PostData postData = this.mModel.P0().F().get(i2);
                if (postData.M() != null && postData.M().y() != null) {
                    Iterator<TbRichTextData> it = postData.M().y().iterator();
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
                    b.a.r0.k2.r.g.b(postData, eVar);
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
        if (!(interceptable == null || interceptable.invokeL(65610, this, view) == null) || view == null) {
            return;
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(b.a.r0.k2.i.pb_track_more_obj_source, Integer.valueOf(this.isDialogFromLongClick ? 2 : 3));
        view.setTag(sparseArray);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean richTextHandleSingleTap(View view) {
        InterceptResult invokeL;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65611, this, view)) == null) {
            if (view != null && (view.getTag() instanceof SparseArray)) {
                Object obj = ((SparseArray) view.getTag()).get(b.a.r0.k2.i.tag_clip_board);
                if (obj instanceof PostData) {
                    PostData postData = (PostData) obj;
                    if (checkUpIsLogin() && (pbModel = this.mModel) != null && pbModel.P0() != null) {
                        if (this.mView.y() != null) {
                            this.mView.y().c();
                        }
                        b.a.r0.k2.r.s sVar = new b.a.r0.k2.r.s();
                        sVar.A(this.mModel.P0().l());
                        sVar.E(this.mModel.P0().O());
                        sVar.C(postData);
                        TiebaStatic.log("c11743");
                        this.mView.x().S(sVar);
                        this.mView.x().setPostId(postData.G());
                        locateSubPbEditor(view, postData.t().getUserId(), "", postData);
                        b.a.q0.x.x.e eVar = this.mPbEditor;
                        if (eVar != null) {
                            this.mView.W(eVar.D());
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
        if (!(interceptable == null || interceptable.invokeL(65612, this, emotionImageData) == null) || emotionImageData == null) {
            return;
        }
        if (this.mReplyEmotionModel == null) {
            b.a.r0.k2.u.f.b1.f.a aVar = new b.a.r0.k2.u.f.b1.f.a(this);
            this.mReplyEmotionModel = aVar;
            aVar.n(this.mPrePostCallBack);
        }
        b.a.r0.k2.u.f.b1.f.a aVar2 = this.mReplyEmotionModel;
        PbModel pbModel = this.mModel;
        aVar2.k(emotionImageData, pbModel, pbModel.P0());
    }

    private void setPbNormalEditorBuilder(b.a.q0.x.x.g gVar) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65613, this, gVar) == null) || gVar == null || (pbModel = this.mModel) == null) {
            return;
        }
        gVar.p(pbModel.q0());
        if (this.mModel.P0() != null && this.mModel.P0().l() != null) {
            gVar.o(this.mModel.P0().l());
        }
        gVar.q("pb");
        gVar.r(this.mModel);
    }

    private void setShowPicBlauncherOutSetVisibilty(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65614, this, z) == null) {
            this.mPbEditor.g0(z);
            this.mPbEditor.j0(z);
            this.mPbEditor.q0(z);
        }
    }

    private void showAntiInfo(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65615, this, antiData, postWriteCallBackData) == null) || antiData == null || postWriteCallBackData == null) {
            return;
        }
        if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
            if (this.mView != null) {
                String errorString = postWriteCallBackData.getErrorString();
                String preMsg = postWriteCallBackData.getPreMsg();
                String colorMsg = postWriteCallBackData.getColorMsg();
                if (postWriteCallBackData.getIconStampData() != null) {
                    b.a.q0.t.h.b.a(getPageContext(), postWriteCallBackData);
                    return;
                } else {
                    b.a.r0.l3.s0.m.b(getPageContext().getPageActivity(), errorString, preMsg, colorMsg);
                    return;
                }
            }
            return;
        }
        if (!this.mModel.D0()) {
            antiData.setBlock_forum_name(this.mModel.P0().l().getName());
            antiData.setBlock_forum_id(this.mModel.P0().l().getId());
            antiData.setUser_name(this.mModel.P0().U().getUserName());
            antiData.setUser_id(this.mModel.P0().U().getUserId());
        }
        AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDelNoSubPostDialog(SparseArray<Object> sparseArray, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65616, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            b.a.r0.k2.u.f.f1.a.d(getActivity(), getPageContext(), new w(this, sparseArray, i2, z), new x(this));
        }
    }

    private void showUserMuteDialog(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65617, this, new Object[]{Boolean.valueOf(z), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z) {
                this.mView.d0();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this);
            if (b.a.e.e.p.k.isEmpty(str)) {
                aVar.setMessage(getResources().getString(b.a.r0.k2.l.block_mute_message_alert, str3));
            } else {
                aVar.setMessage(str);
            }
            aVar.setPositiveButton(b.a.r0.k2.l.confirm, new c(this, userMuteAddAndDelCustomMessage));
            aVar.setNegativeButton(b.a.r0.k2.l.cancel, new d(this));
            aVar.create(getPageContext()).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSubPbActivity(PostData postData, boolean z) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65619, this, postData, z) == null) || postData == null || (pbModel = this.mModel) == null || pbModel.P0() == null || postData.A() == 1) {
            return;
        }
        String f1 = this.mModel.f1();
        String G = postData.G();
        int V = this.mModel.P0() != null ? this.mModel.P0().V() : 0;
        AbsPbActivity.e processSubPbImg = processSubPbImg(G);
        if (processSubPbImg == null) {
            return;
        }
        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this).createSubPbActivityConfig(f1, G, "pb", true, false, null, false, null, V, postData.R(), this.mModel.P0().d(), false, postData.t() != null ? postData.t().getIconInfo() : null, 5).addBigImageData(processSubPbImg.f52183a, processSubPbImg.f52184b, processSubPbImg.f52189g, processSubPbImg.j);
        addBigImageData.setKeyPageStartFrom(this.mModel.O0());
        addBigImageData.setFromFrsForumId(this.mModel.getFromForumId());
        addBigImageData.setWorksInfoData(this.mModel.k1());
        addBigImageData.setKeyFromForumId(this.mModel.getForumId());
        addBigImageData.setBjhData(this.mModel.j0());
        addBigImageData.setIsOpenEditor(z);
        addBigImageData.setFromFoldComment(true);
        sendMessage(new CustomMessage(2002001, addBigImageData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopVoice() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65620, this) == null) || (voiceManager = this.mVoiceManager) == null) {
            return;
        }
        voiceManager.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackDialogItem(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65621, this, i2) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.mModel.f1()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(b.a.r0.k2.u.f.f1.a.m(i2))));
        }
    }

    private void tryAddexperienced() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65622, this) == null) && TbadkCoreApplication.isLogin() && AddExperiencedModel.B(this.mModel.getForumId()) && this.mModel.P0() != null && this.mModel.P0().l() != null) {
            if (this.mModel.P0().l().isLike() == 1) {
                this.mModel.e0().A(this.mModel.getForumId(), this.mModel.f1());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText validImage(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65623, this, str, i2)) == null) {
            PbModel pbModel = this.mModel;
            TbRichText tbRichText = null;
            if (pbModel == null || pbModel.P0() == null || str == null || i2 < 0) {
                return null;
            }
            b.a.r0.k2.r.f P0 = this.mModel.P0();
            if (P0.j() != null) {
                ArrayList<PostData> arrayList = new ArrayList<>();
                arrayList.add(P0.j());
                tbRichText = getImage(arrayList, str, i2);
            }
            if (tbRichText == null) {
                ArrayList<PostData> F = P0.F();
                addTopAgreeData(P0, F);
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
            userMuteCheckCustomMessage.userIdF = b.a.e.e.m.b.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = b.a.e.e.m.b.g((String) sparseArray.get(b.a.r0.k2.i.tag_user_mute_mute_userid), 0L);
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
            if ((this.mModel.P0() != null && (this.mModel.P0().g0() || ThreadCardUtils.isSelf(this.mModel.P0().O()))) || this.mReplyPrivacyController == null || this.mModel.P0() == null || this.mModel.P0().d() == null) {
                return true;
            }
            return this.mReplyPrivacyController.checkPrivacyBeforeInvokeEditor(this.mModel.P0().d().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public boolean checkPrivacyBeforePost(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (this.mReplyPrivacyController == null || this.mModel.P0() == null || ThreadCardUtils.isSelf(this.mModel.P0().O()) || this.mModel.P0().d() == null) {
                return true;
            }
            return this.mReplyPrivacyController.checkPrivacyBeforeSend(this.mModel.P0().d().replyPrivateFlag, i2);
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.t
    public void decorateText(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048580, this, spannableStringBuilder, textView, tbRichTextView) == null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains(PB_LITERATURE_LOOK_MORE_ICON_SUFFIX)) {
            return;
        }
        Object[] objArr = (b.a.q0.f1.n.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), b.a.q0.f1.n.f.class);
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (x0.c(objArr[i2].d()) && (drawable = SkinManager.getDrawable(b.a.r0.k2.h.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(PB_LITERATURE_LOOK_MORE_ICON_SUFFIX);
                spannableStringBuilder2.setSpan(new b.a.q0.f1.d(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i2], spannableStringBuilder.getSpanStart(objArr[i2]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    public void deleteThread(b.a.q0.s.s.a aVar, JSONArray jSONArray) {
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
            sparseArray.put(b.a.r0.k2.i.tag_del_post_id, str);
            sparseArray.put(b.a.r0.k2.i.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(b.a.r0.k2.i.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(b.a.r0.k2.i.tag_del_post_is_self, Boolean.valueOf(z));
            sparseArray.put(s0.W1, Integer.valueOf(s0.X1));
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
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    public void finishForumManageProcess(int i2, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            if (z && z2) {
                showToast(getPageContext().getString(b.a.r0.k2.l.success));
            } else if (z2) {
                if (b.a.e.e.p.k.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(b.a.r0.k2.l.neterror);
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
            if (pbModel == null || pbModel.P0() == null) {
                return null;
            }
            return this.mModel.P0().d();
        }
        return (AntiData) invokeV.objValue;
    }

    @Override // b.a.r0.k2.u.a
    public b.a.r0.k2.u.f.c1.a getEventController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mPbEventController : (b.a.r0.k2.u.f.c1.a) invokeV.objValue;
    }

    public PostData getFirstPostData() {
        InterceptResult invokeV;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            PbModel pbModel = this.mModel;
            if (pbModel == null || pbModel.P0() == null || this.mModel.P0().O() == null || this.mModel.P0().O().J() == null) {
                return null;
            }
            PostData postData = new PostData();
            MetaData J = this.mModel.P0().O().J();
            String userId = J.getUserId();
            HashMap<String, MetaData> A1 = this.mModel.P0().O().A1();
            if (A1 != null && (metaData = A1.get(userId)) != null && metaData.getUserId() != null) {
                J = metaData;
            }
            postData.m0(1);
            postData.q0(this.mModel.P0().O().W());
            postData.C0(this.mModel.P0().O().getTitle());
            postData.B0(this.mModel.P0().O().P());
            postData.k0(J);
            return postData;
        }
        return (PostData) invokeV.objValue;
    }

    @Override // b.a.r0.k2.u.a
    public String getFromForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            PbModel pbModel = this.mModel;
            if (pbModel != null) {
                return pbModel.q0();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public PbModel getModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mModel : (PbModel) invokeV.objValue;
    }

    public b.a.q0.x.x.e getPbEditor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mPbEditor : (b.a.q0.x.x.e) invokeV.objValue;
    }

    public b.a.r0.k2.u.f.c1.c getPbPostShareController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mPbPostShareController : (b.a.r0.k2.u.f.c1.c) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, voiceData$VoiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // b.a.r0.k2.u.a
    public int getUserIdentify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            PbModel pbModel = this.mModel;
            if (pbModel == null || pbModel.P0() == null) {
                return 0;
            }
            return this.mModel.P0().V();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mVoiceManager : (VoiceManager) invokeV.objValue;
    }

    public void handleMuteClick(boolean z, String str, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Boolean.valueOf(z), str, sparseArray}) == null) {
            String str2 = sparseArray.get(b.a.r0.k2.i.tag_user_mute_mute_username) instanceof String ? (String) sparseArray.get(b.a.r0.k2.i.tag_user_mute_mute_username) : "";
            String str3 = sparseArray.get(b.a.r0.k2.i.tag_user_mute_thread_id) instanceof String ? (String) sparseArray.get(b.a.r0.k2.i.tag_user_mute_thread_id) : "";
            String str4 = sparseArray.get(b.a.r0.k2.i.tag_user_mute_post_id) instanceof String ? (String) sparseArray.get(b.a.r0.k2.i.tag_user_mute_post_id) : "";
            String str5 = sparseArray.get(b.a.r0.k2.i.tag_user_mute_msg) instanceof String ? (String) sparseArray.get(b.a.r0.k2.i.tag_user_mute_msg) : "";
            String str6 = sparseArray.get(b.a.r0.k2.i.tag_user_mute_mute_nameshow) instanceof String ? (String) sparseArray.get(b.a.r0.k2.i.tag_user_mute_mute_nameshow) : "";
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.MESSAGE_ID_PB);
            userMuteAddAndDelCustomMessage.setTag(this.MESSAGE_ID_PB);
            showUserMuteDialog(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    @Override // b.a.r0.k2.u.a
    public boolean isHost(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
            PbModel pbModel = this.mModel;
            return pbModel != null && pbModel.z1(str);
        }
        return invokeL.booleanValue;
    }

    public boolean isHostOnlyMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            PbModel pbModel = this.mModel;
            if (pbModel != null) {
                return pbModel.t0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isImage(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, view)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // b.a.r0.k2.u.a
    public boolean isSimpleForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            PbModel pbModel = this.mModel;
            if (pbModel == null) {
                return false;
            }
            return pbModel.y1();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        String str;
        Serializable serializableExtra;
        EmotionImageData emotionImageData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048602, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            this.mPbEditor.I(i2, i3, intent);
            b.a.r0.k2.u.f.b1.f.a aVar = this.mReplyEmotionModel;
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
                    k0.b().m();
                    this.mHandler.postDelayed(new h(this), 1000L);
                } else if (i2 == 13011) {
                    b.a.r0.y2.a.g().m(getPageContext());
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
                        b.a.r0.y2.a.g().m(getPageContext());
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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
        }
    }

    @Override // b.a.q0.s.s.a.e
    public void onClick(b.a.q0.s.s.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, aVar) == null) {
            deleteThread(aVar, (JSONArray) null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, bundle) == null) {
            super.onCreate(bundle);
            VoiceManager voiceManager = new VoiceManager();
            this.mVoiceManager = voiceManager;
            voiceManager.onCreate(getPageContext());
            initData(bundle);
            initUI(bundle);
            loadData();
            this.mView.x().setFromForumId(this.mModel.getFromForumId());
            b.a.r0.k2.u.g.a aVar = new b.a.r0.k2.u.g.a(this);
            this.mUEGReportController = aVar;
            aVar.b(getUniqueId());
            this.mUserBlockController = new b.a.r0.v3.b(getPageContext(), getUniqueId());
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.mReplyPrivacyController = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new r(this));
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.mPbEditor.l0(TbSingleton.getInstance().getAdVertiComment());
            } else {
                this.mPbEditor.l0(this.mView.z());
            }
        }
    }

    public void processProfessionPermission() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || !checkUpIsLogin() || (pbModel = this.mModel) == null || pbModel.P0() == null || this.mModel.P0().l() == null || checkIsIfPostForbid()) {
            return;
        }
        if (this.mModel.P0().g0()) {
            this.mView.t();
            return;
        }
        if (this.mProfessionController == null) {
            b.a.r0.x0.q2.a.c cVar = new b.a.r0.x0.q2.a.c(getPageContext());
            this.mProfessionController = cVar;
            cVar.j(0);
            this.mProfessionController.i(new o(this));
        }
        this.mProfessionController.g(this.mModel.P0().l().getId(), b.a.e.e.m.b.g(this.mModel.f1(), 0L));
    }

    public void showBlockDialog(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, str) == null) || str == null || this.mUserBlockController == null) {
            return;
        }
        this.mUserBlockController.n(b.a.e.e.m.b.g(str, 0L));
    }

    public void markFloor(PostData postData) {
        b.a.q0.i.a aVar;
        PostData firstPostData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, postData) == null) || postData == null) {
            return;
        }
        boolean z = false;
        if (postData.G() != null && postData.G().equals(this.mModel.K0())) {
            z = true;
        }
        MarkData J0 = this.mModel.J0(postData);
        if (this.mModel.P0() != null && this.mModel.P0().g0() && (firstPostData = getFirstPostData()) != null) {
            J0 = this.mModel.J0(firstPostData);
        }
        if (J0 == null || (aVar = this.mMarkModel) == null) {
            return;
        }
        aVar.i(J0);
        if (!z) {
            this.mMarkModel.a();
        } else {
            this.mMarkModel.d();
        }
    }

    public void deleteThread(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(s0.W1)).intValue();
            if (intValue == s0.X1) {
                if (this.mForumManageModel.P()) {
                    return;
                }
                String str = (String) sparseArray.get(b.a.r0.k2.i.tag_del_post_id);
                int intValue2 = ((Integer) sparseArray.get(b.a.r0.k2.i.tag_manage_user_identity)).intValue();
                boolean booleanValue = ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_del_post_is_self)).booleanValue();
                int intValue3 = ((Integer) sparseArray.get(b.a.r0.k2.i.tag_del_post_type)).intValue();
                boolean booleanValue2 = sparseArray.get(b.a.r0.k2.i.tag_is_block_thread) != null ? ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_is_block_thread)).booleanValue() : false;
                if (jSONArray != null) {
                    this.mForumManageModel.R(StringHelper.JsonArrayToString(jSONArray));
                }
                this.mForumManageModel.S(this.mModel.P0().l().getId(), this.mModel.P0().l().getName(), this.mModel.P0().O().f0(), str, intValue3, intValue2, booleanValue, this.mModel.P0().O().L(), booleanValue2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            } else if (intValue == s0.Y1 || intValue == s0.a2) {
                if (this.mModel.m0() != null) {
                    this.mModel.m0().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == s0.Y1) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSubPbActivity(SparseArray<Object> sparseArray) {
        PostData postData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65618, this, sparseArray) == null) && checkUpIsLogin() && sparseArray != null && (sparseArray.get(b.a.r0.k2.i.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(b.a.r0.k2.i.tag_clip_board)) != null) {
            startSubPbActivity(postData, false);
        }
    }
}
