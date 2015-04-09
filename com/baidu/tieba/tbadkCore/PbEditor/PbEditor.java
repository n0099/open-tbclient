package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class PbEditor extends LinearLayout {
    private static final Pattern cmR = Pattern.compile("#\\([^#\\)\\(]+\\)$");
    private static final Pattern cmV = Pattern.compile("#\\([a-zA-Z0-9_\\u4E00-\\u9FA5]+\\)");
    private boolean akd;
    private int cmM;
    private ab cmN;
    protected PbEditorToolView cmO;
    public EditorToolComponetContainer cmP;
    protected com.baidu.tbadk.editortool.v cmQ;
    private boolean cmS;
    private final CustomMessageListener cmT;
    protected boolean cmU;
    private boolean cmy;
    protected Context mContext;
    private BdUniqueId mId;
    private TbPageContext<?> mPageContext;

    public void setHideBaobao(boolean z) {
        this.akd = z;
        if (this.cmP != null) {
            this.cmP.setHideBaobao(z);
        }
    }

    public EditorToolComponetContainer getEditorToolComponetContainer() {
        return this.cmP;
    }

    public PbEditorToolView getEditorToolButtonContainer() {
        return this.cmO;
    }

    public PbEditor(Context context) {
        super(context);
        this.cmM = 1000;
        this.cmy = false;
        this.akd = false;
        this.cmT = new q(this, 2001310);
        this.cmU = true;
        this.mContext = context;
        this.mId = BdUniqueId.gen();
        initialize();
    }

    public PbEditor(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cmM = 1000;
        this.cmy = false;
        this.akd = false;
        this.cmT = new q(this, 2001310);
        this.cmU = true;
        this.mContext = context;
        this.mId = BdUniqueId.gen();
        initialize();
    }

    public void setFrom(int i) {
        if (this.cmP != null) {
            this.cmP.setFrom(i);
        }
    }

    public void amc() {
        this.cmO.amc();
    }

    public void amd() {
        this.cmO.amd();
    }

    public boolean ame() {
        Editable text = this.cmO.getEditText().getText();
        if ((text != null && text.toString().trim().length() > 0) || this.cmP.alT() || this.cmP.alU()) {
            return true;
        }
        return this.cmP.alV();
    }

    public EditText getEditText() {
        return this.cmO.getEditText();
    }

    public void v(ArrayList<String> arrayList) {
        this.cmO.X(arrayList);
    }

    public String getContent() {
        return this.cmO.getEditText().getText().toString();
    }

    public void setContent(String str) {
        this.cmO.getEditText().setText(str);
        if (!TextUtils.isEmpty(str)) {
            this.cmO.getEditText().setSelection(str.length());
        }
    }

    public void amf() {
        this.cmO.getEditText().requestFocus();
        this.cmP.aa(this.cmO.getEditText());
    }

    public void amg() {
        this.cmP.hideAll();
        this.cmO.alt();
    }

    public void amh() {
        this.cmP.hideAll();
        this.cmO.alt();
    }

    public void ami() {
        if (this.cmP.alK() && !this.cmS) {
            this.cmS = true;
            ac.a(this, this.mContext, new r(this));
            return;
        }
        amg();
    }

    public boolean alK() {
        return this.cmP.alK();
    }

    protected void initialize() {
        com.baidu.adp.lib.g.b.hH().a(this.mContext, com.baidu.tieba.w.pb_editor_view, this, true);
        this.cmO = (PbEditorToolView) findViewById(com.baidu.tieba.v.pb_editor_tool_button);
        this.cmP = (EditorToolComponetContainer) findViewById(com.baidu.tieba.v.pb_editor_tool_group);
        amj();
        MessageManager.getInstance().unRegisterListener(this.mId);
        this.cmT.setTag(this.mId);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.cmT);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.cmT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amj() {
        if (!TbadkCoreApplication.m411getInst().appResponseToCmd(2802001)) {
            setHideBaobao(true);
        }
    }

    private void amk() {
        this.cmN = new ab(this.mContext);
        this.cmN.tP();
        addView(this.cmN, 0);
        this.cmN.setOnActionListener(this.cmQ);
    }

    public boolean alY() {
        return this.cmP.alY();
    }

    public void Y(View view) {
        this.cmP.Y(view);
    }

    public void Z(View view) {
        this.cmP.Z(view);
    }

    public void acy() {
        this.cmO.getEditText().requestFocus();
        this.cmP.aa(this.cmO.getEditText());
        this.cmO.getEditText().setSelection(this.cmO.getEditText().getText().length());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, ae aeVar) {
        this.cmO.getEditText().requestFocus();
        this.cmP.Z(this.cmO.getEditText());
        iq(i);
    }

    public void B(int i, String str) {
        if (this.cmN != null) {
            this.cmN.B(i, str);
            if (i == 2 && this.cmN.getVisibility() == 0) {
                this.cmP.za();
                this.cmO.amr();
                return;
            }
            aml();
        }
    }

    private void aml() {
        if (this.cmP != null) {
            this.cmP.zb();
            refresh();
        }
    }

    public void setLocationInfoViewState(int i) {
        B(i, null);
    }

    public int getLocationViewVisibility() {
        if (this.cmN == null) {
            return 8;
        }
        return this.cmN.getVisibility();
    }

    public int getLocationInfoViewState() {
        if (this.cmN == null) {
            return 0;
        }
        return this.cmN.getLocationInfoViewState();
    }

    protected void iq(int i) {
        if (i == 5) {
            this.cmP.alP();
        } else if (i == 23 || i == 22) {
            this.cmP.alQ();
        } else if (i == 2) {
            this.cmP.alO();
        } else if (i == 38) {
            this.cmP.alN();
        } else if (i == 44) {
            this.cmP.alR();
        } else if (i == 50 || i == 48) {
            this.cmP.alS();
        }
    }

    public void ir(int i) {
        if (this.cmP.alK()) {
            iq(i);
            this.cmP.Z(this.cmO.getEditText());
            return;
        }
        this.cmU = false;
        if (this.cmP.alY()) {
            this.cmP.Z(this.cmO.getEditText());
        }
        new Handler().postDelayed(new s(this, i), 200L);
    }

    public boolean Ji() {
        Editable text = this.cmO.getEditText().getText();
        return (text == null ? 0 : text.length()) >= this.cmM;
    }

    public void a(TbPageContext<?> tbPageContext, com.baidu.tbadk.editortool.v vVar) {
        this.mPageContext = tbPageContext;
        if (vVar != null) {
            this.cmQ = vVar;
            if (this.cmN != null) {
                this.cmN.setOnActionListener(vVar);
            }
            this.cmO.setOnActionListener(new u(this, vVar));
            this.cmP.setOnActionListener(new v(this, vVar));
        }
    }

    public void alW() {
        this.cmP.alW();
    }

    public void b(TbPageContext<?> tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().X(i == 1);
            tbPageContext.getLayoutMode().h(this.cmO);
            tbPageContext.getLayoutMode().h(this.cmP);
        }
        if (this.cmN != null) {
            this.cmN.tP();
        }
        this.cmO.changeSkinType(i);
        this.cmP.onChangeSkinType(i);
    }

    public void clearData() {
        this.cmO.clearData();
        this.cmP.clearData();
    }

    public void alM() {
        this.cmP.alM();
    }

    public void Cf() {
        if (this.cmQ != null) {
            this.cmQ.handleAction(33, null);
        }
        setVisibility(0);
    }

    public void hide() {
        if (this.cmQ != null) {
            this.cmQ.handleAction(34, null);
        }
        this.cmO.alt();
        this.cmP.hideAll();
        Z(getEditText());
        setVisibility(8);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    public void setMoreFocusable(boolean z) {
        this.cmO.setMoreFocusable(z);
    }

    public void setAudioFocusable(boolean z) {
        this.cmO.setAudioFocusable(z);
    }

    public void abm() {
        this.cmO.abm();
    }

    public void abn() {
        this.cmO.abn();
    }

    public void Jn() {
        this.cmP.Jn();
    }

    public VoiceData.VoiceModel getAudioData() {
        return this.cmP.getAudioData();
    }

    public void setAudioData(VoiceData.VoiceModel voiceModel) {
        this.cmP.setAudioData(voiceModel);
    }

    public void Jm() {
        this.cmP.Jm();
    }

    public void k(Bitmap bitmap) {
        this.cmP.setImage(bitmap);
    }

    public void aQ(boolean z) {
        this.cmy = z;
        this.cmP.aQ(z);
        if (z) {
            setLocationViewVisibility(8);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public static int iG(String str) {
        int i = 0;
        if (str != null && str.length() != 0) {
            Matcher matcher = cmV.matcher(str);
            while (matcher.find()) {
                if (com.baidu.tbadk.editortool.aa.yR().eg(matcher.group())) {
                    i++;
                }
            }
        }
        return i;
    }

    public void refresh() {
        if (this.cmy) {
            this.cmO.ams();
            return;
        }
        if (TextUtils.isEmpty(TbadkCoreApplication.m411getInst().getDefaultBubble()) && !this.cmy) {
            if (!this.cmP.alT() && !this.cmP.alU() && !this.cmP.yZ()) {
                this.cmO.ams();
            } else {
                this.cmO.amr();
            }
        } else {
            this.cmO.amr();
        }
        this.cmP.refresh();
    }

    public void setMaxTextCount(int i) {
        this.cmM = i;
    }

    public void setLocationViewVisibility(int i) {
        if (i == 0) {
            if (this.cmN == null) {
                amk();
            }
            this.cmN.setVisibility(0);
            return;
        }
        if (this.cmN != null) {
            removeView(this.cmN);
            this.cmN = null;
        }
        aml();
    }
}
