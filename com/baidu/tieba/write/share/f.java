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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f {
    private String mAppCachePath = BdBaseApplication.getInst().getContext().getCacheDir().getAbsolutePath() + "/";
    private BdUniqueId mPageId;
    private e mpW;

    public f(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }

    public void a(c cVar) {
        a aVar = new a();
        aVar.setTag(this.mPageId);
        aVar.execute(cVar);
    }

    public void a(e eVar) {
        this.mpW = eVar;
    }

    /* loaded from: classes2.dex */
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
            com.baidu.adp.lib.Disk.ops.c cVar2 = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, at.getNameMd5FromUrl(cVar.imageUrl + 42), DiskFileOperate.Action.READ);
            cVar2.setSubFolder(true);
            cVar2.setIsFormatData(false);
            ImageUploadResult f = new com.baidu.tbadk.img.f(null).f(fO(cVar2.buildPath(), cVar2.getName()), true, false);
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
                str = cVar.mpG;
            }
            y yVar = new y();
            yVar.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
            yVar.aWu().aWV().mIsNeedTbs = true;
            yVar.addPostData("anonymous", "1");
            yVar.addPostData("can_no_forum", "0");
            yVar.addPostData("is_feedback", "0");
            if (TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() < 3) {
                yVar.addPostData("vcode_tag", "12");
            }
            yVar.addPostData("new_vcode", "1");
            yVar.addPostData("content", cVar.Qx);
            yVar.addPostData("fid", cVar.forumId);
            yVar.addPostData("kw", cVar.mpF);
            yVar.addPostData("is_hide", "0");
            yVar.addPostData("call_from", "2");
            yVar.addPostData("title", cVar.Qx);
            yVar.addPostData("is_ntitle", "1");
            yVar.addPostData("st_type", "notitle");
            yVar.addPostData("is_location", "2");
            Address address = com.baidu.adp.lib.c.a.kG().getAddress(false);
            if (address != null && TbadkCoreApplication.getInst().getIsLocationOn() && !TbConfig.getPositionPagerId().equals(cVar.forumId)) {
                yVar.addPostData("lbs", String.valueOf(address.getLatitude()) + Constants.ACCEPT_TIME_SEPARATOR_SP + String.valueOf(address.getLongitude()));
                yVar.addPostData("lat", String.valueOf(address.getLatitude()));
                yVar.addPostData("lng", String.valueOf(address.getLongitude()));
            }
            com.baidu.tieba.tbadkCore.location.a locationData = com.baidu.tieba.tbadkCore.location.c.diE().getLocationData();
            if (locationData != null) {
                yVar.addPostData("name", locationData.diC());
                yVar.addPostData(IXAdRequestInfo.SN, locationData.axE());
            }
            yVar.addPostData("is_link_thread", "0");
            if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                yVar.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
            }
            yVar.addPostData("tbopen_app_key", cVar.appKey);
            yVar.addPostData("tbopen_app_icon", cVar.mpE);
            yVar.addPostData("tbopen_app_name", cVar.appName);
            yVar.addPostData("share_abstract", cVar.content);
            yVar.addPostData("share_image", str);
            yVar.addPostData("share_h5_url", cVar.linkUrl);
            yVar.addPostData("share_swan_app_key", cVar.mpD);
            yVar.addPostData("share_swan_path", cVar.mpH);
            String postNetData = yVar.postNetData();
            d dVar = new d();
            try {
                JSONObject jSONObject = new JSONObject(postNetData);
                dVar.mpJ = jSONObject.optString("msg");
                dVar.preMsg = jSONObject.optString("pre_msg");
                dVar.fid = cVar.forumId;
                dVar.tid = jSONObject.optString("tid");
                dVar.pid = jSONObject.optString("pid");
                dVar.videoId = jSONObject.optString("video_id");
            } catch (Exception e) {
            }
            ErrorData errorData = new ErrorData();
            if (yVar.aWu().aWW().isRequestSuccess()) {
                errorData.parserJson(postNetData);
            } else {
                errorData.setError_code(yVar.isNetSuccess() ? yVar.getServerErrorCode() : yVar.getNetErrorCode());
                errorData.setError_msg(yVar.getErrorString());
            }
            if (errorData.error_code != 0 && !j.isNetWorkAvailable()) {
                errorData.setError_msg(TbadkCoreApplication.getInst().getApp().getString(R.string.neterror));
            }
            dVar.mpI = errorData;
            AntiData antiData = new AntiData();
            try {
                antiData.parserJson(new JSONObject(postNetData).optJSONObject("anti_stat"));
            } catch (Exception e2) {
            }
            dVar.antiData = antiData;
            return dVar;
        }

        public String fO(String str, String str2) {
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
            if (f.this.mpW != null) {
                f.this.mpW.a(dVar);
            }
        }
    }
}
