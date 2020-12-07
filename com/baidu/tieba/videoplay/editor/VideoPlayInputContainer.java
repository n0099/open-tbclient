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
import com.baidu.tieba.write.j;
import java.util.regex.Matcher;
/* loaded from: classes24.dex */
public class VideoPlayInputContainer extends LinearLayout implements n {
    private EditorTools acn;
    private int aco;
    private int aku;
    private TextView bQv;
    private boolean fvH;
    private boolean fvI;
    private boolean fvJ;
    private int fvK;
    private EditText fwL;
    private LinearLayout fwP;
    private ImageView iWv;
    private View mBottomLine;

    public VideoPlayInputContainer(Context context) {
        this(context, null);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fvH = false;
        this.fvI = true;
        this.fvJ = true;
        this.fvK = -1;
        this.aku = 0;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.tbds144));
        this.fwP = new LinearLayout(getContext());
        this.fwP.setOrientation(0);
        this.fwP.setMinimumHeight(l.getDimens(context, R.dimen.ds90));
        addView(this.fwP, new LinearLayout.LayoutParams(-1, -2));
        gJ(context);
        eU(context);
        eT(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void gJ(Context context) {
        this.iWv = new ImageView(context);
        this.iWv.setEnabled(true);
        this.iWv.setPadding(0, 0, l.getDimens(context, R.dimen.tbds30), l.getDimens(context, R.dimen.tbds24));
        this.iWv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(1, 5, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        this.fwP.addView(this.iWv, layoutParams);
    }

    private void eU(Context context) {
        this.fwL = new EditText(context);
        this.fwL.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.fwL.setMaxLines(4);
        this.fwL.setGravity(16);
        this.fwL.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.fwL.setBackgroundResource(R.color.common_color_10022);
        j.h(this.fwL, R.drawable.edittext_cursor);
        this.fwL.setPadding(0, l.getDimens(context, R.dimen.ds24), l.getDimens(context, R.dimen.ds54), l.getDimens(context, R.dimen.ds24));
        this.fwL.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.fwL.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!VideoPlayInputContainer.this.fvJ) {
                    VideoPlayInputContainer.this.fvJ = true;
                    if (VideoPlayInputContainer.this.fvK != -1) {
                        VideoPlayInputContainer.this.fwL.setSelection(VideoPlayInputContainer.this.fvK);
                        VideoPlayInputContainer.this.fvK = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, VideoPlayInputContainer.this.fwL.getText().toString()));
                }
                VideoPlayInputContainer.this.bQv.setEnabled((editable == null || StringUtils.isNull(editable.toString().trim())) ? false : true);
                VideoPlayInputContainer.this.dXI();
            }
        });
        this.fwL.setHint(context.getString(R.string.reply_something));
        this.fwL.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    VideoPlayInputContainer.this.fwL.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        this.fwP.addView(this.fwL, layoutParams);
    }

    private void eT(Context context) {
        this.bQv = new TextView(context);
        this.bQv.setGravity(17);
        this.bQv.setIncludeFontPadding(false);
        this.bQv.setEnabled(false);
        this.bQv.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.fontsize32));
        this.bQv.setText(R.string.send_replay);
        this.bQv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, l.getDimens(context, R.dimen.tbds18));
        layoutParams.gravity = 80;
        this.fwP.addView(this.bQv, layoutParams);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.fwL.getSelectionStart() > 0) {
                        String substring = this.fwL.getText().toString().substring(0, this.fwL.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.iEW.matcher(substring);
                        if (matcher.find()) {
                            this.fwL.getText().delete(this.fwL.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.fwL.getSelectionStart());
                            return;
                        }
                        this.fwL.getText().delete(this.fwL.getSelectionStart() - 1, this.fwL.getSelectionStart());
                        return;
                    }
                    return;
                case 6:
                    if (aVar.data == null) {
                        this.fwL.setText((CharSequence) null);
                        return;
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.fwL.setText((CharSequence) null);
                            return;
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void d(SpannableStringBuilder spannableStringBuilder) {
                                    VideoPlayInputContainer.this.fwL.setText(spannableStringBuilder);
                                    VideoPlayInputContainer.this.fwL.setSelection(VideoPlayInputContainer.this.fwL.getText().length());
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
                        this.fwL.setText((CharSequence) null);
                    }
                    this.bQv.setEnabled(false);
                    dXI();
                    return;
                case 24:
                    if (aVar.data != null && (aVar.data instanceof u)) {
                        u uVar = (u) aVar.data;
                        if (uVar.bxC() == EmotionGroupType.NET_SUG) {
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
            String obj = this.fwL.getText().toString();
            if (this.fvI && com.baidu.tieba.face.a.JV(obj) >= 10 && getContext() != null) {
                e.bsW().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), uVar, this.fwL);
            }
        }
    }

    private void b(u uVar) {
        if (!this.fvH || uVar.bxC() == EmotionGroupType.LOCAL) {
            String obj = this.fwL.getText().toString();
            if (this.fvI && com.baidu.tieba.face.a.JV(obj) >= 10 && getContext() != null) {
                e.bsW().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), uVar, this.fwL);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.acn = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.acn != null) {
            this.acn.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.aco = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.aco;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void su() {
        if (this.fwL != null) {
            this.fwL.setFocusable(true);
            this.fwL.setFocusableInTouchMode(true);
            this.fwL.requestFocus();
            l.showSoftKeyPad(getContext(), this.fwL);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        this.aku = i;
        ap.setBackgroundColor(this.mBottomLine, R.color.CAM_X0204);
        ap.setViewTextColor(this.fwL, R.color.CAM_X0106, 2, i);
        ap.setBackgroundColor(this, R.color.CAM_X0201);
        if (i == 0) {
            j.h(this.fwL, R.drawable.edittext_cursor);
            this.fwL.setHintTextColor(getContext().getResources().getColor(R.color.CAM_X0109));
        } else {
            j.h(this.fwL, R.drawable.edittext_cursor_1);
            this.fwL.setHintTextColor(ap.getColor(i, R.color.CAM_X0109));
        }
        dXI();
        ap.setImageResource(this.iWv, R.drawable.pbeditor_face_button);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXI() {
        if (this.bQv.isEnabled()) {
            ap.setViewTextColor(this.bQv, R.color.CAM_X0302, 1, this.aku);
        } else {
            ap.setViewTextColor(this.bQv, R.color.CAM_X0107, 1);
        }
    }

    public EditText getInputView() {
        return this.fwL;
    }
}
