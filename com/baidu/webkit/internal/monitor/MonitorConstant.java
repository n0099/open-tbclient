package com.baidu.webkit.internal.monitor;

import com.baidu.webkit.internal.INoProGuard;
/* loaded from: classes9.dex */
public class MonitorConstant implements INoProGuard {

    /* loaded from: classes9.dex */
    public enum KeySectionType implements INoProGuard {
        GET_VISITED_HISTORY,
        DO_UPDATE_VISITED_HISTORY,
        RESTORE_FROM_CACHE,
        PROGRESSCHANGED,
        SHOULD_INTERCEPT_REQUEST,
        SHOULD_OVERRIDE_URL_LOADING,
        SHOULD_SPECIAL_LOADING,
        PAGESTART,
        PAGEFINISH,
        PAGE_COMMIT_VISIBLE,
        FIRST_SCREEN_PAINT_COMMIT,
        RECEIVED_ERROR,
        RECEIVED_TITLE,
        HIT_MAGIC_FILTER,
        NEW_HISTORY_ITEM,
        DID_FIRST_LAYOUT,
        DID_FIRST_PAINT,
        FIRST_SCREEN_PAINT,
        DID_UNSAFE_PAGE_DETECTED,
        RESOURCE_REQUEST_COMPLETED,
        START_NAVIGATION,
        RESOURCE_HEADERS_RECEIVED,
        RESOURCE_BEFORE_REQUEST
    }
}
