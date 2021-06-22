package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.BubbleGroupActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.dialog.WriteTipBubbleController;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PreLoadImageHelper;
import com.baidu.tbadk.core.util.ReplyPrivacyCheckController;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.resourceLoaderProc.BigImageLoaderProc;
import com.baidu.tbadk.core.util.videoPreload.PreLoadVideoHelper;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbMemeImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextMemeInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.sub.SubPbModel;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.n0.a0.d;
import d.a.n0.b1.m.f;
import d.a.n0.h.a;
import d.a.n0.r.f0.f;
import d.a.n0.r.q.a2;
import d.a.n0.r.s.a;
import d.a.n0.r.s.b;
import d.a.o0.e2.k.e.r0;
import d.a.o0.e2.k.e.x0;
import d.a.o0.r0.f2.a.c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes5.dex */
public class NewSubPbActivity extends BaseActivity<NewSubPbActivity> implements VoiceManager.j, d.a.n0.b1.m.h, BdListView.p, d.a.o0.e2.k.a<NewSubPbActivity> {
    public static String TB_GAME_TYPE = "tbgametype";
    public BdUniqueId MESSAGE_ID_NEWSUB_PB;
    public boolean hasRemindedEditorTips;
    public View.OnClickListener mCommonClickListener;
    public d.a.c.a.f mCtx;
    public d.a.n0.w.w.h mEditor;
    public TbRichTextMemeInfo mEmotionInfo;
    public d.a.o0.e2.k.e.c1.a mEvent;
    public Object mExtra;
    public d.a.c.e.k.b<GifView> mGifViewPool;
    public TbRichTextView.x mImageClickListener;
    public d.a.c.e.k.b<ImageView> mImageViewPool;
    public boolean mIsSoftKeyBoardVisible;
    public PbCommenFloorItemViewHolder mItemClickShowSoftKeyBoardViewHolder;
    public d.a.n0.h.a mMarkModel;
    public d.a.c.e.k.b<RelativeLayout> mMemeViewPool;
    public d.a.n0.r.b0.a mMessageHelper;
    public d.a.o0.e3.h0.e mMsgData;
    public View.OnLongClickListener mOnLongClickListener;
    public PermissionJudgePolicy mPermissionJudgement;
    public d.a.c.a.e mPostManageCallBack;
    public ForumManageModel mPostManageModel;
    public d.a.o0.e2.k.e.d0 mPostMoreOptionView;
    public PostWriteCallBackData mPostWriteCallBackData;
    public d.a.o0.r0.f2.a.c mProfessionController;
    public d.a.o0.e2.e<d.a.o0.e2.h.r> mRefreshData;
    public String mReplyHintText;
    public ReplyPrivacyCheckController mReplyPrivacyController;
    public d.a.c.k.d.a mSaveBdImage;
    public x0 mSaveImageHelper;
    public String mSaveImageUrl;
    public d.a.o0.w3.c mSensitiveProcessController;
    public EditText mSubFloorEditText;
    public SubPbModel.b mSubPbCallBack;
    public SubPbModel mSubPbModel;
    public AbsListView.OnScrollListener mSubPbScrollListener;
    public d.a.o0.e2.k.g.a mSubPbView;
    public d.a.c.e.k.b<TextView> mTextViewPool;
    public d.a.c.e.k.b<LinearLayout> mTextVoiceViewPool;
    public d.a.n0.r.f0.c mToastMute;
    public d.a.o0.e2.k.f.a mUEGReportController;
    public d.a.o0.o3.b mUserBlockController;
    public VoiceManager mVoiceManager;
    public d.a.c.e.k.b<View> mVoiceViewPool;
    public boolean mIsFromCDN = true;
    public int imgIndex = 0;
    public PostData postData = null;
    public a.InterfaceC1183a mMarkDoneCallBack = null;
    public q0 forbidUserCallback = null;
    public q0 deleteReplayCallback = null;
    public boolean mIsPaused = false;
    public boolean isFirstLoadData = false;
    public boolean mIsRichTextListenerAcked = false;
    public boolean mIsFromPb = false;
    public d.a.n0.w.w.c mPrePostCallBack = new k();
    public int lastScrollState = 0;
    public boolean mIsFromSchema = false;
    public BdUniqueId mOnlyDisagreeId = BdUniqueId.gen();
    public boolean showTrisectionAndFeedback = d.a.n0.b.d.W();
    public boolean needOpenEditor = true;
    public d.a.n0.w.w.b mCheckPostCallBack = new v();
    public CustomMessageListener subpbReplyListener = new g0(2921481);
    public NewWriteModel.g mOnPostWriteNewCallback = new h0();
    public CustomMessageListener mUserMuteAddListener = new l0(2001427);
    public CustomMessageListener mUserMuteDelListener = new m0(2001428);
    public CustomMessageListener mUserMuteCheckListener = new n0(2001426);
    public final f.g mOnPullRefreshListener = new o0();
    public boolean index_valid = false;
    public final b.c mOnImageSaveClickListener = new p();
    public CustomMessageListener richTextIntentClickListener = new t(2001332);
    public CustomMessageListener updatePendantMessageListener = new i0(2016485);

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (NewSubPbActivity.this.mSubPbModel != null) {
                NewSubPbActivity.this.mSubPbModel.z0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a0 extends d.a.n0.k0.b {
        public a0() {
        }

        @Override // d.a.n0.k0.b
        public int getMaxCost() {
            return d.a.n0.k0.e.b().c();
        }

        @Override // d.a.n0.k0.b
        public boolean isCurrentPageCanBeAddToSourceTrace() {
            return false;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements PbFakeFloorModel.b {
        public b() {
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(PostData postData) {
            NewSubPbActivity.this.mSubPbView.z0(postData);
            NewSubPbActivity.this.mSubPbView.v0(null);
        }
    }

    /* loaded from: classes5.dex */
    public class b0 implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserMuteAddAndDelCustomMessage f19419e;

        public b0(UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
            this.f19419e = userMuteAddAndDelCustomMessage;
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            NewSubPbActivity.this.mSubPbView.A0();
            MessageManager.getInstance().sendMessage(this.f19419e);
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements WriteTipBubbleController.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f19421a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.w.w.h f19422b;

        public c(View view, d.a.n0.w.w.h hVar) {
            this.f19421a = view;
            this.f19422b = hVar;
        }

        @Override // com.baidu.tbadk.core.dialog.WriteTipBubbleController.b
        public void a(View view, String str) {
            this.f19421a.performClick();
            this.f19422b.p();
            this.f19422b.s().i().setText(str);
            Editable text = this.f19422b.s().i().getText();
            if (TextUtils.isEmpty(text)) {
                return;
            }
            this.f19422b.s().i().setSelection(text.length());
        }
    }

    /* loaded from: classes5.dex */
    public class c0 implements a.e {
        public c0() {
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements SubPbModel.b {

        /* loaded from: classes5.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.o0.e2.h.r f19426e;

            public a(d.a.o0.e2.h.r rVar) {
                this.f19426e = rVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                NewSubPbActivity.this.needOpenEditor = false;
                NewSubPbActivity.this.openEditor(this.f19426e.i(), false);
            }
        }

        public d() {
        }

        @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.b
        public void a(boolean z, int i2, String str, d.a.o0.e2.h.r rVar) {
            if (NewSubPbActivity.this.mSubPbView == null) {
                return;
            }
            NewSubPbActivity.this.mSubPbView.l0();
            if (!z) {
                NewSubPbActivity.this.onNetOrDataError(i2, str);
                return;
            }
            NewSubPbActivity.this.mSubPbView.S();
            if (rVar != null) {
                if (rVar.i() != null || NewSubPbActivity.this.mSubPbModel != null) {
                    rVar.i().v0(NewSubPbActivity.this.mSubPbModel.j0());
                }
                if (NewSubPbActivity.this.mSubPbView != null) {
                    NewSubPbActivity.this.initEditor(rVar.l() != null && rVar.l().V1());
                    if (NewSubPbActivity.this.mEditor != null && NewSubPbActivity.this.mEditor.a() != null) {
                        NewSubPbActivity.this.mEditor.a().w(TbadkCoreApplication.getInst().getSkinType());
                    }
                    NewSubPbActivity.this.mSubPbView.H0(rVar, NewSubPbActivity.this.mSubPbModel.o0(), NewSubPbActivity.this.mSubPbModel.n0() != null, NewSubPbActivity.this.isFirstLoadData);
                    if (NewSubPbActivity.this.isFirstLoadData) {
                        NewSubPbActivity.this.mSubPbView.G().setSelectionFromTop(NewSubPbActivity.this.mSubPbView.G().getHeaderViewsCount() + 1, -d.a.c.e.p.l.g(NewSubPbActivity.this, R.dimen.tbds18));
                        NewSubPbActivity.this.checkShowKeyboard();
                        NewSubPbActivity.this.isFirstLoadData = false;
                    }
                }
                if (NewSubPbActivity.this.mEditor != null) {
                    NewSubPbActivity.this.mEditor.E(rVar.a());
                    NewSubPbActivity.this.mEditor.X(rVar.l());
                    if (NewSubPbActivity.this.getIntent() != null && NewSubPbActivity.this.getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_OPEN_EDITOR, false) && NewSubPbActivity.this.needOpenEditor) {
                        d.a.c.e.m.e.a().postDelayed(new a(rVar), 200L);
                    }
                }
                if (NewSubPbActivity.this.mRefreshData == null) {
                    NewSubPbActivity.this.mRefreshData = new d.a.o0.e2.e();
                }
                NewSubPbActivity.this.mRefreshData.c(rVar);
                NewSubPbActivity.this.mRefreshData.d(0);
                NewSubPbActivity newSubPbActivity = NewSubPbActivity.this;
                newSubPbActivity.mReplyPrivacyController.setLikeUserData(newSubPbActivity.mSubPbModel.W());
            }
            String stringExtra = NewSubPbActivity.this.getIntent().getStringExtra("key_open_editor_tips");
            if (TextUtils.isEmpty(stringExtra) || NewSubPbActivity.this.hasRemindedEditorTips) {
                return;
            }
            NewSubPbActivity.this.hasRemindedEditorTips = true;
            NewSubPbActivity newSubPbActivity2 = NewSubPbActivity.this;
            newSubPbActivity2.showDeleteResumeEditorTips(newSubPbActivity2.mSubPbView.N(), NewSubPbActivity.this.mEditor, stringExtra);
        }
    }

    /* loaded from: classes5.dex */
    public class d0 implements a.e {
        public d0() {
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class e implements a.InterfaceC1183a {
        public e() {
        }

        @Override // d.a.n0.h.a.InterfaceC1183a
        public void a(boolean z, boolean z2, String str) {
            if (z) {
                if (NewSubPbActivity.this.mMarkModel != null) {
                    NewSubPbActivity.this.mMarkModel.h(z2);
                }
                MarkData f2 = NewSubPbActivity.this.mMarkModel.f();
                d.a.o0.e2.e eVar = new d.a.o0.e2.e();
                eVar.d(2);
                if (z2) {
                    eVar.c(f2);
                    if (NewSubPbActivity.this.mMarkModel != null) {
                        if (f2 != null) {
                            NewSubPbActivity.this.mSubPbModel.K0(true);
                            NewSubPbActivity.this.mSubPbModel.L0(NewSubPbActivity.this.mSubPbModel.w());
                            NewSubPbActivity.this.showToast(R.string.add_mark_on_pb);
                        } else {
                            NewSubPbActivity newSubPbActivity = NewSubPbActivity.this;
                            newSubPbActivity.showToast(newSubPbActivity.getPageContext().getString(R.string.add_mark));
                        }
                        if (NewSubPbActivity.this.mSubPbView != null) {
                            NewSubPbActivity.this.mSubPbView.L0(true);
                        }
                    }
                } else {
                    eVar.c(null);
                    NewSubPbActivity.this.mSubPbModel.K0(false);
                    NewSubPbActivity.this.mSubPbModel.L0(null);
                    NewSubPbActivity newSubPbActivity2 = NewSubPbActivity.this;
                    newSubPbActivity2.showToast(newSubPbActivity2.getPageContext().getString(R.string.remove_mark));
                    if (NewSubPbActivity.this.mSubPbView != null) {
                        NewSubPbActivity.this.mSubPbView.L0(false);
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, eVar));
                return;
            }
            NewSubPbActivity newSubPbActivity3 = NewSubPbActivity.this;
            newSubPbActivity3.showToast(newSubPbActivity3.getPageContext().getString(R.string.update_mark_failed));
        }
    }

    /* loaded from: classes5.dex */
    public class e0 implements a.e {
        public e0() {
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            if (Build.VERSION.SDK_INT < 11) {
                aVar.dismiss();
                ((TbPageContext) NewSubPbActivity.this.mCtx).showToast(R.string.frs_header_games_unavailable);
                return;
            }
            TiebaStatic.log("c10025");
            aVar.dismiss();
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.mCtx.getPageActivity(), 2, true, 4);
            if (!StringUtils.isNULL("4010001001")) {
                memberPayActivityConfig.setSceneId("4010001001");
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
        }
    }

    /* loaded from: classes5.dex */
    public class f implements q0 {
        public f() {
        }

        @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.q0
        public void a(Object obj) {
            Object[] objArr = (Object[]) obj;
            String valueOf = (NewSubPbActivity.this.mSubPbModel.X() == null || NewSubPbActivity.this.mSubPbModel.X().l() == null || NewSubPbActivity.this.mSubPbModel.X().l().T() == null) ? "" : String.valueOf(NewSubPbActivity.this.mSubPbModel.X().l().T().getUserId());
            String valueOf2 = objArr.length > 1 ? String.valueOf(objArr[1]) : "";
            String valueOf3 = objArr.length > 2 ? String.valueOf(objArr[2]) : "";
            NewSubPbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.mSubPbModel.X().d().getId(), NewSubPbActivity.this.mSubPbModel.X().d().getName(), NewSubPbActivity.this.mSubPbModel.X().l().o0(), valueOf, valueOf2, objArr.length > 3 ? String.valueOf(objArr[3]) : "", valueOf3, objArr.length > 4 ? String.valueOf(objArr[4]) : "")));
        }
    }

    /* loaded from: classes5.dex */
    public class f0 implements a.e {
        public f0() {
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class g implements q0 {
        public g() {
        }

        @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.q0
        public void a(Object obj) {
            Object[] objArr = (Object[]) obj;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (NewSubPbActivity.this.mPostManageModel.O() || objArr == null || objArr.length < 4) {
                    return;
                }
                String valueOf = String.valueOf(objArr[0]);
                int d2 = d.a.c.e.m.b.d(String.valueOf(objArr[1]), 0);
                boolean a2 = d.a.c.e.m.b.a(String.valueOf(objArr[2]), false);
                int d3 = d.a.c.e.m.b.d(String.valueOf(objArr[3]), 0);
                if (NewSubPbActivity.this.mSubPbModel == null || NewSubPbActivity.this.mSubPbModel.X() == null || NewSubPbActivity.this.mSubPbModel.X().d() == null || NewSubPbActivity.this.mSubPbModel.X().l() == null) {
                    return;
                }
                if (objArr.length > 4) {
                    NewSubPbActivity.this.mPostManageModel.Q(String.valueOf(objArr[4]));
                }
                NewSubPbActivity.this.mPostManageModel.R(NewSubPbActivity.this.mSubPbModel.X().d().getId(), NewSubPbActivity.this.mSubPbModel.X().d().getName(), NewSubPbActivity.this.mSubPbModel.X().l().o0(), valueOf, d3, d2, a2, NewSubPbActivity.this.mSubPbModel.X().l().V());
                return;
            }
            TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), true, 11017)));
        }
    }

    /* loaded from: classes5.dex */
    public class g0 extends CustomMessageListener {
        public g0(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || NewSubPbActivity.this.mSubPbModel == null || !(customResponsedMessage.getData() instanceof PostWriteCallBackData) || !StringHelper.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), NewSubPbActivity.this.mSubPbModel.k0())) {
                return;
            }
            if (NewSubPbActivity.this.mSensitiveProcessController != null) {
                NewSubPbActivity.this.mSensitiveProcessController.n(null);
                NewSubPbActivity.this.mSensitiveProcessController.i(null);
                NewSubPbActivity.this.mSensitiveProcessController.k(false);
            }
            if (NewSubPbActivity.this.mEditor != null) {
                NewSubPbActivity.this.mEditor.p();
                NewSubPbActivity.this.mEditor.F();
            }
            NewSubPbActivity.this.mSubPbModel.y();
        }
    }

