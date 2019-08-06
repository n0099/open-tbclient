package com.baidu.tieba.write.share;

import android.location.Address;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.appsearchlib.Info;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.R;
import com.tencent.connect.common.Constants;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {
    private e jQU;
    private BdUniqueId mPageId;
    private String wH = BdBaseApplication.getInst().getContext().getCacheDir().getAbsolutePath() + "/";

    public f(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }

    public void a(c cVar) {
        a aVar = new a();
        aVar.setTag(this.mPageId);
        aVar.execute(cVar);
    }

    public void a(e eVar) {
        this.jQU = eVar;
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
            com.baidu.adp.lib.Disk.ops.c cVar2 = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, at.oj(cVar.imageUrl + 42), DiskFileOperate.Action.READ);
            cVar2.J(true);
            cVar2.K(false);
            ImageUploadResult f = new com.baidu.tbadk.img.f(null).f(ey(cVar2.gM(), cVar2.getName()), true, false);
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
                str = cVar.jQC;
            }
            x xVar = new x();
            xVar.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
            xVar.aiG().ajG().mIsNeedTbs = true;
            xVar.o("anonymous", "1");
            xVar.o("can_no_forum", "0");
            xVar.o("is_feedback", "0");
            if (TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() < 3) {
                xVar.o("vcode_tag", Constants.VIA_REPORT_TYPE_SET_AVATAR);
            }
            xVar.o("new_vcode", "1");
            xVar.o("content", cVar.Hu);
            xVar.o("fid", cVar.forumId);
            xVar.o("kw", cVar.jQB);
            xVar.o("is_hide", "0");
            xVar.o(IntentConfig.CALL_FROM, "2");
            xVar.o("title", cVar.Hu);
            xVar.o("is_ntitle", "1");
            xVar.o("st_type", "notitle");
            xVar.o("is_location", "2");
            Address X = com.baidu.adp.lib.d.a.hY().X(false);
            if (X != null && TbadkCoreApplication.getInst().getIsLocationOn() && !TbConfig.getPositionPagerId().equals(cVar.forumId)) {
                xVar.o("lbs", String.valueOf(X.getLatitude()) + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + String.valueOf(X.getLongitude()));
                xVar.o("lat", String.valueOf(X.getLatitude()));
                xVar.o("lng", String.valueOf(X.getLongitude()));
            }
            com.baidu.tieba.tbadkCore.location.a locationData = com.baidu.tieba.tbadkCore.location.c.cqr().getLocationData();
            if (locationData != null) {
                xVar.o("name", locationData.cqp());
                xVar.o(IXAdRequestInfo.SN, locationData.getSn());
            }
            xVar.o("is_link_thread", "0");
            if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                xVar.o("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
            }
            xVar.o("tbopen_app_key", cVar.appKey);
            xVar.o("tbopen_app_icon", cVar.jQA);
            xVar.o("tbopen_app_name", cVar.appName);
            xVar.o("share_abstract", cVar.content);
            xVar.o("share_image", str);
            xVar.o("share_h5_url", cVar.linkUrl);
            xVar.o("share_swan_app_key", cVar.jQz);
            xVar.o("share_swan_path", cVar.jQD);
            String aii = xVar.aii();
            d dVar = new d();
            try {
                JSONObject jSONObject = new JSONObject(aii);
                dVar.jQF = jSONObject.optString("msg");
                dVar.preMsg = jSONObject.optString("pre_msg");
                dVar.fid = cVar.forumId;
                dVar.tid = jSONObject.optString("tid");
                dVar.pid = jSONObject.optString(Info.kBaiduPIDKey);
                dVar.videoId = jSONObject.optString("video_id");
            } catch (Exception e) {
            }
            ErrorData errorData = new ErrorData();
            if (xVar.aiG().ajH().isRequestSuccess()) {
                errorData.parserJson(aii);
            } else {
                errorData.setError_code(xVar.aiJ() ? xVar.aiK() : xVar.aiL());
                errorData.setError_msg(xVar.getErrorString());
            }
            if (errorData.error_code != 0 && !j.kc()) {
                errorData.setError_msg(TbadkCoreApplication.getInst().getApp().getString(R.string.neterror));
            }
            dVar.jQE = errorData;
            AntiData antiData = new AntiData();
            try {
                antiData.parserJson(new JSONObject(aii).optJSONObject("anti_stat"));
            } catch (Exception e2) {
            }
            dVar.antiData = antiData;
            return dVar;
        }

        public String ey(String str, String str2) {
            String str3 = f.this.wH + str2;
            if (str != null) {
                return f.this.wH + str + "/" + str2;
            }
            return str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(d dVar) {
            if (f.this.jQU != null) {
                f.this.jQU.a(dVar);
            }
        }
    }
}
