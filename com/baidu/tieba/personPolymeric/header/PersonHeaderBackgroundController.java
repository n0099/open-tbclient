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
import d.a.c.e.l.c;
import d.a.c.e.l.d;
import d.a.c.e.p.k;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
/* loaded from: classes5.dex */
public class PersonHeaderBackgroundController {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f19840a;

    /* renamed from: b  reason: collision with root package name */
    public TbImageView f19841b;

    /* renamed from: c  reason: collision with root package name */
    public View f19842c;

    /* renamed from: d  reason: collision with root package name */
    public UserData f19843d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f19844e;

    /* renamed from: f  reason: collision with root package name */
    public int f19845f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f19846g = new b();

    /* loaded from: classes5.dex */
    public class a extends c<d.a.c.j.d.a> {
        public a() {
        }

        @Override // d.a.c.e.l.c
        public void onCancelled(String str) {
            super.onCancelled(str);
        }

        @Override // d.a.c.e.l.c
        public void onProgressUpdate(Object... objArr) {
            super.onProgressUpdate(objArr);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.j.d.a aVar, String str, int i2) {
            super.onLoaded((a) aVar, str, i2);
            if (aVar != null) {
                aVar.h(PersonHeaderBackgroundController.this.f19841b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i2;
            if (PersonHeaderBackgroundController.this.f19844e) {
                if (PersonHeaderBackgroundController.this.f19843d == null || !PersonHeaderBackgroundController.this.f19843d.isBaijiahaoUser()) {
                    TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "3"));
                    String userId = PersonHeaderBackgroundController.this.f19843d.getUserId();
                    String bg_pic = PersonHeaderBackgroundController.this.f19843d.getBg_pic();
                    try {
                        i2 = d.a.c.e.m.b.d((String) PersonHeaderBackgroundController.this.f(bg_pic).get("props_id"), -1);
                    } catch (URISyntaxException unused) {
                        i2 = -1;
                    }
                    if (i2 != -1 && !userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                        int i3 = 0;
                        if (currentAccountInfo != null && !StringUtils.isNull(bg_pic) && !StringUtils.isNull(currentAccountInfo.getPersonalBgUrl()) && bg_pic.equalsIgnoreCase(currentAccountInfo.getPersonalBgUrl())) {
                            i3 = 1;
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalBackgroundPreviewActivityConfig(PersonHeaderBackgroundController.this.f19841b.getContext(), i2, i3)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalBackdropGroupActivityConfig(PersonHeaderBackgroundController.this.f19841b.getContext())));
                }
            }
        }
    }

    public PersonHeaderBackgroundController(TbPageContext tbPageContext, TbImageView tbImageView, View view, boolean z) {
        this.f19840a = tbPageContext;
        this.f19841b = tbImageView;
        this.f19844e = z;
        tbImageView.setDefaultBgResource(R.drawable.bg_pic_mine);
        this.f19842c = view;
        view.setOnClickListener(this.f19846g);
    }

    public void e(UserData userData) {
        if (userData == null) {
            return;
        }
        this.f19843d = userData;
        String bg_pic = userData.getBg_pic();
        if (k.isEmpty(bg_pic)) {
            return;
        }
        d.h().k(bg_pic, 10, new a(), 0, 0, this.f19840a.getUniqueId(), new Object[0]);
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
        ViewGroup.LayoutParams layoutParams = this.f19841b.getLayoutParams();
        if (layoutParams != null) {
            return layoutParams.height;
        }
        return 0;
    }

    public void h(double d2) {
        int i2 = (int) (this.f19845f + (PullRefreshFrameLayout.D * d2));
        ViewGroup.LayoutParams layoutParams = this.f19841b.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = i2;
            this.f19841b.setLayoutParams(layoutParams);
        }
    }

    public void i(int i2) {
        this.f19845f = i2;
        ViewGroup.LayoutParams layoutParams = this.f19841b.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = this.f19845f;
            this.f19841b.setLayoutParams(layoutParams);
        }
    }

    public void j(int i2) {
        ViewGroup.LayoutParams layoutParams = this.f19841b.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = i2;
            this.f19841b.setLayoutParams(layoutParams);
        }
    }
}
