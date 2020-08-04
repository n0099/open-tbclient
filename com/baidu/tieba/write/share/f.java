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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {
    private String mAppCachePath = BdBaseApplication.getInst().getContext().getCacheDir().getAbsolutePath() + "/";
    private BdUniqueId mPageId;
    private e mxX;

    public f(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }

    public void a(c cVar) {
        a aVar = new a();
        aVar.setTag(this.mPageId);
        aVar.execute(cVar);
    }

    public void a(e eVar) {
        this.mxX = eVar;
    }

    /* loaded from: classes3.dex */
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
            com.baidu.adp.lib.Disk.ops.c cVar2 = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, au.getNameMd5FromUrl(cVar.imageUrl + 42), DiskFileOperate.Action.READ);
            cVar2.setSubFolder(true);
            cVar2.setIsFormatData(false);
            ImageUploadResult f = new com.baidu.tbadk.img.f(null).f(fQ(cVar2.buildPath(), cVar2.getName()), true, false);
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
                str = cVar.mxH;
            }
            z zVar = new z();
            zVar.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
            zVar.bav().baW().mIsNeedTbs = true;
            zVar.addPostData("anonymous", "1");
            zVar.addPostData("can_no_forum", "0");
            zVar.addPostData("is_feedback", "0");
            if (TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() < 3) {
                zVar.addPostData("vcode_tag", "12");
            }
            zVar.addPostData("new_vcode", "1");
            zVar.addPostData("content", cVar.Qw);
            zVar.addPostData("fid", cVar.forumId);
            zVar.addPostData("kw", cVar.mxG);
            zVar.addPostData("is_hide", "0");
            zVar.addPostData("call_from", "2");
            zVar.addPostData("title", cVar.Qw);
            zVar.addPostData("is_ntitle", "1");
            zVar.addPostData("st_type", "notitle");
            zVar.addPostData("is_location", "2");
            Address address = com.baidu.adp.lib.c.a.kG().getAddress(false);
            if (address != null && TbadkCoreApplication.getInst().getIsLocationOn() && !TbConfig.getPositionPagerId().equals(cVar.forumId)) {
                zVar.addPostData("lbs", String.valueOf(address.getLatitude()) + Constants.ACCEPT_TIME_SEPARATOR_SP + String.valueOf(address.getLongitude()));
                zVar.addPostData("lat", String.valueOf(address.getLatitude()));
                zVar.addPostData("lng", String.valueOf(address.getLongitude()));
            }
            com.baidu.tieba.tbadkCore.location.a locationData = com.baidu.tieba.tbadkCore.location.c.dlN().getLocationData();
            if (locationData != null) {
                zVar.addPostData("name", locationData.dlL());
                zVar.addPostData(IXAdRequestInfo.SN, locationData.aAC());
            }
            zVar.addPostData("is_link_thread", "0");
            if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                zVar.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
            }
            zVar.addPostData("tbopen_app_key", cVar.appKey);
            zVar.addPostData("tbopen_app_icon", cVar.mxF);
            zVar.addPostData("tbopen_app_name", cVar.appName);
            zVar.addPostData("share_abstract", cVar.content);
            zVar.addPostData("share_image", str);
            zVar.addPostData("share_h5_url", cVar.linkUrl);
            zVar.addPostData("share_swan_app_key", cVar.mxE);
            zVar.addPostData("share_swan_path", cVar.mxI);
            String postNetData = zVar.postNetData();
            d dVar = new d();
            try {
                JSONObject jSONObject = new JSONObject(postNetData);
                dVar.mxK = jSONObject.optString("msg");
                dVar.preMsg = jSONObject.optString("pre_msg");
                dVar.fid = cVar.forumId;
                dVar.tid = jSONObject.optString("tid");
                dVar.pid = jSONObject.optString("pid");
                dVar.videoId = jSONObject.optString("video_id");
            } catch (Exception e) {
            }
            ErrorData errorData = new ErrorData();
            if (zVar.bav().baX().isRequestSuccess()) {
                errorData.parserJson(postNetData);
            } else {
                errorData.setError_code(zVar.isNetSuccess() ? zVar.getServerErrorCode() : zVar.getNetErrorCode());
                errorData.setError_msg(zVar.getErrorString());
            }
            if (errorData.error_code != 0 && !j.isNetWorkAvailable()) {
                errorData.setError_msg(TbadkCoreApplication.getInst().getApp().getString(R.string.neterror));
            }
            dVar.mxJ = errorData;
            AntiData antiData = new AntiData();
            try {
                antiData.parserJson(new JSONObject(postNetData).optJSONObject("anti_stat"));
            } catch (Exception e2) {
            }
            dVar.antiData = antiData;
            return dVar;
        }

        public String fQ(String str, String str2) {
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
            if (f.this.mxX != null) {
                f.this.mxX.a(dVar);
            }
        }
    }
}
