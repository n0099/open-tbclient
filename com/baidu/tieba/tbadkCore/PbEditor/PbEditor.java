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
    private static final Pattern cmB = Pattern.compile("#\\([^#\\)\\(]+\\)$");
    private static final Pattern cmF = Pattern.compile("#\\([a-zA-Z0-9_\\u4E00-\\u9FA5]+\\)");
    private boolean ajV;
    protected com.baidu.tbadk.editortool.v cmA;
    private boolean cmC;
    private final CustomMessageListener cmD;
    protected boolean cmE;
    private boolean cmi;
    private int cmw;
    private ab cmx;
    protected PbEditorToolView cmy;
    public EditorToolComponetContainer cmz;
    protected Context mContext;
    private BdUniqueId mId;
    private TbPageContext<?> mPageContext;

    public void setHideBaobao(boolean z) {
        this.ajV = z;
        if (this.cmz != null) {
            this.cmz.setHideBaobao(z);
        }
    }

    public EditorToolComponetContainer getEditorToolComponetContainer() {
        return this.cmz;
    }

    public PbEditorToolView getEditorToolButtonContainer() {
        return this.cmy;
    }

    public PbEditor(Context context) {
        super(context);
        this.cmw = 1000;
        this.cmi = false;
        this.ajV = false;
        this.cmD = new q(this, 2001310);
        this.cmE = true;
        this.mContext = context;
        this.mId = BdUniqueId.gen();
        initialize();
    }

    public PbEditor(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cmw = 1000;
        this.cmi = false;
        this.ajV = false;
        this.cmD = new q(this, 2001310);
        this.cmE = true;
        this.mContext = context;
        this.mId = BdUniqueId.gen();
        initialize();
    }

    public void setFrom(int i) {
        if (this.cmz != null) {
            this.cmz.setFrom(i);
        }
    }

    public void alN() {
        this.cmy.alN();
    }

    public void alO() {
        this.cmy.alO();
    }

    public boolean alP() {
        Editable text = this.cmy.getEditText().getText();
        if ((text != null && text.toString().trim().length() > 0) || this.cmz.alE() || this.cmz.alF()) {
            return true;
        }
        return this.cmz.alG();
    }

    public EditText getEditText() {
        return this.cmy.getEditText();
    }

    public void v(ArrayList<String> arrayList) {
        this.cmy.V(arrayList);
    }

    public String getContent() {
        return this.cmy.getEditText().getText().toString();
    }

    public void setContent(String str) {
        this.cmy.getEditText().setText(str);
        if (!TextUtils.isEmpty(str)) {
            this.cmy.getEditText().setSelection(str.length());
        }
    }

    public void alQ() {
        this.cmy.getEditText().requestFocus();
        this.cmz.aa(this.cmy.getEditText());
    }

    public void alR() {
        this.cmz.hideAll();
        this.cmy.ale();
    }

    public void alS() {
        this.cmz.hideAll();
        this.cmy.ale();
    }

    public void alT() {
        if (this.cmz.alv() && !this.cmC) {
            this.cmC = true;
            ac.a(this, this.mContext, new r(this));
            return;
        }
        alR();
    }

    public boolean alv() {
        return this.cmz.alv();
    }

    protected void initialize() {
        com.baidu.adp.lib.g.b.hH().a(this.mContext, com.baidu.tieba.w.pb_editor_view, this, true);
        this.cmy = (PbEditorToolView) findViewById(com.baidu.tieba.v.pb_editor_tool_button);
        this.cmz = (EditorToolComponetContainer) findViewById(com.baidu.tieba.v.pb_editor_tool_group);
        alU();
        MessageManager.getInstance().unRegisterListener(this.mId);
        this.cmD.setTag(this.mId);
        MessageManager.getInstance().registerListener(this.cmD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alU() {
        if (!TbadkCoreApplication.m411getInst().appResponseToCmd(2802001)) {
            setHideBaobao(true);
        }
    }

    private void alV() {
        this.cmx = new ab(this.mContext);
        this.cmx.tP();
        addView(this.cmx, 0);
        this.cmx.setOnActionListener(this.cmA);
    }

    public boolean alJ() {
        return this.cmz.alJ();
    }

    public void Y(View view) {
        this.cmz.Y(view);
    }

    public void Z(View view) {
        this.cmz.Z(view);
    }

    public void acj() {
        this.cmy.getEditText().requestFocus();
        this.cmz.aa(this.cmy.getEditText());
        this.cmy.getEditText().setSelection(this.cmy.getEditText().getText().length());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, ae aeVar) {
        this.cmy.getEditText().requestFocus();
        this.cmz.Z(this.cmy.getEditText());
        in(i);
    }

    public void B(int i, String str) {
        if (this.cmx != null) {
            this.cmx.B(i, str);
            if (i == 2 && this.cmx.getVisibility() == 0) {
                this.cmz.yU();
                this.cmy.amc();
                return;
            }
            alW();
        }
    }

    private void alW() {
        if (this.cmz != null) {
            this.cmz.yV();
            refresh();
        }
    }

    public void setLocationInfoViewState(int i) {
        B(i, null);
    }

    public int getLocationViewVisibility() {
        if (this.cmx == null) {
            return 8;
        }
        return this.cmx.getVisibility();
    }

    public int getLocationInfoViewState() {
        if (this.cmx == null) {
            return 0;
        }
        return this.cmx.getLocationInfoViewState();
    }

    protected void in(int i) {
        if (i == 5) {
            this.cmz.alA();
        } else if (i == 23 || i == 22) {
            this.cmz.alB();
        } else if (i == 2) {
            this.cmz.alz();
        } else if (i == 38) {
            this.cmz.aly();
        } else if (i == 44) {
            this.cmz.alC();
        } else if (i == 50 || i == 48) {
            this.cmz.alD();
        }
    }

    public void io(int i) {
        if (this.cmz.alv()) {
            in(i);
            this.cmz.Z(this.cmy.getEditText());
            return;
        }
        this.cmE = false;
        if (this.cmz.alJ()) {
            this.cmz.Z(this.cmy.getEditText());
        }
        new Handler().postDelayed(new s(this, i), 200L);
    }

    public boolean Jc() {
        Editable text = this.cmy.getEditText().getText();
        return (text == null ? 0 : text.length()) >= this.cmw;
    }

    public void a(TbPageContext<?> tbPageContext, com.baidu.tbadk.editortool.v vVar) {
        this.mPageContext = tbPageContext;
        if (vVar != null) {
            this.cmA = vVar;
            if (this.cmx != null) {
                this.cmx.setOnActionListener(vVar);
            }
            this.cmy.setOnActionListener(new u(this, vVar));
            this.cmz.setOnActionListener(new v(this, vVar));
        }
    }

    public void alH() {
        this.cmz.alH();
    }

    public void b(TbPageContext<?> tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().X(i == 1);
            tbPageContext.getLayoutMode().h(this.cmy);
            tbPageContext.getLayoutMode().h(this.cmz);
        }
        if (this.cmx != null) {
            this.cmx.tP();
        }
        this.cmy.changeSkinType(i);
        this.cmz.onChangeSkinType(i);
    }

    public void clearData() {
        this.cmy.clearData();
        this.cmz.clearData();
    }

    public void alx() {
        this.cmz.alx();
    }

    public void BZ() {
        if (this.cmA != null) {
            this.cmA.handleAction(33, null);
        }
        setVisibility(0);
    }

    public void hide() {
        if (this.cmA != null) {
            this.cmA.handleAction(34, null);
        }
        this.cmy.ale();
        this.cmz.hideAll();
        Z(getEditText());
        setVisibility(8);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    public void setMoreFocusable(boolean z) {
        this.cmy.setMoreFocusable(z);
    }

    public void setAudioFocusable(boolean z) {
        this.cmy.setAudioFocusable(z);
    }

    public void aaY() {
        this.cmy.aaY();
    }

    public void aaZ() {
        this.cmy.aaZ();
    }

    public void Jh() {
        this.cmz.Jh();
    }

    public VoiceData.VoiceModel getAudioData() {
        return this.cmz.getAudioData();
    }

    public void setAudioData(VoiceData.VoiceModel voiceModel) {
        this.cmz.setAudioData(voiceModel);
    }

    public void Jg() {
        this.cmz.Jg();
    }

    public void k(Bitmap bitmap) {
        this.cmz.setImage(bitmap);
    }

    public void aQ(boolean z) {
        this.cmi = z;
        this.cmz.aQ(z);
        if (z) {
            setLocationViewVisibility(8);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public static int iD(String str) {
        int i = 0;
        if (str != null && str.length() != 0) {
            Matcher matcher = cmF.matcher(str);
            while (matcher.find()) {
                if (com.baidu.tbadk.editortool.aa.yL().ed(matcher.group())) {
                    i++;
                }
            }
        }
        return i;
    }

    public void refresh() {
        if (this.cmi) {
            this.cmy.amd();
            return;
        }
        if (TextUtils.isEmpty(TbadkCoreApplication.m411getInst().getDefaultBubble()) && !this.cmi) {
            if (!this.cmz.alE() && !this.cmz.alF() && !this.cmz.yT()) {
                this.cmy.amd();
            } else {
                this.cmy.amc();
            }
        } else {
            this.cmy.amc();
        }
        this.cmz.refresh();
    }

    public void setMaxTextCount(int i) {
        this.cmw = i;
    }

    public void setLocationViewVisibility(int i) {
        if (i == 0) {
            if (this.cmx == null) {
                alV();
            }
            this.cmx.setVisibility(0);
            return;
        }
        if (this.cmx != null) {
            removeView(this.cmx);
            this.cmx = null;
        }
        alW();
    }
}
