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
    private EditorTools Ta;
    private int Tb;
    private boolean eLn;
    private String eeJ;
    private LocationInfoWithDelView hTG;
    private StateSwitchView hTH;
    private StateSwitchView hTI;
    private String mForumId;
    private String mFrom;

    public EditorInfoContainer(Context context, String str) {
        this(context, str, null);
    }

    public EditorInfoContainer(Context context, String str, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eLn = true;
        int dimension = (int) context.getResources().getDimension(e.C0210e.ds14);
        setLayoutParams(new ViewGroup.LayoutParams(-1, getResources().getDimensionPixelSize(e.C0210e.ds90)));
        setPadding(dimension, 0, dimension, 0);
        setGravity(16);
        this.eeJ = str;
        dg(context);
        dh(context);
        di(context);
    }

    private void dg(Context context) {
        this.hTG = new LocationInfoWithDelView(context);
        this.hTG.setId(e.g.editor_id_location);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(e.C0210e.ds16);
        this.hTG.setLocationClickListener(new LocationInfoWithDelView.a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.1
            @Override // com.baidu.tieba.write.editor.LocationInfoWithDelView.a
            public void bOe() {
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(18, -1, null));
            }

            @Override // com.baidu.tieba.write.editor.LocationInfoWithDelView.a
            public void bOf() {
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(20, -1, null));
                EditorInfoContainer.this.hTG.hide();
            }
        });
        addView(this.hTG, layoutParams);
    }

    private void dh(Context context) {
        this.hTH = new StateSwitchView(context);
        this.hTH.setId(e.g.view_write_thread_add_title);
        this.hTH.setStateString(getResources().getString(e.j.write_add_title), getResources().getString(e.j.write_hide_title));
        this.hTH.setBackgroundId(e.f.state_switch_bg);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(e.C0210e.ds16);
        layoutParams.addRule(1, e.g.editor_id_location);
        this.hTH.setLayoutParams(layoutParams);
        this.hTH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EditorInfoContainer.this.hTH.getState() == 0) {
                    EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(45, -1, null));
                } else {
                    EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(53, -1, null));
                }
                EditorInfoContainer.this.hTH.arh();
            }
        });
        addView(this.hTH);
    }

    private void di(Context context) {
        this.hTI = new StateSwitchView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        this.hTI.setLayoutParams(layoutParams);
        this.hTI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ("from_share_write".equals(EditorInfoContainer.this.mFrom)) {
                    if ("1".equals(EditorInfoContainer.this.eeJ)) {
                        TiebaStatic.log(new am("c12608").x("obj_locate", 6));
                    } else if ("2".equals(EditorInfoContainer.this.eeJ)) {
                        TiebaStatic.log(new am("c12608").x("obj_locate", 5));
                    }
                }
                EditorInfoContainer.this.hTI.arh();
                if ("2".equals(EditorInfoContainer.this.eeJ)) {
                    a.ba(EditorInfoContainer.this.mForumId, EditorInfoContainer.this.hTI.getState() == 0 ? 0 : 1);
                }
            }
        });
        if ("1".equals(this.eeJ)) {
            this.hTI.setStateString(getResources().getString(e.j.public_to_all), getResources().getString(e.j.public_to_me));
            this.hTI.setBackgroundId(e.f.state_switch_bg);
        } else if ("2".equals(this.eeJ)) {
            this.hTI.setStateString(getResources().getString(e.j.display_to_home_page), getResources().getString(e.j.display_to_home_page));
            this.hTI.setLeftStateDrawable(e.f.icon_share_home_select_ok, e.f.icon_share_home_select);
            this.hTI.setPadding(this.hTI.getPaddingLeft(), 0, 0, 0);
            this.hTI.setTextSize(0, getResources().getDimensionPixelSize(e.C0210e.ds28));
        }
        addView(this.hTI);
    }

    public boolean isPrivacy() {
        return (this.hTI == null || this.hTI.getState() != 0) && this.hTI != null && this.hTI.getState() == 1;
    }

    public void bld() {
        if (this.hTI != null) {
            this.hTI.hideTip();
        }
    }

    public void bOd() {
        if (this.hTH != null) {
            this.hTH.setVisibility(8);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void aZ(String str, int i) {
        if ("2".equals(this.eeJ)) {
            this.mForumId = str;
            a.a(str, i, new a.InterfaceC0335a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.4
                @Override // com.baidu.tieba.write.editor.a.InterfaceC0335a
                public void xj(int i2) {
                    EditorInfoContainer.this.hTI.setState(i2 != 1 ? 0 : 1);
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
                        this.hTG.setState(aVar2.state, aVar2.addr);
                        return;
                    } else {
                        this.hTG.hide();
                        return;
                    }
                }
                return;
            case 20:
                this.hTG.hide();
                return;
            case 21:
                this.hTH.setState(1);
                return;
            case 54:
                b(new com.baidu.tbadk.editortools.a(55, -1, Boolean.valueOf(isPrivacy())));
                return;
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void pN() {
        if (this.eLn) {
            this.eLn = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, Config.TRACE_VISIT_FIRST));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Tb;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        bld();
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        if (this.hTH != null) {
            this.hTH.onChangeSkinType(i);
        }
        if (this.hTG != null) {
            this.hTG.onChangeSkinType(i);
        }
        if (this.hTI != null) {
            this.hTI.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Ta != null) {
            this.Ta.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Ta = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Tb = i;
    }
}
