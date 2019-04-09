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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.d;
import com.tencent.connect.common.Constants;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {
    private e jpG;
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
        this.jpG = eVar;
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
            com.baidu.adp.lib.Disk.ops.c cVar2 = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, as.mL(cVar.imageUrl + 42), DiskFileOperate.Action.READ);
            cVar2.R(true);
            cVar2.S(false);
            ImageUploadResult f = new com.baidu.tbadk.img.f(null).f(ek(cVar2.hJ(), cVar2.getName()), true, false);
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
                str = cVar.jpo;
            }
            x xVar = new x();
            xVar.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
            xVar.acE().adC().mIsNeedTbs = true;
            xVar.x("anonymous", "1");
            xVar.x("can_no_forum", "0");
            xVar.x("is_feedback", "0");
            if (TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() < 3) {
                xVar.x("vcode_tag", Constants.VIA_REPORT_TYPE_SET_AVATAR);
            }
            xVar.x("new_vcode", "1");
            xVar.x("content", cVar.JA);
            xVar.x(ImageViewerConfig.FORUM_ID, cVar.forumId);
            xVar.x("kw", cVar.jpn);
            xVar.x("is_hide", "0");
            xVar.x(IntentConfig.CALL_FROM, "2");
            xVar.x("title", cVar.JA);
            xVar.x("is_ntitle", "1");
            xVar.x("st_type", "notitle");
            xVar.x("is_location", "2");
            Address af = com.baidu.adp.lib.d.a.iW().af(false);
            if (af != null && TbadkCoreApplication.getInst().getIsLocationOn() && !TbConfig.getPositionPagerId().equals(cVar.forumId)) {
                xVar.x("lbs", String.valueOf(af.getLatitude()) + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + String.valueOf(af.getLongitude()));
                xVar.x("lat", String.valueOf(af.getLatitude()));
                xVar.x("lng", String.valueOf(af.getLongitude()));
            }
            com.baidu.tieba.tbadkCore.location.a locationData = com.baidu.tieba.tbadkCore.location.c.ceV().getLocationData();
            if (locationData != null) {
                xVar.x("name", locationData.ceS());
                xVar.x("sn", locationData.ceU());
            }
            xVar.x("is_link_thread", "0");
            if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                xVar.x("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
            }
            xVar.x("tbopen_app_key", cVar.appKey);
            xVar.x("tbopen_app_icon", cVar.jpm);
            xVar.x("tbopen_app_name", cVar.appName);
            xVar.x("share_abstract", cVar.content);
            xVar.x("share_image", str);
            xVar.x("share_h5_url", cVar.linkUrl);
            xVar.x("share_swan_app_key", cVar.jpl);
            xVar.x("share_swan_path", cVar.jpp);
            String acg = xVar.acg();
            d dVar = new d();
            try {
                JSONObject jSONObject = new JSONObject(acg);
                dVar.jpr = jSONObject.optString("msg");
                dVar.preMsg = jSONObject.optString("pre_msg");
                dVar.fid = cVar.forumId;
                dVar.tid = jSONObject.optString("tid");
                dVar.pid = jSONObject.optString(Info.kBaiduPIDKey);
                dVar.videoId = jSONObject.optString("video_id");
            } catch (Exception e) {
            }
            ErrorData errorData = new ErrorData();
            if (xVar.acE().adD().isRequestSuccess()) {
                errorData.parserJson(acg);
            } else {
                errorData.setError_code(xVar.acH() ? xVar.acI() : xVar.acJ());
                errorData.setError_msg(xVar.getErrorString());
            }
            if (errorData.error_code != 0 && !j.kY()) {
                errorData.setError_msg(TbadkCoreApplication.getInst().getApp().getString(d.j.neterror));
            }
            dVar.jpq = errorData;
            AntiData antiData = new AntiData();
            try {
                antiData.parserJson(new JSONObject(acg).optJSONObject("anti_stat"));
            } catch (Exception e2) {
            }
            dVar.antiData = antiData;
            return dVar;
        }

        public String ek(String str, String str2) {
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
            if (f.this.jpG != null) {
                f.this.jpG.a(dVar);
            }
        }
    }
}
