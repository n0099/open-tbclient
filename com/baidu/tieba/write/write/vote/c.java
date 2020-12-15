package com.baidu.tieba.write.write.vote;

import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.data.WriteVoteItemData;
import com.baidu.tbadk.util.ae;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends RecyclerView.Adapter {
    private List<WriteVoteItemData> mData;
    private TbPageContext mPageContext;
    private InterfaceC0909c ohr;
    private boolean ohq = false;
    TextView.OnEditorActionListener mOnEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.write.write.vote.c.1
        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            View focusSearch;
            if (i == 5 && (focusSearch = textView.focusSearch(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER)) != null) {
                focusSearch.requestFocus(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
                return true;
            }
            return true;
        }
    };

    /* renamed from: com.baidu.tieba.write.write.vote.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0909c {
        void Ng(int i);

        void a(WriteVoteItemData writeVoteItemData, int i);

        void ecI();
    }

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setData(List<WriteVoteItemData> list) {
        this.mData = list;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0909c interfaceC0909c) {
        this.ohr = interfaceC0909c;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new b(LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.view_vote_item, viewGroup, false));
        }
        return new a(LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.view_vote_add_item, viewGroup, false));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        if (viewHolder instanceof b) {
            b bVar = (b) viewHolder;
            String text = this.mData.get(i).getText();
            bVar.ohw.setHint(String.format(this.mPageContext.getString(R.string.write_vote_item), Integer.valueOf(i + 1)));
            bVar.ohw.setGravity(19);
            if (i < this.mData.size() - 1) {
                bVar.ohw.setImeOptions(5);
            } else {
                bVar.ohw.setImeOptions(1);
            }
            ImageView imageView = bVar.ohx;
            if (this.mData.size() > 2) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.vote.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.ohr != null) {
                        c.this.ohr.Ng(i);
                    }
                }
            });
            bVar.setPosition(i);
            if (!StringUtils.isNull(text)) {
                bVar.ohw.setText(text);
            } else {
                bVar.ohw.setText("");
            }
            if (this.ohq && i == this.mData.size() - 1) {
                bVar.ohw.requestFocus();
                this.ohq = false;
            }
        } else if (viewHolder instanceof a) {
            a aVar = (a) viewHolder;
            aVar.oht.setText(String.format(this.mPageContext.getString(R.string.write_add_vote_item), Integer.valueOf(20 - this.mData.size())));
            aVar.ohv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.vote.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.ohr != null) {
                        c.this.ohr.ecI();
                        c.this.ohq = true;
                    }
                }
            });
        }
        d(viewHolder);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return !Nh(i) ? 1 : 2;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.mData == null) {
            return 0;
        }
        if (this.mData.size() < 20) {
            return this.mData.size() + 1;
        }
        return 20;
    }

    public void d(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(this.mPageContext.getResources().getDimension(R.dimen.tbds10));
            gradientDrawable.setColor(ap.getColor(R.color.CAM_X0209));
            gradientDrawable.setStroke(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds1), ap.getColor(R.color.CAM_X0603));
            if (viewHolder instanceof b) {
                b bVar = (b) viewHolder;
                bVar.ohw.setTextColor(ap.getColor(R.color.CAM_X0105));
                bVar.ohw.setHintTextColor(ap.getColor(R.color.CAM_X0109));
                bVar.ohw.setBackgroundDrawable(gradientDrawable);
                SvgManager.btW().a(bVar.ohx, R.drawable.ic_icon_mask_select_delete24_svg, SvgManager.SvgResourceStateType.NORMAL);
            } else if (viewHolder instanceof a) {
                a aVar = (a) viewHolder;
                ap.setViewTextColor(aVar.oht, R.color.CAM_X0302);
                aVar.ohv.setBackgroundDrawable(gradientDrawable);
                SvgManager.btW().a(aVar.ohu, R.drawable.ic_icon_pure_post_addvote12_svg, R.color.CAM_X0302, SvgManager.SvgResourceStateType.NORMAL);
            }
        }
    }

    private boolean Nh(int i) {
        return this.mData != null && this.mData.size() < 20 && i == this.mData.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends RecyclerView.ViewHolder {
        public EditText ohw;
        public ImageView ohx;
        private d ohy;

        public b(View view) {
            super(view);
            this.ohw = (EditText) view.findViewById(R.id.vote_item);
            this.ohx = (ImageView) view.findViewById(R.id.img_delete);
            this.ohy = new d(this);
            this.ohw.setOnEditorActionListener(c.this.mOnEditorActionListener);
        }

        public void setPosition(int i) {
            this.ohy.setPosition(i);
            this.ohw.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.vote.c.b.1
                @Override // android.view.View.OnFocusChangeListener
                public void onFocusChange(View view, boolean z) {
                    if (z) {
                        b.this.ohw.addTextChangedListener(b.this.ohy);
                    } else {
                        b.this.ohw.removeTextChangedListener(b.this.ohy);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends RecyclerView.ViewHolder {
        public TextView oht;
        public ImageView ohu;
        public RelativeLayout ohv;

        public a(View view) {
            super(view);
            this.oht = (TextView) view.findViewById(R.id.vote_add_item);
            this.ohu = (ImageView) view.findViewById(R.id.vote_add_item_icon);
            this.ohv = (RelativeLayout) view.findViewById(R.id.vote_add_item_back);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d implements TextWatcher {
        private final b ohA;
        private int position;

        public d(b bVar) {
            this.ohA = bVar;
        }

        public void setPosition(int i) {
            this.position = i;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable != null) {
                String obj = editable.toString();
                if (StringUtils.isNull(obj)) {
                    obj = "";
                }
                WriteVoteItemData writeVoteItemData = new WriteVoteItemData();
                writeVoteItemData.setId(this.position + 1);
                if (ae.getTextLengthWithEmoji(obj) > 28) {
                    obj = ae.subStringWithEmoji(obj, 28);
                    this.ohA.ohw.setText(obj);
                    this.ohA.ohw.setSelection(obj.length());
                    c.this.mPageContext.showToast(String.format(c.this.mPageContext.getString(R.string.write_vote_toast), 14));
                }
                writeVoteItemData.setText(obj);
                c.this.ohr.a(writeVoteItemData, this.position);
            }
        }
    }
}
