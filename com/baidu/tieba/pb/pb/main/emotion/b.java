package com.baidu.tieba.pb.pb.main.emotion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends BaseAdapter {
    private List<EmotionImageData> iSJ;
    private a mcY;
    private EmotionView.a mcZ;

    /* loaded from: classes2.dex */
    public interface a {
        void d(EmotionImageData emotionImageData);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.iSJ)) {
            return 0;
        }
        return this.iSJ.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.iSJ = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0838b c0838b;
        if (view == null) {
            C0838b c0838b2 = new C0838b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_sug_emotion, (ViewGroup) null);
            c0838b2.lCA = (EmotionView) view.findViewById(R.id.emotion_view);
            c0838b2.lCA.cyo();
            c0838b2.lCA.setController(this.mcZ);
            c0838b2.lCA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.mcY != null && (view2 instanceof EmotionView)) {
                        b.this.mcY.d(((EmotionView) view2).getData());
                    }
                }
            });
            view.setTag(c0838b2);
            c0838b = c0838b2;
        } else {
            c0838b = (C0838b) view.getTag();
        }
        if (this.iSJ != null && i >= 0 && i < this.iSJ.size()) {
            c0838b.lCA.a(this.iSJ.get(i));
        }
        return view;
    }

    public void a(a aVar) {
        this.mcY = aVar;
    }

    public void a(EmotionView.a aVar) {
        this.mcZ = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0838b {
        EmotionView lCA;

        C0838b() {
        }
    }
}
