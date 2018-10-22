package com.baidu.tieba.write.share;

import android.location.Address;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.e;
import com.tencent.connect.common.Constants;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {
    private e hLJ;
    private BdUniqueId mPageId;
    private String yU = BdBaseApplication.getInst().getContext().getCacheDir().getAbsolutePath() + "/";

    public f(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }

    public void a(c cVar) {
        a aVar = new a();
        aVar.setTag(this.mPageId);
        aVar.execute(cVar);
    }

    public void a(e eVar) {
        this.hLJ = eVar;
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
            com.baidu.adp.lib.Disk.ops.c cVar2 = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, ar.fs(cVar.imageUrl + 42), DiskFileOperate.Action.READ);
            cVar2.D(true);
            cVar2.E(false);
            ImageUploadResult c = new com.baidu.tbadk.img.f(null).c(cS(cVar2.hL(), cVar2.getName()), true, false);
            if (c != null && c.picInfo != null) {
                if (c.picInfo.originPic != null && !StringUtils.isNull(c.picInfo.originPic.picUrl)) {
                    str = c.picInfo.originPic.picUrl;
                } else if (c.picInfo.bigPic != null && !StringUtils.isNull(c.picInfo.bigPic.picUrl)) {
                    str = c.picInfo.bigPic.picUrl;
                } else if (c.picInfo.smallPic != null && !StringUtils.isNull(c.picInfo.smallPic.picUrl)) {
                    str = c.picInfo.smallPic.picUrl;
                }
            }
            if (StringUtils.isNull(str)) {
                str = cVar.hLr;
            }
            x xVar = new x();
            xVar.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
            xVar.BY().CW().mIsNeedTbs = true;
            xVar.x("anonymous", "1");
            xVar.x("can_no_forum", "0");
            xVar.x("is_feedback", "0");
            if (TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() < 3) {
                xVar.x("vcode_tag", Constants.VIA_REPORT_TYPE_SET_AVATAR);
            }
            xVar.x("new_vcode", "1");
            xVar.x("content", cVar.Jq);
            xVar.x(ImageViewerConfig.FORUM_ID, cVar.forumId);
            xVar.x("kw", cVar.hLq);
            xVar.x("is_hide", "0");
            xVar.x(IntentConfig.CALL_FROM, "2");
            xVar.x("title", cVar.Jq);
            xVar.x("is_ntitle", "1");
            xVar.x("st_type", "notitle");
            xVar.x("is_location", "2");
            Address R = com.baidu.adp.lib.d.a.iX().R(false);
            if (R != null && TbadkCoreApplication.getInst().getIsLocationOn() && !TbConfig.getPositionPagerId().equals(cVar.forumId)) {
                xVar.x("lbs", String.valueOf(R.getLatitude()) + "," + String.valueOf(R.getLongitude()));
                xVar.x("lat", String.valueOf(R.getLatitude()));
                xVar.x("lng", String.valueOf(R.getLongitude()));
            }
            com.baidu.tieba.tbadkCore.location.a locationData = com.baidu.tieba.tbadkCore.location.c.bCH().getLocationData();
            if (locationData != null) {
                xVar.x("name", locationData.bCD());
                xVar.x("sn", locationData.bCF());
            }
            xVar.x("is_link_thread", "0");
            if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                xVar.x("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
            }
            xVar.x("tbopen_app_key", cVar.appKey);
            xVar.x("tbopen_app_icon", cVar.hLp);
            xVar.x("tbopen_app_name", cVar.appName);
            xVar.x("share_abstract", cVar.content);
            xVar.x("share_image", str);
            xVar.x("share_h5_url", cVar.linkUrl);
            xVar.x("share_swan_app_key", cVar.hLo);
            xVar.x("share_swan_path", cVar.hLs);
            String BA = xVar.BA();
            d dVar = new d();
            try {
                JSONObject jSONObject = new JSONObject(BA);
                dVar.hLu = jSONObject.optString("msg");
                dVar.preMsg = jSONObject.optString("pre_msg");
                dVar.fid = cVar.forumId;
                dVar.tid = jSONObject.optString("tid");
                dVar.pid = jSONObject.optString(Info.kBaiduPIDKey);
                dVar.videoId = jSONObject.optString("video_id");
            } catch (Exception e) {
            }
            ErrorData errorData = new ErrorData();
            if (xVar.BY().CX().isRequestSuccess()) {
                errorData.parserJson(BA);
            } else {
                errorData.setError_code(xVar.Cb() ? xVar.Cc() : xVar.Cd());
                errorData.setError_msg(xVar.getErrorString());
            }
            if (errorData.error_code != 0 && !j.kX()) {
                errorData.setError_msg(TbadkCoreApplication.getInst().getApp().getString(e.j.neterror));
            }
            dVar.hLt = errorData;
            AntiData antiData = new AntiData();
            try {
                antiData.parserJson(new JSONObject(BA).optJSONObject("anti_stat"));
            } catch (Exception e2) {
            }
            dVar.antiData = antiData;
            return dVar;
        }

        public String cS(String str, String str2) {
            String str3 = f.this.yU + str2;
            if (str != null) {
                return f.this.yU + str + "/" + str2;
            }
            return str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(d dVar) {
            if (f.this.hLJ != null) {
                f.this.hLJ.a(dVar);
            }
        }
    }
}
