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
import d.b.c.e.p.j;
import d.b.i0.r.q.i1;
import d.b.i0.r.q.t1;
import d.b.i0.r.s.a;
import d.b.i0.s.c.h0;
import d.b.j0.d3.i0.a;
import d.b.j0.d3.n0.f;
import d.b.j0.t1.k;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class NewWriteModel extends BdBaseModel {
    public static int MAX_IMG_NUM = 10;

    /* renamed from: e  reason: collision with root package name */
    public h f21123e;

    /* renamed from: f  reason: collision with root package name */
    public d f21124f;

    /* renamed from: g  reason: collision with root package name */
    public WriteData f21125g;

    /* renamed from: h  reason: collision with root package name */
    public String f21126h;
    public String i;
    public byte[] j;
    public e k;
    public f l;
    public g m;
    public boolean n;
    public d.b.c.a.f<?> o;
    public a.c p;
    public SpanGroupManager q;
    public String r;
    public f.c s;

    /* loaded from: classes5.dex */
    public class a implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.r.s.a f21127e;

        public a(d.b.i0.r.s.a aVar) {
            this.f21127e = aVar;
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            this.f21127e.dismiss();
            NewWriteModel.this.R();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.r.s.a f21129e;

        public b(d.b.i0.r.s.a aVar) {
            this.f21129e = aVar;
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            this.f21129e.dismiss();
            NewWriteModel.this.cancel();
        }
    }

    /* loaded from: classes5.dex */
    public class c extends f.c {
        public c() {
        }

        @Override // d.b.j0.d3.n0.f.c
        public void a(String str) {
            if (NewWriteModel.this.f21125g == null || TextUtils.isEmpty(str)) {
                if (NewWriteModel.this.m != null) {
                    NewWriteModel.this.m.callback(false, null, null, NewWriteModel.this.f21125g, null);
                    return;
                }
                return;
            }
            NewWriteModel.this.f21123e = null;
            NewWriteModel.this.f21125g.setAuthSid(str);
            NewWriteModel.this.i0();
        }

        @Override // d.b.j0.d3.n0.f.c
        public void c(String str) {
            if (NewWriteModel.this.f21125g == null || TextUtils.isEmpty(str)) {
                if (NewWriteModel.this.m != null) {
                    NewWriteModel.this.m.callback(false, null, null, NewWriteModel.this.f21125g, null);
                    return;
                }
                return;
            }
            NewWriteModel.this.f21123e = null;
            NewWriteModel.this.f21125g.setAuthSid(str);
            NewWriteModel.this.i0();
        }

        @Override // d.b.j0.d3.n0.f.c
        public void d() {
            if (NewWriteModel.this.f21125g != null) {
                NewWriteModel.this.f21125g.setAuthSid(null);
            }
            if (NewWriteModel.this.m != null) {
                NewWriteModel.this.m.callback(false, null, null, NewWriteModel.this.f21125g, null);
            }
        }

        @Override // d.b.j0.d3.n0.f.c
        public void e() {
            if (NewWriteModel.this.f21125g != null) {
                NewWriteModel.this.f21123e = null;
                NewWriteModel.this.f21125g.setAuthSid(null);
                NewWriteModel.this.i0();
            } else if (NewWriteModel.this.m != null) {
                NewWriteModel.this.m.callback(false, null, null, NewWriteModel.this.f21125g, null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends BdAsyncTask<Void, Void, ImageUploadResult> {

        /* renamed from: a  reason: collision with root package name */
        public boolean f21132a = false;

        /* renamed from: b  reason: collision with root package name */
        public d.b.j0.d3.i0.a f21133b = new d.b.j0.d3.i0.a();

        /* renamed from: c  reason: collision with root package name */
        public Bitmap f21134c = null;

        public d() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean isLocalImagePath = FileHelper.isLocalImagePath(NewWriteModel.this.i);
            if (this.f21132a) {
                return null;
            }
            if (NewWriteModel.this.j == null || NewWriteModel.this.j.length <= 0) {
                if (TextUtils.isEmpty(NewWriteModel.this.i) || !isLocalImagePath) {
                    return null;
                }
                Uri parse = Uri.parse(NewWriteModel.this.i);
                NewWriteModel.this.f21126h = FileHelper.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), parse);
                if (TextUtils.isEmpty(NewWriteModel.this.f21126h)) {
                    return null;
                }
                NewWriteModel newWriteModel = NewWriteModel.this;
                return newWriteModel.S(newWriteModel.f21126h, this.f21133b);
            }
            Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(NewWriteModel.this.j);
            this.f21134c = Bytes2Bitmap;
            if (Bytes2Bitmap == null) {
                return null;
            }
            NewWriteModel.this.f21126h = FileHelper.saveFileToSDOrMemory(TbConfig.IMAGE_RESIZED_FILE, Bytes2Bitmap, 85);
            if (TextUtils.isEmpty(NewWriteModel.this.f21126h)) {
                Bitmap bitmap = this.f21134c;
                if (bitmap != null && !bitmap.isRecycled()) {
                    this.f21134c.recycle();
                }
                return null;
            }
            NewWriteModel newWriteModel2 = NewWriteModel.this;
            return newWriteModel2.S(newWriteModel2.f21126h, this.f21133b);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (this.f21132a) {
                return;
            }
            if (NewWriteModel.this.k != null) {
                NewWriteModel.this.k.a(imageUploadResult, false);
            }
            Bitmap bitmap = this.f21134c;
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            this.f21134c.recycle();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.f21132a = true;
            d.b.j0.d3.i0.a aVar = this.f21133b;
            if (aVar != null) {
                aVar.b();
            }
            if (NewWriteModel.this.k != null) {
                NewWriteModel.this.k.a(null, true);
            }
            Bitmap bitmap = this.f21134c;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.f21134c.recycle();
            }
            super.cancel();
            NewWriteModel.this.f21124f = null;
        }
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a(ImageUploadResult imageUploadResult, boolean z);
    }

    /* loaded from: classes5.dex */
    public interface f {
        void a(boolean z, String str, h0 h0Var, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes5.dex */
    public interface g {
        void callback(boolean z, PostWriteCallBackData postWriteCallBackData, h0 h0Var, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes5.dex */
    public class h extends BdAsyncTask<Integer, Integer, d.b.j0.d3.q0.f> {

        /* renamed from: a  reason: collision with root package name */
        public d.b.j0.d3.i0.a f21136a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f21137b = null;

        /* renamed from: c  reason: collision with root package name */
        public boolean f21138c = false;

        /* renamed from: d  reason: collision with root package name */
        public k f21139d;

        /* renamed from: e  reason: collision with root package name */
        public d.b.j0.t1.g f21140e;

        /* loaded from: classes5.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomDialogData f21142e;

            public a(CustomDialogData customDialogData) {
                this.f21142e = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.b.j0.d2.j.c.a((TbPageContext) NewWriteModel.this.o, this.f21142e).show();
            }
        }

        public h() {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
            if (runTask != null) {
                this.f21139d = (k) runTask.getData();
            }
            k kVar = this.f21139d;
            if (kVar != null) {
                this.f21140e = kVar.get();
            }
            setPriority(3);
            d.b.j0.d3.q0.b.a("发帖：任务创建：PostThreadTask");
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:137:0x02fd  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public d.b.j0.d3.q0.f doInBackground(Integer... numArr) {
            d.b.j0.d3.q0.f fVar;
            JSONArray jSONArray;
            JSONException jSONException;
            IconStampData iconStampData;
            d.b.i0.t.a aVar;
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
            if (this.f21138c) {
                return null;
            }
            d.b.i0.a0.d.c(NewWriteModel.this.f21125g.getContent());
            d.b.j0.d3.q0.b.a("doInBackground() start");
            d.b.j0.d3.q0.b.a("发帖：任务后台执行 开始 doInBackground");
            d.b.j0.d3.i0.a aVar2 = new d.b.j0.d3.i0.a();
            this.f21136a = aVar2;
            aVar2.j(NewWriteModel.this.q);
            this.f21136a.k(NewWriteModel.this.r);
            this.f21136a.l(this.f21140e);
            this.f21136a.i(NewWriteModel.this.p);
            this.f21137b = this.f21136a.h(NewWriteModel.this.f21125g, NewWriteModel.this.n);
            d.b.j0.d3.q0.b.a("发帖：任务后台执行 开始 doInBackground 结束");
            ErrorData d2 = this.f21136a.d();
            if (this.f21136a.e() && this.f21137b != null) {
                d.b.j0.d3.q0.b.a("发帖：任务后台执行 开始 doInBackground 成功");
                AntiData c2 = this.f21136a.c();
                String error_msg = d2.getError_msg();
                if (d.b.c.e.p.k.isEmpty(error_msg)) {
                    error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_success);
                }
                fVar = new d.b.j0.d3.q0.f(d2.getError_code(), error_msg, c2);
                if (NewWriteModel.this.f21125g != null && NewWriteModel.this.f21125g.isHasImages() && !fVar.s()) {
                    NewWriteModel.this.f21125g.deleteUploadedTempImages();
                }
                d.b.j0.d3.q0.b.a("发帖：任务后台执行 开始 doInBackground 删除临时的图片");
            } else if (d2 != null && d2.error_code == 220015) {
                fVar = new d.b.j0.d3.q0.f(d2.getError_code(), d2.getError_msg(), null);
                if (this.f21137b != null) {
                    try {
                        JSONObject optJSONObject = new JSONObject(this.f21137b).optJSONObject("info");
                        if (optJSONObject != null && (jSONArray = optJSONObject.getJSONArray("confilter_hitwords")) != null && jSONArray.length() > 0) {
                            int length = jSONArray.length();
                            ArrayList<String> arrayList = new ArrayList<>();
                            for (int i = 0; i < length; i++) {
                                arrayList.add(jSONArray.optString(i));
                            }
                            fVar.K(arrayList);
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                d.b.j0.d3.q0.b.a("发帖：任务后台执行 开始 doInBackground 失败 1");
            } else if (d2 != null && d2.error_code == 238010) {
                fVar = new d.b.j0.d3.q0.f(d2.getError_code(), d2.getError_msg(), null);
                if (this.f21137b != null) {
                    try {
                        JSONObject optJSONObject2 = new JSONObject(this.f21137b).optJSONObject("info");
                        if (optJSONObject2 != null) {
                            t1 t1Var = new t1();
                            t1Var.f51631a = optJSONObject2.optString("block_content");
                            t1Var.f51632b = optJSONObject2.optString("block_cancel");
                            t1Var.f51633c = optJSONObject2.optString("block_confirm");
                            fVar.J(t1Var);
                        }
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                }
                d.b.j0.d3.q0.b.a("发帖：任务后台执行 开始 doInBackground 失败 2");
            } else if (d2 != null && d2.error_code != 0) {
                String error_msg2 = d2.getError_msg();
                if (StringUtils.isNull(error_msg2)) {
                    if (d2.error_code == 3250013) {
                        error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.anti_account_exception_appealing);
                    } else {
                        error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                    }
                }
                fVar = new d.b.j0.d3.q0.f(d2.getError_code(), error_msg2, this.f21136a.c());
                d.b.j0.d3.q0.b.a("发帖：任务后台执行 开始 doInBackground 失败 3");
            } else {
                fVar = new d.b.j0.d3.q0.f(-17, TbadkCoreApplication.getInst().getApp().getString(R.string.neterror), null);
                d.b.j0.d3.q0.b.a("发帖：任务后台执行 开始 doInBackground 失败 4");
            }
            if (!fVar.s()) {
                ContriInfo contriInfo = new ContriInfo();
                try {
                    if (this.f21137b != null) {
                        JSONObject jSONObject = new JSONObject(this.f21137b);
                        String optString = jSONObject.optString("msg");
                        try {
                            str4 = jSONObject.optString("pre_msg");
                            try {
                                str5 = jSONObject.optString("color_msg");
                            } catch (JSONException e4) {
                                e = e4;
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
                                d.b.j0.d3.q0.b.a("doInBackground end");
                                d.b.j0.d3.q0.b.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                return fVar;
                            }
                            try {
                                str6 = jSONObject.optString("tid");
                            } catch (JSONException e5) {
                                e = e5;
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
                                d.b.j0.d3.q0.b.a("doInBackground end");
                                d.b.j0.d3.q0.b.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                return fVar;
                            }
                            try {
                                str7 = jSONObject.optString("pid");
                                try {
                                    str8 = jSONObject.optString("video_id");
                                } catch (JSONException e6) {
                                    e = e6;
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
                                    d.b.j0.d3.q0.b.a("doInBackground end");
                                    d.b.j0.d3.q0.b.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                    return fVar;
                                }
                            } catch (JSONException e7) {
                                e = e7;
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
                                d.b.j0.d3.q0.b.a("doInBackground end");
                                d.b.j0.d3.q0.b.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                return fVar;
                            }
                        } catch (JSONException e8) {
                            e = e8;
                            str3 = optString;
                            aVar = null;
                            str = null;
                            str2 = null;
                            str4 = null;
                        }
                        try {
                            customDialogData = d.b.j0.d2.b.a(jSONObject);
                            try {
                                JSONObject optJSONObject3 = jSONObject.optJSONObject("twzhibo_info");
                                r6 = optJSONObject3 != null ? optJSONObject3.optInt("is_copytwzhibo", 0) : 0;
                                JSONObject optJSONObject4 = jSONObject.optJSONObject("exp");
                                if (optJSONObject4 != null) {
                                    str2 = optJSONObject4.optString("pre_msg");
                                    try {
                                        str = optJSONObject4.optString("color_msg");
                                    } catch (JSONException e9) {
                                        e = e9;
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
                                        d.b.j0.d3.q0.b.a("doInBackground end");
                                        d.b.j0.d3.q0.b.a("发帖：任务后台执行 开始 doInBackground 完全结束");
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
                                        } catch (JSONException e10) {
                                            e = e10;
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
                                            d.b.j0.d3.q0.b.a("doInBackground end");
                                            d.b.j0.d3.q0.b.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                            return fVar;
                                        }
                                    } else {
                                        videoEasterEggData = null;
                                    }
                                    JSONObject optJSONObject6 = jSONObject.optJSONObject("advertisement");
                                    if (optJSONObject6 != null) {
                                        aVar = new d.b.i0.t.a();
                                        try {
                                            aVar.i(optJSONObject6);
                                        } catch (JSONException e11) {
                                            e = e11;
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
                                            d.b.j0.d3.q0.b.a("doInBackground end");
                                            d.b.j0.d3.q0.b.a("发帖：任务后台执行 开始 doInBackground 完全结束");
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
                                        } catch (JSONException e12) {
                                            jSONException = e12;
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
                                            d.b.j0.d3.q0.b.a("doInBackground end");
                                            d.b.j0.d3.q0.b.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                            return fVar;
                                        }
                                    } else {
                                        str3 = optString;
                                        iconStampData = null;
                                    }
                                } catch (JSONException e13) {
                                    e = e13;
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
                                    d.b.j0.d3.q0.b.a("doInBackground end");
                                    d.b.j0.d3.q0.b.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                    return fVar;
                                }
                            } catch (JSONException e14) {
                                e = e14;
                                str3 = optString;
                                aVar = null;
                                str = null;
                                str2 = null;
                            }
                        } catch (JSONException e15) {
                            e = e15;
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
                            d.b.j0.d3.q0.b.a("doInBackground end");
                            d.b.j0.d3.q0.b.a("发帖：任务后台执行 开始 doInBackground 完全结束");
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
            d.b.j0.d3.q0.b.a("doInBackground end");
            d.b.j0.d3.q0.b.a("发帖：任务后台执行 开始 doInBackground 完全结束");
            return fVar;
        }

        public final void c(d.b.j0.d3.q0.f fVar) {
            if (d.b.j0.d3.n0.f.a(fVar.f(), AuthTokenData.parse(this.f21137b), NewWriteModel.this.s)) {
                return;
            }
            if (fVar.u()) {
                NewWriteModel.this.X(fVar);
            } else if (fVar.x()) {
                NewWriteModel.this.W(fVar);
                NewWriteModel.this.X(fVar);
            } else if (d.b.j0.n3.a.c(fVar.f())) {
                NewWriteModel.this.V(fVar);
                NewWriteModel.this.X(fVar);
            } else if (fVar.v()) {
                h0 h0Var = new h0();
                h0Var.e(this.f21137b);
                if (h0Var.c() == null || NewWriteModel.this.f21125g == null) {
                    return;
                }
                NewWriteModel.this.f21125g.setVcodeMD5(h0Var.b());
                NewWriteModel.this.f21125g.setVcodeUrl(h0Var.c());
                NewWriteModel newWriteModel = NewWriteModel.this;
                newWriteModel.Y(fVar, null, h0Var, newWriteModel.f21125g);
            } else if (fVar.t()) {
                AccessState accessState = new AccessState();
                accessState.parserJson(this.f21137b);
                NewWriteModel newWriteModel2 = NewWriteModel.this;
                newWriteModel2.Y(fVar, accessState, null, newWriteModel2.f21125g);
            } else if (fVar.w()) {
                NewWriteModel.this.X(fVar);
            } else {
                NewWriteModel.this.X(fVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.f21138c = true;
            d.b.j0.d3.i0.a aVar = this.f21136a;
            if (aVar != null) {
                aVar.b();
            }
            if (NewWriteModel.this.m != null) {
                NewWriteModel.this.m.callback(false, null, null, NewWriteModel.this.f21125g, null);
            } else if (NewWriteModel.this.l != null) {
                NewWriteModel.this.l.a(false, null, null, null, null);
            }
            super.cancel(true);
            NewWriteModel.this.f21123e = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x01ea, code lost:
            if (r5 != 7) goto L54;
         */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPostExecute(d.b.j0.d3.q0.f fVar) {
            String i;
            String h2;
            super.onPostExecute(fVar);
            d.b.j0.d3.q0.b.a("onPostExecute start");
            d.b.j0.d3.q0.b.a("发帖： onPostExecute");
            NewWriteModel.this.f21123e = null;
            if (fVar != null && fVar.f() != 0) {
                d.b.i0.r.z.a.a(AlbumActivityConfig.FROM_WRITE, 0L, 0, "write_result", fVar.f(), fVar.g(), "tid", fVar.p(), "pid", fVar.l());
            }
            if (!this.f21138c && fVar != null) {
                if (fVar.s()) {
                    d.b.j0.d3.q0.b.a("onPostExecute error");
                    c(fVar);
                    d.b.j0.t1.g gVar = this.f21140e;
                    if (gVar != null) {
                        gVar.f(fVar.f55462a, fVar.g());
                    }
                } else {
                    d.b.j0.d3.q0.b.a("onPostExecute success");
                    if (NewWriteModel.this.m == null) {
                        if (NewWriteModel.this.l != null) {
                            NewWriteModel.this.l.a(true, fVar.g(), null, null, fVar.c());
                        }
                    } else {
                        if (!StringUtils.isNull(fVar.m()) && !StringUtils.isNull(fVar.d())) {
                            i = fVar.m();
                            h2 = fVar.d();
                        } else if (StringUtils.isNull(fVar.h()) && StringUtils.isNull(fVar.i())) {
                            i = null;
                            h2 = null;
                        } else {
                            i = fVar.i();
                            h2 = fVar.h();
                        }
                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(fVar.f(), fVar.g(), i, h2);
                        postWriteCallBackData.setThreadId(fVar.p());
                        postWriteCallBackData.setPostId(fVar.l());
                        postWriteCallBackData.setIsCopyTWZhibo(fVar.k());
                        postWriteCallBackData.setErrorString(fVar.g());
                        postWriteCallBackData.setActivityDialog(fVar.a());
                        postWriteCallBackData.setVideoid(fVar.r());
                        postWriteCallBackData.setContriInfo(fVar.e());
                        if (NewWriteModel.this.f21125g != null) {
                            postWriteCallBackData.setProZone(NewWriteModel.this.f21125g.getProZone());
                            postWriteCallBackData.setGeneralTabId(NewWriteModel.this.f21125g.getTabId());
                        }
                        postWriteCallBackData.setVideoEasterEggData(fVar.q());
                        postWriteCallBackData.setmAdverSegmentData(fVar.b());
                        postWriteCallBackData.setIconStampData(fVar.j());
                        h0 h0Var = new h0();
                        h0Var.e(this.f21137b);
                        NewWriteModel.this.m.callback(true, postWriteCallBackData, h0Var, NewWriteModel.this.f21125g, fVar.c());
                        if (NewWriteModel.this.f21125g != null && d.b.j0.d3.q0.a.f().e() != null) {
                            d.b.j0.d3.q0.a.f().q(NewWriteModel.this.f21125g.getForumId());
                            d.b.j0.d3.q0.a.f().r(NewWriteModel.this.f21125g.getForumName());
                            if (NewWriteModel.this.f21125g.getVideoInfo() != null) {
                                postWriteCallBackData.writeDataForVideo = NewWriteModel.this.f21125g;
                            }
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001383, postWriteCallBackData);
                            customResponsedMessage.setOrginalMessage(new CustomMessage(2001383, d.b.j0.d3.q0.a.f().e()));
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                            d.b.j0.d3.q0.a.f().o(null);
                        }
                        CustomDialogData activityDialog = postWriteCallBackData.getActivityDialog();
                        if (activityDialog != null && fVar.j() == null) {
                            if (NewWriteModel.this.f21125g != null) {
                                int type = NewWriteModel.this.f21125g.getType();
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
                            d.b.c.e.m.e.a().postDelayed(new a(activityDialog), 1000L);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001375, Boolean.valueOf(fVar.j() == null)));
                    d.b.j0.t1.g gVar2 = this.f21140e;
                    if (gVar2 != null) {
                        gVar2.g();
                    }
                }
                d.b.j0.d3.q0.b.a("发帖： onPostExecute 完全结束");
                return;
            }
            d.b.j0.d3.q0.b.a("发帖： onPostExecute isCanceled");
        }
    }

    public NewWriteModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.f21123e = null;
        this.f21124f = null;
        this.f21125g = null;
        this.f21126h = null;
        this.i = null;
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
        d dVar = this.f21124f;
        if (dVar == null || dVar.isCancelled()) {
            return;
        }
        this.f21124f.cancel();
    }

    public boolean Q() {
        WriteData writeData = this.f21125g;
        if (writeData == null) {
            return true;
        }
        return (writeData.getWriteImagesInfo() != null ? this.f21125g.getWriteImagesInfo().size() + 0 : 0) <= MAX_IMG_NUM;
    }

    public final void R() {
        if (this.f21123e == null) {
            if (d.b.j0.d3.q0.a.f().e() != null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001378, T());
                customResponsedMessage.setOrginalMessage(new CustomMessage(2001378, d.b.j0.d3.q0.a.f().e()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
            this.f21123e = new h();
            d.b.j0.d3.q0.b.a("dealPost()");
            this.f21123e.execute(new Integer[0]);
        }
    }

    public final ImageUploadResult S(String str, d.b.j0.d3.i0.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.clearAllActions();
        imageFileInfo.addPersistAction(d.b.i0.b0.g.d.g(TbImageHelper.getInstance().getPostImageSize(), TbImageHelper.getInstance().getPostImageHeightLimit()));
        return aVar.g(imageFileInfo, true);
    }

    public WriteData T() {
        return this.f21125g;
    }

    public void U() {
        SpanGroupManager spanGroupManager = this.q;
        if (spanGroupManager != null) {
            this.r = spanGroupManager.t();
        } else {
            this.r = null;
        }
    }

    public final void V(d.b.j0.d3.q0.f fVar) {
        d.b.c.a.f<?> fVar2 = this.o;
        if (fVar2 == null || fVar == null || (this.m instanceof d.b.j0.d3.q0.a)) {
            return;
        }
        d.b.j0.n3.a.d(fVar2.getPageActivity(), fVar.g());
        fVar.C(null);
    }

    public final void W(d.b.j0.d3.q0.f fVar) {
        if (this.o == null || fVar == null || fVar.c() == null || fVar.c().mFrsForbidenDialogInfo == null) {
            return;
        }
        AntiHelper.p(this.o.getPageActivity(), fVar.c().mFrsForbidenDialogInfo.ahead_url);
    }

    public final void X(d.b.j0.d3.q0.f fVar) {
        Y(fVar, null, null, this.f21125g);
    }

    public final void Y(d.b.j0.d3.q0.f fVar, AccessState accessState, h0 h0Var, WriteData writeData) {
        if (fVar == null) {
            return;
        }
        if (this.m != null) {
            PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(fVar.f(), fVar.g(), null, null);
            postWriteCallBackData.setAccessState(accessState);
            postWriteCallBackData.setSensitiveWords(fVar.o());
            postWriteCallBackData.setReplyPrivacyTip(fVar.n());
            this.m.callback(false, postWriteCallBackData, h0Var, writeData, fVar.c());
            return;
        }
        f fVar2 = this.l;
        if (fVar2 != null) {
            fVar2.a(false, fVar.g(), h0Var, writeData, fVar.c());
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
        this.i = str;
    }

    public void c0(f fVar) {
        this.l = fVar;
    }

    public final void cancel() {
        h hVar = this.f21123e;
        if (hVar != null && !hVar.isCancelled()) {
            this.f21123e.cancel();
            return;
        }
        g gVar = this.m;
        if (gVar != null) {
            gVar.callback(false, null, null, this.f21125g, null);
            return;
        }
        f fVar = this.l;
        if (fVar != null) {
            fVar.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        h hVar = this.f21123e;
        if (hVar == null || hVar.isCancelled()) {
            return false;
        }
        this.f21123e.cancel();
        return false;
    }

    public void d0(g gVar) {
        this.m = gVar;
    }

    public void e0(@Nullable d.b.c.a.f<?> fVar) {
        if (fVar != null) {
            this.o = fVar;
            this.unique_id = fVar.getUniqueId();
            return;
        }
        this.o = null;
        this.unique_id = null;
    }

    public void f0(WriteData writeData) {
        this.f21125g = writeData;
    }

    public boolean g0() {
        if (this.f21125g == null) {
            return false;
        }
        d.b.j0.d3.q0.b.a("发帖：开始上传");
        this.f21125g.startPublish();
        i1.g(this.f21125g, 0).e(true);
        R();
        return true;
    }

    public void h0() {
        if (this.f21124f == null) {
            d dVar = new d();
            this.f21124f = dVar;
            dVar.execute(new Void[0]);
        }
    }

    public boolean i0() {
        if (this.f21125g == null) {
            return false;
        }
        if (j.z() && !j.H() && this.f21125g.getWriteImagesInfo() != null && this.f21125g.getWriteImagesInfo().size() != 0 && this.f21125g.getWriteImagesInfo().isOriginalImg() && !d.b.i0.r.d0.b.j().g("original_img_up_tip", false)) {
            d.b.i0.r.d0.b.j().t("original_img_up_tip", true);
            d.b.c.a.f<?> fVar = this.o;
            if (fVar == null) {
                R();
                return true;
            }
            d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(fVar.getPageActivity());
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
        this.f21123e = null;
        this.f21124f = null;
        this.f21125g = null;
        this.f21126h = null;
        this.i = null;
        this.j = null;
        this.l = null;
        this.m = null;
        this.n = false;
        this.s = new c();
        this.o = baseActivity.getPageContext();
    }

    public NewWriteModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.f21123e = null;
        this.f21124f = null;
        this.f21125g = null;
        this.f21126h = null;
        this.i = null;
        this.j = null;
        this.l = null;
        this.m = null;
        this.n = false;
        this.s = new c();
        this.o = tbPageContext;
    }

    public NewWriteModel() {
        this.f21123e = null;
        this.f21124f = null;
        this.f21125g = null;
        this.f21126h = null;
        this.i = null;
        this.j = null;
        this.l = null;
        this.m = null;
        this.n = false;
        this.s = new c();
        this.o = null;
    }
}
