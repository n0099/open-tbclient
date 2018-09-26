package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.o;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.e;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
/* loaded from: classes2.dex */
public class VideoPlayInputContainer extends LinearLayout implements l {
    private EditorTools SG;
    private int SH;
    private int aCJ;
    private boolean aQS;
    private boolean aQT;
    private boolean aQU;
    private int aQV;
    private EditText aRu;
    private LinearLayout aRy;
    private ImageView hvU;
    private View mBottomLine;
    private TextView mSendView;

    public VideoPlayInputContainer(Context context) {
        this(context, null);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aQS = false;
        this.aQT = true;
        this.aQU = true;
        this.aQV = -1;
        this.aCJ = 0;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(e.C0141e.tbds144));
        this.aRy = new LinearLayout(getContext());
        this.aRy.setOrientation(0);
        this.aRy.setMinimumHeight(com.baidu.adp.lib.util.l.h(context, e.C0141e.ds90));
        addView(this.aRy, new LinearLayout.LayoutParams(-1, -2));
        cU(context);
        bI(context);
        bH(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(getContext(), e.C0141e.ds1)));
        addView(this.mBottomLine);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void cU(Context context) {
        this.hvU = new ImageView(context);
        this.hvU.setEnabled(true);
        this.hvU.setPadding(0, 0, com.baidu.adp.lib.util.l.h(context, e.C0141e.tbds30), com.baidu.adp.lib.util.l.h(context, e.C0141e.tbds24));
        this.hvU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(1, 5, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        this.aRy.addView(this.hvU, layoutParams);
    }

    private void bI(Context context) {
        this.aRu = new EditText(context);
        this.aRu.setMinHeight(context.getResources().getDimensionPixelSize(e.C0141e.ds32));
        this.aRu.setMaxLines(4);
        this.aRu.setGravity(16);
        this.aRu.setTextSize(0, getResources().getDimensionPixelSize(e.C0141e.ds32));
        this.aRu.setBackgroundResource(e.d.common_color_10022);
        a(this.aRu, e.f.edittext_cursor);
        this.aRu.setPadding(0, com.baidu.adp.lib.util.l.h(context, e.C0141e.ds24), com.baidu.adp.lib.util.l.h(context, e.C0141e.ds54), com.baidu.adp.lib.util.l.h(context, e.C0141e.ds24));
        this.aRu.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.aRu.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!VideoPlayInputContainer.this.aQU) {
                    VideoPlayInputContainer.this.aQU = true;
                    if (VideoPlayInputContainer.this.aQV != -1) {
                        VideoPlayInputContainer.this.aRu.setSelection(VideoPlayInputContainer.this.aQV);
                        VideoPlayInputContainer.this.aQV = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, VideoPlayInputContainer.this.aRu.getText().toString()));
                }
                VideoPlayInputContainer.this.mSendView.setEnabled((editable == null || StringUtils.isNull(editable.toString().trim())) ? false : true);
                VideoPlayInputContainer.this.bGY();
            }
        });
        this.aRu.setHint(context.getString(e.j.reply_something));
        this.aRu.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    VideoPlayInputContainer.this.aRu.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        this.aRy.addView(this.aRu, layoutParams);
    }

    private void a(EditText editText, int i) {
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(editText, Integer.valueOf(i));
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    private void bH(Context context) {
        this.mSendView = new TextView(context);
        this.mSendView.setGravity(17);
        this.mSendView.setIncludeFontPadding(false);
        this.mSendView.setEnabled(false);
        this.mSendView.setTextSize(0, context.getResources().getDimensionPixelSize(e.C0141e.fontsize32));
        this.mSendView.setText(e.j.replay);
        this.mSendView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, com.baidu.adp.lib.util.l.h(context, e.C0141e.tbds18));
        layoutParams.gravity = 80;
        this.aRy.addView(this.mSendView, layoutParams);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.aRu.getSelectionStart() > 0) {
                        String substring = this.aRu.getText().toString().substring(0, this.aRu.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.daY.matcher(substring);
                        if (matcher.find()) {
                            this.aRu.getText().delete(this.aRu.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.aRu.getSelectionStart());
                            return;
                        }
                        this.aRu.getText().delete(this.aRu.getSelectionStart() - 1, this.aRu.getSelectionStart());
                        return;
                    }
                    return;
                case 6:
                    if (aVar.data == null) {
                        this.aRu.setText((CharSequence) null);
                        return;
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.aRu.setText((CharSequence) null);
                            return;
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void a(SpannableStringBuilder spannableStringBuilder) {
                                    VideoPlayInputContainer.this.aRu.setText(spannableStringBuilder);
                                    VideoPlayInputContainer.this.aRu.setSelection(VideoPlayInputContainer.this.aRu.getText().length());
                                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    VideoPlayInputContainer.this.requestFocus();
                                }
                            });
                            return;
                        }
                    } else {
                        return;
                    }
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.aRu.setText((CharSequence) null);
                    }
                    this.mSendView.setEnabled(false);
                    bGY();
                    return;
                case 24:
                    if (aVar.data != null && (aVar.data instanceof o)) {
                        o oVar = (o) aVar.data;
                        if (oVar.Dv() == EmotionGroupType.NET_SUG) {
                            a(oVar);
                            return;
                        } else {
                            b(oVar);
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void a(o oVar) {
        if (oVar != null && !TextUtils.isEmpty(oVar.getName()) && !TextUtils.isEmpty(oVar.getUrl())) {
            String obj = this.aRu.getText().toString();
            if (this.aQT && com.baidu.tieba.face.a.me(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.zk().showToast(e.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), oVar, this.aRu);
            }
        }
    }

    private void b(o oVar) {
        if (!this.aQS || oVar.Dv() == EmotionGroupType.LOCAL) {
            String obj = this.aRu.getText().toString();
            if (this.aQT && com.baidu.tieba.face.a.me(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.zk().showToast(e.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), oVar, this.aRu);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.SG = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.SG != null) {
            this.SG.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.SH = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.SH;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void pI() {
        if (this.aRu != null) {
            this.aRu.setFocusable(true);
            this.aRu.setFocusableInTouchMode(true);
            this.aRu.requestFocus();
            com.baidu.adp.lib.util.l.b(getContext(), this.aRu);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.aCJ = i;
        al.j(this.mBottomLine, e.d.cp_bg_line_c);
        al.b(this.aRu, e.d.cp_cont_f, 2, i);
        al.j(this, e.d.cp_bg_line_d);
        if (i == 0) {
            a(this.aRu, e.f.edittext_cursor);
            this.aRu.setHintTextColor(getContext().getResources().getColor(e.d.cp_cont_d));
        } else {
            a(this.aRu, e.f.edittext_cursor_1);
            this.aRu.setHintTextColor(al.getColor(i, e.d.cp_cont_d));
        }
        bGY();
        al.c(this.hvU, e.f.pbeditor_face_button);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGY() {
        if (this.mSendView.isEnabled()) {
            al.b(this.mSendView, e.d.cp_link_tip_a, 1, this.aCJ);
        } else {
            al.c(this.mSendView, e.d.cp_cont_j, 1);
        }
    }

    public EditText getInputView() {
        return this.aRu;
    }
}
