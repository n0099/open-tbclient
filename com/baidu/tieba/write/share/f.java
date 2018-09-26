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
    private e hEw;
    private BdUniqueId mPageId;
    private String yj = BdBaseApplication.getInst().getContext().getCacheDir().getAbsolutePath() + "/";

    public f(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }

    public void a(c cVar) {
        a aVar = new a();
        aVar.setTag(this.mPageId);
        aVar.execute(cVar);
    }

    public void a(e eVar) {
        this.hEw = eVar;
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
            com.baidu.adp.lib.Disk.ops.c cVar2 = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, ar.fe(cVar.imageUrl + 42), DiskFileOperate.Action.READ);
            cVar2.D(true);
            cVar2.E(false);
            ImageUploadResult c = new com.baidu.tbadk.img.f(null).c(cH(cVar2.hv(), cVar2.getName()), true, false);
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
                str = cVar.hEe;
            }
            x xVar = new x();
            xVar.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
            xVar.zR().AP().mIsNeedTbs = true;
            xVar.u("anonymous", "1");
            xVar.u("can_no_forum", "0");
            xVar.u("is_feedback", "0");
            if (TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() < 3) {
                xVar.u("vcode_tag", Constants.VIA_REPORT_TYPE_SET_AVATAR);
            }
            xVar.u("new_vcode", "1");
            xVar.u("content", cVar.IP);
            xVar.u(ImageViewerConfig.FORUM_ID, cVar.forumId);
            xVar.u("kw", cVar.hEd);
            xVar.u("is_hide", "0");
            xVar.u(IntentConfig.CALL_FROM, "2");
            xVar.u("title", cVar.IP);
            xVar.u("is_ntitle", "1");
            xVar.u("st_type", "notitle");
            xVar.u("is_location", "2");
            Address R = com.baidu.adp.lib.d.a.iH().R(false);
            if (R != null && TbadkCoreApplication.getInst().getIsLocationOn() && !TbConfig.getPositionPagerId().equals(cVar.forumId)) {
                xVar.u("lbs", String.valueOf(R.getLatitude()) + "," + String.valueOf(R.getLongitude()));
                xVar.u("lat", String.valueOf(R.getLatitude()));
                xVar.u("lng", String.valueOf(R.getLongitude()));
            }
            com.baidu.tieba.tbadkCore.location.a locationData = com.baidu.tieba.tbadkCore.location.c.bzs().getLocationData();
            if (locationData != null) {
                xVar.u("name", locationData.bzo());
                xVar.u("sn", locationData.bzq());
            }
            xVar.u("is_link_thread", "0");
            if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                xVar.u("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
            }
            xVar.u("tbopen_app_key", cVar.hEa);
            xVar.u("tbopen_app_icon", cVar.hEc);
            xVar.u("tbopen_app_name", cVar.appName);
            xVar.u("share_abstract", cVar.content);
            xVar.u("share_image", str);
            xVar.u("share_h5_url", cVar.linkUrl);
            xVar.u("share_swan_app_key", cVar.hEb);
            xVar.u("share_swan_path", cVar.hEf);
            String zt = xVar.zt();
            d dVar = new d();
            try {
                JSONObject jSONObject = new JSONObject(zt);
                dVar.hEh = jSONObject.optString("msg");
                dVar.preMsg = jSONObject.optString("pre_msg");
                dVar.fid = cVar.forumId;
                dVar.tid = jSONObject.optString("tid");
                dVar.pid = jSONObject.optString(Info.kBaiduPIDKey);
                dVar.videoId = jSONObject.optString("video_id");
            } catch (Exception e) {
            }
            ErrorData errorData = new ErrorData();
            if (xVar.zR().AQ().isRequestSuccess()) {
                errorData.parserJson(zt);
            } else {
                errorData.setError_code(xVar.zU() ? xVar.zV() : xVar.zW());
                errorData.setError_msg(xVar.getErrorString());
            }
            if (errorData.error_code != 0 && !j.kK()) {
                errorData.setError_msg(TbadkCoreApplication.getInst().getApp().getString(e.j.neterror));
            }
            dVar.hEg = errorData;
            AntiData antiData = new AntiData();
            try {
                antiData.parserJson(new JSONObject(zt).optJSONObject("anti_stat"));
            } catch (Exception e2) {
            }
            dVar.antiData = antiData;
            return dVar;
        }

        public String cH(String str, String str2) {
            String str3 = f.this.yj + str2;
            if (str != null) {
                return f.this.yj + str + "/" + str2;
            }
            return str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(d dVar) {
            if (f.this.hEw != null) {
                f.this.hEw.a(dVar);
            }
        }
    }
}
