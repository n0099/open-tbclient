package com.baidu.tieba.story;

import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bl;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class UserStoryData implements Serializable {
    public static final int TYPE_NONE = -1;
    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_OFFICIAL = 1;
    public static final int TYPE_OTHER_UID_AT = -2;
    public static final int TYPE_OTHER_UID_RE = -1;
    public MetaData storyUser;
    public int lastStoryFragIndex = 0;
    public boolean isTimeout = false;
    public boolean isLoadSucc = false;
    public int otherUid = 0;
    public int storyUserType = 0;
    public List<bl> storyList = new LinkedList();
}
