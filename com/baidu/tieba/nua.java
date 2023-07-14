package com.baidu.tieba;

import android.location.Address;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.searchbox.ui.animview.praise.ComboPraiseManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.ImageUploader;
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class nua {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public BdUniqueId b;
    public mua c;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class b extends BdAsyncTask<kua, Integer, lua> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nua a;

        public b(nua nuaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nuaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nuaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(lua luaVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, luaVar) == null) && this.a.c != null) {
                this.a.c.a(luaVar);
            }
        }

        public /* synthetic */ b(nua nuaVar, a aVar) {
            this(nuaVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public lua doInBackground(kua... kuaVarArr) {
            InterceptResult invokeL;
            kua kuaVar;
            int netErrorCode;
            ImageUploadResult.picInfo picinfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, kuaVarArr)) == null) {
                String str = null;
                if (kuaVarArr.length == 0 || (kuaVar = kuaVarArr[0]) == null) {
                    return null;
                }
                jc jcVar = new jc("images", TbMd5.getNameMd5FromUrl(kuaVar.i + 42), DiskFileOperate.Action.READ);
                jcVar.setSubFolder(true);
                jcVar.setIsFormatData(false);
                ImageUploadResult uploadInBackground = new ImageUploader(null).uploadInBackground(c(jcVar.buildPath(), jcVar.getName()), true, false);
                if (uploadInBackground != null && (picinfo = uploadInBackground.picInfo) != null) {
                    ImageUploadResult.PicDetailedInfo picDetailedInfo = picinfo.originPic;
                    if (picDetailedInfo != null && !StringUtils.isNull(picDetailedInfo.picUrl)) {
                        str = uploadInBackground.picInfo.originPic.picUrl;
                    } else {
                        ImageUploadResult.PicDetailedInfo picDetailedInfo2 = uploadInBackground.picInfo.bigPic;
                        if (picDetailedInfo2 != null && !StringUtils.isNull(picDetailedInfo2.picUrl)) {
                            str = uploadInBackground.picInfo.bigPic.picUrl;
                        } else {
                            ImageUploadResult.PicDetailedInfo picDetailedInfo3 = uploadInBackground.picInfo.smallPic;
                            if (picDetailedInfo3 != null && !StringUtils.isNull(picDetailedInfo3.picUrl)) {
                                str = uploadInBackground.picInfo.smallPic.picUrl;
                            }
                        }
                    }
                }
                if (StringUtils.isNull(str)) {
                    str = kuaVar.j;
                }
                NetWork netWork = new NetWork();
                netWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                netWork.getNetContext().getRequest().mIsNeedTbs = true;
                netWork.addPostData("anonymous", "1");
                netWork.addPostData("can_no_forum", "0");
                netWork.addPostData("is_feedback", "0");
                if (TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() < 3) {
                    netWork.addPostData("vcode_tag", "12");
                }
                netWork.addPostData("new_vcode", "1");
                netWork.addPostData("content", kuaVar.m);
                netWork.addPostData("fid", kuaVar.e);
                netWork.addPostData(TiebaStatic.Params.H5_FORUM_NAME, kuaVar.f);
                netWork.addPostData("is_hide", "0");
                netWork.addPostData(IntentConfig.CALL_FROM, "2");
                netWork.addPostData("title", kuaVar.m);
                netWork.addPostData("is_ntitle", "1");
                netWork.addPostData("st_type", "notitle");
                netWork.addPostData("is_location", "2");
                Address j = sf.n().j(false);
                if (j != null && TbadkCoreApplication.getInst().getIsLocationOn()) {
                    netWork.addPostData("lbs", String.valueOf(j.getLatitude()) + "," + String.valueOf(j.getLongitude()));
                    netWork.addPostData(SuggestAddrField.KEY_LAT, String.valueOf(j.getLatitude()));
                    netWork.addPostData(SuggestAddrField.KEY_LNG, String.valueOf(j.getLongitude()));
                }
                LocationData b = wda.a().b();
                if (b != null) {
                    netWork.addPostData("name", b.getFormatted_address());
                    netWork.addPostData(ComboPraiseManager.PRAISE_SOURCE_PREFIX_HN_SN, b.getSn());
                }
                netWork.addPostData("is_link_thread", "0");
                if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                    netWork.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                }
                netWork.addPostData("tbopen_app_key", kuaVar.a);
                netWork.addPostData("tbopen_app_icon", kuaVar.d);
                netWork.addPostData("tbopen_app_name", kuaVar.c);
                netWork.addPostData("share_abstract", kuaVar.h);
                netWork.addPostData("share_image", str);
                netWork.addPostData("share_h5_url", kuaVar.k);
                netWork.addPostData("share_naws_app_key", kuaVar.b);
                netWork.addPostData("share_naws_path", kuaVar.l);
                String postNetData = netWork.postNetData();
                lua luaVar = new lua();
                try {
                    JSONObject jSONObject = new JSONObject(postNetData);
                    jSONObject.optString("msg");
                    jSONObject.optString("pre_msg");
                    luaVar.b = kuaVar.e;
                    luaVar.c = jSONObject.optString("tid");
                    jSONObject.optString("pid");
                    jSONObject.optString("video_id");
                } catch (Exception unused) {
                }
                ErrorData errorData = new ErrorData();
                if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                    errorData.parserJson(postNetData);
                } else {
                    if (netWork.isNetSuccess()) {
                        netErrorCode = netWork.getServerErrorCode();
                    } else {
                        netErrorCode = netWork.getNetErrorCode();
                    }
                    errorData.setError_code(netErrorCode);
                    errorData.setError_msg(netWork.getErrorString());
                }
                if (errorData.error_code != 0 && !BdNetTypeUtil.isNetWorkAvailable()) {
                    errorData.setError_msg(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0e1f));
                }
                luaVar.a = errorData;
                try {
                    new AntiData().parserJson(new JSONObject(postNetData).optJSONObject("anti_stat"));
                } catch (Exception unused2) {
                }
                return luaVar;
            }
            return (lua) invokeL.objValue;
        }

        public String c(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
                String str3 = this.a.a + str2;
                if (str != null) {
                    return this.a.a + str + "/" + str2;
                }
                return str3;
            }
            return (String) invokeLL.objValue;
        }
    }

    public nua(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = BdBaseApplication.getInst().getContext().getCacheDir().getAbsolutePath() + "/";
        this.b = bdUniqueId;
    }

    public void c(mua muaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, muaVar) == null) {
            this.c = muaVar;
        }
    }

    public void d(kua kuaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kuaVar) == null) {
            b bVar = new b(this, null);
            bVar.setTag(this.b);
            bVar.execute(kuaVar);
        }
    }
}
