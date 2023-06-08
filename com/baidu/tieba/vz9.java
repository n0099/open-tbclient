package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class vz9 implements tz9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public String b;
    public String c;
    public final int d;
    public int e;
    public wz9 f;
    public boolean g;
    public xz9 h;
    public sx8 i;

    public vz9(String str, int i, sx8 sx8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), sx8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = str;
        this.d = i;
        this.i = sx8Var;
        File file = new File(str);
        if (!file.exists()) {
            return;
        }
        this.a = file.length();
        this.b = cj.b(FileHelper.GetStreamFromFile(file));
        long j = this.a;
        int i4 = this.d;
        if (j % i4 == 0) {
            this.e = (int) (j / i4);
        } else {
            this.e = ((int) (j / i4)) + 1;
        }
    }

    public final a0a g(ArrayList<Integer> arrayList, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048583, this, arrayList, str, i)) == null) {
            if (ListUtils.isEmpty(arrayList) || StringUtils.isNull(str)) {
                return null;
            }
            if (arrayList.size() > 3) {
                this.h = new yz9(this.c, this.d, this.e, this.a, this.b);
            } else {
                this.h = new zz9(this.c, this.d, this.e, this.a, this.b);
            }
            this.h.f(this.f);
            a0a g = this.h.g(arrayList, str, i);
            this.h = null;
            return g;
        }
        return (a0a) invokeLLI.objValue;
    }

    @Override // com.baidu.tieba.tz9
    public void a(wz9 wz9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, wz9Var) == null) {
            this.f = wz9Var;
        }
    }

    public final void d(int i) {
        wz9 wz9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && (wz9Var = this.f) != null) {
            wz9Var.onProgressUpdate(i / 100.0f);
        }
    }

    @Override // com.baidu.tieba.tz9
    public VideoFinishResult b(String str, int i) {
        InterceptResult invokeLI;
        sz9 c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i)) == null) {
            if (StringUtils.isNull(str) || this.a <= 0 || StringUtils.isNull(this.b) || i <= 0 || this.g) {
                return null;
            }
            d(10);
            long j = i;
            sz9 c2 = c(this.e, j, false, null);
            if (c2 != null && !this.g) {
                if (c2.e != 0) {
                    VideoFinishResult videoFinishResult = new VideoFinishResult();
                    videoFinishResult.setErrorNo(c2.e);
                    videoFinishResult.setUserMessage(c2.d);
                    e(302, c2.e, c2.d);
                    return videoFinishResult;
                }
                d(30);
                if (!StringUtils.isNull(c2.c)) {
                    VideoFinishResult videoFinishResult2 = new VideoFinishResult();
                    videoFinishResult2.setVideoMd5(this.b);
                    videoFinishResult2.setVideoUrl(c2.c);
                    f();
                    return videoFinishResult2;
                } else if (this.g) {
                    return null;
                } else {
                    ArrayList<Integer> arrayList = c2.a;
                    if (ListUtils.isEmpty(arrayList)) {
                        arrayList = new ArrayList<>();
                        int i2 = 0;
                        while (i2 < this.e) {
                            i2++;
                            arrayList.add(Integer.valueOf(i2));
                        }
                    }
                    String str2 = c2.b;
                    a0a g = g(arrayList, str2, i);
                    if (g != null && !this.g) {
                        if (g.b != 0) {
                            VideoFinishResult videoFinishResult3 = new VideoFinishResult();
                            videoFinishResult3.setErrorNo(g.b);
                            videoFinishResult3.setUserMessage(g.c);
                            e(303, g.b, g.c);
                            return videoFinishResult3;
                        }
                        d(85);
                        if (!StringUtils.isNull(g.a)) {
                            VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                            videoFinishResult4.setVideoUrl(g.a);
                            videoFinishResult4.setVideoMd5(this.b);
                            f();
                            return videoFinishResult4;
                        } else if (this.g || (c = c(this.e, j, true, str2)) == null) {
                            return null;
                        } else {
                            VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                            int i3 = c.e;
                            if (i3 == 0) {
                                videoFinishResult5.setVideoUrl(c.c);
                                videoFinishResult5.setVideoMd5(this.b);
                                f();
                            } else {
                                videoFinishResult5.setErrorNo(i3);
                                videoFinishResult5.setUserMessage(c.d);
                                e(304, c.e, c.d);
                                TiebaStatic.log(new StatisticItem("c12024").param("params", c.d));
                            }
                            d(100);
                            return videoFinishResult5;
                        }
                    }
                }
            }
            return null;
        }
        return (VideoFinishResult) invokeLI.objValue;
    }

    public final sz9 c(int i, long j, boolean z, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Boolean.valueOf(z), str})) == null) {
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
            netWork.addPostData("chunk_sum", String.valueOf(i));
            netWork.addPostData("video_size", String.valueOf(this.a));
            netWork.addPostData("chunk_size", String.valueOf(this.d));
            netWork.addPostData("is_merge", String.valueOf(z ? 1 : 0));
            netWork.addPostData(VideoFinishResult.KEY_VIDEO_MD5, this.b);
            netWork.addPostData("video_len", String.valueOf(j));
            netWork.addPostData("tbs", TbadkCoreApplication.getInst().getTbs());
            if (!StringUtils.isNull(str)) {
                netWork.addPostData("upload_id", str);
            }
            String postNetData = netWork.postNetData();
            if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                if (StringUtils.isNull(postNetData)) {
                    return null;
                }
                sz9 sz9Var = new sz9();
                sz9Var.a(postNetData);
                return sz9Var;
            }
            sz9 sz9Var2 = new sz9();
            if (netWork.getNetContext().getResponse().isNetSuccess()) {
                sz9Var2.e = netWork.getNetContext().getResponse().mServerErrorCode;
            } else {
                sz9Var2.e = netWork.getNetContext().getResponse().mNetErrorCode;
            }
            sz9Var2.d = netWork.getNetContext().getResponse().mErrorString;
            return sz9Var2;
        }
        return (sz9) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.tz9
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.g = true;
            xz9 xz9Var = this.h;
            if (xz9Var != null) {
                xz9Var.a();
            }
        }
    }

    public final void f() {
        sx8 sx8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (sx8Var = this.i) != null) {
            sx8Var.j();
        }
    }

    public final void e(int i, int i2, String str) {
        sx8 sx8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048581, this, i, i2, str) == null) && (sx8Var = this.i) != null) {
            sx8Var.f(i, i2, str);
        }
    }
}
