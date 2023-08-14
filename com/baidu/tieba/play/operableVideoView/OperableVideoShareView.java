package com.baidu.tieba.play.operableVideoView;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalForumInfo;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.bi;
import com.baidu.tieba.bu9;
import com.baidu.tieba.kv5;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.MessageFormat;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class OperableVideoShareView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public bu9 a;
    public View b;
    public ImageView c;
    public View d;
    public ImageView e;
    public View f;
    public ImageView g;
    public View h;
    public View i;
    public ImageView j;
    public ThreadData k;
    public int l;
    public View.OnClickListener m;

    public int getLayoutR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.operable_video_share_view : invokeV.intValue;
    }

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OperableVideoShareView a;

        public a(OperableVideoShareView operableVideoShareView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {operableVideoShareView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = operableVideoShareView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || kv5.a()) {
                return;
            }
            if (view2 != this.a.b) {
                if (view2 != this.a.d) {
                    if (view2 != this.a.f) {
                        return;
                    }
                    this.a.i(8);
                    return;
                }
                this.a.i(2);
                return;
            }
            this.a.i(3);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperableVideoShareView(Context context) {
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
        this.l = 3;
        this.m = new a(this);
        h();
    }

    public void setShareData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, threadData) == null) {
            this.k = threadData;
            if (threadData != null && !threadData.isUgcThreadType()) {
                this.f.setVisibility(0);
                this.b.setVisibility(0);
                this.d.setVisibility(0);
                this.h.setVisibility(0);
                return;
            }
            this.f.setVisibility(8);
            this.b.setVisibility(8);
            this.d.setVisibility(8);
            this.h.setVisibility(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperableVideoShareView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = 3;
        this.m = new a(this);
        h();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperableVideoShareView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.l = 3;
        this.m = new a(this);
        h();
    }

    public final int g(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData)) == null) {
            if (threadData != null) {
                if (threadData.isRealGod()) {
                    return 4;
                }
                if (threadData.getIsLive() == 1) {
                    return 3;
                }
                if (!threadData.isRealVideoThread()) {
                    return 1;
                }
                return 2;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public void setShareFrom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.l = i;
        }
    }

    public void setVideoContainer(bu9 bu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bu9Var) == null) {
            this.a = bu9Var;
            this.i.setOnClickListener(bu9Var);
        }
    }

    public void e(boolean z, boolean z2) {
        int dimens;
        int dimens2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.d.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.b.getLayoutParams();
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.f.getLayoutParams();
            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.h.getLayoutParams();
            LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.i.getLayoutParams();
            if (z2 && !z) {
                dimens = BdUtilHelper.getDimens(getContext(), R.dimen.tbds72);
                dimens2 = BdUtilHelper.getDimens(getContext(), R.dimen.tbds52);
            } else {
                dimens = BdUtilHelper.getDimens(getContext(), R.dimen.tbds36);
                dimens2 = BdUtilHelper.getDimens(getContext(), R.dimen.tbds26);
            }
            layoutParams4.rightMargin = dimens2;
            layoutParams4.leftMargin = dimens2;
            layoutParams5.rightMargin = dimens;
            layoutParams5.leftMargin = dimens;
            layoutParams3.rightMargin = dimens;
            layoutParams3.leftMargin = dimens;
            layoutParams2.rightMargin = dimens;
            layoutParams2.leftMargin = dimens;
            layoutParams.rightMargin = dimens;
            layoutParams.leftMargin = dimens;
        }
    }

    public final String f(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData)) == null) {
            if (threadData == null || threadData.getMedias() == null) {
                return null;
            }
            ArrayList<MediaData> medias = threadData.getMedias();
            int size = medias.size();
            for (int i = 0; i < size; i++) {
                MediaData mediaData = medias.get(i);
                if (mediaData != null && (mediaData.getType() == 3 || mediaData.getType() == 5)) {
                    if (!StringUtils.isNull(mediaData.getThumbnails_url())) {
                        return mediaData.getThumbnails_url();
                    }
                    if (!StringUtils.isNull(mediaData.getPicUrl())) {
                        return mediaData.getPicUrl();
                    }
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            LinearLayout.inflate(getContext(), getLayoutR(), this);
            this.b = findViewById(R.id.share_weixin);
            this.c = (ImageView) findViewById(R.id.share_weixin_img);
            this.d = findViewById(R.id.share_weixin_timeline);
            this.e = (ImageView) findViewById(R.id.share_weixin_timeline_img);
            this.f = findViewById(R.id.share_qq);
            this.g = (ImageView) findViewById(R.id.share_qq_img);
            this.h = findViewById(R.id.obfuscated_res_0x7f090908);
            this.i = findViewById(R.id.video_replay);
            this.j = (ImageView) findViewById(R.id.replay_img);
            this.b.setOnClickListener(this.m);
            this.d.setOnClickListener(this.m);
            this.f.setOnClickListener(this.m);
            setOnClickListener(this.m);
            this.c.setImageDrawable(SvgManager.getInstance().getDrawable(R.drawable.icon_mask_share_wechat40_svg, 1, false));
            this.e.setImageDrawable(SvgManager.getInstance().getDrawable(R.drawable.icon_mask_share_circle40_svg, 1, false));
            this.g.setImageDrawable(SvgManager.getInstance().getDrawable(R.drawable.icon_mask_share_qq40_svg, 1, false));
            this.j.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_replay44_svg, R.color.CAM_X0105, null, false));
            this.j.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(BdUtilHelper.getDimens(getContext(), R.dimen.tbds52), getResources().getColor(R.color.CAM_X0622)));
        }
    }

    public final void i(int i) {
        ThreadData threadData;
        Uri parse;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048581, this, i) != null) || (threadData = this.k) == null) {
            return;
        }
        String valueOf = String.valueOf(threadData.getFid());
        String forum_name = this.k.getForum_name();
        OriginalForumInfo originalForumInfo = this.k.mOriginalForumInfo;
        if (originalForumInfo != null) {
            valueOf = originalForumInfo.id;
            forum_name = originalForumInfo.ori_fname;
        }
        String title = this.k.getTitle();
        String tid = this.k.getTid();
        String str = TbConfig.HTTPS_PB_PREFIX + tid + "?share=9105&fr=share";
        String f = f(this.k);
        if (f == null) {
            parse = null;
        } else {
            parse = Uri.parse(f);
        }
        String str2 = this.k.getAbstract();
        String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), title, str2);
        ShareItem shareItem = new ShareItem();
        shareItem.title = title;
        shareItem.content = format;
        if (!this.k.isUgcThreadType() && this.k.isRealVideoThread() && this.k.getThreadVideoInfo() != null) {
            shareItem.readCount = this.k.getThreadVideoInfo().play_count.intValue();
        }
        shareItem.shareAbstract = str2;
        shareItem.linkUrl = str;
        shareItem.shareReportFrom = this.l;
        shareItem.extData = tid;
        shareItem.objParam1 = 3;
        if (this.k.isWorksInfo()) {
            i2 = 11;
        } else {
            i2 = 2;
        }
        shareItem.objParam2 = i2;
        if (i == 3) {
            shareItem.objParam3 = 1;
        } else if (i == 2) {
            shareItem.objParam3 = 2;
        } else if (i == 8) {
            shareItem.objParam3 = 3;
        } else {
            shareItem.objParam3 = 0;
        }
        shareItem.fid = valueOf;
        shareItem.fName = forum_name;
        shareItem.tid = tid;
        shareItem.nid = this.k.getNid();
        shareItem.isFromFeedVideoFinish = true;
        shareItem.objSource = 3;
        shareItem.obj_type = g(this.k);
        if (parse != null) {
            shareItem.imageUri = parse;
        }
        shareItem.originalThreadInfo = OriginalThreadInfo.ShareInfo.generateShareInfo(this.k);
        shareItem.forwardInfo = ShareItem.ForwardInfo.generateForwardInfo(this.k);
        shareItem.objLocate = 1;
        TbadkCoreApplication.getInst().setShareItem(shareItem);
        shareItem.smartAppShareImageUrl = this.k.getShareImageUrl();
        Bundle bundle = new Bundle();
        bundle.putString("tid", shareItem.tid);
        bundle.putString("fid", shareItem.fid);
        bundle.putInt("obj_type", shareItem.obj_type);
        bundle.putInt("obj_param1", shareItem.objParam1);
        bundle.putInt(TiebaStatic.Params.OBJ_PARAM2, shareItem.objParam2);
        bundle.putInt(TiebaStatic.Params.OBJ_PARAM3, shareItem.objParam3);
        bundle.putInt("obj_source", shareItem.shareReportFrom);
        bundle.putInt("obj_locate", shareItem.objLocate);
        shareItem.setStats(bundle);
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        statisticItem.param("tid", shareItem.tid);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("fid", shareItem.fid);
        statisticItem.param("obj_locate", this.l);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, shareItem.objParam3);
        statisticItem.param("nid", shareItem.nid);
        if (!bi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        TiebaStatic.log(statisticItem);
        MessageManager.getInstance().sendMessage(new ImplicitShareMessage(getContext(), i, shareItem, true));
    }
}
