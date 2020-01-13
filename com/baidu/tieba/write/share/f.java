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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class f {
    private e kOz;
    private String mAppCachePath = BdBaseApplication.getInst().getContext().getCacheDir().getAbsolutePath() + "/";
    private BdUniqueId mPageId;

    public f(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }

    public void a(c cVar) {
        a aVar = new a();
        aVar.setTag(this.mPageId);
        aVar.execute(cVar);
    }

    public void a(e eVar) {
        this.kOz = eVar;
    }

    /* loaded from: classes11.dex */
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
            com.baidu.adp.lib.Disk.ops.c cVar2 = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, as.getNameMd5FromUrl(cVar.imageUrl + 42), DiskFileOperate.Action.READ);
            cVar2.setSubFolder(true);
            cVar2.setIsFormatData(false);
            ImageUploadResult f = new com.baidu.tbadk.img.f(null).f(eH(cVar2.buildPath(), cVar2.getName()), true, false);
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
                str = cVar.kOi;
            }
            x xVar = new x();
            xVar.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
            xVar.aDU().aEu().mIsNeedTbs = true;
            xVar.addPostData("anonymous", "1");
            xVar.addPostData("can_no_forum", "0");
            xVar.addPostData("is_feedback", "0");
            if (TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() < 3) {
                xVar.addPostData("vcode_tag", "12");
            }
            xVar.addPostData("new_vcode", "1");
            xVar.addPostData("content", cVar.wo);
            xVar.addPostData("fid", cVar.forumId);
            xVar.addPostData("kw", cVar.kOh);
            xVar.addPostData("is_hide", "0");
            xVar.addPostData("call_from", "2");
            xVar.addPostData("title", cVar.wo);
            xVar.addPostData("is_ntitle", "1");
            xVar.addPostData("st_type", "notitle");
            xVar.addPostData("is_location", "2");
            Address address = com.baidu.adp.lib.c.a.fK().getAddress(false);
            if (address != null && TbadkCoreApplication.getInst().getIsLocationOn() && !TbConfig.getPositionPagerId().equals(cVar.forumId)) {
                xVar.addPostData("lbs", String.valueOf(address.getLatitude()) + Constants.ACCEPT_TIME_SEPARATOR_SP + String.valueOf(address.getLongitude()));
                xVar.addPostData("lat", String.valueOf(address.getLatitude()));
                xVar.addPostData("lng", String.valueOf(address.getLongitude()));
            }
            com.baidu.tieba.tbadkCore.location.a locationData = com.baidu.tieba.tbadkCore.location.c.cKe().getLocationData();
            if (locationData != null) {
                xVar.addPostData("name", locationData.cKc());
                xVar.addPostData(IXAdRequestInfo.SN, locationData.getSn());
            }
            xVar.addPostData("is_link_thread", "0");
            if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                xVar.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
            }
            xVar.addPostData("tbopen_app_key", cVar.appKey);
            xVar.addPostData("tbopen_app_icon", cVar.kOg);
            xVar.addPostData("tbopen_app_name", cVar.appName);
            xVar.addPostData("share_abstract", cVar.content);
            xVar.addPostData("share_image", str);
            xVar.addPostData("share_h5_url", cVar.linkUrl);
            xVar.addPostData("share_swan_app_key", cVar.kOf);
            xVar.addPostData("share_swan_path", cVar.kOj);
            String postNetData = xVar.postNetData();
            d dVar = new d();
            try {
                JSONObject jSONObject = new JSONObject(postNetData);
                dVar.kOl = jSONObject.optString("msg");
                dVar.preMsg = jSONObject.optString("pre_msg");
                dVar.fid = cVar.forumId;
                dVar.tid = jSONObject.optString("tid");
                dVar.pid = jSONObject.optString("pid");
                dVar.videoId = jSONObject.optString("video_id");
            } catch (Exception e) {
            }
            ErrorData errorData = new ErrorData();
            if (xVar.aDU().aEv().isRequestSuccess()) {
                errorData.parserJson(postNetData);
            } else {
                errorData.setError_code(xVar.isNetSuccess() ? xVar.getServerErrorCode() : xVar.getNetErrorCode());
                errorData.setError_msg(xVar.getErrorString());
            }
            if (errorData.error_code != 0 && !j.isNetWorkAvailable()) {
                errorData.setError_msg(TbadkCoreApplication.getInst().getApp().getString(R.string.neterror));
            }
            dVar.kOk = errorData;
            AntiData antiData = new AntiData();
            try {
                antiData.parserJson(new JSONObject(postNetData).optJSONObject("anti_stat"));
            } catch (Exception e2) {
            }
            dVar.antiData = antiData;
            return dVar;
        }

        public String eH(String str, String str2) {
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
            if (f.this.kOz != null) {
                f.this.kOz.a(dVar);
            }
        }
    }
}
