package com.baidu.tieba.widget.share;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.share.ShareContent;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.bu;
import com.baidu.tieba.util.by;
import com.slidingmenu.lib.R;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    private LayoutInflater a;
    private Context b;
    private View c;
    private TextView d;
    private View e;
    private TextView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private Button l;
    private LinearLayout m;
    private AlertDialog n;
    private HashMap<MediaType, String> q;
    private HashMap<String, ShareContent> o = new HashMap<>();
    private boolean p = false;
    private a r = new c(this);

    public b(Context context) {
        this.b = context;
        this.a = (LayoutInflater) context.getSystemService("layout_inflater");
        this.c = this.a.inflate(R.layout.share_dialog_content, (ViewGroup) null);
        this.d = (TextView) this.c.findViewById(R.id.share_dialog_title);
        this.e = this.c.findViewById(R.id.share_dialog_content);
        this.l = (Button) this.c.findViewById(R.id.btnShareCancel);
        this.l.setOnClickListener(this);
        this.f = (TextView) this.c.findViewById(R.id.iconWeixinTimeline);
        this.f.setOnClickListener(this);
        this.g = (TextView) this.c.findViewById(R.id.iconWeixin);
        this.g.setOnClickListener(this);
        this.h = (TextView) this.c.findViewById(R.id.iconQZone);
        this.h.setOnClickListener(this);
        this.i = (TextView) this.c.findViewById(R.id.iconQQWeibo);
        this.i.setOnClickListener(this);
        this.j = (TextView) this.c.findViewById(R.id.iconSinaWeibo);
        this.j.setOnClickListener(this);
        this.k = (TextView) this.c.findViewById(R.id.iconRenren);
        this.k.setOnClickListener(this);
        this.m = (LinearLayout) this.c.findViewById(R.id.customViewBox);
    }

    public void a(a aVar) {
        if (this.r != null) {
            this.r = aVar;
        }
    }

    public void a(HashMap<MediaType, String> hashMap) {
        this.q = hashMap;
    }

    public void a(ShareContent shareContent, boolean z) {
        Location c;
        if (z && (c = c()) != null) {
            shareContent.setLocation(c);
        }
        this.o.put("common_mediatype", shareContent);
    }

    public void a(MediaType mediaType, ShareContent shareContent, boolean z) {
        Location c;
        if (z && (c = c()) != null) {
            shareContent.setLocation(c);
        }
        this.o.put(mediaType.toString(), shareContent);
    }

    private Location c() {
        LocationManager locationManager = (LocationManager) this.b.getSystemService("location");
        Criteria criteria = new Criteria();
        criteria.setAccuracy(1);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setCostAllowed(true);
        criteria.setPowerRequirement(1);
        try {
            return locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria, false));
        } catch (Exception e) {
            return null;
        }
    }

    public void a(View view, View.OnClickListener onClickListener) {
        if (view != null) {
            this.m.addView(view);
            if (onClickListener != null) {
                view.setOnClickListener(onClickListener);
            }
            this.m.setVisibility(0);
        }
    }

    public void a() {
        if (!UtilHelper.b()) {
            com.baidu.adp.lib.g.g.a(this.b, (int) R.string.share_on_no_network);
            return;
        }
        this.n = new AlertDialog.Builder(this.b).create();
        this.n.setCanceledOnTouchOutside(true);
        this.n.show();
        Window window = this.n.getWindow();
        window.setWindowAnimations(R.style.share_dialog_style);
        window.setGravity(80);
        window.setLayout(-1, -2);
        a(this.r);
        window.setContentView(this.c);
        d();
    }

    public void b() {
        if (this.n != null) {
            this.p = false;
            this.n.dismiss();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b();
        if (!this.o.isEmpty()) {
            if (view.getId() == R.id.btnShareCancel || !this.p) {
                this.p = true;
                d dVar = new d(this.b, this.r);
                switch (view.getId()) {
                    case R.id.iconWeixinTimeline /* 2131101199 */:
                        a("share_to_pyq");
                        b(MediaType.WEIXIN_TIMELINE);
                        ShareContent a = a(MediaType.WEIXIN_TIMELINE);
                        if (a != null) {
                            dVar.b(a);
                            return;
                        }
                        return;
                    case R.id.iconWeixin /* 2131101200 */:
                        a("share_to_weixin");
                        b(MediaType.WEIXIN_FRIEND);
                        ShareContent a2 = a(MediaType.WEIXIN_FRIEND);
                        if (a2 != null) {
                            dVar.a(a2);
                            return;
                        }
                        return;
                    case R.id.iconQZone /* 2131101201 */:
                        a("share_to_qzone");
                        b(MediaType.QZONE);
                        ShareContent a3 = a(MediaType.QZONE);
                        if (a3 != null) {
                            dVar.c(a3);
                            return;
                        }
                        return;
                    case R.id.iconQQWeibo /* 2131101202 */:
                        a("share_to_qweibo");
                        b(MediaType.QQWEIBO);
                        ShareContent a4 = a(MediaType.QQWEIBO);
                        if (a4 != null) {
                            dVar.d(a4);
                            return;
                        }
                        return;
                    case R.id.iconSinaWeibo /* 2131101203 */:
                        a("share_to_sweibo");
                        b(MediaType.SINAWEIBO);
                        ShareContent a5 = a(MediaType.SINAWEIBO);
                        if (a5 != null) {
                            dVar.e(a5);
                            return;
                        }
                        return;
                    case R.id.iconRenren /* 2131101204 */:
                        a("share_to_renren");
                        b(MediaType.RENREN);
                        ShareContent a6 = a(MediaType.RENREN);
                        if (a6 != null) {
                            dVar.f(a6);
                            return;
                        }
                        return;
                    case R.id.customViewBox /* 2131101205 */:
                    default:
                        return;
                    case R.id.btnShareCancel /* 2131101206 */:
                        a("share_cancel");
                        this.r.b();
                        return;
                }
            }
        }
    }

    private ShareContent a(MediaType mediaType) {
        if (this.o.containsKey(mediaType.toString())) {
            return this.o.get(mediaType.toString());
        }
        if (!this.o.containsKey("common_mediatype")) {
            return null;
        }
        return this.o.get("common_mediatype");
    }

    private void b(MediaType mediaType) {
        if (mediaType != null) {
            this.p = true;
            if (this.q != null) {
                String str = this.q.get(mediaType);
                if (!bu.c(str)) {
                    a(str);
                }
            }
        }
    }

    private void a(String str) {
        by.a(this.b, str, "click", 1, new Object[0]);
    }

    private void d() {
        a(this.f, R.drawable.icon_unite_share_friend, R.color.share_to, R.drawable.icon_unite_share_friend_1, R.color.share_to_1);
        a(this.g, R.drawable.icon_unite_share_weixin, R.color.share_to, R.drawable.icon_unite_share_weixin_1, R.color.share_to_1);
        a(this.h, R.drawable.icon_unite_share_qqzon, R.color.share_to, R.drawable.icon_unite_share_qqzon_1, R.color.share_to_1);
        a(this.i, R.drawable.icon_unite_share_tencent, R.color.share_to, R.drawable.icon_unite_share_tencent_1, R.color.share_to_1);
        a(this.j, R.drawable.icon_unite_share_sina, R.color.share_to, R.drawable.icon_unite_share_sina_1, R.color.share_to_1);
        a(this.k, R.drawable.icon_unite_share_renren, R.color.share_to, R.drawable.icon_unite_share_renren_1, R.color.share_to_1);
        int paddingLeft = this.d.getPaddingLeft();
        if (TiebaApplication.h().al() == 1) {
            this.e.setBackgroundResource(R.drawable.bg_unite_popup_share_down_1);
            this.d.setBackgroundResource(R.drawable.bg_unite_popup_share_up_1);
            this.d.setTextColor(this.b.getResources().getColor(R.color.share_to_1));
            this.l.setBackgroundResource(R.drawable.btn_w_square_1);
            this.l.setTextColor(this.b.getResources().getColor(R.color.share_to_1));
        } else {
            this.e.setBackgroundResource(R.drawable.bg_unite_popup_share_down);
            this.d.setBackgroundResource(R.drawable.bg_unite_popup_share_up);
            this.d.setTextColor(this.b.getResources().getColor(R.color.share_to));
            this.l.setBackgroundResource(R.drawable.btn_w_square);
            this.l.setTextColor(this.b.getResources().getColor(R.color.share_to));
        }
        this.d.setPadding(paddingLeft, 0, 0, 0);
    }

    private void a(TextView textView, int i, int i2, int i3, int i4) {
        int al = TiebaApplication.h().al();
        if (al != 1) {
            i3 = i;
        }
        if (al != 1) {
            i4 = i2;
        }
        Drawable drawable = this.b.getResources().getDrawable(i3);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        textView.setCompoundDrawables(null, drawable, null, null);
        textView.setTextColor(this.b.getResources().getColor(i4));
    }
}
