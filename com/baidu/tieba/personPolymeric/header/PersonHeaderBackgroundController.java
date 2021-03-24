package com.baidu.tieba.personPolymeric.header;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonalBackdropGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalBackgroundPreviewActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.PullRefreshFrameLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.b.b.e.l.c;
import d.b.b.e.l.d;
import d.b.b.e.p.k;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
/* loaded from: classes5.dex */
public class PersonHeaderBackgroundController {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f20416a;

    /* renamed from: b  reason: collision with root package name */
    public TbImageView f20417b;

    /* renamed from: c  reason: collision with root package name */
    public View f20418c;

    /* renamed from: d  reason: collision with root package name */
    public UserData f20419d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f20420e;

    /* renamed from: f  reason: collision with root package name */
    public int f20421f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f20422g = new b();

    /* loaded from: classes5.dex */
    public class a extends c<d.b.b.j.d.a> {
        public a() {
        }

        @Override // d.b.b.e.l.c
        public void onCancelled(String str) {
            super.onCancelled(str);
        }

        @Override // d.b.b.e.l.c
        public void onProgressUpdate(Object... objArr) {
            super.onProgressUpdate(objArr);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.l.c
        public void onLoaded(d.b.b.j.d.a aVar, String str, int i) {
            super.onLoaded((a) aVar, str, i);
            if (aVar != null) {
                aVar.h(PersonHeaderBackgroundController.this.f20417b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            if (PersonHeaderBackgroundController.this.f20420e) {
                if (PersonHeaderBackgroundController.this.f20419d == null || !PersonHeaderBackgroundController.this.f20419d.isBaijiahaoUser()) {
                    TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "3"));
                    String userId = PersonHeaderBackgroundController.this.f20419d.getUserId();
                    String bg_pic = PersonHeaderBackgroundController.this.f20419d.getBg_pic();
                    try {
                        i = d.b.b.e.m.b.d((String) PersonHeaderBackgroundController.this.f(bg_pic).get("props_id"), -1);
                    } catch (URISyntaxException unused) {
                        i = -1;
                    }
                    if (i != -1 && !userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                        int i2 = 0;
                        if (currentAccountInfo != null && !StringUtils.isNull(bg_pic) && !StringUtils.isNull(currentAccountInfo.getPersonalBgUrl()) && bg_pic.equalsIgnoreCase(currentAccountInfo.getPersonalBgUrl())) {
                            i2 = 1;
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalBackgroundPreviewActivityConfig(PersonHeaderBackgroundController.this.f20417b.getContext(), i, i2)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalBackdropGroupActivityConfig(PersonHeaderBackgroundController.this.f20417b.getContext())));
                }
            }
        }
    }

    public PersonHeaderBackgroundController(TbPageContext tbPageContext, TbImageView tbImageView, View view, boolean z) {
        this.f20416a = tbPageContext;
        this.f20417b = tbImageView;
        this.f20420e = z;
        tbImageView.setDefaultBgResource(R.drawable.bg_pic_mine);
        this.f20418c = view;
        view.setOnClickListener(this.f20422g);
    }

    public void e(UserData userData) {
        if (userData == null) {
            return;
        }
        this.f20419d = userData;
        String bg_pic = userData.getBg_pic();
        if (k.isEmpty(bg_pic)) {
            return;
        }
        d.h().k(bg_pic, 10, new a(), 0, 0, this.f20416a.getUniqueId(), new Object[0]);
    }

    public final Map<String, String> f(final String str) throws URISyntaxException {
        return new HashMap<String, String>() { // from class: com.baidu.tieba.personPolymeric.header.PersonHeaderBackgroundController.3
            {
                for (NameValuePair nameValuePair : URLEncodedUtils.parse(new URI(str), "UTF-8")) {
                    put(nameValuePair.getName(), nameValuePair.getValue());
                }
            }
        };
    }

    public int g() {
        ViewGroup.LayoutParams layoutParams = this.f20417b.getLayoutParams();
        if (layoutParams != null) {
            return layoutParams.height;
        }
        return 0;
    }

    public void h(double d2) {
        double d3 = this.f20421f;
        double d4 = PullRefreshFrameLayout.D;
        Double.isNaN(d4);
        Double.isNaN(d3);
        int i = (int) (d3 + (d4 * d2));
        ViewGroup.LayoutParams layoutParams = this.f20417b.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = i;
            this.f20417b.setLayoutParams(layoutParams);
        }
    }

    public void i(int i) {
        this.f20421f = i;
        ViewGroup.LayoutParams layoutParams = this.f20417b.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = this.f20421f;
            this.f20417b.setLayoutParams(layoutParams);
        }
    }

    public void j(int i) {
        ViewGroup.LayoutParams layoutParams = this.f20417b.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = i;
            this.f20417b.setLayoutParams(layoutParams);
        }
    }
}
