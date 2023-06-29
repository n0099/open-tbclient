package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.resourceLoaderProc.EmotionShareLoaderProc;
import com.baidu.tbadk.switchs.QqShareH5Switch;
import com.baidu.tieba.kw9;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.share.QQShare;
import com.tencent.tauth.IUiListener;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class lw9 extends kw9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IUiListener p;
    public final qg<EmotionShareLoaderProc.EmotionShare> q;

    /* loaded from: classes6.dex */
    public class a extends qg<EmotionShareLoaderProc.EmotionShare> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lw9 a;

        public a(lw9 lw9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lw9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lw9Var;
        }

        @Override // com.baidu.tieba.qg
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                super.onCancelled(str);
                this.a.t(3, 4);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qg
        /* renamed from: a */
        public void onLoaded(EmotionShareLoaderProc.EmotionShare emotionShare, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, emotionShare, str, i) == null) {
                super.onLoaded(emotionShare, str, i);
                if (emotionShare == null || emotionShare.image == null || TextUtils.isEmpty(emotionShare.path)) {
                    this.a.t(2, 4);
                }
                if (emotionShare != null && !TextUtils.isEmpty(emotionShare.path)) {
                    this.a.O(emotionShare.path);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lw9(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = new a(this);
        this.l = 4;
    }

    public final void O(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("imageLocalUrl", str);
            bundle.putInt("req_type", 5);
            bundle.putInt("cflag", 1);
            IUiListener iUiListener = this.p;
            if (iUiListener != null) {
                this.k.shareToQQ((Activity) this.b, bundle, iUiListener);
            }
        }
    }

    public final void M(ShareEntity shareEntity, IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, shareEntity, iUiListener) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("req_type", 7);
            bundle.putString("title", sw9.a(this.b));
            if (!StringUtils.isNull(shareEntity.getTitle())) {
                bundle.putString("summary", shareEntity.getTitle());
            } else if (!StringUtils.isNull(shareEntity.getContent())) {
                bundle.putString("summary", shareEntity.getContent());
            } else {
                bundle.putString("summary", this.b.getString(R.string.obfuscated_res_0x7f0f1385));
            }
            bundle.putString("targetUrl", shareEntity.getLinkUrl());
            ArrayList<String> arrayList = new ArrayList<>();
            if (!TextUtils.isEmpty(shareEntity.getImgUrl())) {
                arrayList.add(shareEntity.getImgUrl());
            } else {
                arrayList.add("http://tb3.bdstatic.com/public/img/fcf10e29473417fa5e0d4a1e6.fcf10e29.png");
            }
            bundle.putStringArrayList("imageUrl", arrayList);
            bundle.putString(QQShare.SHARE_TO_QQ_MINI_PROGRAM_APPID, "1111264064");
            bundle.putString(QQShare.SHARE_TO_QQ_MINI_PROGRAM_TYPE, "3");
            bundle.putString(QQShare.SHARE_TO_QQ_MINI_PROGRAM_PATH, "pages/pb/pb?tid=" + shareEntity.getTid());
            if (iUiListener != null) {
                this.k.shareToQzone((Activity) this.b, bundle, iUiListener);
            }
        }
    }

    public final void N(ShareEntity shareEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shareEntity) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("req_type", 1);
            bundle.putString("title", shareEntity.getTitle());
            bundle.putString("summary", shareEntity.getContent());
            bundle.putString("targetUrl", shareEntity.getLinkUrl());
            ArrayList<String> arrayList = new ArrayList<>();
            if (!TextUtils.isEmpty(shareEntity.getImgUrl())) {
                arrayList.add(shareEntity.getImgUrl());
            }
            bundle.putStringArrayList("imageUrl", arrayList);
            IUiListener iUiListener = this.p;
            if (iUiListener != null) {
                this.k.shareToQzone((Activity) this.b, bundle, iUiListener);
            }
        }
    }

    public final void P(ShareEntity shareEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, shareEntity) == null) {
            if (p(shareEntity.getLocalFile())) {
                O(shareEntity.getLocalFile());
            } else if (o(shareEntity.getImageUri())) {
                O(shareEntity.getImageUri().getPath());
            } else {
                rg.h().k(shareEntity.getImgUrl(), 34, this.q, 0, 0, j(), new Object[0]);
            }
        }
    }

    @Override // com.baidu.tieba.kw9, com.baidu.tieba.pw9
    public void a(ShareEntity shareEntity, qw9 qw9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, shareEntity, qw9Var) == null) {
            if (shareEntity != null && this.k != null) {
                this.e = shareEntity;
                Context context = this.b;
                if (context != null && (context instanceof Activity)) {
                    this.p = new kw9.c(this, qw9Var);
                    if (!QqShareH5Switch.isOn() && !StringUtils.isNull(shareEntity.getTid()) && !"0".equals(shareEntity.getTid())) {
                        M(shareEntity, this.p);
                        return;
                    } else if (shareEntity.getShareType() != 0) {
                        P(shareEntity);
                        return;
                    } else {
                        N(shareEntity);
                        return;
                    }
                }
                t(2, 4);
                if (qw9Var != null) {
                    qw9Var.c1(0, 2);
                    return;
                }
                return;
            }
            t(2, 4);
            if (qw9Var != null) {
                qw9Var.c1(0, 2);
            }
        }
    }
}
