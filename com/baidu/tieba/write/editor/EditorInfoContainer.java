package com.baidu.tieba.write.editor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.d;
import com.baidu.tieba.write.editor.LocationInfoWithDelView;
import com.baidu.tieba.write.editor.a;
/* loaded from: classes3.dex */
public class EditorInfoContainer extends RelativeLayout implements l {
    private EditorTools JS;
    private int JT;
    private boolean dTV;
    private String gLv;
    private LocationInfoWithDelView hdl;
    private StateSwitchView hdm;
    private StateSwitchView hdn;
    private String mForumId;
    private String mFrom;

    public EditorInfoContainer(Context context, String str) {
        this(context, str, null);
    }

    public EditorInfoContainer(Context context, String str, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dTV = true;
        int dimension = (int) context.getResources().getDimension(d.e.ds14);
        setLayoutParams(new ViewGroup.LayoutParams(-1, getResources().getDimensionPixelSize(d.e.ds90)));
        setPadding(dimension, 0, dimension, 0);
        setGravity(16);
        this.gLv = str;
        cf(context);
        cg(context);
        ch(context);
    }

    private void cf(Context context) {
        this.hdl = new LocationInfoWithDelView(context);
        this.hdl.setId(d.g.editor_id_location);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.e.ds16);
        this.hdl.setLocationClickListener(new LocationInfoWithDelView.a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.1
            @Override // com.baidu.tieba.write.editor.LocationInfoWithDelView.a
            public void bCd() {
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(18, -1, null));
            }

            @Override // com.baidu.tieba.write.editor.LocationInfoWithDelView.a
            public void bCe() {
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(20, -1, null));
                EditorInfoContainer.this.hdl.hide();
            }
        });
        addView(this.hdl, layoutParams);
    }

    private void cg(Context context) {
        this.hdm = new StateSwitchView(context);
        this.hdm.setId(d.g.view_write_thread_add_title);
        this.hdm.setStateString(getResources().getString(d.k.write_add_title), getResources().getString(d.k.write_hide_title));
        this.hdm.setBackgroundId(d.f.state_switch_bg);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.e.ds16);
        layoutParams.addRule(1, d.g.editor_id_location);
        this.hdm.setLayoutParams(layoutParams);
        this.hdm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EditorInfoContainer.this.hdm.getState() == 0) {
                    EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(45, -1, null));
                } else {
                    EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(53, -1, null));
                }
                EditorInfoContainer.this.hdm.bCf();
            }
        });
        addView(this.hdm);
    }

    private void ch(Context context) {
        this.hdn = new StateSwitchView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        this.hdn.setLayoutParams(layoutParams);
        this.hdn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if ("from_share_write".equals(EditorInfoContainer.this.mFrom)) {
                    if ("1".equals(EditorInfoContainer.this.gLv)) {
                        TiebaStatic.log(new al("c12608").r("obj_locate", 6));
                    } else if ("2".equals(EditorInfoContainer.this.gLv)) {
                        TiebaStatic.log(new al("c12608").r("obj_locate", 5));
                    }
                }
                EditorInfoContainer.this.hdn.bCf();
                if ("2".equals(EditorInfoContainer.this.gLv)) {
                    a.aQ(EditorInfoContainer.this.mForumId, EditorInfoContainer.this.hdn.getState() == 0 ? 0 : 1);
                }
            }
        });
        if ("1".equals(this.gLv)) {
            this.hdn.setStateString(getResources().getString(d.k.public_to_all), getResources().getString(d.k.public_to_me));
            this.hdn.setBackgroundId(d.f.state_switch_bg);
        } else if ("2".equals(this.gLv)) {
            this.hdn.setStateString(getResources().getString(d.k.display_to_home_page), getResources().getString(d.k.display_to_home_page));
            this.hdn.setLeftStateDrawable(d.f.icon_share_home_select_ok, d.f.icon_share_home_select);
            this.hdn.setPadding(this.hdn.getPaddingLeft(), 0, 0, 0);
            this.hdn.setTextSize(0, getResources().getDimensionPixelSize(d.e.ds28));
        }
        addView(this.hdn);
    }

    public boolean isPrivacy() {
        return (this.hdn == null || this.hdn.getState() != 0) && this.hdn != null && this.hdn.getState() == 1;
    }

    public void akW() {
        if (this.hdn != null) {
            this.hdn.hideTip();
        }
    }

    public void bCc() {
        if (this.hdm != null) {
            this.hdm.setVisibility(8);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void aP(String str, int i) {
        if ("2".equals(this.gLv)) {
            this.mForumId = str;
            a.a(str, i, new a.InterfaceC0233a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.4
                @Override // com.baidu.tieba.write.editor.a.InterfaceC0233a
                public void uX(int i2) {
                    EditorInfoContainer.this.hdn.setState(i2 != 1 ? 0 : 1);
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
                    if (aVar2 != null && aVar2.aEp) {
                        this.hdl.setState(aVar2.state, aVar2.addr);
                        return;
                    } else {
                        this.hdl.hide();
                        return;
                    }
                }
                return;
            case 20:
                this.hdl.hide();
                return;
            case 21:
                this.hdm.setState(1);
                return;
            case 54:
                b(new com.baidu.tbadk.editortools.a(55, -1, Boolean.valueOf(isPrivacy())));
                return;
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void lN() {
        if (this.dTV) {
            this.dTV = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, "first"));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.JT;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        akW();
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        if (this.hdm != null) {
            this.hdm.onChangeSkinType(i);
        }
        if (this.hdl != null) {
            this.hdl.onChangeSkinType(i);
        }
        if (this.hdn != null) {
            this.hdn.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.JS != null) {
            this.JS.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.JS = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.JT = i;
    }
}
