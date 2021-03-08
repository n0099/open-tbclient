package com.baidu.tieba.write.share;

import android.location.Address;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.tencent.connect.common.Constants;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class f {
    private String mAppCachePath = BdBaseApplication.getInst().getContext().getCacheDir().getAbsolutePath() + "/";
    private BdUniqueId mPageId;
    private e oiW;

    public f(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }

    public void a(c cVar) {
        a aVar = new a();
        aVar.setTag(this.mPageId);
        aVar.execute(cVar);
    }

    public void a(e eVar) {
        this.oiW = eVar;
    }

    /* loaded from: classes7.dex */
    private class a extends BdAsyncTask<c, Integer, d> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public d doInBackground(c... cVarArr) {
            c cVar;
            String str = null;
            if (cVarArr.length == 0 || (cVar = cVarArr[0]) == null) {
                return null;
            }
            com.baidu.adp.lib.Disk.ops.c cVar2 = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, aw.getNameMd5FromUrl(cVar.imageUrl + 42), DiskFileOperate.Action.READ);
            cVar2.setSubFolder(true);
            cVar2.setIsFormatData(false);
            ImageUploadResult f = new com.baidu.tbadk.img.f(null).f(gP(cVar2.buildPath(), cVar2.getName()), true, false);
            if (f != null && f.picInfo != null) {
                if (f.picInfo.originPic != null && !StringUtils.isNull(f.picInfo.originPic.picUrl)) {
                    str = f.picInfo.originPic.picUrl;
                } else if (f.picInfo.bigPic != null && !StringUtils.isNull(f.picInfo.bigPic.picUrl)) {
                    str = f.picInfo.bigPic.picUrl;
                } else if (f.picInfo.smallPic != null && !StringUtils.isNull(f.picInfo.smallPic.picUrl)) {
                    str = f.picInfo.smallPic.picUrl;
                }
            }
            if (StringUtils.isNull(str)) {
                str = cVar.oiH;
            }
            aa aaVar = new aa();
            aaVar.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
            aaVar.bsu().btd().mIsNeedTbs = true;
            aaVar.addPostData("anonymous", "1");
            aaVar.addPostData("can_no_forum", "0");
            aaVar.addPostData("is_feedback", "0");
            if (TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() < 3) {
                aaVar.addPostData("vcode_tag", Constants.VIA_REPORT_TYPE_SET_AVATAR);
            }
            aaVar.addPostData("new_vcode", "1");
            aaVar.addPostData("content", cVar.comment);
            aaVar.addPostData("fid", cVar.forumId);
            aaVar.addPostData("kw", cVar.oiG);
            aaVar.addPostData("is_hide", "0");
            aaVar.addPostData("call_from", "2");
            aaVar.addPostData("title", cVar.comment);
            aaVar.addPostData("is_ntitle", "1");
            aaVar.addPostData("st_type", "notitle");
            aaVar.addPostData("is_location", "2");
            Address address = com.baidu.adp.lib.c.a.lH().getAddress(false);
            if (address != null && TbadkCoreApplication.getInst().getIsLocationOn() && !TbConfig.getPositionPagerId().equals(cVar.forumId)) {
                aaVar.addPostData("lbs", String.valueOf(address.getLatitude()) + "," + String.valueOf(address.getLongitude()));
                aaVar.addPostData("lat", String.valueOf(address.getLatitude()));
                aaVar.addPostData("lng", String.valueOf(address.getLongitude()));
            }
            LocationData locationData = com.baidu.tieba.tbadkCore.location.b.dOB().getLocationData();
            if (locationData != null) {
                aaVar.addPostData("name", locationData.getFormatted_address());
                aaVar.addPostData(IXAdRequestInfo.SN, locationData.getSn());
            }
            aaVar.addPostData("is_link_thread", "0");
            if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                aaVar.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
            }
            aaVar.addPostData("tbopen_app_key", cVar.appKey);
            aaVar.addPostData("tbopen_app_icon", cVar.eMr);
            aaVar.addPostData("tbopen_app_name", cVar.appName);
            aaVar.addPostData("share_abstract", cVar.content);
            aaVar.addPostData("share_image", str);
            aaVar.addPostData("share_h5_url", cVar.linkUrl);
            aaVar.addPostData("share_swan_app_key", cVar.oiF);
            aaVar.addPostData("share_swan_path", cVar.oiI);
            String postNetData = aaVar.postNetData();
            d dVar = new d();
            try {
                JSONObject jSONObject = new JSONObject(postNetData);
                dVar.oiK = jSONObject.optString("msg");
                dVar.preMsg = jSONObject.optString("pre_msg");
                dVar.fid = cVar.forumId;
                dVar.tid = jSONObject.optString("tid");
                dVar.pid = jSONObject.optString("pid");
                dVar.videoId = jSONObject.optString("video_id");
            } catch (Exception e) {
            }
            ErrorData errorData = new ErrorData();
            if (aaVar.bsu().bte().isRequestSuccess()) {
                errorData.parserJson(postNetData);
            } else {
                errorData.setError_code(aaVar.isNetSuccess() ? aaVar.getServerErrorCode() : aaVar.getNetErrorCode());
                errorData.setError_msg(aaVar.getErrorString());
            }
            if (errorData.error_code != 0 && !j.isNetWorkAvailable()) {
                errorData.setError_msg(TbadkCoreApplication.getInst().getApp().getString(R.string.neterror));
            }
            dVar.oiJ = errorData;
            AntiData antiData = new AntiData();
            try {
                antiData.parserJson(new JSONObject(postNetData).optJSONObject("anti_stat"));
            } catch (Exception e2) {
            }
            dVar.antiData = antiData;
            return dVar;
        }

        public String gP(String str, String str2) {
            String str3 = f.this.mAppCachePath + str2;
            if (str != null) {
                return f.this.mAppCachePath + str + "/" + str2;
            }
            return str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(d dVar) {
            if (f.this.oiW != null) {
                f.this.oiW.a(dVar);
            }
        }
    }
}