    /* loaded from: classes5.dex */
    public class h extends d.a.c.a.e {
        public h() {
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            boolean z = false;
            if (obj != null) {
                int loadDataMode = NewSubPbActivity.this.mPostManageModel.getLoadDataMode();
                if (loadDataMode == 0) {
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    NewSubPbActivity.this.finishDelPost(bVar, (bVar.f20988e != 1002 || bVar.f20989f) ? true : true);
                    return;
                } else if (loadDataMode != 1) {
                    return;
                } else {
                    ForumManageModel.d dVar = (ForumManageModel.d) obj;
                    NewSubPbActivity.this.mSubPbView.z(1, dVar.f20991a, dVar.f20992b, true);
                    return;
                }
            }
            NewSubPbActivity.this.mSubPbView.z(NewSubPbActivity.this.mPostManageModel.getLoadDataMode(), false, null, false);
        }
    }

    /* loaded from: classes5.dex */
    public class h0 implements NewWriteModel.g {

        /* loaded from: classes5.dex */
        public class a implements a.e {
            public a(h0 h0Var) {
            }

            @Override // d.a.n0.r.s.a.e
            public void onClick(d.a.n0.r.s.a aVar) {
                aVar.dismiss();
            }
        }

        /* loaded from: classes5.dex */
        public class b implements a.e {
            public b() {
            }

