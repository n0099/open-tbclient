package com.baidu.tieba.tbadkCore.writeModel;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.coreExtra.data.AccessState;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.IconStampData;
import com.baidu.tbadk.data.VideoEasterEggData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.ContriInfo;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import d.a.c.e.p.j;
import d.a.m0.r.q.i1;
import d.a.m0.r.q.t1;
import d.a.m0.r.s.a;
import d.a.m0.s.c.i0;
import d.a.n0.e3.i0.a;
import d.a.n0.e3.n0.f;
import d.a.n0.u1.k;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class NewWriteModel extends BdBaseModel {
    public static int MAX_IMG_NUM = 10;

    /* renamed from: e  reason: collision with root package name */
    public h f20878e;

    /* renamed from: f  reason: collision with root package name */
    public d f20879f;

    /* renamed from: g  reason: collision with root package name */
    public WriteData f20880g;

    /* renamed from: h  reason: collision with root package name */
    public String f20881h;

    /* renamed from: i  reason: collision with root package name */
    public String f20882i;
    public byte[] j;
    public e k;
    public f l;
    public g m;
    public boolean n;
    public d.a.c.a.f<?> o;
    public a.c p;
    public SpanGroupManager q;
    public String r;
    public f.c s;

    /* loaded from: classes5.dex */
    public class a implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.r.s.a f20883e;

        public a(d.a.m0.r.s.a aVar) {
            this.f20883e = aVar;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            this.f20883e.dismiss();
            NewWriteModel.this.R();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.r.s.a f20885e;

        public b(d.a.m0.r.s.a aVar) {
            this.f20885e = aVar;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            this.f20885e.dismiss();
            NewWriteModel.this.cancel();
        }
    }

    /* loaded from: classes5.dex */
    public class c extends f.c {
        public c() {
        }

        @Override // d.a.n0.e3.n0.f.c
        public void a(String str) {
            if (NewWriteModel.this.f20880g == null || TextUtils.isEmpty(str)) {
                if (NewWriteModel.this.m != null) {
                    NewWriteModel.this.m.callback(false, null, null, NewWriteModel.this.f20880g, null);
                    return;
                }
                return;
            }
            NewWriteModel.this.f20878e = null;
            NewWriteModel.this.f20880g.setAuthSid(str);
            NewWriteModel.this.i0();
        }

        @Override // d.a.n0.e3.n0.f.c
        public void c(String str) {
            if (NewWriteModel.this.f20880g == null || TextUtils.isEmpty(str)) {
                if (NewWriteModel.this.m != null) {
                    NewWriteModel.this.m.callback(false, null, null, NewWriteModel.this.f20880g, null);
                    return;
                }
                return;
            }
            NewWriteModel.this.f20878e = null;
            NewWriteModel.this.f20880g.setAuthSid(str);
            NewWriteModel.this.i0();
        }

        @Override // d.a.n0.e3.n0.f.c
        public void d() {
            if (NewWriteModel.this.f20880g != null) {
                NewWriteModel.this.f20880g.setAuthSid(null);
            }
            if (NewWriteModel.this.m != null) {
                NewWriteModel.this.m.callback(false, null, null, NewWriteModel.this.f20880g, null);
            }
        }

        @Override // d.a.n0.e3.n0.f.c
        public void e() {
            if (NewWriteModel.this.f20880g != null) {
                NewWriteModel.this.f20878e = null;
                NewWriteModel.this.f20880g.setAuthSid(null);
                NewWriteModel.this.i0();
            } else if (NewWriteModel.this.m != null) {
                NewWriteModel.this.m.callback(false, null, null, NewWriteModel.this.f20880g, null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends BdAsyncTask<Void, Void, ImageUploadResult> {

        /* renamed from: a  reason: collision with root package name */
        public boolean f20888a = false;

        /* renamed from: b  reason: collision with root package name */
        public d.a.n0.e3.i0.a f20889b = new d.a.n0.e3.i0.a();

        /* renamed from: c  reason: collision with root package name */
        public Bitmap f20890c = null;

        public d() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean isLocalImagePath = FileHelper.isLocalImagePath(NewWriteModel.this.f20882i);
            if (this.f20888a) {
                return null;
            }
            if (NewWriteModel.this.j == null || NewWriteModel.this.j.length <= 0) {
                if (TextUtils.isEmpty(NewWriteModel.this.f20882i) || !isLocalImagePath) {
                    return null;
                }
                Uri parse = Uri.parse(NewWriteModel.this.f20882i);
                NewWriteModel.this.f20881h = FileHelper.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), parse);
                if (TextUtils.isEmpty(NewWriteModel.this.f20881h)) {
                    return null;
                }
                NewWriteModel newWriteModel = NewWriteModel.this;
                return newWriteModel.S(newWriteModel.f20881h, this.f20889b);
            }
            Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(NewWriteModel.this.j);
            this.f20890c = Bytes2Bitmap;
            if (Bytes2Bitmap == null) {
                return null;
            }
            NewWriteModel.this.f20881h = FileHelper.saveFileToSDOrMemory(TbConfig.IMAGE_RESIZED_FILE, Bytes2Bitmap, 85);
            if (TextUtils.isEmpty(NewWriteModel.this.f20881h)) {
                Bitmap bitmap = this.f20890c;
                if (bitmap != null && !bitmap.isRecycled()) {
                    this.f20890c.recycle();
                }
                return null;
            }
            NewWriteModel newWriteModel2 = NewWriteModel.this;
            return newWriteModel2.S(newWriteModel2.f20881h, this.f20889b);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (this.f20888a) {
                return;
            }
            if (NewWriteModel.this.k != null) {
                NewWriteModel.this.k.a(imageUploadResult, false);
            }
            Bitmap bitmap = this.f20890c;
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            this.f20890c.recycle();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.f20888a = true;
            d.a.n0.e3.i0.a aVar = this.f20889b;
            if (aVar != null) {
                aVar.b();
            }
            if (NewWriteModel.this.k != null) {
                NewWriteModel.this.k.a(null, true);
            }
            Bitmap bitmap = this.f20890c;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.f20890c.recycle();
            }
            super.cancel();
            NewWriteModel.this.f20879f = null;
        }
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a(ImageUploadResult imageUploadResult, boolean z);
    }

    /* loaded from: classes5.dex */
    public interface f {
        void a(boolean z, String str, i0 i0Var, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes5.dex */
    public interface g {
        void callback(boolean z, PostWriteCallBackData postWriteCallBackData, i0 i0Var, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes5.dex */
    public class h extends BdAsyncTask<Integer, Integer, d.a.n0.e3.q0.f> {

        /* renamed from: a  reason: collision with root package name */
        public d.a.n0.e3.i0.a f20892a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f20893b = null;

        /* renamed from: c  reason: collision with root package name */
        public boolean f20894c = false;

        /* renamed from: d  reason: collision with root package name */
        public k f20895d;

        /* renamed from: e  reason: collision with root package name */
        public d.a.n0.u1.g f20896e;

        /* loaded from: classes5.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomDialogData f20898e;

            public a(CustomDialogData customDialogData) {
                this.f20898e = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.n0.e2.j.c.a((TbPageContext) NewWriteModel.this.o, this.f20898e).show();
            }
        }

        public h() {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
            if (runTask != null) {
                this.f20895d = (k) runTask.getData();
            }
            k kVar = this.f20895d;
            if (kVar != null) {
                this.f20896e = kVar.get();
            }
            setPriority(3);
            d.a.n0.e3.q0.b.a("发帖：任务创建：PostThreadTask");
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:137:0x02f5  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public d.a.n0.e3.q0.f doInBackground(Integer... numArr) {
            d.a.n0.e3.q0.f fVar;
            JSONArray jSONArray;
            JSONException jSONException;
            IconStampData iconStampData;
            d.a.m0.t.a aVar;
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            CustomDialogData customDialogData;
            VideoEasterEggData videoEasterEggData;
            if (this.f20894c) {
                return null;
            }
            d.a.m0.a0.d.c(NewWriteModel.this.f20880g.getContent());
            d.a.n0.e3.q0.b.a("doInBackground() start");
            d.a.n0.e3.q0.b.a("发帖：任务后台执行 开始 doInBackground");
            d.a.n0.e3.i0.a aVar2 = new d.a.n0.e3.i0.a();
            this.f20892a = aVar2;
            aVar2.j(NewWriteModel.this.q);
            this.f20892a.k(NewWriteModel.this.r);
            this.f20892a.l(this.f20896e);
            this.f20892a.i(NewWriteModel.this.p);
            this.f20893b = this.f20892a.h(NewWriteModel.this.f20880g, NewWriteModel.this.n);
            d.a.n0.e3.q0.b.a("发帖：任务后台执行 开始 doInBackground 结束");
            ErrorData d2 = this.f20892a.d();
            if (this.f20892a.e() && this.f20893b != null) {
                d.a.n0.e3.q0.b.a("发帖：任务后台执行 开始 doInBackground 成功");
                AntiData c2 = this.f20892a.c();
                String error_msg = d2.getError_msg();
                if (d.a.c.e.p.k.isEmpty(error_msg)) {
                    error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_success);
                }
                fVar = new d.a.n0.e3.q0.f(d2.getError_code(), error_msg, c2);
                if (NewWriteModel.this.f20880g != null && NewWriteModel.this.f20880g.isHasImages() && !fVar.s()) {
                    NewWriteModel.this.f20880g.deleteUploadedTempImages();
                }
                d.a.n0.e3.q0.b.a("发帖：任务后台执行 开始 doInBackground 删除临时的图片");
            } else if (d2 != null && d2.error_code == 220015) {
                fVar = new d.a.n0.e3.q0.f(d2.getError_code(), d2.getError_msg(), null);
                if (this.f20893b != null) {
                    try {
                        JSONObject optJSONObject = new JSONObject(this.f20893b).optJSONObject("info");
                        if (optJSONObject != null && (jSONArray = optJSONObject.getJSONArray("confilter_hitwords")) != null && jSONArray.length() > 0) {
                            int length = jSONArray.length();
                            ArrayList<String> arrayList = new ArrayList<>();
                            for (int i2 = 0; i2 < length; i2++) {
                                arrayList.add(jSONArray.optString(i2));
                            }
                            fVar.K(arrayList);
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                d.a.n0.e3.q0.b.a("发帖：任务后台执行 开始 doInBackground 失败 1");
            } else if (d2 != null && d2.error_code == 238010) {
                fVar = new d.a.n0.e3.q0.f(d2.getError_code(), d2.getError_msg(), null);
                if (this.f20893b != null) {
                    try {
                        JSONObject optJSONObject2 = new JSONObject(this.f20893b).optJSONObject("info");
                        if (optJSONObject2 != null) {
                            t1 t1Var = new t1();
                            t1Var.f50127a = optJSONObject2.optString("block_content");
                            t1Var.f50128b = optJSONObject2.optString("block_cancel");
                            t1Var.f50129c = optJSONObject2.optString("block_confirm");
                            fVar.J(t1Var);
                        }
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                }
                d.a.n0.e3.q0.b.a("发帖：任务后台执行 开始 doInBackground 失败 2");
            } else if (d2 != null && d2.error_code != 0) {
                String error_msg2 = d2.getError_msg();
                if (StringUtils.isNull(error_msg2)) {
                    if (d2.error_code == 3250013) {
                        error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.anti_account_exception_appealing);
                    } else {
                        error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                    }
                }
                fVar = new d.a.n0.e3.q0.f(d2.getError_code(), error_msg2, this.f20892a.c());
                d.a.n0.e3.q0.b.a("发帖：任务后台执行 开始 doInBackground 失败 3");
            } else {
                fVar = new d.a.n0.e3.q0.f(-17, TbadkCoreApplication.getInst().getApp().getString(R.string.neterror), null);
                d.a.n0.e3.q0.b.a("发帖：任务后台执行 开始 doInBackground 失败 4");
            }
            if (!fVar.s()) {
                ContriInfo contriInfo = new ContriInfo();
                try {
                    if (this.f20893b != null) {
                        JSONObject jSONObject = new JSONObject(this.f20893b);
                        String optString = jSONObject.optString("msg");
                        try {
                            str4 = jSONObject.optString("pre_msg");
                        } catch (JSONException e4) {
                            e = e4;
                            str3 = optString;
                            aVar = null;
                            str = null;
                            str2 = null;
                            str4 = null;
                        }
                        try {
                            str5 = jSONObject.optString("color_msg");
                        } catch (JSONException e5) {
                            e = e5;
                            str3 = optString;
                            aVar = null;
                            str = null;
                            str2 = null;
                            str5 = null;
                            str6 = null;
                            str7 = null;
                            str8 = null;
                            customDialogData = null;
                            videoEasterEggData = null;
                            jSONException = e;
                            iconStampData = null;
                            jSONException.printStackTrace();
                            if (StringUtils.isNull(str3)) {
                            }
                            fVar.C(str3);
                            fVar.I(str4);
                            fVar.A(str5);
                            fVar.L(str6);
                            fVar.H(str7);
                            fVar.G(r6);
                            fVar.E(str2);
                            fVar.D(str);
                            fVar.y(customDialogData);
                            fVar.N(str8);
                            fVar.B(contriInfo);
                            fVar.M(videoEasterEggData);
                            fVar.z(aVar);
                            fVar.F(iconStampData);
                            d.a.n0.e3.q0.b.a("doInBackground end");
                            d.a.n0.e3.q0.b.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                            return fVar;
                        }
                        try {
                            str6 = jSONObject.optString("tid");
                        } catch (JSONException e6) {
                            e = e6;
                            str3 = optString;
                            aVar = null;
                            str = null;
                            str2 = null;
                            str6 = null;
                            str7 = null;
                            str8 = null;
                            customDialogData = null;
                            videoEasterEggData = null;
                            jSONException = e;
                            iconStampData = null;
                            jSONException.printStackTrace();
                            if (StringUtils.isNull(str3)) {
                            }
                            fVar.C(str3);
                            fVar.I(str4);
                            fVar.A(str5);
                            fVar.L(str6);
                            fVar.H(str7);
                            fVar.G(r6);
                            fVar.E(str2);
                            fVar.D(str);
                            fVar.y(customDialogData);
                            fVar.N(str8);
                            fVar.B(contriInfo);
                            fVar.M(videoEasterEggData);
                            fVar.z(aVar);
                            fVar.F(iconStampData);
                            d.a.n0.e3.q0.b.a("doInBackground end");
                            d.a.n0.e3.q0.b.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                            return fVar;
                        }
                        try {
                            str7 = jSONObject.optString("pid");
                            try {
                                str8 = jSONObject.optString("video_id");
                                try {
                                    customDialogData = d.a.n0.e2.b.a(jSONObject);
                                    try {
                                        JSONObject optJSONObject3 = jSONObject.optJSONObject("twzhibo_info");
                                        r6 = optJSONObject3 != null ? optJSONObject3.optInt("is_copytwzhibo", 0) : 0;
                                        JSONObject optJSONObject4 = jSONObject.optJSONObject("exp");
                                        if (optJSONObject4 != null) {
                                            str2 = optJSONObject4.optString("pre_msg");
                                            try {
                                                str = optJSONObject4.optString("color_msg");
                                            } catch (JSONException e7) {
                                                e = e7;
                                                str3 = optString;
                                                aVar = null;
                                                str = null;
                                                videoEasterEggData = null;
                                                jSONException = e;
                                                iconStampData = null;
                                                jSONException.printStackTrace();
                                                if (StringUtils.isNull(str3)) {
                                                }
                                                fVar.C(str3);
                                                fVar.I(str4);
                                                fVar.A(str5);
                                                fVar.L(str6);
                                                fVar.H(str7);
                                                fVar.G(r6);
                                                fVar.E(str2);
                                                fVar.D(str);
                                                fVar.y(customDialogData);
                                                fVar.N(str8);
                                                fVar.B(contriInfo);
                                                fVar.M(videoEasterEggData);
                                                fVar.z(aVar);
                                                fVar.F(iconStampData);
                                                d.a.n0.e3.q0.b.a("doInBackground end");
                                                d.a.n0.e3.q0.b.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                                return fVar;
                                            }
                                        } else {
                                            str = null;
                                            str2 = null;
                                        }
                                        try {
                                            contriInfo.parseJson(jSONObject.optJSONObject("contri_info"));
                                            JSONObject optJSONObject5 = jSONObject.optJSONObject("star_info");
                                            if (optJSONObject5 != null) {
                                                videoEasterEggData = new VideoEasterEggData();
                                                try {
                                                    videoEasterEggData.parseJson(optJSONObject5);
                                                } catch (JSONException e8) {
                                                    e = e8;
                                                    str3 = optString;
                                                    aVar = null;
                                                    jSONException = e;
                                                    iconStampData = null;
                                                    jSONException.printStackTrace();
                                                    if (StringUtils.isNull(str3)) {
                                                    }
                                                    fVar.C(str3);
                                                    fVar.I(str4);
                                                    fVar.A(str5);
                                                    fVar.L(str6);
                                                    fVar.H(str7);
                                                    fVar.G(r6);
                                                    fVar.E(str2);
                                                    fVar.D(str);
                                                    fVar.y(customDialogData);
                                                    fVar.N(str8);
                                                    fVar.B(contriInfo);
                                                    fVar.M(videoEasterEggData);
                                                    fVar.z(aVar);
                                                    fVar.F(iconStampData);
                                                    d.a.n0.e3.q0.b.a("doInBackground end");
                                                    d.a.n0.e3.q0.b.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                                    return fVar;
                                                }
                                            } else {
                                                videoEasterEggData = null;
                                            }
                                            JSONObject optJSONObject6 = jSONObject.optJSONObject("advertisement");
                                            if (optJSONObject6 != null) {
                                                aVar = new d.a.m0.t.a();
                                                try {
                                                    aVar.i(optJSONObject6);
                                                } catch (JSONException e9) {
                                                    e = e9;
                                                    str3 = optString;
                                                    jSONException = e;
                                                    iconStampData = null;
                                                    jSONException.printStackTrace();
                                                    if (StringUtils.isNull(str3)) {
                                                    }
                                                    fVar.C(str3);
                                                    fVar.I(str4);
                                                    fVar.A(str5);
                                                    fVar.L(str6);
                                                    fVar.H(str7);
                                                    fVar.G(r6);
                                                    fVar.E(str2);
                                                    fVar.D(str);
                                                    fVar.y(customDialogData);
                                                    fVar.N(str8);
                                                    fVar.B(contriInfo);
                                                    fVar.M(videoEasterEggData);
                                                    fVar.z(aVar);
                                                    fVar.F(iconStampData);
                                                    d.a.n0.e3.q0.b.a("doInBackground end");
                                                    d.a.n0.e3.q0.b.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                                    return fVar;
                                                }
                                            } else {
                                                aVar = null;
                                            }
                                            JSONObject optJSONObject7 = jSONObject.optJSONObject("icon_stamp_info");
                                            if (optJSONObject7 != null) {
                                                IconStampData iconStampData2 = new IconStampData();
                                                try {
                                                    iconStampData2.parseJson(optJSONObject7);
                                                    iconStampData = iconStampData2;
                                                    str3 = optString;
                                                } catch (JSONException e10) {
                                                    jSONException = e10;
                                                    iconStampData = iconStampData2;
                                                    str3 = optString;
                                                    jSONException.printStackTrace();
                                                    if (StringUtils.isNull(str3)) {
                                                    }
                                                    fVar.C(str3);
                                                    fVar.I(str4);
                                                    fVar.A(str5);
                                                    fVar.L(str6);
                                                    fVar.H(str7);
                                                    fVar.G(r6);
                                                    fVar.E(str2);
                                                    fVar.D(str);
                                                    fVar.y(customDialogData);
                                                    fVar.N(str8);
                                                    fVar.B(contriInfo);
                                                    fVar.M(videoEasterEggData);
                                                    fVar.z(aVar);
                                                    fVar.F(iconStampData);
                                                    d.a.n0.e3.q0.b.a("doInBackground end");
                                                    d.a.n0.e3.q0.b.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                                    return fVar;
                                                }
                                            } else {
                                                str3 = optString;
                                                iconStampData = null;
                                            }
                                        } catch (JSONException e11) {
                                            e = e11;
                                            str3 = optString;
                                            aVar = null;
                                            videoEasterEggData = null;
                                            jSONException = e;
                                            iconStampData = null;
                                            jSONException.printStackTrace();
                                            if (StringUtils.isNull(str3)) {
                                            }
                                            fVar.C(str3);
                                            fVar.I(str4);
                                            fVar.A(str5);
                                            fVar.L(str6);
                                            fVar.H(str7);
                                            fVar.G(r6);
                                            fVar.E(str2);
                                            fVar.D(str);
                                            fVar.y(customDialogData);
                                            fVar.N(str8);
                                            fVar.B(contriInfo);
                                            fVar.M(videoEasterEggData);
                                            fVar.z(aVar);
                                            fVar.F(iconStampData);
                                            d.a.n0.e3.q0.b.a("doInBackground end");
                                            d.a.n0.e3.q0.b.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                            return fVar;
                                        }
                                    } catch (JSONException e12) {
                                        e = e12;
                                        str3 = optString;
                                        aVar = null;
                                        str = null;
                                        str2 = null;
                                    }
                                } catch (JSONException e13) {
                                    e = e13;
                                    str3 = optString;
                                    aVar = null;
                                    str = null;
                                    str2 = null;
                                    customDialogData = null;
                                    videoEasterEggData = null;
                                    jSONException = e;
                                    iconStampData = null;
                                    jSONException.printStackTrace();
                                    if (StringUtils.isNull(str3)) {
                                    }
                                    fVar.C(str3);
                                    fVar.I(str4);
                                    fVar.A(str5);
                                    fVar.L(str6);
                                    fVar.H(str7);
                                    fVar.G(r6);
                                    fVar.E(str2);
                                    fVar.D(str);
                                    fVar.y(customDialogData);
                                    fVar.N(str8);
                                    fVar.B(contriInfo);
                                    fVar.M(videoEasterEggData);
                                    fVar.z(aVar);
                                    fVar.F(iconStampData);
                                    d.a.n0.e3.q0.b.a("doInBackground end");
                                    d.a.n0.e3.q0.b.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                    return fVar;
                                }
                            } catch (JSONException e14) {
                                e = e14;
                                str3 = optString;
                                aVar = null;
                                str = null;
                                str2 = null;
                                str8 = null;
                                customDialogData = null;
                                videoEasterEggData = null;
                                jSONException = e;
                                iconStampData = null;
                                jSONException.printStackTrace();
                                if (StringUtils.isNull(str3)) {
                                }
                                fVar.C(str3);
                                fVar.I(str4);
                                fVar.A(str5);
                                fVar.L(str6);
                                fVar.H(str7);
                                fVar.G(r6);
                                fVar.E(str2);
                                fVar.D(str);
                                fVar.y(customDialogData);
                                fVar.N(str8);
                                fVar.B(contriInfo);
                                fVar.M(videoEasterEggData);
                                fVar.z(aVar);
                                fVar.F(iconStampData);
                                d.a.n0.e3.q0.b.a("doInBackground end");
                                d.a.n0.e3.q0.b.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                return fVar;
                            }
                        } catch (JSONException e15) {
                            e = e15;
                            str3 = optString;
                            aVar = null;
                            str = null;
                            str2 = null;
                            str7 = null;
                            str8 = null;
                            customDialogData = null;
                            videoEasterEggData = null;
                            jSONException = e;
                            iconStampData = null;
                            jSONException.printStackTrace();
                            if (StringUtils.isNull(str3)) {
                            }
                            fVar.C(str3);
                            fVar.I(str4);
                            fVar.A(str5);
                            fVar.L(str6);
                            fVar.H(str7);
                            fVar.G(r6);
                            fVar.E(str2);
                            fVar.D(str);
                            fVar.y(customDialogData);
                            fVar.N(str8);
                            fVar.B(contriInfo);
                            fVar.M(videoEasterEggData);
                            fVar.z(aVar);
                            fVar.F(iconStampData);
                            d.a.n0.e3.q0.b.a("doInBackground end");
                            d.a.n0.e3.q0.b.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                            return fVar;
                        }
                    } else {
                        iconStampData = null;
                        aVar = null;
                        str = null;
                        str2 = null;
                        str3 = null;
                        str4 = null;
                        str5 = null;
                        str6 = null;
                        str7 = null;
                        str8 = null;
                        customDialogData = null;
                        videoEasterEggData = null;
                    }
                } catch (JSONException e16) {
                    jSONException = e16;
                    iconStampData = null;
                    aVar = null;
                    str = null;
                    str2 = null;
                    str3 = null;
                    str4 = null;
                    str5 = null;
                    str6 = null;
                    str7 = null;
                    str8 = null;
                    customDialogData = null;
                    videoEasterEggData = null;
                }
                if (StringUtils.isNull(str3)) {
                    str3 = TbadkCoreApplication.getInst().getString(R.string.send_success);
                }
                fVar.C(str3);
                fVar.I(str4);
                fVar.A(str5);
                fVar.L(str6);
                fVar.H(str7);
                fVar.G(r6);
                fVar.E(str2);
                fVar.D(str);
                fVar.y(customDialogData);
                fVar.N(str8);
                fVar.B(contriInfo);
                fVar.M(videoEasterEggData);
                fVar.z(aVar);
                fVar.F(iconStampData);
            }
            d.a.n0.e3.q0.b.a("doInBackground end");
            d.a.n0.e3.q0.b.a("发帖：任务后台执行 开始 doInBackground 完全结束");
            return fVar;
        }

        public final void c(d.a.n0.e3.q0.f fVar) {
            if (d.a.n0.e3.n0.f.a(fVar.f(), AuthTokenData.parse(this.f20893b), NewWriteModel.this.s)) {
                return;
            }
            if (fVar.u()) {
                NewWriteModel.this.X(fVar);
            } else if (fVar.x()) {
                NewWriteModel.this.W(fVar);
                NewWriteModel.this.X(fVar);
            } else if (d.a.n0.o3.a.c(fVar.f())) {
                NewWriteModel.this.V(fVar);
                NewWriteModel.this.X(fVar);
            } else if (fVar.v()) {
                i0 i0Var = new i0();
                i0Var.e(this.f20893b);
                if (i0Var.c() == null || NewWriteModel.this.f20880g == null) {
                    return;
                }
                NewWriteModel.this.f20880g.setVcodeMD5(i0Var.b());
                NewWriteModel.this.f20880g.setVcodeUrl(i0Var.c());
                NewWriteModel newWriteModel = NewWriteModel.this;
                newWriteModel.Y(fVar, null, i0Var, newWriteModel.f20880g);
            } else if (fVar.t()) {
                AccessState accessState = new AccessState();
                accessState.parserJson(this.f20893b);
                NewWriteModel newWriteModel2 = NewWriteModel.this;
                newWriteModel2.Y(fVar, accessState, null, newWriteModel2.f20880g);
            } else if (fVar.w()) {
                NewWriteModel.this.X(fVar);
            } else {
                NewWriteModel.this.X(fVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.f20894c = true;
            d.a.n0.e3.i0.a aVar = this.f20892a;
            if (aVar != null) {
                aVar.b();
            }
            if (NewWriteModel.this.m != null) {
                NewWriteModel.this.m.callback(false, null, null, NewWriteModel.this.f20880g, null);
            } else if (NewWriteModel.this.l != null) {
                NewWriteModel.this.l.a(false, null, null, null, null);
            }
            super.cancel(true);
            NewWriteModel.this.f20878e = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x01e7, code lost:
            if (r5 != 7) goto L54;
         */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPostExecute(d.a.n0.e3.q0.f fVar) {
            String i2;
            String h2;
            super.onPostExecute(fVar);
            d.a.n0.e3.q0.b.a("onPostExecute start");
            d.a.n0.e3.q0.b.a("发帖： onPostExecute");
            NewWriteModel.this.f20878e = null;
            if (fVar != null && fVar.f() != 0) {
                d.a.m0.r.z.a.a(AlbumActivityConfig.FROM_WRITE, 0L, 0, "write_result", fVar.f(), fVar.g(), "tid", fVar.p(), "pid", fVar.l());
            }
            if (!this.f20894c && fVar != null) {
                if (fVar.s()) {
                    d.a.n0.e3.q0.b.a("onPostExecute error");
                    c(fVar);
                    d.a.n0.u1.g gVar = this.f20896e;
                    if (gVar != null) {
                        gVar.h(fVar.f54226a, fVar.g());
                    }
                } else {
                    d.a.n0.e3.q0.b.a("onPostExecute success");
                    if (NewWriteModel.this.m == null) {
                        if (NewWriteModel.this.l != null) {
                            NewWriteModel.this.l.a(true, fVar.g(), null, null, fVar.c());
                        }
                    } else {
                        if (!StringUtils.isNull(fVar.m()) && !StringUtils.isNull(fVar.d())) {
                            i2 = fVar.m();
                            h2 = fVar.d();
                        } else if (StringUtils.isNull(fVar.h()) && StringUtils.isNull(fVar.i())) {
                            i2 = null;
                            h2 = null;
                        } else {
                            i2 = fVar.i();
                            h2 = fVar.h();
                        }
                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(fVar.f(), fVar.g(), i2, h2);
                        postWriteCallBackData.setThreadId(fVar.p());
                        postWriteCallBackData.setPostId(fVar.l());
                        postWriteCallBackData.setIsCopyTWZhibo(fVar.k());
                        postWriteCallBackData.setErrorString(fVar.g());
                        postWriteCallBackData.setActivityDialog(fVar.a());
                        postWriteCallBackData.setVideoid(fVar.r());
                        postWriteCallBackData.setContriInfo(fVar.e());
                        if (NewWriteModel.this.f20880g != null) {
                            postWriteCallBackData.setProZone(NewWriteModel.this.f20880g.getProZone());
                            postWriteCallBackData.setGeneralTabId(NewWriteModel.this.f20880g.getTabId());
                        }
                        postWriteCallBackData.setVideoEasterEggData(fVar.q());
                        postWriteCallBackData.setmAdverSegmentData(fVar.b());
                        postWriteCallBackData.setIconStampData(fVar.j());
                        i0 i0Var = new i0();
                        i0Var.e(this.f20893b);
                        NewWriteModel.this.m.callback(true, postWriteCallBackData, i0Var, NewWriteModel.this.f20880g, fVar.c());
                        if (NewWriteModel.this.f20880g != null && d.a.n0.e3.q0.a.f().e() != null) {
                            d.a.n0.e3.q0.a.f().q(NewWriteModel.this.f20880g.getForumId());
                            d.a.n0.e3.q0.a.f().r(NewWriteModel.this.f20880g.getForumName());
                            if (NewWriteModel.this.f20880g.getVideoInfo() != null) {
                                postWriteCallBackData.writeDataForVideo = NewWriteModel.this.f20880g;
                            }
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001383, postWriteCallBackData);
                            customResponsedMessage.setOrginalMessage(new CustomMessage(2001383, d.a.n0.e3.q0.a.f().e()));
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                            d.a.n0.e3.q0.a.f().o(null);
                        }
                        CustomDialogData activityDialog = postWriteCallBackData.getActivityDialog();
                        if (activityDialog != null && fVar.j() == null) {
                            if (NewWriteModel.this.f20880g != null) {
                                int type = NewWriteModel.this.f20880g.getType();
                                if (type != 0) {
                                    if (type == 1 || type == 2) {
                                        activityDialog.type = 1;
                                    } else if (type != 4) {
                                        if (type != 9) {
                                            if (type != 6) {
                                            }
                                        }
                                    }
                                }
                                activityDialog.type = 2;
                            }
                            d.a.c.e.m.e.a().postDelayed(new a(activityDialog), 1000L);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001375, Boolean.valueOf(fVar.j() == null)));
                    d.a.n0.u1.g gVar2 = this.f20896e;
                    if (gVar2 != null) {
                        gVar2.c();
                    }
                }
                d.a.n0.e3.q0.b.a("发帖： onPostExecute 完全结束");
                return;
            }
            d.a.n0.e3.q0.b.a("发帖： onPostExecute isCanceled");
        }
    }

    public NewWriteModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.f20878e = null;
        this.f20879f = null;
        this.f20880g = null;
        this.f20881h = null;
        this.f20882i = null;
        this.j = null;
        this.l = null;
        this.m = null;
        this.n = false;
        this.s = new c();
        this.o = baseFragmentActivity.getPageContext();
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    public void P() {
        d dVar = this.f20879f;
        if (dVar == null || dVar.isCancelled()) {
            return;
        }
        this.f20879f.cancel();
    }

    public boolean Q() {
        WriteData writeData = this.f20880g;
        if (writeData == null) {
            return true;
        }
        return (writeData.getWriteImagesInfo() != null ? this.f20880g.getWriteImagesInfo().size() + 0 : 0) <= MAX_IMG_NUM;
    }

    public final void R() {
        if (this.f20878e == null) {
            if (d.a.n0.e3.q0.a.f().e() != null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001378, T());
                customResponsedMessage.setOrginalMessage(new CustomMessage(2001378, d.a.n0.e3.q0.a.f().e()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
            this.f20878e = new h();
            d.a.n0.e3.q0.b.a("dealPost()");
            this.f20878e.execute(new Integer[0]);
        }
    }

    public final ImageUploadResult S(String str, d.a.n0.e3.i0.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.clearAllActions();
        imageFileInfo.addPersistAction(d.a.m0.b0.g.d.g(TbImageHelper.getInstance().getPostImageSize(), TbImageHelper.getInstance().getPostImageHeightLimit()));
        return aVar.g(imageFileInfo, true);
    }

    public WriteData T() {
        return this.f20880g;
    }

    public void U() {
        SpanGroupManager spanGroupManager = this.q;
        if (spanGroupManager != null) {
            this.r = spanGroupManager.t();
        } else {
            this.r = null;
        }
    }

    public final void V(d.a.n0.e3.q0.f fVar) {
        d.a.c.a.f<?> fVar2 = this.o;
        if (fVar2 == null || fVar == null || (this.m instanceof d.a.n0.e3.q0.a)) {
            return;
        }
        d.a.n0.o3.a.d(fVar2.getPageActivity(), fVar.g());
        fVar.C(null);
    }

    public final void W(d.a.n0.e3.q0.f fVar) {
        if (this.o == null || fVar == null || fVar.c() == null || fVar.c().mFrsForbidenDialogInfo == null) {
            return;
        }
        AntiHelper.p(this.o.getPageActivity(), fVar.c().mFrsForbidenDialogInfo.ahead_url);
    }

    public final void X(d.a.n0.e3.q0.f fVar) {
        Y(fVar, null, null, this.f20880g);
    }

    public final void Y(d.a.n0.e3.q0.f fVar, AccessState accessState, i0 i0Var, WriteData writeData) {
        if (fVar == null) {
            return;
        }
        if (this.m != null) {
            PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(fVar.f(), fVar.g(), null, null);
            postWriteCallBackData.setAccessState(accessState);
            postWriteCallBackData.setSensitiveWords(fVar.o());
            postWriteCallBackData.setReplyPrivacyTip(fVar.n());
            this.m.callback(false, postWriteCallBackData, i0Var, writeData, fVar.c());
            return;
        }
        f fVar2 = this.l;
        if (fVar2 != null) {
            fVar2.a(false, fVar.g(), i0Var, writeData, fVar.c());
        }
    }

    public void Z(boolean z) {
        this.n = z;
    }

    public void a0(e eVar) {
        this.k = eVar;
    }

    public void b0(byte[] bArr, String str) {
        this.j = bArr;
        this.f20882i = str;
    }

    public void c0(f fVar) {
        this.l = fVar;
    }

    public final void cancel() {
        h hVar = this.f20878e;
        if (hVar != null && !hVar.isCancelled()) {
            this.f20878e.cancel();
            return;
        }
        g gVar = this.m;
        if (gVar != null) {
            gVar.callback(false, null, null, this.f20880g, null);
            return;
        }
        f fVar = this.l;
        if (fVar != null) {
            fVar.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        h hVar = this.f20878e;
        if (hVar == null || hVar.isCancelled()) {
            return false;
        }
        this.f20878e.cancel();
        return false;
    }

    public void d0(g gVar) {
        this.m = gVar;
    }

    public void e0(@Nullable d.a.c.a.f<?> fVar) {
        if (fVar != null) {
            this.o = fVar;
            this.unique_id = fVar.getUniqueId();
            return;
        }
        this.o = null;
        this.unique_id = null;
    }

    public void f0(WriteData writeData) {
        this.f20880g = writeData;
    }

    public boolean g0() {
        if (this.f20880g == null) {
            return false;
        }
        d.a.n0.e3.q0.b.a("发帖：开始上传");
        this.f20880g.startPublish();
        i1.g(this.f20880g, 0).e(true);
        R();
        return true;
    }

    public void h0() {
        if (this.f20879f == null) {
            d dVar = new d();
            this.f20879f = dVar;
            dVar.execute(new Void[0]);
        }
    }

    public boolean i0() {
        if (this.f20880g == null) {
            return false;
        }
        if (j.z() && !j.H() && this.f20880g.getWriteImagesInfo() != null && this.f20880g.getWriteImagesInfo().size() != 0 && this.f20880g.getWriteImagesInfo().isOriginalImg() && !d.a.m0.r.d0.b.j().g("original_img_up_tip", false)) {
            d.a.m0.r.d0.b.j().t("original_img_up_tip", true);
            d.a.c.a.f<?> fVar = this.o;
            if (fVar == null) {
                R();
                return true;
            }
            d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(fVar.getPageActivity());
            aVar.setMessageId(R.string.original_img_up_no_wifi_tip);
            aVar.setPositiveButton(R.string.alert_yes_button, new a(aVar));
            aVar.setNegativeButton(R.string.cancel, new b(aVar));
            aVar.create(this.o);
            aVar.show();
        } else {
            R();
        }
        return true;
    }

    public void setSpanGroupManager(SpanGroupManager spanGroupManager) {
        this.q = spanGroupManager;
    }

    public NewWriteModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.f20878e = null;
        this.f20879f = null;
        this.f20880g = null;
        this.f20881h = null;
        this.f20882i = null;
        this.j = null;
        this.l = null;
        this.m = null;
        this.n = false;
        this.s = new c();
        this.o = baseActivity.getPageContext();
    }

    public NewWriteModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.f20878e = null;
        this.f20879f = null;
        this.f20880g = null;
        this.f20881h = null;
        this.f20882i = null;
        this.j = null;
        this.l = null;
        this.m = null;
        this.n = false;
        this.s = new c();
        this.o = tbPageContext;
    }

    public NewWriteModel() {
        this.f20878e = null;
        this.f20879f = null;
        this.f20880g = null;
        this.f20881h = null;
        this.f20882i = null;
        this.j = null;
        this.l = null;
        this.m = null;
        this.n = false;
        this.s = new c();
        this.o = null;
    }
}
