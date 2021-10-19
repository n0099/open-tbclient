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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.c0.d;
import c.a.q0.f1.m.f;
import c.a.q0.i.a;
import c.a.q0.s.f0.f;
import c.a.q0.s.q.d2;
import c.a.q0.s.s.a;
import c.a.q0.s.s.b;
import c.a.r0.k2.k.e.w0;
import c.a.r0.x0.g2.a.c;
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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.resourceLoaderProc.BigImageLoaderProc;
import com.baidu.tbadk.core.util.videoPreload.PreLoadVideoHelper;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.UserPendantData;
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
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tbadk.widget.tiejia.TiePlusStat;
import com.baidu.tbadk.widget.tiejia.TiebaPlusRecommendCard;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pb.pb.main.PbMoreDialog;
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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes7.dex */
public class NewSubPbActivity extends BaseActivity<NewSubPbActivity> implements VoiceManager.j, c.a.q0.f1.m.i, BdListView.p, c.a.r0.k2.k.a<NewSubPbActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static String TB_GAME_TYPE = "tbgametype";
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId MESSAGE_ID_NEWSUB_PB;
    public r0 deleteReplayCallback;
    public r0 forbidUserCallback;
    public boolean hasRemindedEditorTips;
    public int imgIndex;
    public boolean index_valid;
    public boolean isFirstLoadData;
    public boolean isFromVideoMiddle;
    public int lastScrollState;
    public c.a.q0.x.x.b mCheckPostCallBack;
    public View.OnClickListener mCommonClickListener;
    public c.a.e.a.f mCtx;
    public c.a.q0.x.x.h mEditor;
    public TbRichTextMemeInfo mEmotionInfo;
    public c.a.r0.k2.k.e.c1.a mEvent;
    public Object mExtra;
    public int mFromVideoTab;
    public c.a.e.e.k.b<GifView> mGifViewPool;
    public TbRichTextView.z mImageClickListener;
    public c.a.e.e.k.b<ImageView> mImageViewPool;
    public boolean mIsFromCDN;
    public boolean mIsFromPb;
    public boolean mIsFromSchema;
    public boolean mIsFromVideoTAb;
    public boolean mIsPaused;
    public boolean mIsRichTextListenerAcked;
    public boolean mIsSoftKeyBoardVisible;
    public PbCommenFloorItemViewHolder mItemClickShowSoftKeyBoardViewHolder;
    public a.InterfaceC0669a mMarkDoneCallBack;
    public c.a.q0.i.a mMarkModel;
    public c.a.e.e.k.b<RelativeLayout> mMemeViewPool;
    public c.a.q0.s.b0.a mMessageHelper;
    public c.a.r0.k3.i0.e mMsgData;
    public final b.c mOnImageSaveClickListener;
    public View.OnLongClickListener mOnLongClickListener;
    public NewWriteModel.g mOnPostWriteNewCallback;
    public final f.g mOnPullRefreshListener;
    public BdUniqueId mOnlyDisagreeId;
    public PermissionJudgePolicy mPermissionJudgement;
    public c.a.e.a.e mPostManageCallBack;
    public ForumManageModel mPostManageModel;
    public PbMoreDialog mPostMoreOptionView;
    public PostWriteCallBackData mPostWriteCallBackData;
    public c.a.q0.x.x.c mPrePostCallBack;
    public c.a.r0.x0.g2.a.c mProfessionController;
    public c.a.r0.k2.e<c.a.r0.k2.h.r> mRefreshData;
    public String mReplyHintText;
    public ReplyPrivacyCheckController mReplyPrivacyController;
    public c.a.e.l.d.a mSaveBdImage;
    public w0 mSaveImageHelper;
    public String mSaveImageUrl;
    public c.a.r0.d4.c mSensitiveProcessController;
    public EditText mSubFloorEditText;
    public SubPbModel.b mSubPbCallBack;
    public SubPbModel mSubPbModel;
    public AbsListView.OnScrollListener mSubPbScrollListener;
    public c.a.r0.k2.k.g.a mSubPbView;
    public c.a.e.e.k.b<TextView> mTextViewPool;
    public c.a.e.e.k.b<LinearLayout> mTextVoiceViewPool;
    public c.a.q0.s.f0.c mToastMute;
    public c.a.r0.k2.k.f.a mUEGReportController;
    public c.a.r0.u3.b mUserBlockController;
    public CustomMessageListener mUserMuteAddListener;
    public CustomMessageListener mUserMuteCheckListener;
    public CustomMessageListener mUserMuteDelListener;
    public BdUniqueId mVideoPageUniqueId;
    public VoiceManager mVoiceManager;
    public c.a.e.e.k.b<View> mVoiceViewPool;
    public boolean needOpenEditor;
    public PostData postData;
    @NonNull
    public TiePlusEventController.d richTextEventAckedCallback;
    public CustomMessageListener richTextIntentClickListener;
    public boolean showTrisectionAndFeedback;
    public CustomMessageListener subpbReplyListener;
    @Nullable
    public TiePlusEventController tiePlusEventController;
    public CustomMessageListener updatePendantMessageListener;

    /* loaded from: classes7.dex */
    public class a implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f55403a;

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
            this.f55403a = newSubPbActivity;
        }

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && z) {
                this.f55403a.mEditor.G();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a0 implements c.a.e.e.k.c<RelativeLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f55404a;

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
            this.f55404a = newSubPbActivity;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
        public /* bridge */ /* synthetic */ RelativeLayout a(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            e(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
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
        @Override // c.a.e.e.k.c
        /* renamed from: f */
        public void b(RelativeLayout relativeLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, relativeLayout) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.k.c
        /* renamed from: g */
        public RelativeLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new RelativeLayout(this.f55404a.getPageContext().getPageActivity()) : (RelativeLayout) invokeV.objValue;
        }

        public RelativeLayout h(RelativeLayout relativeLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, relativeLayout)) == null) ? relativeLayout : (RelativeLayout) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f55405e;

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
            this.f55405e = newSubPbActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f55405e.mSubPbModel == null) {
                return;
            }
            this.f55405e.mSubPbModel.loadData();
        }
    }

    /* loaded from: classes7.dex */
    public class b0 extends c.a.q0.o0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f55406a;

        public b0(NewSubPbActivity newSubPbActivity) {
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
            this.f55406a = newSubPbActivity;
        }

        @Override // c.a.q0.o0.b
        public int getMaxCost() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c.a.q0.o0.e.b().c() : invokeV.intValue;
        }

        @Override // c.a.q0.o0.b
        public boolean isCurrentPageCanBeAddToSourceTrace() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements PbFakeFloorModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f55407a;

        public c(NewSubPbActivity newSubPbActivity) {
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
            this.f55407a = newSubPbActivity;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, postData) == null) {
                this.f55407a.mSubPbView.z0(postData);
                this.f55407a.mSubPbView.v0(null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserMuteAddAndDelCustomMessage f55408e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f55409f;

        public c0(NewSubPbActivity newSubPbActivity, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
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
            this.f55409f = newSubPbActivity;
            this.f55408e = userMuteAddAndDelCustomMessage;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f55409f.mSubPbView.A0();
                MessageManager.getInstance().sendMessage(this.f55408e);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements WriteTipBubbleController.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f55410a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.x.x.h f55411b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f55412c;

        public d(NewSubPbActivity newSubPbActivity, View view, c.a.q0.x.x.h hVar) {
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
            this.f55412c = newSubPbActivity;
            this.f55410a = view;
            this.f55411b = hVar;
        }

        @Override // com.baidu.tbadk.core.dialog.WriteTipBubbleController.b
        public void a(View view, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, str) == null) {
                this.f55410a.performClick();
                this.f55411b.q();
                this.f55411b.u().i().setText(str);
                Editable text = this.f55411b.u().i().getText();
                if (TextUtils.isEmpty(text)) {
                    return;
                }
                this.f55411b.u().i().setSelection(text.length());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f55413e;

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
            this.f55413e = newSubPbActivity;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements SubPbModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f55414a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.k2.h.r f55415e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ e f55416f;

            public a(e eVar, c.a.r0.k2.h.r rVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, rVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f55416f = eVar;
                this.f55415e = rVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f55416f.f55414a.needOpenEditor = false;
                    this.f55416f.f55414a.openEditor(this.f55415e.i(), false);
                }
            }
        }

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
            this.f55414a = newSubPbActivity;
        }

        @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.b
        public void a(boolean z, int i2, String str, c.a.r0.k2.h.r rVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), str, rVar}) == null) || this.f55414a.mSubPbView == null) {
                return;
            }
            this.f55414a.mSubPbView.l0();
            if (!z) {
                this.f55414a.onNetOrDataError(i2, str);
                return;
            }
            this.f55414a.mSubPbView.S();
            if (rVar != null) {
                if (rVar.i() != null || this.f55414a.mSubPbModel != null) {
                    rVar.i().x0(this.f55414a.mSubPbModel.w0());
                }
                if (this.f55414a.mSubPbView != null) {
                    this.f55414a.initEditor(rVar.l() != null && rVar.l().Q1());
                    if (this.f55414a.mEditor != null && this.f55414a.mEditor.a() != null) {
                        this.f55414a.mEditor.a().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                    }
                    this.f55414a.mSubPbView.H0(rVar, this.f55414a.mSubPbModel.B0(), this.f55414a.mSubPbModel.A0() != null, this.f55414a.isFirstLoadData);
                    if (this.f55414a.isFirstLoadData) {
                        this.f55414a.mSubPbView.G().setSelectionFromTop(this.f55414a.mSubPbView.G().getHeaderViewsCount() + 1, -c.a.e.e.p.l.g(this.f55414a, R.dimen.tbds18));
                        this.f55414a.checkShowKeyboard();
                        this.f55414a.isFirstLoadData = false;
                    }
                }
                if (this.f55414a.mEditor != null) {
                    this.f55414a.mEditor.H(rVar.a());
                    this.f55414a.mEditor.c0(rVar.l());
                    if (this.f55414a.getIntent() != null && this.f55414a.getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_OPEN_EDITOR, false) && this.f55414a.needOpenEditor) {
                        c.a.e.e.m.e.a().postDelayed(new a(this, rVar), 200L);
                    }
                }
                if (this.f55414a.mRefreshData == null) {
                    this.f55414a.mRefreshData = new c.a.r0.k2.e();
                }
                this.f55414a.mRefreshData.c(rVar);
                this.f55414a.mRefreshData.d(0);
                NewSubPbActivity newSubPbActivity = this.f55414a;
                newSubPbActivity.mReplyPrivacyController.setLikeUserData(newSubPbActivity.mSubPbModel.i0());
            }
            String stringExtra = this.f55414a.getIntent().getStringExtra("key_open_editor_tips");
            if (TextUtils.isEmpty(stringExtra) || this.f55414a.hasRemindedEditorTips) {
                return;
            }
            this.f55414a.hasRemindedEditorTips = true;
            NewSubPbActivity newSubPbActivity2 = this.f55414a;
            newSubPbActivity2.showDeleteResumeEditorTips(newSubPbActivity2.mSubPbView.N(), this.f55414a.mEditor, stringExtra);
        }
    }

    /* loaded from: classes7.dex */
    public class e0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f55417e;

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
            this.f55417e = newSubPbActivity;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements a.InterfaceC0669a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f55418a;

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
            this.f55418a = newSubPbActivity;
        }

        @Override // c.a.q0.i.a.InterfaceC0669a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                if (z) {
                    if (this.f55418a.mMarkModel != null) {
                        this.f55418a.mMarkModel.h(z2);
                    }
                    MarkData f2 = this.f55418a.mMarkModel.f();
                    c.a.r0.k2.e eVar = new c.a.r0.k2.e();
                    eVar.d(2);
                    if (z2) {
                        eVar.c(f2);
                        if (this.f55418a.mMarkModel != null) {
                            if (f2 != null) {
                                this.f55418a.mSubPbModel.Y0(true);
                                this.f55418a.mSubPbModel.Z0(this.f55418a.mSubPbModel.y());
                                this.f55418a.showToast(R.string.add_mark_on_pb);
                            } else {
                                NewSubPbActivity newSubPbActivity = this.f55418a;
                                newSubPbActivity.showToast(newSubPbActivity.getPageContext().getString(R.string.add_mark));
                            }
                            if (this.f55418a.mSubPbView != null) {
                                this.f55418a.mSubPbView.L0(true);
                            }
                        }
                    } else {
                        eVar.c(null);
                        this.f55418a.mSubPbModel.Y0(false);
                        this.f55418a.mSubPbModel.Z0(null);
                        NewSubPbActivity newSubPbActivity2 = this.f55418a;
                        newSubPbActivity2.showToast(newSubPbActivity2.getPageContext().getString(R.string.remove_mark));
                        if (this.f55418a.mSubPbView != null) {
                            this.f55418a.mSubPbView.L0(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, eVar));
                    return;
                }
                NewSubPbActivity newSubPbActivity3 = this.f55418a;
                newSubPbActivity3.showToast(newSubPbActivity3.getPageContext().getString(R.string.update_mark_failed));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f55419e;

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
            this.f55419e = newSubPbActivity;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar.dismiss();
                    ((TbPageContext) this.f55419e.mCtx).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.f55419e.mCtx.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements r0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f55420a;

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
            this.f55420a = newSubPbActivity;
        }

        @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.r0
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                Object[] objArr = (Object[]) obj;
                String valueOf = (this.f55420a.mSubPbModel.j0() == null || this.f55420a.mSubPbModel.j0().l() == null || this.f55420a.mSubPbModel.j0().l().J() == null) ? "" : String.valueOf(this.f55420a.mSubPbModel.j0().l().J().getUserId());
                String valueOf2 = objArr.length > 1 ? String.valueOf(objArr[1]) : "";
                String valueOf3 = objArr.length > 2 ? String.valueOf(objArr[2]) : "";
                this.f55420a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.f55420a.getPageContext().getPageActivity(), this.f55420a.mSubPbModel.j0().d().getId(), this.f55420a.mSubPbModel.j0().d().getName(), this.f55420a.mSubPbModel.j0().l().f0(), valueOf, valueOf2, objArr.length > 3 ? String.valueOf(objArr[3]) : "", valueOf3, objArr.length > 4 ? String.valueOf(objArr[4]) : "")));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g0 implements c.a.q0.x.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f55421a;

        public g0(NewSubPbActivity newSubPbActivity) {
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
            this.f55421a = newSubPbActivity;
        }

        @Override // c.a.q0.x.x.b
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f55421a.mSensitiveProcessController.d()) {
                    NewSubPbActivity newSubPbActivity = this.f55421a;
                    newSubPbActivity.showToast(newSubPbActivity.mSensitiveProcessController.c());
                    if (this.f55421a.mEditor.y()) {
                        this.f55421a.mEditor.w(this.f55421a.mPostWriteCallBackData);
                    }
                    this.f55421a.checkContentSensitiveWord(true);
                    return true;
                }
                NewSubPbActivity newSubPbActivity2 = this.f55421a;
                if (newSubPbActivity2.mReplyPrivacyController == null || newSubPbActivity2.mSubPbModel == null || this.f55421a.mSubPbModel.h0() == null || this.f55421a.isHost(TbadkCoreApplication.getCurrentAccount())) {
                    return false;
                }
                NewSubPbActivity newSubPbActivity3 = this.f55421a;
                return !newSubPbActivity3.mReplyPrivacyController.checkPrivacyBeforeSend(newSubPbActivity3.mSubPbModel.h0().replyPrivateFlag, ReplyPrivacyCheckController.TYPE_FLOOR);
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class h implements r0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f55422a;

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
            this.f55422a = newSubPbActivity;
        }

        @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.r0
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (this.f55422a.mPostManageModel.P() || objArr == null || objArr.length < 4) {
                        return;
                    }
                    String valueOf = String.valueOf(objArr[0]);
                    int e2 = c.a.e.e.m.b.e(String.valueOf(objArr[1]), 0);
                    boolean b2 = c.a.e.e.m.b.b(String.valueOf(objArr[2]), false);
                    int e3 = c.a.e.e.m.b.e(String.valueOf(objArr[3]), 0);
                    if (this.f55422a.mSubPbModel == null || this.f55422a.mSubPbModel.j0() == null || this.f55422a.mSubPbModel.j0().d() == null || this.f55422a.mSubPbModel.j0().l() == null) {
                        return;
                    }
                    if (objArr.length > 4) {
                        this.f55422a.mPostManageModel.R(String.valueOf(objArr[4]));
                    }
                    this.f55422a.mPostManageModel.S(this.f55422a.mSubPbModel.j0().d().getId(), this.f55422a.mSubPbModel.j0().d().getName(), this.f55422a.mSubPbModel.j0().l().f0(), valueOf, e3, e2, b2, this.f55422a.mSubPbModel.j0().l().L(), false);
                    return;
                }
                TbadkCoreApplication.getInst().login(this.f55422a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f55422a.getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f55423e;

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
            this.f55423e = newSubPbActivity;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i extends c.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f55424a;

        public i(NewSubPbActivity newSubPbActivity) {
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
            this.f55424a = newSubPbActivity;
        }

        @Override // c.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                boolean z = false;
                if (obj != null) {
                    int loadDataMode = this.f55424a.mPostManageModel.getLoadDataMode();
                    if (loadDataMode == 0) {
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        this.f55424a.finishDelPost(bVar, (bVar.f57180e != 1002 || bVar.f57181f) ? true : true);
                        return;
                    } else if (loadDataMode != 1) {
                        return;
                    } else {
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        this.f55424a.mSubPbView.z(1, dVar.f57184a, dVar.f57185b, true);
                        return;
                    }
                }
                this.f55424a.mSubPbView.z(this.f55424a.mPostManageModel.getLoadDataMode(), false, null, false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f55425a;

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
            this.f55425a = newSubPbActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserPendantData)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (StringUtils.isNull(currentAccount)) {
                    return;
                }
                UserPendantData userPendantData = (UserPendantData) customResponsedMessage.getData();
                if (this.f55425a.mSubPbModel.j0() == null || this.f55425a.mSubPbModel.j0().i() == null || this.f55425a.mSubPbModel.j0().i().t() == null || !currentAccount.equals(this.f55425a.mSubPbModel.j0().i().t().getUserId()) || this.f55425a.mSubPbModel.j0().i().t().getPendantData() == null) {
                    return;
                }
                this.f55425a.mSubPbModel.j0().i().t().getPendantData().setImgUrl(userPendantData.getImgUrl());
                this.f55425a.mSubPbModel.j0().i().t().getPendantData().setPropsId(userPendantData.getPropsId());
                this.f55425a.mSubPbView.y(this.f55425a.mSubPbModel.j0(), this.f55425a.mSubPbModel.j0().i(), this.f55425a.mSubPbModel.j0().e(), this.f55425a.mSubPbModel.j0().f(), this.f55425a.mSubPbModel.B0(), this.f55425a.mSubPbModel.A0() != null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SparseArray f55426e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f55427f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f55428g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f55429h;

        public j(NewSubPbActivity newSubPbActivity, SparseArray sparseArray, int i2, boolean z) {
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
            this.f55429h = newSubPbActivity;
            this.f55426e = sparseArray;
            this.f55427f = i2;
            this.f55428g = z;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (aVar != null) {
                    aVar.dismiss();
                }
                if (this.f55429h.deleteReplayCallback != null) {
                    this.f55429h.deleteReplayCallback.a(new Object[]{this.f55426e.get(R.id.tag_del_post_id), Integer.valueOf(this.f55427f), Boolean.valueOf(this.f55428g), this.f55426e.get(R.id.tag_del_post_type)});
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f55430e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f55431f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f55432g;

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
            this.f55432g = newSubPbActivity;
            this.f55430e = i2;
            this.f55431f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f55432g.mSubPbView == null || this.f55432g.mSubPbView.G() == null) {
                return;
            }
            this.f55432g.mSubPbView.G().setSelectionFromTop(this.f55430e, this.f55432g.mSubPbView.I() - this.f55431f);
        }
    }

    /* loaded from: classes7.dex */
    public class k implements c.a.q0.x.x.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f55433a;

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
            this.f55433a = newSubPbActivity;
        }

        @Override // c.a.q0.x.x.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f55433a.mSubPbView.x0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f55434e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f55435f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f55436g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f55437h;

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
            this.f55437h = newSubPbActivity;
            this.f55434e = i2;
            this.f55435f = i3;
            this.f55436g = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f55437h.mSubPbView == null || this.f55437h.mSubPbView.G() == null) {
                return;
            }
            this.f55437h.mSubPbView.G().setSelectionFromTop(this.f55434e, this.f55437h.mSubPbView.I() + (this.f55435f - this.f55436g));
        }
    }

    /* loaded from: classes7.dex */
    public class l implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f55438e;

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
            this.f55438e = newSubPbActivity;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f55439a;

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
            this.f55439a = newSubPbActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.f55439a.mSubPbModel != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && StringHelper.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), this.f55439a.mSubPbModel.x0())) {
                if (this.f55439a.mSensitiveProcessController != null) {
                    this.f55439a.mSensitiveProcessController.n(null);
                    this.f55439a.mSensitiveProcessController.i(null);
                    this.f55439a.mSensitiveProcessController.k(false);
                }
                if (this.f55439a.mEditor != null) {
                    this.f55439a.mEditor.q();
                    this.f55439a.mEditor.I();
                }
                this.f55439a.mSubPbModel.H();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f55440e;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.k2.k.e.c1.c f55441e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ PostData f55442f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ m f55443g;

            public a(m mVar, c.a.r0.k2.k.e.c1.c cVar, PostData postData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar, cVar, postData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f55443g = mVar;
                this.f55441e = cVar;
                this.f55442f = postData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.r0.k2.k.e.d dVar = new c.a.r0.k2.k.e.d(new c.a.q0.f1.m.a());
                    dVar.j(c.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
                    dVar.o(TbConfig.getPostLineSpace(), 1.0f);
                    this.f55441e.f20162b.a(null, this.f55443g.f55440e.mSubPbModel.j0().l(), this.f55442f, dVar);
                }
            }
        }

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
            this.f55440e = newSubPbActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            PostData postData;
            String b2;
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == null && this.f55440e.mSubPbView == null) {
                    return;
                }
                boolean z = true;
                boolean z2 = false;
                SparseArray<Object> sparseArray2 = null;
                if (view == this.f55440e.mSubPbView.F()) {
                    this.f55440e.mSubPbView.w();
                    String str2 = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                    String str3 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                    String str4 = view.getTag(R.id.tag_virtual_user_url) instanceof String ? (String) view.getTag(R.id.tag_virtual_user_url) : null;
                    if (str4 != null) {
                        if (this.f55440e.checkUpIsLogin()) {
                            UrlManager.getInstance().dealOneLink(this.f55440e.getPageContext(), new String[]{str4});
                        }
                    } else if (str2 != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f55440e.getPageContext().getPageActivity(), str2, str3, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                    }
                } else if (view != this.f55440e.mSubPbView.N()) {
                    if (view != this.f55440e.mSubPbView.K()) {
                        if (view == this.f55440e.mSubPbView.L()) {
                            if (this.f55440e.checkUpIsLogin()) {
                                this.f55440e.mSubPbView.K0();
                                this.f55440e.mSubPbView.u();
                                if (this.f55440e.mEditor != null) {
                                    this.f55440e.mEditor.h0();
                                }
                            }
                        } else if (view.getId() != R.id.pb_floor_feedback) {
                            if (view == this.f55440e.mSubPbView.H()) {
                                this.f55440e.mSubPbView.w();
                                if (this.f55440e.mSubPbModel.loadData()) {
                                    this.f55440e.mSubPbView.G0();
                                    return;
                                }
                                return;
                            }
                            str = "";
                            if (view == this.f55440e.mSubPbView.D() || view == this.f55440e.mSubPbView.C() || view == this.f55440e.mSubPbView.O()) {
                                if (this.f55440e.mIsRichTextListenerAcked) {
                                    this.f55440e.mIsRichTextListenerAcked = false;
                                    return;
                                }
                                if (this.f55440e.mSubPbModel.j0() != null && this.f55440e.mSubPbModel.j0().l() != null) {
                                    z2 = ThreadCardUtils.isUgcThreadType(this.f55440e.mSubPbModel.j0().l().L());
                                }
                                if (z2) {
                                    PbActivityConfig createNormalCfg = new PbActivityConfig(this.f55440e.getActivity()).createNormalCfg(this.f55440e.mSubPbModel.x0(), null, "");
                                    if (!StringUtils.isNull(this.f55440e.mSubPbModel.getFromForumId())) {
                                        createNormalCfg.setForumId(this.f55440e.mSubPbModel.getFromForumId());
                                    }
                                    if (this.f55440e.mSubPbModel.j0() != null && this.f55440e.mSubPbModel.j0().l() != null) {
                                        createNormalCfg.setBjhData(this.f55440e.mSubPbModel.j0().l().L());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                                    return;
                                }
                                PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.f55440e.getActivity()).createNormalCfg(this.f55440e.mSubPbModel.x0(), this.f55440e.mSubPbModel.y(), "");
                                if (!StringUtils.isNull(this.f55440e.mSubPbModel.getFromForumId())) {
                                    createNormalCfg2.setForumId(this.f55440e.mSubPbModel.getFromForumId());
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg2));
                            } else if (this.f55440e.mSubPbView.J() == null || view != this.f55440e.mSubPbView.J().getMarkTextView()) {
                                if (this.f55440e.mSubPbView.J() == null || view != this.f55440e.mSubPbView.J().getDeleteTextView()) {
                                    if (this.f55440e.mSubPbView.J() == null || view != this.f55440e.mSubPbView.J().getManageTextView()) {
                                        if (this.f55440e.mSubPbView.J() == null || view != this.f55440e.mSubPbView.J().getReportTextView()) {
                                            if (this.f55440e.mSubPbView.J() == null || view != this.f55440e.mSubPbView.J().getCopyTextView()) {
                                                if (view != this.f55440e.mSubPbView.E() && view != this.f55440e.mSubPbView.O()) {
                                                    if (view != null && (view.getTag() instanceof PbCommenFloorItemViewHolder)) {
                                                        this.f55440e.mItemClickShowSoftKeyBoardViewHolder = (PbCommenFloorItemViewHolder) view.getTag();
                                                        if (ViewHelper.checkUpIsLogin(this.f55440e.getPageContext().getPageActivity())) {
                                                            if (this.f55440e.mIsRichTextListenerAcked) {
                                                                this.f55440e.mIsRichTextListenerAcked = false;
                                                                return;
                                                            }
                                                            NewSubPbActivity newSubPbActivity = this.f55440e;
                                                            if (newSubPbActivity.mReplyPrivacyController != null && newSubPbActivity.mSubPbModel != null && this.f55440e.mSubPbModel.h0() != null && !this.f55440e.isHost(TbadkCoreApplication.getCurrentAccount())) {
                                                                NewSubPbActivity newSubPbActivity2 = this.f55440e;
                                                                if (!newSubPbActivity2.mReplyPrivacyController.checkPrivacyBeforeInvokeEditor(newSubPbActivity2.mSubPbModel.h0().replyPrivateFlag)) {
                                                                    return;
                                                                }
                                                            }
                                                            SparseArray sparseArray3 = (SparseArray) view.getTag(R.id.tag_from);
                                                            if (sparseArray3 == null) {
                                                                return;
                                                            }
                                                            this.f55440e.openEditor(sparseArray3, ((view.getTag(R.id.tag_subpb_ban_display_keyboard) instanceof Boolean) && view.getTag(R.id.tag_subpb_ban_display_keyboard) == Boolean.TRUE) ? false : false);
                                                            if (sparseArray3.get(R.id.tag_clip_board) instanceof PostData) {
                                                                PostData postData2 = (PostData) sparseArray3.get(R.id.tag_clip_board);
                                                                c.a.r0.k2.k.g.e.a(this.f55440e.mSubPbModel != null ? this.f55440e.mSubPbModel.x0() : "", postData2.t() == null ? "" : postData2.t().getUserId(), postData2.E());
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    } else if (view.getId() != R.id.post_info_commont_img && view.getId() != R.id.pb_floor_comment_container && (this.f55440e.mPostMoreOptionView == null || view != this.f55440e.mPostMoreOptionView.getReplyTextView())) {
                                                        if (this.f55440e.mPostMoreOptionView == null || view != this.f55440e.mPostMoreOptionView.getReportTextView()) {
                                                            if (this.f55440e.mPostMoreOptionView == null || view != this.f55440e.mPostMoreOptionView.getMarkTextView()) {
                                                                if (this.f55440e.mPostMoreOptionView == null || view != this.f55440e.mPostMoreOptionView.getDeleteTextView()) {
                                                                    if (this.f55440e.mPostMoreOptionView == null || view != this.f55440e.mPostMoreOptionView.getCopyTextView()) {
                                                                        if (this.f55440e.mPostMoreOptionView == null || view != this.f55440e.mPostMoreOptionView.getEmotionTextView()) {
                                                                            if (this.f55440e.mPostMoreOptionView == null || view != this.f55440e.mPostMoreOptionView.getSaveLocalTextView()) {
                                                                                if (this.f55440e.mPostMoreOptionView == null || view != this.f55440e.mPostMoreOptionView.getDisagreeTextView()) {
                                                                                    if (this.f55440e.mPostMoreOptionView == null || view != this.f55440e.mPostMoreOptionView.getManageTextView()) {
                                                                                        if (this.f55440e.mPostMoreOptionView == null || view != this.f55440e.mPostMoreOptionView.getBlockTextView()) {
                                                                                            if (this.f55440e.mPostMoreOptionView != null && view == this.f55440e.mPostMoreOptionView.getShareTextView()) {
                                                                                                if (view.getTag() instanceof SparseArray) {
                                                                                                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                                                                                                    if (sparseArray4.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                                        PostData postData3 = (PostData) sparseArray4.get(R.id.tag_load_sub_data);
                                                                                                        c.a.r0.k2.k.e.c1.c cVar = new c.a.r0.k2.k.e.c1.c(this.f55440e.getPageContext());
                                                                                                        if (postData3 != null) {
                                                                                                            c.a.e.e.m.e.a().postDelayed(new a(this, cVar, postData3), 100L);
                                                                                                            String f0 = this.f55440e.mSubPbModel.j0().l().f0();
                                                                                                            if (StringUtils.isNull(f0) || "0".equals(f0)) {
                                                                                                                f0 = this.f55440e.mSubPbModel.j0().l().F0();
                                                                                                            }
                                                                                                            TiebaStatic.log(new StatisticItem("c13700").param("tid", f0).param("fid", this.f55440e.mSubPbModel.j0().l().T()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData3.E()).param("obj_source", 1).param("obj_type", 4));
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
                                                                                                if (ViewHelper.checkUpIsLogin(this.f55440e.getPageContext().getPageActivity())) {
                                                                                                    String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                                    String p = c.a.q0.s.d0.b.j().p("tail_link", "");
                                                                                                    if (StringUtils.isNull(p)) {
                                                                                                        return;
                                                                                                    }
                                                                                                    TiebaStatic.log("c10056");
                                                                                                    c.a.q0.m.a.p(view.getContext(), string, p, true, true, true);
                                                                                                    return;
                                                                                                }
                                                                                                return;
                                                                                            } else if (id == R.id.richText && (view.getTag() instanceof SparseArray)) {
                                                                                                Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
                                                                                                if (obj instanceof PostData) {
                                                                                                    PostData postData4 = (PostData) obj;
                                                                                                    if (postData4.getType() == PostData.x0 || TextUtils.isEmpty(postData4.u()) || !c.a.q0.s.k.c().g()) {
                                                                                                        return;
                                                                                                    }
                                                                                                    this.f55440e.navigateToBubbleWebView(postData4.E());
                                                                                                    return;
                                                                                                }
                                                                                                return;
                                                                                            } else {
                                                                                                return;
                                                                                            }
                                                                                        } else if (!c.a.e.e.p.j.z()) {
                                                                                            this.f55440e.showToast(R.string.network_not_available);
                                                                                            return;
                                                                                        } else if (!ViewHelper.checkUpIsLogin(this.f55440e.getActivity()) || (b2 = c.a.r0.u3.a.b(view)) == null || this.f55440e.mUserBlockController == null) {
                                                                                            return;
                                                                                        } else {
                                                                                            this.f55440e.mUserBlockController.n(c.a.e.e.m.b.g(b2, 0L));
                                                                                            return;
                                                                                        }
                                                                                    } else if (!c.a.e.e.p.j.z()) {
                                                                                        this.f55440e.showToast(R.string.network_not_available);
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
                                                                                                this.f55440e.mSubPbView.g0(((Integer) sparseArray5.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray5.get(R.id.tag_del_post_id), ((Integer) sparseArray5.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(R.id.tag_del_post_is_self)).booleanValue(), false);
                                                                                                return;
                                                                                            }
                                                                                            return;
                                                                                        } else if (booleanValue3) {
                                                                                            sparseArray5.put(R.id.tag_from, 1);
                                                                                            sparseArray5.put(R.id.tag_check_mute_from, 2);
                                                                                            this.f55440e.checkMuteState(sparseArray5);
                                                                                            return;
                                                                                        } else {
                                                                                            sparseArray5.put(R.id.tag_check_mute_from, 2);
                                                                                            this.f55440e.mSubPbView.i0(view);
                                                                                            return;
                                                                                        }
                                                                                    }
                                                                                } else if (this.f55440e.checkUpIsLogin() && (sparseArray = (SparseArray) view.getTag()) != null) {
                                                                                    PostData postData5 = (PostData) sparseArray.get(R.id.tag_clip_board);
                                                                                    if (postData5.q() == null) {
                                                                                        return;
                                                                                    }
                                                                                    this.f55440e.clickOnDisagree(postData5.q());
                                                                                    return;
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (this.f55440e.mSaveBdImage == null || TextUtils.isEmpty(this.f55440e.mSaveImageUrl)) {
                                                                                return;
                                                                            } else {
                                                                                if (this.f55440e.mPermissionJudgement == null) {
                                                                                    this.f55440e.mPermissionJudgement = new PermissionJudgePolicy();
                                                                                }
                                                                                this.f55440e.mPermissionJudgement.clearRequestPermissionList();
                                                                                this.f55440e.mPermissionJudgement.appendRequestPermission(this.f55440e.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                if (this.f55440e.mPermissionJudgement.startRequestPermission(this.f55440e.getPageContext().getPageActivity())) {
                                                                                    return;
                                                                                }
                                                                                if (this.f55440e.mSaveImageHelper == null) {
                                                                                    NewSubPbActivity newSubPbActivity3 = this.f55440e;
                                                                                    newSubPbActivity3.mSaveImageHelper = new w0(newSubPbActivity3.getPageContext());
                                                                                }
                                                                                this.f55440e.mSaveImageHelper.b(this.f55440e.mSaveImageUrl, this.f55440e.mSaveBdImage.n());
                                                                                this.f55440e.mSaveBdImage = null;
                                                                                this.f55440e.mSaveImageUrl = null;
                                                                                return;
                                                                            }
                                                                        } else if (this.f55440e.mSaveBdImage == null || TextUtils.isEmpty(this.f55440e.mSaveImageUrl)) {
                                                                            return;
                                                                        } else {
                                                                            if (this.f55440e.mEmotionInfo == null) {
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.f55440e.mSaveImageUrl));
                                                                            } else {
                                                                                d.a aVar = new d.a();
                                                                                aVar.f12822a = this.f55440e.mSaveImageUrl;
                                                                                if (this.f55440e.mEmotionInfo.memeInfo.pck_id.intValue() >= 0) {
                                                                                    str = "" + this.f55440e.mEmotionInfo.memeInfo.pck_id;
                                                                                }
                                                                                aVar.f12823b = str;
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                                                                            }
                                                                            this.f55440e.mSaveBdImage = null;
                                                                            this.f55440e.mSaveImageUrl = null;
                                                                            return;
                                                                        }
                                                                    }
                                                                    NewSubPbActivity newSubPbActivity4 = this.f55440e;
                                                                    PostData postData6 = newSubPbActivity4.postData;
                                                                    if (postData6 != null) {
                                                                        postData6.j0(newSubPbActivity4.getPageContext().getPageActivity());
                                                                        this.f55440e.postData = null;
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                SparseArray sparseArray6 = (SparseArray) view.getTag();
                                                                if (sparseArray6 != null && (sparseArray6.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray6.get(R.id.tag_del_post_id) instanceof String) && (sparseArray6.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray6.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                                                                    boolean booleanValue4 = ((Boolean) sparseArray6.get(R.id.tag_del_post_is_self)).booleanValue();
                                                                    int intValue = ((Integer) sparseArray6.get(R.id.tag_manage_user_identity)).intValue();
                                                                    boolean booleanValue5 = ((Boolean) sparseArray6.get(R.id.tag_has_sub_post)).booleanValue();
                                                                    boolean isHost = this.f55440e.isHost(TbadkCoreApplication.getCurrentAccount());
                                                                    if (isHost) {
                                                                        if (!booleanValue5) {
                                                                            this.f55440e.showDelNoSubPostDialog(sparseArray6, intValue, booleanValue4);
                                                                            return;
                                                                        } else {
                                                                            this.f55440e.mSubPbView.g0(((Integer) sparseArray6.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray6.get(R.id.tag_del_post_id), intValue, booleanValue4, isHost);
                                                                            return;
                                                                        }
                                                                    } else if (booleanValue4 && !booleanValue5) {
                                                                        this.f55440e.showDelNoSubPostDialog(sparseArray6, intValue, booleanValue4);
                                                                        return;
                                                                    } else {
                                                                        this.f55440e.mSubPbView.g0(((Integer) sparseArray6.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray6.get(R.id.tag_del_post_id), intValue, booleanValue4, isHost);
                                                                        return;
                                                                    }
                                                                }
                                                                return;
                                                            } else if (this.f55440e.checkUpIsLogin()) {
                                                                this.f55440e.markFloor(view);
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        } else if (!c.a.e.e.p.j.z()) {
                                                            this.f55440e.showToast(R.string.network_not_available);
                                                            return;
                                                        } else {
                                                            Object tag = view.getTag();
                                                            if (tag instanceof String) {
                                                                this.f55440e.handleReportClicked((String) tag);
                                                                return;
                                                            } else if (tag instanceof SparseArray) {
                                                                SparseArray<Object> sparseArray7 = (SparseArray) tag;
                                                                if ((sparseArray7.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray7.get(R.id.tag_user_mute_visible)).booleanValue()) {
                                                                    sparseArray7.put(R.id.tag_from, 0);
                                                                    sparseArray7.put(R.id.tag_check_mute_from, 2);
                                                                    this.f55440e.checkMuteState(sparseArray7);
                                                                    return;
                                                                }
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        }
                                                    } else if (this.f55440e.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                        SparseArray sparseArray8 = (SparseArray) view.getTag();
                                                        if ((sparseArray8.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray8.get(R.id.tag_load_sub_data)) != null) {
                                                            if (this.f55440e.mSubPbModel != null) {
                                                                TiebaStatic.log(new StatisticItem("c13700").param("tid", this.f55440e.mSubPbModel.y0()).param("fid", this.f55440e.mSubPbModel.getFromForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData.E()).param("obj_source", 1).param("obj_type", 3));
                                                            }
                                                            this.f55440e.openEditor(postData, ((view.getTag(R.id.tag_subpb_ban_display_keyboard) instanceof Boolean) && view.getTag(R.id.tag_subpb_ban_display_keyboard) == Boolean.TRUE) ? false : false);
                                                            return;
                                                        }
                                                        return;
                                                    } else {
                                                        return;
                                                    }
                                                } else if (this.f55440e.checkUpIsLogin()) {
                                                    if (this.f55440e.mEditor.B()) {
                                                        this.f55440e.mEditor.z();
                                                        return;
                                                    } else {
                                                        this.f55440e.mEditor.k0(null, null);
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
                                                    ((PostData) sparseArray9.get(R.id.tag_clip_board)).j0(this.f55440e.getPageContext().getPageActivity());
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                        TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                                        if (!c.a.e.e.p.j.z()) {
                                            this.f55440e.showToast(R.string.network_not_available);
                                            return;
                                        }
                                        Object tag2 = view.getTag();
                                        this.f55440e.mSubPbView.w();
                                        if (tag2 instanceof String) {
                                            String str5 = (String) tag2;
                                            if (this.f55440e.checkUpIsLogin()) {
                                                this.f55440e.handleReportClicked(str5);
                                                return;
                                            }
                                            return;
                                        } else if (tag2 instanceof SparseArray) {
                                            SparseArray<Object> sparseArray10 = (SparseArray) tag2;
                                            if ((sparseArray10.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray10.get(R.id.tag_user_mute_visible)).booleanValue()) {
                                                sparseArray10.put(R.id.tag_from, 0);
                                                sparseArray10.put(R.id.tag_check_mute_from, 2);
                                                this.f55440e.checkMuteState(sparseArray10);
                                                return;
                                            }
                                            return;
                                        } else {
                                            return;
                                        }
                                    } else if (c.a.e.e.p.j.z()) {
                                        this.f55440e.mSubPbView.w();
                                        if (this.f55440e.checkUpIsLogin()) {
                                            this.f55440e.doManager(view);
                                            return;
                                        }
                                        return;
                                    } else {
                                        this.f55440e.showToast(R.string.network_not_available);
                                        return;
                                    }
                                }
                                this.f55440e.mSubPbView.w();
                                SparseArray sparseArray11 = (SparseArray) view.getTag();
                                if (sparseArray11 == null) {
                                    return;
                                }
                                this.f55440e.mSubPbView.g0(((Integer) sparseArray11.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray11.get(R.id.tag_del_post_id), ((Integer) sparseArray11.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray11.get(R.id.tag_del_post_is_self)).booleanValue(), false);
                            } else {
                                TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                                this.f55440e.mSubPbView.w();
                                if (this.f55440e.checkUpIsLogin() && this.f55440e.mSubPbModel.j0() != null) {
                                    NewSubPbActivity newSubPbActivity5 = this.f55440e;
                                    newSubPbActivity5.markFloor(newSubPbActivity5.mSubPbModel.j0().i());
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
                            if (this.f55440e.mPostMoreOptionView == null) {
                                this.f55440e.mPostMoreOptionView = new PbMoreDialog(this.f55440e.getPageContext(), this.f55440e.mCommonClickListener);
                                this.f55440e.mSubPbView.w0(this.f55440e.mPostMoreOptionView.getView());
                                this.f55440e.mPostMoreOptionView.changeLoginStyle(this.f55440e.mIsLogin);
                            }
                            this.f55440e.mPostMoreOptionView.showDialog();
                            this.f55440e.mPostMoreOptionView.confirmFeedback(sparseArray2, this.f55440e.getUserIdentity(), (this.f55440e.isShowReportButton(sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue() : false) && this.f55440e.isLogin()) ? false : false, this.f55440e.mSubPbModel.j0());
                        }
                    } else if (this.f55440e.checkUpIsLogin()) {
                        this.f55440e.mSubPbView.K0();
                        this.f55440e.mSubPbView.u();
                        if (this.f55440e.mEditor != null) {
                            this.f55440e.mEditor.f0();
                        }
                    }
                } else if (this.f55440e.checkUpIsLogin()) {
                    this.f55440e.processProfessionPermission();
                    if (this.f55440e.mSubPbModel == null || this.f55440e.mSubPbModel.j0() == null || this.f55440e.mSubPbModel.j0().l() == null || this.f55440e.mSubPbModel.j0().l().J() == null) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f55440e.mSubPbModel.x0()).param("fid", this.f55440e.mSubPbModel.j0().l().T()).param("obj_locate", 5).param("uid", this.f55440e.mSubPbModel.j0().l().J().getUserId()));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m0 implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f55444a;

        /* loaded from: classes7.dex */
        public class a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(m0 m0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {m0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // c.a.q0.s.s.a.e
            public void onClick(c.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ m0 f55445e;

            public b(m0 m0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {m0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f55445e = m0Var;
            }

            @Override // c.a.q0.s.s.a.e
            public void onClick(c.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                    this.f55445e.f55444a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.f55445e.f55444a.getActivity(), 0, 26, 2)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
                }
            }
        }

        public m0(NewSubPbActivity newSubPbActivity) {
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
            this.f55444a = newSubPbActivity;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, c.a.q0.t.c.l0 l0Var, WriteData writeData, AntiData antiData) {
            ReplyPrivacyCheckController replyPrivacyCheckController;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, l0Var, writeData, antiData}) == null) {
                if (z && this.f55444a.mEditor != null && this.f55444a.mEditor.a() != null) {
                    this.f55444a.mEditor.a().hide();
                    if (this.f55444a.mSubPbModel.G0()) {
                        TiebaStatic.log(new StatisticItem("c10367").param("post_id", this.f55444a.mSubPbModel.y()));
                    }
                }
                if (z) {
                    this.f55444a.mSensitiveProcessController.n(null);
                    this.f55444a.mSensitiveProcessController.i(null);
                    this.f55444a.mSensitiveProcessController.k(false);
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        c.a.q0.t.h.b.a(this.f55444a.getPageContext(), postWriteCallBackData);
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    this.f55444a.mSensitiveProcessController.i(postWriteCallBackData.getSensitiveWords());
                    this.f55444a.mSensitiveProcessController.n(postWriteCallBackData.getErrorString());
                    if (ListUtils.isEmpty(this.f55444a.mSensitiveProcessController.a())) {
                        return;
                    }
                    this.f55444a.mPostWriteCallBackData = postWriteCallBackData;
                    if (this.f55444a.mEditor.y()) {
                        this.f55444a.mEditor.w(this.f55444a.mPostWriteCallBackData);
                    }
                    this.f55444a.checkContentSensitiveWord(true);
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (c.a.e.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.makeText(this.f55444a.getActivity(), this.f55444a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                    } else {
                        DefaultNavigationBarCoverTip.makeText(this.f55444a.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.f55444a.getActivity());
                    if (c.a.e.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.setMessage(this.f55444a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        aVar.setMessage(postWriteCallBackData.getErrorString());
                    }
                    aVar.setNegativeButton(R.string.cancel, new a(this));
                    aVar.setPositiveButton(R.string.open_now, new b(this));
                    aVar.create(this.f55444a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && (replyPrivacyCheckController = this.f55444a.mReplyPrivacyController) != null) {
                    replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                }
                this.f55444a.mSubPbView.l0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f55446e;

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
            this.f55446e = newSubPbActivity;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) {
                this.f55446e.mSubPbView.f0();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) {
                if (i2 == 2 || i2 == 1) {
                    this.f55446e.mSubPbView.w();
                    if (this.f55446e.lastScrollState != 2 && this.f55446e.lastScrollState != 1) {
                        this.f55446e.mSubPbView.T();
                    }
                }
                this.f55446e.mEditor.z();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f55447a;

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
            this.f55447a = newSubPbActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.f55447a.MESSAGE_ID_NEWSUB_PB) {
                this.f55447a.mSubPbView.R();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    this.f55447a.mToastMute.c(this.f55447a.mCtx.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.f55447a.mCtx.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    this.f55447a.showUserMuteAddDialog(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    this.f55447a.showOpenMemberReplyDialog();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (c.a.e.e.p.k.isEmpty(errorString2)) {
                        errorString2 = this.f55447a.mCtx.getResources().getString(R.string.mute_fail);
                    }
                    this.f55447a.mToastMute.b(errorString2);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f55448e;

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
            this.f55448e = newSubPbActivity;
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
            if (this.f55448e.mSubPbView != null && this.f55448e.mSubPbView.Y()) {
                return false;
            }
            try {
                sparseArray = (SparseArray) view.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null && this.f55448e.isImage(view)) {
                if (view instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) view;
                    this.f55448e.mSaveBdImage = tbImageView.getBdImage();
                    this.f55448e.mSaveImageUrl = tbImageView.getUrl();
                    if (this.f55448e.mSaveBdImage == null || TextUtils.isEmpty(this.f55448e.mSaveImageUrl)) {
                        return true;
                    }
                    if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        this.f55448e.mEmotionInfo = null;
                    } else {
                        this.f55448e.mEmotionInfo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    }
                } else if (view instanceof GifView) {
                    GifView gifView = (GifView) view;
                    if (gifView.getBdImage() == null) {
                        return true;
                    }
                    this.f55448e.mSaveBdImage = gifView.getBdImage();
                    if (!TextUtils.isEmpty(gifView.getBdImage().q())) {
                        this.f55448e.mSaveImageUrl = gifView.getBdImage().q();
                    }
                    if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        this.f55448e.mEmotionInfo = null;
                    } else {
                        this.f55448e.mEmotionInfo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    }
                } else if (view instanceof TbMemeImageView) {
                    TbMemeImageView tbMemeImageView = (TbMemeImageView) view;
                    if (tbMemeImageView.getBdImage() != null) {
                        this.f55448e.mSaveBdImage = tbMemeImageView.getBdImage();
                        if (!TextUtils.isEmpty(tbMemeImageView.getBdImage().q())) {
                            this.f55448e.mSaveImageUrl = tbMemeImageView.getBdImage().q();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            this.f55448e.mEmotionInfo = null;
                        } else {
                            this.f55448e.mEmotionInfo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                    this.f55448e.mSubPbView.E0(this.f55448e.mOnImageSaveClickListener, this.f55448e.mSaveBdImage.t());
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
                this.f55448e.postData = (PostData) sparseArray2.get(R.id.tag_clip_board);
                NewSubPbActivity newSubPbActivity = this.f55448e;
                if (newSubPbActivity.postData == null || newSubPbActivity.mMarkModel == null) {
                    return true;
                }
                if (this.f55448e.mMarkModel != null) {
                    this.f55448e.mMarkModel.h(this.f55448e.mSubPbModel.K0());
                }
                boolean z = this.f55448e.mMarkModel.e() && this.f55448e.postData.E() != null && this.f55448e.postData.E().equals(this.f55448e.mSubPbModel.s0());
                if (this.f55448e.mPostMoreOptionView == null) {
                    this.f55448e.mPostMoreOptionView = new PbMoreDialog(this.f55448e.getPageContext(), this.f55448e.mCommonClickListener);
                    this.f55448e.mSubPbView.w0(this.f55448e.mPostMoreOptionView.getView());
                    this.f55448e.mPostMoreOptionView.changeLoginStyle(this.f55448e.mIsLogin);
                }
                this.f55448e.mPostMoreOptionView.showDialog();
                boolean z2 = this.f55448e.isShowReportButton(sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue() : false) && this.f55448e.isLogin();
                boolean z3 = (this.f55448e.mSubPbModel.j0() == null || this.f55448e.mSubPbModel.j0().l() == null || !this.f55448e.mSubPbModel.j0().l().Q1()) ? false : true;
                boolean booleanValue = sparseArray2.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_is_subpb)).booleanValue() : false;
                if (z) {
                    this.f55448e.mPostMoreOptionView.getMarkTextView().setText(R.string.remove_mark);
                } else {
                    this.f55448e.mPostMoreOptionView.getMarkTextView().setText(R.string.mark);
                }
                if (booleanValue || z3) {
                    this.f55448e.mPostMoreOptionView.getMarkTextView().setVisibility(8);
                } else {
                    this.f55448e.mPostMoreOptionView.getMarkTextView().setVisibility(0);
                }
                if (this.f55448e.isImage(view)) {
                    if (this.f55448e.mSaveBdImage != null && !this.f55448e.mSaveBdImage.t()) {
                        sparseArray2.put(R.id.tag_richtext_image, Boolean.TRUE);
                    } else {
                        sparseArray2.put(R.id.tag_richtext_image, Boolean.FALSE);
                    }
                    sparseArray2.put(R.id.tag_richtext_emotion, Boolean.TRUE);
                } else {
                    sparseArray2.put(R.id.tag_richtext_image, Boolean.FALSE);
                    sparseArray2.put(R.id.tag_richtext_emotion, Boolean.FALSE);
                }
                c.a.r0.k2.h.r j0 = this.f55448e.mSubPbModel.j0();
                this.f55448e.mPostMoreOptionView.setTitleContent(c.a.r0.k2.k.e.f1.a.f(this.f55448e.postData));
                this.f55448e.mPostMoreOptionView.confirmItems(sparseArray2, this.f55448e.getUserIdentity(), z2, this.f55448e.showTrisectionAndFeedback && this.f55448e.postData.m0, j0);
                return true;
            }
            sparseArray2 = sparseArray;
            if (sparseArray2 != null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f55449a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o0(NewSubPbActivity newSubPbActivity, int i2) {
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
            this.f55449a = newSubPbActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.f55449a.MESSAGE_ID_NEWSUB_PB) {
                this.f55449a.mSubPbView.R();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    this.f55449a.mToastMute.c(this.f55449a.mCtx.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (c.a.e.e.p.k.isEmpty(muteMessage)) {
                    muteMessage = this.f55449a.mCtx.getResources().getString(R.string.un_mute_fail);
                }
                this.f55449a.mToastMute.b(muteMessage);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p implements TbRichTextView.z {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f55450a;

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
            this.f55450a = newSubPbActivity;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v7, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$b */
        /* JADX DEBUG: Multi-variable search result rejected for r6v8, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$b */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.z
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
                        c.a.r0.k2.h.r j0 = this.f55450a.mSubPbModel.j0();
                        TbRichText validImage = this.f55450a.validImage(str, i2);
                        TbRichTextData tbRichTextData = (validImage == null || validImage.y() == null) ? null : validImage.y().get(this.f55450a.imgIndex);
                        if (tbRichTextData == null) {
                            return;
                        }
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        if (!tbRichTextData.C().D()) {
                            String encodeImageUrl = this.f55450a.encodeImageUrl(tbRichTextData);
                            arrayList.add(encodeImageUrl);
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = str;
                            imageUrlData.urlType = this.f55450a.mIsFromCDN ? 17 : 18;
                            concurrentHashMap.put(encodeImageUrl, imageUrlData);
                            if (j0 != null) {
                                if (j0.d() != null) {
                                    str6 = j0.d().getName();
                                    str7 = j0.d().getId();
                                } else {
                                    str6 = null;
                                    str7 = null;
                                }
                                str8 = j0.l() != null ? j0.l().f0() : null;
                                z4 = true;
                            } else {
                                z4 = false;
                                str6 = null;
                                str7 = null;
                                str8 = null;
                            }
                            if (this.f55450a.mSubPbModel.A0() != null) {
                                concurrentHashMap = this.f55450a.mSubPbModel.A0();
                                z4 = this.f55450a.mSubPbModel.E0();
                                arrayList = this.f55450a.mSubPbModel.z0();
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
                            bVar.N(this.f55450a.getThreadData());
                            bVar.L(String.valueOf(validImage.getPostId()));
                            bVar.A(this.f55450a.mSubPbModel.getFromForumId());
                            this.f55450a.sendMessage(new CustomMessage(2010000, bVar.v(this.f55450a.getPageContext().getPageActivity())));
                            return;
                        }
                        this.f55450a.index_valid = false;
                        TbRichText K = j0.i().K();
                        int size = arrayList.size();
                        int imageIndex = this.f55450a.getImageIndex(K, validImage, i2, i2, arrayList, concurrentHashMap);
                        int size2 = arrayList.size();
                        String str9 = size != size2 ? arrayList.get(size2 - 1) : "";
                        if (j0 != null) {
                            if (j0.d() != null) {
                                str5 = j0.d().getName();
                                str3 = j0.d().getId();
                            } else {
                                str5 = null;
                                str3 = null;
                            }
                            str2 = j0.l() != null ? j0.l().f0() : null;
                            z3 = true;
                            str4 = str5;
                        } else {
                            str2 = null;
                            str3 = null;
                            z3 = false;
                            str4 = null;
                        }
                        if (this.f55450a.mSubPbModel.A0() != null) {
                            concurrentHashMap = this.f55450a.mSubPbModel.A0();
                            z3 = this.f55450a.mSubPbModel.E0();
                            arrayList = this.f55450a.mSubPbModel.z0();
                            imageIndex += this.f55450a.mSubPbModel.t0();
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
                        bVar2.N(this.f55450a.getThreadData());
                        bVar2.L(String.valueOf(validImage.getPostId()));
                        bVar2.A(this.f55450a.mSubPbModel.getFromForumId());
                        this.f55450a.sendMessage(new CustomMessage(2010000, bVar2.v(this.f55450a.getPageContext().getPageActivity())));
                        return;
                    }
                    TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    boolean isGif = ((TbImageView) view).isGif();
                    if (tbRichTextMemeInfo == null || tbRichTextMemeInfo.memeInfo == null) {
                        return;
                    }
                    this.f55450a.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(this.f55450a.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, isGif)));
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f55451a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p0(NewSubPbActivity newSubPbActivity, int i2) {
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
            this.f55451a = newSubPbActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.r0.v3.a) && customResponsedMessage.getOrginalMessage().getTag() == this.f55451a.MESSAGE_ID_NEWSUB_PB) {
                c.a.r0.v3.a aVar = (c.a.r0.v3.a) customResponsedMessage.getData();
                this.f55451a.mSubPbView.R();
                SparseArray<Object> sparseArray = (SparseArray) this.f55451a.mExtra;
                DataRes dataRes = aVar.f25642a;
                if (aVar.f25644c == 0 && dataRes != null) {
                    z = c.a.e.e.m.b.e(dataRes.is_mute, 0) == 1;
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_user_mute_msg, dataRes.mute_confirm);
                } else {
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                    z = false;
                }
                int intValue = sparseArray.get(R.id.tag_from) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_from)).intValue() : 0;
                if (intValue == 0) {
                    this.f55451a.showOperateDialog(z, sparseArray);
                } else if (intValue == 1) {
                    this.f55451a.mSubPbView.h0(sparseArray, z);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f55452a;

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
            this.f55452a = newSubPbActivity;
        }

        @Override // c.a.q0.s.s.b.c
        public void a(c.a.q0.s.s.b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) {
                bVar.e();
                if (this.f55452a.mSaveBdImage == null || TextUtils.isEmpty(this.f55452a.mSaveImageUrl)) {
                    return;
                }
                if (i2 == 0) {
                    if (this.f55452a.mEmotionInfo == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.f55452a.mSaveImageUrl));
                    } else {
                        d.a aVar = new d.a();
                        aVar.f12822a = this.f55452a.mSaveImageUrl;
                        String str = "";
                        if (this.f55452a.mEmotionInfo.memeInfo.pck_id.intValue() >= 0) {
                            str = "" + this.f55452a.mEmotionInfo.memeInfo.pck_id;
                        }
                        aVar.f12823b = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i2 == 1) {
                    if (this.f55452a.mPermissionJudgement == null) {
                        this.f55452a.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    this.f55452a.mPermissionJudgement.clearRequestPermissionList();
                    this.f55452a.mPermissionJudgement.appendRequestPermission(this.f55452a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.f55452a.mPermissionJudgement.startRequestPermission(this.f55452a.getPageContext().getPageActivity())) {
                        return;
                    }
                    if (this.f55452a.mSaveImageHelper == null) {
                        NewSubPbActivity newSubPbActivity = this.f55452a;
                        newSubPbActivity.mSaveImageHelper = new w0(newSubPbActivity.getPageContext());
                    }
                    this.f55452a.mSaveImageHelper.b(this.f55452a.mSaveImageUrl, this.f55452a.mSaveBdImage.n());
                }
                this.f55452a.mSaveBdImage = null;
                this.f55452a.mSaveImageUrl = null;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q0 implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f55453e;

        public q0(NewSubPbActivity newSubPbActivity) {
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
            this.f55453e = newSubPbActivity;
        }

        @Override // c.a.q0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f55453e.mSubPbModel == null) {
                return;
            }
            this.f55453e.mSubPbModel.P0();
        }
    }

    /* loaded from: classes7.dex */
    public class r implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f55454a;

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
            this.f55454a = newSubPbActivity;
        }

        @Override // c.a.r0.x0.g2.a.c.d
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x00cd  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00d7  */
        @Override // c.a.r0.x0.g2.a.c.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void b(boolean z) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) != null) || !z) {
                return;
            }
            NewSubPbActivity newSubPbActivity = this.f55454a;
            if (newSubPbActivity.mReplyPrivacyController != null && newSubPbActivity.mSubPbModel != null && this.f55454a.mSubPbModel.h0() != null && !this.f55454a.isHost(TbadkCoreApplication.getCurrentAccount())) {
                NewSubPbActivity newSubPbActivity2 = this.f55454a;
                if (!newSubPbActivity2.mReplyPrivacyController.checkPrivacyBeforeInvokeEditor(newSubPbActivity2.mSubPbModel.h0().replyPrivateFlag)) {
                    return;
                }
            }
            if (this.f55454a.mSubPbModel != null && this.f55454a.mSubPbModel.j0() != null && this.f55454a.mSubPbModel.j0().i() != null) {
                PostData i2 = this.f55454a.mSubPbModel.j0().i();
                if (i2.K() != null && i2.t() != null) {
                    str = String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), i2.t().getName_show(), i2.K().toString());
                    this.f55454a.mEditor.a().sendAction(new c.a.q0.x.a(45, 27, str));
                    if (!this.f55454a.mEditor.y()) {
                        this.f55454a.mEditor.w(null);
                        return;
                    }
                    this.f55454a.mSubPbView.K0();
                    this.f55454a.mSubPbView.u();
                    if (this.f55454a.mEditor != null) {
                        this.f55454a.mEditor.j0();
                        return;
                    }
                    return;
                }
            }
            str = null;
            this.f55454a.mEditor.a().sendAction(new c.a.q0.x.a(45, 27, str));
            if (!this.f55454a.mEditor.y()) {
            }
        }

        @Override // c.a.r0.x0.g2.a.c.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface r0 {
        void a(Object obj);
    }

    /* loaded from: classes7.dex */
    public class s implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f55455e;

        public s(NewSubPbActivity newSubPbActivity) {
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
            this.f55455e = newSubPbActivity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || this.f55455e.mSensitiveProcessController == null) {
                return;
            }
            if (!this.f55455e.mSensitiveProcessController.e()) {
                this.f55455e.checkContentSensitiveWord(false);
            }
            this.f55455e.mSensitiveProcessController.l(false);
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

    /* loaded from: classes7.dex */
    public class t implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SparseArray f55456a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f55457b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f55458c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f55459d;

        public t(NewSubPbActivity newSubPbActivity, SparseArray sparseArray, boolean z, String str) {
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
            this.f55459d = newSubPbActivity;
            this.f55456a = sparseArray;
            this.f55457b = z;
            this.f55458c = str;
        }

        @Override // c.a.q0.s.s.b.c
        public void a(c.a.q0.s.s.b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) {
                if (i2 == 0) {
                    String str = this.f55456a.get(R.id.tag_user_mute_mute_username) instanceof String ? (String) this.f55456a.get(R.id.tag_user_mute_mute_username) : "";
                    String str2 = this.f55456a.get(R.id.tag_user_mute_thread_id) instanceof String ? (String) this.f55456a.get(R.id.tag_user_mute_thread_id) : "";
                    String str3 = this.f55456a.get(R.id.tag_user_mute_post_id) instanceof String ? (String) this.f55456a.get(R.id.tag_user_mute_post_id) : "";
                    String str4 = this.f55456a.get(R.id.tag_user_mute_msg) instanceof String ? (String) this.f55456a.get(R.id.tag_user_mute_msg) : "";
                    String str5 = this.f55456a.get(R.id.tag_user_mute_mute_nameshow) instanceof String ? (String) this.f55456a.get(R.id.tag_user_mute_mute_nameshow) : "";
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.f55457b, this.f55458c, str, str2, str3, 1, str4, this.f55459d.MESSAGE_ID_NEWSUB_PB);
                    userMuteAddAndDelCustomMessage.setTag(this.f55459d.MESSAGE_ID_NEWSUB_PB);
                    this.f55459d.showUserMuteDialog(this.f55457b, userMuteAddAndDelCustomMessage, str4, str, str5);
                }
                bVar.e();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f55460a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(NewSubPbActivity newSubPbActivity, int i2) {
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
            this.f55460a = newSubPbActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                c.a.q0.f1.m.f.b(this.f55460a.getPageContext(), aVar.f13288a, aVar.f13289b, aVar.f13290c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v implements TiePlusEventController.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f55461a;

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
            this.f55461a = newSubPbActivity;
        }

        @Override // com.baidu.tbadk.widget.tiejia.TiePlusEventController.d
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f55461a.mIsRichTextListenerAcked = true;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class w implements c.a.e.e.k.c<GifView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f55462a;

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
            this.f55462a = newSubPbActivity;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
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
        @Override // c.a.e.e.k.c
        /* renamed from: f */
        public void b(GifView gifView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, gifView) == null) {
                gifView.onDestroy();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.k.c
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new GifView(this.f55462a.getPageContext().getPageActivity()) : (GifView) invokeV.objValue;
        }

        public GifView h(GifView gifView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, gifView)) == null) ? gifView : (GifView) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class x implements c.a.e.e.k.c<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f55463a;

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
            this.f55463a = newSubPbActivity;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
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
                    if (c.a.q0.s.k.c().g()) {
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
        @Override // c.a.e.e.k.c
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
                    foreDrawableImageView.setDefaultBgResource(R.color.CAM_X0204);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.k.c
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.f55463a.getPageContext().getPageActivity());
                boolean g2 = c.a.q0.s.k.c().g();
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
                    foreDrawableImageView.stopLoading();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.CAM_X0204);
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class y implements c.a.e.e.k.c<View> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f55464a;

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
            this.f55464a = newSubPbActivity;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
        public /* bridge */ /* synthetic */ View a(View view) {
            View view2 = view;
            e(view2);
            return view2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
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
        @Override // c.a.e.e.k.c
        /* renamed from: f */
        public void b(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
                ((PlayVoiceBntNew) view).reset();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.k.c
        /* renamed from: g */
        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(this.f55464a.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                playVoiceBntNew.setVoiceManager(this.f55464a.getVoiceManager());
                playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                return playVoiceBntNew;
            }
            return (View) invokeV.objValue;
        }

        public View h(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view)) == null) {
                ((PlayVoiceBntNew) view).reset();
                return view;
            }
            return (View) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class z implements c.a.e.e.k.c<LinearLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f55465a;

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
            this.f55465a = newSubPbActivity;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
        public /* bridge */ /* synthetic */ LinearLayout a(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            e(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
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
        @Override // c.a.e.e.k.c
        /* renamed from: f */
        public void b(LinearLayout linearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, linearLayout) == null) {
                linearLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.k.c
        /* renamed from: g */
        public LinearLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                LinearLayout linearLayout = new LinearLayout(this.f55465a.getPageContext().getPageActivity());
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
        this.mIsFromVideoTAb = false;
        this.mFromVideoTab = 0;
        this.isFromVideoMiddle = false;
        this.mPrePostCallBack = new k(this);
        this.lastScrollState = 0;
        this.mIsFromSchema = false;
        this.mOnlyDisagreeId = BdUniqueId.gen();
        this.showTrisectionAndFeedback = c.a.q0.b.d.l0();
        this.needOpenEditor = true;
        this.richTextEventAckedCallback = new v(this);
        this.mCheckPostCallBack = new g0(this);
        this.subpbReplyListener = new l0(this, 2921481);
        this.mOnPostWriteNewCallback = new m0(this);
        this.mUserMuteAddListener = new n0(this, 2001427);
        this.mUserMuteDelListener = new o0(this, 2001428);
        this.mUserMuteCheckListener = new p0(this, 2001426);
        this.mOnPullRefreshListener = new q0(this);
        this.index_valid = false;
        this.mOnImageSaveClickListener = new q(this);
        this.richTextIntentClickListener = new u(this, 2001332);
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
            return AntiHelper.d(getPageContext(), subPbModel.h0());
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void clickOnDisagree(AgreeData agreeData) {
        c.a.q0.m0.c k2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65604, this, agreeData) == null) || agreeData == null) {
            return;
        }
        if (this.mMessageHelper == null) {
            this.mMessageHelper = new c.a.q0.s.b0.a();
        }
        if (this.mMsgData == null) {
            c.a.r0.k3.i0.e eVar = new c.a.r0.k3.i0.e();
            this.mMsgData = eVar;
            eVar.f21030a = this.mOnlyDisagreeId;
        }
        c.a.q0.s.q.f fVar = new c.a.q0.s.q.f();
        fVar.f14190b = 12;
        fVar.f14196h = 9;
        fVar.f14195g = 3;
        if (getSubPbModel() != null) {
            fVar.f14194f = getSubPbModel().u0();
        }
        fVar.f14189a = 2;
        int i2 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                fVar.f14197i = 0;
                k2 = TbPageExtraHelper.k(getActivity());
                if (k2 != null) {
                    agreeData.objSource = k2.a();
                }
                this.mMessageHelper.c(agreeData, i2, getUniqueId(), false);
                this.mMessageHelper.d(agreeData, this.mMsgData);
                if (getSubPbModel() != null || getSubPbModel().j0() == null) {
                }
                this.mMessageHelper.b(this, fVar, agreeData, getSubPbModel().j0().l());
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            fVar.f14197i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            fVar.f14197i = 1;
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
        c.a.e.e.m.g.d(this.mSubPbView.M(), getPageContext().getPageActivity());
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
            TbRichTextImageInfo C = tbRichTextData.C();
            if (C != null) {
                if (!StringUtils.isNull(C.w())) {
                    return C.w();
                }
                if (C.getHeight() * C.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                    double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (C.getHeight() * C.getWidth()));
                    sb.append(BigImageLoaderProc.NCDN_PER);
                    sb.append(String.valueOf((int) (C.getWidth() * sqrt)));
                    sb.append("&height=");
                    sb.append(String.valueOf((int) (C.getHeight() * sqrt)));
                } else {
                    double width = C.getWidth() / C.getHeight();
                    double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                    sb.append(BigImageLoaderProc.NCDN_PER);
                    sb.append(String.valueOf((int) (width * sqrt2)));
                    sb.append("&height=");
                    sb.append(String.valueOf((int) sqrt2));
                }
                sb.append("&src=");
                sb.append(c.a.e.e.p.k.getUrlEncode(C.B()));
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
            c.a.r0.k2.k.g.a aVar = this.mSubPbView;
            if (aVar == null || aVar.G() == null || (pbCommenFloorItemViewHolder = this.mItemClickShowSoftKeyBoardViewHolder) == null || (i2 = pbCommenFloorItemViewHolder.mPosition) == -1) {
                return;
            }
            int headerViewsCount = i2 + this.mSubPbView.G().getHeaderViewsCount();
            if (this.mItemClickShowSoftKeyBoardViewHolder.getView() != null) {
                int height = this.mItemClickShowSoftKeyBoardViewHolder.getView().getHeight();
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
                        if (y2.get(i4).C().y().equals(str)) {
                            int h2 = (int) c.a.e.e.p.l.h(TbadkCoreApplication.getInst());
                            int width = y2.get(i4).C().getWidth() * h2;
                            int height = y2.get(i4).C().getHeight() * h2;
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
        TbRichTextImageInfo C;
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
                        int h2 = (int) c.a.e.e.p.l.h(TbadkCoreApplication.getInst());
                        int width = tbRichText.y().get(i5).C().getWidth() * h2;
                        int height = tbRichText.y().get(i5).C().getHeight() * h2;
                        if (!(width < 80 || height < 80 || width * height < 10000) && tbRichText.y().get(i5).C().D()) {
                            TbRichTextData tbRichTextData = tbRichText.y().get(i5);
                            String encodeImageUrl = encodeImageUrl(tbRichTextData);
                            arrayList.add(encodeImageUrl);
                            if (!TextUtils.isEmpty(encodeImageUrl) && tbRichTextData != null && (C = tbRichTextData.C()) != null) {
                                String y2 = C.y();
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
    public d2 getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65610, this)) == null) {
            SubPbModel subPbModel = this.mSubPbModel;
            if (subPbModel == null || subPbModel.j0() == null) {
                return null;
            }
            return this.mSubPbModel.j0().l();
        }
        return (d2) invokeV.objValue;
    }

    private void handleFullScreenEditorResult(int i2, Intent intent) {
        c.a.q0.x.n nVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65611, this, i2, intent) == null) {
            this.mEditor.a().hideTools();
            this.mEditor.z();
            if (intent == null) {
                return;
            }
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.mEditor.C(writeData);
                this.mEditor.d0(pbEditorData.getVoiceModel());
                c.a.q0.x.m findToolById = this.mEditor.a().findToolById(6);
                if (findToolById != null && (nVar = findToolById.k) != null) {
                    nVar.onAction(new c.a.q0.x.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i2 == -1) {
                    this.mEditor.G();
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
            c.a.q0.x.x.h hVar = (c.a.q0.x.x.h) new c.a.q0.x.x.i(z2).a(getActivity());
            this.mEditor = hVar;
            if (hVar != null) {
                hVar.O(getPageContext());
                this.mEditor.b0(this.mSubPbModel);
                this.mEditor.R(this.mOnPostWriteNewCallback);
                this.mEditor.P(2);
                this.mEditor.V(this.mPrePostCallBack);
                this.mEditor.N(this.mCheckPostCallBack);
                this.mEditor.a().showLinePositionBottom(true);
                this.mEditor.A(getPageContext());
                this.mEditor.Q(this.mFromVideoTab);
            }
            c.a.r0.k2.k.g.a aVar = this.mSubPbView;
            if (aVar != null) {
                aVar.X(this.mEditor);
            }
            c.a.q0.x.x.h hVar2 = this.mEditor;
            if (hVar2 != null && (subPbModel = this.mSubPbModel) != null) {
                hVar2.H(subPbModel.h0());
                this.mEditor.z();
            }
            c.a.q0.x.x.h hVar3 = this.mEditor;
            if (hVar3 == null) {
                return;
            }
            hVar3.u().k(getReplyHint());
            this.mEditor.u().l(getReplyHint());
            EditText i2 = this.mEditor.u().i();
            this.mSubFloorEditText = i2;
            i2.addTextChangedListener(new s(this));
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

    private boolean initIsFromVideoMiddle(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65614, this, bundle)) == null) {
            if (bundle != null) {
                this.isFromVideoMiddle = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_VIDEO_MIDDLE);
            } else {
                this.isFromVideoMiddle = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_VIDEO_MIDDLE, false);
            }
            return this.isFromVideoMiddle;
        }
        return invokeL.booleanValue;
    }

    private boolean initIsFromVideoTab(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65615, this, bundle)) == null) {
            if (bundle != null) {
                this.mIsFromVideoTAb = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_VIDEO_TAB, false);
                this.mFromVideoTab = bundle.getInt(SubPbActivityConfig.KEY_IS_JUMP_FROM_VIDEO_TAB_CHILD);
            } else {
                Intent intent = getIntent();
                this.mIsFromVideoTAb = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_VIDEO_TAB, false);
                this.mFromVideoTab = intent.getIntExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_VIDEO_TAB_CHILD, 0);
            }
            return this.mIsFromVideoTAb;
        }
        return invokeL.booleanValue;
    }

    private int initIsFromVideoTabChild(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65616, this, bundle)) == null) {
            if (bundle != null) {
                this.mFromVideoTab = bundle.getInt(SubPbActivityConfig.KEY_IS_JUMP_FROM_VIDEO_TAB_CHILD);
            } else {
                this.mFromVideoTab = getIntent().getIntExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_VIDEO_TAB_CHILD, 0);
            }
            return this.mFromVideoTab;
        }
        return invokeL.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShowReportButton(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65617, this, z2)) == null) {
            if (this.mSubPbModel == null) {
                return false;
            }
            return ((getUserIdentity() != 0) || this.mSubPbModel.j0() == null || this.mSubPbModel.j0().l() == null || this.mSubPbModel.j0().l().J() == null || this.mSubPbModel.j0().l().D2() || TextUtils.equals(this.mSubPbModel.j0().l().J().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z2) ? false : true;
        }
        return invokeZ.booleanValue;
    }

    private void jumpToWeb(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65618, this, str) == null) {
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
        if (interceptable == null || interceptable.invokeL(65619, this, view) == null) {
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
        if ((interceptable == null || interceptable.invokeL(65620, this, str) == null) && !StringUtils.isNull(str) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
            String p2 = c.a.q0.s.d0.b.j().p("bubble_link", "");
            if (StringUtils.isNull(p2)) {
                return;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return;
            }
            c.a.q0.m.a.p(getPageContext().getPageActivity(), getResources().getString(R.string.editor_privilege), p2 + "?props_id=" + str, true, true, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onNetOrDataError(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65621, this, i2, str) == null) {
            if (this.mSubPbModel.D0()) {
                showToast(str);
            } else if (!c.a.e.e.p.l.D()) {
                this.mSubPbView.C0(R.string.recommend_pb_no_net_text);
            } else if (i2 == 4) {
                c.a.r0.k2.k.g.a aVar = this.mSubPbView;
                aVar.D0(str + "(4" + SmallTailInfo.EMOTION_SUFFIX, true);
            } else if (!TextUtils.isEmpty(str)) {
                c.a.r0.k2.k.g.a aVar2 = this.mSubPbView;
                aVar2.D0(str + "(" + i2 + SmallTailInfo.EMOTION_SUFFIX, true);
            } else {
                this.mSubPbView.C0(R.string.no_data_text);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openEditor(SparseArray<Object> sparseArray, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65622, this, sparseArray, z2) == null) || sparseArray == null) {
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
        if (interceptable == null || interceptable.invokeV(65624, this) == null) {
            Intent intent = getIntent();
            boolean booleanExtra = intent != null ? intent.getBooleanExtra("key_is_from_dynamic", false) : false;
            if (checkIsIfPostForbid()) {
                return;
            }
            if (booleanExtra) {
                if (this.mReplyPrivacyController == null || (subPbModel = this.mSubPbModel) == null || subPbModel.h0() == null || isHost(TbadkCoreApplication.getCurrentAccount()) || this.mReplyPrivacyController.checkPrivacyBeforeInvokeEditor(this.mSubPbModel.h0().replyPrivateFlag)) {
                    if (this.mEditor.y()) {
                        this.mEditor.w(null);
                        return;
                    }
                    this.mSubPbView.K0();
                    this.mSubPbView.u();
                    c.a.q0.x.x.h hVar = this.mEditor;
                    if (hVar != null) {
                        hVar.j0();
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.mProfessionController == null) {
                c.a.r0.x0.g2.a.c cVar = new c.a.r0.x0.g2.a.c(getPageContext());
                this.mProfessionController = cVar;
                cVar.i(new r(this));
            }
            SubPbModel subPbModel2 = this.mSubPbModel;
            if (subPbModel2 == null || subPbModel2.j0() == null || this.mSubPbModel.j0().d() == null) {
                return;
            }
            this.mProfessionController.g(this.mSubPbModel.j0().d().getId(), c.a.e.e.m.b.g(this.mSubPbModel.x0(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDelNoSubPostDialog(SparseArray<Object> sparseArray, int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65625, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            c.a.r0.k2.k.e.f1.a.d(this, getPageContext(), new j(this, sparseArray, i2, z2), new l(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDeleteResumeEditorTips(View view, c.a.q0.x.x.h hVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65626, this, view, hVar, str) == null) {
            new WriteTipBubbleController(getPageContext(), new d(this, view, hVar)).d(view, getString(R.string.open_editor_tips), str, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_PB_REPLY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showOpenMemberReplyDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65627, this) == null) {
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(getPageContext().getPageActivity());
            aVar.setMessage(getResources().getString(R.string.mute_is_super_member_function));
            aVar.setPositiveButton(R.string.open_now, new f0(this));
            aVar.setNegativeButton(R.string.cancel, new h0(this));
            aVar.create(this.mCtx).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showOperateDialog(boolean z2, SparseArray<Object> sparseArray) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65628, this, z2, sparseArray) == null) {
            String str = sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_mute_userid) : "";
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                String[] strArr = new String[1];
                if (z2) {
                    string = getResources().getString(R.string.un_mute);
                } else {
                    string = getResources().getString(R.string.mute);
                }
                strArr[0] = string;
                c.a.q0.s.s.b bVar = new c.a.q0.s.s.b(getPageContext().getPageActivity());
                bVar.k(R.string.operation);
                bVar.j(strArr, new t(this, sparseArray, z2, str));
                bVar.c(getPageContext());
                bVar.m();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showUserMuteAddDialog(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65629, this, str) == null) {
            if (str == null) {
                str = "";
            }
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.mCtx.getPageActivity());
            aVar.setMessage(str);
            aVar.setNegativeButton(R.string.know, new e0(this));
            aVar.create(this.mCtx).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showUserMuteDialog(boolean z2, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65630, this, new Object[]{Boolean.valueOf(z2), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z2) {
                this.mSubPbView.A0();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.mCtx.getPageActivity());
            if (c.a.e.e.p.k.isEmpty(str)) {
                aVar.setMessage(this.mCtx.getResources().getString(R.string.block_mute_message_alert, str3));
            } else {
                aVar.setMessage(str);
            }
            aVar.setPositiveButton(R.string.confirm, new c0(this, userMuteAddAndDelCustomMessage));
            aVar.setNegativeButton(R.string.cancel, new d0(this));
            aVar.create(this.mCtx).show();
        }
    }

    private void startBrowsePageMission() {
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65631, this) == null) || (subPbModel = this.mSubPbModel) == null || c.a.e.e.p.k.isEmpty(subPbModel.x0())) {
            return;
        }
        c.a.q0.a.d.y().P(c.a.q0.a.c.W, c.a.e.e.m.b.g(this.mSubPbModel.x0(), 0L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText validImage(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65632, this, str, i2)) == null) {
            SubPbModel subPbModel = this.mSubPbModel;
            if (subPbModel == null || subPbModel.j0() == null || str == null || i2 < 0) {
                return null;
            }
            c.a.r0.k2.h.r j02 = this.mSubPbModel.j0();
            TbRichText image = getImage(j02.i(), str, i2);
            if (image != null || (image = getImage(j02.i(), str, i2)) != null) {
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
            c.a.r0.d4.c cVar = this.mSensitiveProcessController;
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
            userMuteCheckCustomMessage.userIdF = c.a.e.e.m.b.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = c.a.e.e.m.b.g(str, 0L);
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
                this.mEditor.z();
            } else if (StringUtils.isNull(this.mSubPbModel.v0())) {
            } else {
                if (this.mSubPbView.I0() && c.a.e.e.p.l.D()) {
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
            if (this.mIsFromPb && !this.mIsFromSchema && !this.mIsFromVideoTAb) {
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
            if (this.mIsFromPb && !this.mIsFromSchema && !this.mIsFromVideoTAb) {
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
        this.mSubPbView.z(0, bVar.f57176a, bVar.f57177b, z2);
        if (bVar.f57176a) {
            int i3 = bVar.f57179d;
            if (i3 == 1) {
                if (this.mSubPbView.G() instanceof BdTypeListView) {
                    List<c.a.e.l.e.n> data = ((BdTypeListView) this.mSubPbView.G()).getData();
                    if (!ListUtils.isEmpty(data)) {
                        while (i2 < data.size() && (!(data.get(i2) instanceof PostData) || !bVar.f57182g.equals(((PostData) data.get(i2)).E()))) {
                            i2++;
                        }
                        if (i2 < data.size()) {
                            data.remove(i2);
                        }
                        this.mSubPbView.a0();
                    }
                }
            } else if (i3 == 2) {
                this.mSubPbModel.f0(bVar.f57182g);
                this.mSubPbView.H0(this.mSubPbModel.j0(), this.mSubPbModel.B0(), this.mSubPbModel.A0() != null, false);
                if (this.mSubPbModel.L0()) {
                    this.mSubPbModel.X0(false);
                    this.mSubPbView.s();
                    this.mSubPbModel.loadData();
                }
            }
            c.a.r0.k2.e eVar = new c.a.r0.k2.e();
            eVar.c(bVar);
            eVar.d(1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, eVar));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, c.a.q0.o0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "a007" : (String) invokeV.objValue;
    }

    @Override // c.a.r0.k2.k.a
    public c.a.r0.k2.k.e.c1.a getEventController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mEvent : (c.a.r0.k2.k.e.c1.a) invokeV.objValue;
    }

    @Override // c.a.r0.k2.k.a
    public String getFromForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            SubPbModel subPbModel = this.mSubPbModel;
            if (subPbModel == null || subPbModel.j0() == null || this.mSubPbModel.j0().l() == null) {
                return null;
            }
            return this.mSubPbModel.j0().l().Z();
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.q0.f1.m.i
    public c.a.e.e.k.b<GifView> getGifViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.mGifViewPool == null) {
                this.mGifViewPool = new c.a.e.e.k.b<>(new w(this), 20, 0);
            }
            return this.mGifViewPool;
        }
        return (c.a.e.e.k.b) invokeV.objValue;
    }

    @Override // c.a.q0.f1.m.i
    public c.a.e.e.k.b<ImageView> getImageViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.mImageViewPool == null) {
                this.mImageViewPool = new c.a.e.e.k.b<>(new x(this), 8, 0);
            }
            return this.mImageViewPool;
        }
        return (c.a.e.e.k.b) invokeV.objValue;
    }

    @Override // c.a.q0.f1.m.i
    public c.a.e.e.k.b<ItemCardView> getItemCardViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return null;
        }
        return (c.a.e.e.k.b) invokeV.objValue;
    }

    @Override // c.a.q0.f1.m.i
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            c.a.r0.k2.k.g.a aVar = this.mSubPbView;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            SubPbModel subPbModel = this.mSubPbModel;
            if (subPbModel == null || c.a.e.e.p.k.isEmpty(subPbModel.x0())) {
                return 0L;
            }
            return c.a.e.e.m.b.g(this.mSubPbModel.x0(), 0L);
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public c.a.q0.o0.d getPageStayDurationItem() {
        InterceptResult invokeV;
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            c.a.q0.o0.d pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null && (subPbModel = this.mSubPbModel) != null) {
                if (subPbModel.j0() != null && this.mSubPbModel.j0().d() != null) {
                    pageStayDurationItem.t(c.a.e.e.m.b.g(this.mSubPbModel.j0().d().getId(), 0L));
                }
                pageStayDurationItem.C(c.a.e.e.m.b.g(this.mSubPbModel.x0(), 0L));
                if (this.mSubPbModel.j0() != null && this.mSubPbModel.j0().l() != null) {
                    d2 l2 = this.mSubPbModel.j0().l();
                    pageStayDurationItem.u(l2.F0());
                    if (l2.o2()) {
                        pageStayDurationItem.t = "1";
                    } else if (l2.E2()) {
                        pageStayDurationItem.t = "2";
                    } else {
                        pageStayDurationItem.t = "3";
                    }
                }
                pageStayDurationItem.w(c.a.e.e.m.b.g(this.mSubPbModel.y(), 0L));
            }
            return pageStayDurationItem;
        }
        return (c.a.q0.o0.d) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, c.a.q0.o0.a
    public c.a.q0.o0.b getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? new b0(this) : (c.a.q0.o0.b) invokeV.objValue;
    }

    public String getPostId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            SubPbModel subPbModel = this.mSubPbModel;
            if (subPbModel != null) {
                return subPbModel.y();
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, voiceData$VoiceModel)) == null) {
            View E = this.mSubPbView.E();
            if (E == null || (findViewWithTag = E.findViewWithTag(voiceData$VoiceModel)) == null) {
                return null;
            }
            return (VoiceManager.i) findViewWithTag;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // c.a.q0.f1.m.i
    public c.a.e.e.k.b<RelativeLayout> getRelativeLayoutPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            c.a.e.e.k.b<RelativeLayout> bVar = new c.a.e.e.k.b<>(new a0(this), 10, 0);
            this.mMemeViewPool = bVar;
            return bVar;
        }
        return (c.a.e.e.k.b) invokeV.objValue;
    }

    public String getReplyHint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (!c.a.e.e.p.k.isEmpty(this.mReplyHintText)) {
                return this.mReplyHintText;
            }
            String string = getResources().getString(c.a.r0.k2.k.e.q0.b());
            this.mReplyHintText = string;
            return string;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.q0.f1.m.i
    public int getRichTextViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public SubPbModel getSubPbModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mSubPbModel : (SubPbModel) invokeV.objValue;
    }

    @Override // c.a.q0.f1.m.i
    public c.a.e.e.k.b<TextView> getTextViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.mTextViewPool == null) {
                this.mTextViewPool = TbRichTextView.createTextViewPool(getPageContext().getPageActivity(), 8);
            }
            return this.mTextViewPool;
        }
        return (c.a.e.e.k.b) invokeV.objValue;
    }

    @Override // c.a.q0.f1.m.i
    public c.a.e.e.k.b<LinearLayout> getTextVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (this.mTextVoiceViewPool == null) {
                this.mTextVoiceViewPool = new c.a.e.e.k.b<>(new z(this), 15, 0);
            }
            return this.mTextVoiceViewPool;
        }
        return (c.a.e.e.k.b) invokeV.objValue;
    }

    public String getThreadId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            SubPbModel subPbModel = this.mSubPbModel;
            if (subPbModel != null) {
                return subPbModel.x0();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.q0.f1.m.i
    public c.a.e.e.k.b<TiebaPlusRecommendCard> getTiejiaRecommendPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return null;
        }
        return (c.a.e.e.k.b) invokeV.objValue;
    }

    @Override // c.a.r0.k2.k.a
    public int getUserIdentify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            SubPbModel subPbModel = this.mSubPbModel;
            if (subPbModel == null) {
                return 0;
            }
            return subPbModel.B0();
        }
        return invokeV.intValue;
    }

    public int getUserIdentity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            SubPbModel subPbModel = this.mSubPbModel;
            if (subPbModel != null) {
                return subPbModel.B0();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.mVoiceManager : (VoiceManager) invokeV.objValue;
    }

    @Override // c.a.q0.f1.m.i
    public c.a.e.e.k.b<View> getVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (this.mVoiceViewPool == null) {
                this.mVoiceViewPool = new c.a.e.e.k.b<>(new y(this), 8, 0);
            }
            return this.mVoiceViewPool;
        }
        return (c.a.e.e.k.b) invokeV.objValue;
    }

    public void handleMuteClick(boolean z2, String str, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Boolean.valueOf(z2), str, sparseArray}) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            SubPbModel subPbModel = this.mSubPbModel;
            if (subPbModel != null && subPbModel.j0() != null && this.mSubPbModel.j0().l() != null && this.mSubPbModel.j0().l().Q1()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.mSubPbModel.x0(), str);
                d2 l2 = this.mSubPbModel.j0().l();
                if (l2.M1()) {
                    format = format + "&channelid=33833";
                } else if (l2.R1()) {
                    format = format + "&channelid=33842";
                } else if (l2.P1()) {
                    format = format + "&channelid=33840";
                }
                jumpToWeb(format);
                return;
            }
            this.mUEGReportController.a(str);
        }
    }

    public void initCallBacks() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.mSubPbCallBack = new e(this);
            this.mMarkDoneCallBack = new f(this);
            this.forbidUserCallback = new g(this);
            this.deleteReplayCallback = new h(this);
            this.mPostManageCallBack = new i(this);
        }
    }

    public void initData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, bundle) == null) {
            SubPbModel subPbModel = new SubPbModel(getPageContext());
            this.mSubPbModel = subPbModel;
            subPbModel.W0(new c(this));
            ForumManageModel forumManageModel = new ForumManageModel(getPageContext());
            this.mPostManageModel = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.mPostManageCallBack);
            VoiceManager voiceManager = new VoiceManager();
            this.mVoiceManager = voiceManager;
            voiceManager.onCreate(getPageContext());
            c.a.q0.i.a b2 = c.a.q0.i.a.b(this);
            this.mMarkModel = b2;
            if (b2 != null) {
                b2.j(this.mMarkDoneCallBack);
            }
            if (bundle != null) {
                this.mSubPbModel.initWithBundle(bundle);
            } else {
                this.mSubPbModel.initWithIntent(getIntent());
            }
            setForceInterceptStimeStat(this.mSubPbModel.F0());
            this.mSubPbModel.a1(this.mSubPbCallBack);
            if (this.mSubPbModel.H0() && !this.mSubPbModel.N0()) {
                this.mSubPbModel.loadData();
            } else if (!TextUtils.isEmpty(getIntent().getStringExtra("key_open_editor_tips"))) {
                this.mSubPbModel.loadData();
            } else {
                this.mSubPbModel.O0();
            }
        }
    }

    public void initListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            registerListener(this.updatePendantMessageListener);
            this.mCommonClickListener = new m(this);
            this.mSubPbScrollListener = new n(this);
            this.mOnLongClickListener = new o(this);
            this.mImageClickListener = new p(this);
        }
    }

    public void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            c.a.r0.k2.k.g.a aVar = new c.a.r0.k2.k.g.a(this, this.mCommonClickListener);
            this.mSubPbView = aVar;
            aVar.q0(this.mSubPbModel);
            setContentView(this.mSubPbView.P(), new FrameLayout.LayoutParams(-1, -1));
            this.mSubPbView.u0(this.mSubPbScrollListener);
            this.mSubPbView.v0(this);
            this.mSubPbView.r0(this.mImageClickListener);
            this.mSubPbView.s0(this.mOnLongClickListener);
            this.mSubPbView.t0(new b(this));
            this.mSubPbView.m0(this.forbidUserCallback);
            this.mSubPbView.k0(this.deleteReplayCallback);
            this.mSubPbView.o0(this.mOnPullRefreshListener);
            SubPbModel subPbModel = this.mSubPbModel;
            if (subPbModel != null && subPbModel.H0() && !this.mSubPbModel.M0()) {
                this.mSubPbView.D().setVisibility(8);
            } else {
                this.mSubPbView.D().setVisibility(0);
            }
            SubPbModel subPbModel2 = this.mSubPbModel;
            if (subPbModel2 == null || subPbModel2.H0()) {
                return;
            }
            this.mSubPbView.n0(false);
        }
    }

    public boolean isFromPb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            SubPbModel subPbModel = this.mSubPbModel;
            if (subPbModel != null) {
                return subPbModel.H0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isH5GameLink(String str) {
        InterceptResult invokeL;
        Map<String, String> paramPair;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (paramPair = UrlManager.getParamPair(UrlManager.getParamStr(str))) == null) {
                return false;
            }
            this.mIsRichTextListenerAcked = true;
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return isH5GameLink(c.a.e.e.p.k.getUrlDecode(str2));
            }
            String str3 = paramPair.get(TB_GAME_TYPE);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.r0.k2.k.a
    public boolean isHost(String str) {
        InterceptResult invokeL;
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, str)) == null) {
            if (StringUtils.isNull(str) || (subPbModel = this.mSubPbModel) == null || subPbModel.j0() == null || this.mSubPbModel.j0().l() == null || this.mSubPbModel.j0().l().J() == null) {
                return false;
            }
            return str.equals(this.mSubPbModel.j0().l().J().getUserId());
        }
        return invokeL.booleanValue;
    }

    public boolean isImage(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, view)) == null) ? (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView) : invokeL.booleanValue;
    }

    public boolean isPaused() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.mIsPaused : invokeV.booleanValue;
    }

    @Override // c.a.r0.k2.k.a
    public boolean isSimpleForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            SubPbModel subPbModel = this.mSubPbModel;
            if (subPbModel == null || subPbModel.j0() == null || this.mSubPbModel.j0().l() == null) {
                return false;
            }
            return !this.mSubPbModel.j0().l().l2();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048619, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i2 == 25035) {
                handleFullScreenEditorResult(i3, intent);
            }
            c.a.q0.x.x.h hVar = this.mEditor;
            if (hVar != null) {
                hVar.D(i2, i3, intent);
            }
        }
    }

    @Override // c.a.q0.f1.m.i
    public void onAtClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048620, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.mIsRichTextListenerAcked = true;
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            c.a.q0.x.x.h hVar = this.mEditor;
            if (hVar != null && hVar.a() != null && this.mEditor.a().isToolVisible()) {
                this.mEditor.a().hideTools();
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mSubPbView.e0(i2);
            if (!this.mIsFromVideoTAb || UtilHelper.isFlyMeOs()) {
                return;
            }
            UtilHelper.changeStatusBarIconAndTextColor(true, this);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, bundle) == null) {
            initIsFromPb(bundle);
            initIsFromVideoTab(bundle);
            initIsFromVideoTabChild(bundle);
            initIsFromVideoMiddle(bundle);
            if (getIntent() != null) {
                this.mIsFromSchema = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_FROM_SCHEMA, false);
                if (this.mIsFromVideoTAb) {
                    this.mVideoPageUniqueId = (BdUniqueId) getIntent().getSerializableExtra("key_from_video_page_id");
                }
            }
            super.onCreate(bundle);
            this.mCtx = getPageContext();
            this.isFirstLoadData = true;
            c.a.r0.d4.c cVar = new c.a.r0.d4.c();
            this.mSensitiveProcessController = cVar;
            cVar.h(R.color.cp_cont_h_alpha85);
            this.mSensitiveProcessController.j(R.color.CAM_X0101);
            initListeners();
            initCallBacks();
            initData(bundle);
            initUI();
            if (this.mIsFromVideoTAb) {
                ((SubPbView) this.mSubPbView.P()).setAnimTime(0);
                ((SubPbView) this.mSubPbView.P()).setIsFromVideoTab(true);
            } else {
                ((SubPbView) this.mSubPbView.P()).setAnimTime(300);
                ((SubPbView) this.mSubPbView.P()).setIsFromVideoTab(false);
            }
            ((SubPbView) this.mSubPbView.P()).show();
            initEditor(false);
            addGlobalLayoutListener();
            adjustResizeForSoftInput();
            this.mSubPbView.r(this.mIsFromSchema);
            c.a.q0.s.f0.c cVar2 = new c.a.q0.s.f0.c();
            this.mToastMute = cVar2;
            cVar2.f13832a = 1000L;
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
            replyPrivacyCheckController.setAttentionCallback(new a(this));
            c.a.r0.k2.k.f.a aVar = new c.a.r0.k2.k.f.a(this);
            this.mUEGReportController = aVar;
            aVar.b(getUniqueId());
            this.mEvent = new c.a.r0.k2.k.e.c1.a(this);
            this.mUserBlockController = new c.a.r0.u3.b(getPageContext(), getUniqueId());
            if (this.tiePlusEventController == null) {
                if (this.isFromVideoMiddle) {
                    this.tiePlusEventController = new TiePlusEventController(this, TiePlusStat.Locate.VIDEO_MIDDLE_COMMENT);
                } else {
                    this.tiePlusEventController = new TiePlusEventController(this, TiePlusStat.Locate.PB_COMMENT);
                }
                this.tiePlusEventController.addEventAckedCallbackWeaked(this.richTextEventAckedCallback);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
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
            c.a.r0.u3.b bVar = this.mUserBlockController;
            if (bVar != null) {
                bVar.l();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.mReplyPrivacyController;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            this.mCtx = null;
            this.mToastMute = null;
            TbPageExtraHelper.v(getCurrentPageKey());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z2) == null) {
            super.onKeyboardVisibilityChanged(z2);
            this.mIsSoftKeyBoardVisible = z2;
            fixReplyFloorViewHolderPosition(true);
        }
    }

    @Override // c.a.q0.f1.m.i
    public void onLinkButtonClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048626, this, context, str) == null) {
        }
    }

    @Override // c.a.q0.f1.m.i
    public void onLinkClicked(Context context, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048627, this, context, str, z2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (isH5GameLink(str)) {
            MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
            return;
        }
        if (z2) {
            if (!TextUtils.isEmpty(str)) {
                c.a.q0.u.l lVar = new c.a.q0.u.l();
                lVar.f15072a = str;
                lVar.f15073b = 3;
                lVar.f15074c = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, lVar));
            }
        } else {
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str});
        }
        this.mIsRichTextListenerAcked = true;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            this.mIsPaused = true;
            super.onPause();
            TiePlusEventController tiePlusEventController = this.tiePlusEventController;
            if (tiePlusEventController != null) {
                tiePlusEventController.onPause();
            }
            c.a.q0.a.d.y().E();
            VoiceManager voiceManager = this.mVoiceManager;
            if (voiceManager != null) {
                voiceManager.onPause(getPageContext());
            }
            MessageManager.getInstance().unRegisterListener(this.richTextIntentClickListener);
            this.mSubPbView.c0();
            if (this.mIsFromVideoTAb) {
                syncFloatBackGround(false);
            }
        }
    }

    @Override // c.a.q0.f1.m.i
    public void onPhoneClicked(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048629, this, context, str, str2) == null) {
        }
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048630, this, z2) == null) {
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, c.a.e.a.i
    public void onPreLoad(c.a.e.l.e.q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, qVar) == null) {
            PreLoadImageHelper.load(qVar, getUniqueId(), 3);
            PreLoadVideoHelper.load(qVar, getUniqueId(), this);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            this.mIsPaused = false;
            super.onResume();
            TiePlusEventController tiePlusEventController = this.tiePlusEventController;
            if (tiePlusEventController != null) {
                tiePlusEventController.onResume();
            }
            startBrowsePageMission();
            VoiceManager voiceManager = this.mVoiceManager;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            registerListener(this.richTextIntentClickListener);
            this.mSubPbView.d0();
            if (this.mIsFromVideoTAb) {
                syncFloatBackGround(true);
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (bundle == null || (subPbModel = this.mSubPbModel) == null) {
                return;
            }
            subPbModel.V0(bundle);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            if (this.mSubPbView.I0() && c.a.e.e.p.l.D()) {
                this.mSubPbModel.loadData();
            } else {
                this.mSubPbView.l0();
            }
        }
    }

    @Override // c.a.q0.f1.m.i
    public void onSongClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048635, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            super.onStop();
            VoiceManager voiceManager = this.mVoiceManager;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            this.mEditor.F();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048638, this, z2) == null) {
            super.onUserChanged(z2);
            PbMoreDialog pbMoreDialog = this.mPostMoreOptionView;
            if (pbMoreDialog != null) {
                pbMoreDialog.changeLoginStyle(z2);
            }
            c.a.r0.k2.k.g.a aVar = this.mSubPbView;
            if (aVar != null) {
                aVar.t(z2);
            }
        }
    }

    @Override // c.a.q0.f1.m.i
    public void onVideoClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048639, this, context, str) == null) {
        }
    }

    @Override // c.a.q0.f1.m.i
    public void onVideoP2PClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048640, this, context, str) == null) {
        }
    }

    public void stopVoice() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048641, this) == null) || (voiceManager = this.mVoiceManager) == null) {
            return;
        }
        voiceManager.stopPlay();
    }

    public void syncFloatBackGround(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048642, this, z2) == null) {
            CustomMessage customMessage = new CustomMessage(2921596);
            customMessage.setTag(this.mVideoPageUniqueId);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921596, Boolean.valueOf(z2));
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openEditor(PostData postData, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65623, this, postData, z2) == null) || checkIsIfPostForbid()) {
            return;
        }
        if (postData != null) {
            if (postData.t() != null) {
                MetaData t2 = postData.t();
                this.mEditor.X(t2.getUserId());
                boolean z3 = postData.m0;
                this.mEditor.p(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.t().getName_show(), postData.K() != null ? postData.K().toString() : ""));
                if (z3) {
                    if (!z2) {
                        this.mEditor.W(t2.getName_show(), t2.getPortrait());
                    }
                } else if (!z2) {
                    this.mEditor.W(t2.getName_show(), t2.getPortrait());
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
        if (!(interceptable == null || interceptable.invokeL(1048618, this, postData) == null) || postData == null) {
            return;
        }
        boolean z2 = false;
        if (this.mSubPbModel.K0() && postData.E() != null && postData.E().equals(this.mSubPbModel.s0())) {
            z2 = true;
        }
        MarkData r02 = this.mSubPbModel.r0(postData);
        if (r02 == null) {
            return;
        }
        this.mSubPbView.w();
        c.a.q0.i.a aVar = this.mMarkModel;
        if (aVar != null) {
            aVar.i(r02);
            if (!z2) {
                this.mMarkModel.a();
            } else {
                this.mMarkModel.d();
            }
        }
    }
}
