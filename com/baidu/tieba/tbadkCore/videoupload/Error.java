package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class Error extends OrmObject implements Serializable {
    public static final long serialVersionUID = 2382642331836044912L;
    public String errmsg;
    public int errno;
    public String usermsg;
}
