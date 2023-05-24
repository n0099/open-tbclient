package com.baidu.tieba;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.codec.language.bm.ResourceConstants;
/* loaded from: classes8.dex */
public class w48 extends x48<ThreadData> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context m;
    public LinearLayout n;
    public FrameLayout o;
    public GifView p;
    public TbImageView q;
    public TextView r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w48(@NonNull Context context) {
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
        this.m = context;
        t(context);
    }

    @Override // com.baidu.tieba.q48
    public void a(String str) {
        boolean z;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            ThreadData threadData = (ThreadData) this.j;
            long userIdLong = this.k.getUserIdLong();
            String userName = this.k.getUserName();
            String name_show = this.k.getName_show();
            String portrait = this.k.getPortrait();
            if (this.k.getIsMyFriend() == 1) {
                z = true;
            } else {
                z = false;
            }
            x58.d(threadData, str, userIdLong, userName, name_show, portrait, z);
            ic5.e(this.k.getUserIdLong());
            if (((ThreadData) this.j).threadType == 40) {
                i = 2;
            } else {
                i = 1;
            }
            p(1, 0, i, String.valueOf(this.k.getUserIdLong()));
        }
    }

    @Override // com.baidu.tieba.q48
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            x58.j(str, this.k.groupData, (ThreadData) this.j);
        }
    }

    @Override // com.baidu.tieba.x48
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.g();
            p45 d = p45.d(this.n);
            d.o(R.string.J_X05);
            d.f(R.color.CAM_X0207);
            p45.d(this.r).w(R.color.CAM_X0107);
        }
    }

    public final void r(ThreadData threadData, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, threadData, charSequence) == null) && threadData.isVoiceThreadType()) {
            String str = ((Object) charSequence) + this.m.getString(R.string.im_share_voice_info);
        }
    }

    public final void s(ThreadData threadData, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, threadData, charSequence) == null) && threadData.getPollData() != null) {
            String str = ((Object) charSequence) + this.m.getString(R.string.im_share_vote_info);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.x48
    /* renamed from: w */
    public void o(ThreadData threadData, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, threadData, metaData) == null) {
            super.o(threadData, metaData);
            if (threadData == null) {
                return;
            }
            this.q.setVisibility(8);
            u(threadData);
            v(threadData);
        }
    }

    public final CharSequence q(ThreadData threadData, CharSequence charSequence) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, threadData, charSequence)) == null) {
            if (threadData != null && threadData.isShareThread && threadData.originalThreadData != null) {
                SpannableStringBuilder append = new SpannableStringBuilder(charSequence).append((CharSequence) ResourceConstants.CMT);
                OriginalThreadInfo originalThreadInfo = threadData.originalThreadData;
                return new SpannableString(append.append((CharSequence) new SpannableString(nx5.J(originalThreadInfo.s, originalThreadInfo.E, false, threadData, originalThreadInfo.h()))));
            }
            return charSequence;
        }
        return (CharSequence) invokeLL.objValue;
    }

    public final void t(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.im_share_dialog_thread, i());
            this.n = (LinearLayout) inflate.findViewById(R.id.im_share_thread_info_container);
            this.o = (FrameLayout) inflate.findViewById(R.id.im_share_thread_info_img_container);
            GifView gifView = (GifView) inflate.findViewById(R.id.im_share_thread_info_img);
            this.p = gifView;
            gifView.setConrers(15);
            this.p.setRadiusById(R.string.J_X04);
            this.p.setDrawCorner(true);
            this.p.setDrawBorder(true);
            this.p.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.L_X01));
            this.p.setBorderSurroundContent(true);
            this.p.setAutoPlay(true);
            this.p.setShowStaticDrawable(false);
            this.p.setSupportNoImage(false);
            this.p.setGifIconSupport(true);
            this.q = (TbImageView) inflate.findViewById(R.id.im_share_thread_info_video_icon);
            this.r = (TextView) inflate.findViewById(R.id.im_share_thread_info_text);
            g();
        }
    }

    public final void u(ThreadData threadData) {
        MediaData mediaData;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, threadData) == null) {
            if (threadData.getThreadType() == 40 && threadData.getThreadVideoInfo() != null) {
                str = threadData.getThreadVideoInfo().thumbnail_url;
                this.q.setVisibility(0);
                this.q.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pb_post_share_voide_thread_play, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
            } else {
                new MediaData();
                if (threadData.isImShareFromPb()) {
                    OriginalThreadInfo originalThreadInfo = threadData.originalThreadData;
                    if (originalThreadInfo != null && !ListUtils.isEmpty(originalThreadInfo.h)) {
                        mediaData = threadData.originalThreadData.h.get(0);
                        mediaData.setSrc_pic(threadData.originalThreadData.c);
                    } else {
                        this.o.setVisibility(8);
                        return;
                    }
                } else if (ListUtils.isEmpty(threadData.getMedias())) {
                    this.o.setVisibility(8);
                    return;
                } else {
                    mediaData = threadData.getMedias().get(0);
                }
                if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                    str = mediaData.getSrc_pic();
                } else if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    str = mediaData.getPicUrl();
                } else {
                    str = null;
                }
            }
            if (TextUtils.isEmpty(str)) {
                this.o.setVisibility(8);
                return;
            }
            this.p.setVisibility(0);
            this.p.m0(str, 38);
        }
    }

    public final void v(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, threadData) == null) {
            CharSequence string = this.m.getString(R.string.im_share_default_info);
            if (!TextUtils.isEmpty(threadData.getTitleText()) && threadData.getIsNoTitle() == 0) {
                string = q(threadData, threadData.getTitleText());
            } else if (!TextUtils.isEmpty(threadData.getTitle()) && threadData.getIsNoTitle() == 0) {
                string = q(threadData, threadData.getTitle());
            } else if (!TextUtils.isEmpty(threadData.getAbstractText())) {
                string = q(threadData, threadData.getAbstractText());
                r(threadData, string);
                s(threadData, string);
            } else if (!TextUtils.isEmpty(threadData.getAbstract())) {
                string = q(threadData, threadData.getAbstract());
                r(threadData, string);
                s(threadData, string);
            } else if (threadData.isImShareFromPb() && threadData.getPbFirstShareData() != null && threadData.getPbFirstShareData().a0() != null) {
                string = threadData.getPbFirstShareData().a0().toString();
            }
            this.r.setText(string);
        }
    }
}
