package com.baidu.tieba;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbPostShareDialogConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class z09 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public b b;

    /* loaded from: classes7.dex */
    public interface b {
        void a(qv8 qv8Var, ThreadData threadData, pp9 pp9Var, xv5 xv5Var);
    }

    /* loaded from: classes7.dex */
    public class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z09 a;

        public a(z09 z09Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z09Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z09Var;
        }

        @Override // com.baidu.tieba.z09.b
        public void a(qv8 qv8Var, ThreadData threadData, pp9 pp9Var, xv5 xv5Var) {
            String e;
            String tid;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, qv8Var, threadData, pp9Var, xv5Var) == null) {
                if ((qv8Var != null || threadData != null) && pp9Var != null && this.a.a != null) {
                    if (qv8Var != null) {
                        String str2 = qv8Var.L(false)[0];
                        if (!StringUtils.isNull(str2) && str2.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                            str2 = str2.substring(37);
                        }
                        ThreadData M = qv8Var.M();
                        if (M == null) {
                            return;
                        }
                        String str3 = str2;
                        threadData = M;
                        e = str3;
                    } else {
                        e = this.a.e(threadData);
                    }
                    cw8 cw8Var = new cw8();
                    cw8Var.h(threadData.getAbstract());
                    if (!StringUtils.isNull(e)) {
                        cw8Var.k(e);
                    }
                    cw8Var.l(threadData.getThreadType());
                    cw8Var.g(xv5Var);
                    cw8Var.i(pp9Var);
                    String title = threadData.getTitle();
                    if (StringUtils.isNull(title)) {
                        title = threadData.getAbstract();
                    }
                    cw8Var.h(title);
                    if (threadData.isUgcThreadType()) {
                        tid = threadData.getBaijiahaoData().oriUgcTid;
                        str = "?share=9105&fr=dshare&dtype=" + threadData.getBaijiahaoData().oriUgcType + "&dvid=" + threadData.getBaijiahaoData().oriUgcVid + "&nid=" + threadData.getBaijiahaoData().oriUgcNid;
                    } else {
                        tid = threadData.getTid();
                        str = "?share=9105&fr=share";
                    }
                    cw8Var.j(this.a.d(TbConfig.HTTPS_PB_PREFIX + tid + (str + "&post_id=" + pp9Var.N() + "&share_from=comment&post_sort=1")));
                    ShareItem shareItem = new ShareItem();
                    shareItem.k0 = 1;
                    shareItem.k = true;
                    shareItem.u = tid;
                    shareItem.f0 = pp9Var.N();
                    Bundle bundle = new Bundle();
                    bundle.putString("tid", tid);
                    bundle.putString("pid", pp9Var.N());
                    bundle.putInt("source", 1);
                    shareItem.l(bundle);
                    PbPostShareDialogConfig pbPostShareDialogConfig = new PbPostShareDialogConfig(this.a.a.getPageActivity(), shareItem, true, cw8Var);
                    pbPostShareDialogConfig.setIsCopyLink(false);
                    pbPostShareDialogConfig.setHideMode(pbPostShareDialogConfig.hideMode | 32);
                    this.a.a.sendMessage(new CustomMessage(2001276, pbPostShareDialogConfig));
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                    statisticItem.param("tid", tid);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (threadData.getForumData() != null) {
                        statisticItem.param("fid", threadData.getForumData().a);
                    }
                    if (threadData.getTopAgreePost() != null) {
                        statisticItem.param("post_id", pp9Var.N());
                    }
                    statisticItem.param("obj_locate", 21);
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    public z09(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new a(this);
        this.a = tbPageContext;
    }

    public final Bitmap d(String str) {
        InterceptResult invokeL;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null || str.length() == 0 || (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) == null || runTask.getData() == null) {
                return null;
            }
            return (Bitmap) runTask.getData();
        }
        return (Bitmap) invokeL.objValue;
    }

    public final String e(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData)) == null) {
            String str = null;
            if (threadData == null) {
                return null;
            }
            if (threadData.getThreadAlaInfo() != null && !TextUtils.isEmpty(threadData.getThreadAlaInfo().cover)) {
                return threadData.getThreadAlaInfo().cover;
            }
            if (threadData.getMedias() == null) {
                return null;
            }
            ArrayList<MediaData> medias = threadData.getMedias();
            int size = medias.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                MediaData mediaData = medias.get(i);
                if (mediaData != null && (mediaData.getType() == 3 || mediaData.getType() == 5)) {
                    if (!StringUtils.isNull(mediaData.getThumbnails_url())) {
                        str = mediaData.getThumbnails_url();
                        break;
                    } else if (!StringUtils.isNull(mediaData.getPicUrl())) {
                        str = mediaData.getPicUrl();
                        break;
                    }
                }
                i++;
            }
            if (str == null && threadData.getThreadVideoInfo() != null && !TextUtils.isEmpty(threadData.getThreadVideoInfo().thumbnail_url)) {
                return threadData.getThreadVideoInfo().thumbnail_url;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }
}
