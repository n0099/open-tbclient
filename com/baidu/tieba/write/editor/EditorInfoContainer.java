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
import com.baidu.tieba.e;
import com.baidu.tieba.write.editor.LocationInfoWithDelView;
import com.baidu.tieba.write.editor.a;
/* loaded from: classes3.dex */
public class EditorInfoContainer extends RelativeLayout implements l {
    private EditorTools SY;
    private int SZ;
    private String dWT;
    private boolean eDf;
    private LocationInfoWithDelView hKL;
    private StateSwitchView hKM;
    private StateSwitchView hKN;
    private String mForumId;
    private String mFrom;

    public EditorInfoContainer(Context context, String str) {
        this(context, str, null);
    }

    public EditorInfoContainer(Context context, String str, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eDf = true;
        int dimension = (int) context.getResources().getDimension(e.C0175e.ds14);
        setLayoutParams(new ViewGroup.LayoutParams(-1, getResources().getDimensionPixelSize(e.C0175e.ds90)));
        setPadding(dimension, 0, dimension, 0);
        setGravity(16);
        this.dWT = str;
        dh(context);
        di(context);
        dj(context);
    }

    private void dh(Context context) {
        this.hKL = new LocationInfoWithDelView(context);
        this.hKL.setId(e.g.editor_id_location);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(e.C0175e.ds16);
        this.hKL.setLocationClickListener(new LocationInfoWithDelView.a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.1
            @Override // com.baidu.tieba.write.editor.LocationInfoWithDelView.a
            public void bMz() {
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(18, -1, null));
            }

            @Override // com.baidu.tieba.write.editor.LocationInfoWithDelView.a
            public void bMA() {
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(20, -1, null));
                EditorInfoContainer.this.hKL.hide();
            }
        });
        addView(this.hKL, layoutParams);
    }

    private void di(Context context) {
        this.hKM = new StateSwitchView(context);
        this.hKM.setId(e.g.view_write_thread_add_title);
        this.hKM.setStateString(getResources().getString(e.j.write_add_title), getResources().getString(e.j.write_hide_title));
        this.hKM.setBackgroundId(e.f.state_switch_bg);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(e.C0175e.ds16);
        layoutParams.addRule(1, e.g.editor_id_location);
        this.hKM.setLayoutParams(layoutParams);
        this.hKM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EditorInfoContainer.this.hKM.getState() == 0) {
                    EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(45, -1, null));
                } else {
                    EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(53, -1, null));
                }
                EditorInfoContainer.this.hKM.apU();
            }
        });
        addView(this.hKM);
    }

    private void dj(Context context) {
        this.hKN = new StateSwitchView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        this.hKN.setLayoutParams(layoutParams);
        this.hKN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ("from_share_write".equals(EditorInfoContainer.this.mFrom)) {
                    if ("1".equals(EditorInfoContainer.this.dWT)) {
                        TiebaStatic.log(new am("c12608").x("obj_locate", 6));
                    } else if ("2".equals(EditorInfoContainer.this.dWT)) {
                        TiebaStatic.log(new am("c12608").x("obj_locate", 5));
                    }
                }
                EditorInfoContainer.this.hKN.apU();
                if ("2".equals(EditorInfoContainer.this.dWT)) {
                    a.aZ(EditorInfoContainer.this.mForumId, EditorInfoContainer.this.hKN.getState() == 0 ? 0 : 1);
                }
            }
        });
        if ("1".equals(this.dWT)) {
            this.hKN.setStateString(getResources().getString(e.j.public_to_all), getResources().getString(e.j.public_to_me));
            this.hKN.setBackgroundId(e.f.state_switch_bg);
        } else if ("2".equals(this.dWT)) {
            this.hKN.setStateString(getResources().getString(e.j.display_to_home_page), getResources().getString(e.j.display_to_home_page));
            this.hKN.setLeftStateDrawable(e.f.icon_share_home_select_ok, e.f.icon_share_home_select);
            this.hKN.setPadding(this.hKN.getPaddingLeft(), 0, 0, 0);
            this.hKN.setTextSize(0, getResources().getDimensionPixelSize(e.C0175e.ds28));
        }
        addView(this.hKN);
    }

    public boolean isPrivacy() {
        return (this.hKN == null || this.hKN.getState() != 0) && this.hKN != null && this.hKN.getState() == 1;
    }

    public void auj() {
        if (this.hKN != null) {
            this.hKN.hideTip();
        }
    }

    public void bMy() {
        if (this.hKM != null) {
            this.hKM.setVisibility(8);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void aY(String str, int i) {
        if ("2".equals(this.dWT)) {
            this.mForumId = str;
            a.a(str, i, new a.InterfaceC0293a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.4
                @Override // com.baidu.tieba.write.editor.a.InterfaceC0293a
                public void wt(int i2) {
                    EditorInfoContainer.this.hKN.setState(i2 != 1 ? 0 : 1);
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
                        this.hKL.setState(aVar2.state, aVar2.addr);
                        return;
                    } else {
                        this.hKL.hide();
                        return;
                    }
                }
                return;
            case 20:
                this.hKL.hide();
                return;
            case 21:
                this.hKM.setState(1);
                return;
            case 54:
                b(new com.baidu.tbadk.editortools.a(55, -1, Boolean.valueOf(isPrivacy())));
                return;
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void pQ() {
        if (this.eDf) {
            this.eDf = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, Config.TRACE_VISIT_FIRST));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.SZ;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        auj();
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        if (this.hKM != null) {
            this.hKM.onChangeSkinType(i);
        }
        if (this.hKL != null) {
            this.hKL.onChangeSkinType(i);
        }
        if (this.hKN != null) {
            this.hKN.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.SY != null) {
            this.SY.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.SY = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.SZ = i;
    }
}
