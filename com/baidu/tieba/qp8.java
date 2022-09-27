package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.util.PriorityOrganizer;
/* loaded from: classes5.dex */
public interface qp8 {

    /* loaded from: classes5.dex */
    public interface a {

        /* renamed from: com.baidu.tieba.qp8$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public interface InterfaceC0398a {
            void a(@NonNull f45 f45Var);

            boolean b();
        }

        void a(@Nullable InterfaceC0398a interfaceC0398a);
    }

    @NonNull
    PriorityOrganizer d0();

    int getCurrentTabType();

    @NonNull
    a q0();
}
