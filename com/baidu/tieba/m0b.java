package com.baidu.tieba;

import android.location.Address;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.lbs.BdLocationMananger;
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
public class m0b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public BdUniqueId b;
    public l0b c;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class b extends BdAsyncTask<j0b, Integer, k0b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m0b a;

        public b(m0b m0bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m0bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m0bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(k0b k0bVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, k0bVar) == null) && this.a.c != null) {
                this.a.c.a(k0bVar);
            }
        }

        public /* synthetic */ b(m0b m0bVar, a aVar) {
            this(m0bVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public k0b doInBackground(j0b... j0bVarArr) {
            InterceptResult invokeL;
            j0b j0bVar;
            int netErrorCode;
            ImageUploadResult.picInfo picinfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, j0bVarArr)) == null) {
                String str = null;
                if (j0bVarArr.length == 0 || (j0bVar = j0bVarArr[0]) == null) {
                    return null;
                }
                zb zbVar = new zb("images", TbMd5.getNameMd5FromUrl(j0bVar.i + 42), DiskFileOperate.Action.READ);
                zbVar.setSubFolder(true);
                zbVar.setIsFormatData(false);
                ImageUploadResult uploadInBackground = new ImageUploader(null).uploadInBackground(c(zbVar.buildPath(), zbVar.getName()), true, false);
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
                    str = j0bVar.j;
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
                netWork.addPostData("content", j0bVar.m);
                netWork.addPostData("fid", j0bVar.e);
                netWork.addPostData(TiebaStatic.Params.H5_FORUM_NAME, j0bVar.f);
                netWork.addPostData("is_hide", "0");
                netWork.addPostData(IntentConfig.CALL_FROM, "2");
                netWork.addPostData("title", j0bVar.m);
                netWork.addPostData("is_ntitle", "1");
                netWork.addPostData("st_type", "notitle");
                netWork.addPostData("is_location", "2");
                Address address = BdLocationMananger.getInstance().getAddress(false);
                if (address != null && TbadkCoreApplication.getInst().getIsLocationOn()) {
                    netWork.addPostData("lbs", String.valueOf(address.getLatitude()) + "," + String.valueOf(address.getLongitude()));
                    netWork.addPostData(SuggestAddrField.KEY_LAT, String.valueOf(address.getLatitude()));
                    netWork.addPostData(SuggestAddrField.KEY_LNG, String.valueOf(address.getLongitude()));
                }
                LocationData b = sia.a().b();
                if (b != null) {
                    netWork.addPostData("name", b.getFormatted_address());
                    netWork.addPostData(ComboPraiseManager.PRAISE_SOURCE_PREFIX_HN_SN, b.getSn());
                }
                netWork.addPostData("is_link_thread", "0");
                if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                    netWork.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                }
                netWork.addPostData("tbopen_app_key", j0bVar.a);
                netWork.addPostData("tbopen_app_icon", j0bVar.d);
                netWork.addPostData("tbopen_app_name", j0bVar.c);
                netWork.addPostData("share_abstract", j0bVar.h);
                netWork.addPostData("share_image", str);
                netWork.addPostData("share_h5_url", j0bVar.k);
                netWork.addPostData("share_naws_app_key", j0bVar.b);
                netWork.addPostData("share_naws_path", j0bVar.l);
                String postNetData = netWork.postNetData();
                k0b k0bVar = new k0b();
                try {
                    JSONObject jSONObject = new JSONObject(postNetData);
                    jSONObject.optString("msg");
                    jSONObject.optString("pre_msg");
                    k0bVar.b = j0bVar.e;
                    k0bVar.c = jSONObject.optString("tid");
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
                    errorData.setError_msg(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0e40));
                }
                k0bVar.a = errorData;
                try {
                    new AntiData().parserJson(new JSONObject(postNetData).optJSONObject("anti_stat"));
                } catch (Exception unused2) {
                }
                return k0bVar;
            }
            return (k0b) invokeL.objValue;
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

    public m0b(BdUniqueId bdUniqueId) {
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

    public void c(l0b l0bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, l0bVar) == null) {
            this.c = l0bVar;
        }
    }

    public void d(j0b j0bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j0bVar) == null) {
            b bVar = new b(this, null);
            bVar.setTag(this.b);
            bVar.execute(j0bVar);
        }
    }
}
