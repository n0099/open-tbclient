package com.baidu.tieba.write.editor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.d;
import com.baidu.tieba.write.editor.LocationInfoWithDelView;
import com.baidu.tieba.write.editor.a;
/* loaded from: classes3.dex */
public class EditorInfoContainer extends RelativeLayout implements l {
    private EditorTools VO;
    private int VP;
    private boolean fga;
    private String fxi;
    private StateSwitchView joA;
    private StateSwitchView joB;
    private LocationInfoWithDelView joz;
    private String mForumId;
    private String mFrom;

    public EditorInfoContainer(Context context, String str) {
        this(context, str, null);
    }

    public EditorInfoContainer(Context context, String str, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fga = true;
        int dimension = (int) context.getResources().getDimension(d.e.ds14);
        setLayoutParams(new ViewGroup.LayoutParams(-1, getResources().getDimensionPixelSize(d.e.ds90)));
        setPadding(dimension, 0, dimension, 0);
        setGravity(16);
        this.fxi = str;
        eB(context);
        eC(context);
        eD(context);
    }

    private void eB(Context context) {
        this.joz = new LocationInfoWithDelView(context);
        this.joz.setId(d.g.editor_id_location);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.e.ds16);
        this.joz.setLocationClickListener(new LocationInfoWithDelView.a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.1
            @Override // com.baidu.tieba.write.editor.LocationInfoWithDelView.a
            public void cpu() {
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(18, -1, null));
            }

            @Override // com.baidu.tieba.write.editor.LocationInfoWithDelView.a
            public void cpv() {
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(20, -1, null));
                EditorInfoContainer.this.joz.hide();
            }
        });
        addView(this.joz, layoutParams);
    }

    private void eC(Context context) {
        this.joA = new StateSwitchView(context);
        this.joA.setId(d.g.view_write_thread_add_title);
        this.joA.setStateString(getResources().getString(d.j.write_add_title), getResources().getString(d.j.write_hide_title));
        this.joA.setBackgroundId(d.f.state_switch_bg);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.e.ds16);
        layoutParams.addRule(1, d.g.editor_id_location);
        this.joA.setLayoutParams(layoutParams);
        this.joA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EditorInfoContainer.this.joA.getState() == 0) {
                    EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(45, -1, null));
                } else {
                    EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(53, -1, null));
                }
                EditorInfoContainer.this.joA.aSk();
            }
        });
        addView(this.joA);
    }

    private void eD(Context context) {
        this.joB = new StateSwitchView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        this.joB.setLayoutParams(layoutParams);
        this.joB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ("from_share_write".equals(EditorInfoContainer.this.mFrom)) {
                    if ("1".equals(EditorInfoContainer.this.fxi)) {
                        TiebaStatic.log(new am("c12608").T("obj_locate", 6));
                    } else if ("2".equals(EditorInfoContainer.this.fxi)) {
                        TiebaStatic.log(new am("c12608").T("obj_locate", 5));
                    }
                }
                EditorInfoContainer.this.joB.aSk();
                if ("2".equals(EditorInfoContainer.this.fxi)) {
                    a.bx(EditorInfoContainer.this.mForumId, EditorInfoContainer.this.joB.getState() == 0 ? 0 : 1);
                }
            }
        });
        if ("1".equals(this.fxi)) {
            this.joB.setStateString(getResources().getString(d.j.public_to_all), getResources().getString(d.j.public_to_me));
            this.joB.setBackgroundId(d.f.state_switch_bg);
        } else if ("2".equals(this.fxi)) {
            this.joB.setStateString(getResources().getString(d.j.display_to_home_page), getResources().getString(d.j.display_to_home_page));
            this.joB.setLeftStateDrawable(d.f.icon_share_home_select_ok, d.f.icon_share_home_select);
            this.joB.setPadding(this.joB.getPaddingLeft(), 0, 0, 0);
            this.joB.setTextSize(0, getResources().getDimensionPixelSize(d.e.ds28));
        }
        addView(this.joB);
    }

    public boolean isPrivacy() {
        return (this.joB == null || this.joB.getState() != 0) && this.joB != null && this.joB.getState() == 1;
    }

    public void aWN() {
        if (this.joB != null) {
            this.joB.hideTip();
        }
    }

    public void cpt() {
        if (this.joA != null) {
            this.joA.setVisibility(8);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void bw(String str, int i) {
        if ("2".equals(this.fxi)) {
            this.mForumId = str;
            a.a(str, i, new a.InterfaceC0408a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.4
                @Override // com.baidu.tieba.write.editor.a.InterfaceC0408a
                public void Bj(int i2) {
                    EditorInfoContainer.this.joB.setState(i2 != 1 ? 0 : 1);
                }
            });
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar == null) {
            return;
        }
        switch (aVar.code) {
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 46:
            case 49:
            default:
                return;
            case 19:
                if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.d.a)) {
                    com.baidu.tbadk.editortools.d.a aVar2 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                    if (aVar2 != null && aVar2.isShow) {
                        this.joz.setState(aVar2.state, aVar2.addr);
                        return;
                    } else {
                        this.joz.hide();
                        return;
                    }
                }
                return;
            case 20:
                this.joz.hide();
                return;
            case 21:
                this.joA.setState(1);
                return;
            case 54:
                b(new com.baidu.tbadk.editortools.a(55, -1, Boolean.valueOf(isPrivacy())));
                return;
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void qT() {
        if (this.fga) {
            this.fga = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, Config.TRACE_VISIT_FIRST));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.VP;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        aWN();
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        if (this.joA != null) {
            this.joA.onChangeSkinType(i);
        }
        if (this.joz != null) {
            this.joz.onChangeSkinType(i);
        }
        if (this.joB != null) {
            this.joB.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.VO != null) {
            this.VO.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.VO = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.VP = i;
    }
}
