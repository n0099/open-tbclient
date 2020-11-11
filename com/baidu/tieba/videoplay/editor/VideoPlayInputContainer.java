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
/* loaded from: classes24.dex */
public class VideoPlayInputContainer extends LinearLayout implements n {
    private EditorTools abk;
    private int abl;
    private int ajq;
    private TextView bNa;
    private boolean foV;
    private boolean foW;
    private boolean foX;
    private int foY;
    private EditText fpZ;
    private LinearLayout fqd;
    private ImageView iKP;
    private View mBottomLine;

    public VideoPlayInputContainer(Context context) {
        this(context, null);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.foV = false;
        this.foW = true;
        this.foX = true;
        this.foY = -1;
        this.ajq = 0;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.tbds144));
        this.fqd = new LinearLayout(getContext());
        this.fqd.setOrientation(0);
        this.fqd.setMinimumHeight(l.getDimens(context, R.dimen.ds90));
        addView(this.fqd, new LinearLayout.LayoutParams(-1, -2));
        fZ(context);
        ep(context);
        eo(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void fZ(Context context) {
        this.iKP = new ImageView(context);
        this.iKP.setEnabled(true);
        this.iKP.setPadding(0, 0, l.getDimens(context, R.dimen.tbds30), l.getDimens(context, R.dimen.tbds24));
        this.iKP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(1, 5, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        this.fqd.addView(this.iKP, layoutParams);
    }

    private void ep(Context context) {
        this.fpZ = new EditText(context);
        this.fpZ.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.fpZ.setMaxLines(4);
        this.fpZ.setGravity(16);
        this.fpZ.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.fpZ.setBackgroundResource(R.color.common_color_10022);
        g(this.fpZ, R.drawable.edittext_cursor);
        this.fpZ.setPadding(0, l.getDimens(context, R.dimen.ds24), l.getDimens(context, R.dimen.ds54), l.getDimens(context, R.dimen.ds24));
        this.fpZ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.fpZ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!VideoPlayInputContainer.this.foX) {
                    VideoPlayInputContainer.this.foX = true;
                    if (VideoPlayInputContainer.this.foY != -1) {
                        VideoPlayInputContainer.this.fpZ.setSelection(VideoPlayInputContainer.this.foY);
                        VideoPlayInputContainer.this.foY = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, VideoPlayInputContainer.this.fpZ.getText().toString()));
                }
                VideoPlayInputContainer.this.bNa.setEnabled((editable == null || StringUtils.isNull(editable.toString().trim())) ? false : true);
                VideoPlayInputContainer.this.dSp();
            }
        });
        this.fpZ.setHint(context.getString(R.string.reply_something));
        this.fpZ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    VideoPlayInputContainer.this.fpZ.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        this.fqd.addView(this.fpZ, layoutParams);
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

    private void eo(Context context) {
        this.bNa = new TextView(context);
        this.bNa.setGravity(17);
        this.bNa.setIncludeFontPadding(false);
        this.bNa.setEnabled(false);
        this.bNa.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.fontsize32));
        this.bNa.setText(R.string.send_replay);
        this.bNa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, l.getDimens(context, R.dimen.tbds18));
        layoutParams.gravity = 80;
        this.fqd.addView(this.bNa, layoutParams);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.fpZ.getSelectionStart() > 0) {
                        String substring = this.fpZ.getText().toString().substring(0, this.fpZ.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.itq.matcher(substring);
                        if (matcher.find()) {
                            this.fpZ.getText().delete(this.fpZ.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.fpZ.getSelectionStart());
                            return;
                        }
                        this.fpZ.getText().delete(this.fpZ.getSelectionStart() - 1, this.fpZ.getSelectionStart());
                        return;
                    }
                    return;
                case 6:
                    if (aVar.data == null) {
                        this.fpZ.setText((CharSequence) null);
                        return;
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.fpZ.setText((CharSequence) null);
                            return;
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    VideoPlayInputContainer.this.fpZ.setText(spannableStringBuilder);
                                    VideoPlayInputContainer.this.fpZ.setSelection(VideoPlayInputContainer.this.fpZ.getText().length());
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
                        this.fpZ.setText((CharSequence) null);
                    }
                    this.bNa.setEnabled(false);
                    dSp();
                    return;
                case 24:
                    if (aVar.data != null && (aVar.data instanceof u)) {
                        u uVar = (u) aVar.data;
                        if (uVar.buM() == EmotionGroupType.NET_SUG) {
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
            String obj = this.fpZ.getText().toString();
            if (this.foW && com.baidu.tieba.face.a.JE(obj) >= 10 && getContext() != null) {
                e.bqp().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), uVar, this.fpZ);
            }
        }
    }

    private void b(u uVar) {
        if (!this.foV || uVar.buM() == EmotionGroupType.LOCAL) {
            String obj = this.fpZ.getText().toString();
            if (this.foW && com.baidu.tieba.face.a.JE(obj) >= 10 && getContext() != null) {
                e.bqp().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), uVar, this.fpZ);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.abk = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.abk != null) {
            this.abk.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.abl = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.abl;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void display() {
        if (this.fpZ != null) {
            this.fpZ.setFocusable(true);
            this.fpZ.setFocusableInTouchMode(true);
            this.fpZ.requestFocus();
            l.showSoftKeyPad(getContext(), this.fpZ);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        this.ajq = i;
        ap.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.fpZ, R.color.cp_cont_f, 2, i);
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (i == 0) {
            g(this.fpZ, R.drawable.edittext_cursor);
            this.fpZ.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_d));
        } else {
            g(this.fpZ, R.drawable.edittext_cursor_1);
            this.fpZ.setHintTextColor(ap.getColor(i, R.color.cp_cont_d));
        }
        dSp();
        ap.setImageResource(this.iKP, R.drawable.pbeditor_face_button);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dSp() {
        if (this.bNa.isEnabled()) {
            ap.setViewTextColor(this.bNa, R.color.cp_link_tip_a, 1, this.ajq);
        } else {
            ap.setViewTextColor(this.bNa, R.color.cp_cont_j, 1);
        }
    }

    public EditText getInputView() {
        return this.fpZ;
    }
}
