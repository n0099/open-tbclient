package com.baidu.tieba.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private TextView Si;
    private List<a> abJ;
    private Context gXO;
    private LinearLayout gXP;
    private View gXQ;
    private String titleText;
    private View view;
    private int gXR = d.C0082d.cp_bg_line_d;
    private int titleColor = d.C0082d.cp_cont_d;
    private int gXS = d.C0082d.cp_bg_line_a;

    /* renamed from: com.baidu.tieba.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0139b {
        void onClick();
    }

    public b(Context context) {
        if (context != null) {
            this.gXO = context;
            this.view = LayoutInflater.from(context).inflate(d.h.bottom_up_list_dialog_view, (ViewGroup) null);
            this.gXP = (LinearLayout) this.view.findViewById(d.g.content_view);
            this.Si = (TextView) this.view.findViewById(d.g.title);
            this.gXQ = this.view.findViewById(d.g.title_divide_line);
            this.abJ = new ArrayList();
        }
    }

    public Context getContext() {
        return this.gXO;
    }

    public ViewGroup WO() {
        return this.gXP;
    }

    public int bDY() {
        return this.gXS;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void dU(List<a> list) {
        if (list != null) {
            this.abJ = list;
            this.gXP.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.gXP.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void onChangeSkinType() {
        aj.k(this.Si, this.gXR);
        aj.i(this.Si, this.titleColor);
        aj.k(this.gXQ, this.gXS);
        if (this.abJ != null) {
            for (a aVar : this.abJ) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View bDZ() {
        if (!StringUtils.isNull(this.titleText)) {
            this.Si.setText(this.titleText);
        } else {
            this.Si.setVisibility(8);
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private TextView abZ;
        private String afi;
        private View dnQ;
        private b gXT;
        private int gXU;
        private int[] gXV;
        private int gXW;
        private InterfaceC0139b gXX;
        private boolean gXY;
        private int mTextColor;
        private View mView;

        public a(b bVar) {
            this(null, bVar);
        }

        public a(String str, b bVar) {
            this.mTextColor = d.f.person_more_pop_cancel_text_selector;
            this.gXU = d.f.person_more_pop_item_bg_selector;
            this.gXW = 17;
            this.gXY = true;
            this.afi = str;
            this.gXT = bVar;
            initView();
        }

        public View getView() {
            return this.mView;
        }

        public void setText(String str) {
            this.afi = str;
            this.abZ.setText(this.afi);
        }

        public void a(InterfaceC0139b interfaceC0139b) {
            if (interfaceC0139b != null) {
                this.gXX = interfaceC0139b;
                this.abZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.b.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.gXX.onClick();
                    }
                });
            }
        }

        public void onChangeSkinType() {
            aj.j(this.abZ, this.gXU);
            aj.i(this.abZ, this.mTextColor);
            aj.k(this.dnQ, this.gXT.bDY());
        }

        private void initView() {
            if (this.gXT != null && this.gXT.getContext() != null) {
                this.mView = LayoutInflater.from(this.gXT.getContext()).inflate(d.h.bottom_up_list_dialog_item, this.gXT.WO(), false);
                this.abZ = (TextView) this.mView.findViewById(d.g.item_view);
                this.abZ.setText(this.afi);
                this.abZ.setGravity(this.gXW);
                if (this.gXV != null && this.gXV.length == 4) {
                    this.abZ.setPadding(this.gXV[0], this.gXV[1], this.gXV[2], this.gXV[3]);
                }
                this.dnQ = this.mView.findViewById(d.g.divider_line);
                if (this.gXY) {
                    this.dnQ.setVisibility(0);
                } else {
                    this.dnQ.setVisibility(8);
                }
                onChangeSkinType();
            }
        }
    }
}
