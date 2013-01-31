package com.baidu.tieba.nearby;

import android.location.Location;
import android.os.AsyncTask;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.a.aa;
import com.baidu.tieba.a.ab;
import com.baidu.tieba.a.ac;
import com.baidu.tieba.c.af;
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
    public com.baidu.tieba.a.y doInBackground(String... strArr) {
        com.baidu.tieba.a.y yVar;
        Exception e;
        try {
        } catch (Exception e2) {
            yVar = null;
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
        af.e(getClass().getName(), "latitude = ", valueOf);
        af.e(getClass().getName(), "longitude = ", valueOf2);
        String i = this.b.i();
        if (this.b.b()) {
            yVar = new com.baidu.tieba.a.y();
            try {
                yVar.a(i);
            } catch (Exception e3) {
                e = e3;
                af.b(getClass().getName(), "doInBackground", e.getMessage());
                return yVar;
            }
        } else {
            yVar = null;
        }
        return yVar;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        ProgressBar progressBar;
        TextView textView;
        progressBar = this.a.G;
        progressBar.setVisibility(0);
        textView = this.a.g;
        textView.setVisibility(8);
        super.onPreExecute();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.a.y yVar) {
        ProgressBar progressBar;
        TextView textView;
        TextView textView2;
        Handler handler;
        Handler handler2;
        Handler handler3;
        LbsView lbsView;
        int size;
        ab abVar;
        com.baidu.tieba.c.a aVar;
        com.baidu.tieba.c.d dVar;
        int size2;
        LbsView lbsView2;
        super.onPostExecute(yVar);
        progressBar = this.a.G;
        progressBar.setVisibility(8);
        this.a.m = null;
        this.a.u();
        this.a.r();
        if (yVar == null) {
            textView = this.a.g;
            textView.setVisibility(0);
            textView2 = this.a.g;
            textView2.setText(this.b.f());
            return;
        }
        int size3 = yVar.b().size();
        for (int i = 0; i < size3; i++) {
            ac acVar = (ac) yVar.b().get(i);
            if (acVar.a() >= 1000) {
                lbsView2 = this.a.c;
                lbsView2.a(String.valueOf(String.valueOf(acVar.a() / LocationClientOption.MIN_SCAN_SPAN)) + "km");
            } else {
                lbsView = this.a.c;
                lbsView.a(String.valueOf(String.valueOf(acVar.a())) + "m");
            }
            ArrayList b = acVar.b();
            ArrayList c = acVar.c();
            int size4 = b != null ? b.size() + 0 : 0;
            int size5 = c != null ? size4 + c.size() : size4;
            if (b != null && (size2 = b.size()) > 0) {
                for (int i2 = 0; i2 < size2; i2++) {
                    aa aaVar = (aa) b.get(i2);
                    if (aaVar != null) {
                        this.a.a((size3 - i) - 1, size5, aaVar);
                    }
                }
            }
            if (c != null && (size = c.size()) > 0) {
                for (int i3 = 0; i3 < size; i3++) {
                    ArrayList arrayList = (ArrayList) c.get(i3);
                    if (arrayList != null && arrayList.size() > 0 && (abVar = (ab) arrayList.get(0)) != null) {
                        if (abVar.a() == 1 && abVar.d() != null) {
                            this.a.a((size3 - i) - 1, size5, arrayList);
                            aVar = this.a.F;
                            String d = abVar.d();
                            dVar = this.a.D;
                            aVar.a(d, dVar);
                        } else {
                            this.a.b((size3 - i) - 1, size5, arrayList);
                        }
                    }
                }
            }
        }
        if (this.a.getParent() != null && (this.a.getParent() instanceof NearbyActivity) && yVar.a() != null) {
            ((NearbyActivity) this.a.getParent()).a(yVar.a().a() + yVar.a().b() + yVar.a().c());
        }
        this.a.B = true;
        handler = this.a.A;
        handler.removeMessages(1);
        handler2 = this.a.A;
        handler3 = this.a.A;
        handler2.sendMessageDelayed(handler3.obtainMessage(1), 5000L);
        this.a.t();
    }

    public void a() {
        ProgressBar progressBar;
        TextView textView;
        this.a.m = null;
        progressBar = this.a.G;
        progressBar.setVisibility(8);
        textView = this.a.g;
        textView.setVisibility(8);
        super.cancel(true);
    }
}
