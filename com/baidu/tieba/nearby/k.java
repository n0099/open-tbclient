package com.baidu.tieba.nearby;

import android.location.Location;
import android.os.AsyncTask;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.a.aa;
import com.baidu.tieba.a.ab;
import com.baidu.tieba.c.ae;
import com.baidu.tieba.view.LbsView;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends AsyncTask {
    final /* synthetic */ LbsActivity a;
    private com.baidu.tieba.c.t b = null;
    private Location c;

    public k(LbsActivity lbsActivity, Location location) {
        this.a = lbsActivity;
        this.c = null;
        this.c = location;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.baidu.tieba.a.x doInBackground(String... strArr) {
        com.baidu.tieba.a.x xVar;
        Exception e;
        try {
        } catch (Exception e2) {
            xVar = null;
            e = e2;
        }
        if (this.c == null) {
            return null;
        }
        this.b = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/f/lbs/map");
        String valueOf = String.valueOf(this.c.getLatitude());
        String valueOf2 = String.valueOf(this.c.getLongitude());
        this.b.a("lat", valueOf);
        this.b.a("lng", valueOf2);
        ae.c(getClass().getName(), "latitude = ", valueOf);
        ae.c(getClass().getName(), "longitude = ", valueOf2);
        String i = this.b.i();
        if (this.b.b()) {
            xVar = new com.baidu.tieba.a.x();
            try {
                xVar.a(i);
            } catch (Exception e3) {
                e = e3;
                ae.b(getClass().getName(), "doInBackground", e.getMessage());
                return xVar;
            }
        } else {
            xVar = null;
        }
        return xVar;
    }

    public void a() {
        ProgressBar progressBar;
        TextView textView;
        this.a.l = null;
        progressBar = this.a.F;
        progressBar.setVisibility(8);
        textView = this.a.f;
        textView.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.a.x xVar) {
        ProgressBar progressBar;
        TextView textView;
        TextView textView2;
        Handler handler;
        Handler handler2;
        Handler handler3;
        LbsView lbsView;
        int size;
        aa aaVar;
        com.baidu.tieba.c.a aVar;
        com.baidu.tieba.c.d dVar;
        int size2;
        LbsView lbsView2;
        super.onPostExecute(xVar);
        progressBar = this.a.F;
        progressBar.setVisibility(8);
        this.a.l = null;
        this.a.s();
        this.a.p();
        if (xVar == null) {
            textView = this.a.f;
            textView.setVisibility(0);
            textView2 = this.a.f;
            textView2.setText(this.b.f());
            return;
        }
        int size3 = xVar.b().size();
        for (int i = 0; i < size3; i++) {
            ab abVar = (ab) xVar.b().get(i);
            if (abVar.a() >= 1000) {
                lbsView2 = this.a.b;
                lbsView2.a(String.valueOf(String.valueOf(abVar.a() / LocationClientOption.MIN_SCAN_SPAN)) + "km");
            } else {
                lbsView = this.a.b;
                lbsView.a(String.valueOf(String.valueOf(abVar.a())) + "m");
            }
            ArrayList b = abVar.b();
            ArrayList c = abVar.c();
            int size4 = b != null ? b.size() + 0 : 0;
            int size5 = c != null ? size4 + c.size() : size4;
            if (b != null && (size2 = b.size()) > 0) {
                for (int i2 = 0; i2 < size2; i2++) {
                    com.baidu.tieba.a.z zVar = (com.baidu.tieba.a.z) b.get(i2);
                    if (zVar != null) {
                        this.a.a((size3 - i) - 1, size5, zVar);
                    }
                }
            }
            if (c != null && (size = c.size()) > 0) {
                for (int i3 = 0; i3 < size; i3++) {
                    ArrayList arrayList = (ArrayList) c.get(i3);
                    if (arrayList != null && arrayList.size() > 0 && (aaVar = (aa) arrayList.get(0)) != null) {
                        if (aaVar.a() != 1 || aaVar.d() == null) {
                            this.a.b((size3 - i) - 1, size5, arrayList);
                        } else {
                            this.a.a((size3 - i) - 1, size5, arrayList);
                            aVar = this.a.E;
                            String d = aaVar.d();
                            dVar = this.a.C;
                            aVar.a(d, dVar);
                        }
                    }
                }
            }
        }
        if (this.a.getParent() != null && (this.a.getParent() instanceof NearbyActivity) && xVar.a() != null) {
            ((NearbyActivity) this.a.getParent()).a(xVar.a().a() + xVar.a().b() + xVar.a().c());
        }
        this.a.A = true;
        handler = this.a.z;
        handler.removeMessages(1);
        handler2 = this.a.z;
        handler3 = this.a.z;
        handler2.sendMessageDelayed(handler3.obtainMessage(1), 5000L);
        this.a.r();
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        ProgressBar progressBar;
        TextView textView;
        progressBar = this.a.F;
        progressBar.setVisibility(0);
        textView = this.a.f;
        textView.setVisibility(8);
        super.onPreExecute();
    }
}
