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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.e;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.n;
import com.baidu.tieba.R;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
/* loaded from: classes23.dex */
public class VideoPlayInputContainer extends LinearLayout implements n {
    private EditorTools aaS;
    private int aaT;
    private int aiX;
    private TextView bxT;
    private boolean eOA;
    private int eOB;
    private boolean eOy;
    private boolean eOz;
    private EditText ePB;
    private LinearLayout ePF;
    private ImageView idz;
    private View mBottomLine;

    public VideoPlayInputContainer(Context context) {
        this(context, null);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eOy = false;
        this.eOz = true;
        this.eOA = true;
        this.eOB = -1;
        this.aiX = 0;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.tbds144));
        this.ePF = new LinearLayout(getContext());
        this.ePF.setOrientation(0);
        this.ePF.setMinimumHeight(l.getDimens(context, R.dimen.ds90));
        addView(this.ePF, new LinearLayout.LayoutParams(-1, -2));
        fR(context);
        ei(context);
        eh(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void fR(Context context) {
        this.idz = new ImageView(context);
        this.idz.setEnabled(true);
        this.idz.setPadding(0, 0, l.getDimens(context, R.dimen.tbds30), l.getDimens(context, R.dimen.tbds24));
        this.idz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(1, 5, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        this.ePF.addView(this.idz, layoutParams);
    }

    private void ei(Context context) {
        this.ePB = new EditText(context);
        this.ePB.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.ePB.setMaxLines(4);
        this.ePB.setGravity(16);
        this.ePB.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.ePB.setBackgroundResource(R.color.common_color_10022);
        g(this.ePB, R.drawable.edittext_cursor);
        this.ePB.setPadding(0, l.getDimens(context, R.dimen.ds24), l.getDimens(context, R.dimen.ds54), l.getDimens(context, R.dimen.ds24));
        this.ePB.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.ePB.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!VideoPlayInputContainer.this.eOA) {
                    VideoPlayInputContainer.this.eOA = true;
                    if (VideoPlayInputContainer.this.eOB != -1) {
                        VideoPlayInputContainer.this.ePB.setSelection(VideoPlayInputContainer.this.eOB);
                        VideoPlayInputContainer.this.eOB = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, VideoPlayInputContainer.this.ePB.getText().toString()));
                }
                VideoPlayInputContainer.this.bxT.setEnabled((editable == null || StringUtils.isNull(editable.toString().trim())) ? false : true);
                VideoPlayInputContainer.this.dIT();
            }
        });
        this.ePB.setHint(context.getString(R.string.reply_something));
        this.ePB.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    VideoPlayInputContainer.this.ePB.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        this.ePF.addView(this.ePB, layoutParams);
    }

    private void g(EditText editText, int i) {
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(editText, Integer.valueOf(i));
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    private void eh(Context context) {
        this.bxT = new TextView(context);
        this.bxT.setGravity(17);
        this.bxT.setIncludeFontPadding(false);
        this.bxT.setEnabled(false);
        this.bxT.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.fontsize32));
        this.bxT.setText(R.string.send_replay);
        this.bxT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, l.getDimens(context, R.dimen.tbds18));
        layoutParams.gravity = 80;
        this.ePF.addView(this.bxT, layoutParams);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.ePB.getSelectionStart() > 0) {
                        String substring = this.ePB.getText().toString().substring(0, this.ePB.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.hLW.matcher(substring);
                        if (matcher.find()) {
                            this.ePB.getText().delete(this.ePB.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.ePB.getSelectionStart());
                            return;
                        }
                        this.ePB.getText().delete(this.ePB.getSelectionStart() - 1, this.ePB.getSelectionStart());
                        return;
                    }
                    return;
                case 6:
                    if (aVar.data == null) {
                        this.ePB.setText((CharSequence) null);
                        return;
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.ePB.setText((CharSequence) null);
                            return;
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    VideoPlayInputContainer.this.ePB.setText(spannableStringBuilder);
                                    VideoPlayInputContainer.this.ePB.setSelection(VideoPlayInputContainer.this.ePB.getText().length());
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
                        this.ePB.setText((CharSequence) null);
                    }
                    this.bxT.setEnabled(false);
                    dIT();
                    return;
                case 24:
                    if (aVar.data != null && (aVar.data instanceof u)) {
                        u uVar = (u) aVar.data;
                        if (uVar.bnJ() == EmotionGroupType.NET_SUG) {
                            a(uVar);
                            return;
                        } else {
                            b(uVar);
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void a(u uVar) {
        if (uVar != null && !TextUtils.isEmpty(uVar.getName()) && !TextUtils.isEmpty(uVar.getUrl())) {
            String obj = this.ePB.getText().toString();
            if (this.eOz && com.baidu.tieba.face.a.Ib(obj) >= 10 && getContext() != null) {
                e.bjn().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), uVar, this.ePB);
            }
        }
    }

    private void b(u uVar) {
        if (!this.eOy || uVar.bnJ() == EmotionGroupType.LOCAL) {
            String obj = this.ePB.getText().toString();
            if (this.eOz && com.baidu.tieba.face.a.Ib(obj) >= 10 && getContext() != null) {
                e.bjn().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), uVar, this.ePB);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.aaS = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.aaS != null) {
            this.aaS.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.aaT = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.aaT;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void display() {
        if (this.ePB != null) {
            this.ePB.setFocusable(true);
            this.ePB.setFocusableInTouchMode(true);
            this.ePB.requestFocus();
            l.showSoftKeyPad(getContext(), this.ePB);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        this.aiX = i;
        ap.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.ePB, R.color.cp_cont_f, 2, i);
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (i == 0) {
            g(this.ePB, R.drawable.edittext_cursor);
            this.ePB.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_d));
        } else {
            g(this.ePB, R.drawable.edittext_cursor_1);
            this.ePB.setHintTextColor(ap.getColor(i, R.color.cp_cont_d));
        }
        dIT();
        ap.setImageResource(this.idz, R.drawable.pbeditor_face_button);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dIT() {
        if (this.bxT.isEnabled()) {
            ap.setViewTextColor(this.bxT, R.color.cp_link_tip_a, 1, this.aiX);
        } else {
            ap.setViewTextColor(this.bxT, R.color.cp_cont_j, 1);
        }
    }

    public EditText getInputView() {
        return this.ePB;
    }
}
