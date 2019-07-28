package com.baidu.tieba.write.editor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
import com.baidu.tieba.write.editor.LocationInfoWithDelView;
import com.baidu.tieba.write.editor.a;
/* loaded from: classes3.dex */
public class EditorInfoContainer extends RelativeLayout implements l {
    private EditorTools TU;
    private int TV;
    private boolean fBk;
    private String fTa;
    private LocationInfoWithDelView jOH;
    private StateSwitchView jOI;
    private StateSwitchView jOJ;
    private String mForumId;
    private String mFrom;

    public EditorInfoContainer(Context context, String str) {
        this(context, str, null);
    }

    public EditorInfoContainer(Context context, String str, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fBk = true;
        int dimension = (int) context.getResources().getDimension(R.dimen.ds14);
        setLayoutParams(new ViewGroup.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds90)));
        setPadding(dimension, 0, dimension, 0);
        setGravity(16);
        this.fTa = str;
        es(context);
        et(context);
        eu(context);
    }

    private void es(Context context) {
        this.jOH = new LocationInfoWithDelView(context);
        this.jOH.setId(R.id.editor_id_location);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.ds16);
        this.jOH.setLocationClickListener(new LocationInfoWithDelView.a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.1
            @Override // com.baidu.tieba.write.editor.LocationInfoWithDelView.a
            public void cAz() {
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(18, -1, null));
            }

            @Override // com.baidu.tieba.write.editor.LocationInfoWithDelView.a
            public void cAA() {
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(20, -1, null));
                EditorInfoContainer.this.jOH.hide();
            }
        });
        addView(this.jOH, layoutParams);
    }

    private void et(Context context) {
        this.jOI = new StateSwitchView(context);
        this.jOI.setId(R.id.view_write_thread_add_title);
        this.jOI.setStateString(getResources().getString(R.string.write_add_title), getResources().getString(R.string.write_hide_title));
        this.jOI.setBackgroundId(R.drawable.state_switch_bg);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.ds16);
        layoutParams.addRule(1, R.id.editor_id_location);
        this.jOI.setLayoutParams(layoutParams);
        this.jOI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EditorInfoContainer.this.jOI.getState() == 0) {
                    EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(45, -1, null));
                } else {
                    EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(53, -1, null));
                }
                EditorInfoContainer.this.jOI.aGQ();
            }
        });
        addView(this.jOI);
    }

    private void eu(Context context) {
        this.jOJ = new StateSwitchView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        this.jOJ.setLayoutParams(layoutParams);
        this.jOJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ("from_share_write".equals(EditorInfoContainer.this.mFrom)) {
                    if ("1".equals(EditorInfoContainer.this.fTa)) {
                        TiebaStatic.log(new an("c12608").P("obj_locate", 6));
                    } else if ("2".equals(EditorInfoContainer.this.fTa)) {
                        TiebaStatic.log(new an("c12608").P("obj_locate", 5));
                    }
                }
                EditorInfoContainer.this.jOJ.aGQ();
                if ("2".equals(EditorInfoContainer.this.fTa)) {
                    a.bu(EditorInfoContainer.this.mForumId, EditorInfoContainer.this.jOJ.getState() == 0 ? 0 : 1);
                }
            }
        });
        if ("1".equals(this.fTa)) {
            this.jOJ.setStateString(getResources().getString(R.string.public_to_all), getResources().getString(R.string.public_to_me));
            this.jOJ.setBackgroundId(R.drawable.state_switch_bg);
        } else if ("2".equals(this.fTa)) {
            this.jOJ.setStateString(getResources().getString(R.string.display_to_home_page), getResources().getString(R.string.display_to_home_page));
            this.jOJ.setLeftStateDrawable(R.drawable.icon_share_home_select_ok, R.drawable.icon_share_home_select);
            this.jOJ.setPadding(this.jOJ.getPaddingLeft(), 0, 0, 0);
            this.jOJ.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds28));
        }
        addView(this.jOJ);
    }

    public boolean isPrivacy() {
        return (this.jOJ == null || this.jOJ.getState() != 0) && this.jOJ != null && this.jOJ.getState() == 1;
    }

    public void bgg() {
        if (this.jOJ != null) {
            this.jOJ.hideTip();
        }
    }

    public void cAy() {
        if (this.jOI != null) {
            this.jOI.setVisibility(8);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void bt(String str, int i) {
        if ("2".equals(this.fTa)) {
            this.mForumId = str;
            a.a(str, i, new a.InterfaceC0432a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.4
                @Override // com.baidu.tieba.write.editor.a.InterfaceC0432a
                public void CZ(int i2) {
                    EditorInfoContainer.this.jOJ.setState(i2 != 1 ? 0 : 1);
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
                        this.jOH.setState(aVar2.state, aVar2.addr);
                        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                            if (!StringUtils.isNull(aVar2.addr)) {
                                setVisibility(0);
                                return;
                            } else {
                                setVisibility(8);
                                return;
                            }
                        }
                        return;
                    }
                    this.jOH.hide();
                    if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                        setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            case 20:
                this.jOH.hide();
                if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                    setVisibility(8);
                    return;
                }
                return;
            case 21:
                this.jOI.setState(1);
                return;
            case 54:
                b(new com.baidu.tbadk.editortools.a(55, -1, Boolean.valueOf(isPrivacy())));
                return;
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void qk() {
        if (this.fBk) {
            this.fBk = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, Config.TRACE_VISIT_FIRST));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.TV;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        bgg();
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        if (this.jOI != null) {
            this.jOI.onChangeSkinType(i);
        }
        if (this.jOH != null) {
            this.jOH.onChangeSkinType(i);
        }
        if (this.jOJ != null) {
            this.jOJ.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.TU != null) {
            this.TU.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.TU = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.TV = i;
    }
}
