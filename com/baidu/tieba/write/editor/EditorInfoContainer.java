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
    private EditorTools VN;
    private int VO;
    private boolean fgn;
    private String fxu;
    private LocationInfoWithDelView joJ;
    private StateSwitchView joK;
    private StateSwitchView joL;
    private String mForumId;
    private String mFrom;

    public EditorInfoContainer(Context context, String str) {
        this(context, str, null);
    }

    public EditorInfoContainer(Context context, String str, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fgn = true;
        int dimension = (int) context.getResources().getDimension(d.e.ds14);
        setLayoutParams(new ViewGroup.LayoutParams(-1, getResources().getDimensionPixelSize(d.e.ds90)));
        setPadding(dimension, 0, dimension, 0);
        setGravity(16);
        this.fxu = str;
        eB(context);
        eC(context);
        eD(context);
    }

    private void eB(Context context) {
        this.joJ = new LocationInfoWithDelView(context);
        this.joJ.setId(d.g.editor_id_location);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.e.ds16);
        this.joJ.setLocationClickListener(new LocationInfoWithDelView.a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.1
            @Override // com.baidu.tieba.write.editor.LocationInfoWithDelView.a
            public void cpw() {
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(18, -1, null));
            }

            @Override // com.baidu.tieba.write.editor.LocationInfoWithDelView.a
            public void cpx() {
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(20, -1, null));
                EditorInfoContainer.this.joJ.hide();
            }
        });
        addView(this.joJ, layoutParams);
    }

    private void eC(Context context) {
        this.joK = new StateSwitchView(context);
        this.joK.setId(d.g.view_write_thread_add_title);
        this.joK.setStateString(getResources().getString(d.j.write_add_title), getResources().getString(d.j.write_hide_title));
        this.joK.setBackgroundId(d.f.state_switch_bg);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.e.ds16);
        layoutParams.addRule(1, d.g.editor_id_location);
        this.joK.setLayoutParams(layoutParams);
        this.joK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EditorInfoContainer.this.joK.getState() == 0) {
                    EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(45, -1, null));
                } else {
                    EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(53, -1, null));
                }
                EditorInfoContainer.this.joK.aSm();
            }
        });
        addView(this.joK);
    }

    private void eD(Context context) {
        this.joL = new StateSwitchView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        this.joL.setLayoutParams(layoutParams);
        this.joL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ("from_share_write".equals(EditorInfoContainer.this.mFrom)) {
                    if ("1".equals(EditorInfoContainer.this.fxu)) {
                        TiebaStatic.log(new am("c12608").T("obj_locate", 6));
                    } else if ("2".equals(EditorInfoContainer.this.fxu)) {
                        TiebaStatic.log(new am("c12608").T("obj_locate", 5));
                    }
                }
                EditorInfoContainer.this.joL.aSm();
                if ("2".equals(EditorInfoContainer.this.fxu)) {
                    a.bx(EditorInfoContainer.this.mForumId, EditorInfoContainer.this.joL.getState() == 0 ? 0 : 1);
                }
            }
        });
        if ("1".equals(this.fxu)) {
            this.joL.setStateString(getResources().getString(d.j.public_to_all), getResources().getString(d.j.public_to_me));
            this.joL.setBackgroundId(d.f.state_switch_bg);
        } else if ("2".equals(this.fxu)) {
            this.joL.setStateString(getResources().getString(d.j.display_to_home_page), getResources().getString(d.j.display_to_home_page));
            this.joL.setLeftStateDrawable(d.f.icon_share_home_select_ok, d.f.icon_share_home_select);
            this.joL.setPadding(this.joL.getPaddingLeft(), 0, 0, 0);
            this.joL.setTextSize(0, getResources().getDimensionPixelSize(d.e.ds28));
        }
        addView(this.joL);
    }

    public boolean isPrivacy() {
        return (this.joL == null || this.joL.getState() != 0) && this.joL != null && this.joL.getState() == 1;
    }

    public void aWP() {
        if (this.joL != null) {
            this.joL.hideTip();
        }
    }

    public void cpv() {
        if (this.joK != null) {
            this.joK.setVisibility(8);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void bw(String str, int i) {
        if ("2".equals(this.fxu)) {
            this.mForumId = str;
            a.a(str, i, new a.InterfaceC0408a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.4
                @Override // com.baidu.tieba.write.editor.a.InterfaceC0408a
                public void Bn(int i2) {
                    EditorInfoContainer.this.joL.setState(i2 != 1 ? 0 : 1);
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
                        this.joJ.setState(aVar2.state, aVar2.addr);
                        return;
                    } else {
                        this.joJ.hide();
                        return;
                    }
                }
                return;
            case 20:
                this.joJ.hide();
                return;
            case 21:
                this.joK.setState(1);
                return;
            case 54:
                b(new com.baidu.tbadk.editortools.a(55, -1, Boolean.valueOf(isPrivacy())));
                return;
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void qT() {
        if (this.fgn) {
            this.fgn = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, Config.TRACE_VISIT_FIRST));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.VO;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        aWP();
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        if (this.joK != null) {
            this.joK.onChangeSkinType(i);
        }
        if (this.joJ != null) {
            this.joJ.onChangeSkinType(i);
        }
        if (this.joL != null) {
            this.joL.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.VN != null) {
            this.VN.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.VN = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.VO = i;
    }
}
