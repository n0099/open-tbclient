package com.baidu.tieba.write.video;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.editortools.editorinfotool.LocationInfoView;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
/* loaded from: classes5.dex */
public class WriteLocationView extends LocationInfoView {

    /* renamed from: h  reason: collision with root package name */
    public LocationModel f21976h;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteLocationView.this.f21976h.H(false);
                    WriteLocationView.this.f21976h.G(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteLocationView.this.e(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteLocationView.this.f21976h.H(true);
                WriteLocationView.this.e(0, true, null);
            }
        }
    }

    public WriteLocationView(Context context) {
        this(context, null);
    }

    public final void e(int i2, boolean z, String str) {
        setVisibility(z ? 0 : 8);
        setState(i2, str);
    }

    public WriteLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        new a(2001226);
    }
}
