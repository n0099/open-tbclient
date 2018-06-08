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
import com.baidu.tbadk.core.util.e;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.n;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.d;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
/* loaded from: classes2.dex */
public class VideoPlayInputContainer extends LinearLayout implements l {
    private EditorTools Qh;
    private int Qi;
    private boolean aMH;
    private boolean aMI;
    private boolean aMJ;
    private int aMK;
    private EditText aNk;
    private LinearLayout aNo;
    private int ayX;
    private ImageView hiI;
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
        this.aMH = false;
        this.aMI = true;
        this.aMJ = true;
        this.aMK = -1;
        this.ayX = 0;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(d.e.tbds144));
        this.aNo = new LinearLayout(getContext());
        this.aNo.setOrientation(0);
        this.aNo.setMinimumHeight(com.baidu.adp.lib.util.l.e(context, d.e.ds90));
        addView(this.aNo, new LinearLayout.LayoutParams(-1, -2));
        cp(context);
        bc(context);
        bb(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.e(getContext(), d.e.ds1)));
        addView(this.mBottomLine);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void cp(Context context) {
        this.hiI = new ImageView(context);
        this.hiI.setEnabled(true);
        this.hiI.setPadding(0, 0, com.baidu.adp.lib.util.l.e(context, d.e.tbds30), com.baidu.adp.lib.util.l.e(context, d.e.tbds24));
        this.hiI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(1, 5, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        this.aNo.addView(this.hiI, layoutParams);
    }

    private void bc(Context context) {
        this.aNk = new EditText(context);
        this.aNk.setMinHeight(context.getResources().getDimensionPixelSize(d.e.ds32));
        this.aNk.setMaxLines(4);
        this.aNk.setGravity(16);
        this.aNk.setTextSize(0, getResources().getDimensionPixelSize(d.e.ds32));
        this.aNk.setBackgroundResource(d.C0141d.common_color_10022);
        a(this.aNk, d.f.edittext_cursor);
        this.aNk.setPadding(0, com.baidu.adp.lib.util.l.e(context, d.e.ds24), com.baidu.adp.lib.util.l.e(context, d.e.ds54), com.baidu.adp.lib.util.l.e(context, d.e.ds24));
        this.aNk.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.aNk.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!VideoPlayInputContainer.this.aMJ) {
                    VideoPlayInputContainer.this.aMJ = true;
                    if (VideoPlayInputContainer.this.aMK != -1) {
                        VideoPlayInputContainer.this.aNk.setSelection(VideoPlayInputContainer.this.aMK);
                        VideoPlayInputContainer.this.aMK = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, VideoPlayInputContainer.this.aNk.getText().toString()));
                }
                VideoPlayInputContainer.this.mSendView.setEnabled((editable == null || StringUtils.isNull(editable.toString().trim())) ? false : true);
                VideoPlayInputContainer.this.bEU();
            }
        });
        this.aNk.setHint(context.getString(d.k.reply_something));
        this.aNk.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    VideoPlayInputContainer.this.aNk.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        this.aNo.addView(this.aNk, layoutParams);
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

    private void bb(Context context) {
        this.mSendView = new TextView(context);
        this.mSendView.setGravity(17);
        this.mSendView.setIncludeFontPadding(false);
        this.mSendView.setEnabled(false);
        this.mSendView.setTextSize(0, context.getResources().getDimensionPixelSize(d.e.fontsize32));
        this.mSendView.setText(d.k.replay);
        this.mSendView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, com.baidu.adp.lib.util.l.e(context, d.e.tbds18));
        layoutParams.gravity = 80;
        this.aNo.addView(this.mSendView, layoutParams);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.aNk.getSelectionStart() > 0) {
                        String substring = this.aNk.getText().toString().substring(0, this.aNk.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.cUu.matcher(substring);
                        if (matcher.find()) {
                            this.aNk.getText().delete(this.aNk.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.aNk.getSelectionStart());
                            return;
                        }
                        this.aNk.getText().delete(this.aNk.getSelectionStart() - 1, this.aNk.getSelectionStart());
                        return;
                    }
                    return;
                case 6:
                    if (aVar.data == null) {
                        this.aNk.setText((CharSequence) null);
                        return;
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.aNk.setText((CharSequence) null);
                            return;
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void a(SpannableStringBuilder spannableStringBuilder) {
                                    VideoPlayInputContainer.this.aNk.setText(spannableStringBuilder);
                                    VideoPlayInputContainer.this.aNk.setSelection(VideoPlayInputContainer.this.aNk.getText().length());
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
                        this.aNk.setText((CharSequence) null);
                    }
                    this.mSendView.setEnabled(false);
                    bEU();
                    return;
                case 24:
                    if (aVar.data != null && (aVar.data instanceof n)) {
                        n nVar = (n) aVar.data;
                        if (nVar.Cb() == EmotionGroupType.NET_SUG) {
                            a(nVar);
                            return;
                        } else {
                            b(nVar);
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void a(n nVar) {
        if (nVar != null && !TextUtils.isEmpty(nVar.getName()) && !TextUtils.isEmpty(nVar.getUrl())) {
            String obj = this.aNk.getText().toString();
            if (this.aMI && com.baidu.tieba.face.a.lF(obj) >= 10 && getContext() != null) {
                e.xZ().showToast(d.k.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), nVar, this.aNk);
            }
        }
    }

    private void b(n nVar) {
        if (!this.aMH || nVar.Cb() == EmotionGroupType.LOCAL) {
            String obj = this.aNk.getText().toString();
            if (this.aMI && com.baidu.tieba.face.a.lF(obj) >= 10 && getContext() != null) {
                e.xZ().showToast(d.k.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), nVar, this.aNk);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Qh = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Qh != null) {
            this.Qh.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Qi = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Qi;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void oD() {
        if (this.aNk != null) {
            this.aNk.setFocusable(true);
            this.aNk.setFocusableInTouchMode(true);
            this.aNk.requestFocus();
            com.baidu.adp.lib.util.l.c(getContext(), this.aNk);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.ayX = i;
        al.j(this.mBottomLine, d.C0141d.cp_bg_line_c);
        al.b(this.aNk, d.C0141d.cp_cont_f, 2, i);
        al.j(this, d.C0141d.cp_bg_line_d);
        if (i == 0) {
            a(this.aNk, d.f.edittext_cursor);
            this.aNk.setHintTextColor(getContext().getResources().getColor(d.C0141d.cp_cont_d));
        } else {
            a(this.aNk, d.f.edittext_cursor_1);
            this.aNk.setHintTextColor(al.getColor(i, d.C0141d.cp_cont_d));
        }
        bEU();
        al.c(this.hiI, d.f.pbeditor_face_button);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEU() {
        if (this.mSendView.isEnabled()) {
            al.b(this.mSendView, d.C0141d.cp_link_tip_a, 1, this.ayX);
        } else {
            al.c(this.mSendView, d.C0141d.cp_cont_j, 1);
        }
    }

    public EditText getInputView() {
        return this.aNk;
    }
}
