package com.baidu.wallet.base.datamodel;

import com.baidu.wallet.core.NoProguard;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class TransferArriveInfo implements NoProguard, Serializable {
    public String arrive_explain;
    public TransferArriveType[] arrive_type;
    public String choose_explain;
    public String default_type_value;
    public String maintain_explain;

    /* loaded from: classes5.dex */
    public static class TransferArriveType implements NoProguard, Serializable {
        public String type_arrive_msg;
        public String type_arrive_msg_hl;
        public String type_name;
        public String type_value;
    }
}
