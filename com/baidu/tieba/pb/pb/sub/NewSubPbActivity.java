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
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.r0.a0.d;
import d.a.r0.b1.m.f;
import d.a.r0.h.a;
import d.a.r0.r.f0.f;
import d.a.r0.r.q.b2;
import d.a.r0.r.s.a;
import d.a.r0.r.s.b;
import d.a.s0.h2.k.e.r0;
import d.a.s0.h2.k.e.x0;
import d.a.s0.u0.f2.a.c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes5.dex */
public class NewSubPbActivity extends BaseActivity<NewSubPbActivity> implements VoiceManager.j, d.a.r0.b1.m.h, BdListView.p, d.a.s0.h2.k.a<NewSubPbActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static String TB_GAME_TYPE = "tbgametype";
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId MESSAGE_ID_NEWSUB_PB;
    public q0 deleteReplayCallback;
    public q0 forbidUserCallback;
    public boolean hasRemindedEditorTips;
    public int imgIndex;
    public boolean index_valid;
    public boolean isFirstLoadData;
    public int lastScrollState;
    public d.a.r0.w.w.b mCheckPostCallBack;
    public View.OnClickListener mCommonClickListener;
    public d.a.c.a.f mCtx;
    public d.a.r0.w.w.h mEditor;
    public TbRichTextMemeInfo mEmotionInfo;
    public d.a.s0.h2.k.e.c1.a mEvent;
    public Object mExtra;
    public d.a.c.e.k.b<GifView> mGifViewPool;
    public TbRichTextView.x mImageClickListener;
    public d.a.c.e.k.b<ImageView> mImageViewPool;
    public boolean mIsFromCDN;
    public boolean mIsFromPb;
    public boolean mIsFromSchema;
    public boolean mIsPaused;
    public boolean mIsRichTextListenerAcked;
    public boolean mIsSoftKeyBoardVisible;
    public PbCommenFloorItemViewHolder mItemClickShowSoftKeyBoardViewHolder;
    public a.InterfaceC1243a mMarkDoneCallBack;
    public d.a.r0.h.a mMarkModel;
    public d.a.c.e.k.b<RelativeLayout> mMemeViewPool;
    public d.a.r0.r.b0.a mMessageHelper;
    public d.a.s0.h3.h0.e mMsgData;
    public final b.c mOnImageSaveClickListener;
    public View.OnLongClickListener mOnLongClickListener;
    public NewWriteModel.g mOnPostWriteNewCallback;
    public final f.g mOnPullRefreshListener;
    public BdUniqueId mOnlyDisagreeId;
    public PermissionJudgePolicy mPermissionJudgement;
    public d.a.c.a.e mPostManageCallBack;
    public ForumManageModel mPostManageModel;
    public d.a.s0.h2.k.e.d0 mPostMoreOptionView;
    public PostWriteCallBackData mPostWriteCallBackData;
    public d.a.r0.w.w.c mPrePostCallBack;
    public d.a.s0.u0.f2.a.c mProfessionController;
    public d.a.s0.h2.e<d.a.s0.h2.h.r> mRefreshData;
    public String mReplyHintText;
    public ReplyPrivacyCheckController mReplyPrivacyController;
    public d.a.c.k.d.a mSaveBdImage;
    public x0 mSaveImageHelper;
    public String mSaveImageUrl;
    public d.a.s0.a4.c mSensitiveProcessController;
    public EditText mSubFloorEditText;
    public SubPbModel.b mSubPbCallBack;
    public SubPbModel mSubPbModel;
    public AbsListView.OnScrollListener mSubPbScrollListener;
    public d.a.s0.h2.k.g.a mSubPbView;
    public d.a.c.e.k.b<TextView> mTextViewPool;
    public d.a.c.e.k.b<LinearLayout> mTextVoiceViewPool;
    public d.a.r0.r.f0.c mToastMute;
    public d.a.s0.h2.k.f.a mUEGReportController;
    public d.a.s0.r3.b mUserBlockController;
    public CustomMessageListener mUserMuteAddListener;
    public CustomMessageListener mUserMuteCheckListener;
    public CustomMessageListener mUserMuteDelListener;
    public VoiceManager mVoiceManager;
    public d.a.c.e.k.b<View> mVoiceViewPool;
    public boolean needOpenEditor;
    public PostData postData;
    public CustomMessageListener richTextIntentClickListener;
    public boolean showTrisectionAndFeedback;
    public CustomMessageListener subpbReplyListener;
    public CustomMessageListener updatePendantMessageListener;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f19548e;

        public a(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19548e = newSubPbActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f19548e.mSubPbModel == null) {
                return;
            }
            this.f19548e.mSubPbModel.z0();
        }
    }

    /* loaded from: classes5.dex */
    public class a0 extends d.a.r0.k0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f19549a;

        public a0(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19549a = newSubPbActivity;
        }

        @Override // d.a.r0.k0.b
        public int getMaxCost() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? d.a.r0.k0.e.b().c() : invokeV.intValue;
        }

        @Override // d.a.r0.k0.b
        public boolean isCurrentPageCanBeAddToSourceTrace() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements PbFakeFloorModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f19550a;

        public b(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19550a = newSubPbActivity;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, postData) == null) {
                this.f19550a.mSubPbView.z0(postData);
                this.f19550a.mSubPbView.v0(null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserMuteAddAndDelCustomMessage f19551e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f19552f;

        public b0(NewSubPbActivity newSubPbActivity, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, userMuteAddAndDelCustomMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19552f = newSubPbActivity;
            this.f19551e = userMuteAddAndDelCustomMessage;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f19552f.mSubPbView.A0();
                MessageManager.getInstance().sendMessage(this.f19551e);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements WriteTipBubbleController.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f19553a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.r0.w.w.h f19554b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f19555c;

        public c(NewSubPbActivity newSubPbActivity, View view, d.a.r0.w.w.h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, view, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19555c = newSubPbActivity;
            this.f19553a = view;
            this.f19554b = hVar;
        }

        @Override // com.baidu.tbadk.core.dialog.WriteTipBubbleController.b
        public void a(View view, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, str) == null) {
                this.f19553a.performClick();
                this.f19554b.p();
                this.f19554b.s().i().setText(str);
                Editable text = this.f19554b.s().i().getText();
                if (TextUtils.isEmpty(text)) {
                    return;
                }
                this.f19554b.s().i().setSelection(text.length());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f19556e;

        public c0(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19556e = newSubPbActivity;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements SubPbModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f19557a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.s0.h2.h.r f19558e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f19559f;

            public a(d dVar, d.a.s0.h2.h.r rVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, rVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19559f = dVar;
                this.f19558e = rVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f19559f.f19557a.needOpenEditor = false;
                    this.f19559f.f19557a.openEditor(this.f19558e.i(), false);
                }
            }
        }

        public d(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19557a = newSubPbActivity;
        }

        @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.b
        public void a(boolean z, int i2, String str, d.a.s0.h2.h.r rVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), str, rVar}) == null) || this.f19557a.mSubPbView == null) {
                return;
            }
            this.f19557a.mSubPbView.l0();
            if (!z) {
                this.f19557a.onNetOrDataError(i2, str);
                return;
            }
            this.f19557a.mSubPbView.S();
            if (rVar != null) {
                if (rVar.i() != null || this.f19557a.mSubPbModel != null) {
                    rVar.i().v0(this.f19557a.mSubPbModel.j0());
                }
                if (this.f19557a.mSubPbView != null) {
                    this.f19557a.initEditor(rVar.l() != null && rVar.l().I1());
                    if (this.f19557a.mEditor != null && this.f19557a.mEditor.a() != null) {
                        this.f19557a.mEditor.a().w(TbadkCoreApplication.getInst().getSkinType());
                    }
                    this.f19557a.mSubPbView.H0(rVar, this.f19557a.mSubPbModel.o0(), this.f19557a.mSubPbModel.n0() != null, this.f19557a.isFirstLoadData);
                    if (this.f19557a.isFirstLoadData) {
                        this.f19557a.mSubPbView.G().setSelectionFromTop(this.f19557a.mSubPbView.G().getHeaderViewsCount() + 1, -d.a.c.e.p.l.g(this.f19557a, R.dimen.tbds18));
                        this.f19557a.checkShowKeyboard();
                        this.f19557a.isFirstLoadData = false;
                    }
                }
                if (this.f19557a.mEditor != null) {
                    this.f19557a.mEditor.E(rVar.a());
                    this.f19557a.mEditor.X(rVar.l());
                    if (this.f19557a.getIntent() != null && this.f19557a.getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_OPEN_EDITOR, false) && this.f19557a.needOpenEditor) {
                        d.a.c.e.m.e.a().postDelayed(new a(this, rVar), 200L);
                    }
                }
                if (this.f19557a.mRefreshData == null) {
                    this.f19557a.mRefreshData = new d.a.s0.h2.e();
                }
                this.f19557a.mRefreshData.c(rVar);
                this.f19557a.mRefreshData.d(0);
                NewSubPbActivity newSubPbActivity = this.f19557a;
                newSubPbActivity.mReplyPrivacyController.setLikeUserData(newSubPbActivity.mSubPbModel.W());
            }
            String stringExtra = this.f19557a.getIntent().getStringExtra("key_open_editor_tips");
            if (TextUtils.isEmpty(stringExtra) || this.f19557a.hasRemindedEditorTips) {
                return;
            }
            this.f19557a.hasRemindedEditorTips = true;
            NewSubPbActivity newSubPbActivity2 = this.f19557a;
            newSubPbActivity2.showDeleteResumeEditorTips(newSubPbActivity2.mSubPbView.N(), this.f19557a.mEditor, stringExtra);
        }
    }

    /* loaded from: classes5.dex */
    public class d0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f19560e;

        public d0(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19560e = newSubPbActivity;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements a.InterfaceC1243a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f19561a;

        public e(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19561a = newSubPbActivity;
        }

        @Override // d.a.r0.h.a.InterfaceC1243a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                if (z) {
                    if (this.f19561a.mMarkModel != null) {
                        this.f19561a.mMarkModel.h(z2);
                    }
                    MarkData f2 = this.f19561a.mMarkModel.f();
                    d.a.s0.h2.e eVar = new d.a.s0.h2.e();
                    eVar.d(2);
                    if (z2) {
                        eVar.c(f2);
                        if (this.f19561a.mMarkModel != null) {
                            if (f2 != null) {
                                this.f19561a.mSubPbModel.K0(true);
                                this.f19561a.mSubPbModel.L0(this.f19561a.mSubPbModel.w());
                                this.f19561a.showToast(R.string.add_mark_on_pb);
                            } else {
                                NewSubPbActivity newSubPbActivity = this.f19561a;
                                newSubPbActivity.showToast(newSubPbActivity.getPageContext().getString(R.string.add_mark));
                            }
                            if (this.f19561a.mSubPbView != null) {
                                this.f19561a.mSubPbView.L0(true);
                            }
                        }
                    } else {
                        eVar.c(null);
                        this.f19561a.mSubPbModel.K0(false);
                        this.f19561a.mSubPbModel.L0(null);
                        NewSubPbActivity newSubPbActivity2 = this.f19561a;
                        newSubPbActivity2.showToast(newSubPbActivity2.getPageContext().getString(R.string.remove_mark));
                        if (this.f19561a.mSubPbView != null) {
                            this.f19561a.mSubPbView.L0(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, eVar));
                    return;
                }
                NewSubPbActivity newSubPbActivity3 = this.f19561a;
                newSubPbActivity3.showToast(newSubPbActivity3.getPageContext().getString(R.string.update_mark_failed));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f19562e;

        public e0(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19562e = newSubPbActivity;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar.dismiss();
                    ((TbPageContext) this.f19562e.mCtx).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.f19562e.mCtx.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements q0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f19563a;

        public f(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19563a = newSubPbActivity;
        }

        @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.q0
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                Object[] objArr = (Object[]) obj;
                String valueOf = (this.f19563a.mSubPbModel.X() == null || this.f19563a.mSubPbModel.X().l() == null || this.f19563a.mSubPbModel.X().l().H() == null) ? "" : String.valueOf(this.f19563a.mSubPbModel.X().l().H().getUserId());
                String valueOf2 = objArr.length > 1 ? String.valueOf(objArr[1]) : "";
                String valueOf3 = objArr.length > 2 ? String.valueOf(objArr[2]) : "";
                this.f19563a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.f19563a.getPageContext().getPageActivity(), this.f19563a.mSubPbModel.X().d().getId(), this.f19563a.mSubPbModel.X().d().getName(), this.f19563a.mSubPbModel.X().l().c0(), valueOf, valueOf2, objArr.length > 3 ? String.valueOf(objArr[3]) : "", valueOf3, objArr.length > 4 ? String.valueOf(objArr[4]) : "")));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f19564e;

        public f0(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19564e = newSubPbActivity;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements q0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f19565a;

        public g(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19565a = newSubPbActivity;
        }

        @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.q0
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (this.f19565a.mPostManageModel.O() || objArr == null || objArr.length < 4) {
                        return;
                    }
                    String valueOf = String.valueOf(objArr[0]);
                    int d2 = d.a.c.e.m.b.d(String.valueOf(objArr[1]), 0);
                    boolean a2 = d.a.c.e.m.b.a(String.valueOf(objArr[2]), false);
                    int d3 = d.a.c.e.m.b.d(String.valueOf(objArr[3]), 0);
                    if (this.f19565a.mSubPbModel == null || this.f19565a.mSubPbModel.X() == null || this.f19565a.mSubPbModel.X().d() == null || this.f19565a.mSubPbModel.X().l() == null) {
                        return;
                    }
                    if (objArr.length > 4) {
                        this.f19565a.mPostManageModel.Q(String.valueOf(objArr[4]));
                    }
                    this.f19565a.mPostManageModel.R(this.f19565a.mSubPbModel.X().d().getId(), this.f19565a.mSubPbModel.X().d().getName(), this.f19565a.mSubPbModel.X().l().c0(), valueOf, d3, d2, a2, this.f19565a.mSubPbModel.X().l().J());
                    return;
                }
                TbadkCoreApplication.getInst().login(this.f19565a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f19565a.getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f19566a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g0(NewSubPbActivity newSubPbActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, Integer.valueOf(i2)};
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
            this.f19566a = newSubPbActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.f19566a.mSubPbModel != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && StringHelper.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), this.f19566a.mSubPbModel.k0())) {
                if (this.f19566a.mSensitiveProcessController != null) {
                    this.f19566a.mSensitiveProcessController.n(null);
                    this.f19566a.mSensitiveProcessController.i(null);
                    this.f19566a.mSensitiveProcessController.k(false);
                }
                if (this.f19566a.mEditor != null) {
                    this.f19566a.mEditor.p();
                    this.f19566a.mEditor.F();
                }
                this.f19566a.mSubPbModel.y();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h extends d.a.c.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f19567a;

        public h(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19567a = newSubPbActivity;
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                boolean z = false;
                if (obj != null) {
                    int loadDataMode = this.f19567a.mPostManageModel.getLoadDataMode();
                    if (loadDataMode == 0) {
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        this.f19567a.finishDelPost(bVar, (bVar.f21137e != 1002 || bVar.f21138f) ? true : true);
                        return;
                    } else if (loadDataMode != 1) {
                        return;
                    } else {
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        this.f19567a.mSubPbView.z(1, dVar.f21140a, dVar.f21141b, true);
                        return;
                    }
                }
                this.f19567a.mSubPbView.z(this.f19567a.mPostManageModel.getLoadDataMode(), false, null, false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h0 implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f19568a;

        /* loaded from: classes5.dex */
        public class a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(h0 h0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {h0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // d.a.r0.r.s.a.e
            public void onClick(d.a.r0.r.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h0 f19569e;

            public b(h0 h0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {h0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19569e = h0Var;
            }

            @Override // d.a.r0.r.s.a.e
            public void onClick(d.a.r0.r.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                    this.f19569e.f19568a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.f19569e.f19568a.getActivity(), 0, 26, 2)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
                }
            }
        }

        public h0(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19568a = newSubPbActivity;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, d.a.r0.s.c.i0 i0Var, WriteData writeData, AntiData antiData) {
            ReplyPrivacyCheckController replyPrivacyCheckController;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, i0Var, writeData, antiData}) == null) {
                if (z && this.f19568a.mEditor != null && this.f19568a.mEditor.a() != null) {
                    this.f19568a.mEditor.a().o();
                    if (this.f19568a.mSubPbModel.s0()) {
                        TiebaStatic.log(new StatisticItem("c10367").param("post_id", this.f19568a.mSubPbModel.w()));
                    }
                }
                if (z) {
                    this.f19568a.mSensitiveProcessController.n(null);
                    this.f19568a.mSensitiveProcessController.i(null);
                    this.f19568a.mSensitiveProcessController.k(false);
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        d.a.r0.s.h.b.a(this.f19568a.getPageContext(), postWriteCallBackData);
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    this.f19568a.mSensitiveProcessController.i(postWriteCallBackData.getSensitiveWords());
                    this.f19568a.mSensitiveProcessController.n(postWriteCallBackData.getErrorString());
                    if (ListUtils.isEmpty(this.f19568a.mSensitiveProcessController.a())) {
                        return;
                    }
                    this.f19568a.mPostWriteCallBackData = postWriteCallBackData;
                    if (this.f19568a.mEditor.v()) {
                        this.f19568a.mEditor.t(this.f19568a.mPostWriteCallBackData);
                    }
                    this.f19568a.checkContentSensitiveWord(true);
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (d.a.c.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.s(this.f19568a.getActivity(), this.f19568a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).u();
                    } else {
                        DefaultNavigationBarCoverTip.s(this.f19568a.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(this.f19568a.getActivity());
                    if (d.a.c.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.setMessage(this.f19568a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        aVar.setMessage(postWriteCallBackData.getErrorString());
                    }
                    aVar.setNegativeButton(R.string.cancel, new a(this));
                    aVar.setPositiveButton(R.string.open_now, new b(this));
                    aVar.create(this.f19568a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && (replyPrivacyCheckController = this.f19568a.mReplyPrivacyController) != null) {
                    replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                }
                this.f19568a.mSubPbView.l0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SparseArray f19570e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f19571f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f19572g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f19573h;

        public i(NewSubPbActivity newSubPbActivity, SparseArray sparseArray, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, sparseArray, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19573h = newSubPbActivity;
            this.f19570e = sparseArray;
            this.f19571f = i2;
            this.f19572g = z;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (aVar != null) {
                    aVar.dismiss();
                }
                if (this.f19573h.deleteReplayCallback != null) {
                    this.f19573h.deleteReplayCallback.a(new Object[]{this.f19570e.get(R.id.tag_del_post_id), Integer.valueOf(this.f19571f), Boolean.valueOf(this.f19572g), this.f19570e.get(R.id.tag_del_post_type)});
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f19574a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i0(NewSubPbActivity newSubPbActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, Integer.valueOf(i2)};
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
            this.f19574a = newSubPbActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof d.a.r0.t.n)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (StringUtils.isNull(currentAccount)) {
                    return;
                }
                d.a.r0.t.n nVar = (d.a.r0.t.n) customResponsedMessage.getData();
                if (this.f19574a.mSubPbModel.X() == null || this.f19574a.mSubPbModel.X().i() == null || this.f19574a.mSubPbModel.X().i().t() == null || !currentAccount.equals(this.f19574a.mSubPbModel.X().i().t().getUserId()) || this.f19574a.mSubPbModel.X().i().t().getPendantData() == null) {
                    return;
                }
                this.f19574a.mSubPbModel.X().i().t().getPendantData().d(nVar.a());
                this.f19574a.mSubPbModel.X().i().t().getPendantData().e(nVar.b());
                this.f19574a.mSubPbView.y(this.f19574a.mSubPbModel.X(), this.f19574a.mSubPbModel.X().i(), this.f19574a.mSubPbModel.X().e(), this.f19574a.mSubPbModel.X().f(), this.f19574a.mSubPbModel.o0(), this.f19574a.mSubPbModel.n0() != null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f19575e;

        public j(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19575e = newSubPbActivity;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f19576e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f19577f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f19578g;

        public j0(NewSubPbActivity newSubPbActivity, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19578g = newSubPbActivity;
            this.f19576e = i2;
            this.f19577f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19578g.mSubPbView == null || this.f19578g.mSubPbView.G() == null) {
                return;
            }
            this.f19578g.mSubPbView.G().setSelectionFromTop(this.f19576e, this.f19578g.mSubPbView.I() - this.f19577f);
        }
    }

    /* loaded from: classes5.dex */
    public class k implements d.a.r0.w.w.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f19579a;

        public k(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19579a = newSubPbActivity;
        }

        @Override // d.a.r0.w.w.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19579a.mSubPbView.x0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f19580e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f19581f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f19582g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f19583h;

        public k0(NewSubPbActivity newSubPbActivity, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19583h = newSubPbActivity;
            this.f19580e = i2;
            this.f19581f = i3;
            this.f19582g = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19583h.mSubPbView == null || this.f19583h.mSubPbView.G() == null) {
                return;
            }
            this.f19583h.mSubPbView.G().setSelectionFromTop(this.f19580e, this.f19583h.mSubPbView.I() + (this.f19581f - this.f19582g));
        }
    }

    /* loaded from: classes5.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f19584e;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.s0.h2.k.e.c1.c f19585e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ PostData f19586f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ l f19587g;

            public a(l lVar, d.a.s0.h2.k.e.c1.c cVar, PostData postData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar, cVar, postData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19587g = lVar;
                this.f19585e = cVar;
                this.f19586f = postData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.a.s0.h2.k.e.e eVar = new d.a.s0.h2.k.e.e(new d.a.r0.b1.m.a());
                    eVar.j(d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
                    eVar.o(TbConfig.getPostLineSpace(), 1.0f);
                    this.f19585e.f60438b.a(null, this.f19587g.f19584e.mSubPbModel.X().l(), this.f19586f, eVar);
                }
            }
        }

        public l(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19584e = newSubPbActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PostData postData;
            String b2;
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == null && this.f19584e.mSubPbView == null) {
                    return;
                }
                boolean z = true;
                boolean z2 = false;
                SparseArray<Object> sparseArray2 = null;
                if (view == this.f19584e.mSubPbView.F()) {
                    this.f19584e.mSubPbView.w();
                    String str = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                    String str2 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                    String str3 = view.getTag(R.id.tag_virtual_user_url) instanceof String ? (String) view.getTag(R.id.tag_virtual_user_url) : null;
                    if (str3 != null) {
                        if (this.f19584e.checkUpIsLogin()) {
                            UrlManager.getInstance().dealOneLink(this.f19584e.getPageContext(), new String[]{str3});
                        }
                    } else if (str != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f19584e.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                    }
                } else if (view != this.f19584e.mSubPbView.N()) {
                    if (view != this.f19584e.mSubPbView.K()) {
                        if (view == this.f19584e.mSubPbView.L()) {
                            if (this.f19584e.checkUpIsLogin()) {
                                this.f19584e.mSubPbView.K0();
                                this.f19584e.mSubPbView.u();
                                if (this.f19584e.mEditor != null) {
                                    this.f19584e.mEditor.c0();
                                }
                            }
                        } else if (view.getId() != R.id.pb_floor_feedback) {
                            if (view == this.f19584e.mSubPbView.H()) {
                                this.f19584e.mSubPbView.w();
                                if (this.f19584e.mSubPbModel.z0()) {
                                    this.f19584e.mSubPbView.G0();
                                    return;
                                }
                                return;
                            }
                            String str4 = "";
                            if (view == this.f19584e.mSubPbView.D() || view == this.f19584e.mSubPbView.C() || view == this.f19584e.mSubPbView.O()) {
                                if (this.f19584e.mIsRichTextListenerAcked) {
                                    this.f19584e.mIsRichTextListenerAcked = false;
                                    return;
                                }
                                if (this.f19584e.mSubPbModel.X() != null && this.f19584e.mSubPbModel.X().l() != null) {
                                    z2 = ThreadCardUtils.isUgcThreadType(this.f19584e.mSubPbModel.X().l().J());
                                }
                                if (z2) {
                                    PbActivityConfig createNormalCfg = new PbActivityConfig(this.f19584e.getActivity()).createNormalCfg(this.f19584e.mSubPbModel.k0(), null, "");
                                    if (!StringUtils.isNull(this.f19584e.mSubPbModel.getFromForumId())) {
                                        createNormalCfg.setForumId(this.f19584e.mSubPbModel.getFromForumId());
                                    }
                                    if (this.f19584e.mSubPbModel.X() != null && this.f19584e.mSubPbModel.X().l() != null) {
                                        createNormalCfg.setBjhData(this.f19584e.mSubPbModel.X().l().J());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                                    return;
                                }
                                PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.f19584e.getActivity()).createNormalCfg(this.f19584e.mSubPbModel.k0(), this.f19584e.mSubPbModel.w(), "");
                                if (!StringUtils.isNull(this.f19584e.mSubPbModel.getFromForumId())) {
                                    createNormalCfg2.setForumId(this.f19584e.mSubPbModel.getFromForumId());
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg2));
                            } else if (this.f19584e.mSubPbView.J() == null || view != this.f19584e.mSubPbView.J().z()) {
                                if (this.f19584e.mSubPbView.J() == null || view != this.f19584e.mSubPbView.J().t()) {
                                    if (this.f19584e.mSubPbView.J() == null || view != this.f19584e.mSubPbView.J().y()) {
                                        if (this.f19584e.mSubPbView.J() == null || view != this.f19584e.mSubPbView.J().C()) {
                                            if (this.f19584e.mSubPbView.J() == null || view != this.f19584e.mSubPbView.J().s()) {
                                                if (view != this.f19584e.mSubPbView.E() && view != this.f19584e.mSubPbView.O()) {
                                                    if (view != null && (view.getTag() instanceof PbCommenFloorItemViewHolder)) {
                                                        this.f19584e.mItemClickShowSoftKeyBoardViewHolder = (PbCommenFloorItemViewHolder) view.getTag();
                                                        if (ViewHelper.checkUpIsLogin(this.f19584e.getPageContext().getPageActivity())) {
                                                            if (this.f19584e.mIsRichTextListenerAcked) {
                                                                this.f19584e.mIsRichTextListenerAcked = false;
                                                                return;
                                                            }
                                                            NewSubPbActivity newSubPbActivity = this.f19584e;
                                                            if (newSubPbActivity.mReplyPrivacyController != null && newSubPbActivity.mSubPbModel != null && this.f19584e.mSubPbModel.V() != null && !this.f19584e.isHost(TbadkCoreApplication.getCurrentAccount())) {
                                                                NewSubPbActivity newSubPbActivity2 = this.f19584e;
                                                                if (!newSubPbActivity2.mReplyPrivacyController.checkPrivacyBeforeInvokeEditor(newSubPbActivity2.mSubPbModel.V().replyPrivateFlag)) {
                                                                    return;
                                                                }
                                                            }
                                                            SparseArray sparseArray3 = (SparseArray) view.getTag(R.id.tag_from);
                                                            if (sparseArray3 == null) {
                                                                return;
                                                            }
                                                            this.f19584e.openEditor(sparseArray3, ((view.getTag(R.id.tag_subpb_ban_display_keyboard) instanceof Boolean) && view.getTag(R.id.tag_subpb_ban_display_keyboard) == Boolean.TRUE) ? false : false);
                                                            return;
                                                        }
                                                        return;
                                                    } else if (view.getId() != R.id.post_info_commont_img && view.getId() != R.id.pb_floor_comment_container && (this.f19584e.mPostMoreOptionView == null || view != this.f19584e.mPostMoreOptionView.B())) {
                                                        if (this.f19584e.mPostMoreOptionView == null || view != this.f19584e.mPostMoreOptionView.C()) {
                                                            if (this.f19584e.mPostMoreOptionView == null || view != this.f19584e.mPostMoreOptionView.z()) {
                                                                if (this.f19584e.mPostMoreOptionView == null || view != this.f19584e.mPostMoreOptionView.t()) {
                                                                    if (this.f19584e.mPostMoreOptionView == null || view != this.f19584e.mPostMoreOptionView.s()) {
                                                                        if (this.f19584e.mPostMoreOptionView == null || view != this.f19584e.mPostMoreOptionView.v()) {
                                                                            if (this.f19584e.mPostMoreOptionView == null || view != this.f19584e.mPostMoreOptionView.D()) {
                                                                                if (this.f19584e.mPostMoreOptionView == null || view != this.f19584e.mPostMoreOptionView.u()) {
                                                                                    if (this.f19584e.mPostMoreOptionView == null || view != this.f19584e.mPostMoreOptionView.y()) {
                                                                                        if (this.f19584e.mPostMoreOptionView == null || view != this.f19584e.mPostMoreOptionView.r()) {
                                                                                            if (this.f19584e.mPostMoreOptionView != null && view == this.f19584e.mPostMoreOptionView.E()) {
                                                                                                if (view.getTag() instanceof SparseArray) {
                                                                                                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                                                                                                    if (sparseArray4.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                                        PostData postData2 = (PostData) sparseArray4.get(R.id.tag_load_sub_data);
                                                                                                        d.a.s0.h2.k.e.c1.c cVar = new d.a.s0.h2.k.e.c1.c(this.f19584e.getPageContext());
                                                                                                        if (postData2 != null) {
                                                                                                            d.a.c.e.m.e.a().postDelayed(new a(this, cVar, postData2), 100L);
                                                                                                            String c0 = this.f19584e.mSubPbModel.X().l().c0();
                                                                                                            if (StringUtils.isNull(c0) || "0".equals(c0)) {
                                                                                                                c0 = this.f19584e.mSubPbModel.X().l().A0();
                                                                                                            }
                                                                                                            TiebaStatic.log(new StatisticItem("c13700").param("tid", c0).param("fid", this.f19584e.mSubPbModel.X().l().Q()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData2.E()).param("obj_source", 1).param("obj_type", 4));
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
                                                                                                if (ViewHelper.checkUpIsLogin(this.f19584e.getPageContext().getPageActivity())) {
                                                                                                    String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                                    String p = d.a.r0.r.d0.b.j().p("tail_link", "");
                                                                                                    if (StringUtils.isNull(p)) {
                                                                                                        return;
                                                                                                    }
                                                                                                    TiebaStatic.log("c10056");
                                                                                                    d.a.r0.l.a.o(view.getContext(), string, p, true, true, true);
                                                                                                    return;
                                                                                                }
                                                                                                return;
                                                                                            } else if (id == R.id.richText && (view.getTag() instanceof SparseArray)) {
                                                                                                Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
                                                                                                if (obj instanceof PostData) {
                                                                                                    PostData postData3 = (PostData) obj;
                                                                                                    if (postData3.getType() == PostData.w0 || TextUtils.isEmpty(postData3.u()) || !d.a.r0.r.k.c().g()) {
                                                                                                        return;
                                                                                                    }
                                                                                                    this.f19584e.navigateToBubbleWebView(postData3.E());
                                                                                                    return;
                                                                                                }
                                                                                                return;
                                                                                            } else {
                                                                                                return;
                                                                                            }
                                                                                        } else if (!d.a.c.e.p.j.z()) {
                                                                                            this.f19584e.showToast(R.string.network_not_available);
                                                                                            return;
                                                                                        } else if (!ViewHelper.checkUpIsLogin(this.f19584e.getActivity()) || (b2 = d.a.s0.r3.a.b(view)) == null || this.f19584e.mUserBlockController == null) {
                                                                                            return;
                                                                                        } else {
                                                                                            this.f19584e.mUserBlockController.n(d.a.c.e.m.b.f(b2, 0L));
                                                                                            return;
                                                                                        }
                                                                                    } else if (!d.a.c.e.p.j.z()) {
                                                                                        this.f19584e.showToast(R.string.network_not_available);
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
                                                                                                this.f19584e.mSubPbView.g0(((Integer) sparseArray5.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray5.get(R.id.tag_del_post_id), ((Integer) sparseArray5.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(R.id.tag_del_post_is_self)).booleanValue(), false);
                                                                                                return;
                                                                                            }
                                                                                            return;
                                                                                        } else if (booleanValue3) {
                                                                                            sparseArray5.put(R.id.tag_from, 1);
                                                                                            sparseArray5.put(R.id.tag_check_mute_from, 2);
                                                                                            this.f19584e.checkMuteState(sparseArray5);
                                                                                            return;
                                                                                        } else {
                                                                                            sparseArray5.put(R.id.tag_check_mute_from, 2);
                                                                                            this.f19584e.mSubPbView.i0(view);
                                                                                            return;
                                                                                        }
                                                                                    }
                                                                                } else if (this.f19584e.checkUpIsLogin() && (sparseArray = (SparseArray) view.getTag()) != null) {
                                                                                    PostData postData4 = (PostData) sparseArray.get(R.id.tag_clip_board);
                                                                                    if (postData4.q() == null) {
                                                                                        return;
                                                                                    }
                                                                                    this.f19584e.clickOnDisagree(postData4.q());
                                                                                    return;
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (this.f19584e.mSaveBdImage == null || TextUtils.isEmpty(this.f19584e.mSaveImageUrl)) {
                                                                                return;
                                                                            } else {
                                                                                if (this.f19584e.mPermissionJudgement == null) {
                                                                                    this.f19584e.mPermissionJudgement = new PermissionJudgePolicy();
                                                                                }
                                                                                this.f19584e.mPermissionJudgement.clearRequestPermissionList();
                                                                                this.f19584e.mPermissionJudgement.appendRequestPermission(this.f19584e.getPageContext().getPageActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                                                                                if (this.f19584e.mPermissionJudgement.startRequestPermission(this.f19584e.getPageContext().getPageActivity())) {
                                                                                    return;
                                                                                }
                                                                                if (this.f19584e.mSaveImageHelper == null) {
                                                                                    NewSubPbActivity newSubPbActivity3 = this.f19584e;
                                                                                    newSubPbActivity3.mSaveImageHelper = new x0(newSubPbActivity3.getPageContext());
                                                                                }
                                                                                this.f19584e.mSaveImageHelper.b(this.f19584e.mSaveImageUrl, this.f19584e.mSaveBdImage.n());
                                                                                this.f19584e.mSaveBdImage = null;
                                                                                this.f19584e.mSaveImageUrl = null;
                                                                                return;
                                                                            }
                                                                        } else if (this.f19584e.mSaveBdImage == null || TextUtils.isEmpty(this.f19584e.mSaveImageUrl)) {
                                                                            return;
                                                                        } else {
                                                                            if (this.f19584e.mEmotionInfo == null) {
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.f19584e.mSaveImageUrl));
                                                                            } else {
                                                                                d.a aVar = new d.a();
                                                                                aVar.f54736a = this.f19584e.mSaveImageUrl;
                                                                                if (this.f19584e.mEmotionInfo.memeInfo.pck_id.intValue() >= 0) {
                                                                                    str4 = "" + this.f19584e.mEmotionInfo.memeInfo.pck_id;
                                                                                }
                                                                                aVar.f54737b = str4;
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                                                                            }
                                                                            this.f19584e.mSaveBdImage = null;
                                                                            this.f19584e.mSaveImageUrl = null;
                                                                            return;
                                                                        }
                                                                    }
                                                                    NewSubPbActivity newSubPbActivity4 = this.f19584e;
                                                                    PostData postData5 = newSubPbActivity4.postData;
                                                                    if (postData5 != null) {
                                                                        postData5.h0(newSubPbActivity4.getPageContext().getPageActivity());
                                                                        this.f19584e.postData = null;
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                SparseArray sparseArray6 = (SparseArray) view.getTag();
                                                                if (sparseArray6 != null && (sparseArray6.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray6.get(R.id.tag_del_post_id) instanceof String) && (sparseArray6.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray6.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                                                                    boolean booleanValue4 = ((Boolean) sparseArray6.get(R.id.tag_del_post_is_self)).booleanValue();
                                                                    int intValue = ((Integer) sparseArray6.get(R.id.tag_manage_user_identity)).intValue();
                                                                    boolean booleanValue5 = ((Boolean) sparseArray6.get(R.id.tag_has_sub_post)).booleanValue();
                                                                    boolean isHost = this.f19584e.isHost(TbadkCoreApplication.getCurrentAccount());
                                                                    if (isHost) {
                                                                        if (!booleanValue5) {
                                                                            this.f19584e.showDelNoSubPostDialog(sparseArray6, intValue, booleanValue4);
                                                                            return;
                                                                        } else {
                                                                            this.f19584e.mSubPbView.g0(((Integer) sparseArray6.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray6.get(R.id.tag_del_post_id), intValue, booleanValue4, isHost);
                                                                            return;
                                                                        }
                                                                    } else if (booleanValue4 && !booleanValue5) {
                                                                        this.f19584e.showDelNoSubPostDialog(sparseArray6, intValue, booleanValue4);
                                                                        return;
                                                                    } else {
                                                                        this.f19584e.mSubPbView.g0(((Integer) sparseArray6.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray6.get(R.id.tag_del_post_id), intValue, booleanValue4, isHost);
                                                                        return;
                                                                    }
                                                                }
                                                                return;
                                                            } else if (this.f19584e.checkUpIsLogin()) {
                                                                this.f19584e.markFloor(view);
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        } else if (!d.a.c.e.p.j.z()) {
                                                            this.f19584e.showToast(R.string.network_not_available);
                                                            return;
                                                        } else {
                                                            Object tag = view.getTag();
                                                            if (tag instanceof String) {
                                                                this.f19584e.handleReportClicked((String) tag);
                                                                return;
                                                            } else if (tag instanceof SparseArray) {
                                                                SparseArray<Object> sparseArray7 = (SparseArray) tag;
                                                                if ((sparseArray7.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray7.get(R.id.tag_user_mute_visible)).booleanValue()) {
                                                                    sparseArray7.put(R.id.tag_from, 0);
                                                                    sparseArray7.put(R.id.tag_check_mute_from, 2);
                                                                    this.f19584e.checkMuteState(sparseArray7);
                                                                    return;
                                                                }
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        }
                                                    } else if (this.f19584e.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                        SparseArray sparseArray8 = (SparseArray) view.getTag();
                                                        if ((sparseArray8.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray8.get(R.id.tag_load_sub_data)) != null) {
                                                            if (this.f19584e.mSubPbModel != null) {
                                                                TiebaStatic.log(new StatisticItem("c13700").param("tid", this.f19584e.mSubPbModel.l0()).param("fid", this.f19584e.mSubPbModel.getFromForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData.E()).param("obj_source", 1).param("obj_type", 3));
                                                            }
                                                            this.f19584e.openEditor(postData, ((view.getTag(R.id.tag_subpb_ban_display_keyboard) instanceof Boolean) && view.getTag(R.id.tag_subpb_ban_display_keyboard) == Boolean.TRUE) ? false : false);
                                                            return;
                                                        }
                                                        return;
                                                    } else {
                                                        return;
                                                    }
                                                } else if (this.f19584e.checkUpIsLogin()) {
                                                    if (this.f19584e.mEditor.y()) {
                                                        this.f19584e.mEditor.w();
                                                        return;
                                                    } else {
                                                        this.f19584e.mEditor.f0(null);
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
                                                    ((PostData) sparseArray9.get(R.id.tag_clip_board)).h0(this.f19584e.getPageContext().getPageActivity());
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                        TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                                        if (!d.a.c.e.p.j.z()) {
                                            this.f19584e.showToast(R.string.network_not_available);
                                            return;
                                        }
                                        Object tag2 = view.getTag();
                                        this.f19584e.mSubPbView.w();
                                        if (tag2 instanceof String) {
                                            String str5 = (String) tag2;
                                            if (this.f19584e.checkUpIsLogin()) {
                                                this.f19584e.handleReportClicked(str5);
                                                return;
                                            }
                                            return;
                                        } else if (tag2 instanceof SparseArray) {
                                            SparseArray<Object> sparseArray10 = (SparseArray) tag2;
                                            if ((sparseArray10.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray10.get(R.id.tag_user_mute_visible)).booleanValue()) {
                                                sparseArray10.put(R.id.tag_from, 0);
                                                sparseArray10.put(R.id.tag_check_mute_from, 2);
                                                this.f19584e.checkMuteState(sparseArray10);
                                                return;
                                            }
                                            return;
                                        } else {
                                            return;
                                        }
                                    } else if (d.a.c.e.p.j.z()) {
                                        this.f19584e.mSubPbView.w();
                                        if (this.f19584e.checkUpIsLogin()) {
                                            this.f19584e.doManager(view);
                                            return;
                                        }
                                        return;
                                    } else {
                                        this.f19584e.showToast(R.string.network_not_available);
                                        return;
                                    }
                                }
                                this.f19584e.mSubPbView.w();
                                SparseArray sparseArray11 = (SparseArray) view.getTag();
                                if (sparseArray11 == null) {
                                    return;
                                }
                                this.f19584e.mSubPbView.g0(((Integer) sparseArray11.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray11.get(R.id.tag_del_post_id), ((Integer) sparseArray11.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray11.get(R.id.tag_del_post_is_self)).booleanValue(), false);
                            } else {
                                TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                                this.f19584e.mSubPbView.w();
                                if (this.f19584e.checkUpIsLogin() && this.f19584e.mSubPbModel.X() != null) {
                                    NewSubPbActivity newSubPbActivity5 = this.f19584e;
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
                            if (this.f19584e.mPostMoreOptionView == null) {
                                this.f19584e.mPostMoreOptionView = new d.a.s0.h2.k.e.d0(this.f19584e.getPageContext(), this.f19584e.mCommonClickListener);
                                this.f19584e.mSubPbView.w0(this.f19584e.mPostMoreOptionView.F());
                                this.f19584e.mPostMoreOptionView.n(this.f19584e.mIsLogin);
                            }
                            this.f19584e.mPostMoreOptionView.l();
                            this.f19584e.mPostMoreOptionView.o(sparseArray2, this.f19584e.getUserIdentity(), (this.f19584e.isShowReportButton(sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue() : false) && this.f19584e.isLogin()) ? false : false, this.f19584e.mSubPbModel.X());
                        }
                    } else if (this.f19584e.checkUpIsLogin()) {
                        this.f19584e.mSubPbView.K0();
                        this.f19584e.mSubPbView.u();
                        if (this.f19584e.mEditor != null) {
                            this.f19584e.mEditor.a0();
                        }
                    }
                } else if (this.f19584e.checkUpIsLogin()) {
                    this.f19584e.processProfessionPermission();
                    if (this.f19584e.mSubPbModel == null || this.f19584e.mSubPbModel.X() == null || this.f19584e.mSubPbModel.X().l() == null || this.f19584e.mSubPbModel.X().l().H() == null) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f19584e.mSubPbModel.k0()).param("fid", this.f19584e.mSubPbModel.X().l().Q()).param("obj_locate", 5).param("uid", this.f19584e.mSubPbModel.X().l().H().getUserId()));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f19588a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l0(NewSubPbActivity newSubPbActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, Integer.valueOf(i2)};
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
            this.f19588a = newSubPbActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.f19588a.MESSAGE_ID_NEWSUB_PB) {
                this.f19588a.mSubPbView.R();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    this.f19588a.mToastMute.c(this.f19588a.mCtx.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.f19588a.mCtx.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    this.f19588a.showUserMuteAddDialog(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    this.f19588a.showOpenMemberReplyDialog();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (d.a.c.e.p.k.isEmpty(errorString2)) {
                        errorString2 = this.f19588a.mCtx.getResources().getString(R.string.mute_fail);
                    }
                    this.f19588a.mToastMute.b(errorString2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f19589e;

        public m(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19589e = newSubPbActivity;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) {
                this.f19589e.mSubPbView.f0();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) {
                if (i2 == 2 || i2 == 1) {
                    this.f19589e.mSubPbView.w();
                    if (this.f19589e.lastScrollState != 2 && this.f19589e.lastScrollState != 1) {
                        this.f19589e.mSubPbView.T();
                    }
                }
                this.f19589e.mEditor.w();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f19590a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m0(NewSubPbActivity newSubPbActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, Integer.valueOf(i2)};
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
            this.f19590a = newSubPbActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.f19590a.MESSAGE_ID_NEWSUB_PB) {
                this.f19590a.mSubPbView.R();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    this.f19590a.mToastMute.c(this.f19590a.mCtx.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (d.a.c.e.p.k.isEmpty(muteMessage)) {
                    muteMessage = this.f19590a.mCtx.getResources().getString(R.string.un_mute_fail);
                }
                this.f19590a.mToastMute.b(muteMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f19591e;

        public n(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19591e = newSubPbActivity;
        }

        /* JADX WARN: Removed duplicated region for block: B:74:0x0190 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:75:0x0191  */
        @Override // android.view.View.OnLongClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            SparseArray<Object> sparseArray;
            SparseArray<Object> sparseArray2;
            SparseArray<Object> sparseArray3;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, view)) != null) {
                return invokeL.booleanValue;
            }
            if (this.f19591e.mSubPbView != null && this.f19591e.mSubPbView.Y()) {
                return false;
            }
            try {
                sparseArray = (SparseArray) view.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null && this.f19591e.isImage(view)) {
                if (view instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) view;
                    this.f19591e.mSaveBdImage = tbImageView.getBdImage();
                    this.f19591e.mSaveImageUrl = tbImageView.getUrl();
                    if (this.f19591e.mSaveBdImage == null || TextUtils.isEmpty(this.f19591e.mSaveImageUrl)) {
                        return true;
                    }
                    if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        this.f19591e.mEmotionInfo = null;
                    } else {
                        this.f19591e.mEmotionInfo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    }
                } else if (view instanceof GifView) {
                    GifView gifView = (GifView) view;
                    if (gifView.getBdImage() == null) {
                        return true;
                    }
                    this.f19591e.mSaveBdImage = gifView.getBdImage();
                    if (!TextUtils.isEmpty(gifView.getBdImage().q())) {
                        this.f19591e.mSaveImageUrl = gifView.getBdImage().q();
                    }
                    if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        this.f19591e.mEmotionInfo = null;
                    } else {
                        this.f19591e.mEmotionInfo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    }
                } else if (view instanceof TbMemeImageView) {
                    TbMemeImageView tbMemeImageView = (TbMemeImageView) view;
                    if (tbMemeImageView.getBdImage() != null) {
                        this.f19591e.mSaveBdImage = tbMemeImageView.getBdImage();
                        if (!TextUtils.isEmpty(tbMemeImageView.getBdImage().q())) {
                            this.f19591e.mSaveImageUrl = tbMemeImageView.getBdImage().q();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            this.f19591e.mEmotionInfo = null;
                        } else {
                            this.f19591e.mEmotionInfo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                    this.f19591e.mSubPbView.E0(this.f19591e.mOnImageSaveClickListener, this.f19591e.mSaveBdImage.t());
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
                this.f19591e.postData = (PostData) sparseArray2.get(R.id.tag_clip_board);
                NewSubPbActivity newSubPbActivity = this.f19591e;
                if (newSubPbActivity.postData == null || newSubPbActivity.mMarkModel == null) {
                    return true;
                }
                if (this.f19591e.mMarkModel != null) {
                    this.f19591e.mMarkModel.h(this.f19591e.mSubPbModel.v0());
                }
                boolean z = this.f19591e.mMarkModel.e() && this.f19591e.postData.E() != null && this.f19591e.postData.E().equals(this.f19591e.mSubPbModel.f0());
                if (this.f19591e.mPostMoreOptionView == null) {
                    this.f19591e.mPostMoreOptionView = new d.a.s0.h2.k.e.d0(this.f19591e.getPageContext(), this.f19591e.mCommonClickListener);
                    this.f19591e.mSubPbView.w0(this.f19591e.mPostMoreOptionView.F());
                    this.f19591e.mPostMoreOptionView.n(this.f19591e.mIsLogin);
                }
                this.f19591e.mPostMoreOptionView.l();
                boolean z2 = this.f19591e.isShowReportButton(sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue() : false) && this.f19591e.isLogin();
                boolean z3 = (this.f19591e.mSubPbModel.X() == null || this.f19591e.mSubPbModel.X().l() == null || !this.f19591e.mSubPbModel.X().l().I1()) ? false : true;
                boolean booleanValue = sparseArray2.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_is_subpb)).booleanValue() : false;
                if (z) {
                    this.f19591e.mPostMoreOptionView.z().setText(R.string.remove_mark);
                } else {
                    this.f19591e.mPostMoreOptionView.z().setText(R.string.mark);
                }
                if (booleanValue || z3) {
                    this.f19591e.mPostMoreOptionView.z().setVisibility(8);
                } else {
                    this.f19591e.mPostMoreOptionView.z().setVisibility(0);
                }
                if (this.f19591e.isImage(view)) {
                    if (this.f19591e.mSaveBdImage != null && !this.f19591e.mSaveBdImage.t()) {
                        sparseArray2.put(R.id.tag_richtext_image, Boolean.TRUE);
                    } else {
                        sparseArray2.put(R.id.tag_richtext_image, Boolean.FALSE);
                    }
                    sparseArray2.put(R.id.tag_richtext_emotion, Boolean.TRUE);
                } else {
                    sparseArray2.put(R.id.tag_richtext_image, Boolean.FALSE);
                    sparseArray2.put(R.id.tag_richtext_emotion, Boolean.FALSE);
                }
                d.a.s0.h2.h.r X = this.f19591e.mSubPbModel.X();
                this.f19591e.mPostMoreOptionView.j(d.a.s0.h2.k.e.f1.a.f(this.f19591e.postData));
                this.f19591e.mPostMoreOptionView.p(sparseArray2, this.f19591e.getUserIdentity(), z2, this.f19591e.showTrisectionAndFeedback && this.f19591e.postData.m0, X);
                return true;
            }
            sparseArray2 = sparseArray;
            if (sparseArray2 != null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f19592a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n0(NewSubPbActivity newSubPbActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, Integer.valueOf(i2)};
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
            this.f19592a = newSubPbActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof d.a.s0.s3.a) && customResponsedMessage.getOrginalMessage().getTag() == this.f19592a.MESSAGE_ID_NEWSUB_PB) {
                d.a.s0.s3.a aVar = (d.a.s0.s3.a) customResponsedMessage.getData();
                this.f19592a.mSubPbView.R();
                SparseArray<Object> sparseArray = (SparseArray) this.f19592a.mExtra;
                DataRes dataRes = aVar.f65437a;
                if (aVar.f65439c == 0 && dataRes != null) {
                    z = d.a.c.e.m.b.d(dataRes.is_mute, 0) == 1;
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_user_mute_msg, dataRes.mute_confirm);
                } else {
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                    z = false;
                }
                int intValue = sparseArray.get(R.id.tag_from) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_from)).intValue() : 0;
                if (intValue == 0) {
                    this.f19592a.showOperateDialog(z, sparseArray);
                } else if (intValue == 1) {
                    this.f19592a.mSubPbView.h0(sparseArray, z);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o implements TbRichTextView.x {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f19593a;

        public o(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19593a = newSubPbActivity;
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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, str, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                        d.a.s0.h2.h.r X = this.f19593a.mSubPbModel.X();
                        TbRichText validImage = this.f19593a.validImage(str, i2);
                        TbRichTextData tbRichTextData = (validImage == null || validImage.y() == null) ? null : validImage.y().get(this.f19593a.imgIndex);
                        if (tbRichTextData == null) {
                            return;
                        }
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        if (!tbRichTextData.B().D()) {
                            String encodeImageUrl = this.f19593a.encodeImageUrl(tbRichTextData);
                            arrayList.add(encodeImageUrl);
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = str;
                            imageUrlData.urlType = this.f19593a.mIsFromCDN ? 17 : 18;
                            concurrentHashMap.put(encodeImageUrl, imageUrlData);
                            if (X != null) {
                                if (X.d() != null) {
                                    str6 = X.d().getName();
                                    str7 = X.d().getId();
                                } else {
                                    str6 = null;
                                    str7 = null;
                                }
                                str8 = X.l() != null ? X.l().c0() : null;
                                z4 = true;
                            } else {
                                z4 = false;
                                str6 = null;
                                str7 = null;
                                str8 = null;
                            }
                            if (this.f19593a.mSubPbModel.n0() != null) {
                                concurrentHashMap = this.f19593a.mSubPbModel.n0();
                                z4 = this.f19593a.mSubPbModel.r0();
                                arrayList = this.f19593a.mSubPbModel.m0();
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
                            bVar.N(this.f19593a.getThreadData());
                            bVar.L(String.valueOf(validImage.getPostId()));
                            bVar.A(this.f19593a.mSubPbModel.getFromForumId());
                            this.f19593a.sendMessage(new CustomMessage(2010000, bVar.v(this.f19593a.getPageContext().getPageActivity())));
                            return;
                        }
                        this.f19593a.index_valid = false;
                        TbRichText K = X.i().K();
                        int size = arrayList.size();
                        int imageIndex = this.f19593a.getImageIndex(K, validImage, i2, i2, arrayList, concurrentHashMap);
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
                            str2 = X.l() != null ? X.l().c0() : null;
                            z3 = true;
                            str4 = str5;
                        } else {
                            str2 = null;
                            str3 = null;
                            z3 = false;
                            str4 = null;
                        }
                        if (this.f19593a.mSubPbModel.n0() != null) {
                            concurrentHashMap = this.f19593a.mSubPbModel.n0();
                            z3 = this.f19593a.mSubPbModel.r0();
                            arrayList = this.f19593a.mSubPbModel.m0();
                            imageIndex += this.f19593a.mSubPbModel.g0();
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
                        bVar2.N(this.f19593a.getThreadData());
                        bVar2.L(String.valueOf(validImage.getPostId()));
                        bVar2.A(this.f19593a.mSubPbModel.getFromForumId());
                        this.f19593a.sendMessage(new CustomMessage(2010000, bVar2.v(this.f19593a.getPageContext().getPageActivity())));
                        return;
                    }
                    TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    boolean w = ((TbImageView) view).w();
                    if (tbRichTextMemeInfo == null || tbRichTextMemeInfo.memeInfo == null) {
                        return;
                    }
                    this.f19593a.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(this.f19593a.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, w)));
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o0 implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f19594e;

        public o0(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19594e = newSubPbActivity;
        }

        @Override // d.a.r0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f19594e.mSubPbModel == null) {
                return;
            }
            this.f19594e.mSubPbModel.B0();
        }
    }

    /* loaded from: classes5.dex */
    public class p implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f19595a;

        public p(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19595a = newSubPbActivity;
        }

        @Override // d.a.r0.r.s.b.c
        public void a(d.a.r0.r.s.b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) {
                bVar.e();
                if (this.f19595a.mSaveBdImage == null || TextUtils.isEmpty(this.f19595a.mSaveImageUrl)) {
                    return;
                }
                if (i2 == 0) {
                    if (this.f19595a.mEmotionInfo == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.f19595a.mSaveImageUrl));
                    } else {
                        d.a aVar = new d.a();
                        aVar.f54736a = this.f19595a.mSaveImageUrl;
                        String str = "";
                        if (this.f19595a.mEmotionInfo.memeInfo.pck_id.intValue() >= 0) {
                            str = "" + this.f19595a.mEmotionInfo.memeInfo.pck_id;
                        }
                        aVar.f54737b = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i2 == 1) {
                    if (this.f19595a.mPermissionJudgement == null) {
                        this.f19595a.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    this.f19595a.mPermissionJudgement.clearRequestPermissionList();
                    this.f19595a.mPermissionJudgement.appendRequestPermission(this.f19595a.getPageContext().getPageActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                    if (this.f19595a.mPermissionJudgement.startRequestPermission(this.f19595a.getPageContext().getPageActivity())) {
                        return;
                    }
                    if (this.f19595a.mSaveImageHelper == null) {
                        NewSubPbActivity newSubPbActivity = this.f19595a;
                        newSubPbActivity.mSaveImageHelper = new x0(newSubPbActivity.getPageContext());
                    }
                    this.f19595a.mSaveImageHelper.b(this.f19595a.mSaveImageUrl, this.f19595a.mSaveBdImage.n());
                }
                this.f19595a.mSaveBdImage = null;
                this.f19595a.mSaveImageUrl = null;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p0 implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f19596a;

        public p0(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19596a = newSubPbActivity;
        }

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && z) {
                this.f19596a.mEditor.D();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f19597a;

        public q(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19597a = newSubPbActivity;
        }

        @Override // d.a.s0.u0.f2.a.c.d
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x00cd  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00d7  */
        @Override // d.a.s0.u0.f2.a.c.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void b(boolean z) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) != null) || !z) {
                return;
            }
            NewSubPbActivity newSubPbActivity = this.f19597a;
            if (newSubPbActivity.mReplyPrivacyController != null && newSubPbActivity.mSubPbModel != null && this.f19597a.mSubPbModel.V() != null && !this.f19597a.isHost(TbadkCoreApplication.getCurrentAccount())) {
                NewSubPbActivity newSubPbActivity2 = this.f19597a;
                if (!newSubPbActivity2.mReplyPrivacyController.checkPrivacyBeforeInvokeEditor(newSubPbActivity2.mSubPbModel.V().replyPrivateFlag)) {
                    return;
                }
            }
            if (this.f19597a.mSubPbModel != null && this.f19597a.mSubPbModel.X() != null && this.f19597a.mSubPbModel.X().i() != null) {
                PostData i2 = this.f19597a.mSubPbModel.X().i();
                if (i2.K() != null && i2.t() != null) {
                    str = String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), i2.t().getName_show(), i2.K().toString());
                    this.f19597a.mEditor.a().A(new d.a.r0.w.a(45, 27, str));
                    if (!this.f19597a.mEditor.v()) {
                        this.f19597a.mEditor.t(null);
                        return;
                    }
                    this.f19597a.mSubPbView.K0();
                    this.f19597a.mSubPbView.u();
                    if (this.f19597a.mEditor != null) {
                        this.f19597a.mEditor.e0();
                        return;
                    }
                    return;
                }
            }
            str = null;
            this.f19597a.mEditor.a().A(new d.a.r0.w.a(45, 27, str));
            if (!this.f19597a.mEditor.v()) {
            }
        }

        @Override // d.a.s0.u0.f2.a.c.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface q0 {
        void a(Object obj);
    }

    /* loaded from: classes5.dex */
    public class r implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f19598e;

        public r(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19598e = newSubPbActivity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || this.f19598e.mSensitiveProcessController == null) {
                return;
            }
            if (!this.f19598e.mSensitiveProcessController.e()) {
                this.f19598e.checkContentSensitiveWord(false);
            }
            this.f19598e.mSensitiveProcessController.l(false);
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

    /* loaded from: classes5.dex */
    public class s implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SparseArray f19599a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f19600b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f19601c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f19602d;

        public s(NewSubPbActivity newSubPbActivity, SparseArray sparseArray, boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, sparseArray, Boolean.valueOf(z), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19602d = newSubPbActivity;
            this.f19599a = sparseArray;
            this.f19600b = z;
            this.f19601c = str;
        }

        @Override // d.a.r0.r.s.b.c
        public void a(d.a.r0.r.s.b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) {
                if (i2 == 0) {
                    String str = this.f19599a.get(R.id.tag_user_mute_mute_username) instanceof String ? (String) this.f19599a.get(R.id.tag_user_mute_mute_username) : "";
                    String str2 = this.f19599a.get(R.id.tag_user_mute_thread_id) instanceof String ? (String) this.f19599a.get(R.id.tag_user_mute_thread_id) : "";
                    String str3 = this.f19599a.get(R.id.tag_user_mute_post_id) instanceof String ? (String) this.f19599a.get(R.id.tag_user_mute_post_id) : "";
                    String str4 = this.f19599a.get(R.id.tag_user_mute_msg) instanceof String ? (String) this.f19599a.get(R.id.tag_user_mute_msg) : "";
                    String str5 = this.f19599a.get(R.id.tag_user_mute_mute_nameshow) instanceof String ? (String) this.f19599a.get(R.id.tag_user_mute_mute_nameshow) : "";
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.f19600b, this.f19601c, str, str2, str3, 1, str4, this.f19602d.MESSAGE_ID_NEWSUB_PB);
                    userMuteAddAndDelCustomMessage.setTag(this.f19602d.MESSAGE_ID_NEWSUB_PB);
                    this.f19602d.showUserMuteDialog(this.f19600b, userMuteAddAndDelCustomMessage, str4, str, str5);
                }
                bVar.e();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f19603a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(NewSubPbActivity newSubPbActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, Integer.valueOf(i2)};
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
            this.f19603a = newSubPbActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                d.a.r0.b1.m.f.b(this.f19603a.getPageContext(), aVar.f55046a, aVar.f55047b, aVar.f55048c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u implements d.a.c.e.k.c<GifView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f19604a;

        public u(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19604a = newSubPbActivity;
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
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gifView)) == null) ? gifView : (GifView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(GifView gifView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, gifView) == null) {
                gifView.c0();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new GifView(this.f19604a.getPageContext().getPageActivity()) : (GifView) invokeV.objValue;
        }

        public GifView h(GifView gifView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, gifView)) == null) ? gifView : (GifView) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class v implements d.a.r0.w.w.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f19605a;

        public v(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19605a = newSubPbActivity;
        }

        @Override // d.a.r0.w.w.b
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f19605a.mSensitiveProcessController.d()) {
                    NewSubPbActivity newSubPbActivity = this.f19605a;
                    newSubPbActivity.showToast(newSubPbActivity.mSensitiveProcessController.c());
                    if (this.f19605a.mEditor.v()) {
                        this.f19605a.mEditor.t(this.f19605a.mPostWriteCallBackData);
                    }
                    this.f19605a.checkContentSensitiveWord(true);
                    return true;
                }
                NewSubPbActivity newSubPbActivity2 = this.f19605a;
                if (newSubPbActivity2.mReplyPrivacyController == null || newSubPbActivity2.mSubPbModel == null || this.f19605a.mSubPbModel.V() == null || this.f19605a.isHost(TbadkCoreApplication.getCurrentAccount())) {
                    return false;
                }
                NewSubPbActivity newSubPbActivity3 = this.f19605a;
                return !newSubPbActivity3.mReplyPrivacyController.checkPrivacyBeforeSend(newSubPbActivity3.mSubPbModel.V().replyPrivateFlag, ReplyPrivacyCheckController.TYPE_FLOOR);
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class w implements d.a.c.e.k.c<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f19606a;

        public w(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19606a = newSubPbActivity;
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
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, imageView)) == null) {
                if (imageView instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) imageView;
                    tbImageView.setTag(null);
                    if (d.a.r0.r.k.c().g()) {
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
        @Override // d.a.c.e.k.c
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
                    foreDrawableImageView.Q();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.CAM_X0204);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.f19606a.getPageContext().getPageActivity());
                boolean g2 = d.a.r0.r.k.c().g();
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
                    foreDrawableImageView.Q();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.CAM_X0204);
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class x implements d.a.c.e.k.c<View> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f19607a;

        public x(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19607a = newSubPbActivity;
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
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view)) == null) ? view : (View) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
                ((PlayVoiceBntNew) view).l();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(this.f19607a.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                playVoiceBntNew.setVoiceManager(this.f19607a.getVoiceManager());
                playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                return playVoiceBntNew;
            }
            return (View) invokeV.objValue;
        }

        public View h(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view)) == null) {
                ((PlayVoiceBntNew) view).l();
                return view;
            }
            return (View) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class y implements d.a.c.e.k.c<LinearLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f19608a;

        public y(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19608a = newSubPbActivity;
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
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, linearLayout)) == null) ? linearLayout : (LinearLayout) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(LinearLayout linearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, linearLayout) == null) {
                linearLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public LinearLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                LinearLayout linearLayout = new LinearLayout(this.f19608a.getPageContext().getPageActivity());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                linearLayout.setLayoutParams(layoutParams);
                linearLayout.setGravity(16);
                linearLayout.setBaselineAligned(true);
                linearLayout.setOrientation(1);
                linearLayout.setLayoutParams(layoutParams);
                return linearLayout;
            }
            return (LinearLayout) invokeV.objValue;
        }

        public LinearLayout h(LinearLayout linearLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, linearLayout)) == null) {
                linearLayout.removeAllViews();
                return linearLayout;
            }
            return (LinearLayout) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class z implements d.a.c.e.k.c<RelativeLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f19609a;

        public z(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19609a = newSubPbActivity;
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
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, relativeLayout)) == null) ? relativeLayout : (RelativeLayout) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(RelativeLayout relativeLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, relativeLayout) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public RelativeLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new RelativeLayout(this.f19609a.getPageContext().getPageActivity()) : (RelativeLayout) invokeV.objValue;
        }

        public RelativeLayout h(RelativeLayout relativeLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, relativeLayout)) == null) ? relativeLayout : (RelativeLayout) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(889977085, "Lcom/baidu/tieba/pb/pb/sub/NewSubPbActivity;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(889977085, "Lcom/baidu/tieba/pb/pb/sub/NewSubPbActivity;");
        }
    }

    public NewSubPbActivity() {
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
        this.mIsFromCDN = true;
        this.imgIndex = 0;
        this.postData = null;
        this.mMarkDoneCallBack = null;
        this.forbidUserCallback = null;
        this.deleteReplayCallback = null;
        this.mIsPaused = false;
        this.isFirstLoadData = false;
        this.mIsRichTextListenerAcked = false;
        this.mIsFromPb = false;
        this.mPrePostCallBack = new k(this);
        this.lastScrollState = 0;
        this.mIsFromSchema = false;
        this.mOnlyDisagreeId = BdUniqueId.gen();
        this.showTrisectionAndFeedback = d.a.r0.b.d.W();
        this.needOpenEditor = true;
        this.mCheckPostCallBack = new v(this);
        this.subpbReplyListener = new g0(this, 2921481);
        this.mOnPostWriteNewCallback = new h0(this);
        this.mUserMuteAddListener = new l0(this, 2001427);
        this.mUserMuteDelListener = new m0(this, 2001428);
        this.mUserMuteCheckListener = new n0(this, 2001426);
        this.mOnPullRefreshListener = new o0(this);
        this.index_valid = false;
        this.mOnImageSaveClickListener = new p(this);
        this.richTextIntentClickListener = new t(this, 2001332);
        this.updatePendantMessageListener = new i0(this, 2016485);
    }

    private boolean checkIsIfPostForbid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65603, this)) == null) {
            SubPbModel subPbModel = this.mSubPbModel;
            if (subPbModel == null) {
                return false;
            }
            return AntiHelper.d(getPageContext(), subPbModel.V());
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void clickOnDisagree(AgreeData agreeData) {
        d.a.r0.i0.c k2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65604, this, agreeData) == null) || agreeData == null) {
            return;
        }
        if (this.mMessageHelper == null) {
            this.mMessageHelper = new d.a.r0.r.b0.a();
        }
        if (this.mMsgData == null) {
            d.a.s0.h3.h0.e eVar = new d.a.s0.h3.h0.e();
            this.mMsgData = eVar;
            eVar.f61215a = this.mOnlyDisagreeId;
        }
        d.a.r0.r.q.f fVar = new d.a.r0.r.q.f();
        fVar.f55932b = 12;
        fVar.f55938h = 9;
        fVar.f55937g = 3;
        if (getSubPbModel() != null) {
            fVar.f55936f = getSubPbModel().h0();
        }
        fVar.f55931a = 2;
        int i2 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                fVar.f55939i = 0;
                k2 = TbPageExtraHelper.k(getActivity());
                if (k2 != null) {
                    agreeData.objSource = k2.a();
                }
                this.mMessageHelper.c(agreeData, i2, getUniqueId(), false);
                this.mMessageHelper.d(agreeData, this.mMsgData);
                if (getSubPbModel() != null || getSubPbModel().X() == null) {
                }
                this.mMessageHelper.b(this, fVar, agreeData, getSubPbModel().X().l());
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            fVar.f55939i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            fVar.f55939i = 1;
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
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65605, this, view) == null) || view == null || (sparseArray = (SparseArray) view.getTag()) == null) {
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
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65606, this, tbRichTextData)) == null) {
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
        return (String) invokeL.objValue;
    }

    private void fixReplyFloorViewHolderPosition(boolean z2) {
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
        int i2;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65607, this, z2) == null) {
            Rect rect = new Rect();
            FrameLayout frameLayout = (FrameLayout) findViewById(16908290);
            if (frameLayout != null && (childAt = frameLayout.getChildAt(0)) != null) {
                frameLayout.getWindowVisibleDisplayFrame(rect);
                if (z2) {
                    ((FrameLayout.LayoutParams) childAt.getLayoutParams()).height = rect.height();
                    childAt.requestLayout();
                }
            }
            d.a.s0.h2.k.g.a aVar = this.mSubPbView;
            if (aVar == null || aVar.G() == null || (pbCommenFloorItemViewHolder = this.mItemClickShowSoftKeyBoardViewHolder) == null || (i2 = pbCommenFloorItemViewHolder.U) == -1) {
                return;
            }
            int headerViewsCount = i2 + this.mSubPbView.G().getHeaderViewsCount();
            if (this.mItemClickShowSoftKeyBoardViewHolder.a() != null) {
                int height = this.mItemClickShowSoftKeyBoardViewHolder.a().getHeight();
                int height2 = ((rect.height() - this.mSubPbView.A()) - this.mSubPbView.I()) - this.mSubPbView.B();
                int i3 = height - height2;
                if (i3 > 0) {
                    this.mSubPbView.G().post(new j0(this, headerViewsCount, i3));
                } else {
                    this.mSubPbView.G().post(new k0(this, headerViewsCount, height2, height));
                }
            }
        }
    }

    private TbRichText getImage(PostData postData, String str, int i2) {
        InterceptResult invokeLLI;
        TbRichText K;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65608, this, postData, str, i2)) == null) {
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
        return (TbRichText) invokeLLI.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getImageIndex(TbRichText tbRichText, TbRichText tbRichText2, int i2, int i3, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        InterceptResult invokeCommon;
        TbRichTextImageInfo B;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65609, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i2), Integer.valueOf(i3), arrayList, concurrentHashMap})) == null) {
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
        return invokeCommon.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b2 getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65610, this)) == null) {
            SubPbModel subPbModel = this.mSubPbModel;
            if (subPbModel == null || subPbModel.X() == null) {
                return null;
            }
            return this.mSubPbModel.X().l();
        }
        return (b2) invokeV.objValue;
    }

    private void handleFullScreenEditorResult(int i2, Intent intent) {
        d.a.r0.w.n nVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65611, this, i2, intent) == null) {
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
                d.a.r0.w.m n2 = this.mEditor.a().n(6);
                if (n2 != null && (nVar = n2.k) != null) {
                    nVar.onAction(new d.a.r0.w.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i2 == -1) {
                    this.mEditor.D();
                }
                this.mSubPbView.T();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initEditor(boolean z2) {
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65612, this, z2) == null) {
            d.a.r0.w.w.h hVar = (d.a.r0.w.w.h) new d.a.r0.w.w.i(z2).a(getActivity());
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
            d.a.s0.h2.k.g.a aVar = this.mSubPbView;
            if (aVar != null) {
                aVar.X(this.mEditor);
            }
            d.a.r0.w.w.h hVar2 = this.mEditor;
            if (hVar2 != null && (subPbModel = this.mSubPbModel) != null) {
                hVar2.E(subPbModel.V());
                this.mEditor.w();
            }
            d.a.r0.w.w.h hVar3 = this.mEditor;
            if (hVar3 == null) {
                return;
            }
            hVar3.s().k(getReplyHint());
            this.mEditor.s().l(getReplyHint());
            EditText i2 = this.mEditor.s().i();
            this.mSubFloorEditText = i2;
            i2.addTextChangedListener(new r(this));
        }
    }

    private boolean initIsFromPb(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65613, this, bundle)) == null) {
            if (bundle != null) {
                this.mIsFromPb = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            } else {
                this.mIsFromPb = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            }
            return this.mIsFromPb;
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShowReportButton(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65614, this, z2)) == null) {
            if (this.mSubPbModel == null) {
                return false;
            }
            return ((getUserIdentity() != 0) || this.mSubPbModel.X() == null || this.mSubPbModel.X().l() == null || this.mSubPbModel.X().l().H() == null || this.mSubPbModel.X().l().p2() || TextUtils.equals(this.mSubPbModel.X().l().H().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z2) ? false : true;
        }
        return invokeZ.booleanValue;
    }

    private void jumpToWeb(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65615, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this, "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void markFloor(View view) {
        SparseArray sparseArray;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65616, this, view) == null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void navigateToBubbleWebView(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65617, this, str) == null) && !StringUtils.isNull(str) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
            String p2 = d.a.r0.r.d0.b.j().p("bubble_link", "");
            if (StringUtils.isNull(p2)) {
                return;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return;
            }
            d.a.r0.l.a.o(getPageContext().getPageActivity(), getResources().getString(R.string.editor_privilege), p2 + "?props_id=" + str, true, true, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onNetOrDataError(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65618, this, i2, str) == null) {
            if (this.mSubPbModel.q0()) {
                showToast(str);
            } else if (!d.a.c.e.p.l.D()) {
                this.mSubPbView.C0(R.string.recommend_pb_no_net_text);
            } else if (i2 == 4) {
                d.a.s0.h2.k.g.a aVar = this.mSubPbView;
                aVar.D0(str + "(4" + SmallTailInfo.EMOTION_SUFFIX, true);
            } else if (!TextUtils.isEmpty(str)) {
                d.a.s0.h2.k.g.a aVar2 = this.mSubPbView;
                aVar2.D0(str + "(" + i2 + SmallTailInfo.EMOTION_SUFFIX, true);
            } else {
                this.mSubPbView.C0(R.string.no_data_text);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openEditor(SparseArray<Object> sparseArray, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65619, this, sparseArray, z2) == null) || sparseArray == null) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65621, this) == null) {
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
                    d.a.r0.w.w.h hVar = this.mEditor;
                    if (hVar != null) {
                        hVar.e0();
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.mProfessionController == null) {
                d.a.s0.u0.f2.a.c cVar = new d.a.s0.u0.f2.a.c(getPageContext());
                this.mProfessionController = cVar;
                cVar.j(new q(this));
            }
            SubPbModel subPbModel2 = this.mSubPbModel;
            if (subPbModel2 == null || subPbModel2.X() == null || this.mSubPbModel.X().d() == null) {
                return;
            }
            this.mProfessionController.h(this.mSubPbModel.X().d().getId(), d.a.c.e.m.b.f(this.mSubPbModel.k0(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDelNoSubPostDialog(SparseArray<Object> sparseArray, int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65622, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            d.a.s0.h2.k.e.f1.a.d(this, getPageContext(), new i(this, sparseArray, i2, z2), new j(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDeleteResumeEditorTips(View view, d.a.r0.w.w.h hVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65623, this, view, hVar, str) == null) {
            new WriteTipBubbleController(getPageContext(), new c(this, view, hVar)).d(view, getString(R.string.open_editor_tips), str, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_PB_REPLY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showOpenMemberReplyDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65624, this) == null) {
            d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(getPageContext().getPageActivity());
            aVar.setMessage(getResources().getString(R.string.mute_is_super_member_function));
            aVar.setPositiveButton(R.string.open_now, new e0(this));
            aVar.setNegativeButton(R.string.cancel, new f0(this));
            aVar.create(this.mCtx).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showOperateDialog(boolean z2, SparseArray<Object> sparseArray) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65625, this, z2, sparseArray) == null) {
            String str = sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_mute_userid) : "";
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                String[] strArr = new String[1];
                if (z2) {
                    string = getResources().getString(R.string.un_mute);
                } else {
                    string = getResources().getString(R.string.mute);
                }
                strArr[0] = string;
                d.a.r0.r.s.b bVar = new d.a.r0.r.s.b(getPageContext().getPageActivity());
                bVar.k(R.string.operation);
                bVar.j(strArr, new s(this, sparseArray, z2, str));
                bVar.c(getPageContext());
                bVar.m();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showUserMuteAddDialog(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65626, this, str) == null) {
            if (str == null) {
                str = "";
            }
            d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(this.mCtx.getPageActivity());
            aVar.setMessage(str);
            aVar.setNegativeButton(R.string.know, new d0(this));
            aVar.create(this.mCtx).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showUserMuteDialog(boolean z2, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65627, this, new Object[]{Boolean.valueOf(z2), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z2) {
                this.mSubPbView.A0();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(this.mCtx.getPageActivity());
            if (d.a.c.e.p.k.isEmpty(str)) {
                aVar.setMessage(this.mCtx.getResources().getString(R.string.block_mute_message_alert, str3));
            } else {
                aVar.setMessage(str);
            }
            aVar.setPositiveButton(R.string.confirm, new b0(this, userMuteAddAndDelCustomMessage));
            aVar.setNegativeButton(R.string.cancel, new c0(this));
            aVar.create(this.mCtx).show();
        }
    }

    private void startBrowsePageMission() {
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65628, this) == null) || (subPbModel = this.mSubPbModel) == null || d.a.c.e.p.k.isEmpty(subPbModel.k0())) {
            return;
        }
        d.a.r0.a.d.y().P(d.a.r0.a.c.W, d.a.c.e.m.b.f(this.mSubPbModel.k0(), 0L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText validImage(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65629, this, str, i2)) == null) {
            SubPbModel subPbModel = this.mSubPbModel;
            if (subPbModel == null || subPbModel.X() == null || str == null || i2 < 0) {
                return null;
            }
            d.a.s0.h2.h.r X = this.mSubPbModel.X();
            TbRichText image = getImage(X.i(), str, i2);
            if (image != null || (image = getImage(X.i(), str, i2)) != null) {
            }
            return image;
        }
        return (TbRichText) invokeLI.objValue;
    }

    public void checkContentSensitiveWord(boolean z2) {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z2) == null) || (editText = this.mSubFloorEditText) == null || editText.getText() == null) {
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
            d.a.s0.a4.c cVar = this.mSensitiveProcessController;
            cVar.k(cVar.b() >= 0);
        }
    }

    public void checkMuteState(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sparseArray) == null) {
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
    }

    public void checkShowKeyboard() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
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
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.mIsFromPb && !this.mIsFromSchema) {
                ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            } else {
                super.closeAnimation();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.mIsFromPb && !this.mIsFromSchema) {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            } else {
                super.enterExitAnimation();
            }
        }
    }

    public void finishDelPost(ForumManageModel.b bVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048581, this, bVar, z2) == null) || bVar == null) {
            return;
        }
        int i2 = 0;
        this.mSubPbView.z(0, bVar.f21133a, bVar.f21134b, z2);
        if (bVar.f21133a) {
            int i3 = bVar.f21136d;
            if (i3 == 1) {
                if (this.mSubPbView.G() instanceof BdTypeListView) {
                    List<d.a.c.k.e.n> data = ((BdTypeListView) this.mSubPbView.G()).getData();
                    if (!ListUtils.isEmpty(data)) {
                        while (i2 < data.size() && (!(data.get(i2) instanceof PostData) || !bVar.f21139g.equals(((PostData) data.get(i2)).E()))) {
                            i2++;
                        }
                        if (i2 < data.size()) {
                            data.remove(i2);
                        }
                        this.mSubPbView.a0();
                    }
                }
            } else if (i3 == 2) {
                this.mSubPbModel.U(bVar.f21139g);
                this.mSubPbView.H0(this.mSubPbModel.X(), this.mSubPbModel.o0(), this.mSubPbModel.n0() != null, false);
                if (this.mSubPbModel.w0()) {
                    this.mSubPbModel.J0(false);
                    this.mSubPbView.s();
                    this.mSubPbModel.z0();
                }
            }
            d.a.s0.h2.e eVar = new d.a.s0.h2.e();
            eVar.c(bVar);
            eVar.d(1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, eVar));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, d.a.r0.k0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "a007" : (String) invokeV.objValue;
    }

    @Override // d.a.s0.h2.k.a
    public d.a.s0.h2.k.e.c1.a getEventController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mEvent : (d.a.s0.h2.k.e.c1.a) invokeV.objValue;
    }

    @Override // d.a.s0.h2.k.a
    public String getFromForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            SubPbModel subPbModel = this.mSubPbModel;
            if (subPbModel == null || subPbModel.X() == null || this.mSubPbModel.X().l() == null) {
                return null;
            }
            return this.mSubPbModel.X().l().W();
        }
        return (String) invokeV.objValue;
    }

    @Override // d.a.r0.b1.m.h
    public d.a.c.e.k.b<GifView> getGifViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.mGifViewPool == null) {
                this.mGifViewPool = new d.a.c.e.k.b<>(new u(this), 20, 0);
            }
            return this.mGifViewPool;
        }
        return (d.a.c.e.k.b) invokeV.objValue;
    }

    @Override // d.a.r0.b1.m.h
    public d.a.c.e.k.b<ImageView> getImageViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.mImageViewPool == null) {
                this.mImageViewPool = new d.a.c.e.k.b<>(new w(this), 8, 0);
            }
            return this.mImageViewPool;
        }
        return (d.a.c.e.k.b) invokeV.objValue;
    }

    @Override // d.a.r0.b1.m.h
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            d.a.s0.h2.k.g.a aVar = this.mSubPbView;
            if (aVar != null) {
                return aVar.G();
            }
            return null;
        }
        return (ListView) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            SubPbModel subPbModel = this.mSubPbModel;
            if (subPbModel == null || d.a.c.e.p.k.isEmpty(subPbModel.k0())) {
                return 0L;
            }
            return d.a.c.e.m.b.f(this.mSubPbModel.k0(), 0L);
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public d.a.r0.k0.d getPageStayDurationItem() {
        InterceptResult invokeV;
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            d.a.r0.k0.d pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null && (subPbModel = this.mSubPbModel) != null) {
                if (subPbModel.X() != null && this.mSubPbModel.X().d() != null) {
                    pageStayDurationItem.q(d.a.c.e.m.b.f(this.mSubPbModel.X().d().getId(), 0L));
                }
                pageStayDurationItem.y(d.a.c.e.m.b.f(this.mSubPbModel.k0(), 0L));
                if (this.mSubPbModel.X() != null && this.mSubPbModel.X().l() != null) {
                    pageStayDurationItem.r(this.mSubPbModel.X().l().A0());
                }
                pageStayDurationItem.t(d.a.c.e.m.b.f(this.mSubPbModel.w(), 0L));
            }
            return pageStayDurationItem;
        }
        return (d.a.r0.k0.d) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, d.a.r0.k0.a
    public d.a.r0.k0.b getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? new a0(this) : (d.a.r0.k0.b) invokeV.objValue;
    }

    public String getPostId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            SubPbModel subPbModel = this.mSubPbModel;
            if (subPbModel != null) {
                return subPbModel.w();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        InterceptResult invokeL;
        View findViewWithTag;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, voiceData$VoiceModel)) == null) {
            View E = this.mSubPbView.E();
            if (E == null || (findViewWithTag = E.findViewWithTag(voiceData$VoiceModel)) == null) {
                return null;
            }
            return (VoiceManager.i) findViewWithTag;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // d.a.r0.b1.m.h
    public d.a.c.e.k.b<RelativeLayout> getRelativeLayoutPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            d.a.c.e.k.b<RelativeLayout> bVar = new d.a.c.e.k.b<>(new z(this), 10, 0);
            this.mMemeViewPool = bVar;
            return bVar;
        }
        return (d.a.c.e.k.b) invokeV.objValue;
    }

    public String getReplyHint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (!d.a.c.e.p.k.isEmpty(this.mReplyHintText)) {
                return this.mReplyHintText;
            }
            String string = getResources().getString(r0.b());
            this.mReplyHintText = string;
            return string;
        }
        return (String) invokeV.objValue;
    }

    @Override // d.a.r0.b1.m.h
    public int getRichTextViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public SubPbModel getSubPbModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mSubPbModel : (SubPbModel) invokeV.objValue;
    }

    @Override // d.a.r0.b1.m.h
    public d.a.c.e.k.b<TextView> getTextViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.mTextViewPool == null) {
                this.mTextViewPool = TbRichTextView.y(getPageContext().getPageActivity(), 8);
            }
            return this.mTextViewPool;
        }
        return (d.a.c.e.k.b) invokeV.objValue;
    }

    @Override // d.a.r0.b1.m.h
    public d.a.c.e.k.b<LinearLayout> getTextVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.mTextVoiceViewPool == null) {
                this.mTextVoiceViewPool = new d.a.c.e.k.b<>(new y(this), 15, 0);
            }
            return this.mTextVoiceViewPool;
        }
        return (d.a.c.e.k.b) invokeV.objValue;
    }

    public String getThreadId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            SubPbModel subPbModel = this.mSubPbModel;
            if (subPbModel != null) {
                return subPbModel.k0();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // d.a.s0.h2.k.a
    public int getUserIdentify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            SubPbModel subPbModel = this.mSubPbModel;
            if (subPbModel == null) {
                return 0;
            }
            return subPbModel.o0();
        }
        return invokeV.intValue;
    }

    public int getUserIdentity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            SubPbModel subPbModel = this.mSubPbModel;
            if (subPbModel != null) {
                return subPbModel.o0();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.mVoiceManager : (VoiceManager) invokeV.objValue;
    }

    @Override // d.a.r0.b1.m.h
    public d.a.c.e.k.b<View> getVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            if (this.mVoiceViewPool == null) {
                this.mVoiceViewPool = new d.a.c.e.k.b<>(new x(this), 8, 0);
            }
            return this.mVoiceViewPool;
        }
        return (d.a.c.e.k.b) invokeV.objValue;
    }

    public void handleMuteClick(boolean z2, String str, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{Boolean.valueOf(z2), str, sparseArray}) == null) {
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
    }

    public void handleReportClicked(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            SubPbModel subPbModel = this.mSubPbModel;
            if (subPbModel != null && subPbModel.X() != null && this.mSubPbModel.X().l() != null && this.mSubPbModel.X().l().I1()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.mSubPbModel.k0(), str);
                b2 l2 = this.mSubPbModel.X().l();
                if (l2.E1()) {
                    format = format + "&channelid=33833";
                } else if (l2.J1()) {
                    format = format + "&channelid=33842";
                } else if (l2.H1()) {
                    format = format + "&channelid=33840";
                }
                jumpToWeb(format);
                return;
            }
            this.mUEGReportController.i(str);
        }
    }

    public void initCallBacks() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.mSubPbCallBack = new d(this);
            this.mMarkDoneCallBack = new e(this);
            this.forbidUserCallback = new f(this);
            this.deleteReplayCallback = new g(this);
            this.mPostManageCallBack = new h(this);
        }
    }

    public void initData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, bundle) == null) {
            SubPbModel subPbModel = new SubPbModel(getPageContext());
            this.mSubPbModel = subPbModel;
            subPbModel.I0(new b(this));
            ForumManageModel forumManageModel = new ForumManageModel(getPageContext());
            this.mPostManageModel = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.mPostManageCallBack);
            VoiceManager voiceManager = new VoiceManager();
            this.mVoiceManager = voiceManager;
            voiceManager.onCreate(getPageContext());
            d.a.r0.h.a b2 = d.a.r0.h.a.b(this);
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
    }

    public void initListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            registerListener(this.updatePendantMessageListener);
            this.mCommonClickListener = new l(this);
            this.mSubPbScrollListener = new m(this);
            this.mOnLongClickListener = new n(this);
            this.mImageClickListener = new o(this);
        }
    }

    public void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            d.a.s0.h2.k.g.a aVar = new d.a.s0.h2.k.g.a(this, this.mCommonClickListener);
            this.mSubPbView = aVar;
            aVar.q0(this.mSubPbModel);
            setContentView(this.mSubPbView.P(), new FrameLayout.LayoutParams(-1, -1));
            this.mSubPbView.u0(this.mSubPbScrollListener);
            this.mSubPbView.v0(this);
            this.mSubPbView.r0(this.mImageClickListener);
            this.mSubPbView.s0(this.mOnLongClickListener);
            this.mSubPbView.t0(new a(this));
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
    }

    public boolean isFromPb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            SubPbModel subPbModel = this.mSubPbModel;
            if (subPbModel != null) {
                return subPbModel.t0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isH5GameLink(String str) {
        InterceptResult invokeL;
        Map<String, String> paramPair;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) {
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
        return invokeL.booleanValue;
    }

    @Override // d.a.s0.h2.k.a
    public boolean isHost(String str) {
        InterceptResult invokeL;
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, str)) == null) {
            if (StringUtils.isNull(str) || (subPbModel = this.mSubPbModel) == null || subPbModel.X() == null || this.mSubPbModel.X().l() == null || this.mSubPbModel.X().l().H() == null) {
                return false;
            }
            return str.equals(this.mSubPbModel.X().l().H().getUserId());
        }
        return invokeL.booleanValue;
    }

    public boolean isImage(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, view)) == null) ? (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView) : invokeL.booleanValue;
    }

    public boolean isPaused() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.mIsPaused : invokeV.booleanValue;
    }

    @Override // d.a.s0.h2.k.a
    public boolean isSimpleForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            SubPbModel subPbModel = this.mSubPbModel;
            if (subPbModel == null || subPbModel.X() == null || this.mSubPbModel.X().l() == null) {
                return false;
            }
            return !this.mSubPbModel.X().l().b2();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048617, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i2 == 25035) {
                handleFullScreenEditorResult(i3, intent);
            }
            d.a.r0.w.w.h hVar = this.mEditor;
            if (hVar != null) {
                hVar.A(i2, i3, intent);
            }
        }
    }

    @Override // d.a.r0.b1.m.h
    public void onAtClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048618, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.mIsRichTextListenerAcked = true;
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            d.a.r0.w.w.h hVar = this.mEditor;
            if (hVar != null && hVar.a() != null && this.mEditor.a().u()) {
                this.mEditor.a().q();
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mSubPbView.e0(i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, bundle) == null) {
            initIsFromPb(bundle);
            if (getIntent() != null) {
                this.mIsFromSchema = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_FROM_SCHEMA, false);
            }
            super.onCreate(bundle);
            this.mCtx = getPageContext();
            this.isFirstLoadData = true;
            d.a.s0.a4.c cVar = new d.a.s0.a4.c();
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
            d.a.r0.r.f0.c cVar2 = new d.a.r0.r.f0.c();
            this.mToastMute = cVar2;
            cVar2.f55627a = 1000L;
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
            replyPrivacyCheckController.setAttentionCallback(new p0(this));
            d.a.s0.h2.k.f.a aVar = new d.a.s0.h2.k.f.a(this);
            this.mUEGReportController = aVar;
            aVar.a(getUniqueId());
            this.mEvent = new d.a.s0.h2.k.e.c1.a(this);
            this.mUserBlockController = new d.a.s0.r3.b(getPageContext(), getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
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
            d.a.s0.r3.b bVar = this.mUserBlockController;
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
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z2) == null) {
            super.onKeyboardVisibilityChanged(z2);
            this.mIsSoftKeyBoardVisible = z2;
            fixReplyFloorViewHolderPosition(true);
        }
    }

    @Override // d.a.r0.b1.m.h
    public void onLinkButtonClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048624, this, context, str) == null) {
        }
    }

    @Override // d.a.r0.b1.m.h
    public void onLinkClicked(Context context, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048625, this, context, str, z2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (isH5GameLink(str)) {
            MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
            return;
        }
        if (z2) {
            if (!TextUtils.isEmpty(str)) {
                d.a.r0.t.m mVar = new d.a.r0.t.m();
                mVar.f56722a = str;
                mVar.f56723b = 3;
                mVar.f56724c = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, mVar));
            }
        } else {
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str});
        }
        this.mIsRichTextListenerAcked = true;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            this.mIsPaused = true;
            super.onPause();
            d.a.r0.a.d.y().E();
            VoiceManager voiceManager = this.mVoiceManager;
            if (voiceManager != null) {
                voiceManager.onPause(getPageContext());
            }
            MessageManager.getInstance().unRegisterListener(this.richTextIntentClickListener);
            this.mSubPbView.c0();
        }
    }

    @Override // d.a.r0.b1.m.h
    public void onPhoneClicked(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048627, this, context, str, str2) == null) {
        }
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z2) == null) {
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, d.a.c.a.i
    public void onPreLoad(d.a.c.k.e.q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, qVar) == null) {
            PreLoadImageHelper.load(qVar, getUniqueId(), 3);
            PreLoadVideoHelper.load(qVar, getUniqueId(), this);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
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
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (bundle == null || (subPbModel = this.mSubPbModel) == null) {
                return;
            }
            subPbModel.H0(bundle);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            if (this.mSubPbView.I0() && d.a.c.e.p.l.D()) {
                this.mSubPbModel.z0();
            } else {
                this.mSubPbView.l0();
            }
        }
    }

    @Override // d.a.r0.b1.m.h
    public void onSongClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048633, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            super.onStart();
            VoiceManager voiceManager = this.mVoiceManager;
            if (voiceManager != null) {
                voiceManager.onStart(getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            super.onStop();
            VoiceManager voiceManager = this.mVoiceManager;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            this.mEditor.C();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048636, this, z2) == null) {
            super.onUserChanged(z2);
            d.a.s0.h2.k.e.d0 d0Var = this.mPostMoreOptionView;
            if (d0Var != null) {
                d0Var.n(z2);
            }
            d.a.s0.h2.k.g.a aVar = this.mSubPbView;
            if (aVar != null) {
                aVar.t(z2);
            }
        }
    }

    @Override // d.a.r0.b1.m.h
    public void onVideoClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048637, this, context, str) == null) {
        }
    }

    @Override // d.a.r0.b1.m.h
    public void onVideoP2PClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048638, this, context, str) == null) {
        }
    }

    public void stopVoice() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048639, this) == null) || (voiceManager = this.mVoiceManager) == null) {
            return;
        }
        voiceManager.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openEditor(PostData postData, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65620, this, postData, z2) == null) || checkIsIfPostForbid()) {
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
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048616, this, postData) == null) || postData == null) {
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
        d.a.r0.h.a aVar = this.mMarkModel;
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