            @Override // d.a.n0.r.s.a.e
            public void onClick(d.a.n0.r.s.a aVar) {
                aVar.dismiss();
                NewSubPbActivity.this.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(NewSubPbActivity.this.getActivity(), 0, 26, 2)));
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
            }
        }

        public h0() {
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, d.a.n0.s.c.i0 i0Var, WriteData writeData, AntiData antiData) {
            ReplyPrivacyCheckController replyPrivacyCheckController;
            if (z && NewSubPbActivity.this.mEditor != null && NewSubPbActivity.this.mEditor.a() != null) {
                NewSubPbActivity.this.mEditor.a().o();
                if (NewSubPbActivity.this.mSubPbModel.s0()) {
                    TiebaStatic.log(new StatisticItem("c10367").param("post_id", NewSubPbActivity.this.mSubPbModel.w()));
                }
            }
            if (z) {
                NewSubPbActivity.this.mSensitiveProcessController.n(null);
                NewSubPbActivity.this.mSensitiveProcessController.i(null);
                NewSubPbActivity.this.mSensitiveProcessController.k(false);
                if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                    d.a.n0.s.h.b.a(NewSubPbActivity.this.getPageContext(), postWriteCallBackData);
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.mSensitiveProcessController.i(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.mSensitiveProcessController.n(postWriteCallBackData.getErrorString());
                if (ListUtils.isEmpty(NewSubPbActivity.this.mSensitiveProcessController.a())) {
                    return;
                }
                NewSubPbActivity.this.mPostWriteCallBackData = postWriteCallBackData;
                if (NewSubPbActivity.this.mEditor.v()) {
                    NewSubPbActivity.this.mEditor.t(NewSubPbActivity.this.mPostWriteCallBackData);
                }
                NewSubPbActivity.this.checkContentSensitiveWord(true);
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (d.a.c.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.s(NewSubPbActivity.this.getActivity(), NewSubPbActivity.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).u();
                } else {
                    DefaultNavigationBarCoverTip.s(NewSubPbActivity.this.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                d.a.n0.r.s.a aVar = new d.a.n0.r.s.a(NewSubPbActivity.this.getActivity());
                if (d.a.c.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.setMessage(NewSubPbActivity.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.setMessage(postWriteCallBackData.getErrorString());
                }
                aVar.setNegativeButton(R.string.cancel, new a(this));
                aVar.setPositiveButton(R.string.open_now, new b());
                aVar.create(NewSubPbActivity.this.getPageContext()).show();
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && (replyPrivacyCheckController = NewSubPbActivity.this.mReplyPrivacyController) != null) {
                replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.mSubPbView.l0();
        }
    }

    /* loaded from: classes5.dex */
    public class i implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SparseArray f19438e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f19439f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f19440g;

        public i(SparseArray sparseArray, int i2, boolean z) {
            this.f19438e = sparseArray;
            this.f19439f = i2;
            this.f19440g = z;
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            if (aVar != null) {
                aVar.dismiss();
            }
            if (NewSubPbActivity.this.deleteReplayCallback != null) {
                NewSubPbActivity.this.deleteReplayCallback.a(new Object[]{this.f19438e.get(R.id.tag_del_post_id), Integer.valueOf(this.f19439f), Boolean.valueOf(this.f19440g), this.f19438e.get(R.id.tag_del_post_type)});
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i0 extends CustomMessageListener {
        public i0(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof d.a.n0.t.n)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (StringUtils.isNull(currentAccount)) {
                    return;
                }
                d.a.n0.t.n nVar = (d.a.n0.t.n) customResponsedMessage.getData();
                if (NewSubPbActivity.this.mSubPbModel.X() == null || NewSubPbActivity.this.mSubPbModel.X().i() == null || NewSubPbActivity.this.mSubPbModel.X().i().t() == null || !currentAccount.equals(NewSubPbActivity.this.mSubPbModel.X().i().t().getUserId()) || NewSubPbActivity.this.mSubPbModel.X().i().t().getPendantData() == null) {
                    return;
                }
                NewSubPbActivity.this.mSubPbModel.X().i().t().getPendantData().d(nVar.a());
                NewSubPbActivity.this.mSubPbModel.X().i().t().getPendantData().e(nVar.b());
                NewSubPbActivity.this.mSubPbView.y(NewSubPbActivity.this.mSubPbModel.X(), NewSubPbActivity.this.mSubPbModel.X().i(), NewSubPbActivity.this.mSubPbModel.X().e(), NewSubPbActivity.this.mSubPbModel.X().f(), NewSubPbActivity.this.mSubPbModel.o0(), NewSubPbActivity.this.mSubPbModel.n0() != null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements a.e {
        public j() {
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class j0 implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f19444e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f19445f;

        public j0(int i2, int i3) {
            this.f19444e = i2;
            this.f19445f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (NewSubPbActivity.this.mSubPbView == null || NewSubPbActivity.this.mSubPbView.G() == null) {
                return;
            }
            NewSubPbActivity.this.mSubPbView.G().setSelectionFromTop(this.f19444e, NewSubPbActivity.this.mSubPbView.I() - this.f19445f);
        }
    }

    /* loaded from: classes5.dex */
    public class k implements d.a.n0.w.w.c {
        public k() {
        }

        @Override // d.a.n0.w.w.c
        public void a() {
            NewSubPbActivity.this.mSubPbView.x0();
        }
    }

    /* loaded from: classes5.dex */
    public class k0 implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f19448e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f19449f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f19450g;

        public k0(int i2, int i3, int i4) {
            this.f19448e = i2;
            this.f19449f = i3;
            this.f19450g = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (NewSubPbActivity.this.mSubPbView == null || NewSubPbActivity.this.mSubPbView.G() == null) {
                return;
            }
            NewSubPbActivity.this.mSubPbView.G().setSelectionFromTop(this.f19448e, NewSubPbActivity.this.mSubPbView.I() + (this.f19449f - this.f19450g));
        }
    }

    /* loaded from: classes5.dex */
    public class l implements View.OnClickListener {

        /* loaded from: classes5.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.o0.e2.k.e.c1.c f19453e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ PostData f19454f;

            public a(d.a.o0.e2.k.e.c1.c cVar, PostData postData) {
                this.f19453e = cVar;
                this.f19454f = postData;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.o0.e2.k.e.e eVar = new d.a.o0.e2.k.e.e(new d.a.n0.b1.m.a());
                eVar.j(d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
                eVar.o(TbConfig.getPostLineSpace(), 1.0f);
                this.f19453e.f57033b.a(null, NewSubPbActivity.this.mSubPbModel.X().l(), this.f19454f, eVar);
            }
        }

        public l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PostData postData;
            String b2;
            SparseArray sparseArray;
            if (view == null && NewSubPbActivity.this.mSubPbView == null) {
                return;
            }
            boolean z = true;
            boolean z2 = false;
            SparseArray<Object> sparseArray2 = null;
            if (view == NewSubPbActivity.this.mSubPbView.F()) {
                NewSubPbActivity.this.mSubPbView.w();
                String str = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                String str2 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                String str3 = view.getTag(R.id.tag_virtual_user_url) instanceof String ? (String) view.getTag(R.id.tag_virtual_user_url) : null;
                if (str3 != null) {
                    if (NewSubPbActivity.this.checkUpIsLogin()) {
                        UrlManager.getInstance().dealOneLink(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                    }
                } else if (str != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                }
            } else if (view != NewSubPbActivity.this.mSubPbView.N()) {
                if (view != NewSubPbActivity.this.mSubPbView.K()) {
                    if (view == NewSubPbActivity.this.mSubPbView.L()) {
                        if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.mSubPbView.K0();
                            NewSubPbActivity.this.mSubPbView.u();
                            if (NewSubPbActivity.this.mEditor != null) {
                                NewSubPbActivity.this.mEditor.c0();
                            }
                        }
                    } else if (view.getId() != R.id.pb_floor_feedback) {
                        if (view == NewSubPbActivity.this.mSubPbView.H()) {
                            NewSubPbActivity.this.mSubPbView.w();
                            if (NewSubPbActivity.this.mSubPbModel.z0()) {
                                NewSubPbActivity.this.mSubPbView.G0();
                                return;
                            }
                            return;
                        }
                        String str4 = "";
                        if (view == NewSubPbActivity.this.mSubPbView.D() || view == NewSubPbActivity.this.mSubPbView.C() || view == NewSubPbActivity.this.mSubPbView.O()) {
                            if (NewSubPbActivity.this.mIsRichTextListenerAcked) {
                                NewSubPbActivity.this.mIsRichTextListenerAcked = false;
                                return;
                            }
                            if (NewSubPbActivity.this.mSubPbModel.X() != null && NewSubPbActivity.this.mSubPbModel.X().l() != null) {
                                z2 = ThreadCardUtils.isUgcThreadType(NewSubPbActivity.this.mSubPbModel.X().l().V());
                            }
                            if (z2) {
                                PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.mSubPbModel.k0(), null, "");
                                if (!StringUtils.isNull(NewSubPbActivity.this.mSubPbModel.getFromForumId())) {
                                    createNormalCfg.setForumId(NewSubPbActivity.this.mSubPbModel.getFromForumId());
                                }
                                if (NewSubPbActivity.this.mSubPbModel.X() != null && NewSubPbActivity.this.mSubPbModel.X().l() != null) {
                                    createNormalCfg.setBjhData(NewSubPbActivity.this.mSubPbModel.X().l().V());
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                                return;
                            }
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.mSubPbModel.k0(), NewSubPbActivity.this.mSubPbModel.w(), "");
                            if (!StringUtils.isNull(NewSubPbActivity.this.mSubPbModel.getFromForumId())) {
                                createNormalCfg2.setForumId(NewSubPbActivity.this.mSubPbModel.getFromForumId());
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg2));
                        } else if (NewSubPbActivity.this.mSubPbView.J() == null || view != NewSubPbActivity.this.mSubPbView.J().z()) {
                            if (NewSubPbActivity.this.mSubPbView.J() == null || view != NewSubPbActivity.this.mSubPbView.J().t()) {
                                if (NewSubPbActivity.this.mSubPbView.J() == null || view != NewSubPbActivity.this.mSubPbView.J().y()) {
                                    if (NewSubPbActivity.this.mSubPbView.J() == null || view != NewSubPbActivity.this.mSubPbView.J().C()) {
                                        if (NewSubPbActivity.this.mSubPbView.J() == null || view != NewSubPbActivity.this.mSubPbView.J().s()) {
                                            if (view != NewSubPbActivity.this.mSubPbView.E() && view != NewSubPbActivity.this.mSubPbView.O()) {
                                                if (view != null && (view.getTag() instanceof PbCommenFloorItemViewHolder)) {
                                                    NewSubPbActivity.this.mItemClickShowSoftKeyBoardViewHolder = (PbCommenFloorItemViewHolder) view.getTag();
                                                    if (ViewHelper.checkUpIsLogin(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                        if (NewSubPbActivity.this.mIsRichTextListenerAcked) {
                                                            NewSubPbActivity.this.mIsRichTextListenerAcked = false;
                                                            return;
                                                        }
                                                        NewSubPbActivity newSubPbActivity = NewSubPbActivity.this;
                                                        if (newSubPbActivity.mReplyPrivacyController != null && newSubPbActivity.mSubPbModel != null && NewSubPbActivity.this.mSubPbModel.V() != null && !NewSubPbActivity.this.isHost(TbadkCoreApplication.getCurrentAccount())) {
                                                            NewSubPbActivity newSubPbActivity2 = NewSubPbActivity.this;
                                                            if (!newSubPbActivity2.mReplyPrivacyController.checkPrivacyBeforeInvokeEditor(newSubPbActivity2.mSubPbModel.V().replyPrivateFlag)) {
                                                                return;
                                                            }
                                                        }
                                                        SparseArray sparseArray3 = (SparseArray) view.getTag(R.id.tag_from);
                                                        if (sparseArray3 == null) {
                                                            return;
                                                        }
                                                        NewSubPbActivity.this.openEditor(sparseArray3, ((view.getTag(R.id.tag_subpb_ban_display_keyboard) instanceof Boolean) && view.getTag(R.id.tag_subpb_ban_display_keyboard) == Boolean.TRUE) ? false : false);
                                                        return;
                                                    }
                                                    return;
                                                } else if (view.getId() != R.id.post_info_commont_img && view.getId() != R.id.pb_floor_comment_container && (NewSubPbActivity.this.mPostMoreOptionView == null || view != NewSubPbActivity.this.mPostMoreOptionView.B())) {
                                                    if (NewSubPbActivity.this.mPostMoreOptionView == null || view != NewSubPbActivity.this.mPostMoreOptionView.C()) {
                                                        if (NewSubPbActivity.this.mPostMoreOptionView == null || view != NewSubPbActivity.this.mPostMoreOptionView.z()) {
                                                            if (NewSubPbActivity.this.mPostMoreOptionView == null || view != NewSubPbActivity.this.mPostMoreOptionView.t()) {
                                                                if (NewSubPbActivity.this.mPostMoreOptionView == null || view != NewSubPbActivity.this.mPostMoreOptionView.s()) {
                                                                    if (NewSubPbActivity.this.mPostMoreOptionView == null || view != NewSubPbActivity.this.mPostMoreOptionView.v()) {
                                                                        if (NewSubPbActivity.this.mPostMoreOptionView == null || view != NewSubPbActivity.this.mPostMoreOptionView.D()) {
                                                                            if (NewSubPbActivity.this.mPostMoreOptionView == null || view != NewSubPbActivity.this.mPostMoreOptionView.u()) {
                                                                                if (NewSubPbActivity.this.mPostMoreOptionView == null || view != NewSubPbActivity.this.mPostMoreOptionView.y()) {
                                                                                    if (NewSubPbActivity.this.mPostMoreOptionView == null || view != NewSubPbActivity.this.mPostMoreOptionView.r()) {
                                                                                        if (NewSubPbActivity.this.mPostMoreOptionView != null && view == NewSubPbActivity.this.mPostMoreOptionView.E()) {
                                                                                            if (view.getTag() instanceof SparseArray) {
                                                                                                SparseArray sparseArray4 = (SparseArray) view.getTag();
                                                                                                if (sparseArray4.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                                    PostData postData2 = (PostData) sparseArray4.get(R.id.tag_load_sub_data);
                                                                                                    d.a.o0.e2.k.e.c1.c cVar = new d.a.o0.e2.k.e.c1.c(NewSubPbActivity.this.getPageContext());
                                                                                                    if (postData2 != null) {
                                                                                                        d.a.c.e.m.e.a().postDelayed(new a(cVar, postData2), 100L);
                                                                                                        String o0 = NewSubPbActivity.this.mSubPbModel.X().l().o0();
                                                                                                        if (StringUtils.isNull(o0) || "0".equals(o0)) {
                                                                                                            o0 = NewSubPbActivity.this.mSubPbModel.X().l().M0();
                                                                                                        }
                                                                                                        TiebaStatic.log(new StatisticItem("c13700").param("tid", o0).param("fid", NewSubPbActivity.this.mSubPbModel.X().l().c0()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData2.E()).param("obj_source", 1).param("obj_type", 4));
                                                                                                        return;
                                                                                                    }
                                                                                                    return;
                                                                                                }
                                                                                                return;
                                                                                            }
                                                                                            return;
                                                                                        }
                                                                                        int id = view.getId();
                                                                                        if (id == R.id.pb_item_tail_content) {
                                                                                            if (ViewHelper.checkUpIsLogin(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                                String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                                String p = d.a.n0.r.d0.b.j().p("tail_link", "");
                                                                                                if (StringUtils.isNull(p)) {
                                                                                                    return;
                                                                                                }
                                                                                                TiebaStatic.log("c10056");
                                                                                                d.a.n0.l.a.o(view.getContext(), string, p, true, true, true);
                                                                                                return;
                                                                                            }
                                                                                            return;
                                                                                        } else if (id == R.id.richText && (view.getTag() instanceof SparseArray)) {
                                                                                            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
                                                                                            if (obj instanceof PostData) {
                                                                                                PostData postData3 = (PostData) obj;
                                                                                                if (postData3.getType() == PostData.w0 || TextUtils.isEmpty(postData3.u()) || !d.a.n0.r.k.c().g()) {
                                                                                                    return;
                                                                                                }
                                                                                                NewSubPbActivity.this.navigateToBubbleWebView(postData3.E());
                                                                                                return;
                                                                                            }
                                                                                            return;
                                                                                        } else {
                                                                                            return;
                                                                                        }
                                                                                    } else if (!d.a.c.e.p.j.z()) {
                                                                                        NewSubPbActivity.this.showToast(R.string.network_not_available);
                                                                                        return;
                                                                                    } else if (!ViewHelper.checkUpIsLogin(NewSubPbActivity.this.getActivity()) || (b2 = d.a.o0.o3.a.b(view)) == null || NewSubPbActivity.this.mUserBlockController == null) {
                                                                                        return;
                                                                                    } else {
                                                                                        NewSubPbActivity.this.mUserBlockController.n(d.a.c.e.m.b.f(b2, 0L));
                                                                                        return;
                                                                                    }
                                                                                } else if (!d.a.c.e.p.j.z()) {
                                                                                    NewSubPbActivity.this.showToast(R.string.network_not_available);
                                                                                    return;
                                                                                } else {
                                                                                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                                                                                    if (sparseArray5 == null) {
                                                                                        return;
                                                                                    }
                                                                                    boolean booleanValue = ((Boolean) sparseArray5.get(R.id.tag_should_manage_visible)).booleanValue();
                                                                                    boolean booleanValue2 = ((Boolean) sparseArray5.get(R.id.tag_should_delete_visible)).booleanValue();
                                                                                    boolean booleanValue3 = ((Boolean) sparseArray5.get(R.id.tag_user_mute_visible)).booleanValue();
                                                                                    if (!booleanValue) {
                                                                                        if (booleanValue2) {
                                                                                            NewSubPbActivity.this.mSubPbView.g0(((Integer) sparseArray5.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray5.get(R.id.tag_del_post_id), ((Integer) sparseArray5.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(R.id.tag_del_post_is_self)).booleanValue(), false);
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    } else if (booleanValue3) {
                                                                                        sparseArray5.put(R.id.tag_from, 1);
                                                                                        sparseArray5.put(R.id.tag_check_mute_from, 2);
                                                                                        NewSubPbActivity.this.checkMuteState(sparseArray5);
                                                                                        return;
                                                                                    } else {
                                                                                        sparseArray5.put(R.id.tag_check_mute_from, 2);
                                                                                        NewSubPbActivity.this.mSubPbView.i0(view);
                                                                                        return;
                                                                                    }
                                                                                }
                                                                            } else if (NewSubPbActivity.this.checkUpIsLogin() && (sparseArray = (SparseArray) view.getTag()) != null) {
                                                                                PostData postData4 = (PostData) sparseArray.get(R.id.tag_clip_board);
                                                                                if (postData4.q() == null) {
                                                                                    return;
                                                                                }
                                                                                NewSubPbActivity.this.clickOnDisagree(postData4.q());
                                                                                return;
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (NewSubPbActivity.this.mSaveBdImage == null || TextUtils.isEmpty(NewSubPbActivity.this.mSaveImageUrl)) {
                                                                            return;
                                                                        } else {
                                                                            if (NewSubPbActivity.this.mPermissionJudgement == null) {
                                                                                NewSubPbActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                                                                            }
                                                                            NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                                                                            NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                                                                            if (NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                return;
                                                                            }
                                                                            if (NewSubPbActivity.this.mSaveImageHelper == null) {
                                                                                NewSubPbActivity newSubPbActivity3 = NewSubPbActivity.this;
                                                                                newSubPbActivity3.mSaveImageHelper = new x0(newSubPbActivity3.getPageContext());
                                                                            }
                                                                            NewSubPbActivity.this.mSaveImageHelper.b(NewSubPbActivity.this.mSaveImageUrl, NewSubPbActivity.this.mSaveBdImage.n());
                                                                            NewSubPbActivity.this.mSaveBdImage = null;
                                                                            NewSubPbActivity.this.mSaveImageUrl = null;
                                                                            return;
                                                                        }
                                                                    } else if (NewSubPbActivity.this.mSaveBdImage == null || TextUtils.isEmpty(NewSubPbActivity.this.mSaveImageUrl)) {
                                                                        return;
                                                                    } else {
                                                                        if (NewSubPbActivity.this.mEmotionInfo == null) {
                                                                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, NewSubPbActivity.this.mSaveImageUrl));
                                                                        } else {
                                                                            d.a aVar = new d.a();
                                                                            aVar.f52600a = NewSubPbActivity.this.mSaveImageUrl;
                                                                            if (NewSubPbActivity.this.mEmotionInfo.memeInfo.pck_id.intValue() >= 0) {
                                                                                str4 = "" + NewSubPbActivity.this.mEmotionInfo.memeInfo.pck_id;
                                                                            }
                                                                            aVar.f52601b = str4;
                                                                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                                                                        }
                                                                        NewSubPbActivity.this.mSaveBdImage = null;
                                                                        NewSubPbActivity.this.mSaveImageUrl = null;
                                                                        return;
                                                                    }
                                                                }
                                                                NewSubPbActivity newSubPbActivity4 = NewSubPbActivity.this;
                                                                PostData postData5 = newSubPbActivity4.postData;
                                                                if (postData5 != null) {
                                                                    postData5.h0(newSubPbActivity4.getPageContext().getPageActivity());
                                                                    NewSubPbActivity.this.postData = null;
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            SparseArray sparseArray6 = (SparseArray) view.getTag();
                                                            if (sparseArray6 != null && (sparseArray6.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray6.get(R.id.tag_del_post_id) instanceof String) && (sparseArray6.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray6.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                                                                boolean booleanValue4 = ((Boolean) sparseArray6.get(R.id.tag_del_post_is_self)).booleanValue();
                                                                int intValue = ((Integer) sparseArray6.get(R.id.tag_manage_user_identity)).intValue();
                                                                boolean booleanValue5 = ((Boolean) sparseArray6.get(R.id.tag_has_sub_post)).booleanValue();
                                                                boolean isHost = NewSubPbActivity.this.isHost(TbadkCoreApplication.getCurrentAccount());
                                                                if (isHost) {
                                                                    if (!booleanValue5) {
                                                                        NewSubPbActivity.this.showDelNoSubPostDialog(sparseArray6, intValue, booleanValue4);
                                                                        return;
                                                                    } else {
                                                                        NewSubPbActivity.this.mSubPbView.g0(((Integer) sparseArray6.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray6.get(R.id.tag_del_post_id), intValue, booleanValue4, isHost);
                                                                        return;
                                                                    }
                                                                } else if (booleanValue4 && !booleanValue5) {
                                                                    NewSubPbActivity.this.showDelNoSubPostDialog(sparseArray6, intValue, booleanValue4);
                                                                    return;
                                                                } else {
                                                                    NewSubPbActivity.this.mSubPbView.g0(((Integer) sparseArray6.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray6.get(R.id.tag_del_post_id), intValue, booleanValue4, isHost);
                                                                    return;
                                                                }
                                                            }
                                                            return;
                                                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                            NewSubPbActivity.this.markFloor(view);
                                                            return;
                                                        } else {
                                                            return;
                                                        }
                                                    } else if (!d.a.c.e.p.j.z()) {
                                                        NewSubPbActivity.this.showToast(R.string.network_not_available);
                                                        return;
                                                    } else {
                                                        Object tag = view.getTag();
                                                        if (tag instanceof String) {
                                                            NewSubPbActivity.this.handleReportClicked((String) tag);
                                                            return;
                                                        } else if (tag instanceof SparseArray) {
                                                            SparseArray<Object> sparseArray7 = (SparseArray) tag;
                                                            if ((sparseArray7.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray7.get(R.id.tag_user_mute_visible)).booleanValue()) {
                                                                sparseArray7.put(R.id.tag_from, 0);
                                                                sparseArray7.put(R.id.tag_check_mute_from, 2);
                                                                NewSubPbActivity.this.checkMuteState(sparseArray7);
                                                                return;
                                                            }
                                                            return;
                                                        } else {
                                                            return;
                                                        }
                                                    }
                                                } else if (NewSubPbActivity.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                    SparseArray sparseArray8 = (SparseArray) view.getTag();
                                                    if ((sparseArray8.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray8.get(R.id.tag_load_sub_data)) != null) {
                                                        if (NewSubPbActivity.this.mSubPbModel != null) {
                                                            TiebaStatic.log(new StatisticItem("c13700").param("tid", NewSubPbActivity.this.mSubPbModel.l0()).param("fid", NewSubPbActivity.this.mSubPbModel.getFromForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData.E()).param("obj_source", 1).param("obj_type", 3));
                                                        }
                                                        NewSubPbActivity.this.openEditor(postData, ((view.getTag(R.id.tag_subpb_ban_display_keyboard) instanceof Boolean) && view.getTag(R.id.tag_subpb_ban_display_keyboard) == Boolean.TRUE) ? false : false);
                                                        return;
                                                    }
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                if (NewSubPbActivity.this.mEditor.y()) {
                                                    NewSubPbActivity.this.mEditor.w();
                                                    return;
                                                } else {
                                                    NewSubPbActivity.this.mEditor.f0(null);
                                                    return;
                                                }
                                            } else {
                                                return;
                                            }
                                        } else if (view.getTag() == null || !(view.getTag() instanceof SparseArray)) {
                                            return;
                                        } else {
                                            SparseArray sparseArray9 = (SparseArray) view.getTag();
                                            if (sparseArray9.get(R.id.tag_clip_board) instanceof PostData) {
                                                ((PostData) sparseArray9.get(R.id.tag_clip_board)).h0(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                                    if (!d.a.c.e.p.j.z()) {
                                        NewSubPbActivity.this.showToast(R.string.network_not_available);
                                        return;
                                    }
                                    Object tag2 = view.getTag();
                                    NewSubPbActivity.this.mSubPbView.w();
                                    if (tag2 instanceof String) {
                                        String str5 = (String) tag2;
                                        if (NewSubPbActivity.this.checkUpIsLogin()) {
                                            NewSubPbActivity.this.handleReportClicked(str5);
                                            return;
                                        }
                                        return;
                                    } else if (tag2 instanceof SparseArray) {
                                        SparseArray<Object> sparseArray10 = (SparseArray) tag2;
                                        if ((sparseArray10.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray10.get(R.id.tag_user_mute_visible)).booleanValue()) {
                                            sparseArray10.put(R.id.tag_from, 0);
                                            sparseArray10.put(R.id.tag_check_mute_from, 2);
                                            NewSubPbActivity.this.checkMuteState(sparseArray10);
                                            return;
                                        }
                                        return;
                                    } else {
                                        return;
                                    }
                                } else if (d.a.c.e.p.j.z()) {
                                    NewSubPbActivity.this.mSubPbView.w();
                                    if (NewSubPbActivity.this.checkUpIsLogin()) {
                                        NewSubPbActivity.this.doManager(view);
                                        return;
                                    }
                                    return;
                                } else {
                                    NewSubPbActivity.this.showToast(R.string.network_not_available);
                                    return;
                                }
                            }
                            NewSubPbActivity.this.mSubPbView.w();
                            SparseArray sparseArray11 = (SparseArray) view.getTag();
                            if (sparseArray11 == null) {
                                return;
                            }
                            NewSubPbActivity.this.mSubPbView.g0(((Integer) sparseArray11.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray11.get(R.id.tag_del_post_id), ((Integer) sparseArray11.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray11.get(R.id.tag_del_post_is_self)).booleanValue(), false);
                        } else {
                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                            NewSubPbActivity.this.mSubPbView.w();
                            if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.mSubPbModel.X() != null) {
                                NewSubPbActivity newSubPbActivity5 = NewSubPbActivity.this;
                                newSubPbActivity5.markFloor(newSubPbActivity5.mSubPbModel.X().i());
                            }
                        }
                    } else {
                        try {
                            sparseArray2 = (SparseArray) view.getTag();
                        } catch (ClassCastException e2) {
                            e2.printStackTrace();
                        }
                        if (sparseArray2 == null || ((PostData) sparseArray2.get(R.id.tag_clip_board)) == null) {
                            return;
                        }
                        if (NewSubPbActivity.this.mPostMoreOptionView == null) {
                            NewSubPbActivity.this.mPostMoreOptionView = new d.a.o0.e2.k.e.d0(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.mCommonClickListener);
                            NewSubPbActivity.this.mSubPbView.w0(NewSubPbActivity.this.mPostMoreOptionView.F());
                            NewSubPbActivity.this.mPostMoreOptionView.n(NewSubPbActivity.this.mIsLogin);
                        }
                        NewSubPbActivity.this.mPostMoreOptionView.l();
                        NewSubPbActivity.this.mPostMoreOptionView.o(sparseArray2, NewSubPbActivity.this.getUserIdentity(), (NewSubPbActivity.this.isShowReportButton(sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue() : false) && NewSubPbActivity.this.isLogin()) ? false : false, NewSubPbActivity.this.mSubPbModel.X());
                    }
                } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                    NewSubPbActivity.this.mSubPbView.K0();
                    NewSubPbActivity.this.mSubPbView.u();
                    if (NewSubPbActivity.this.mEditor != null) {
                        NewSubPbActivity.this.mEditor.a0();
                    }
                }
            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                NewSubPbActivity.this.processProfessionPermission();
                if (NewSubPbActivity.this.mSubPbModel == null || NewSubPbActivity.this.mSubPbModel.X() == null || NewSubPbActivity.this.mSubPbModel.X().l() == null || NewSubPbActivity.this.mSubPbModel.X().l().T() == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13402").param("tid", NewSubPbActivity.this.mSubPbModel.k0()).param("fid", NewSubPbActivity.this.mSubPbModel.X().l().c0()).param("obj_locate", 5).param("uid", NewSubPbActivity.this.mSubPbModel.X().l().T().getUserId()));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l0 extends CustomMessageListener {
        public l0(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.MESSAGE_ID_NEWSUB_PB) {
                NewSubPbActivity.this.mSubPbView.R();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.mToastMute.c(NewSubPbActivity.this.mCtx.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.mCtx.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.showUserMuteAddDialog(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.showOpenMemberReplyDialog();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (d.a.c.e.p.k.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.mCtx.getResources().getString(R.string.mute_fail);
                    }
                    NewSubPbActivity.this.mToastMute.b(errorString2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements AbsListView.OnScrollListener {
        public m() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            NewSubPbActivity.this.mSubPbView.f0();
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            if (i2 == 2 || i2 == 1) {
                NewSubPbActivity.this.mSubPbView.w();
                if (NewSubPbActivity.this.lastScrollState != 2 && NewSubPbActivity.this.lastScrollState != 1) {
                    NewSubPbActivity.this.mSubPbView.T();
                }
            }
            NewSubPbActivity.this.mEditor.w();
        }
    }

    /* loaded from: classes5.dex */
    public class m0 extends CustomMessageListener {
        public m0(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.MESSAGE_ID_NEWSUB_PB) {
                NewSubPbActivity.this.mSubPbView.R();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.mToastMute.c(NewSubPbActivity.this.mCtx.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (d.a.c.e.p.k.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.mCtx.getResources().getString(R.string.un_mute_fail);
                }
                NewSubPbActivity.this.mToastMute.b(muteMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements View.OnLongClickListener {
        public n() {
        }

        /* JADX WARN: Removed duplicated region for block: B:72:0x018c A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:73:0x018d  */
        @Override // android.view.View.OnLongClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onLongClick(View view) {
            SparseArray<Object> sparseArray;
            SparseArray<Object> sparseArray2;
            SparseArray<Object> sparseArray3;
            if (NewSubPbActivity.this.mSubPbView != null && NewSubPbActivity.this.mSubPbView.Y()) {
                return false;
            }
            try {
                sparseArray = (SparseArray) view.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null && NewSubPbActivity.this.isImage(view)) {
                if (view instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) view;
                    NewSubPbActivity.this.mSaveBdImage = tbImageView.getBdImage();
                    NewSubPbActivity.this.mSaveImageUrl = tbImageView.getUrl();
                    if (NewSubPbActivity.this.mSaveBdImage == null || TextUtils.isEmpty(NewSubPbActivity.this.mSaveImageUrl)) {
                        return true;
                    }
                    if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        NewSubPbActivity.this.mEmotionInfo = null;
                    } else {
                        NewSubPbActivity.this.mEmotionInfo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    }
                } else if (view instanceof GifView) {
                    GifView gifView = (GifView) view;
                    if (gifView.getBdImage() == null) {
                        return true;
                    }
                    NewSubPbActivity.this.mSaveBdImage = gifView.getBdImage();
                    if (!TextUtils.isEmpty(gifView.getBdImage().q())) {
                        NewSubPbActivity.this.mSaveImageUrl = gifView.getBdImage().q();
                    }
                    if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        NewSubPbActivity.this.mEmotionInfo = null;
                    } else {
                        NewSubPbActivity.this.mEmotionInfo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    }
                } else if (view instanceof TbMemeImageView) {
                    TbMemeImageView tbMemeImageView = (TbMemeImageView) view;
                    if (tbMemeImageView.getBdImage() != null) {
                        NewSubPbActivity.this.mSaveBdImage = tbMemeImageView.getBdImage();
                        if (!TextUtils.isEmpty(tbMemeImageView.getBdImage().q())) {
                            NewSubPbActivity.this.mSaveImageUrl = tbMemeImageView.getBdImage().q();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.mEmotionInfo = null;
                        } else {
                            NewSubPbActivity.this.mEmotionInfo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    }
                }
                if (view.getParent() instanceof TbRichTextView) {
                    try {
                        sparseArray3 = (SparseArray) ((TbRichTextView) view.getParent()).getTag();
                    } catch (ClassCastException e3) {
                        e3.printStackTrace();
                    }
                } else if (!(view.getParent().getParent() instanceof TbRichTextView)) {
                    NewSubPbActivity.this.mSubPbView.E0(NewSubPbActivity.this.mOnImageSaveClickListener, NewSubPbActivity.this.mSaveBdImage.t());
                } else {
                    try {
                        sparseArray3 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                    } catch (ClassCastException e4) {
                        e4.printStackTrace();
                    }
                }
                sparseArray2 = sparseArray3;
                if (sparseArray2 != null) {
                    return true;
                }
                NewSubPbActivity.this.postData = (PostData) sparseArray2.get(R.id.tag_clip_board);
                NewSubPbActivity newSubPbActivity = NewSubPbActivity.this;
                if (newSubPbActivity.postData == null || newSubPbActivity.mMarkModel == null) {
                    return true;
                }
                if (NewSubPbActivity.this.mMarkModel != null) {
                    NewSubPbActivity.this.mMarkModel.h(NewSubPbActivity.this.mSubPbModel.v0());
                }
                boolean z = NewSubPbActivity.this.mMarkModel.e() && NewSubPbActivity.this.postData.E() != null && NewSubPbActivity.this.postData.E().equals(NewSubPbActivity.this.mSubPbModel.f0());
                if (NewSubPbActivity.this.mPostMoreOptionView == null) {
                    NewSubPbActivity.this.mPostMoreOptionView = new d.a.o0.e2.k.e.d0(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.mCommonClickListener);
                    NewSubPbActivity.this.mSubPbView.w0(NewSubPbActivity.this.mPostMoreOptionView.F());
                    NewSubPbActivity.this.mPostMoreOptionView.n(NewSubPbActivity.this.mIsLogin);
                }
                NewSubPbActivity.this.mPostMoreOptionView.l();
                boolean z2 = NewSubPbActivity.this.isShowReportButton(sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue() : false) && NewSubPbActivity.this.isLogin();
                boolean z3 = (NewSubPbActivity.this.mSubPbModel.X() == null || NewSubPbActivity.this.mSubPbModel.X().l() == null || !NewSubPbActivity.this.mSubPbModel.X().l().V1()) ? false : true;
                boolean booleanValue = sparseArray2.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_is_subpb)).booleanValue() : false;
                if (z) {
                    NewSubPbActivity.this.mPostMoreOptionView.z().setText(R.string.remove_mark);
                } else {
                    NewSubPbActivity.this.mPostMoreOptionView.z().setText(R.string.mark);
                }
                if (booleanValue || z3) {
                    NewSubPbActivity.this.mPostMoreOptionView.z().setVisibility(8);
                } else {
                    NewSubPbActivity.this.mPostMoreOptionView.z().setVisibility(0);
                }
                if (NewSubPbActivity.this.isImage(view)) {
                    if (NewSubPbActivity.this.mSaveBdImage != null && !NewSubPbActivity.this.mSaveBdImage.t()) {
                        sparseArray2.put(R.id.tag_richtext_image, Boolean.TRUE);
                    } else {
                        sparseArray2.put(R.id.tag_richtext_image, Boolean.FALSE);
                    }
                    sparseArray2.put(R.id.tag_richtext_emotion, Boolean.TRUE);
                } else {
                    sparseArray2.put(R.id.tag_richtext_image, Boolean.FALSE);
                    sparseArray2.put(R.id.tag_richtext_emotion, Boolean.FALSE);
                }
                d.a.o0.e2.h.r X = NewSubPbActivity.this.mSubPbModel.X();
                NewSubPbActivity.this.mPostMoreOptionView.j(d.a.o0.e2.k.e.e1.a.f(NewSubPbActivity.this.postData));
                NewSubPbActivity.this.mPostMoreOptionView.p(sparseArray2, NewSubPbActivity.this.getUserIdentity(), z2, NewSubPbActivity.this.showTrisectionAndFeedback && NewSubPbActivity.this.postData.m0, X);
                return true;
            }
            sparseArray2 = sparseArray;
            if (sparseArray2 != null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n0 extends CustomMessageListener {
        public n0(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof d.a.o0.p3.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.MESSAGE_ID_NEWSUB_PB) {
                d.a.o0.p3.a aVar = (d.a.o0.p3.a) customResponsedMessage.getData();
                NewSubPbActivity.this.mSubPbView.R();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.f61976a;
                if (aVar.f61978c == 0 && dataRes != null) {
                    z = d.a.c.e.m.b.d(dataRes.is_mute, 0) == 1;
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_user_mute_msg, dataRes.mute_confirm);
                } else {
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                    z = false;
                }
                int intValue = sparseArray.get(R.id.tag_from) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_from)).intValue() : 0;
                if (intValue == 0) {
                    NewSubPbActivity.this.showOperateDialog(z, sparseArray);
                } else if (intValue == 1) {
                    NewSubPbActivity.this.mSubPbView.h0(sparseArray, z);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o implements TbRichTextView.x {
        public o() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v7, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$b */
        /* JADX DEBUG: Multi-variable search result rejected for r6v8, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$b */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.x
        public void a(View view, String str, int i2, boolean z, boolean z2) {
            String str2;
            String str3;
            boolean z3;
            String str4;
            String str5;
            boolean z4;
            String str6;
            String str7;
            String str8;
            try {
                if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                    d.a.o0.e2.h.r X = NewSubPbActivity.this.mSubPbModel.X();
                    TbRichText validImage = NewSubPbActivity.this.validImage(str, i2);
                    TbRichTextData tbRichTextData = (validImage == null || validImage.y() == null) ? null : validImage.y().get(NewSubPbActivity.this.imgIndex);
                    if (tbRichTextData == null) {
                        return;
                    }
                    ArrayList<String> arrayList = new ArrayList<>();
                    ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                    if (!tbRichTextData.B().D()) {
                        String encodeImageUrl = NewSubPbActivity.this.encodeImageUrl(tbRichTextData);
                        arrayList.add(encodeImageUrl);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = str;
                        imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                        concurrentHashMap.put(encodeImageUrl, imageUrlData);
                        if (X != null) {
                            if (X.d() != null) {
                                str6 = X.d().getName();
                                str7 = X.d().getId();
                            } else {
                                str6 = null;
                                str7 = null;
                            }
                            str8 = X.l() != null ? X.l().o0() : null;
                            z4 = true;
                        } else {
                            z4 = false;
                            str6 = null;
                            str7 = null;
                            str8 = null;
                        }
                        if (NewSubPbActivity.this.mSubPbModel.n0() != null) {
                            concurrentHashMap = NewSubPbActivity.this.mSubPbModel.n0();
                            z4 = NewSubPbActivity.this.mSubPbModel.r0();
                            arrayList = NewSubPbActivity.this.mSubPbModel.m0();
                        }
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(ListUtils.getItem(arrayList, 0));
                        ImageViewerConfig.b bVar = new ImageViewerConfig.b();
                        bVar.x(arrayList2);
                        bVar.z(str6);
                        bVar.y(str7);
                        bVar.O(str8);
                        bVar.C(z4);
                        bVar.J(arrayList.get(0));
                        bVar.F(true);
                        bVar.w(concurrentHashMap);
                        bVar.H(true);
                        bVar.K(false);
                        bVar.G(false);
                        bVar.N(NewSubPbActivity.this.getThreadData());
                        bVar.L(String.valueOf(validImage.getPostId()));
                        bVar.A(NewSubPbActivity.this.mSubPbModel.getFromForumId());
                        NewSubPbActivity.this.sendMessage(new CustomMessage(2010000, bVar.v(NewSubPbActivity.this.getPageContext().getPageActivity())));
                        return;
                    }
                    NewSubPbActivity.this.index_valid = false;
                    TbRichText K = X.i().K();
                    int size = arrayList.size();
                    int imageIndex = NewSubPbActivity.this.getImageIndex(K, validImage, i2, i2, arrayList, concurrentHashMap);
                    int size2 = arrayList.size();
                    String str9 = size != size2 ? arrayList.get(size2 - 1) : "";
                    if (X != null) {
                        if (X.d() != null) {
                            str5 = X.d().getName();
                            str3 = X.d().getId();
                        } else {
                            str5 = null;
                            str3 = null;
                        }
                        str2 = X.l() != null ? X.l().o0() : null;
                        z3 = true;
                        str4 = str5;
                    } else {
                        str2 = null;
                        str3 = null;
                        z3 = false;
                        str4 = null;
                    }
                    if (NewSubPbActivity.this.mSubPbModel.n0() != null) {
                        concurrentHashMap = NewSubPbActivity.this.mSubPbModel.n0();
                        z3 = NewSubPbActivity.this.mSubPbModel.r0();
                        arrayList = NewSubPbActivity.this.mSubPbModel.m0();
                        imageIndex += NewSubPbActivity.this.mSubPbModel.g0();
                    }
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(ListUtils.getItem(arrayList, imageIndex));
                    ImageViewerConfig.b bVar2 = new ImageViewerConfig.b();
                    bVar2.x(arrayList3);
                    bVar2.z(str4);
                    bVar2.y(str3);
                    bVar2.O(str2);
                    bVar2.C(z3);
                    bVar2.J(str9);
                    bVar2.F(true);
                    bVar2.w(concurrentHashMap);
                    bVar2.H(true);
                    bVar2.K(false);
                    bVar2.G(false);
                    bVar2.N(NewSubPbActivity.this.getThreadData());
                    bVar2.L(String.valueOf(validImage.getPostId()));
                    bVar2.A(NewSubPbActivity.this.mSubPbModel.getFromForumId());
                    NewSubPbActivity.this.sendMessage(new CustomMessage(2010000, bVar2.v(NewSubPbActivity.this.getPageContext().getPageActivity())));
                    return;
                }
                TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                boolean H = ((TbImageView) view).H();
                if (tbRichTextMemeInfo == null || tbRichTextMemeInfo.memeInfo == null) {
                    return;
                }
                NewSubPbActivity.this.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, H)));
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o0 implements f.g {
        public o0() {
        }

        @Override // d.a.n0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (NewSubPbActivity.this.mSubPbModel != null) {
                NewSubPbActivity.this.mSubPbModel.B0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p implements b.c {
        public p() {
        }

        @Override // d.a.n0.r.s.b.c
        public void a(d.a.n0.r.s.b bVar, int i2, View view) {
            bVar.e();
            if (NewSubPbActivity.this.mSaveBdImage == null || TextUtils.isEmpty(NewSubPbActivity.this.mSaveImageUrl)) {
                return;
            }
            if (i2 == 0) {
                if (NewSubPbActivity.this.mEmotionInfo == null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, NewSubPbActivity.this.mSaveImageUrl));
                } else {
                    d.a aVar = new d.a();
                    aVar.f52600a = NewSubPbActivity.this.mSaveImageUrl;
                    String str = "";
                    if (NewSubPbActivity.this.mEmotionInfo.memeInfo.pck_id.intValue() >= 0) {
                        str = "" + NewSubPbActivity.this.mEmotionInfo.memeInfo.pck_id;
                    }
                    aVar.f52601b = str;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                }
            } else if (i2 == 1) {
                if (NewSubPbActivity.this.mPermissionJudgement == null) {
                    NewSubPbActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                }
                NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                if (NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                    return;
                }
                if (NewSubPbActivity.this.mSaveImageHelper == null) {
                    NewSubPbActivity newSubPbActivity = NewSubPbActivity.this;
                    newSubPbActivity.mSaveImageHelper = new x0(newSubPbActivity.getPageContext());
                }
                NewSubPbActivity.this.mSaveImageHelper.b(NewSubPbActivity.this.mSaveImageUrl, NewSubPbActivity.this.mSaveBdImage.n());
            }
            NewSubPbActivity.this.mSaveBdImage = null;
            NewSubPbActivity.this.mSaveImageUrl = null;
        }
    }

    /* loaded from: classes5.dex */
    public class p0 implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
        public p0() {
        }

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i2) {
            if (z) {
                NewSubPbActivity.this.mEditor.D();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q implements c.d {
        public q() {
        }

        @Override // d.a.o0.r0.f2.a.c.d
        public void a(boolean z, int i2) {
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x00c9  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00d3  */
        @Override // d.a.o0.r0.f2.a.c.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void b(boolean z) {
            String str;
            if (!z) {
                return;
            }
            NewSubPbActivity newSubPbActivity = NewSubPbActivity.this;
            if (newSubPbActivity.mReplyPrivacyController != null && newSubPbActivity.mSubPbModel != null && NewSubPbActivity.this.mSubPbModel.V() != null && !NewSubPbActivity.this.isHost(TbadkCoreApplication.getCurrentAccount())) {
                NewSubPbActivity newSubPbActivity2 = NewSubPbActivity.this;
                if (!newSubPbActivity2.mReplyPrivacyController.checkPrivacyBeforeInvokeEditor(newSubPbActivity2.mSubPbModel.V().replyPrivateFlag)) {
                    return;
                }
            }
            if (NewSubPbActivity.this.mSubPbModel != null && NewSubPbActivity.this.mSubPbModel.X() != null && NewSubPbActivity.this.mSubPbModel.X().i() != null) {
                PostData i2 = NewSubPbActivity.this.mSubPbModel.X().i();
                if (i2.K() != null && i2.t() != null) {
                    str = String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), i2.t().getName_show(), i2.K().toString());
                    NewSubPbActivity.this.mEditor.a().A(new d.a.n0.w.a(45, 27, str));
                    if (!NewSubPbActivity.this.mEditor.v()) {
                        NewSubPbActivity.this.mEditor.t(null);
                        return;
                    }
                    NewSubPbActivity.this.mSubPbView.K0();
                    NewSubPbActivity.this.mSubPbView.u();
                    if (NewSubPbActivity.this.mEditor != null) {
                        NewSubPbActivity.this.mEditor.e0();
                        return;
                    }
                    return;
                }
            }
            str = null;
            NewSubPbActivity.this.mEditor.a().A(new d.a.n0.w.a(45, 27, str));
            if (!NewSubPbActivity.this.mEditor.v()) {
            }
        }

        @Override // d.a.o0.r0.f2.a.c.d
        public void c(boolean z) {
        }
    }

    /* loaded from: classes5.dex */
    public interface q0 {
        void a(Object obj);
    }

    /* loaded from: classes5.dex */
    public class r implements TextWatcher {
        public r() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (NewSubPbActivity.this.mSensitiveProcessController == null) {
                return;
            }
            if (!NewSubPbActivity.this.mSensitiveProcessController.e()) {
                NewSubPbActivity.this.checkContentSensitiveWord(false);
            }
            NewSubPbActivity.this.mSensitiveProcessController.l(false);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* loaded from: classes5.dex */
    public class s implements b.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SparseArray f19467a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f19468b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f19469c;

        public s(SparseArray sparseArray, boolean z, String str) {
            this.f19467a = sparseArray;
            this.f19468b = z;
            this.f19469c = str;
        }

        @Override // d.a.n0.r.s.b.c
        public void a(d.a.n0.r.s.b bVar, int i2, View view) {
            if (i2 == 0) {
                String str = this.f19467a.get(R.id.tag_user_mute_mute_username) instanceof String ? (String) this.f19467a.get(R.id.tag_user_mute_mute_username) : "";
                String str2 = this.f19467a.get(R.id.tag_user_mute_thread_id) instanceof String ? (String) this.f19467a.get(R.id.tag_user_mute_thread_id) : "";
                String str3 = this.f19467a.get(R.id.tag_user_mute_post_id) instanceof String ? (String) this.f19467a.get(R.id.tag_user_mute_post_id) : "";
                String str4 = this.f19467a.get(R.id.tag_user_mute_msg) instanceof String ? (String) this.f19467a.get(R.id.tag_user_mute_msg) : "";
                String str5 = this.f19467a.get(R.id.tag_user_mute_mute_nameshow) instanceof String ? (String) this.f19467a.get(R.id.tag_user_mute_mute_nameshow) : "";
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                userMuteAddAndDelCustomMessage.setData(this.f19468b, this.f19469c, str, str2, str3, 1, str4, NewSubPbActivity.this.MESSAGE_ID_NEWSUB_PB);
                userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.MESSAGE_ID_NEWSUB_PB);
                NewSubPbActivity.this.showUserMuteDialog(this.f19468b, userMuteAddAndDelCustomMessage, str4, str, str5);
            }
            bVar.e();
        }
    }

    /* loaded from: classes5.dex */
    public class t extends CustomMessageListener {
        public t(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof f.a)) {
                return;
            }
            f.a aVar = (f.a) customResponsedMessage.getData();
            d.a.n0.b1.m.f.b(NewSubPbActivity.this.getPageContext(), aVar.f52910a, aVar.f52911b, aVar.f52912c);
        }
    }

    /* loaded from: classes5.dex */
    public class u implements d.a.c.e.k.c<GifView> {
        public u() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ GifView c(GifView gifView) {
            GifView gifView2 = gifView;
            h(gifView2);
            return gifView2;
        }

        public GifView e(GifView gifView) {
            return gifView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(GifView gifView) {
            gifView.l0();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public GifView d() {
            return new GifView(NewSubPbActivity.this.getPageContext().getPageActivity());
        }

        public GifView h(GifView gifView) {
            return gifView;
        }
    }

    /* loaded from: classes5.dex */
    public class v implements d.a.n0.w.w.b {
        public v() {
        }

        @Override // d.a.n0.w.w.b
        public boolean a() {
            if (NewSubPbActivity.this.mSensitiveProcessController.d()) {
                NewSubPbActivity newSubPbActivity = NewSubPbActivity.this;
                newSubPbActivity.showToast(newSubPbActivity.mSensitiveProcessController.c());
                if (NewSubPbActivity.this.mEditor.v()) {
                    NewSubPbActivity.this.mEditor.t(NewSubPbActivity.this.mPostWriteCallBackData);
                }
                NewSubPbActivity.this.checkContentSensitiveWord(true);
                return true;
            }
            NewSubPbActivity newSubPbActivity2 = NewSubPbActivity.this;
            if (newSubPbActivity2.mReplyPrivacyController == null || newSubPbActivity2.mSubPbModel == null || NewSubPbActivity.this.mSubPbModel.V() == null || NewSubPbActivity.this.isHost(TbadkCoreApplication.getCurrentAccount())) {
                return false;
            }
            NewSubPbActivity newSubPbActivity3 = NewSubPbActivity.this;
            return !newSubPbActivity3.mReplyPrivacyController.checkPrivacyBeforeSend(newSubPbActivity3.mSubPbModel.V().replyPrivateFlag, ReplyPrivacyCheckController.TYPE_FLOOR);
        }
    }

    /* loaded from: classes5.dex */
    public class w implements d.a.c.e.k.c<ImageView> {
        public w() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        public ImageView e(ImageView imageView) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                tbImageView.setTag(null);
                if (d.a.n0.r.k.c().g()) {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(ImageView imageView) {
            imageView.setBackgroundDrawable(null);
            imageView.setImageDrawable(null);
            imageView.setTag(null);
            imageView.setOnClickListener(null);
            if (imageView instanceof ForeDrawableImageView) {
                ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                foreDrawableImageView.Z();
                foreDrawableImageView.setForegroundDrawable(0);
                foreDrawableImageView.setDefaultBgResource(R.color.CAM_X0204);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public ImageView d() {
            ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
            boolean g2 = d.a.n0.r.k.c().g();
            foreDrawableImageView.setDefaultBg(SkinManager.getDrawable(R.color.common_color_10220));
            if (g2) {
                foreDrawableImageView.setAdjustViewBounds(false);
                foreDrawableImageView.setInterceptOnClick(false);
            } else {
                foreDrawableImageView.setDefaultResource(R.drawable.icon_click);
                foreDrawableImageView.setAdjustViewBounds(true);
                foreDrawableImageView.setInterceptOnClick(true);
            }
            return foreDrawableImageView;
        }

        public ImageView h(ImageView imageView) {
            imageView.setBackgroundDrawable(null);
            imageView.setImageDrawable(null);
            imageView.setTag(null);
            imageView.setOnClickListener(null);
            if (imageView instanceof ForeDrawableImageView) {
                ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                foreDrawableImageView.Z();
                foreDrawableImageView.setForegroundDrawable(0);
                foreDrawableImageView.setDefaultBgResource(R.color.CAM_X0204);
            }
            return imageView;
        }
    }

    /* loaded from: classes5.dex */
    public class x implements d.a.c.e.k.c<View> {
        public x() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ View a(View view) {
            View view2 = view;
            e(view2);
            return view2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ View c(View view) {
            View view2 = view;
            h(view2);
            return view2;
        }

        public View e(View view) {
            return view;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(View view) {
            ((PlayVoiceBntNew) view).l();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public View d() {
            PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(NewSubPbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
            playVoiceBntNew.setVoiceManager(NewSubPbActivity.this.getVoiceManager());
            playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
            return playVoiceBntNew;
        }

        public View h(View view) {
            ((PlayVoiceBntNew) view).l();
            return view;
        }
    }

    /* loaded from: classes5.dex */
    public class y implements d.a.c.e.k.c<LinearLayout> {
        public y() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ LinearLayout a(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            e(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ LinearLayout c(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            h(linearLayout2);
            return linearLayout2;
        }

        public LinearLayout e(LinearLayout linearLayout) {
            return linearLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(LinearLayout linearLayout) {
            linearLayout.removeAllViews();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public LinearLayout d() {
            LinearLayout linearLayout = new LinearLayout(NewSubPbActivity.this.getPageContext().getPageActivity());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.setGravity(16);
            linearLayout.setBaselineAligned(true);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(layoutParams);
            return linearLayout;
        }

        public LinearLayout h(LinearLayout linearLayout) {
            linearLayout.removeAllViews();
            return linearLayout;
        }
    }

    /* loaded from: classes5.dex */
    public class z implements d.a.c.e.k.c<RelativeLayout> {
        public z() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ RelativeLayout a(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            e(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ RelativeLayout c(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            h(relativeLayout2);
            return relativeLayout2;
        }

        public RelativeLayout e(RelativeLayout relativeLayout) {
            return relativeLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(RelativeLayout relativeLayout) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public RelativeLayout d() {
            return new RelativeLayout(NewSubPbActivity.this.getPageContext().getPageActivity());
        }

        public RelativeLayout h(RelativeLayout relativeLayout) {
            return relativeLayout;
        }
    }

    private boolean checkIsIfPostForbid() {
        SubPbModel subPbModel = this.mSubPbModel;
        if (subPbModel == null) {
            return false;
        }
        return AntiHelper.d(getPageContext(), subPbModel.V());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void clickOnDisagree(AgreeData agreeData) {
        d.a.n0.i0.c k2;
        if (agreeData == null) {
            return;
        }
        if (this.mMessageHelper == null) {
            this.mMessageHelper = new d.a.n0.r.b0.a();
        }
        if (this.mMsgData == null) {
            d.a.o0.e3.h0.e eVar = new d.a.o0.e3.h0.e();
            this.mMsgData = eVar;
            eVar.f57810a = this.mOnlyDisagreeId;
        }
        d.a.n0.r.q.e eVar2 = new d.a.n0.r.q.e();
        eVar2.f53777b = 12;
        eVar2.f53783h = 9;
        eVar2.f53782g = 3;
        if (getSubPbModel() != null) {
            eVar2.f53781f = getSubPbModel().h0();
        }
        eVar2.f53776a = 2;
        int i2 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                eVar2.f53784i = 0;
                k2 = TbPageExtraHelper.k(getActivity());
                if (k2 != null) {
                    agreeData.objSource = k2.a();
                }
                this.mMessageHelper.c(agreeData, i2, getUniqueId(), false);
                this.mMessageHelper.d(agreeData, this.mMsgData);
                if (getSubPbModel() != null || getSubPbModel().X() == null) {
                }
                this.mMessageHelper.b(this, eVar2, agreeData, getSubPbModel().X().l());
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            eVar2.f53784i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            eVar2.f53784i = 1;
        }
        i2 = 0;
        k2 = TbPageExtraHelper.k(getActivity());
        if (k2 != null) {
        }
        this.mMessageHelper.c(agreeData, i2, getUniqueId(), false);
        this.mMessageHelper.d(agreeData, this.mMsgData);
        if (getSubPbModel() != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doManager(View view) {
        SparseArray<Object> sparseArray;
        if (view == null || (sparseArray = (SparseArray) view.getTag()) == null) {
            return;
        }
        boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
        boolean booleanValue2 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
        boolean booleanValue3 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
        if (booleanValue) {
            if (booleanValue3) {
                sparseArray.put(R.id.tag_from, 1);
                checkMuteState(sparseArray);
            } else {
                this.mSubPbView.i0(view);
            }
        } else if (booleanValue2) {
            this.mSubPbView.g0(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue(), false);
        }
        d.a.c.e.m.g.d(this.mSubPbView.M(), getPageContext().getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String encodeImageUrl(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo B = tbRichTextData.B();
        if (B != null) {
            if (!StringUtils.isNull(B.w())) {
                return B.w();
            }
            if (B.getHeight() * B.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (B.getHeight() * B.getWidth()));
                sb.append(BigImageLoaderProc.NCDN_PER);
                sb.append(String.valueOf((int) (B.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (B.getHeight() * sqrt)));
            } else {
                double width = B.getWidth() / B.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append(BigImageLoaderProc.NCDN_PER);
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(d.a.c.e.p.k.getUrlEncode(B.B()));
            return sb.toString();
        }
        return null;
    }

    private void fixReplyFloorViewHolderPosition(boolean z2) {
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
        int i2;
        View childAt;
        Rect rect = new Rect();
        FrameLayout frameLayout = (FrameLayout) findViewById(16908290);
        if (frameLayout != null && (childAt = frameLayout.getChildAt(0)) != null) {
            frameLayout.getWindowVisibleDisplayFrame(rect);
            if (z2) {
                ((FrameLayout.LayoutParams) childAt.getLayoutParams()).height = rect.height();
                childAt.requestLayout();
            }
        }
        d.a.o0.e2.k.g.a aVar = this.mSubPbView;
        if (aVar == null || aVar.G() == null || (pbCommenFloorItemViewHolder = this.mItemClickShowSoftKeyBoardViewHolder) == null || (i2 = pbCommenFloorItemViewHolder.U) == -1) {
            return;
        }
        int headerViewsCount = i2 + this.mSubPbView.G().getHeaderViewsCount();
        if (this.mItemClickShowSoftKeyBoardViewHolder.a() != null) {
            int height = this.mItemClickShowSoftKeyBoardViewHolder.a().getHeight();
            int height2 = ((rect.height() - this.mSubPbView.A()) - this.mSubPbView.I()) - this.mSubPbView.B();
            int i3 = height - height2;
            if (i3 > 0) {
                this.mSubPbView.G().post(new j0(headerViewsCount, i3));
            } else {
                this.mSubPbView.G().post(new k0(headerViewsCount, height2, height));
            }
        }
    }

    private TbRichText getImage(PostData postData, String str, int i2) {
        TbRichText K;
        if (postData != null && (K = postData.K()) != null) {
            ArrayList<TbRichTextData> y2 = K.y();
            int size = y2.size();
            int i3 = -1;
            for (int i4 = 0; i4 < size; i4++) {
                if (y2.get(i4) != null && y2.get(i4).getType() == 8) {
                    i3++;
                    if (y2.get(i4).B().y().equals(str)) {
                        int h2 = (int) d.a.c.e.p.l.h(TbadkCoreApplication.getInst());
                        int width = y2.get(i4).B().getWidth() * h2;
                        int height = y2.get(i4).B().getHeight() * h2;
                        if (width < 80 || height < 80 || width * height < 10000) {
                            return null;
                        }
                        this.imgIndex = i4;
                        return K;
                    } else if (i3 > i2) {
                        break;
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getImageIndex(TbRichText tbRichText, TbRichText tbRichText2, int i2, int i3, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        TbRichTextImageInfo B;
        if (tbRichText == tbRichText2) {
            this.index_valid = true;
        }
        if (tbRichText != null && tbRichText.y() != null) {
            int size = tbRichText.y().size();
            int i4 = -1;
            for (int i5 = 0; i5 < size; i5++) {
                if (tbRichText.y().get(i5) != null && tbRichText.y().get(i5).getType() == 8) {
                    i4++;
                    int h2 = (int) d.a.c.e.p.l.h(TbadkCoreApplication.getInst());
                    int width = tbRichText.y().get(i5).B().getWidth() * h2;
                    int height = tbRichText.y().get(i5).B().getHeight() * h2;
                    if (!(width < 80 || height < 80 || width * height < 10000) && tbRichText.y().get(i5).B().D()) {
                        TbRichTextData tbRichTextData = tbRichText.y().get(i5);
                        String encodeImageUrl = encodeImageUrl(tbRichTextData);
                        arrayList.add(encodeImageUrl);
                        if (!TextUtils.isEmpty(encodeImageUrl) && tbRichTextData != null && (B = tbRichTextData.B()) != null) {
                            String y2 = B.y();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = y2;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(encodeImageUrl, imageUrlData);
                            }
                        }
                        if (!this.index_valid) {
                            i2++;
                        }
                    } else if (tbRichText == tbRichText2 && i4 <= i3) {
                        i2--;
                    }
                }
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a2 getThreadData() {
        SubPbModel subPbModel = this.mSubPbModel;
        if (subPbModel == null || subPbModel.X() == null) {
            return null;
        }
        return this.mSubPbModel.X().l();
    }

    private void handleFullScreenEditorResult(int i2, Intent intent) {
        d.a.n0.w.n nVar;
        this.mEditor.a().q();
        this.mEditor.w();
        if (intent == null) {
            return;
        }
        Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
        if (serializableExtra instanceof PbEditorData) {
            PbEditorData pbEditorData = (PbEditorData) serializableExtra;
            WriteData writeData = new WriteData();
            writeData.setContent(pbEditorData.getContent());
            writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
            this.mEditor.z(writeData);
            this.mEditor.Y(pbEditorData.getVoiceModel());
            d.a.n0.w.m n2 = this.mEditor.a().n(6);
            if (n2 != null && (nVar = n2.k) != null) {
                nVar.onAction(new d.a.n0.w.a(52, 0, pbEditorData.getVoiceModel()));
            }
            if (i2 == -1) {
                this.mEditor.D();
            }
            this.mSubPbView.T();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initEditor(boolean z2) {
        SubPbModel subPbModel;
        d.a.n0.w.w.h hVar = (d.a.n0.w.w.h) new d.a.n0.w.w.i(z2).a(getActivity());
        this.mEditor = hVar;
        if (hVar != null) {
            hVar.L(getPageContext());
            this.mEditor.W(this.mSubPbModel);
            this.mEditor.N(this.mOnPostWriteNewCallback);
            this.mEditor.M(2);
            this.mEditor.Q(this.mPrePostCallBack);
            this.mEditor.K(this.mCheckPostCallBack);
            this.mEditor.a().C(true);
            this.mEditor.x(getPageContext());
        }
        d.a.o0.e2.k.g.a aVar = this.mSubPbView;
        if (aVar != null) {
            aVar.X(this.mEditor);
        }
        d.a.n0.w.w.h hVar2 = this.mEditor;
        if (hVar2 != null && (subPbModel = this.mSubPbModel) != null) {
            hVar2.E(subPbModel.V());
            this.mEditor.w();
        }
        d.a.n0.w.w.h hVar3 = this.mEditor;
        if (hVar3 == null) {
            return;
        }
        hVar3.s().k(getReplyHint());
        this.mEditor.s().l(getReplyHint());
        EditText i2 = this.mEditor.s().i();
        this.mSubFloorEditText = i2;
        i2.addTextChangedListener(new r());
    }

    private boolean initIsFromPb(Bundle bundle) {
        if (bundle != null) {
            this.mIsFromPb = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.mIsFromPb = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.mIsFromPb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShowReportButton(boolean z2) {
        if (this.mSubPbModel == null) {
            return false;
        }
        return ((getUserIdentity() != 0) || this.mSubPbModel.X() == null || this.mSubPbModel.X().l() == null || this.mSubPbModel.X().l().T() == null || this.mSubPbModel.X().l().C2() || TextUtils.equals(this.mSubPbModel.X().l().T().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z2) ? false : true;
    }

    private void jumpToWeb(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this, "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void markFloor(View view) {
        SparseArray sparseArray;
        PostData postData;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e2) {
            e2.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray == null || (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) == null) {
            return;
        }
        markFloor(postData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void navigateToBubbleWebView(String str) {
        if (!StringUtils.isNull(str) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
            String p2 = d.a.n0.r.d0.b.j().p("bubble_link", "");
            if (StringUtils.isNull(p2)) {
                return;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return;
            }
            d.a.n0.l.a.o(getPageContext().getPageActivity(), getResources().getString(R.string.editor_privilege), p2 + "?props_id=" + str, true, true, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onNetOrDataError(int i2, String str) {
        if (this.mSubPbModel.q0()) {
            showToast(str);
        } else if (!d.a.c.e.p.l.D()) {
            this.mSubPbView.C0(R.string.recommend_pb_no_net_text);
        } else if (i2 == 4) {
            d.a.o0.e2.k.g.a aVar = this.mSubPbView;
            aVar.D0(str + "(4" + SmallTailInfo.EMOTION_SUFFIX, true);
        } else if (!TextUtils.isEmpty(str)) {
            d.a.o0.e2.k.g.a aVar2 = this.mSubPbView;
            aVar2.D0(str + "(" + i2 + SmallTailInfo.EMOTION_SUFFIX, true);
        } else {
            this.mSubPbView.C0(R.string.no_data_text);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openEditor(SparseArray<Object> sparseArray, boolean z2) {
        if (sparseArray == null) {
            return;
        }
        if (sparseArray.get(R.id.tag_clip_board) instanceof PostData) {
            openEditor((PostData) sparseArray.get(R.id.tag_clip_board), z2);
        } else {
            openEditor((PostData) null, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processProfessionPermission() {
        SubPbModel subPbModel;
        Intent intent = getIntent();
        boolean booleanExtra = intent != null ? intent.getBooleanExtra("key_is_from_dynamic", false) : false;
        if (checkIsIfPostForbid()) {
            return;
        }
        if (booleanExtra) {
            if (this.mReplyPrivacyController == null || (subPbModel = this.mSubPbModel) == null || subPbModel.V() == null || isHost(TbadkCoreApplication.getCurrentAccount()) || this.mReplyPrivacyController.checkPrivacyBeforeInvokeEditor(this.mSubPbModel.V().replyPrivateFlag)) {
                if (this.mEditor.v()) {
                    this.mEditor.t(null);
                    return;
                }
                this.mSubPbView.K0();
                this.mSubPbView.u();
                d.a.n0.w.w.h hVar = this.mEditor;
                if (hVar != null) {
                    hVar.e0();
                    return;
                }
                return;
            }
            return;
        }
        if (this.mProfessionController == null) {
            d.a.o0.r0.f2.a.c cVar = new d.a.o0.r0.f2.a.c(getPageContext());
            this.mProfessionController = cVar;
            cVar.i(new q());
        }
        SubPbModel subPbModel2 = this.mSubPbModel;
        if (subPbModel2 == null || subPbModel2.X() == null || this.mSubPbModel.X().d() == null) {
            return;
        }
        this.mProfessionController.g(this.mSubPbModel.X().d().getId(), d.a.c.e.m.b.f(this.mSubPbModel.k0(), 0L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDelNoSubPostDialog(SparseArray<Object> sparseArray, int i2, boolean z2) {
        d.a.o0.e2.k.e.e1.a.d(this, getPageContext(), new i(sparseArray, i2, z2), new j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDeleteResumeEditorTips(View view, d.a.n0.w.w.h hVar, String str) {
        new WriteTipBubbleController(getPageContext(), new c(view, hVar)).d(view, getString(R.string.open_editor_tips), str, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_PB_REPLY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showOpenMemberReplyDialog() {
        d.a.n0.r.s.a aVar = new d.a.n0.r.s.a(getPageContext().getPageActivity());
        aVar.setMessage(getResources().getString(R.string.mute_is_super_member_function));
        aVar.setPositiveButton(R.string.open_now, new e0());
        aVar.setNegativeButton(R.string.cancel, new f0());
        aVar.create(this.mCtx).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showOperateDialog(boolean z2, SparseArray<Object> sparseArray) {
        String string;
        String str = sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_mute_userid) : "";
        if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
            String[] strArr = new String[1];
            if (z2) {
                string = getResources().getString(R.string.un_mute);
            } else {
                string = getResources().getString(R.string.mute);
            }
            strArr[0] = string;
            d.a.n0.r.s.b bVar = new d.a.n0.r.s.b(getPageContext().getPageActivity());
            bVar.k(R.string.operation);
            bVar.j(strArr, new s(sparseArray, z2, str));
            bVar.c(getPageContext());
            bVar.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showUserMuteAddDialog(String str) {
        if (str == null) {
            str = "";
        }
        d.a.n0.r.s.a aVar = new d.a.n0.r.s.a(this.mCtx.getPageActivity());
        aVar.setMessage(str);
        aVar.setNegativeButton(R.string.know, new d0());
        aVar.create(this.mCtx).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showUserMuteDialog(boolean z2, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z2) {
            this.mSubPbView.A0();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        d.a.n0.r.s.a aVar = new d.a.n0.r.s.a(this.mCtx.getPageActivity());
        if (d.a.c.e.p.k.isEmpty(str)) {
            aVar.setMessage(this.mCtx.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.setMessage(str);
        }
        aVar.setPositiveButton(R.string.confirm, new b0(userMuteAddAndDelCustomMessage));
        aVar.setNegativeButton(R.string.cancel, new c0());
        aVar.create(this.mCtx).show();
    }

    private void startBrowsePageMission() {
        SubPbModel subPbModel = this.mSubPbModel;
        if (subPbModel == null || d.a.c.e.p.k.isEmpty(subPbModel.k0())) {
            return;
        }
        d.a.n0.a.d.y().P(d.a.n0.a.c.W, d.a.c.e.m.b.f(this.mSubPbModel.k0(), 0L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText validImage(String str, int i2) {
        SubPbModel subPbModel = this.mSubPbModel;
        if (subPbModel == null || subPbModel.X() == null || str == null || i2 < 0) {
            return null;
        }
        d.a.o0.e2.h.r X = this.mSubPbModel.X();
        TbRichText image = getImage(X.i(), str, i2);
        if (image != null || (image = getImage(X.i(), str, i2)) != null) {
        }
        return image;
    }

    public void checkContentSensitiveWord(boolean z2) {
        EditText editText = this.mSubFloorEditText;
        if (editText == null || editText.getText() == null) {
            return;
        }
        int selectionEnd = this.mSubFloorEditText.getSelectionEnd();
        SpannableStringBuilder f2 = this.mSensitiveProcessController.f(this.mSubFloorEditText.getText());
        if (f2 != null) {
            this.mSensitiveProcessController.l(true);
            this.mSubFloorEditText.setText(f2);
            if (z2 && this.mSensitiveProcessController.b() >= 0) {
                this.mSubFloorEditText.requestFocus();
                this.mSubFloorEditText.setSelection(this.mSensitiveProcessController.b());
            } else {
                this.mSubFloorEditText.setSelection(selectionEnd);
            }
            d.a.o0.w3.c cVar = this.mSensitiveProcessController;
            cVar.k(cVar.b() >= 0);
        }
    }

    public void checkMuteState(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_mute_userid) : "";
        this.mSubPbView.A0();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = d.a.c.e.m.b.f(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = d.a.c.e.m.b.f(str, 0L);
        this.mExtra = sparseArray;
        BdUniqueId bdUniqueId = this.MESSAGE_ID_NEWSUB_PB;
        userMuteCheckCustomMessage.mId = bdUniqueId;
        userMuteCheckCustomMessage.setTag(bdUniqueId);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void checkShowKeyboard() {
        if (!TbadkCoreApplication.isLogin()) {
            this.mEditor.w();
        } else if (StringUtils.isNull(this.mSubPbModel.i0())) {
        } else {
            if (this.mSubPbView.I0() && d.a.c.e.p.l.D()) {
                this.mSubPbView.p0();
            } else {
                this.mSubPbView.l0();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.mIsFromPb && !this.mIsFromSchema) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        } else {
            super.closeAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.mIsFromPb && !this.mIsFromSchema) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        } else {
            super.enterExitAnimation();
        }
    }

    public void finishDelPost(ForumManageModel.b bVar, boolean z2) {
        if (bVar == null) {
            return;
        }
        int i2 = 0;
        this.mSubPbView.z(0, bVar.f20984a, bVar.f20985b, z2);
        if (bVar.f20984a) {
            int i3 = bVar.f20987d;
            if (i3 == 1) {
                if (this.mSubPbView.G() instanceof BdTypeListView) {
                    List<d.a.c.k.e.n> data = ((BdTypeListView) this.mSubPbView.G()).getData();
                    if (!ListUtils.isEmpty(data)) {
                        while (i2 < data.size() && (!(data.get(i2) instanceof PostData) || !bVar.f20990g.equals(((PostData) data.get(i2)).E()))) {
                            i2++;
                        }
                        if (i2 < data.size()) {
                            data.remove(i2);
                        }
                        this.mSubPbView.a0();
                    }
                }
            } else if (i3 == 2) {
                this.mSubPbModel.U(bVar.f20990g);
                this.mSubPbView.H0(this.mSubPbModel.X(), this.mSubPbModel.o0(), this.mSubPbModel.n0() != null, false);
                if (this.mSubPbModel.w0()) {
                    this.mSubPbModel.J0(false);
                    this.mSubPbView.s();
                    this.mSubPbModel.z0();
                }
            }
            d.a.o0.e2.e eVar = new d.a.o0.e2.e();
            eVar.c(bVar);
            eVar.d(1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, eVar));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, d.a.n0.k0.a
    public String getCurrentPageKey() {
        return "a007";
    }

    @Override // d.a.o0.e2.k.a
    public d.a.o0.e2.k.e.c1.a getEventController() {
        return this.mEvent;
    }

    @Override // d.a.o0.e2.k.a
    public String getFromForumName() {
        SubPbModel subPbModel = this.mSubPbModel;
        if (subPbModel == null || subPbModel.X() == null || this.mSubPbModel.X().l() == null) {
            return null;
        }
        return this.mSubPbModel.X().l().i0();
    }

    @Override // d.a.n0.b1.m.h
    public d.a.c.e.k.b<GifView> getGifViewPool() {
        if (this.mGifViewPool == null) {
            this.mGifViewPool = new d.a.c.e.k.b<>(new u(), 20, 0);
        }
        return this.mGifViewPool;
    }

    @Override // d.a.n0.b1.m.h
    public d.a.c.e.k.b<ImageView> getImageViewPool() {
        if (this.mImageViewPool == null) {
            this.mImageViewPool = new d.a.c.e.k.b<>(new w(), 8, 0);
        }
        return this.mImageViewPool;
    }

    @Override // d.a.n0.b1.m.h
    public ListView getListView() {
        d.a.o0.e2.k.g.a aVar = this.mSubPbView;
        if (aVar != null) {
            return aVar.G();
        }
        return null;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        SubPbModel subPbModel = this.mSubPbModel;
        if (subPbModel == null || d.a.c.e.p.k.isEmpty(subPbModel.k0())) {
            return 0L;
        }
        return d.a.c.e.m.b.f(this.mSubPbModel.k0(), 0L);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public d.a.n0.k0.d getPageStayDurationItem() {
        SubPbModel subPbModel;
        d.a.n0.k0.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && (subPbModel = this.mSubPbModel) != null) {
            if (subPbModel.X() != null && this.mSubPbModel.X().d() != null) {
                pageStayDurationItem.q(d.a.c.e.m.b.f(this.mSubPbModel.X().d().getId(), 0L));
            }
            pageStayDurationItem.y(d.a.c.e.m.b.f(this.mSubPbModel.k0(), 0L));
            if (this.mSubPbModel.X() != null && this.mSubPbModel.X().l() != null) {
                pageStayDurationItem.r(this.mSubPbModel.X().l().M0());
            }
            pageStayDurationItem.t(d.a.c.e.m.b.f(this.mSubPbModel.w(), 0L));
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.BaseActivity, d.a.n0.k0.a
    public d.a.n0.k0.b getPageStayFilter() {
        return new a0();
    }

    public String getPostId() {
        SubPbModel subPbModel = this.mSubPbModel;
        if (subPbModel != null) {
            return subPbModel.w();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        View findViewWithTag;
        View E = this.mSubPbView.E();
        if (E == null || (findViewWithTag = E.findViewWithTag(voiceData$VoiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) findViewWithTag;
    }

    @Override // d.a.n0.b1.m.h
    public d.a.c.e.k.b<RelativeLayout> getRelativeLayoutPool() {
        d.a.c.e.k.b<RelativeLayout> bVar = new d.a.c.e.k.b<>(new z(), 10, 0);
        this.mMemeViewPool = bVar;
        return bVar;
    }

    public String getReplyHint() {
        if (!d.a.c.e.p.k.isEmpty(this.mReplyHintText)) {
            return this.mReplyHintText;
        }
        String string = getResources().getString(r0.b());
        this.mReplyHintText = string;
        return string;
    }

    @Override // d.a.n0.b1.m.h
    public int getRichTextViewId() {
        return 0;
    }

    public SubPbModel getSubPbModel() {
        return this.mSubPbModel;
    }

    @Override // d.a.n0.b1.m.h
    public d.a.c.e.k.b<TextView> getTextViewPool() {
        if (this.mTextViewPool == null) {
            this.mTextViewPool = TbRichTextView.y(getPageContext().getPageActivity(), 8);
        }
        return this.mTextViewPool;
    }

    @Override // d.a.n0.b1.m.h
    public d.a.c.e.k.b<LinearLayout> getTextVoiceViewPool() {
        if (this.mTextVoiceViewPool == null) {
            this.mTextVoiceViewPool = new d.a.c.e.k.b<>(new y(), 15, 0);
        }
        return this.mTextVoiceViewPool;
    }

    public String getThreadId() {
        SubPbModel subPbModel = this.mSubPbModel;
        if (subPbModel != null) {
            return subPbModel.k0();
        }
        return null;
    }

    @Override // d.a.o0.e2.k.a
    public int getUserIdentify() {
        SubPbModel subPbModel = this.mSubPbModel;
        if (subPbModel == null) {
            return 0;
        }
        return subPbModel.o0();
    }

    public int getUserIdentity() {
        SubPbModel subPbModel = this.mSubPbModel;
        if (subPbModel != null) {
            return subPbModel.o0();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        return this.mVoiceManager;
    }

    @Override // d.a.n0.b1.m.h
    public d.a.c.e.k.b<View> getVoiceViewPool() {
        if (this.mVoiceViewPool == null) {
            this.mVoiceViewPool = new d.a.c.e.k.b<>(new x(), 8, 0);
        }
        return this.mVoiceViewPool;
    }

    public void handleMuteClick(boolean z2, String str, SparseArray<Object> sparseArray) {
        String str2 = sparseArray.get(R.id.tag_user_mute_mute_username) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_mute_username) : "";
        String str3 = sparseArray.get(R.id.tag_user_mute_thread_id) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_thread_id) : "";
        String str4 = sparseArray.get(R.id.tag_user_mute_post_id) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_post_id) : "";
        if (sparseArray.get(R.id.tag_user_mute_msg) instanceof String) {
            str4 = (String) sparseArray.get(R.id.tag_user_mute_msg);
        }
        String str5 = str4;
        String str6 = sparseArray.get(R.id.tag_user_mute_msg) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_msg) : "";
        String str7 = sparseArray.get(R.id.tag_user_mute_mute_nameshow) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_mute_nameshow) : "";
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
        userMuteAddAndDelCustomMessage.setData(z2, str, str2, str3, str5, 1, str6, this.MESSAGE_ID_NEWSUB_PB);
        userMuteAddAndDelCustomMessage.setTag(this.MESSAGE_ID_NEWSUB_PB);
        showUserMuteDialog(z2, userMuteAddAndDelCustomMessage, str6, str2, str7);
    }

    public void handleReportClicked(String str) {
        SubPbModel subPbModel = this.mSubPbModel;
        if (subPbModel != null && subPbModel.X() != null && this.mSubPbModel.X().l() != null && this.mSubPbModel.X().l().V1()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.mSubPbModel.k0(), str);
            a2 l2 = this.mSubPbModel.X().l();
            if (l2.R1()) {
                format = format + "&channelid=33833";
            } else if (l2.W1()) {
                format = format + "&channelid=33842";
            } else if (l2.U1()) {
                format = format + "&channelid=33840";
            }
            jumpToWeb(format);
            return;
        }
        this.mUEGReportController.i(str);
    }

    public void initCallBacks() {
        this.mSubPbCallBack = new d();
        this.mMarkDoneCallBack = new e();
        this.forbidUserCallback = new f();
        this.deleteReplayCallback = new g();
        this.mPostManageCallBack = new h();
    }

    public void initData(Bundle bundle) {
        SubPbModel subPbModel = new SubPbModel(getPageContext());
        this.mSubPbModel = subPbModel;
        subPbModel.I0(new b());
        ForumManageModel forumManageModel = new ForumManageModel(getPageContext());
        this.mPostManageModel = forumManageModel;
        forumManageModel.setLoadDataCallBack(this.mPostManageCallBack);
        VoiceManager voiceManager = new VoiceManager();
        this.mVoiceManager = voiceManager;
        voiceManager.onCreate(getPageContext());
        d.a.n0.h.a b2 = d.a.n0.h.a.b(this);
        this.mMarkModel = b2;
        if (b2 != null) {
            b2.j(this.mMarkDoneCallBack);
        }
        if (bundle != null) {
            this.mSubPbModel.initWithBundle(bundle);
        } else {
            this.mSubPbModel.initWithIntent(getIntent());
        }
        this.mSubPbModel.M0(this.mSubPbCallBack);
        if (this.mSubPbModel.t0() && !this.mSubPbModel.y0()) {
            this.mSubPbModel.z0();
        } else if (!TextUtils.isEmpty(getIntent().getStringExtra("key_open_editor_tips"))) {
            this.mSubPbModel.z0();
        } else {
            this.mSubPbModel.A0();
        }
    }

    public void initListeners() {
        registerListener(this.updatePendantMessageListener);
        this.mCommonClickListener = new l();
        this.mSubPbScrollListener = new m();
        this.mOnLongClickListener = new n();
        this.mImageClickListener = new o();
    }

    public void initUI() {
        d.a.o0.e2.k.g.a aVar = new d.a.o0.e2.k.g.a(this, this.mCommonClickListener);
        this.mSubPbView = aVar;
        aVar.q0(this.mSubPbModel);
        setContentView(this.mSubPbView.P(), new FrameLayout.LayoutParams(-1, -1));
        this.mSubPbView.u0(this.mSubPbScrollListener);
        this.mSubPbView.v0(this);
        this.mSubPbView.r0(this.mImageClickListener);
        this.mSubPbView.s0(this.mOnLongClickListener);
        this.mSubPbView.t0(new a());
        this.mSubPbView.m0(this.forbidUserCallback);
        this.mSubPbView.k0(this.deleteReplayCallback);
        this.mSubPbView.o0(this.mOnPullRefreshListener);
        SubPbModel subPbModel = this.mSubPbModel;
        if (subPbModel != null && subPbModel.t0() && !this.mSubPbModel.x0()) {
            this.mSubPbView.D().setVisibility(8);
        } else {
            this.mSubPbView.D().setVisibility(0);
        }
        SubPbModel subPbModel2 = this.mSubPbModel;
        if (subPbModel2 == null || subPbModel2.t0()) {
            return;
        }
        this.mSubPbView.n0(false);
    }

    public boolean isFromPb() {
        SubPbModel subPbModel = this.mSubPbModel;
        if (subPbModel != null) {
            return subPbModel.t0();
        }
        return false;
    }

    public boolean isH5GameLink(String str) {
        Map<String, String> paramPair;
        if (TextUtils.isEmpty(str) || (paramPair = UrlManager.getParamPair(UrlManager.getParamStr(str))) == null) {
            return false;
        }
        this.mIsRichTextListenerAcked = true;
        String str2 = paramPair.get("url");
        if (!TextUtils.isEmpty(str2)) {
            return isH5GameLink(d.a.c.e.p.k.getUrlDecode(str2));
        }
        String str3 = paramPair.get(TB_GAME_TYPE);
        return !TextUtils.isEmpty(str3) && str3.equals("1");
    }

    @Override // d.a.o0.e2.k.a
    public boolean isHost(String str) {
        SubPbModel subPbModel;
        if (StringUtils.isNull(str) || (subPbModel = this.mSubPbModel) == null || subPbModel.X() == null || this.mSubPbModel.X().l() == null || this.mSubPbModel.X().l().T() == null) {
            return false;
        }
        return str.equals(this.mSubPbModel.X().l().T().getUserId());
    }

    public boolean isImage(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public boolean isPaused() {
        return this.mIsPaused;
    }

    @Override // d.a.o0.e2.k.a
    public boolean isSimpleForum() {
        SubPbModel subPbModel = this.mSubPbModel;
        if (subPbModel == null || subPbModel.X() == null || this.mSubPbModel.X().l() == null) {
            return false;
        }
        return !this.mSubPbModel.X().l().o2();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 25035) {
            handleFullScreenEditorResult(i3, intent);
        }
        d.a.n0.w.w.h hVar = this.mEditor;
        if (hVar != null) {
            hVar.A(i2, i3, intent);
        }
    }

    @Override // d.a.n0.b1.m.h
    public void onAtClicked(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.mIsRichTextListenerAcked = true;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        d.a.n0.w.w.h hVar = this.mEditor;
        if (hVar != null && hVar.a() != null && this.mEditor.a().u()) {
            this.mEditor.a().q();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.mSubPbView.e0(i2);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        initIsFromPb(bundle);
        if (getIntent() != null) {
            this.mIsFromSchema = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_FROM_SCHEMA, false);
        }
        super.onCreate(bundle);
        this.mCtx = getPageContext();
        this.isFirstLoadData = true;
        d.a.o0.w3.c cVar = new d.a.o0.w3.c();
        this.mSensitiveProcessController = cVar;
        cVar.h(R.color.cp_cont_h_alpha85);
        this.mSensitiveProcessController.j(R.color.CAM_X0101);
        initListeners();
        initCallBacks();
        initData(bundle);
        initUI();
        ((SubPbView) this.mSubPbView.P()).h();
        initEditor(false);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.mSubPbView.r(this.mIsFromSchema);
        d.a.n0.r.f0.c cVar2 = new d.a.n0.r.f0.c();
        this.mToastMute = cVar2;
        cVar2.f53491a = 1000L;
        registerListener(this.mUserMuteCheckListener);
        registerListener(this.mUserMuteAddListener);
        registerListener(this.mUserMuteDelListener);
        registerListener(this.subpbReplyListener);
        this.MESSAGE_ID_NEWSUB_PB = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        BdUniqueId bdUniqueId = this.MESSAGE_ID_NEWSUB_PB;
        userMuteAddAndDelCustomMessage.mId = bdUniqueId;
        userMuteAddAndDelCustomMessage.setTag(bdUniqueId);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        BdUniqueId bdUniqueId2 = this.MESSAGE_ID_NEWSUB_PB;
        userMuteCheckCustomMessage.mId = bdUniqueId2;
        userMuteCheckCustomMessage.setTag(bdUniqueId2);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
        this.mReplyPrivacyController = replyPrivacyCheckController;
        replyPrivacyCheckController.setAttentionCallback(new p0());
        d.a.o0.e2.k.f.a aVar = new d.a.o0.e2.k.f.a(this);
        this.mUEGReportController = aVar;
        aVar.a(getUniqueId());
        this.mEvent = new d.a.o0.e2.k.e.c1.a(this);
        this.mUserBlockController = new d.a.o0.o3.b(getPageContext(), getUniqueId());
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, this.mRefreshData));
        this.mSubPbModel.cancelLoadData();
        this.mSubPbModel.destory();
        this.mPostManageModel.cancelLoadData();
        VoiceManager voiceManager = this.mVoiceManager;
        if (voiceManager != null) {
            voiceManager.onDestory(getPageContext());
        }
        this.mSubPbView.w();
        this.mSubPbView.b0();
        MessageManager.getInstance().unRegisterListener(this.mUserMuteAddListener);
        MessageManager.getInstance().unRegisterListener(this.mUserMuteDelListener);
        MessageManager.getInstance().unRegisterListener(this.mUserMuteCheckListener);
        MessageManager.getInstance().unRegisterListener(this.MESSAGE_ID_NEWSUB_PB);
        d.a.o0.o3.b bVar = this.mUserBlockController;
        if (bVar != null) {
            bVar.l();
        }
        ReplyPrivacyCheckController replyPrivacyCheckController = this.mReplyPrivacyController;
        if (replyPrivacyCheckController != null) {
            replyPrivacyCheckController.onDestroy();
        }
        this.mCtx = null;
        this.mToastMute = null;
        TbPageExtraHelper.u(getCurrentPageKey());
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z2) {
        super.onKeyboardVisibilityChanged(z2);
        this.mIsSoftKeyBoardVisible = z2;
        fixReplyFloorViewHolderPosition(true);
    }

    @Override // d.a.n0.b1.m.h
    public void onLinkButtonClicked(Context context, String str) {
    }

    @Override // d.a.n0.b1.m.h
    public void onLinkClicked(Context context, String str, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (isH5GameLink(str)) {
            MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
            return;
        }
        if (z2) {
            if (!TextUtils.isEmpty(str)) {
                d.a.n0.t.m mVar = new d.a.n0.t.m();
                mVar.f54581a = str;
                mVar.f54582b = 3;
                mVar.f54583c = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, mVar));
            }
        } else {
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str});
        }
        this.mIsRichTextListenerAcked = true;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.mIsPaused = true;
        super.onPause();
        d.a.n0.a.d.y().E();
        VoiceManager voiceManager = this.mVoiceManager;
        if (voiceManager != null) {
            voiceManager.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.richTextIntentClickListener);
        this.mSubPbView.c0();
    }

    @Override // d.a.n0.b1.m.h
    public void onPhoneClicked(Context context, String str, String str2) {
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z2) {
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, d.a.c.a.i
    public void onPreLoad(d.a.c.k.e.q qVar) {
        PreLoadImageHelper.load(qVar, getUniqueId(), 3);
        PreLoadVideoHelper.load(qVar, getUniqueId(), this);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.mIsPaused = false;
        super.onResume();
        startBrowsePageMission();
        VoiceManager voiceManager = this.mVoiceManager;
        if (voiceManager != null) {
            voiceManager.onResume(getPageContext());
        }
        registerListener(this.richTextIntentClickListener);
        this.mSubPbView.d0();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        SubPbModel subPbModel;
        super.onSaveInstanceState(bundle);
        if (bundle == null || (subPbModel = this.mSubPbModel) == null) {
            return;
        }
        subPbModel.H0(bundle);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        if (this.mSubPbView.I0() && d.a.c.e.p.l.D()) {
            this.mSubPbModel.z0();
        } else {
            this.mSubPbView.l0();
        }
    }

    @Override // d.a.n0.b1.m.h
    public void onSongClicked(Context context, String str) {
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        VoiceManager voiceManager = this.mVoiceManager;
        if (voiceManager != null) {
            voiceManager.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        VoiceManager voiceManager = this.mVoiceManager;
        if (voiceManager != null) {
            voiceManager.onStop(getPageContext());
        }
        this.mEditor.C();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z2) {
        super.onUserChanged(z2);
        d.a.o0.e2.k.e.d0 d0Var = this.mPostMoreOptionView;
        if (d0Var != null) {
            d0Var.n(z2);
        }
        d.a.o0.e2.k.g.a aVar = this.mSubPbView;
        if (aVar != null) {
            aVar.t(z2);
        }
    }

    @Override // d.a.n0.b1.m.h
    public void onVideoClicked(Context context, String str) {
    }

    @Override // d.a.n0.b1.m.h
    public void onVideoP2PClicked(Context context, String str) {
    }

    public void stopVoice() {
        VoiceManager voiceManager = this.mVoiceManager;
        if (voiceManager != null) {
            voiceManager.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openEditor(PostData postData, boolean z2) {
        if (checkIsIfPostForbid()) {
            return;
        }
        if (postData != null) {
            if (postData.t() != null) {
                MetaData t2 = postData.t();
                this.mEditor.S(t2.getUserId());
                boolean z3 = postData.m0;
                this.mEditor.o(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.t().getName_show(), postData.K() != null ? postData.K().toString() : ""));
                if (z3) {
                    if (!z2) {
                        this.mEditor.R("");
                    }
                } else if (!z2) {
                    this.mEditor.R(t2.getName_show());
                }
            }
            this.mSubPbView.u();
        }
        if (this.mIsSoftKeyBoardVisible) {
            fixReplyFloorViewHolderPosition(false);
        }
    }

    public void markFloor(PostData postData) {
        if (postData == null) {
            return;
        }
        boolean z2 = false;
        if (this.mSubPbModel.v0() && postData.E() != null && postData.E().equals(this.mSubPbModel.f0())) {
            z2 = true;
        }
        MarkData e02 = this.mSubPbModel.e0(postData);
        if (e02 == null) {
            return;
        }
        this.mSubPbView.w();
        d.a.n0.h.a aVar = this.mMarkModel;
        if (aVar != null) {
            aVar.i(e02);
            if (!z2) {
                this.mMarkModel.a();
            } else {
                this.mMarkModel.d();
            }
        }
    }
}
